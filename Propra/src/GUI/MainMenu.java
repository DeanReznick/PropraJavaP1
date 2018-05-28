package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Data.Authentication;
import Data.DataBase;
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
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	public static JTextField txtSuchen;
	private JTable table;
	public static JTable tblPersonen;
	public static JTable tblAuftraege;
	public static JScrollPane scrollPane;
	private JTextField txtSearchOrder;
	public static JScrollPane scrollPane_1;
	

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
		
		DataBase.getConnection(); // Muss immer am Anfang ausgef�hrt werden!
//	    PersonenFertigungsverwaltung.createNewPerson("Kern", "Dean-Robin", "0271/312", "test@ttest.de", "Deutschland", "HB", "Siegen", "10", 57076, "Member", "Geheim123"); 
//	    //PersonenFertigungsverwaltung.deletePerson("Kern", "Dean-Robin"); 
//	    PersonenFertigungsverwaltung.changeNameSurname("Kern", "Dean", "Hans", "M�ller"); 
//	    PersonenFertigungsverwaltung.changeMail("Kern", "Dean-Robin", "dean-kern@t-online.de"); 
//	    PersonenFertigungsverwaltung.changePhoneNumber("Kern", "Dean-Robin", "0271/3178279"); 
//	    PersonenFertigungsverwaltung.changeAddressDataSet("Kern", "Dean-Robin", "Deutschland", "Hermann-B�ttger Weg", "Siegen", "10", 57076);
//	    
//	    
//	    
//	    PersonenFertigungsverwaltung.createNewOrder("Fertigung B", "Standard", "job 33", "C://vbm", "144,-�","65�", "Kern", "Dean-Robin", "Owner");
//	    PersonenFertigungsverwaltung.changeDataSetOrder(12, "Fertigung A","Spezial", "job 123", "C://Projekt_a/bcd", "100,-�","62�");
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
				DataBase.getConnection();
				if (txtSuchen.getText().equals("")) {
					DataBase.getAllPersons();
				}
				DataBase.closeConnection();
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
				int colnr  = MainMenu.tblPersonen.getSelectedRow();
				
				String personName = MainMenu.tblPersonen.getModel().getValueAt(colnr, 1).toString();
				String personVorname = MainMenu.tblPersonen.getModel().getValueAt(colnr, 2).toString();
				String fullName = personVorname + " " + personName;
				
				txtSearchOrder.setText(fullName);
				DataBase.searchOrder(fullName);
			}
		});
		tblPersonen.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				int colnr  = MainMenu.tblPersonen.getSelectedRow();
				
				String personName = MainMenu.tblPersonen.getModel().getValueAt(colnr, 1).toString();
				String personVorname = MainMenu.tblPersonen.getModel().getValueAt(colnr, 2).toString();
				String fullName = personVorname + " " + personName;
				
				txtSearchOrder.setText(fullName);
				DataBase.searchOrder(fullName);
			}
		});
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Vorname", "Telefon", "Email", "Rolle",  "Stra�e", "Hausnummer", "PLZ", "Ort", "Land"}, 0) {
		
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
		    String g = rs.getString("Stra�e");
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
			
		String[] column_headers_auftraege = {"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status"};
		String[][] data_auftraege = new String[1000][11];
		tblAuftraege = new JTable(data_auftraege, column_headers_auftraege);
		DefaultTableModel modelAuftrag = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		String sqlAuftrag = "SELECT * FROM Auftrag";
		ResultSet rsAuftrag = stmt.executeQuery(sqlAuftrag);
		
		while(rsAuftrag.next())
		{
			String a1 = rsAuftrag.getString("ID_Auftrag");
		    String b1 = rsAuftrag.getString("Titel");
		    String c1 = rsAuftrag.getString("AF");
		    String d1 = rsAuftrag.getString("Dateiname");
		    String e1 = rsAuftrag.getString("Dateiort");
		    String f1 = rsAuftrag.getString("PK");
		    String g1 = rsAuftrag.getString("RK");
		    String h1 = rsAuftrag.getString("ID_Status");
		   
		    
		    modelAuftrag.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1});
		}
		
		tblAuftraege.setModel(modelAuftrag);
				
		
		scrollPane_1.setViewportView(tblAuftraege);
		
		JLabel lblAuftraege = new JLabel("Auftraege:");
		lblAuftraege.setBounds(10, 241, 71, 14);
		panelPerson.add(lblAuftraege);
		
		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.setBounds(423, 0, 116, 23);
		panelPerson.add(btnSuchen);
		
		JButton btnSearchOrder = new JButton("Suchen");
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
					JOptionPane.showMessageDialog(null, "Bitte w�hlen sie eine Zeile aus.");
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
						JOptionPane.showMessageDialog(null, "Bitte w�hlen sie eine Person aus.");
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
					JOptionPane.showMessageDialog(null, "Bitte w�hlen sie eine Zeile aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte w�hlen sie eine Zeile aus.");
			}
			}
		});
		btnDeleteOrder.setBounds(208, 388, 127, 23);
		panelPerson.add(btnDeleteOrder);
		
		txtSearchOrder = new JTextField();
		txtSearchOrder.setBounds(744, 389, 205, 20);
		panelPerson.add(txtSearchOrder);
		txtSearchOrder.setColumns(10);
		
		JButton btnNewButton = new JButton("Status aendern");
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int colnr  = tblAuftraege.getSelectedRow();

				Object id_order  =  tblAuftraege.getModel().getValueAt(colnr, 0);
				
				Integer id = Integer.valueOf(id_order.toString()); 
				
				
				AlterStatus x = new AlterStatus(id.intValue()); // -id Order 
				x.setVisible(true);  
		
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
					JOptionPane.showMessageDialog(null, "Bitte w�hlen sie eine Zeile aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte w�hlen sie eine Zeile aus.");
			}
				
			}
		});
		
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				DataBase.searchTable(txtSuchen.getText());
				DataBase.searchPerson(txtSuchen.getText());
			}
		});
				
		JPanel panelFinanz = new JPanel();
		tabbedPane.addTab("Finanzverwaltung", null, panelFinanz, null);
		
		JPanel panelBau = new JPanel();
		tabbedPane.addTab("Bauteileverwaltung", null, panelBau, null);
		
		DataBase.closeConnection();
	}
	
	public void refresh() {
		
	}
}
