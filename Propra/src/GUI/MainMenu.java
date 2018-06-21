package GUI;
//Test
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import Data.Authentication;
import Data.BauteileAuftragsabwicklung;
import Data.DataBase;
import Data.ExportToPDF;
import Data.Finanzverwaltung;
import Data.OffenerAuftragObjektRAM;
import Data.OrderObjektRAM;
import Data.PersonObjektRAM;
import Data.PersonenFertigungsverwaltung;
import Data.StatusObjektRAM;
import Exceptions.InvalidArgumentsException;
import Exceptions.Manager;

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
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JSeparator;
import java.awt.Canvas;
import java.awt.Color;

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
	private JTextField txtDetailNamePerson;
	private JTextField txtDetailVornamePerson;
	private JTextField txtDetailTelefonPerson;
	private JTextField txtDetailMailPerson;
	private JTextField txtDetailRollePerson;
	private JTextField txtDetailStrassePerson;
	private JTextField txtDetailHausnummerPerson;
	private JTextField txtDetailPlzPerson;
	private JTextField txtDetailLandPerson;
	private JTextField txtDetailOrtPerson;
	private JTextField txtDetailPkOrder;
	private JTextField txtDetailDateiortOrder;
	private JTextField txtDetailDateinameOrder;
	private JTextField txtDetailAfOrder;
	private JTextField txtDetailTitelOrder;
	private JTextField txtDetailRkOrder;
	private JTextField txtDetailStatusOrder;
	private JTextField txtDetailRolleOrder;
//	static GraphicsDevice device = GraphicsEnvironment
//	        .getLocalGraphicsEnvironment().getScreenDevices()[0];

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
//		device.setFullScreenWindow(this);
//		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
//		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
		setLocationRelativeTo(null);
		
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
//		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1894, 1029);
		contentPane.add(tabbedPane);
		
		JPanel panelPerson = new JPanel();
		tabbedPane.addTab("Pers. & Fertigung", null, panelPerson, null);
		panelPerson.setLayout(null);
		
		JButton btnHinzufuegen = new JButton("Neue Person");
		btnHinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddPerson x = new AddPerson();
				x.setVisible(true);
			}
		});
		btnHinzufuegen.setBounds(10, 967, 140, 23);
		panelPerson.add(btnHinzufuegen);
		
		JButton btnLoeschen = new JButton("Person l\u00F6schen");
		
		btnLoeschen.setBounds(337, 967, 140, 23);
		panelPerson.add(btnLoeschen);
		
		txtSuchen = new JTextField();
		txtSuchen.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				SwingUtilities.getRootPane(btnSuchen).setDefaultButton(btnSuchen);
			}
		});
		txtSuchen.setToolTipText("Suchen...");
		txtSuchen.setBounds(277, 28, 200, 20);
		panelPerson.add(txtSuchen);
		txtSuchen.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Personen:");
		lblNewLabel.setBounds(10, 11, 71, 14);
		panelPerson.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 467, 895);
		panelPerson.add(scrollPane);
		
		
		Connection con = null;
				
		String[] column_headers = {"ID_Person", "Name", "Vorname", "Email"};
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
				
