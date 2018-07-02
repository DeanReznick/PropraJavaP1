package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Data.BauteileAuftragsabwicklung;
import Data.Calculations;
import Data.DataBase;
import Data.Finanzverwaltung;
import Data.OffenerAuftragObjektRAM;
import Data.OrderObjektRAM;
import Data.PersonObjektRAM;
import Data.PersonenFertigungsverwaltung;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTabbedPane;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTree;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JPanel contentPane;
	public static JTextField txtSearchPerson;
	private JTextField txtSearchOrder;
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
	private JTextField txtSearchComponent;
	private JTextField txtDetailNameComponent;
	private JTextField txtDetailLinkComponent;
	private JTextField txtDetailStockComponent;
	private JTextField txtDetailOrderedComponent;
	private JTextField txtDetailPlannedComponent;
	private JTextField txtDetailLocationComponent;
	private JTextField txtDetailPriceComponent;
	public static JTable tblPersonen;
	public static JTable tblAuftraege;
	public static JTable tblComponents;
	public static JTable tblKasse;
	public static JTable tblTopf;
	public static JTable tblOffeneAuftraege;
	public static JScrollPane scrollPanePerson;
	public static JScrollPane scrollPaneOrder;
	public static JScrollPane scrollPaneCategory;
	public static JScrollPane scrollPaneComponent;
	private boolean hdResolution;
	public static JTree treeCategory;
	private JTable tblRechn;
	private JTextField txtKasseNr;
	private JTextField txtKasseSoll;
	private JTextField txtKasseIst;
	private JTextField txtTopfSoll;
	private JTextField txtTopfIst;
	

	


	public MainMenu() throws SQLException {
		DataBase.getConnection();
		setTitle("eLab");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(dim);
		if (dim.getHeight() == 1080 && dim.getWidth() == 1920) {
			hdResolution = true;
		} else {
			hdResolution = false;
		}
		setSize((int) dim.getWidth(), (int) dim.getHeight() - 20);
//		setSize(1600, 900);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		//1920 x 1080
		
		int[] frameWidths = Calculations.calculateFrameWidths(dim.getWidth(), dim.getHeight());
		int[] frameHeights = Calculations.calculateFrameHeights(dim.getWidth(), dim.getHeight());
		int[] panelWidths = Calculations.calculatePanelWidths(dim.getWidth(), dim.getHeight());
		int[] panelHeights = Calculations.calculatePanelHeights(dim.getWidth(), dim.getHeight());
//		if (hdResolution = false) {
		gbl_contentPane.columnWidths = frameWidths;
		gbl_contentPane.rowHeights = frameHeights;
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0};
//		} else {
//			gbl_contentPane.columnWidths = new int[]{20, 1680, 110, 110};
//			gbl_contentPane.rowHeights = new int[]{13, 1054, 13};
//			gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0};
//			gbl_contentPane.rowWeights = new double[]{0.0, 1.0};
//		}
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEingeloggtAls = new JLabel("eingeloggt, als:" + GUILogin.vorname_signedIn + " " + GUILogin.name_signedIn);
		GridBagConstraints gbc_lblEingeloggtAls = new GridBagConstraints();
		gbc_lblEingeloggtAls.insets = new Insets(0, 0, 5, 5);
		gbc_lblEingeloggtAls.gridx = 2;
		gbc_lblEingeloggtAls.gridy = 0;
		contentPane.add(lblEingeloggtAls, gbc_lblEingeloggtAls);
		
		JButton btnAusloggen = new JButton("ausloggen");
		btnAusloggen.setBackground(Color.RED);
		GridBagConstraints gbc_btnAusloggen = new GridBagConstraints();
		gbc_btnAusloggen.insets = new Insets(0, 0, 5, 0);
		gbc_btnAusloggen.gridx = 3;
		gbc_btnAusloggen.gridy = 0;
		contentPane.add(btnAusloggen, gbc_btnAusloggen);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 1;
		gbc_tabbedPane.gridy = 1;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		
		JPanel panelPerson = new JPanel();
		tabbedPane.addTab("Personen & Fertigungsverwaltung", null, panelPerson, null);
		GridBagLayout gbl_panelPerson = new GridBagLayout();
