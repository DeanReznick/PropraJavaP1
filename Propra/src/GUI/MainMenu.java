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
import Data.DataBase;
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
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

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
			
		String[] column_headers_auftraege = {"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status", "Rolle"};
		String[][] data_auftraege = new String[1000][11];
		tblAuftraege = new JTable(data_auftraege, column_headers_auftraege);
		DefaultTableModel modelAuftrag = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status", "Rolle"}, 0) {
			
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
					JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie eine Zeile aus.");
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
						JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie eine Person aus.");
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
					JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie eine Zeile aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie eine Zeile aus.");
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
				try {
				int colnr  = tblAuftraege.getSelectedRow();

				Object id_order  =  tblAuftraege.getModel().getValueAt(colnr, 0);
				
				Integer id = Integer.valueOf(id_order.toString()); 
				
				
				AlterStatus x = new AlterStatus(id.intValue()); // -id Order 
				x.setVisible(true);  
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie eine Zeile aus.");
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
					JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie eine Zeile aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie eine Zeile aus.");
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
		
		String[] column_headers_orders = {"ID �nderung", "ID Bauteil","ID Person", "Vorname", "Name", "Timestamp", "Aenderung"};
		String[][] data_orders = new String[1000][7];
		tblOffeneAuftraege = new JTable(data_orders, column_headers_orders);
		tblOffeneAuftraege.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
				OrderApprove x = new OrderApprove(); // -id Order 
				x.setVisible(true);  
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie eine Zeile aus.");
				}	
			}
		});
		DefaultTableModel modelOffeneAuftraege = new DefaultTableModel(new String[]{"ID �nderung", "ID Bauteil","ID Person", "Vorname", "Name", "Timestamp", "Aenderung"}, 0) {
			
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
		
		JPanel panelBau = new JPanel();
		tabbedPane.addTab("Bauteileverwaltung", null, panelBau, null);
		panelBau.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(194, 56, 755, 299);
		panelBau.add(scrollPane_3);
		
		String[] column_headers_component = {"ID Bauteil", "Name","Link", "Menge lagernd", "Menge bestellt", "Menge geplant", "Lagerort"};
		String[][] data_components = new String[1000][7];
		tblComponents = new JTable(data_components, column_headers_component);
		DefaultTableModel modelComponents = new DefaultTableModel(new String[]{"ID Bauteil", "Name","Link", "Menge lagernd", "Menge bestellt", "Menge geplant", "Lagerort"}, 0) {
			
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
			    
			    
			 
			  
			    
			    modelComponents.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1});
			}
			
			tblComponents.setModel(modelComponents);
			
			
			
		
		
		scrollPane_3.setViewportView(tblComponents);
		
		txtSearchComponent = new JTextField();
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
		btnAddComponent.setBounds(219, 377, 101, 23);
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
					JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie eine Zeile aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie eine Zeile aus.");
			}
				
			}
		});
		btnDeleteComponent.setBounds(330, 377, 101, 23);
		panelBau.add(btnDeleteComponent);
		
		JButton btnAendern = new JButton("Aendern");
		btnAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UpdateComponent x = new UpdateComponent(); // -id Order 
					x.setVisible(true);	
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie eine Zeile aus.");
				}
				
			}
		});
		btnAendern.setBounds(441, 377, 101, 23);
		panelBau.add(btnAendern);
		
		JButton btnSearchComponent = new JButton("Suchen");
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
					DefaultTableModel modelComponentsKategorie = new DefaultTableModel(new String[]{"ID Bauteil", "Name","Link", "Menge lagernd", "Menge bestellt", "Menge geplant", "Lagerort"}, 0) {
						
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
							    
							    
							 
							  
							    
							    modelComponentsKategorie.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1});
							    
							    System.out.println("While done");
							    
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						tblComponents.setModel(modelComponentsKategorie);
					
					
					
					
					
					
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
			btnNeueKategorie.setBounds(10, 377, 145, 23);
			panelBau.add(btnNeueKategorie);
			
			JButton btnKategorieverwaltung = new JButton("Kategorieverwaltung");
			btnKategorieverwaltung.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						AddToCategory x;
						
							x = new AddToCategory();
							x.setVisible(true);	
					} catch (ArrayIndexOutOfBoundsException ex) {
						JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie eine Zeile aus.");
					}
					
				}
			});
			btnKategorieverwaltung.setBounds(784, 377, 165, 23);
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
						JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie eine Zeile aus.");
					}
					
				}
			});
			btnMengenverwaltung.setBounds(600, 377, 157, 23);
			panelBau.add(btnMengenverwaltung);
		
		
		
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelPerson, btnHinzufuegen, btnLoeschen, txtSuchen, tabbedPane, lblNewLabel, scrollPane, tblPersonen, scrollPane_1, tblAuftraege, lblAuftraege, btnSuchen, btnSearchOrder, btnChangePerson, btnRefresh, btnErstellen, btnChangeOrder, btnDeleteOrder, txtSearchOrder, btnNewButton, panelFinanz, panelBau, panelOrders}));

		
		DataBase.closeConnection();
	}
	
	public void refresh() {
		
	}
}