//				txtSearchOrder.setText(fullName);
				DataBase.searchOrder(fullName);
				
				PersonObjektRAM clicked = new PersonObjektRAM();
				String mail = MainMenu.tblPersonen.getModel().getValueAt(colnr, 3).toString();
				
				for (PersonObjektRAM p : DataBase.people) {
					if (p.getMail().equals(mail) && p.getName().equals(personName) && p.getVorname().equals(personVorname)) {
						clicked = p;
					}
				}
				
				txtDetailNamePerson.setText(clicked.getName());
				txtDetailVornamePerson.setText(clicked.getVorname());
				txtDetailTelefonPerson.setText(clicked.getTelefonnummer());
				txtDetailMailPerson.setText(clicked.getMail());
				txtDetailRollePerson.setText(clicked.getRolle());
				txtDetailStrassePerson.setText(clicked.getStraße());
				txtDetailHausnummerPerson.setText(clicked.getHausnummer());
				txtDetailPlzPerson.setText(Integer.toString(clicked.getPlz()));
				txtDetailOrtPerson.setText(clicked.getOrt());
				txtDetailLandPerson.setText(clicked.getLand());
				DataBase.closeConnection();
			}
		});
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID_Person", "Name", "Vorname", "Email"}, 0) {
		
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
			String idPerson = rs.getString("ID_Person");
		    String name = rs.getString("Name");
		    String vorname = rs.getString("Vorname");
		    String telefonnummer = rs.getString("Telefonnummer");
		    String mail = rs.getString("Mail");
		    String rolle = rs.getString("Rolle");
		    String straße = rs.getString("Straße");
		    String hausnummer = rs.getString("Hausnummer");
		    String plz = rs.getString("PLZ");
		    String ort = rs.getString("Ort");
		    String land = rs.getString("Land");
		    String passwort = rs.getString("Passwort");
		    String timestamp = rs.getString("Timestamp");
		    
		    PersonObjektRAM person = new PersonObjektRAM( Integer.parseInt(idPerson), name, telefonnummer,  mail, timestamp, rolle,  passwort,  land,  straße,ort, Integer.parseInt(plz), hausnummer,vorname);  
		    DataBase.people.add(person);
		    
		    model.addRow(new Object[]{idPerson, name, vorname, mail});
		}
		
		tblPersonen.setModel(model);
				
		scrollPane.setViewportView(tblPersonen);
		TableColumnModel tcm = MainMenu.tblPersonen.getColumnModel();
		tcm.removeColumn( tcm.getColumn(0) );
				
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(960, 61, 460, 895);
		panelPerson.add(scrollPane_1);
			
		String[] column_headers_auftraege = {"Titel", "Status"};
		String[][] data_auftraege = new String[1000][11];
		tblAuftraege = new JTable(data_auftraege, column_headers_auftraege);
		tblAuftraege.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DataBase.getConnection();
				int colnr  = MainMenu.tblAuftraege.getSelectedRow();
				String id = MainMenu.tblAuftraege.getModel().getValueAt(colnr, 0).toString();
				
				OrderObjektRAM clicked = new OrderObjektRAM();
				
				for (OrderObjektRAM o : DataBase.orders) {
					if (o.getId_Auftrag() == Integer.parseInt(id)) {
						clicked = o;
					}
				}
				
				txtDetailTitelOrder.setText(clicked.getTitel());
				txtDetailAfOrder.setText(clicked.getAf());
				txtDetailDateinameOrder.setText(clicked.getDateiname());
				txtDetailDateiortOrder.setText(clicked.getDateiort());
				txtDetailPkOrder.setText(clicked.getPk());
				txtDetailRkOrder.setText(clicked.getRk());
				txtDetailStatusOrder.setText(DataBase.getStatusBeiAuftragId(id));
				txtDetailRolleOrder.setText(DataBase.getRolleByOrderId(id));

				DataBase.closeConnection();
			}
		});
		DefaultTableModel modelAuftrag = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "Status"}, 0) {
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
			String idAuftrag = rsAuftrag.getString("ID_Auftrag");
		    String titel = rsAuftrag.getString("Titel");
		    String af = rsAuftrag.getString("AF");
		    String dateiname = rsAuftrag.getString("Dateiname");
		    String dateiort = rsAuftrag.getString("Dateiort");
		    String pk = rsAuftrag.getString("PK");
		    String rk = rsAuftrag.getString("RK");
		    String status = DataBase.getStatusBeiAuftragId(idAuftrag);
		    
		    String rolle = DataBase.getRolleByOrderId(idAuftrag);
		    //System.out.println(a1);
		   // System.out.println(j1);
		    
		    OrderObjektRAM order = new OrderObjektRAM( Integer.parseInt(idAuftrag), titel, af,  dateiname, dateiort, pk,  rk); 
		    //public OrderObjektRAM(int id_Auftrag, String titel, String af, String dateiname, String dateiort, String pk, String rk) {
		    DataBase.orders.add(order);
		    
		    modelAuftrag.addRow(new Object[]{idAuftrag, titel, status});
		}
		
		tblAuftraege.setModel(modelAuftrag);
		TableColumnModel tcm2 = tblAuftraege.getColumnModel();
		tcm.removeColumn( tcm2.getColumn(0) );
				
		
		scrollPane_1.setViewportView(tblAuftraege);
		
		JLabel lblAuftraege = new JLabel("Auftraege:");
		lblAuftraege.setBounds(960, 11, 71, 14);
		panelPerson.add(lblAuftraege);
		
		btnSuchen = new JButton("Suchen");
		btnSuchen.setBounds(147, 27, 120, 23);
		panelPerson.add(btnSuchen);
		
		btnSearchOrder = new JButton("Suchen");
		btnSearchOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBase.searchOrder(txtSearchOrder.getText());
			}
		});
		btnSearchOrder.setBounds(1090, 27, 120, 23);
		panelPerson.add(btnSearchOrder);
		
		JButton btnChangePerson = new JButton("Speichern");
		btnChangePerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DataBase.getConnection();
					int colnr  = MainMenu.tblPersonen.getSelectedRow();
					
					String personName = MainMenu.tblPersonen.getModel().getValueAt(colnr, 1).toString();
					String personVorname = MainMenu.tblPersonen.getModel().getValueAt(colnr, 2).toString();
					
					PersonObjektRAM clicked = new PersonObjektRAM();
					String mail = MainMenu.tblPersonen.getModel().getValueAt(colnr, 3).toString();
					
					for (PersonObjektRAM p : DataBase.people) {
						if (p.getMail().equals(mail) && p.getName().equals(personName) && p.getVorname().equals(personVorname)) {
							clicked = p;
						}
					}
					String oldName = clicked.getName();
					String oldVorname = clicked.getVorname();
					String oldTel = clicked.getTelefonnummer();
					String oldMail = clicked.getMail();
					String oldRolle = clicked.getRolle();
					String oldStr = clicked.getStraße();
					String oldHaus = clicked.getHausnummer();
					int oldPlz = clicked.getPlz();
					String oldOrt = clicked.getOrt();
					String oldLand = clicked.getLand();
					
					
					String newName = txtDetailNamePerson.getText();
					String newVorname = txtDetailVornamePerson.getText();
					String newTel = txtDetailTelefonPerson.getText();
					String newMail = txtDetailMailPerson.getText();
					String newRolle = txtDetailRollePerson.getText();
					String newStr = txtDetailStrassePerson.getText();
					String newHaus = txtDetailHausnummerPerson.getText();
					int newPlz = Integer.parseInt(txtDetailPlzPerson.getText());
					String newOrt = txtDetailOrtPerson.getText();
					String newLand = txtDetailLandPerson.getText();
					
					if(!newName.equals(oldName) || !newVorname.equals(oldVorname)) {
						
						PersonenFertigungsverwaltung.changeNameSurname(oldVorname, oldName, newVorname, newName);
						System.out.println(oldName);
						System.out.println(newVorname);
						
						
					}
					
					
					if(!newTel.equals(oldTel))
					{
						PersonenFertigungsverwaltung.changePhoneNumber(oldVorname, oldName, newTel);
					}
					
					
					if(!newMail.equals(oldMail))
					{
						PersonenFertigungsverwaltung.changeMail(oldVorname, oldName, newMail);
					}
					
					if(!newRolle.equals(oldRolle))
					{
					PersonenFertigungsverwaltung.changeRolle(clicked.getID_Person(), newRolle);
					}
					
					
					
					if(!newLand.equals(oldLand)
						|| !newStr.equals(oldStr)
						|| !newOrt.equals(oldOrt)
						|| !newHaus.equals(oldHaus)
						|| newPlz != oldPlz)
					{
						PersonenFertigungsverwaltung.changeAddressDataSet(oldVorname, oldName, newLand, newStr, newOrt, newHaus, newPlz);
					}
					
					txtDetailNamePerson.setText("");
					txtDetailVornamePerson.setText("");
					txtDetailTelefonPerson.setText("");
					txtDetailMailPerson.setText("");
					txtDetailRollePerson.setText("");
					txtDetailStrassePerson.setText("");
					txtDetailHausnummerPerson.setText("");
					txtDetailPlzPerson.setText("");
					txtDetailOrtPerson.setText("");
					txtDetailLandPerson.setText("");
					
					DataBase.loadPeopleToRAM();
					DataBase.refreshPersonen();
					
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Person aus.");
				} finally {
					DataBase.closeConnection();
				}
			}
		});
		btnChangePerson.setBounds(677, 346, 120, 23);
		panelPerson.add(btnChangePerson);
		
		JButton btnRefresh = new JButton("Alle anzeigen");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					DataBase.refreshPersonen();				
			}
		});
		
		btnRefresh.setBounds(10, 27, 120, 23);
		panelPerson.add(btnRefresh);
		
		JButton btnErstellen = new JButton("Erstellen");
		btnErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NewOrder x = new NewOrder();
				x.setVisible(true);
			}
		});
		btnErstellen.setBounds(960, 967, 140, 23);
		panelPerson.add(btnErstellen);
		
		JButton btnChangeOrder = new JButton("Speichern");
		btnChangeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