//		if (hdResolution = false) {
		gbl_panelPerson.columnWidths = panelWidths;
		gbl_panelPerson.rowHeights = new int[]{0, 10, 30, 60, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 60, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_panelPerson.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelPerson.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		} else {
//			gbl_panelPerson.columnWidths = new int[]{12, 207, 207, 207, 207, 12, 207, 207, 207, 207};
//			gbl_panelPerson.rowHeights = new int[]{0, 10, 30, 60, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 60, 30, 30, 30, 30, 30, 30, 30, 30, 30};
//			gbl_panelPerson.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
//			gbl_panelPerson.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		}
		panelPerson.setLayout(gbl_panelPerson);
		
		JLabel lblPersonen = new JLabel("Personen:");
		GridBagConstraints gbc_lblPersonen = new GridBagConstraints();
		gbc_lblPersonen.insets = new Insets(0, 0, 5, 5);
		gbc_lblPersonen.gridx = 1;
		gbc_lblPersonen.gridy = 1;
		panelPerson.add(lblPersonen, gbc_lblPersonen);
		
		JLabel lblAuftrge = new JLabel("Auft‰ge:");
		GridBagConstraints gbc_lblAuftrge = new GridBagConstraints();
		gbc_lblAuftrge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuftrge.gridx = 6;
		gbc_lblAuftrge.gridy = 1;
		panelPerson.add(lblAuftrge, gbc_lblAuftrge);
		
		JButton btnShowAllPersons = new JButton("Alle anzeigen");
		btnShowAllPersons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataBase.refreshPersonen();
			}
		});
		GridBagConstraints gbc_btnShowAllPersons = new GridBagConstraints();
		gbc_btnShowAllPersons.anchor = GridBagConstraints.WEST;
		gbc_btnShowAllPersons.insets = new Insets(0, 0, 5, 5);
		gbc_btnShowAllPersons.gridx = 1;
		gbc_btnShowAllPersons.gridy = 2;
		panelPerson.add(btnShowAllPersons, gbc_btnShowAllPersons);
		
		txtSearchPerson = new JTextField();
		GridBagConstraints gbc_txtSearchPerson = new GridBagConstraints();
		gbc_txtSearchPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtSearchPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearchPerson.gridx = 3;
		gbc_txtSearchPerson.gridy = 2;
		panelPerson.add(txtSearchPerson, gbc_txtSearchPerson);
		txtSearchPerson.setColumns(1);
		
		JButton btnSearchPerson = new JButton("Suchen");
		btnSearchPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBase.searchPerson(txtSearchPerson.getText());
			}
		});
		GridBagConstraints gbc_btnSearchPerson = new GridBagConstraints();
		gbc_btnSearchPerson.anchor = GridBagConstraints.EAST;
		gbc_btnSearchPerson.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchPerson.gridx = 4;
		gbc_btnSearchPerson.gridy = 2;
		panelPerson.add(btnSearchPerson, gbc_btnSearchPerson);
		
		JButton btnShowAllOrders = new JButton("Alle anzeigen");
		btnShowAllOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBase.refreshOrder();
			}
		});
		GridBagConstraints gbc_btnShowAllOrders = new GridBagConstraints();
		gbc_btnShowAllOrders.anchor = GridBagConstraints.WEST;
		gbc_btnShowAllOrders.insets = new Insets(0, 0, 5, 5);
		gbc_btnShowAllOrders.gridx = 6;
		gbc_btnShowAllOrders.gridy = 2;
		panelPerson.add(btnShowAllOrders, gbc_btnShowAllOrders);
		
		txtSearchOrder = new JTextField();
		GridBagConstraints gbc_txtSearchOrder = new GridBagConstraints();
		gbc_txtSearchOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtSearchOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearchOrder.gridx = 8;
		gbc_txtSearchOrder.gridy = 2;
		panelPerson.add(txtSearchOrder, gbc_txtSearchOrder);
		txtSearchOrder.setColumns(1);
		
		JButton btnSearchOrder = new JButton("Suchen");
		btnSearchOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBase.searchOrder(txtSearchOrder.getText());
			}
		});
		GridBagConstraints gbc_btnSearchOrder = new GridBagConstraints();
		gbc_btnSearchOrder.anchor = GridBagConstraints.EAST;
		gbc_btnSearchOrder.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchOrder.gridx = 9;
		gbc_btnSearchOrder.gridy = 2;
		panelPerson.add(btnSearchOrder, gbc_btnSearchOrder);
		
		scrollPanePerson = new JScrollPane();
		GridBagConstraints gbc_scrollPanePerson = new GridBagConstraints();
		gbc_scrollPanePerson.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPanePerson.fill = GridBagConstraints.BOTH;
		gbc_scrollPanePerson.gridx = 1;
		gbc_scrollPanePerson.gridy = 3;
		gbc_scrollPanePerson.gridwidth = 4;
		gbc_scrollPanePerson.gridheight = 13;
		panelPerson.add(scrollPanePerson, gbc_scrollPanePerson);
		
		String[] column_headers = {"Name", "Vorname", "Email"};
		String[][] data = new String[1000][11];
				
		tblPersonen = new JTable(data, column_headers);
		tblPersonen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DataBase.getConnection();
				int colnr  = tblPersonen.getSelectedRow();
				
				String personName = tblPersonen.getModel().getValueAt(colnr, 1).toString();
				String personVorname = tblPersonen.getModel().getValueAt(colnr, 2).toString();
				String fullName = personVorname + " " + personName;
				
				DataBase.searchOrder(fullName);
				
				PersonObjektRAM clicked = new PersonObjektRAM();
				String mail = tblPersonen.getModel().getValueAt(colnr, 3).toString();
				
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
				txtDetailStrassePerson.setText(clicked.getStraﬂe());
				txtDetailHausnummerPerson.setText(clicked.getHausnummer());
				txtDetailPlzPerson.setText(Integer.toString(clicked.getPlz()));
				txtDetailOrtPerson.setText(clicked.getOrt());
				txtDetailLandPerson.setText(clicked.getLand());
				DataBase.closeConnection();
			}
		});
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID_Person", "Name", "Vorname", "Email"}, 0) {
		
			private static final long serialVersionUID = -5816265151840752378L;

		@Override
		public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		try {
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
		    String straﬂe = rs.getString("Straﬂe");
		    String hausnummer = rs.getString("Hausnummer");
		    String plz = rs.getString("PLZ");
		    String ort = rs.getString("Ort");
		    String land = rs.getString("Land");
		    String passwort = rs.getString("Passwort");
		    String timestamp = rs.getString("Timestamp");
		    
		    PersonObjektRAM person = new PersonObjektRAM( Integer.parseInt(idPerson), name, telefonnummer,  mail, timestamp, rolle,  passwort,  land,  straﬂe,ort, Integer.parseInt(plz), hausnummer,vorname);  
		    DataBase.people.add(person);
		    
		    model.addRow(new Object[]{idPerson, name, vorname, mail});
		}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Fehler im Programm!");
		}
		
		tblPersonen.setModel(model);
				
		scrollPanePerson.setViewportView(tblPersonen);
		TableColumnModel tcm = tblPersonen.getColumnModel();
		tcm.removeColumn( tcm.getColumn(0) );
		
		scrollPaneOrder = new JScrollPane();
		GridBagConstraints gbc_scrollPaneOrder = new GridBagConstraints();
		gbc_scrollPaneOrder.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneOrder.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneOrder.gridx = 6;
		gbc_scrollPaneOrder.gridy = 3;
		gbc_scrollPaneOrder.gridwidth = 4;
		gbc_scrollPaneOrder.gridheight = 13;
		panelPerson.add(scrollPaneOrder, gbc_scrollPaneOrder);
		
		tblAuftraege = new JTable();
		scrollPaneOrder.setViewportView(tblAuftraege);
		
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
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			try {
		String sqlAuftrag = "SELECT * FROM Auftrag";
		Statement stmt = DataBase.c.createStatement();
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
		    
//		    String rolle = DataBase.getRolleByOrderId(idAuftrag);
		    
		    OrderObjektRAM order = new OrderObjektRAM( Integer.parseInt(idAuftrag), titel, af,  dateiname, dateiort, pk,  rk); 
		    DataBase.orders.add(order);
		    
		    modelAuftrag.addRow(new Object[]{idAuftrag, titel, status});
		}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Fehler im Programm!");
			}
		
		tblAuftraege.setModel(modelAuftrag);
		TableColumnModel tcm2 = tblAuftraege.getColumnModel();
		tcm.removeColumn( tcm2.getColumn(0) );
				
		scrollPaneOrder.setViewportView(tblAuftraege);
		
		JButton btnNewPerson = new JButton("Neue Person");
		btnNewPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPerson x = new AddPerson();
				x.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewPerson = new GridBagConstraints();
		gbc_btnNewPerson.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewPerson.gridx = 1;
		gbc_btnNewPerson.gridy = 16;
		panelPerson.add(btnNewPerson, gbc_btnNewPerson);
		
		JButton btnDeletePerson = new JButton("Person loeschen");
		btnDeletePerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tblPersonen.getModel();
				//get selected row index
				int selectedRowIndex = tblPersonen.getSelectedRow();
				if (selectedRowIndex >= 0) {
				try {
				Delete x = new Delete();
				x.setVisible(true);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Bitte w‰hlen Sie eine Person aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte w‰hlen Sie eine Person aus.");
			}
			}
		});
		GridBagConstraints gbc_btnDeletePerson = new GridBagConstraints();
		gbc_btnDeletePerson.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeletePerson.gridx = 4;
		gbc_btnDeletePerson.gridy = 16;
		panelPerson.add(btnDeletePerson, gbc_btnDeletePerson);
		
		JButton btnCreateOrder = new JButton("Auftrag erstellen");
		btnCreateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewOrder x = new NewOrder();
				x.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCreateOrder = new GridBagConstraints();
		gbc_btnCreateOrder.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateOrder.gridx = 6;
		gbc_btnCreateOrder.gridy = 16;
		panelPerson.add(btnCreateOrder, gbc_btnCreateOrder);
		
		JButton btnDeleteOrder = new JButton("Auftrag loeschen");
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
					JOptionPane.showMessageDialog(null, "Bitte w‰hlen Sie einen Auftrag aus.");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Bitte w‰hlen Sie eine Auftrag aus.");
			}
			}
		});
		GridBagConstraints gbc_btnDeleteOrder = new GridBagConstraints();
		gbc_btnDeleteOrder.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteOrder.gridx = 9;
		gbc_btnDeleteOrder.gridy = 16;
		panelPerson.add(btnDeleteOrder, gbc_btnDeleteOrder);
		
		JLabel lblDetailsPerson = new JLabel("Details:");
		lblDetailsPerson.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblDetailsPerson = new GridBagConstraints();
		gbc_lblDetailsPerson.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetailsPerson.gridx = 1;
		gbc_lblDetailsPerson.gridy = 18;
		panelPerson.add(lblDetailsPerson, gbc_lblDetailsPerson);
		
		JLabel lblDetailsOrder = new JLabel("Details:");
		lblDetailsOrder.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblDetailsOrder = new GridBagConstraints();
		gbc_lblDetailsOrder.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetailsOrder.gridx = 6;
		gbc_lblDetailsOrder.gridy = 18;
		panelPerson.add(lblDetailsOrder, gbc_lblDetailsOrder);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 19;
		panelPerson.add(lblName, gbc_lblName);
		
		txtDetailNamePerson = new JTextField();
		GridBagConstraints gbc_txtDetailNamePerson = new GridBagConstraints();
		gbc_txtDetailNamePerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailNamePerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailNamePerson.gridx = 2;
		gbc_txtDetailNamePerson.gridy = 19;
		panelPerson.add(txtDetailNamePerson, gbc_txtDetailNamePerson);
		txtDetailNamePerson.setColumns(1);
		
		JLabel lblVorname = new JLabel("Vorname:");
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname.gridx = 3;
		gbc_lblVorname.gridy = 19;
		panelPerson.add(lblVorname, gbc_lblVorname);
		
		txtDetailVornamePerson = new JTextField();
		GridBagConstraints gbc_txtDetailVornamePerson = new GridBagConstraints();
		gbc_txtDetailVornamePerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailVornamePerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailVornamePerson.gridx = 4;
		gbc_txtDetailVornamePerson.gridy = 19;
		panelPerson.add(txtDetailVornamePerson, gbc_txtDetailVornamePerson);
		txtDetailVornamePerson.setColumns(1);
		
		JLabel lblTitel = new JLabel("Titel:");
		GridBagConstraints gbc_lblTitel = new GridBagConstraints();
		gbc_lblTitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitel.gridx = 6;
		gbc_lblTitel.gridy = 19;
		panelPerson.add(lblTitel, gbc_lblTitel);
		
		txtDetailTitelOrder = new JTextField();
		GridBagConstraints gbc_txtDetailTitelOrder = new GridBagConstraints();
		gbc_txtDetailTitelOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailTitelOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailTitelOrder.gridx = 7;
		gbc_txtDetailTitelOrder.gridy = 19;
		panelPerson.add(txtDetailTitelOrder, gbc_txtDetailTitelOrder);
		txtDetailTitelOrder.setColumns(1);
		
		JLabel lblArtDerFertigung = new JLabel("Art der Fertigung:");
		GridBagConstraints gbc_lblArtDerFertigung = new GridBagConstraints();
		gbc_lblArtDerFertigung.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtDerFertigung.gridx = 8;
		gbc_lblArtDerFertigung.gridy = 19;
		panelPerson.add(lblArtDerFertigung, gbc_lblArtDerFertigung);
		
				txtDetailAfOrder = new JTextField();
				GridBagConstraints gbc_txtDetailAfOrder = new GridBagConstraints();
				gbc_txtDetailAfOrder.insets = new Insets(0, 0, 5, 5);
				gbc_txtDetailAfOrder.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDetailAfOrder.gridx = 9;
				gbc_txtDetailAfOrder.gridy = 19;
				panelPerson.add(txtDetailAfOrder, gbc_txtDetailAfOrder);
				txtDetailAfOrder.setColumns(1);
		
		JLabel lblTelefonnummer = new JLabel("Telefonnummer:");
		GridBagConstraints gbc_lblTelefonnummer = new GridBagConstraints();
		gbc_lblTelefonnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefonnummer.gridx = 1;
		gbc_lblTelefonnummer.gridy = 20;
		panelPerson.add(lblTelefonnummer, gbc_lblTelefonnummer);
		
		txtDetailTelefonPerson = new JTextField();
		GridBagConstraints gbc_txtDetailTelefonPerson = new GridBagConstraints();
		gbc_txtDetailTelefonPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailTelefonPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailTelefonPerson.gridx = 2;
		gbc_txtDetailTelefonPerson.gridy = 20;
		panelPerson.add(txtDetailTelefonPerson, gbc_txtDetailTelefonPerson);
		txtDetailTelefonPerson.setColumns(1);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 3;
		gbc_lblEmail.gridy = 20;
		panelPerson.add(lblEmail, gbc_lblEmail);
		
		txtDetailMailPerson = new JTextField();
		GridBagConstraints gbc_txtDetailMailPerson = new GridBagConstraints();
		gbc_txtDetailMailPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailMailPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailMailPerson.gridx = 4;
		gbc_txtDetailMailPerson.gridy = 20;
		panelPerson.add(txtDetailMailPerson, gbc_txtDetailMailPerson);
		txtDetailMailPerson.setColumns(1);
		
		JLabel lblDateiname = new JLabel("Dateiname:");
		GridBagConstraints gbc_lblDateiname = new GridBagConstraints();
		gbc_lblDateiname.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateiname.gridx = 6;
		gbc_lblDateiname.gridy = 20;
		panelPerson.add(lblDateiname, gbc_lblDateiname);
		
		txtDetailDateinameOrder = new JTextField();
		GridBagConstraints gbc_txtDetailDateinameOrder = new GridBagConstraints();
		gbc_txtDetailDateinameOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailDateinameOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailDateinameOrder.gridx = 7;
		gbc_txtDetailDateinameOrder.gridy = 20;
		panelPerson.add(txtDetailDateinameOrder, gbc_txtDetailDateinameOrder);
		txtDetailDateinameOrder.setColumns(1);
		
		JLabel lblOrderDateiort = new JLabel("Dateiort:");
		GridBagConstraints gbc_lblOrderDateiort = new GridBagConstraints();
		gbc_lblOrderDateiort.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrderDateiort.gridx = 8;
		gbc_lblOrderDateiort.gridy = 20;
		panelPerson.add(lblOrderDateiort, gbc_lblOrderDateiort);
		
		txtDetailDateiortOrder = new JTextField();
		GridBagConstraints gbc_txtDetailDateiortOrder = new GridBagConstraints();
		gbc_txtDetailDateiortOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailDateiortOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailDateiortOrder.gridx = 9;
		gbc_txtDetailDateiortOrder.gridy = 20;
		panelPerson.add(txtDetailDateiortOrder, gbc_txtDetailDateiortOrder);
		txtDetailDateiortOrder.setColumns(1);
		
		JLabel lblRolle = new JLabel("Rolle:");
		GridBagConstraints gbc_lblRolle = new GridBagConstraints();
		gbc_lblRolle.insets = new Insets(0, 0, 5, 5);
		gbc_lblRolle.gridx = 1;
		gbc_lblRolle.gridy = 21;
		panelPerson.add(lblRolle, gbc_lblRolle);
		
		txtDetailRollePerson = new JTextField();
		GridBagConstraints gbc_txtDetailRollePerson = new GridBagConstraints();
		gbc_txtDetailRollePerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailRollePerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailRollePerson.gridx = 2;
		gbc_txtDetailRollePerson.gridy = 21;
		panelPerson.add(txtDetailRollePerson, gbc_txtDetailRollePerson);
		txtDetailRollePerson.setColumns(1);
		
		JLabel lblStrae = new JLabel("Stra\u00DFe:");
		GridBagConstraints gbc_lblStrae = new GridBagConstraints();
		gbc_lblStrae.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrae.gridx = 3;
		gbc_lblStrae.gridy = 21;
		panelPerson.add(lblStrae, gbc_lblStrae);
		
		txtDetailStrassePerson = new JTextField();
		GridBagConstraints gbc_txtDetailStrassePerson = new GridBagConstraints();
		gbc_txtDetailStrassePerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailStrassePerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailStrassePerson.gridx = 4;
		gbc_txtDetailStrassePerson.gridy = 21;
		panelPerson.add(txtDetailStrassePerson, gbc_txtDetailStrassePerson);
		txtDetailStrassePerson.setColumns(1);
		
		JLabel lblPrognostizierteKosten = new JLabel("Prognostizierte Kosten:");
		GridBagConstraints gbc_lblPrognostizierteKosten = new GridBagConstraints();
		gbc_lblPrognostizierteKosten.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrognostizierteKosten.gridx = 6;
		gbc_lblPrognostizierteKosten.gridy = 21;
		panelPerson.add(lblPrognostizierteKosten, gbc_lblPrognostizierteKosten);
		
		txtDetailPkOrder = new JTextField();
		GridBagConstraints gbc_txtDetailPkOrder = new GridBagConstraints();
		gbc_txtDetailPkOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailPkOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailPkOrder.gridx = 7;
		gbc_txtDetailPkOrder.gridy = 21;
		panelPerson.add(txtDetailPkOrder, gbc_txtDetailPkOrder);
		txtDetailPkOrder.setColumns(1);
		
		JLabel lblReelleKosten = new JLabel("Reelle Kosten:");
		GridBagConstraints gbc_lblReelleKosten = new GridBagConstraints();
		gbc_lblReelleKosten.insets = new Insets(0, 0, 5, 5);
		gbc_lblReelleKosten.gridx = 8;
		gbc_lblReelleKosten.gridy = 21;
		panelPerson.add(lblReelleKosten, gbc_lblReelleKosten);
		
		txtDetailRkOrder = new JTextField();
		GridBagConstraints gbc_txtDetailRkOrder = new GridBagConstraints();
		gbc_txtDetailRkOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailRkOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailRkOrder.gridx = 9;
		gbc_txtDetailRkOrder.gridy = 21;
		panelPerson.add(txtDetailRkOrder, gbc_txtDetailRkOrder);
		txtDetailRkOrder.setColumns(1);
		
		JLabel lblHausnummer = new JLabel("Hausnummer:");
		GridBagConstraints gbc_lblHausnummer = new GridBagConstraints();
		gbc_lblHausnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblHausnummer.gridx = 1;
		gbc_lblHausnummer.gridy = 22;
		panelPerson.add(lblHausnummer, gbc_lblHausnummer);
		
		txtDetailHausnummerPerson = new JTextField();
		GridBagConstraints gbc_txtDetailHausnummerPerson = new GridBagConstraints();
		gbc_txtDetailHausnummerPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailHausnummerPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailHausnummerPerson.gridx = 2;
		gbc_txtDetailHausnummerPerson.gridy = 22;
		panelPerson.add(txtDetailHausnummerPerson, gbc_txtDetailHausnummerPerson);
		txtDetailHausnummerPerson.setColumns(1);
		
		JLabel lblPlz = new JLabel("PLZ:");
		GridBagConstraints gbc_lblPlz = new GridBagConstraints();
		gbc_lblPlz.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlz.gridx = 3;
		gbc_lblPlz.gridy = 22;
		panelPerson.add(lblPlz, gbc_lblPlz);
		
		txtDetailPlzPerson = new JTextField();
		GridBagConstraints gbc_txtDetailPlzPerson = new GridBagConstraints();
		gbc_txtDetailPlzPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailPlzPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailPlzPerson.gridx = 4;
		gbc_txtDetailPlzPerson.gridy = 22;
		panelPerson.add(txtDetailPlzPerson, gbc_txtDetailPlzPerson);
		txtDetailPlzPerson.setColumns(1);
		
		JLabel lblStatus = new JLabel("Status:");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 6;
		gbc_lblStatus.gridy = 22;
		panelPerson.add(lblStatus, gbc_lblStatus);
		
		txtDetailStatusOrder = new JTextField();
		GridBagConstraints gbc_txtDetailStatusOrder = new GridBagConstraints();
		gbc_txtDetailStatusOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailStatusOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailStatusOrder.gridx = 7;
		gbc_txtDetailStatusOrder.gridy = 22;
		panelPerson.add(txtDetailStatusOrder, gbc_txtDetailStatusOrder);
		txtDetailStatusOrder.setColumns(1);
		
		JLabel lblRolleDerPerson = new JLabel("Rolle der Person:");
		GridBagConstraints gbc_lblRolleDerPerson = new GridBagConstraints();
		gbc_lblRolleDerPerson.insets = new Insets(0, 0, 5, 5);
		gbc_lblRolleDerPerson.gridx = 8;
		gbc_lblRolleDerPerson.gridy = 22;
		panelPerson.add(lblRolleDerPerson, gbc_lblRolleDerPerson);
		
		txtDetailRolleOrder = new JTextField();
		GridBagConstraints gbc_txtDetailRolleOrder = new GridBagConstraints();
		gbc_txtDetailRolleOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailRolleOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailRolleOrder.gridx = 9;
		gbc_txtDetailRolleOrder.gridy = 22;
		panelPerson.add(txtDetailRolleOrder, gbc_txtDetailRolleOrder);
		txtDetailRolleOrder.setColumns(1);
		
		JLabel lblStadt = new JLabel("Stadt:");
		GridBagConstraints gbc_lblStadt = new GridBagConstraints();
		gbc_lblStadt.insets = new Insets(0, 0, 5, 5);
		gbc_lblStadt.gridx = 1;
		gbc_lblStadt.gridy = 23;
		panelPerson.add(lblStadt, gbc_lblStadt);
		
		txtDetailOrtPerson = new JTextField();
		GridBagConstraints gbc_txtDetailOrtPerson = new GridBagConstraints();
		gbc_txtDetailOrtPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailOrtPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailOrtPerson.gridx = 2;
		gbc_txtDetailOrtPerson.gridy = 23;
		panelPerson.add(txtDetailOrtPerson, gbc_txtDetailOrtPerson);
		txtDetailOrtPerson.setColumns(1);
		
		JLabel lblLand = new JLabel("Land:");
		GridBagConstraints gbc_lblLand = new GridBagConstraints();
		gbc_lblLand.insets = new Insets(0, 0, 5, 5);
		gbc_lblLand.gridx = 3;
		gbc_lblLand.gridy = 23;
		panelPerson.add(lblLand, gbc_lblLand);
		
		txtDetailLandPerson = new JTextField();
		GridBagConstraints gbc_txtDetailLandPerson = new GridBagConstraints();
		gbc_txtDetailLandPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailLandPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailLandPerson.gridx = 4;
		gbc_txtDetailLandPerson.gridy = 23;
		panelPerson.add(txtDetailLandPerson, gbc_txtDetailLandPerson);
		txtDetailLandPerson.setColumns(1);
		
		JButton btnSaveOrder = new JButton("Speichern");
		btnSaveOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
