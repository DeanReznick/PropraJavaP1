package Data;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfIndirectObject;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePdf {

	public static final String DEST = "/Users/timw9/Desktop/Rechnung8.pdf";
	public static final String PDF = "HelloWorld.pdf";
	
	public static void main (String[] args) throws SQLException {
		DataBase.getConnection();
		DefaultTableModel modelRechnung = DataBase.loadToARechnungObjektRAM(7); 
		DefaultTableModel modelAuftrag = DataBase.loadToAuftragObjektRAM(77);
	
		DataBase.closeConnection();
		
		System.out.println(System.getProperty("user.dir"));
		CreatePdf ps = new CreatePdf();
      ps.createPdf(PDF, modelRechnung, modelAuftrag);
	}
	
	public void createPdf(String filename, DefaultTableModel model, DefaultTableModel modelAuftrag) {
	Document document = new Document(PageSize.A4);
    try{
        PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
        document.open();
        Paragraph p1 = new Paragraph("Rechnung", FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD,BaseColor.BLACK));
        Paragraph leerzeile = new Paragraph("\n");
        Paragraph p2 = new Paragraph("vielen Dank für Ihr Vertrauen in unsere Produkte. Wir hoffen Sie sind zufrieden und würden uns \r\n" + 
        		"freuen wieder von ihnen zu hören.");
			document.add(p1);
			document.add(leerzeile);
        document.add(p2);
        document.add(leerzeile);
        
        String[] colNamesRechnung = {"Name","Art der Bezahlung", "Betrag", "Beschreibung", "Timestamp", "Typ"};
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
            for (int i = 0; i < colNamesRechnung.length; i++) {
                PdfPCell cell = new PdfPCell(new Phrase(colNamesRechnung[i], new Font(
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
            document.add(leerzeile);
            
            String[] colNamesAuftrag = {"Titel","Art der Fertigung"};
			JTable tableAuftrag = new JTable(modelAuftrag);
			tableAuftrag.setShowGrid(true);
			tableAuftrag.setGridColor(Color.LIGHT_GRAY);
	        
	        PdfPTable tablesAuftrag = new PdfPTable(modelAuftrag.getColumnCount());
	        tablesAuftrag.setWidthPercentage(100);
	        tablesAuftrag.getDefaultCell().enableBorderSide(PdfPCell.BOX);
            // Titel
            DateFormat dfAuftrag = DateFormat.getDateTimeInstance(
                    DateFormat.SHORT, DateFormat.SHORT);
            Paragraph headAuftrag = new Paragraph("Tabledemo - "
                    + dfAuftrag.format(new GregorianCalendar().getTime()),
                    new Font(FontFamily.HELVETICA, 14, Font.BOLD));
            headAuftrag.setSpacingAfter(15f);

            // Spaltentitel
            for (int i = 0; i < colNamesAuftrag.length; i++) {
                PdfPCell cell = new PdfPCell(new Phrase(colNamesAuftrag[i], new Font(
                        FontFamily.HELVETICA, 10)));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tablesAuftrag.addCell(cell);
            }
            // Tabelleninhalt
            for (int clmCnt = modelAuftrag.getColumnCount(), rowCnt = modelAuftrag
                    .getRowCount(), i = 0; i < rowCnt; i++) {
                for (int j = 0; j < clmCnt; j++) {
                    String value = modelAuftrag.getValueAt(i, j).toString();
                    tablesAuftrag.addCell(new Phrase(value, new Font(
                            FontFamily.HELVETICA, 10)));
                }
            } 
            
            
            
          
            
            
            
            document.add(tablesAuftrag);
            
            document.add(leerzeile); 
            
            
     
    			document.add( new Paragraph("Dies ist eine automatisch generierte Rechnung. Bei Fragen wenden Sie sich bitte an: "));
    			
    			document.add(leerzeile);
    			
    			document.add( new Paragraph("FakeStreet 123, 57076 Siegen "));
            
            
    
        
//        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
//        Image image = Image.getInstance("ELab_Logo.png");
//        PdfImage stream = new PdfImage(image, "", null);
//        stream.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
//        image.setAbsolutePosition(36, 400);
//        PdfContentByte over = stamper.getOverContent(1);
//        over.addImage(image);
//        stamper.close();
        
    }
    catch(Exception e){
        System.out.println(e);
    }
    document.close();
}
	
	private static void setImage(PdfContentByte cb, String imgPath, float scalePercent)
            throws MalformedURLException, IOException, DocumentException {
        Image img = Image.getInstance(imgPath);
        img.scalePercent(scalePercent);
        img.setAbsolutePosition(cb.getXTLM(), cb.getYTLM());
        cb.addImage(img);
    }
}