//				DataBase.getConnection();
				
				int colId = 0;
				int colTitel = 1;
				int colAf = 2; 
				int colDateiname = 3; 
				int colDateiort = 4; 
				int colPk= 5;
				int colRk = 6;
				int colIdStatus = 7;
				int colnr  = tblAuftraege.getSelectedRow();
				
				/*txtDetailTitelOrder.setText(clicked.getTitel());
				txtDetailAfOrder.setText(clicked.getAf());
				txtDetailDateinameOrder.setText(clicked.getDateiname());
				txtDetailDateiortOrder.setText(clicked.getDateiort());
				txtDetailPkOrder.setText(clicked.getPk());
				txtDetailRkOrder.setText(clicked.getRk());
				txtDetailStatusOrder.setText(DataBase.getStatusBeiAuftragId(id));
				txtDetailRolleOrder.setText(DataBase.getRolleByOrderId(id));*/
				
				OrderObjektRAM clicked = new OrderObjektRAM();
				String id = MainMenu.tblAuftraege.getModel().getValueAt(colnr, 0).toString();
				
				for (OrderObjektRAM o : DataBase.orders) {
					if (o.getId_Auftrag() == Integer.parseInt(id)) {
						clicked = o;
					}
				}
				
				int idOld = Integer.parseInt(id);
				String headerOld = clicked.getTitel();
				String afOld = clicked.getAf();
				String filenameOld = clicked.getDateiname();
				String repositoryOld = clicked.getDateiort();
				String pkOld = clicked.getPk();
				String rkOld = clicked.getRk();
				String statusOld = DataBase.getStatusBeiAuftragId(id);
				
				int colnrPers  = MainMenu.tblPersonen.getSelectedRow();
				int idPerson = Integer.parseInt(MainMenu.tblPersonen.getModel().getValueAt(colnrPers, 0).toString());
				String jobOld = DataBase.getRolleByOrderId(id);
					
					
					int idNew = idOld;
					String headerNew = txtDetailTitelOrder.getText();
					String afNew = txtDetailAfOrder.getText(); 
					String filenameNew = txtDetailDateinameOrder.getText();
					String repositoryNew = txtDetailDateiortOrder.getText();
					String pkNew = txtDetailPkOrder.getText();
					String rkNew = txtDetailRkOrder.getText();
					String jobNew = txtDetailRolleOrder.getText();
					String statusNew = txtDetailStatusOrder.getText();
					
					