//					DataBase.getConnection();
					
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
						
						
//						Manager.checkStandardOrderUpdate(headerNew, afNew, filenameNew, repositoryNew, pkNew, rkNew);
						
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
//						DataBase.closeConnection();
						
						
					} catch (ArrayIndexOutOfBoundsException ex) {
						JOptionPane.showMessageDialog(null, "Bitte w‰hlen Sie eine Person und einen Auftrag aus.");
					} 
//					catch (InvalidArgumentsException e) {
//						
//					}
			}
		});
		GridBagConstraints gbc_btnSaveOrder = new GridBagConstraints();
		gbc_btnSaveOrder.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveOrder.gridx = 9;
		gbc_btnSaveOrder.gridy = 23;
		panelPerson.add(btnSaveOrder, gbc_btnSaveOrder);
		
		JButton btnSavePerson = new JButton("Speichern");
		btnSavePerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					String oldStr = clicked.getStraﬂe();
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
					JOptionPane.showMessageDialog(null, "Bitte w‰hlen Sie eine Person aus.");
				} finally {
					DataBase.closeConnection();
				}
			}
		});
		GridBagConstraints gbc_btnSavePerson = new GridBagConstraints();
		gbc_btnSavePerson.insets = new Insets(0, 0, 5, 5);
		gbc_btnSavePerson.gridx = 4;
		gbc_btnSavePerson.gridy = 24;
		panelPerson.add(btnSavePerson, gbc_btnSavePerson);
		
		JPanel panelBauteil = new JPanel();
		tabbedPane.addTab("Bauteileverwaltung", null, panelBauteil, null);
		GridBagLayout gbl_panelBauteil = new GridBagLayout();
		gbl_panelBauteil.columnWidths = new int[]{10, 300, 10, 150, 150, 150, 100, 100, 100, 300, 100, 50, 10};
		gbl_panelBauteil.rowHeights = new int[]{10, 20, 20, 600, 20, 20, 20, 20, 20, 20, 20, 20};
		gbl_panelBauteil.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0};
		gbl_panelBauteil.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelBauteil.setLayout(gbl_panelBauteil);
		//		gbl_contentPane.columnWidths = new int[]{20, 1680, 110, 110};
		//		gbl_contentPane.rowHeights = new int[]{13, 1054, 13};
				
				JLabel lblKategorien = new JLabel("Kategorien:");
				GridBagConstraints gbc_lblKategorien = new GridBagConstraints();
				gbc_lblKategorien.insets = new Insets(0, 0, 5, 5);
				gbc_lblKategorien.gridx = 1;
				gbc_lblKategorien.gridy = 1;
				panelBauteil.add(lblKategorien, gbc_lblKategorien);
				
				JLabel lblBauteile = new JLabel("Bauteile:");
				GridBagConstraints gbc_lblBauteile = new GridBagConstraints();
				gbc_lblBauteile.insets = new Insets(0, 0, 5, 5);
				gbc_lblBauteile.gridx = 3;
				gbc_lblBauteile.gridy = 1;
				panelBauteil.add(lblBauteile, gbc_lblBauteile);
				
				scrollPaneCategory = new JScrollPane();
				GridBagConstraints gbc_scrollPaneCategory = new GridBagConstraints();
				gbc_scrollPaneCategory.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPaneCategory.fill = GridBagConstraints.BOTH;
				gbc_scrollPaneCategory.gridx = 1;
				gbc_scrollPaneCategory.gridy = 2;
				gbc_scrollPaneCategory.gridwidth = 1;
				gbc_scrollPaneCategory.gridheight = 2;
				panelBauteil.add(scrollPaneCategory, gbc_scrollPaneCategory);
				
				txtSearchComponent = new JTextField();
				GridBagConstraints gbc_txtSearchComponent = new GridBagConstraints();
				gbc_txtSearchComponent.anchor = GridBagConstraints.NORTH;
				gbc_txtSearchComponent.insets = new Insets(0, 0, 5, 5);
				gbc_txtSearchComponent.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtSearchComponent.gridx = 10;
				gbc_txtSearchComponent.gridy = 2;
				panelBauteil.add(txtSearchComponent, gbc_txtSearchComponent);
				txtSearchComponent.setColumns(10);
				
				JButton btnSearchComponent = new JButton("Suchen");
				GridBagConstraints gbc_btnSearchComponent = new GridBagConstraints();
				gbc_btnSearchComponent.insets = new Insets(0, 0, 5, 5);
				gbc_btnSearchComponent.gridx = 11;
				gbc_btnSearchComponent.gridy = 2;
				panelBauteil.add(btnSearchComponent, gbc_btnSearchComponent);
				
				scrollPaneComponent = new JScrollPane();
				GridBagConstraints gbc_scrollPaneComponent = new GridBagConstraints();
				gbc_scrollPaneComponent.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPaneComponent.fill = GridBagConstraints.BOTH;
				gbc_scrollPaneComponent.gridx = 3;
				gbc_scrollPaneComponent.gridy = 3;
				gbc_scrollPaneComponent.gridwidth = 9;
				gbc_scrollPaneComponent.gridheight = 1;
				panelBauteil.add(scrollPaneComponent, gbc_scrollPaneComponent);
				
				String[] column_headers_component = {"Name", "Menge lagernd", "Preis"};
				String[][] data_components = new String[1000][8];
				tblComponents = new JTable(data_components, column_headers_component);
