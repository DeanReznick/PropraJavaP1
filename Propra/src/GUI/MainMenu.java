package GUI;
//Test
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Data.Authentication;
import Data.BauteileAuftragsabwicklung;
import Data.DataBase;
import Data.ExportToPDF;
import Data.Finanzverwaltung;
import Data.OffenerAuftragObjektRAM;
import Data.PersonObjektRAM;
import Data.PersonenFertigungsverwaltung;
import Data.StatusObjektRAM;

import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.itextpdf.text.DocumentException;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Label;
import java.awt.Font;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	public static JTextField txtSuchen;
	private JTable table;
	public static JTable tblPersonen;
	public static JTable tblAuftraege;
	public static JScrollPane scrollPane;
	private JTextField txtSearchOrder;
	public static JScrollPane scrollPane_1;
	public static JTable tblOffeneAuftraege;
	public static JTable tblComponents;
	private JTextField txtSearchComponent;
	public static JScrollPane scrollPane_3;
	public static JTable tblCategory;
	private JButton btnSuchen;
	private JButton btnSearchOrder;
	private JButton btnSearchComponent;
	public static JTable tblKasse;
	public static JTable tblTopf;
	public static JTable tblRechn;
	private JTextField txtSearchBill;
	public static JTable tblAuftraegeRechnung;
	public static JTable tblOrdersInBill;
	public static JTable tblBills;
	public static JScrollPane scrollPane_Kasse;
	public static JScrollPane scrollPane_Topf;
	public static JScrollPane scrollPane_Rechnung;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainMenu frame = new MainMenu();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		