//					Manager.checkStandardOrderUpdate(headerNew, afNew, filenameNew, repositoryNew, pkNew, rkNew);
					
					if(!headerNew.equals(headerOld) 
							||!afNew.equals(afOld) 
							||!filenameNew.equals(filenameOld)
							||!repositoryNew.equals(repositoryOld)
							||!pkNew.equals(pkOld)
							||!rkNew.equals(rkOld)
							) {
						
						
						
						PersonenFertigungsverwaltung.changeDataSetOrder(idNew, headerNew, afNew, filenameNew, repositoryNew, pkNew, rkNew);
					}
					
					
					PersonenFertigungsverwaltung.changeJobOrderPerson(idPerson, idOld, jobNew);

					Object id_order  =  tblAuftraege.getModel().getValueAt(colnr, 0);
					
					Integer idAuftrag = Integer.valueOf(id_order.toString()); 
					

					
					PersonenFertigungsverwaltung.alterStatus(idAuftrag, txtDetailStatusOrder.getText());
					
					
						
					DataBase.refreshOrder();
					DataBase.refreshOrderBill();
//					DataBase.closeConnection();
					
					
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Person und einen Auftrag aus.");
				} 
//				catch (InvalidArgumentsException e) {
//					
//				}
				
				
			}
		});
		btnChangeOrder.setBounds(1620, 293, 120, 23);
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
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Auftrag aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Auftrag aus.");
			}
			}
		});
		btnDeleteOrder.setBounds(1280, 967, 140, 23);
		panelPerson.add(btnDeleteOrder);
		
		txtSearchOrder = new JTextField();
		txtSearchOrder.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				SwingUtilities.getRootPane(btnSearchOrder).setDefaultButton(btnSearchOrder);
			}
		});
		txtSearchOrder.setBounds(1220, 28, 200, 20);
		panelPerson.add(txtSearchOrder);
		txtSearchOrder.setColumns(10);
		
		JButton btnNewButton = new JButton("?Status aendern?");
		
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
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Auftrag aus.");
				}
			}
		});
		btnNewButton.setBounds(1615, 891, 140, 23);
		panelPerson.add(btnNewButton);
		
		JButton btnShowAllOrders = new JButton("Alle anzeigen");
		btnShowAllOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					DataBase.refreshOrder();				
			}
		});
		btnShowAllOrders.setBounds(960, 27, 120, 23);
		panelPerson.add(btnShowAllOrders);
		
		JLabel lblDetailsPerson = new JLabel("Details:");
		lblDetailsPerson.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDetailsPerson.setBounds(487, 68, 60, 14);
		panelPerson.add(lblDetailsPerson);
		
		JLabel lblDetailNamePerson = new JLabel("Name:");
		lblDetailNamePerson.setBounds(487, 93, 140, 14);
		panelPerson.add(lblDetailNamePerson);
		
		JLabel lblDetailVoramePerson = new JLabel("Vorname:");
		lblDetailVoramePerson.setBounds(487, 118, 140, 14);
		panelPerson.add(lblDetailVoramePerson);
		
		JLabel lblDetailTelefonnummerPerson = new JLabel("Telefonnummer:");
		lblDetailTelefonnummerPerson.setBounds(487, 143, 140, 14);
		panelPerson.add(lblDetailTelefonnummerPerson);
		
		JLabel lblDetailEmailPerson = new JLabel("Email:");
		lblDetailEmailPerson.setBounds(487, 168, 140, 14);
		panelPerson.add(lblDetailEmailPerson);
		
		JLabel lblDetailRollePerson = new JLabel("Rolle:");
		lblDetailRollePerson.setBounds(487, 193, 140, 14);
		panelPerson.add(lblDetailRollePerson);
		
		JLabel lblDetailStrassePerson = new JLabel("Stra\u00DFe:");
		lblDetailStrassePerson.setBounds(487, 218, 140, 14);
		panelPerson.add(lblDetailStrassePerson);
		
		JLabel lblDetailHausnummerPerson = new JLabel("Hausnummer:");
		lblDetailHausnummerPerson.setBounds(487, 243, 140, 14);
		panelPerson.add(lblDetailHausnummerPerson);
		
		JLabel lblDetailPlzPerson = new JLabel("PLZ:");
		lblDetailPlzPerson.setBounds(487, 268, 140, 14);
		panelPerson.add(lblDetailPlzPerson);
		
		JLabel lblDetailLandPerson = new JLabel("Land:");
		lblDetailLandPerson.setBounds(487, 293, 140, 14);
		panelPerson.add(lblDetailLandPerson);
		
		JLabel lblDetailOrtPerson = new JLabel("Ort:");
		lblDetailOrtPerson.setBounds(487, 318, 140, 14);
		panelPerson.add(lblDetailOrtPerson);
		
		txtDetailNamePerson = new JTextField();
		txtDetailNamePerson.setBounds(637, 90, 160, 20);
		panelPerson.add(txtDetailNamePerson);
		txtDetailNamePerson.setColumns(10);
		
		txtDetailVornamePerson = new JTextField();
		txtDetailVornamePerson.setBounds(637, 115, 160, 20);
		panelPerson.add(txtDetailVornamePerson);
		txtDetailVornamePerson.setColumns(10);
		
		txtDetailTelefonPerson = new JTextField();
		txtDetailTelefonPerson.setBounds(637, 140, 160, 20);
		panelPerson.add(txtDetailTelefonPerson);
		txtDetailTelefonPerson.setColumns(10);
		
		txtDetailMailPerson = new JTextField();
		txtDetailMailPerson.setBounds(637, 165, 160, 20);
		panelPerson.add(txtDetailMailPerson);
		txtDetailMailPerson.setColumns(10);
		
		txtDetailRollePerson = new JTextField();
		txtDetailRollePerson.setBounds(637, 190, 160, 20);
		panelPerson.add(txtDetailRollePerson);
		txtDetailRollePerson.setColumns(10);
		
		txtDetailStrassePerson = new JTextField();
		txtDetailStrassePerson.setBounds(637, 215, 160, 20);
		panelPerson.add(txtDetailStrassePerson);
		txtDetailStrassePerson.setColumns(10);
		
		txtDetailHausnummerPerson = new JTextField();
		txtDetailHausnummerPerson.setBounds(637, 240, 160, 20);
		panelPerson.add(txtDetailHausnummerPerson);
		txtDetailHausnummerPerson.setColumns(10);
		
		txtDetailPlzPerson = new JTextField();
		txtDetailPlzPerson.setBounds(637, 265, 160, 20);
		panelPerson.add(txtDetailPlzPerson);
		txtDetailPlzPerson.setColumns(10);
		
		txtDetailLandPerson = new JTextField();
		txtDetailLandPerson.setBounds(637, 290, 160, 20);
		panelPerson.add(txtDetailLandPerson);
		txtDetailLandPerson.setColumns(10);
		
		txtDetailOrtPerson = new JTextField();
		txtDetailOrtPerson.setBounds(637, 315, 160, 20);
		panelPerson.add(txtDetailOrtPerson);
		txtDetailOrtPerson.setColumns(10);
		
		JLabel label_1 = new JLabel("Details:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(1430, 70, 60, 14);
		panelPerson.add(label_1);
		
		JLabel lblTitel = new JLabel("Titel:");
		lblTitel.setBounds(1430, 93, 140, 14);
		panelPerson.add(lblTitel);
		
		JLabel lblArtDerFertigung = new JLabel("Art der Fertigung:");
		lblArtDerFertigung.setBounds(1430, 118, 140, 14);
		panelPerson.add(lblArtDerFertigung);
		
		JLabel lblDateiname = new JLabel("Dateiname:");
		lblDateiname.setBounds(1430, 143, 140, 14);
		panelPerson.add(lblDateiname);
		
		JLabel lblDateiort = new JLabel("Dateiort:");
		lblDateiort.setBounds(1430, 168, 140, 14);
		panelPerson.add(lblDateiort);
		
		JLabel lblPrognostizierteKosten = new JLabel("Prognostizierte Kosten:");
		lblPrognostizierteKosten.setBounds(1430, 193, 140, 14);
		panelPerson.add(lblPrognostizierteKosten);
		
		JLabel lblReelleKosten = new JLabel("Reelle Kosten:");
		lblReelleKosten.setBounds(1430, 218, 140, 14);
		panelPerson.add(lblReelleKosten);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(1430, 243, 140, 14);
		panelPerson.add(lblStatus);
		
		txtDetailPkOrder = new JTextField();
		txtDetailPkOrder.setBounds(1580, 190, 160, 20);
		panelPerson.add(txtDetailPkOrder);
		txtDetailPkOrder.setColumns(10);
		
		txtDetailDateiortOrder = new JTextField();
		txtDetailDateiortOrder.setBounds(1580, 165, 160, 20);
		panelPerson.add(txtDetailDateiortOrder);
		txtDetailDateiortOrder.setColumns(10);
		
		txtDetailDateinameOrder = new JTextField();
		txtDetailDateinameOrder.setBounds(1580, 140, 160, 20);
		panelPerson.add(txtDetailDateinameOrder);
		txtDetailDateinameOrder.setColumns(10);
		
		txtDetailAfOrder = new JTextField();
		txtDetailAfOrder.setBounds(1580, 115, 160, 20);
		panelPerson.add(txtDetailAfOrder);
		txtDetailAfOrder.setColumns(10);
		
		txtDetailTitelOrder = new JTextField();
		txtDetailTitelOrder.setBounds(1580, 90, 160, 20);
		panelPerson.add(txtDetailTitelOrder);
		txtDetailTitelOrder.setColumns(10);
		
		txtDetailRkOrder = new JTextField();
		txtDetailRkOrder.setBounds(1580, 215, 160, 20);
		panelPerson.add(txtDetailRkOrder);
		txtDetailRkOrder.setColumns(10);
		
		txtDetailStatusOrder = new JTextField();
		txtDetailStatusOrder.setBounds(1580, 240, 160, 20);
		panelPerson.add(txtDetailStatusOrder);
		txtDetailStatusOrder.setColumns(10);
		
		JLabel lblRolleDerPerson = new JLabel("Rolle der Person:");
		lblRolleDerPerson.setBounds(1430, 268, 140, 14);
		panelPerson.add(lblRolleDerPerson);
		
		txtDetailRolleOrder = new JTextField();
		txtDetailRolleOrder.setBounds(1580, 265, 160, 20);
		panelPerson.add(txtDetailRolleOrder);
		txtDetailRolleOrder.setColumns(10);
		
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
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Person aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Person aus.");
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
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine  aus.");
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
		tblKasse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DataBase.getConnection();
				int colnr  = MainMenu.tblKasse.getSelectedRow();
				DefaultTableModel modelTopf = new DefaultTableModel(new String[]{"ID_Topf", "Soll", "Ist"}, 0) {
					
					@Override
					public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
				String id = MainMenu.tblKasse.getModel().getValueAt(colnr, 0).toString();
				
			
				
				Statement stmtTopf = null;
				
					try {
						
						stmtTopf = DataBase.c.createStatement();
						System.out.println("Statement");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				String sqlTopf = "SELECT Topf.* FROM Topf INNER JOIN 'Mischtabelle-Kasse-Topf' on Topf.ID_Topf = 'Mischtabelle-Kasse-Topf'.ID_Topf where 'Mischtabelle-Kasse-Topf'.ID_Kasse ="+id+";";
				
				ResultSet rsTopf = null;
				
					try {
						rsTopf = stmtTopf.executeQuery(sqlTopf);
						System.out.println("Query executed");
						System.out.println(rsTopf);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				
				
				
				
					try {
						while(rsTopf.next())
						{
							String a1 = rsTopf.getString("ID_Topf");
						 
						    String c1 = rsTopf.getString("Soll");
						    String d1 = rsTopf.getString("Ist");
						    
						    
						 
						  
						    
						    modelTopf.addRow(new Object[]{a1,c1,d1});
						    
						    System.out.println("While done");
						    
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tblTopf.setModel(modelTopf);
				
				
				
				
				
				
				DataBase.closeConnection();
			}
		});
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
		tblTopf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DataBase.getConnection();
				int colnr  = MainMenu.tblTopf.getSelectedRow();
				DefaultTableModel modelRechnung = new DefaultTableModel(new String[]{"ID_Rechnung", "Rechnungsname", "Auftraggeber", "Betrag", "Beschreibung", "Bearbeiter", "Timestamp"}, 0) {
					
					@Override
					public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
				String id = MainMenu.tblTopf.getModel().getValueAt(colnr, 0).toString();
				
			
				
				Statement stmtRechnung = null;
				
					try {
						
						stmtRechnung = DataBase.c.createStatement();
						System.out.println("Statement");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				String sqlRechnung = "SELECT Rechnung.* FROM Rechnung INNER JOIN 'Mischtabelle-Topf-Rechnung' on Rechnung.ID_Rechnung = 'Mischtabelle-Topf-Rechnung'.ID_Rechnung where 'Mischtabelle-Topf-Rechnung'.ID_Topf ="+id+";";
				
				ResultSet rsRechnung = null;
				
					try {
						rsRechnung = stmtRechnung.executeQuery(sqlRechnung);
						System.out.println("Query executed");
						System.out.println(rsRechnung);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				
				
				
				
					try {
						while(rsRechnung.next())
						{
							String a1 = rsRechnung.getString("ID_Rechnung");
						    String b1 = rsRechnung.getString("Rechnungsname");
						    String c1 = rsRechnung.getString("Auftraggeber");
//						    String d1 = rsRechnung.getString("Bezahlung_Art");
						    String e1 = rsRechnung.getString("Betrag");
						    String f1 = rsRechnung.getString("Beschreibung");
						    String g1 = rsRechnung.getString("Bearbeiter");
						    String h1 = rsRechnung.getString("Timestamp");
						    
						    modelRechnung.addRow(new Object[]{a1, b1,c1, e1, f1, g1, h1});
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tblRechn.setModel(modelRechnung);
				
				
				
				
				
				
				DataBase.closeConnection();
			}
		});
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
					//n
					String oldSoll = null; 
					String oldIst = null; 
					String oldIdKasse = null; 
			
					
					int colnr = tblTopf.getSelectedRow();
					String idTopf = tblTopf.getModel().getValueAt(colnr, 0).toString();
					
					if (tblKasse.getSelectedRow() < 0 ) {
					 oldIdKasse = tblTopf.getModel().getValueAt(colnr, 1).toString();
					  oldSoll = tblTopf.getModel().getValueAt(colnr, 2).toString();
					 oldIst = tblTopf.getModel().getValueAt(colnr, 3).toString(); 
					} else {
						 oldSoll = tblTopf.getModel().getValueAt(colnr, 1).toString();
						 oldIst = tblTopf.getModel().getValueAt(colnr, 2).toString();
						 oldIdKasse = tblKasse.getModel().getValueAt(tblKasse.getSelectedRow(), 0).toString();
					}
					
					
				
					
					//n
					AlterTopf x = new AlterTopf(colnr, idTopf, oldIdKasse, oldSoll, oldIst);
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
					TopfRechnung x = new TopfRechnung();
					x.setVisible(true);
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Rechnung aus.");
				}
			}
		});
		btnRechnungZuTopf.setBounds(446, 252, 250, 23);
		panelFinanz.add(btnRechnungZuTopf);
		
		JButton btnNewButton_1 = new JButton("Alle anzeigen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				DataBase.refreshBill2();
				DataBase.refreshKasse();
				DataBase.refreshTopf();
			}
		});
		btnNewButton_1.setBounds(133, 2, 151, 23);
		panelFinanz.add(btnNewButton_1);
		
		JButton btnDeleteRechnungFromTopf = new JButton("Rechnung von Topf entfernen");
		btnDeleteRechnungFromTopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int colnrRechnung = MainMenu.tblRechn.getSelectedRow();
					String idRechnung = MainMenu.tblRechn.getModel().getValueAt(colnrRechnung, 0).toString();
					
					Finanzverwaltung.deleteBillFromTopf(Integer.parseInt(idRechnung));
					//DataBase.refreshBill2();
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
				String betrag = MainMenu.tblRechn.getModel().getValueAt(colnrRechnung, 3).toString();
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
		
		JButton btnAddToBill = new JButton("Auftrag einer Rechnung zuweisen");
		btnAddToBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int selectedRowIndexBills = MainMenu.tblBills.getSelectedRow();
				int selectedRowIndexOrders = MainMenu.tblAuftraegeRechnung.getSelectedRow();
		
				int id_Bill = Integer.parseInt(MainMenu.tblBills.getModel().getValueAt(selectedRowIndexBills, 0).toString());
				int id_Order =Integer.parseInt( MainMenu.tblAuftraegeRechnung.getModel().getValueAt(selectedRowIndexOrders, 0).toString());
				
				
				Finanzverwaltung.addOrderToBill(id_Order, id_Bill);
				DataBase.refreshOrderBill();
				DataBase.refreshOrdersInBill();
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Rechnung und einen Auftrag aus, der noch keiner Rechnung zugeordnet ist.");
				}
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
//		//String sqlOrderBill = "SELECT Auftrag.* FROM Auftrag INNER JOIN 'Mischtabelle-Rechnung-Auftrag' ON Auftrag.ID_Auftrag = 'Mischtabelle-Rechnung-Auftrag'.ID_Auftrag WHERE 'Mischtabelle-Rechnung-Auftrag'.ID_Rechnung like '" + idbill +"';";
//			String sqlOrderBill = "SELECT * FROM Auftrag";";
//			ResultSet rsOrderBill = stmt.executeQuery(sqlOrderBill);
//		
//		//String r = null;
//		//String sqlRolle = "SELECT Rolle FROM Mischtabelle-Person-Auftrag WHERE ID_Auftrag =" + r + ";";
//		
//		
//		while(rsOrderBill.next())
//		{
//			String a1 = rsOrderBill.getString("ID_Auftrag");
//		    String b1 = rsOrderBill.getString("Titel");
//		    String c1 = rsOrderBill.getString("AF");
//		    String d1 = rsOrderBill.getString("Dateiname");
//		    String e1 = rsOrderBill.getString("Dateiort");
//		    String f1 = rsOrderBill.getString("PK");
//		    String g1 = rsOrderBill.getString("RK");
//		    String h1 = DataBase.getStatusBeiAuftragId(a1);
//		    
//		    String j1 = DataBase.getRolleByOrderId(a1);
//		    //System.out.println(a1);
//		   // System.out.println(j1);
//		  
//		    
//		    modelOrderBill.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1, j1});
//		}
		
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
				int id_Bill = Integer.parseInt(MainMenu.tblOrdersInBill.getModel().getValueAt(colnr, 0).toString());
				Finanzverwaltung.deleteOrderFromBill(id_Bill);
				
				DataBase.getConnection();
				DataBase.refreshOrderBill();
				DataBase.refreshOrdersInBill();

				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Auftrag aus.");
				}finally {
					DataBase.closeConnection();
				}
			}
		});
		btnAuftragEntfernen.setBounds(787, 363, 162, 23);
		panelRechnung.add(btnAuftragEntfernen);
		
		JLabel lblAuftraege_1 = new JLabel("Auftraege:");
		lblAuftraege_1.setBounds(10, 17, 150, 14);
		panelRechnung.add(lblAuftraege_1);
		
		JLabel lblOrdersInThis = new JLabel("Auftr\u00E4ge in dieser Rechnung:");
		lblOrdersInThis.setBounds(494, 209, 455, 14);
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
									
									
									String sqlOrdersForBill = "SELECT Auftrag.* FROM Auftrag INNER JOIN 'Mischtabelle-Person-Auftrag' ON Auftrag.ID_Auftrag = 'Mischtabelle-Person-Auftrag'.ID_Auftrag where Auftrag.ID_Rechnung IS NULL AND 'Mischtabelle-Person-Auftrag'.ID_Person ="+auftraggeberID+";";
									
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
		
		JLabel lblBills = new JLabel("Rechnungen:");
		lblBills.setBounds(494, 17, 158, 14);
		panelRechnung.add(lblBills);
		
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
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Rechnung aus.");
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
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Rechnung aus. Bitte alle Auftraege entfernen!");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Rechnung aus.");
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
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie ein Bauteil aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie ein Bauteil aus.");
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
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie ein Bauteil aus.");
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
						JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Bauteil aus.");
					}
					
				}
			});
			btnKategorieverwaltung.setBounds(792, 388, 157, 23);
			panelBau.add(btnKategorieverwaltung);
			
			JButton btnShowAll = new JButton("Alle anzeigen");
			btnShowAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtSearchComponent.setText("");
					DataBase.refreshComponent();
					
				}
			});
			btnShowAll.setBounds(194, 22, 111, 23);
			panelBau.add(btnShowAll);
			
			JButton btnMengenverwaltung = new JButton("Mengenverwaltung");
			btnMengenverwaltung.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Mengenverwaltung x= new Mengenverwaltung();
						x.setVisible(true);
					} catch (ArrayIndexOutOfBoundsException ex) {
						JOptionPane.showMessageDialog(null, "Bitte wählen Sie ein Bauteil aus.");
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
						JOptionPane.showMessageDialog(null, "Bitte wählen Sie ein Bauteil aus.");
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
						JOptionPane.showMessageDialog(null, "Bitte wählen Sie ein Bauteil aus.");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie ein Bauteil aus.");
				}
				}
			});
			btnPreis.setBounds(315, 388, 104, 23);
			panelBau.add(btnPreis);
			
			Label label = new Label("Kategorien");
			label.setFont(new Font("Dialog", Font.BOLD, 20));
			label.setBounds(10, 28, 131, 22);
			panelBau.add(label);
			
			JLabel lblEingeloggtAls = new JLabel("eingeloggt als:");
			lblEingeloggtAls.setBounds(1500, 11, 140, 14);
			contentPane.add(lblEingeloggtAls);
			
			JButton btnAusloggen = new JButton("ausloggen");
			btnAusloggen.setBounds(1703, 7, 120, 23);
			contentPane.add(btnAusloggen);
		
		
		
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelPerson, btnHinzufuegen, btnLoeschen, txtSuchen, tabbedPane, lblNewLabel, scrollPane, tblPersonen, scrollPane_1, tblAuftraege, lblAuftraege, btnSuchen, btnSearchOrder, btnChangePerson, btnRefresh, btnErstellen, btnChangeOrder, btnDeleteOrder, txtSearchOrder, btnNewButton, panelFinanz, panelBau, panelOrders}));

		
		DataBase.closeConnection();
	}
	
	public void refresh() {
		
	}
}