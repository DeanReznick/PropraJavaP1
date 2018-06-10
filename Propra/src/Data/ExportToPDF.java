package Data;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.GregorianCalendar;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import GUI.MainMenu; 

public class ExportToPDF {

	
	//"ID_Rechnung", "Rechnungsname", "Auftraggeber", "Betrag", "Beschreibung", "Bearbeiter", "Timestamp"
    public static final String PDF = "/Users/timw9/Desktop/Rechnung.pdf";

    public static void createPdf(String filename, int idRechnung, String rechnungsname, int idAuftraggeber, int betrag, String beschreibung, int idBearbeiter, String timestamp) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream(filename));
        document.open();

        PdfContentByte cb = writer.getDirectContent();
        BaseFont bf = BaseFont.createFont();
        setImage(cb, "ELab_Logo.png", 40);
        cb.beginText();
        cb.setFontAndSize(bf, 12);
        cb.moveText(20, 105);
        cb.showText("Rechnung\n");
        cb.newlineShowText("Rechnung" + rechnungsname + "\n");
        cb.showText("Sehr geehrter Herr ... \n");
        cb.showText("Vielen Dank für Ihr Vertrauen in unsere Produkte. Wir hoffen Sie sind zufrieden und würden uns freuen wieder von Ihnen zu hören.\n");
        cb.showText("Betrag gesamt: \n");
        cb.showText("Mit freundlichen Grüßen\n");
        cb.showText("ELab");
        
        String[] colNames = {"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status", "Rolle"};
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status", "Rolle"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};	
		String id = Integer.toString(idRechnung);
		
		Statement stmtOrderBills = null;
		
			try {
				
				stmtOrderBills = DataBase.c.createStatement();
				System.out.println("Statement");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		String sqlOrdersBills = "SELECT Auftrag.* FROM Auftrag INNER JOIN 'Mischtabelle-Rechnung-Auftrag' on Auftrag.ID_Auftrag = 'Mischtabelle-Rechnung-Auftrag'.ID_Auftrag where 'Mischtabelle-Rechnung-Auftrag'.ID_Rechnung ="+id+";";
		
		ResultSet rsOrdersBills = null;
		
			try {
				rsOrdersBills = stmtOrderBills.executeQuery(sqlOrdersBills);
				System.out.println("Query executed");
				System.out.println(rsOrdersBills);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			try {
				while(rsOrdersBills.next())
				{
					String a1 = rsOrdersBills.getString("ID_Auftrag");
				    String b1 = rsOrdersBills.getString("Titel");
				    String c1 = rsOrdersBills.getString("AF");
				    String d1 = rsOrdersBills.getString("Dateiname");
				    String e1 = rsOrdersBills.getString("Dateiort");
				    String f1 = rsOrdersBills.getString("PK");
				    String g1 = rsOrdersBills.getString("RK");
				    String h1 = DataBase.getStatusBeiAuftragId(a1);
				    
				    String j1 = DataBase.getRolleByOrderId(a1);
				    //System.out.println(a1);
				   // System.out.println(j1);
				  
				    
				    model.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1, j1});
				    										    
//				    modelOrderBill.addRow(new Object[]{a1, b1,c1,f1,g1, h1});
				    
				    System.out.println("While done");
				    
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JTable table = new JTable(model);
	        table.setShowGrid(true);
	        table.setGridColor(Color.LIGHT_GRAY);
	        
	        PdfPTable tables = new PdfPTable(model.getColumnCount());
            tables.setWidthPercentage(100);
            tables.getDefaultCell().enableBorderSide(PdfPCell.BOX);
            // Titel
            DateFormat df = DateFormat.getDateTimeInstance(
                    DateFormat.SHORT, DateFormat.SHORT);
            Paragraph head = new Paragraph("Tabledemo - "
                    + df.format(new GregorianCalendar().getTime()),
                    new Font(FontFamily.HELVETICA, 14, Font.BOLD));
            head.setSpacingAfter(15f);

            // Spaltentitel
            for (int i = 0; i < colNames.length; i++) {
                PdfPCell cell = new PdfPCell(new Phrase(colNames[i], new Font(
                        FontFamily.HELVETICA, 10)));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tables.addCell(cell);
            }
            // Tabelleninhalt
            for (int clmCnt = model.getColumnCount(), rowCnt = model
                    .getRowCount(), i = 0; i < rowCnt; i++) {
                for (int j = 0; j < clmCnt; j++) {
                    String value = model.getValueAt(i, j).toString();
                    tables.addCell(new Phrase(value, new Font(
                            FontFamily.HELVETICA, 10)));
                }
            } 
            
            document.add(tables);
            
        
        cb.moveText(120, -16);
        cb.setCharacterSpacing(2);
        cb.setWordSpacing(12);
        cb.newlineShowText("Erst recht auch jeden kleineren.");
        cb.endText();

        document.close();

    }

    private static void setImage(PdfContentByte cb, String imgPath, float scalePercent)
            throws MalformedURLException, IOException, DocumentException {
        Image img = Image.getInstance(imgPath);
        img.scalePercent(scalePercent);
        img.setAbsolutePosition(cb.getXTLM(), cb.getYTLM());
        cb.addImage(img);
    }

    private void printMeasures(){
        System.out.println("A4-Ma\u00DFe: " + PageSize.A4.getWidth() + "pt x "
                + PageSize.A4.getHeight() + "pt - "
                + (PageSize.A4.getWidth() * 0.3527) + "mm x "
                + (PageSize.A4.getHeight() * 0.3527) + "mm");
    }

//    public static void main(String[] args) throws DocumentException,
//            IOException {
//        ExportToPDF ps = new ExportToPDF();
//        ps.createPdf(PDF);
//        ps.printMeasures();
//        System.out.println("done");
//    }
} 