//		// Get all status by ID_Person
//	    
//	    for (StatusObjektRAM s: DataBase.status_list) {
//	      System.out.println(s.toString());
//	    }
//	    
//	    
//	    
//	    // Load specific status by ID_Status
//	    
//	    DataBase.loadSpecificStatusToRam(13);
//	    
//	    for (StatusObjektRAM s: DataBase.status_list) {
//	      System.out.println(s.toString());
//	    }
//	    
//	    // People 2 RAM object 
//	    
//	    DataBase.loadPeopleToRAM();
//	    
//	    
//	    for (PersonObjektRAM p : DataBase.people) {
//	      System.out.println(p.toString());
//	    }
//	    
//	    
//	    
//	    
//	  }

	/**
	 * Create the frame.
	 */
	


	public MainMenu() throws SQLException {
		setTitle("Projekt 1");
		setResizable(false);
		
		DataBase.getConnection(); // Muss immer am Anfang ausgeführt werden!
//	    PersonenFertigungsverwaltung.createNewPerson("Kern", "Dean-Robin", "0271/312", "test@ttest.de", "Deutschland", "HB", "Siegen", "10", 57076, "Member", "Geheim123"); 
//	    //PersonenFertigungsverwaltung.deletePerson("Kern", "Dean-Robin"); 
//	    PersonenFertigungsverwaltung.changeNameSurname("Kern", "Dean", "Hans", "Müller"); 
//	    PersonenFertigungsverwaltung.changeMail("Kern", "Dean-Robin", "dean-kern@t-online.de"); 
//	    PersonenFertigungsverwaltung.changePhoneNumber("Kern", "Dean-Robin", "0271/3178279"); 
//	    PersonenFertigungsverwaltung.changeAddressDataSet("Kern", "Dean-Robin", "Deutschland", "Hermann-Böttger Weg", "Siegen", "10", 57076);
//	    
//	    
//	    
//	    PersonenFertigungsverwaltung.createNewOrder("Fertigung B", "Standard", "job 33", "C://vbm", "144,-€","65€", "Kern", "Dean-Robin", "Owner");
//	    PersonenFertigungsverwaltung.changeDataSetOrder(12, "Fertigung A","Spezial", "job 123", "C://Projekt_a/bcd", "100,-€","62€");
//	    PersonenFertigungsverwaltung.changeJobOrderPerson(DataBase.getIdPersonByNameSurname("Kern", "Dean-Robin"), 6, "SMAL BOSS");
//	    PersonenFertigungsverwaltung.deleteOrder(11);
//	    PersonenFertigungsverwaltung.alterStatus(21, "In Bearbeitung. ");
//	    PersonenFertigungsverwaltung.deleteOrder(20);
//	    
//	    
//	    //Password-stuff
//	    System.out.println("Password function test: " + Authentication.checkCredentials("Kern", "Dean-Robin", "Geheim123")); 
//	    System.out.println("Password function test: " + Authentication.checkCredentials("Kern", "Dean-Robin", "Geddd")); 
//	    
//	    
//	    
//	    // Get all status by ID_Person
//	    DataBase.loadStatusToRam(21);
//	    
//	    for (StatusObjektRAM s: DataBase.status_list) {
//	      System.out.println(s.toString());
//	    }
//	    
//	    
//	    
//	    // Load specific status by ID_Status
//	    
//	    DataBase.loadSpecificStatusToRam(13);
//	    
//	    for (StatusObjektRAM s: DataBase.status_list) {
//	      System.out.println(s.toString());
//	    }
//	    
//	    // People 2 RAM object 
//	    
//	    DataBase.loadPeopleToRAM();
//	    
//	    
//	    for (PersonObjektRAM p : DataBase.people) {
//	      System.out.println(p.toString());
//	    }

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 964, 439);
		contentPane.add(tabbedPane);
		
		JPanel panelPerson = new JPanel();
		tabbedPane.addTab("Pers. & Fertigung", null, panelPerson, null);
		panelPerson.setLayout(null);
		
		JButton btnHinzufuegen = new JButton("Hinzufuegen");
		btnHinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddPerson x = new AddPerson();
				x.setVisible(true);
			}
		});
		btnHinzufuegen.setBounds(10, 207, 116, 23);
		panelPerson.add(btnHinzufuegen);
		
		JButton btnLoeschen = new JButton("Loeschen");
		
		btnLoeschen.setBounds(152, 207, 116, 23);
		panelPerson.add(btnLoeschen);
		
		txtSuchen = new JTextField();
		txtSuchen.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				SwingUtilities.getRootPane(btnSuchen).setDefaultButton(btnSuchen);
			}
		});
		txtSuchen.setToolTipText("Suchen...");
		txtSuchen.setBounds(549, 1, 189, 20);
		panelPerson.add(txtSuchen);
		txtSuchen.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Personen:");
		lblNewLabel.setBounds(10, 11, 71, 14);
		panelPerson.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 939, 172);
		panelPerson.add(scrollPane);
		
		
		Connection con = null;
				
		String[] column_headers = {"ID", "Name", "Vorname", "Telefon", "Email", "Adresse_ID", "Rolle"};
		String[][] data = new String[1000][11];
				
		tblPersonen = new JTable(data, column_headers);
		tblPersonen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DataBase.getConnection();
				int colnr  = MainMenu.tblPersonen.getSelectedRow();
				
				String personName = MainMenu.tblPersonen.getModel().getValueAt(colnr, 1).toString();
				String personVorname = MainMenu.tblPersonen.getModel().getValueAt(colnr, 2).toString();
				String fullName = personVorname + " " + personName;
				
				txtSearchOrder.setText(fullName);
				DataBase.searchOrder(fullName);
				DataBase.closeConnection();
			}
		});
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Vorname", "Telefon", "Email", "Rolle",  "Straße", "Hausnummer", "PLZ", "Ort", "Land"}, 0) {
		
		@Override
		public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		Statement stmt = DataBase.c.createStatement();

		String sql = "SELECT * FROM Person";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			String a = rs.getString("ID_Person");
		    String b = rs.getString("Name");
		    String c = rs.getString("Vorname");
		    String d = rs.getString("Telefonnummer");
		    String e = rs.getString("Mail");
		    String f = rs.getString("Rolle");
		    String g = rs.getString("Straße");
		    String h = rs.getString("Hausnummer");
		    String i = rs.getString("PLZ");
		    String j = rs.getString("Ort");
		    String k = rs.getString("Land");
		    
		    model.addRow(new Object[]{a, b,c,d,e,f,g, h, i, j, k});
		}
		
		tblPersonen.setModel(model);
				
		scrollPane.setViewportView(tblPersonen);
				
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 260, 939, 117);
		panelPerson.add(scrollPane_1);
			
		String[] column_headers_auftraege = {"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "Status", "Rolle"};
		String[][] data_auftraege = new String[1000][11];
		tblAuftraege = new JTable(data_auftraege, column_headers_auftraege);
		DefaultTableModel modelAuftrag = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "Status", "Rolle"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		String sqlAuftrag = "SELECT * FROM Auftrag";
		ResultSet rsAuftrag = stmt.executeQuery(sqlAuftrag);
		
		//String r = null;
		//String sqlRolle = "SELECT Rolle FROM Mischtabelle-Person-Auftrag WHERE ID_Auftrag =" + r + ";";
		
		
		while(rsAuftrag.next())
		{
			String a1 = rsAuftrag.getString("ID_Auftrag");
		    String b1 = rsAuftrag.getString("Titel");
		    String c1 = rsAuftrag.getString("AF");
		    String d1 = rsAuftrag.getString("Dateiname");
		    String e1 = rsAuftrag.getString("Dateiort");
		    String f1 = rsAuftrag.getString("PK");
		    String g1 = rsAuftrag.getString("RK");
		    String h1 = DataBase.getStatusBeiAuftragId(a1);
		    
		    String j1 = DataBase.getRolleByOrderId(a1);
		    //System.out.println(a1);
		   // System.out.println(j1);
		  
		    
		    modelAuftrag.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1, j1});
		}
		
		tblAuftraege.setModel(modelAuftrag);
				
		
		scrollPane_1.setViewportView(tblAuftraege);
		
		JLabel lblAuftraege = new JLabel("Auftraege:");
		lblAuftraege.setBounds(10, 241, 71, 14);
		panelPerson.add(lblAuftraege);
		
		btnSuchen = new JButton("Suchen");
		btnSuchen.setBounds(423, 0, 116, 23);
		panelPerson.add(btnSuchen);
		
		btnSearchOrder = new JButton("Suchen");
		btnSearchOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBase.searchOrder(txtSearchOrder.getText());
			}
		});
		btnSearchOrder.setBounds(649, 388, 89, 23);
		panelPerson.add(btnSearchOrder);
		
		JButton btnChangePerson = new JButton("Aendern");
		btnChangePerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Aendern x = new Aendern();
				x.setVisible(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
				}
			}
		});
		btnChangePerson.setBounds(294, 207, 131, 23);
		panelPerson.add(btnChangePerson);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					DataBase.refreshDatabase();				
			}
		});
		
		btnRefresh.setBounds(246, 0, 89, 23);
		panelPerson.add(btnRefresh);
		
		JButton btnErstellen = new JButton("Erstellen");
		btnErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NewOrder x = new NewOrder();
				x.setVisible(true);
			}
		});
		btnErstellen.setBounds(10, 388, 89, 23);
		panelPerson.add(btnErstellen);
		
		JButton btnChangeOrder = new JButton("Aendern");
		btnChangeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					UpdateOrder x = new UpdateOrder();
					x.setVisible(true);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Person aus.");
					}
				
			}
		});
		btnChangeOrder.setBounds(109, 388, 89, 23);
		panelPerson.add(btnChangeOrder);
		
		JButton btnDeleteOrder = new JButton("Auftrag Loeschen");
		btnDeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tblAuftraege.getModel();
				//get selected row index
				int selectedRowIndex = tblAuftraege.getSelectedRow();
				if (selectedRowIndex >= 0) {
				try {
				DeleteOrder x = new DeleteOrder();
				x.setVisible(true);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
			}
			}
		});
		btnDeleteOrder.setBounds(208, 388, 127, 23);
		panelPerson.add(btnDeleteOrder);
		
		txtSearchOrder = new JTextField();
		txtSearchOrder.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				SwingUtilities.getRootPane(btnSearchOrder).setDefaultButton(btnSearchOrder);
			}
		});
		txtSearchOrder.setBounds(744, 389, 205, 20);
		panelPerson.add(txtSearchOrder);
		txtSearchOrder.setColumns(10);
		
		JButton btnNewButton = new JButton("Status aendern");
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
				int colnr  = tblAuftraege.getSelectedRow();

				Object id_order  =  tblAuftraege.getModel().getValueAt(colnr, 0);
				
				Integer id = Integer.valueOf(id_order.toString()); 
				
				
				AlterStatus x = new AlterStatus(id.intValue()); // -id Order 
				x.setVisible(true);  
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
				}
			}
		});
		btnNewButton.setBounds(345, 388, 108, 23);
		panelPerson.add(btnNewButton);
		
		btnLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) tblPersonen.getModel();
				//get selected row index
				int selectedRowIndex = tblPersonen.getSelectedRow();
				if (selectedRowIndex >= 0) {
				try {
				Delete x = new Delete();
				x.setVisible(true);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
			}
				
			}
		});
		
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				DataBase.searchTable(txtSuchen.getText());
				DataBase.searchPerson(txtSuchen.getText());
			}
		});
		
		JPanel panelOrders = new JPanel();
		tabbedPane.addTab("Offene Auftraege", null, panelOrders, null);
		panelOrders.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 56, 939, 344);
		panelOrders.add(scrollPane_2);
		
		String[] column_headers_orders = {"ID Änderung", "ID Bauteil","ID Person", "Vorname", "Name", "Timestamp", "Aenderung"};
		String[][] data_orders = new String[1000][7];
		tblOffeneAuftraege = new JTable(data_orders, column_headers_orders);
		tblOffeneAuftraege.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
				OrderApprove x = new OrderApprove(); // -id Order 
				x.setVisible(true);  
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
				}	
			}
		});
		DefaultTableModel modelOffeneAuftraege = new DefaultTableModel(new String[]{"ID Änderung", "ID Bauteil","ID Person", "Vorname", "Name", "Timestamp", "Aenderung"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};	
			
			DataBase.loadOffeneAuftraegeToRam();
			
			
			for(OffenerAuftragObjektRAM tmp: DataBase.offeneAuftraege) {
				
			int id_aenderung = tmp.getid_aenderung();
			int id_bauteil = tmp.getId_bauteil();
			int id_person = tmp.getId_person();
			String vorname = tmp.getVorname();
			String name = tmp.getName();
			String timestamp = tmp.getTimestamp();
			int aenderung = tmp.getAenderung();
			
			
			 modelOffeneAuftraege.addRow(new Object[]{id_aenderung, id_bauteil, id_person, vorname, name, timestamp, aenderung});
			
			
			
	
			}
			
			tblOffeneAuftraege.setModel(modelOffeneAuftraege);
		
		
		scrollPane_2.setViewportView(tblOffeneAuftraege);
		//contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelPerson, btnHinzufuegen, btnLoeschen, txtSuchen, tabbedPane, lblNewLabel, scrollPane, tblPersonen, scrollPane_1, tblAuftraege, lblAuftraege, btnSuchen, btnSearchOrder, btnChangePerson, btnRefresh, btnErstellen, btnChangeOrder, btnDeleteOrder, txtSearchOrder, btnNewButton, panelFinanz, panelBau, panelOrders}));
		
		JPanel panelFinanz = new JPanel();
		tabbedPane.addTab("Finanzverwaltung", null, panelFinanz, null);
		panelFinanz.setLayout(null);		
		
		scrollPane_Kasse = new JScrollPane();
		scrollPane_Kasse.setBounds(10, 61, 134, 180);
		panelFinanz.add(scrollPane_Kasse);
			
		
		String[] column_headers_kasse = {"ID_Kasse", "Art", "Nummer", "Soll", "Ist"};
		String[][] data_kasse = new String[1000][11];
		tblKasse = new JTable(data_kasse, column_headers_kasse);
		DefaultTableModel modelKasse = new DefaultTableModel(new String[]{"ID_Kasse", "Art", "Nummer", "Soll", "Ist"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		String sqlKasse = "SELECT * FROM Kasse";
		ResultSet rsKasse = stmt.executeQuery(sqlKasse);
		
		while(rsKasse.next())
		{
			String a1 = rsKasse.getString("ID_Kasse");
		    String b1 = rsKasse.getString("Art");
		    String c1 = rsKasse.getString("Nummer");
		    String d1 = rsKasse.getString("Soll");
		    String e1 = rsKasse.getString("Ist");
		    
		    modelKasse.addRow(new Object[]{a1, b1,c1,d1,e1});
		}
		
		tblKasse.setModel(modelKasse);
				
		scrollPane_Kasse.setViewportView(tblKasse);
		
		JLabel lblKassen = new JLabel("Kasse:");
		lblKassen.setBounds(10, 36, 46, 14);
		panelFinanz.add(lblKassen);
		
		scrollPane_Topf = new JScrollPane();
		scrollPane_Topf.setBounds(154, 61, 282, 180);
		panelFinanz.add(scrollPane_Topf);
			
		
		String[] column_headers_topf = {"ID_Topf", "ID_Kasse", "Soll", "Ist"};
		String[][] data_topf = new String[1000][11];
		tblTopf = new JTable(data_topf, column_headers_topf);
		DefaultTableModel modelTopf = new DefaultTableModel(new String[]{"ID_Topf", "ID_Kasse", "Soll", "Ist"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		String sqlTopf = "SELECT Topf.*, 'Mischtabelle-Kasse-Topf'.ID_Kasse FROM Topf LEFT JOIN 'Mischtabelle-Kasse-Topf' ON Topf.ID_Topf = 'Mischtabelle-Kasse-Topf'.ID_Topf;";
		ResultSet rsTopf = stmt.executeQuery(sqlTopf);
		
		while(rsTopf.next())
		{
			String a1 = rsTopf.getString("ID_Topf");
		    String b1 = rsTopf.getString("ID_Kasse");
		    String c1 = rsTopf.getString("Soll");
		    String d1 = rsTopf.getString("Ist");
		    
		    modelTopf.addRow(new Object[]{a1,b1,c1,d1});
		}
		
		tblTopf.setModel(modelTopf);
				
		scrollPane_Topf.setViewportView(tblTopf);
		
		
		JLabel lblTopf = new JLabel("Topf:");
		lblTopf.setBounds(220, 36, 46, 14);
		panelFinanz.add(lblTopf);
		
		scrollPane_Rechnung = new JScrollPane();
		scrollPane_Rechnung.setBounds(446, 61, 489, 180);
		panelFinanz.add(scrollPane_Rechnung);
			
		
		String[] column_headers_rechnung = {"ID_Rechnung", "Rechnungsname", "Auftraggeber", "Betrag", "Beschreibung", "Bearbeiter", "Timestamp"};
		String[][] data_rechnung = new String[1000][11];
		tblRechn = new JTable(data_rechnung, column_headers_topf);
		DefaultTableModel modelRechnung = new DefaultTableModel(new String[]{"ID_Rechnung", "Rechnungsname", "Auftraggeber", "Betrag", "Beschreibung", "Bearbeiter", "Timestamp"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		String sqlRechnung = "SELECT * FROM Rechnung";
		ResultSet rsRechnung = stmt.executeQuery(sqlRechnung);
		
		while(rsRechnung.next())
		{
			String a1 = rsRechnung.getString("ID_Rechnung");
		    String b1 = rsRechnung.getString("Rechnungsname");
		    String c1 = rsRechnung.getString("Auftraggeber");
//		    String d1 = rsRechnung.getString("Bezahlung_Art");
		    String e1 = rsRechnung.getString("Betrag");
		    String f1 = rsRechnung.getString("Beschreibung");
		    String g1 = rsRechnung.getString("Bearbeiter");
		    String h1 = rsRechnung.getString("Timestamp");
		    
		    modelRechnung.addRow(new Object[]{a1, b1,c1, e1, f1, g1, h1});
		}
		
		tblRechn.setModel(modelRechnung);
				
		scrollPane_Rechnung.setViewportView(tblRechn);
		
		
		JLabel lblRechnung = new JLabel("Rechnung:");
		lblRechnung.setBounds(446, 36, 83, 14);
		panelFinanz.add(lblRechnung);
		
		JButton btnNeueKasse = new JButton("Neue Kasse");
		btnNeueKasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddKasse x = new AddKasse();
				x.setVisible(true);
			}
		});
		btnNeueKasse.setBounds(10, 252, 134, 23);
		panelFinanz.add(btnNeueKasse);
		
		JButton btnAendern_2 = new JButton("Aendern");
		btnAendern_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				AlterKasse x = new AlterKasse();
				x.setVisible(true);
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Kasse aus!");
				}
			}
		});
		btnAendern_2.setBounds(10, 286, 134, 23);
		panelFinanz.add(btnAendern_2);
		
		JButton btnKasseLoeschen = new JButton("Kasse Loeschen");
		btnKasseLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) tblKasse.getModel();
				//get selected row index
				int selectedRowIndex = tblKasse.getSelectedRow();
				try {
				DeleteKasse x = new DeleteKasse();
				x.setVisible(true);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Kasse aus.");
				}
			}
		});
		btnKasseLoeschen.setBounds(10, 320, 134, 23);
		panelFinanz.add(btnKasseLoeschen);
		
		JButton btnTopfErstellen = new JButton("Topf erstellen");
		btnTopfErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddTopf x = new AddTopf();
				x.setVisible(true);
			}
		});
		btnTopfErstellen.setBounds(220, 252, 134, 23);
		panelFinanz.add(btnTopfErstellen);
		
		JButton btnTopfaendern = new JButton("Topf Aendern");
		btnTopfaendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AlterTopf x = new AlterTopf();
					x.setVisible(true);
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Topf aus.");
				}
			}
		});
		btnTopfaendern.setBounds(220, 286, 134, 23);
		panelFinanz.add(btnTopfaendern);
		
		JButton btnTopfLoeschen = new JButton("Topf Loeschen");
		btnTopfLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DeleteTopf x = new DeleteTopf();
					x.setVisible(true);
				}catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Topf aus.");
				}
			}
		});
		btnTopfLoeschen.setBounds(220, 320, 134, 23);
		panelFinanz.add(btnTopfLoeschen);
		
		JButton btnRechnungZuTopf = new JButton("Rechnung einem Topf hinzuf\u00FCgen");
		btnRechnungZuTopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int colnrTopf = MainMenu.tblTopf.getSelectedRow();
				int colnrRechnung = MainMenu.tblRechn.getSelectedRow();
				String idTopf = MainMenu.tblTopf.getModel().getValueAt(colnrTopf, 0).toString();
				String idRechnung = MainMenu.tblRechn.getModel().getValueAt(colnrRechnung, 0).toString();
				
				Finanzverwaltung.addBillToTopf(Integer.parseInt(idRechnung), Integer.parseInt(idTopf));
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Topf und eine Rechnung aus!");
				}
			}
		});
		btnRechnungZuTopf.setBounds(446, 252, 250, 23);
		panelFinanz.add(btnRechnungZuTopf);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(0, 0, 89, 23);
		panelFinanz.add(btnNewButton_1);
		
		JButton btnDeleteRechnungFromTopf = new JButton("Rechnung von Topf entfernen");
		btnDeleteRechnungFromTopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int colnrRechnung = MainMenu.tblRechn.getSelectedRow();
					String idRechnung = MainMenu.tblRechn.getModel().getValueAt(colnrRechnung, 0).toString();
					
					Finanzverwaltung.deleteBillFromTopf(Integer.parseInt(idRechnung));
					} catch (ArrayIndexOutOfBoundsException ex) {
						JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Topf und eine Rechnung aus!");
					}
			}
		});
		btnDeleteRechnungFromTopf.setBounds(446, 286, 250, 23);
		panelFinanz.add(btnDeleteRechnungFromTopf);
		
		JButton btnSuchen_1 = new JButton("Suchen");
		btnSuchen_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBase.searchBill(txtSearchBill.getText());
			}
		});
		btnSuchen_1.setBounds(685, 32, 89, 23);
		panelFinanz.add(btnSuchen_1);
		
		txtSearchBill = new JTextField();
		txtSearchBill.setBounds(784, 33, 151, 20);
		panelFinanz.add(txtSearchBill);
		txtSearchBill.setColumns(10);
		
		JButton btnExportPDF = new JButton("Rechnung als PDF exportieren");
		btnExportPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataBase.getConnection();
				try {
				//"ID_Rechnung", "Rechnungsname", "Auftraggeber", "Betrag", "Beschreibung", "Bearbeiter", "Timestamp"
				int colnrRechnung = MainMenu.tblRechn.getSelectedRow();
				int idRechnung = Integer.parseInt(MainMenu.tblRechn.getModel().getValueAt(colnrRechnung, 0).toString());
				String rechnungsname = MainMenu.tblRechn.getModel().getValueAt(colnrRechnung, 1).toString();
				int idAuftraggeber = Integer.parseInt(MainMenu.tblRechn.getModel().getValueAt(colnrRechnung, 2).toString());
				int betrag = Integer.parseInt(MainMenu.tblRechn.getModel().getValueAt(colnrRechnung, 3).toString());
				String beschreibung = MainMenu.tblRechn.getModel().getValueAt(colnrRechnung, 4).toString();
				int idBearbeiter = Integer.parseInt(MainMenu.tblRechn.getModel().getValueAt(colnrRechnung, 5).toString());
				String timestamp = MainMenu.tblRechn.getModel().getValueAt(colnrRechnung, 6).toString();
				String[] parts = timestamp.split("_");
				String day = parts[0];
				String time = parts[1];
				
				if (System.getProperty("os.name").toLowerCase().indexOf("win")<0) {
		            System.err.println("Sorry, Windows only!");
		            System.exit(1);
		        }
		        File desktopDir = new File(System.getProperty("user.home"), "Desktop");
		        System.out.println(desktopDir.getPath() + " " + desktopDir.exists());
				
		        File theDir = new File(desktopDir.getPath() + "/Rechnungen/");

		        // if the directory does not exist, create it
		        if (!theDir.exists()) {
		         System.out.println("creating directory: " + theDir.getName());
		         boolean result = false;

		         try{
		             theDir.mkdir();
		             result = true;
		         } 
		         catch(SecurityException se){
		             //handle it
		         }        
		         if(result) {    
		             System.out.println("DIR created");  
		         }
		     	}
		        
				String filename = desktopDir.getPath() + "/Rechnungen/Rechnung_" + rechnungsname + "_" + day + ".pdf";
				try {
				    Desktop.getDesktop().open(new File(desktopDir.getPath() + "/Rechnungen/"));
				} catch (IOException e) {
				    e.printStackTrace();
				}
				
				ExportToPDF.createPdf(filename, idRechnung, rechnungsname, idAuftraggeber, betrag, beschreibung, idBearbeiter, timestamp);
				
				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Rechnung aus!");
				} catch (DocumentException ex) {
					JOptionPane.showMessageDialog(null, ex);
				} catch (IOException exception) {
					JOptionPane.showMessageDialog(null, exception);
				}
				DataBase.closeConnection();
			}
		});
		btnExportPDF.setBounds(446, 320, 250, 23);
		panelFinanz.add(btnExportPDF);
		
		JPanel panelRechnung = new JPanel();
		tabbedPane.addTab("Rechnung", null, panelRechnung, null);
		panelRechnung.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 42, 411, 304);
		panelRechnung.add(scrollPane_5);
		
		
	
	
		
		String[] headers_auftraegeR = {"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status", "Rolle"};
		String[][] auftraegeR = new String[1000][11];
		tblAuftraegeRechnung = new JTable(auftraegeR,headers_auftraegeR);
		scrollPane_5.setViewportView(tblAuftraegeRechnung);
		
		
		DefaultTableModel modelAuftragR = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status", "Rolle"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		String sqlAuftragR = "SELECT * FROM Auftrag WHERE ID_Rechnung is null;";
		ResultSet rsAuftragR = stmt.executeQuery(sqlAuftragR);
		
		//String r = null;
		//String sqlRolle = "SELECT Rolle FROM Mischtabelle-Person-Auftrag WHERE ID_Auftrag =" + r + ";";
		
		
		while(rsAuftragR.next())
		{
			String a1 = rsAuftragR.getString("ID_Auftrag");
		    String b1 = rsAuftragR.getString("Titel");
		    String c1 = rsAuftragR.getString("AF");
		    String d1 = rsAuftragR.getString("Dateiname");
		    String e1 = rsAuftragR.getString("Dateiort");
		    String f1 = rsAuftragR.getString("PK");
		    String g1 = rsAuftragR.getString("RK");
		    String h1 = DataBase.getStatusBeiAuftragId(a1);
		    
		    String j1 = DataBase.getRolleByOrderId(a1);
		    //System.out.println(a1);
		   // System.out.println(j1);
		  
		    
		    modelAuftragR.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1, j1});
		}
		
		tblAuftraegeRechnung.setModel(modelAuftragR);
		
		JButton btnAddToBill = new JButton("Add to bill");
		btnAddToBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRowIndexBills = MainMenu.tblBills.getSelectedRow();
				int selectedRowIndexOrders = MainMenu.tblAuftraegeRechnung.getSelectedRow();
		
				int id_Bill = Integer.parseInt(MainMenu.tblBills.getModel().getValueAt(selectedRowIndexBills, 0).toString());
				int id_Order =Integer.parseInt( MainMenu.tblAuftraegeRechnung.getModel().getValueAt(selectedRowIndexOrders, 0).toString());
				
				
				Finanzverwaltung.addOrderToBill(id_Order, id_Bill);
				DataBase.refreshOrderBill();
			}
		});
		btnAddToBill.setBounds(10, 363, 178, 23);
		panelRechnung.add(btnAddToBill);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(494, 234, 455, 111);
		panelRechnung.add(scrollPane_6);
		
		
		
		String[] headersOrdersInBills = {"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status", "Rolle"};
		String[][] dataOrdersInBills = new String[1000][11];
		tblOrdersInBill = new JTable(dataOrdersInBills, headersOrdersInBills);
		scrollPane_6.setViewportView(tblOrdersInBill);
		
		
		
		
		//int selectedRowIndex = MainMenu.tblBills.getSelectedRow();
	
		//String tableClick = MainMenu.tblBills.getModel().getValueAt(selectedRowIndex, 0).toString();
		
		
		DefaultTableModel modelOrderBill = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status", "Rolle"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		//String sqlOrderBill = "SELECT Auftrag.* FROM Auftrag INNER JOIN 'Mischtabelle-Rechnung-Auftrag' ON Auftrag.ID_Auftrag = 'Mischtabelle-Rechnung-Auftrag'.ID_Auftrag WHERE 'Mischtabelle-Rechnung-Auftrag'.ID_Rechnung like '" + idbill +"';";
			String sqlOrderBill = "SELECT * FROM Auftrag";
			ResultSet rsOrderBill = stmt.executeQuery(sqlOrderBill);
		
		//String r = null;
		//String sqlRolle = "SELECT Rolle FROM Mischtabelle-Person-Auftrag WHERE ID_Auftrag =" + r + ";";
		
		
		while(rsOrderBill.next())
		{
			String a1 = rsOrderBill.getString("ID_Auftrag");
		    String b1 = rsOrderBill.getString("Titel");
		    String c1 = rsOrderBill.getString("AF");
		    String d1 = rsOrderBill.getString("Dateiname");
		    String e1 = rsOrderBill.getString("Dateiort");
		    String f1 = rsOrderBill.getString("PK");
		    String g1 = rsOrderBill.getString("RK");
		    String h1 = DataBase.getStatusBeiAuftragId(a1);
		    
		    String j1 = DataBase.getRolleByOrderId(a1);
		    //System.out.println(a1);
		   // System.out.println(j1);
		  
		    
		    modelOrderBill.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1, j1});
		}
		
		tblOrdersInBill.setModel(modelOrderBill);
		
		JButton btnErstellen_1 = new JButton("Erstellen");
		btnErstellen_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NewBill x = new NewBill(); // -id Order 
				x.setVisible(true); 
			}
		});
		btnErstellen_1.setBounds(860, 17, 89, 23);
		panelRechnung.add(btnErstellen_1);
		
		JButton btnAuftragEntfernen = new JButton("Auftrag entfernen");
		btnAuftragEntfernen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				int colnr = tblOrdersInBill.getSelectedRow();
				int id_Bill = Finanzverwaltung.getIDRechnungByOrder(Integer.parseInt(MainMenu.tblOrdersInBill.getModel().getValueAt(colnr, 0).toString()));
				Finanzverwaltung.deleteOrderFromBill(id_Bill);
				
				DataBase.getConnection();
				DataBase.refreshOrderBill();
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Auftrag aus.");
				}finally {
					DataBase.closeConnection();
				}
			}
		});
		btnAuftragEntfernen.setBounds(688, 363, 162, 23);
		panelRechnung.add(btnAuftragEntfernen);
		
		JLabel lblAuftraege_1 = new JLabel("Auftraege:");
		lblAuftraege_1.setBounds(10, 17, 150, 14);
		panelRechnung.add(lblAuftraege_1);
		
		JLabel lblOrdersInThis = new JLabel("Orders in this Bill:");
		lblOrdersInThis.setBounds(494, 209, 183, 14);
		panelRechnung.add(lblOrdersInThis);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(494, 43, 455, 151);
		panelRechnung.add(scrollPane_7);
		
		
		
		
		String[] headers_bills = {"ID_Rechnung", "Rechnungsname", "Auftraggeber", "Betrag", "Beschreibung",  "TimeStamp"};
		String[][] data_bills = new String[1000][9];
		tblBills = new JTable(data_bills, headers_bills);
		DefaultTableModel modelBills = new DefaultTableModel(new String[]{"ID_Rechnung", "Rechnungsname", "Auftraggeber", "Betrag", "Beschreibung", "TimeStamp"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		String sqlBill = "SELECT * FROM Rechnung";
		ResultSet rsBill = stmt.executeQuery(sqlBill);
		
	
		
		
		while(rsBill.next())
		{
			String a1 = rsBill.getString("ID_Rechnung");
		    String b1 = rsBill.getString("Rechnungsname");
		    String c1 = rsBill.getString("Auftraggeber");
		   // String d1 = rsBill.getString("Ansprechpartner");
		   // String e1 = rsBill.getString("Bezahlung_Art");
		    String f1 = rsBill.getString("Betrag");
		    String g1 = rsBill.getString("Beschreibung");
		   // String h1 = rsBill.getString("Bearbeiter");
		    String j1 = rsBill.getString("TimeStamp");
		   
		  
		    
		    modelBills.addRow(new Object[]{a1, b1,c1,f1,g1, j1});
		}
		
		tblBills.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DataBase.getConnection();
								
								int colnr  = MainMenu.tblBills.getSelectedRow();
								
								DefaultTableModel modelOrderBill = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status", "Rolle"}, 0) {
									
									@Override
									public boolean isCellEditable(int row, int column) {
											return false;
										}
									};	
								String id = MainMenu.tblBills.getModel().getValueAt(colnr, 0).toString();
								
								System.out.println(id);
								
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
										  
										    
										    modelOrderBill.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1, j1});
										    										    