//				DefaultTableModel modelComponents = new DefaultTableModel(new String[]{"ID Bauteil", "Name","Link", "Menge lagernd", "Menge bestellt", "Menge geplant", "Lagerort", "Preis"}, 0) {
				DefaultTableModel modelComponents = new DefaultTableModel(new String[]{"ID Bauteil", "Name", "Menge lagernd", "Preis"}, 0) {
					
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
					    String d1 = rsComponent.getString("MengeLagernd");
					    int id = Integer.parseInt(a1);
					    
					    String h1 = BauteileAuftragsabwicklung.getComponentPrice(id);
					    
					    
					 
					  
					    
					    modelComponents.addRow(new Object[]{a1, b1,d1,h1});
					}
					
					tblComponents.setModel(modelComponents);
					TableColumnModel tcmComponents = MainMenu.tblComponents.getColumnModel();
					tcmComponents.removeColumn( tcmComponents.getColumn(0) );
					
					
				
				
				scrollPaneComponent.setViewportView(tblComponents);
				
				treeCategory = new JTree();
				scrollPaneCategory.setViewportView(treeCategory);
				
				JButton btnShowAllComponents = new JButton("Alle anzeigen");
				GridBagConstraints gbc_btnShowAllComponents = new GridBagConstraints();
				gbc_btnShowAllComponents.insets = new Insets(0, 0, 5, 5);
				gbc_btnShowAllComponents.gridx = 3;
				gbc_btnShowAllComponents.gridy = 2;
				panelBauteil.add(btnShowAllComponents, gbc_btnShowAllComponents);
				
				JButton btnNeueKategorie = new JButton("Neue Kategorie");
				GridBagConstraints gbc_btnNeueKategorie = new GridBagConstraints();
				gbc_btnNeueKategorie.insets = new Insets(0, 0, 5, 5);
				gbc_btnNeueKategorie.gridx = 1;
				gbc_btnNeueKategorie.gridy = 4;
				panelBauteil.add(btnNeueKategorie, gbc_btnNeueKategorie);
				
				JButton btnNeuesBauteil = new JButton("Neues Bauteil");
				GridBagConstraints gbc_btnNeuesBauteil = new GridBagConstraints();
				gbc_btnNeuesBauteil.insets = new Insets(0, 0, 5, 5);
				gbc_btnNeuesBauteil.gridx = 3;
				gbc_btnNeuesBauteil.gridy = 4;
				panelBauteil.add(btnNeuesBauteil, gbc_btnNeuesBauteil);
				
				JButton btnBauteilLoeschen = new JButton("Bauteil loeschen");
				GridBagConstraints gbc_btnBauteilLoeschen = new GridBagConstraints();
				gbc_btnBauteilLoeschen.insets = new Insets(0, 0, 5, 5);
				gbc_btnBauteilLoeschen.gridx = 4;
				gbc_btnBauteilLoeschen.gridy = 4;
				panelBauteil.add(btnBauteilLoeschen, gbc_btnBauteilLoeschen);
				
				JButton btnMengenverwaltung = new JButton("Mengenverwaltung");
				GridBagConstraints gbc_btnMengenverwaltung = new GridBagConstraints();
				gbc_btnMengenverwaltung.insets = new Insets(0, 0, 5, 5);
				gbc_btnMengenverwaltung.gridx = 5;
				gbc_btnMengenverwaltung.gridy = 4;
				panelBauteil.add(btnMengenverwaltung, gbc_btnMengenverwaltung);
				
				JButton btnKategorieAendern = new JButton("Kategorie Aendern");
				GridBagConstraints gbc_btnKategorieAendern = new GridBagConstraints();
				gbc_btnKategorieAendern.insets = new Insets(0, 0, 5, 5);
				gbc_btnKategorieAendern.gridx = 1;
				gbc_btnKategorieAendern.gridy = 5;
				panelBauteil.add(btnKategorieAendern, gbc_btnKategorieAendern);
				
				JButton btnKategorieLoeschen = new JButton("Kategorie loeschen");
				GridBagConstraints gbc_btnKategorieLoeschen = new GridBagConstraints();
				gbc_btnKategorieLoeschen.insets = new Insets(0, 0, 5, 5);
				gbc_btnKategorieLoeschen.gridx = 1;
				gbc_btnKategorieLoeschen.gridy = 6;
				panelBauteil.add(btnKategorieLoeschen, gbc_btnKategorieLoeschen);
				
				JLabel lblDetailsComponent = new JLabel("Details:");
				lblDetailsComponent.setFont(new Font("Tahoma", Font.BOLD, 15));
				GridBagConstraints gbc_lblDetailsComponent = new GridBagConstraints();
				gbc_lblDetailsComponent.insets = new Insets(0, 0, 5, 5);
				gbc_lblDetailsComponent.gridx = 3;
				gbc_lblDetailsComponent.gridy = 6;
				panelBauteil.add(lblDetailsComponent, gbc_lblDetailsComponent);
				
				JLabel lblName_1 = new JLabel("Name:");
				GridBagConstraints gbc_lblName_1 = new GridBagConstraints();
				gbc_lblName_1.anchor = GridBagConstraints.EAST;
				gbc_lblName_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblName_1.gridx = 3;
				gbc_lblName_1.gridy = 7;
				panelBauteil.add(lblName_1, gbc_lblName_1);
				
				txtDetailNameComponent = new JTextField();
				GridBagConstraints gbc_txtDetailNameComponent = new GridBagConstraints();
				gbc_txtDetailNameComponent.insets = new Insets(0, 0, 5, 5);
				gbc_txtDetailNameComponent.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDetailNameComponent.gridx = 4;
				gbc_txtDetailNameComponent.gridy = 7;
				panelBauteil.add(txtDetailNameComponent, gbc_txtDetailNameComponent);
				txtDetailNameComponent.setColumns(10);
				
				JLabel lblLink = new JLabel("Link:");
				GridBagConstraints gbc_lblLink = new GridBagConstraints();
				gbc_lblLink.anchor = GridBagConstraints.EAST;
				gbc_lblLink.insets = new Insets(0, 0, 5, 5);
				gbc_lblLink.gridx = 5;
				gbc_lblLink.gridy = 7;
				panelBauteil.add(lblLink, gbc_lblLink);
				
				txtDetailLinkComponent = new JTextField();
				GridBagConstraints gbc_txtDetailLinkComponent = new GridBagConstraints();
				gbc_txtDetailLinkComponent.insets = new Insets(0, 0, 5, 5);
				gbc_txtDetailLinkComponent.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDetailLinkComponent.gridx = 6;
				gbc_txtDetailLinkComponent.gridy = 7;
				panelBauteil.add(txtDetailLinkComponent, gbc_txtDetailLinkComponent);
				txtDetailLinkComponent.setColumns(10);
				
				JLabel lblMengelagernd = new JLabel("Menge (lagernd):");
				GridBagConstraints gbc_lblMengelagernd = new GridBagConstraints();
				gbc_lblMengelagernd.anchor = GridBagConstraints.EAST;
				gbc_lblMengelagernd.insets = new Insets(0, 0, 5, 5);
				gbc_lblMengelagernd.gridx = 3;
				gbc_lblMengelagernd.gridy = 8;
				panelBauteil.add(lblMengelagernd, gbc_lblMengelagernd);
				
				txtDetailStockComponent = new JTextField();
				GridBagConstraints gbc_txtDetailStockComponent = new GridBagConstraints();
				gbc_txtDetailStockComponent.insets = new Insets(0, 0, 5, 5);
				gbc_txtDetailStockComponent.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDetailStockComponent.gridx = 4;
				gbc_txtDetailStockComponent.gridy = 8;
				panelBauteil.add(txtDetailStockComponent, gbc_txtDetailStockComponent);
				txtDetailStockComponent.setColumns(10);
				
				JLabel lblMengebestellt = new JLabel("Menge (bestellt):");
				GridBagConstraints gbc_lblMengebestellt = new GridBagConstraints();
				gbc_lblMengebestellt.anchor = GridBagConstraints.EAST;
				gbc_lblMengebestellt.insets = new Insets(0, 0, 5, 5);
				gbc_lblMengebestellt.gridx = 5;
				gbc_lblMengebestellt.gridy = 8;
				panelBauteil.add(lblMengebestellt, gbc_lblMengebestellt);
				
				txtDetailOrderedComponent = new JTextField();
				GridBagConstraints gbc_txtDetailOrderedComponent = new GridBagConstraints();
				gbc_txtDetailOrderedComponent.insets = new Insets(0, 0, 5, 5);
				gbc_txtDetailOrderedComponent.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDetailOrderedComponent.gridx = 6;
				gbc_txtDetailOrderedComponent.gridy = 8;
				panelBauteil.add(txtDetailOrderedComponent, gbc_txtDetailOrderedComponent);
				txtDetailOrderedComponent.setColumns(10);
				
				JLabel lblMengegeplant = new JLabel("Menge (geplant):");
				GridBagConstraints gbc_lblMengegeplant = new GridBagConstraints();
				gbc_lblMengegeplant.anchor = GridBagConstraints.EAST;
				gbc_lblMengegeplant.insets = new Insets(0, 0, 5, 5);
				gbc_lblMengegeplant.gridx = 7;
				gbc_lblMengegeplant.gridy = 8;
				panelBauteil.add(lblMengegeplant, gbc_lblMengegeplant);
				
				txtDetailPlannedComponent = new JTextField();
				GridBagConstraints gbc_txtDetailPlannedComponent = new GridBagConstraints();
				gbc_txtDetailPlannedComponent.insets = new Insets(0, 0, 5, 5);
				gbc_txtDetailPlannedComponent.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDetailPlannedComponent.gridx = 8;
				gbc_txtDetailPlannedComponent.gridy = 8;
				panelBauteil.add(txtDetailPlannedComponent, gbc_txtDetailPlannedComponent);
				txtDetailPlannedComponent.setColumns(10);
				
				JComboBox comboBoxCategory = new JComboBox();
				GridBagConstraints gbc_comboBoxCategory = new GridBagConstraints();
				gbc_comboBoxCategory.insets = new Insets(0, 0, 5, 5);
				gbc_comboBoxCategory.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBoxCategory.gridx = 8;
				gbc_comboBoxCategory.gridy = 9;
				panelBauteil.add(comboBoxCategory, gbc_comboBoxCategory);
				
				JLabel lblLagerort = new JLabel("Lagerort:");
				GridBagConstraints gbc_lblLagerort = new GridBagConstraints();
				gbc_lblLagerort.anchor = GridBagConstraints.EAST;
				gbc_lblLagerort.insets = new Insets(0, 0, 5, 5);
				gbc_lblLagerort.gridx = 3;
				gbc_lblLagerort.gridy = 9;
				panelBauteil.add(lblLagerort, gbc_lblLagerort);
				
				txtDetailLocationComponent = new JTextField();
				GridBagConstraints gbc_txtDetailLocationComponent = new GridBagConstraints();
				gbc_txtDetailLocationComponent.insets = new Insets(0, 0, 5, 5);
				gbc_txtDetailLocationComponent.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDetailLocationComponent.gridx = 4;
				gbc_txtDetailLocationComponent.gridy = 9;
				panelBauteil.add(txtDetailLocationComponent, gbc_txtDetailLocationComponent);
				txtDetailLocationComponent.setColumns(10);
				
				JLabel lblPreis = new JLabel("Preis:");
				GridBagConstraints gbc_lblPreis = new GridBagConstraints();
				gbc_lblPreis.anchor = GridBagConstraints.EAST;
				gbc_lblPreis.insets = new Insets(0, 0, 5, 5);
				gbc_lblPreis.gridx = 5;
				gbc_lblPreis.gridy = 9;
				panelBauteil.add(lblPreis, gbc_lblPreis);
				
				txtDetailPriceComponent = new JTextField();
				GridBagConstraints gbc_txtDetailPriceComponent = new GridBagConstraints();
				gbc_txtDetailPriceComponent.insets = new Insets(0, 0, 5, 5);
				gbc_txtDetailPriceComponent.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDetailPriceComponent.gridx = 6;
				gbc_txtDetailPriceComponent.gridy = 9;
				panelBauteil.add(txtDetailPriceComponent, gbc_txtDetailPriceComponent);
				txtDetailPriceComponent.setColumns(10);
				
				JLabel lblKategorie = new JLabel("Kategorie:");
				GridBagConstraints gbc_lblKategorie = new GridBagConstraints();
				gbc_lblKategorie.anchor = GridBagConstraints.EAST;
				gbc_lblKategorie.insets = new Insets(0, 0, 5, 5);
				gbc_lblKategorie.gridx = 7;
				gbc_lblKategorie.gridy = 9;
				panelBauteil.add(lblKategorie, gbc_lblKategorie);
				
				JButton btnSaveComponent = new JButton("Speichern");
				GridBagConstraints gbc_btnSaveComponent = new GridBagConstraints();
				gbc_btnSaveComponent.insets = new Insets(0, 0, 5, 5);
				gbc_btnSaveComponent.gridx = 8;
				gbc_btnSaveComponent.gridy = 10;
				panelBauteil.add(btnSaveComponent, gbc_btnSaveComponent);
				
		
		JPanel panelFinanz = new JPanel();
		tabbedPane.addTab("Finanzverwaltung", null, panelFinanz, null);
		panelFinanz.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPaneFinanz = new JTabbedPane(JTabbedPane.TOP);
		panelFinanz.add(tabbedPaneFinanz);
		
		
		String[] column_headers_kasse = {"Art", "Soll", "Ist"};
		String[][] data_kasse = new String[1000][11];
		DefaultTableModel modelKasse = new DefaultTableModel(new String[]{"ID_Kasse", "Art", "Nummer", "Soll", "Ist"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
		Statement stmt = DataBase.c.createStatement();
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
		//tcmKasse.removeColumn( tcmKasse.getColumn(0) );
		
		
		
		
//		String[] column_headers_topf = {"ID_Topf", "Soll", "Ist"};
//		String[][] data_topf = new String[1000][11];
//		DefaultTableModel modelTopf = new DefaultTableModel(new String[]{"ID_Topf", "Soll", "Ist"}, 0) {
//			
//			@Override
//			public boolean isCellEditable(int row, int column) {
//					return false;
//				}
//			};
//		String sqlTopf = "SELECT Topf.*, 'Mischtabelle-Kasse-Topf'.ID_Kasse FROM Topf LEFT JOIN 'Mischtabelle-Kasse-Topf' ON Topf.ID_Topf = 'Mischtabelle-Kasse-Topf'.ID_Topf;";
//		ResultSet rsTopf = stmt.executeQuery(sqlTopf);
//		
//		while(rsTopf.next())
//		{
//			String a1 = rsTopf.getString("ID_Topf");
//		    String b1 = rsTopf.getString("ID_Kasse");
//		    String c1 = rsTopf.getString("Soll");
//		    String d1 = rsTopf.getString("Ist");
//		    
//		    modelTopf.addRow(new Object[]{a1,b1,c1,d1});
//		}
		
		
	
		

		
		JPanel panelRechnung = new JPanel();
		tabbedPaneFinanz.addTab("Rechnungen", null, panelRechnung, null);
		GridBagLayout gbl_panelRechnung = new GridBagLayout();
		gbl_panelRechnung.columnWidths = new int[]{0};
		gbl_panelRechnung.rowHeights = new int[]{0};
		gbl_panelRechnung.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelRechnung.rowWeights = new double[]{Double.MIN_VALUE};
		panelRechnung.setLayout(gbl_panelRechnung);
		
		JPanel panelTopf = new JPanel();
		tabbedPaneFinanz.addTab("T\u00F6pfe & Kassen", null, panelTopf, null);
		GridBagLayout gbl_panelTopf = new GridBagLayout();
		gbl_panelTopf.columnWidths = new int[]{0, 11, 130, 230, 176, 207, 440, 180, 0};
		gbl_panelTopf.rowHeights = new int[]{67, 500, 49, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelTopf.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTopf.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelTopf.setLayout(gbl_panelTopf);
		
		JLabel lblNewLabel = new JLabel("  Kassen:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panelTopf.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblToepfe = new JLabel("Toepfe:");
		lblToepfe.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblToepfe = new GridBagConstraints();
		gbc_lblToepfe.gridwidth = 2;
		gbc_lblToepfe.anchor = GridBagConstraints.WEST;
		gbc_lblToepfe.insets = new Insets(0, 0, 5, 5);
		gbc_lblToepfe.gridx = 4;
		gbc_lblToepfe.gridy = 0;
		panelTopf.add(lblToepfe, gbc_lblToepfe);
		
		JLabel lblRechnungen = new JLabel("Rechnungen:");
		lblRechnungen.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblRechnungen = new GridBagConstraints();
		gbc_lblRechnungen.anchor = GridBagConstraints.WEST;
		gbc_lblRechnungen.insets = new Insets(0, 0, 5, 5);
		gbc_lblRechnungen.gridx = 6;
		gbc_lblRechnungen.gridy = 0;
		panelTopf.add(lblRechnungen, gbc_lblRechnungen);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
		panelTopf.add(scrollPane, gbc_scrollPane);
		tblKasse = new JTable(data_kasse, column_headers_kasse);
		
		String[] comboBoxValues = {"Barkasse", "Konto", "Kostenstelle"};
		
		JButton btnTopfErstellen = new JButton("Topf Erstellen");
		GridBagConstraints gbc_btnTopfErstellen = new GridBagConstraints();
		gbc_btnTopfErstellen.insets = new Insets(0, 0, 5, 5);
		gbc_btnTopfErstellen.gridx = 4;
		gbc_btnTopfErstellen.gridy = 2;
		panelTopf.add(btnTopfErstellen, gbc_btnTopfErstellen);
		
		JButton btnTopfLoeschen = new JButton("Topf Loeschen");
		GridBagConstraints gbc_btnTopfLoeschen = new GridBagConstraints();
		gbc_btnTopfLoeschen.insets = new Insets(0, 0, 5, 5);
		gbc_btnTopfLoeschen.gridx = 5;
		gbc_btnTopfLoeschen.gridy = 2;
		panelTopf.add(btnTopfLoeschen, gbc_btnTopfLoeschen);
		
		JLabel lblDetails_1 = new JLabel("Details:");
		lblDetails_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblDetails_1 = new GridBagConstraints();
		gbc_lblDetails_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetails_1.gridx = 4;
		gbc_lblDetails_1.gridy = 3;
		panelTopf.add(lblDetails_1, gbc_lblDetails_1);
		JComboBox comboBoxArt = new JComboBox(comboBoxValues);
		
		GridBagConstraints gbc_comboBoxArt = new GridBagConstraints();
		gbc_comboBoxArt.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxArt.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxArt.gridx = 3;
		gbc_comboBoxArt.gridy = 5;
		panelTopf.add(comboBoxArt, gbc_comboBoxArt);
		
		
		 
		tblKasse.addMouseListener(new MouseAdapter() {
			@Override
			
			
			
			public void mouseClicked(MouseEvent arg0) {
				
				DataBase.getConnection();
				int colnr  = MainMenu.tblKasse.getSelectedRow();
				
				
				String id = MainMenu.tblKasse.getModel().getValueAt(colnr, 0).toString();
				String oldArt = MainMenu.tblKasse.getModel().getValueAt(colnr, 1).toString();
				String oldNumber = MainMenu.tblKasse.getModel().getValueAt(colnr, 2).toString();
				String oldSoll = MainMenu.tblKasse.getModel().getValueAt(colnr, 3).toString();
				String oldIst = MainMenu.tblKasse.getModel().getValueAt(colnr, 4).toString();
				
				comboBoxArt.setSelectedItem(oldArt);
				txtKasseNr.setText(oldNumber);
				txtKasseSoll.setText(oldSoll);
				txtKasseIst.setText(oldIst);
				
				DefaultTableModel modelTopf = new DefaultTableModel(new String[]{"ID_Topf", "ID_Kasse", "Soll", "Ist"}, 0) {
					
					@Override
					public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
				
				
			
				
				Statement stmtTopf = null;
				
					try {
						
						stmtTopf = DataBase.c.createStatement();
						System.out.println("Statement");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				String sqlTopf = "SELECT Topf.*, 'Mischtabelle-Kasse-Topf'.ID_Kasse  FROM Topf INNER JOIN 'Mischtabelle-Kasse-Topf' on Topf.ID_Topf = 'Mischtabelle-Kasse-Topf'.ID_Topf where 'Mischtabelle-Kasse-Topf'.ID_Kasse ="+id+";";
				
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
							String b1 = rsTopf.getString("ID_Kasse");
						    String c1 = rsTopf.getString("Soll");
						    String d1 = rsTopf.getString("Ist");
						    
						    
						 
						  
						    
						    modelTopf.addRow(new Object[]{a1,b1,c1,d1});
						    
						    System.out.println("While done");
						    
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tblTopf.setModel(modelTopf);
				
					TableColumnModel tcmTopf = tblTopf.getColumnModel();
					tcmTopf.removeColumn( tcmTopf.getColumn(1) );
				
				
				
				
				
				DataBase.closeConnection();
			}
		});
		
		tblKasse.setModel(modelKasse);
		scrollPane.setViewportView(tblKasse);
		
		TableColumnModel tcmKasse = tblKasse.getColumnModel();
		tcmKasse.removeColumn( tcmKasse.getColumn(0) );
		tcmKasse.removeColumn( tcmKasse.getColumn(1) );
		
		
		
		int count = MainMenu.tblKasse.getRowCount();
		String[] idList = new String[count];
				
		for(int row=0; row < MainMenu.tblKasse.getRowCount(); row++) {
		 String id = MainMenu.tblKasse.getModel().getValueAt(row, 0).toString();
		 idList[row] = id;
		 		
		}
		JComboBox comboBoxKasse = new JComboBox(idList);
		GridBagConstraints gbc_comboBoxKasse = new GridBagConstraints();
		gbc_comboBoxKasse.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxKasse.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxKasse.gridx = 5;
		gbc_comboBoxKasse.gridy = 5;
		panelTopf.add(comboBoxKasse, gbc_comboBoxKasse);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 4;
		gbc_scrollPane_1.gridy = 1;
		panelTopf.add(scrollPane_1, gbc_scrollPane_1);
		String[] column_headers_topf = {"ID_Topf", "ID_Kasse", "Soll", "Ist"};
		String[][] data_topf = new String[1000][11];
		tblTopf = new JTable(data_topf, column_headers_topf);
		tblTopf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				int colnr = MainMenu.tblTopf.getSelectedRow();
				
				String idTopf = MainMenu.tblTopf.getModel().getValueAt(colnr, 0).toString();
				String oldIdKasse = MainMenu.tblTopf.getModel().getValueAt(colnr, 1).toString();
				
				System.out.println("old id kasse:" +oldIdKasse);
				String oldSoll = MainMenu.tblTopf.getModel().getValueAt(colnr, 2).toString();
				String oldIst = MainMenu.tblTopf.getModel().getValueAt(colnr, 3).toString();
				
				
				txtTopfSoll.setText(oldSoll);
				txtTopfIst.setText(oldIst);
				comboBoxKasse.setSelectedItem(oldIdKasse);
				DataBase.getConnection();
				
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
					
					TableColumnModel tcmRechn = tblRechn.getColumnModel();
					tcmRechn.removeColumn( tcmRechn.getColumn(0) );
					tcmRechn.removeColumn( tcmRechn.getColumn(1) );
					tcmRechn.removeColumn( tcmRechn.getColumn(2) );
					tcmRechn.removeColumn( tcmRechn.getColumn(2) );
				
				
				
				
				
				
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
		TableColumnModel tcmTopf = tblTopf.getColumnModel();
		tcmTopf.removeColumn( tcmTopf.getColumn(1) );
	
				
	
		scrollPane_1.setViewportView(tblTopf);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.gridx = 6;
		gbc_scrollPane_2.gridy = 1;
		panelTopf.add(scrollPane_2, gbc_scrollPane_2);
		
		
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
		
		
		
		
		
		
		TableColumnModel tcmRechn = tblRechn.getColumnModel();
		tcmRechn.removeColumn( tcmRechn.getColumn(0) );
		tcmRechn.removeColumn( tcmRechn.getColumn(1) );
		tcmRechn.removeColumn( tcmRechn.getColumn(2) );
		tcmRechn.removeColumn( tcmRechn.getColumn(2) );
		
		scrollPane_2.setViewportView(tblRechn);
		
		JButton btnKasseErstellen = new JButton("Kasse Erstellen");
		GridBagConstraints gbc_btnKasseErstellen = new GridBagConstraints();
		gbc_btnKasseErstellen.insets = new Insets(0, 0, 5, 5);
		gbc_btnKasseErstellen.gridx = 2;
		gbc_btnKasseErstellen.gridy = 2;
		panelTopf.add(btnKasseErstellen, gbc_btnKasseErstellen);
		
		JButton btnKasseLoeschen = new JButton("Kasse Loeschen");
		GridBagConstraints gbc_btnKasseLoeschen = new GridBagConstraints();
		gbc_btnKasseLoeschen.insets = new Insets(0, 0, 5, 5);
		gbc_btnKasseLoeschen.gridx = 3;
		gbc_btnKasseLoeschen.gridy = 2;
		panelTopf.add(btnKasseLoeschen, gbc_btnKasseLoeschen);
		
		JLabel lblDetails = new JLabel("Details:");
		lblDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblDetails = new GridBagConstraints();
		gbc_lblDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetails.gridx = 2;
		gbc_lblDetails.gridy = 3;
		panelTopf.add(lblDetails, gbc_lblDetails);
		
		JLabel lblArt = new JLabel("Art:");
		GridBagConstraints gbc_lblArt = new GridBagConstraints();
		gbc_lblArt.anchor = GridBagConstraints.EAST;
		gbc_lblArt.insets = new Insets(0, 0, 5, 5);
		gbc_lblArt.gridx = 2;
		gbc_lblArt.gridy = 5;
		panelTopf.add(lblArt, gbc_lblArt);
		
		JLabel lblKasse = new JLabel("Kasse:");
		GridBagConstraints gbc_lblKasse = new GridBagConstraints();
		gbc_lblKasse.anchor = GridBagConstraints.EAST;
		gbc_lblKasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblKasse.gridx = 4;
		gbc_lblKasse.gridy = 5;
		panelTopf.add(lblKasse, gbc_lblKasse);
		
		
		
		
		
		
	
		
		JLabel lblKasseNr = new JLabel("Nummer:");
		GridBagConstraints gbc_lblKasseNr = new GridBagConstraints();
		gbc_lblKasseNr.anchor = GridBagConstraints.EAST;
		gbc_lblKasseNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblKasseNr.gridx = 2;
		gbc_lblKasseNr.gridy = 6;
		panelTopf.add(lblKasseNr, gbc_lblKasseNr);
		
		txtKasseNr = new JTextField();
		GridBagConstraints gbc_txtKasseNr = new GridBagConstraints();
		gbc_txtKasseNr.anchor = GridBagConstraints.NORTH;
		gbc_txtKasseNr.insets = new Insets(0, 0, 5, 5);
		gbc_txtKasseNr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKasseNr.gridx = 3;
		gbc_txtKasseNr.gridy = 6;
		panelTopf.add(txtKasseNr, gbc_txtKasseNr);
		txtKasseNr.setColumns(10);
		
		JLabel lblSoll_1 = new JLabel("Soll:");
		GridBagConstraints gbc_lblSoll_1 = new GridBagConstraints();
		gbc_lblSoll_1.anchor = GridBagConstraints.EAST;
		gbc_lblSoll_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoll_1.gridx = 4;
		gbc_lblSoll_1.gridy = 6;
		panelTopf.add(lblSoll_1, gbc_lblSoll_1);
		
		txtTopfSoll = new JTextField();
		GridBagConstraints gbc_txtTopfSoll = new GridBagConstraints();
		gbc_txtTopfSoll.insets = new Insets(0, 0, 5, 5);
		gbc_txtTopfSoll.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTopfSoll.gridx = 5;
		gbc_txtTopfSoll.gridy = 6;
		panelTopf.add(txtTopfSoll, gbc_txtTopfSoll);
		txtTopfSoll.setColumns(10);
		
		JLabel lblSoll = new JLabel("Soll:");
		GridBagConstraints gbc_lblSoll = new GridBagConstraints();
		gbc_lblSoll.anchor = GridBagConstraints.EAST;
		gbc_lblSoll.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoll.gridx = 2;
		gbc_lblSoll.gridy = 7;
		panelTopf.add(lblSoll, gbc_lblSoll);
		
		txtKasseSoll = new JTextField();
		GridBagConstraints gbc_txtKasseSoll = new GridBagConstraints();
		gbc_txtKasseSoll.insets = new Insets(0, 0, 5, 5);
		gbc_txtKasseSoll.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKasseSoll.gridx = 3;
		gbc_txtKasseSoll.gridy = 7;
		panelTopf.add(txtKasseSoll, gbc_txtKasseSoll);
		txtKasseSoll.setColumns(10);
		
		JLabel lblIst = new JLabel("Ist:");
		GridBagConstraints gbc_lblIst = new GridBagConstraints();
		gbc_lblIst.anchor = GridBagConstraints.EAST;
		gbc_lblIst.insets = new Insets(0, 0, 5, 5);
		gbc_lblIst.gridx = 4;
		gbc_lblIst.gridy = 7;
		panelTopf.add(lblIst, gbc_lblIst);
		
		txtTopfIst = new JTextField();
		GridBagConstraints gbc_txtTopfIst = new GridBagConstraints();
		gbc_txtTopfIst.insets = new Insets(0, 0, 5, 5);
		gbc_txtTopfIst.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTopfIst.gridx = 5;
		gbc_txtTopfIst.gridy = 7;
		panelTopf.add(txtTopfIst, gbc_txtTopfIst);
		txtTopfIst.setColumns(10);
		
		JLabel lblKasseIst = new JLabel("Ist:");
		GridBagConstraints gbc_lblKasseIst = new GridBagConstraints();
		gbc_lblKasseIst.anchor = GridBagConstraints.EAST;
		gbc_lblKasseIst.insets = new Insets(0, 0, 5, 5);
		gbc_lblKasseIst.gridx = 2;
		gbc_lblKasseIst.gridy = 8;
		panelTopf.add(lblKasseIst, gbc_lblKasseIst);
		
		txtKasseIst = new JTextField();
		GridBagConstraints gbc_txtKasseIst = new GridBagConstraints();
		gbc_txtKasseIst.insets = new Insets(0, 0, 5, 5);
		gbc_txtKasseIst.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKasseIst.gridx = 3;
		gbc_txtKasseIst.gridy = 8;
		panelTopf.add(txtKasseIst, gbc_txtKasseIst);
		txtKasseIst.setColumns(10);
		
		JButton btnKasseSpeichern = new JButton("Speichern");
		btnKasseSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int colnr  = MainMenu.tblKasse.getSelectedRow();
				int colnrKasse = MainMenu.tblKasse.getSelectedRow();
				String idKasse = MainMenu.tblKasse.getModel().getValueAt(colnr, 0).toString();
				 String oldArt = MainMenu.tblKasse.getModel().getValueAt(colnr, 1).toString();
				 String oldNumber = MainMenu.tblKasse.getModel().getValueAt(colnr, 2).toString();
				 String oldSoll = MainMenu.tblKasse.getModel().getValueAt(colnr, 3).toString();
				 String oldIst = MainMenu.tblKasse.getModel().getValueAt(colnr, 4).toString();
				 
				Finanzverwaltung.alterKasse(Integer.parseInt(idKasse), comboBoxArt.getSelectedItem().toString(), txtKasseNr.getText(), Integer.parseInt(txtKasseSoll.getText()), Integer.parseInt(txtKasseIst.getText()));
				DataBase.refreshKasse();
			}
		});
		GridBagConstraints gbc_btnKasseSpeichern = new GridBagConstraints();
		gbc_btnKasseSpeichern.insets = new Insets(0, 0, 5, 5);
		gbc_btnKasseSpeichern.gridx = 3;
		gbc_btnKasseSpeichern.gridy = 9;
		panelTopf.add(btnKasseSpeichern, gbc_btnKasseSpeichern);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DataBase.getConnection();
				String idTopf2 = MainMenu.tblTopf.getModel().getValueAt(MainMenu.tblTopf.getSelectedRow(), 0).toString();
		
				System.out.println(idTopf2);
				Finanzverwaltung.alterTopf(Integer.parseInt(idTopf2), Integer.parseInt(comboBoxKasse.getSelectedItem().toString()), Integer.parseInt(txtTopfSoll.getText()), Integer.parseInt(txtTopfIst.getText()));
				DataBase.refreshTopf();
				DataBase.closeConnection();
			}
		});
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpeichern.gridx = 5;
		gbc_btnSpeichern.gridy = 9;
		panelTopf.add(btnSpeichern, gbc_btnSpeichern);
		
		JPanel panelOffen = new JPanel();
		tabbedPane.addTab("Offene Auftr\u00E4ge", null, panelOffen, null);
		GridBagLayout gbl_panelOffen = new GridBagLayout();
		gbl_panelOffen.columnWidths = new int[]{0, 0, 0};
		gbl_panelOffen.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelOffen.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelOffen.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelOffen.setLayout(gbl_panelOffen);
		
		JLabel lblHierFindenSie = new JLabel("Hier finden Sie alle offenen Auftraege, die \u00FCber die Webapplikation in auftrag gegeben wurden. Wenn Sie nun aus der unten stehenden Tabelle einen Auftrag ausw\u00E4hlen, k\u00F6nnen Sie diesen annehmen, oder ablehnen.");
		GridBagConstraints gbc_lblHierFindenSie = new GridBagConstraints();
		gbc_lblHierFindenSie.insets = new Insets(0, 0, 5, 0);
		gbc_lblHierFindenSie.gridx = 1;
		gbc_lblHierFindenSie.gridy = 1;
		panelOffen.add(lblHierFindenSie, gbc_lblHierFindenSie);
		
		JScrollPane scrollPaneOffeneAuftraege = new JScrollPane();
		GridBagConstraints gbc_scrollPaneOffeneAuftraege = new GridBagConstraints();
		gbc_scrollPaneOffeneAuftraege.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneOffeneAuftraege.gridx = 1;
		gbc_scrollPaneOffeneAuftraege.gridy = 2;
		panelOffen.add(scrollPaneOffeneAuftraege, gbc_scrollPaneOffeneAuftraege);
		