//										    modelOrderBill.addRow(new Object[]{a1, b1,c1,f1,g1, h1});
										    
										    System.out.println("While done");
										    
										}
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									tblOrdersInBill.setModel(modelOrderBill);
								
									
									DefaultTableModel modelOrdersForBill = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status", "Rolle"}, 0) {
										
										@Override
										public boolean isCellEditable(int row, int column) {
												return false;
											}
										};	
									String auftraggeberID = MainMenu.tblBills.getModel().getValueAt(colnr, 2).toString();
									
									System.out.println(auftraggeberID);
									
									Statement stmtOrdersForBills = null;
									
										try {
											
											stmtOrdersForBills = DataBase.c.createStatement();
											System.out.println("Statement");
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									
									
									String sqlOrdersForBill = "SELECT Auftrag.* FROM Auftrag INNER JOIN 'Mischtabelle-Person-Auftrag' ON Auftrag.ID_Auftrag = 'Mischtabelle-Person-Auftrag'.ID_Auftrag where 'Mischtabelle-Person-Auftrag'.ID_Person ="+auftraggeberID+";";
									
									ResultSet rsOrdersForBills = null;
									
										try {
											rsOrdersForBills = stmtOrdersForBills.executeQuery(sqlOrdersForBill);
											System.out.println("Query executed");
											System.out.println(rsOrdersForBills);
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									
									
									
									
									
									
										try {
											while(rsOrdersForBills.next())
											{
												String a1 = rsOrdersForBills.getString("ID_Auftrag");
											    String b1 = rsOrdersForBills.getString("Titel");
											    String c1 = rsOrdersForBills.getString("AF");
											    String d1 = rsOrdersForBills.getString("Dateiname");
											    String e1 = rsOrdersForBills.getString("Dateiort");
											    String f1 = rsOrdersForBills.getString("PK");
											    String g1 = rsOrdersForBills.getString("RK");
											    String h1 = DataBase.getStatusBeiAuftragId(a1);
											    
											    String j1 = DataBase.getRolleByOrderId(a1);
											    //System.out.println(a1);
											   // System.out.println(j1);
											  
											    
											    modelOrdersForBill.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1, j1});
											    
											    
											    System.out.println("While done");
											    
											}
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										tblAuftraegeRechnung.setModel(modelOrdersForBill);
									
								
								
								
								
								DataBase.closeConnection();
							
							}
		});
		
		tblBills.setModel(modelBills);
		
		
		//bis hier
		
		scrollPane_7.setViewportView(tblBills);
		
		JLabel lblBills = new JLabel("Bills:");
		lblBills.setBounds(494, 17, 46, 14);
		panelRechnung.add(lblBills);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(860, 363, 89, 23);
		panelRechnung.add(btnSpeichern);
		
		JButton btnAendern_3 = new JButton("Aendern");
		btnAendern_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DataBase.getConnection();
				DefaultTableModel model = (DefaultTableModel) tblBills.getModel();
				//get selected row index
				int selectedRowIndex = tblBills.getSelectedRow();
				if (selectedRowIndex >= 0) {
				try {
				UpdateBill x = new UpdateBill();
				x.setVisible(true);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Rechnung aus.");
			}
				
				DataBase.closeConnection();
			}
		});
		btnAendern_3.setBounds(761, 17, 89, 23);
		panelRechnung.add(btnAendern_3);
		
		JButton btnLoeschen_2 = new JButton("Loeschen");
		btnLoeschen_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DefaultTableModel model = (DefaultTableModel) tblBills.getModel();
				//get selected row index
				int selectedRowIndex = tblBills.getSelectedRow();
				if (selectedRowIndex >= 0) {
				try {
				DeleteBill x = new DeleteBill();
				x.setVisible(true);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
			}
			}
		});
		btnLoeschen_2.setBounds(662, 17, 89, 23);
		panelRechnung.add(btnLoeschen_2);
		
		JPanel panelBau = new JPanel();
		tabbedPane.addTab("Bauteileverwaltung", null, panelBau, null);
		panelBau.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(194, 56, 755, 299);
		panelBau.add(scrollPane_3);
		
		String[] column_headers_component = {"ID Bauteil", "Name","Link", "Menge lagernd", "Menge bestellt", "Menge geplant", "Lagerort", "Preis"};
		String[][] data_components = new String[1000][8];
		tblComponents = new JTable(data_components, column_headers_component);
		DefaultTableModel modelComponents = new DefaultTableModel(new String[]{"ID Bauteil", "Name","Link", "Menge lagernd", "Menge bestellt", "Menge geplant", "Lagerort", "Preis"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};	
			Statement stmtComponents = DataBase.c.createStatement();
			String sqlComponent = "SELECT * FROM Bauteil";
			ResultSet rsComponent = stmtComponents.executeQuery(sqlComponent);
			
			
			
			
			while(rsComponent.next())
			{
				String a1 = rsComponent.getString("ID_Bauteil");
			    String b1 = rsComponent.getString("Name");
			    String c1 = rsComponent.getString("Link");
			    String d1 = rsComponent.getString("MengeLagernd");
			    String e1 = rsComponent.getString("MengeBestellt");
			    String f1 = rsComponent.getString("MengeGeplant");
			    String g1 = rsComponent.getString("Lagerort");
			    int id = Integer.parseInt(a1);
			    
			    String h1 =BauteileAuftragsabwicklung.getComponentPrice(id);
			    
			    
			 
			  
			    
			    modelComponents.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1});
			}
			
			tblComponents.setModel(modelComponents);
			
			
			
		
		
		scrollPane_3.setViewportView(tblComponents);
		
		txtSearchComponent = new JTextField();
		txtSearchComponent.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				SwingUtilities.getRootPane(btnSearchComponent).setDefaultButton(btnSearchComponent);
			}
		});
		txtSearchComponent.setBounds(749, 11, 200, 20);
		panelBau.add(txtSearchComponent);
		txtSearchComponent.setColumns(10);
		
		JButton btnAddComponent = new JButton("Hinzufuegen");
		btnAddComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddComponent x = new AddComponent(); // -id Order 
				x.setVisible(true);
			}
		});
		btnAddComponent.setBounds(204, 359, 101, 23);
		panelBau.add(btnAddComponent);
		
		JButton btnDeleteComponent = new JButton("Loeschen");
		btnDeleteComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tblComponents.getModel();
				//get selected row index
				int selectedRowIndex = tblComponents.getSelectedRow();
				if (selectedRowIndex >= 0) {
				try {
				DeleteComponent x = new DeleteComponent();
				x.setVisible(true);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
			}
				
			}
		});
		btnDeleteComponent.setBounds(204, 388, 101, 23);
		panelBau.add(btnDeleteComponent);
		
		JButton btnAendern = new JButton("Aendern");
		btnAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UpdateComponent x = new UpdateComponent(); // -id Order 
					x.setVisible(true);	
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
				}
				
			}
		});
		btnAendern.setBounds(318, 359, 101, 23);
		panelBau.add(btnAendern);
		
		btnSearchComponent = new JButton("Suchen");
		btnSearchComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataBase.searchComponent(txtSearchComponent.getText());
			}
		});
		btnSearchComponent.setBounds(650, 10, 89, 23);
		panelBau.add(btnSearchComponent);
		
		String[] column_headers_category = {"ID", "Name"};
		String[][] data_category = new String[1000][2];
		DefaultTableModel modelCategory = new DefaultTableModel(new String[]{"ID", "Name"}, 0) {
			
			@Override 
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			Statement stmtCategory = DataBase.c.createStatement();
			String sqlCategory = "SELECT * FROM Kategorie";
			ResultSet rsCategory = stmtCategory.executeQuery(sqlCategory);
			
			
			
			
			while(rsCategory.next())
			{
				String a1 = rsCategory.getString("ID_Kategorie");
			    String b1 = rsCategory.getString("Name");
			  
			    
			    
			 
			  
			    
			    modelCategory.addRow(new Object[]{a1, b1});
			}
			
			JScrollPane scrollPane_4 = new JScrollPane();
			scrollPane_4.setBounds(10, 56, 174, 299);
			panelBau.add(scrollPane_4);
			
			tblCategory = new JTable(data_category, column_headers_category);
			scrollPane_4.setViewportView(tblCategory);
			tblCategory.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					DataBase.getConnection();
					int colnr  = MainMenu.tblCategory.getSelectedRow();
					DefaultTableModel modelComponentsKategorie = new DefaultTableModel(new String[]{"ID Bauteil", "Name","Link", "Menge lagernd", "Menge bestellt", "Menge geplant", "Lagerort", "Preis"}, 0) {
						
						@Override
						public boolean isCellEditable(int row, int column) {
								return false;
							}
						};	
					String id = MainMenu.tblCategory.getModel().getValueAt(colnr, 0).toString();
					
					System.out.println(id);
					
					Statement stmtCategoryComponents = null;
					
						try {
							
							stmtCategoryComponents = DataBase.c.createStatement();
							System.out.println("Statement");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
					String sqlCategoryComponents = "SELECT Bauteil.* FROM Bauteil INNER JOIN 'Mischtabelle-Kategorie-Bauteil' on Bauteil.ID_Bauteil = 'Mischtabelle-Kategorie-Bauteil'.ID_Bauteil where 'Mischtabelle-Kategorie-Bauteil'.ID_Kategorie ="+id+";";
					
					ResultSet rsCategoryComponents = null;
					
						try {
							rsCategoryComponents = stmtCategoryComponents.executeQuery(sqlCategoryComponents);
							System.out.println("Query executed");
							System.out.println(rsCategoryComponents);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
					
					
					
					
						try {
							while(rsCategoryComponents.next())
							{
								String a1 = rsCategoryComponents.getString("ID_Bauteil");
							    String b1 = rsCategoryComponents.getString("Name");
							    String c1 = rsCategoryComponents.getString("Link");
							    String d1 = rsCategoryComponents.getString("MengeLagernd");
							    String e1 = rsCategoryComponents.getString("MengeBestellt");
							    String f1 = rsCategoryComponents.getString("MengeGeplant");
							    String g1 = rsCategoryComponents.getString("Lagerort");
							    int id1 = Integer.parseInt(a1);
							   
							    String h1 =BauteileAuftragsabwicklung.getComponentPrice(id1);
							    
							    
							 
							  
							    
							    modelComponentsKategorie.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1});
							    
							    System.out.println("While done");
							    
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						tblAuftraegeRechnung.setModel(modelComponentsKategorie);
					
					
					
					
					
					
					DataBase.closeConnection();
				}
			});
			
			tblCategory.setModel(modelCategory);
			
			JButton btnNeueKategorie = new JButton("Neue Kategorie");
			btnNeueKategorie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NewCategory x = new NewCategory();
					x.setVisible(true);
				}
			});
			btnNeueKategorie.setBounds(20, 359, 145, 23);
			panelBau.add(btnNeueKategorie);
			
			JButton btnKategorieverwaltung = new JButton("Kategorieverwaltung");
			btnKategorieverwaltung.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						AddToCategory x;
						
							x = new AddToCategory();
							x.setVisible(true);	
					} catch (ArrayIndexOutOfBoundsException ex) {
						JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
					}
					
				}
			});
			btnKategorieverwaltung.setBounds(792, 388, 157, 23);
			panelBau.add(btnKategorieverwaltung);
			
			JButton btnShowAll = new JButton("Show all");
			btnShowAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtSearchComponent.setText("");
					DataBase.refreshComponent();
					
				}
			});
			btnShowAll.setBounds(194, 22, 89, 23);
			panelBau.add(btnShowAll);
			
			JButton btnMengenverwaltung = new JButton("Mengenverwaltung");
			btnMengenverwaltung.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Mengenverwaltung x= new Mengenverwaltung();
						x.setVisible(true);
					} catch (ArrayIndexOutOfBoundsException ex) {
						JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
					}
					
				}
			});
			btnMengenverwaltung.setBounds(792, 359, 157, 23);
			panelBau.add(btnMengenverwaltung);
			
			JButton btnLoeschen_1 = new JButton("Loeschen");
			btnLoeschen_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DefaultTableModel model = (DefaultTableModel) tblCategory.getModel();
					//get selected row index
					int selectedRowIndex = tblCategory.getSelectedRow();
					if (selectedRowIndex >= 0) {
					try {
					DeleteCategory x = new DeleteCategory();
					x.setVisible(true);
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Kategorie aus.");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Kategorie aus.");
				}
				}
			});
			btnLoeschen_1.setBounds(0, 388, 89, 23);
			panelBau.add(btnLoeschen_1);
			
			JButton btnAendern_1 = new JButton("Aendern");
			btnAendern_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						UpdateCategory x = new UpdateCategory(); // -id Order 
						x.setVisible(true);	
					} catch (ArrayIndexOutOfBoundsException ex) {
						JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
					}
				}
			});
			btnAendern_1.setBounds(95, 388, 89, 23);
			panelBau.add(btnAendern_1);
			
			JButton btnPreis = new JButton("Preis");
			btnPreis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel model = (DefaultTableModel) tblComponents.getModel();
					//get selected row index
					int selectedRowIndex = tblComponents.getSelectedRow();
					if (selectedRowIndex >= 0) {
					try {
					AddPrice x = new AddPrice();
					x.setVisible(true);
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Zeile aus.");
				}
				}
			});
			btnPreis.setBounds(315, 388, 104, 23);
			panelBau.add(btnPreis);
			
			Label label = new Label("Kategorien");
			label.setFont(new Font("Dialog", Font.BOLD, 20));
			label.setBounds(10, 28, 131, 22);
			panelBau.add(label);
		
		
		
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelPerson, btnHinzufuegen, btnLoeschen, txtSuchen, tabbedPane, lblNewLabel, scrollPane, tblPersonen, scrollPane_1, tblAuftraege, lblAuftraege, btnSuchen, btnSearchOrder, btnChangePerson, btnRefresh, btnErstellen, btnChangeOrder, btnDeleteOrder, txtSearchOrder, btnNewButton, panelFinanz, panelBau, panelOrders}));

		
		DataBase.closeConnection();
	}
	
	public void refresh() {
		
	}
}