//		String[] column_headers_orders = {"ID ƒnderung", "ID Bauteil","ID Person", "Vorname", "Name", "Timestamp", "Aenderung"};
		String[] column_headers_orders = {"Bauteil", "Vorname", "Name", "Timestamp", "Menge"};
		String[][] data_orders = new String[1000][7];
		tblOffeneAuftraege = new JTable(data_orders, column_headers_orders);
		tblOffeneAuftraege.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
				OrderApprove x = new OrderApprove(); // -id Order 
				x.setVisible(true);  
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte w‰hlen Sie eine  aus.");
				}	
			}
		});
		DefaultTableModel modelOffeneAuftraege = new DefaultTableModel(new String[]{"ID ƒnderung", "Bauteil", "Vorname", "Name", "Timestamp", "Menge"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};	
			
			DataBase.loadOffeneAuftraegeToRam();
			
			
			for(OffenerAuftragObjektRAM tmp: DataBase.offeneAuftraege) {
				
			int id_aenderung = tmp.getid_aenderung();
			int id_bauteil = tmp.getId_bauteil();
			String bauteilName = DataBase.getBauteilName(id_bauteil);
			int id_person = tmp.getId_person();
			String vorname = tmp.getVorname();
			String name = tmp.getName();
			String timestamp = tmp.getTimestamp();
			int aenderung = tmp.getAenderung();
			
			
			 modelOffeneAuftraege.addRow(new Object[]{id_aenderung, bauteilName, vorname, name, timestamp, aenderung});
			}
			
			tblOffeneAuftraege.setModel(modelOffeneAuftraege);
		
		scrollPaneOffeneAuftraege.setViewportView(tblOffeneAuftraege);
		TableColumnModel tcmOffen = tblOffeneAuftraege.getColumnModel();
		tcmOffen.removeColumn( tcmOffen.getColumn(0) );
		setVisible(true);
		
		DataBase.closeConnection();
	}
}
