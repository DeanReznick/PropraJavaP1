package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Data.DataBase;
import Data.OrderObjektRAM;
import Data.PersonObjektRAM;

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
	public static JTable tblPersonen;
	public static JTable tblAuftraege;
	public static JScrollPane scrollPanePerson;
	public static JScrollPane scrollPaneOrder;

	public MainMenu() {
		DataBase.getConnection();
		setTitle("eLab");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) dim.getWidth(), (int) dim.getHeight() - 20);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{20, 1680, 110, 110};
		gbl_contentPane.rowHeights = new int[]{13, 1054, 13};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEingeloggtAls = new JLabel("eingeloggt, als:");
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
		gbl_panelPerson.columnWidths = new int[]{140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140, 140};
		gbl_panelPerson.rowHeights = new int[]{0, 10, 30, 60, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 420, 60};
		gbl_panelPerson.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelPerson.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPerson.setLayout(gbl_panelPerson);
		
		JLabel lblPersonen = new JLabel("Personen:");
		GridBagConstraints gbc_lblPersonen = new GridBagConstraints();
		gbc_lblPersonen.insets = new Insets(0, 0, 5, 5);
		gbc_lblPersonen.gridx = 0;
		gbc_lblPersonen.gridy = 1;
		panelPerson.add(lblPersonen, gbc_lblPersonen);
		
		JLabel lblAuftrge = new JLabel("Auft‰ge:");
		GridBagConstraints gbc_lblAuftrge = new GridBagConstraints();
		gbc_lblAuftrge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuftrge.gridx = 6;
		gbc_lblAuftrge.gridy = 1;
		panelPerson.add(lblAuftrge, gbc_lblAuftrge);
		
		JButton btnAlleAnzeigen = new JButton("Alle anzeigen");
		GridBagConstraints gbc_btnAlleAnzeigen = new GridBagConstraints();
		gbc_btnAlleAnzeigen.anchor = GridBagConstraints.WEST;
		gbc_btnAlleAnzeigen.insets = new Insets(0, 0, 5, 5);
		gbc_btnAlleAnzeigen.gridx = 1;
		gbc_btnAlleAnzeigen.gridy = 2;
		panelPerson.add(btnAlleAnzeigen, gbc_btnAlleAnzeigen);
		
		txtSearchPerson = new JTextField();
		GridBagConstraints gbc_txtSearchPerson = new GridBagConstraints();
		gbc_txtSearchPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtSearchPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearchPerson.gridx = 2;
		gbc_txtSearchPerson.gridy = 2;
		panelPerson.add(txtSearchPerson, gbc_txtSearchPerson);
		txtSearchPerson.setColumns(1);
		
		txtSearchOrder = new JTextField();
		GridBagConstraints gbc_txtSearchOrder = new GridBagConstraints();
		gbc_txtSearchOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtSearchOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearchOrder.gridx = 8;
		gbc_txtSearchOrder.gridy = 2;
		panelPerson.add(txtSearchOrder, gbc_txtSearchOrder);
		txtSearchOrder.setColumns(1);
		
		txtDetailNamePerson = new JTextField();
		GridBagConstraints gbc_txtDetailNamePerson = new GridBagConstraints();
		gbc_txtDetailNamePerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailNamePerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailNamePerson.gridx = 5;
		gbc_txtDetailNamePerson.gridy = 4;
		panelPerson.add(txtDetailNamePerson, gbc_txtDetailNamePerson);
		txtDetailNamePerson.setColumns(1);
		
		txtDetailVornamePerson = new JTextField();
		GridBagConstraints gbc_txtDetailVornamePerson = new GridBagConstraints();
		gbc_txtDetailVornamePerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailVornamePerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailVornamePerson.gridx = 5;
		gbc_txtDetailVornamePerson.gridy = 5;
		panelPerson.add(txtDetailVornamePerson, gbc_txtDetailVornamePerson);
		txtDetailVornamePerson.setColumns(1);
		
		txtDetailTelefonPerson = new JTextField();
		GridBagConstraints gbc_txtDetailTelefonPerson = new GridBagConstraints();
		gbc_txtDetailTelefonPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailTelefonPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailTelefonPerson.gridx = 5;
		gbc_txtDetailTelefonPerson.gridy = 6;
		panelPerson.add(txtDetailTelefonPerson, gbc_txtDetailTelefonPerson);
		txtDetailTelefonPerson.setColumns(1);
		
		txtDetailMailPerson = new JTextField();
		GridBagConstraints gbc_txtDetailMailPerson = new GridBagConstraints();
		gbc_txtDetailMailPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailMailPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailMailPerson.gridx = 5;
		gbc_txtDetailMailPerson.gridy = 7;
		panelPerson.add(txtDetailMailPerson, gbc_txtDetailMailPerson);
		txtDetailMailPerson.setColumns(1);
		
		txtDetailRollePerson = new JTextField();
		GridBagConstraints gbc_txtDetailRollePerson = new GridBagConstraints();
		gbc_txtDetailRollePerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailRollePerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailRollePerson.gridx = 5;
		gbc_txtDetailRollePerson.gridy = 8;
		panelPerson.add(txtDetailRollePerson, gbc_txtDetailRollePerson);
		txtDetailRollePerson.setColumns(1);
		
		txtDetailStrassePerson = new JTextField();
		GridBagConstraints gbc_txtDetailStrassePerson = new GridBagConstraints();
		gbc_txtDetailStrassePerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailStrassePerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailStrassePerson.gridx = 5;
		gbc_txtDetailStrassePerson.gridy = 9;
		panelPerson.add(txtDetailStrassePerson, gbc_txtDetailStrassePerson);
		txtDetailStrassePerson.setColumns(1);
		
		txtDetailHausnummerPerson = new JTextField();
		GridBagConstraints gbc_txtDetailHausnummerPerson = new GridBagConstraints();
		gbc_txtDetailHausnummerPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailHausnummerPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailHausnummerPerson.gridx = 5;
		gbc_txtDetailHausnummerPerson.gridy = 10;
		panelPerson.add(txtDetailHausnummerPerson, gbc_txtDetailHausnummerPerson);
		txtDetailHausnummerPerson.setColumns(1);
		
		txtDetailPlzPerson = new JTextField();
		GridBagConstraints gbc_txtDetailPlzPerson = new GridBagConstraints();
		gbc_txtDetailPlzPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailPlzPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailPlzPerson.gridx = 5;
		gbc_txtDetailPlzPerson.gridy = 11;
		panelPerson.add(txtDetailPlzPerson, gbc_txtDetailPlzPerson);
		txtDetailPlzPerson.setColumns(1);
		
		txtDetailOrtPerson = new JTextField();
		GridBagConstraints gbc_txtDetailOrtPerson = new GridBagConstraints();
		gbc_txtDetailOrtPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailOrtPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailOrtPerson.gridx = 5;
		gbc_txtDetailOrtPerson.gridy = 12;
		panelPerson.add(txtDetailOrtPerson, gbc_txtDetailOrtPerson);
		txtDetailOrtPerson.setColumns(1);
		
		txtDetailLandPerson = new JTextField();
		GridBagConstraints gbc_txtDetailLandPerson = new GridBagConstraints();
		gbc_txtDetailLandPerson.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailLandPerson.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailLandPerson.gridx = 5;
		gbc_txtDetailLandPerson.gridy = 13;
		panelPerson.add(txtDetailLandPerson, gbc_txtDetailLandPerson);
		txtDetailLandPerson.setColumns(1);
		
		txtDetailTitelOrder = new JTextField();
		GridBagConstraints gbc_txtDetailTitelOrder = new GridBagConstraints();
		gbc_txtDetailTitelOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailTitelOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailTitelOrder.gridx = 11;
		gbc_txtDetailTitelOrder.gridy = 4;
		panelPerson.add(txtDetailTitelOrder, gbc_txtDetailTitelOrder);
		txtDetailTitelOrder.setColumns(1);

		txtDetailAfOrder = new JTextField();
		GridBagConstraints gbc_txtDetailAfOrder = new GridBagConstraints();
		gbc_txtDetailAfOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailAfOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailAfOrder.gridx = 11;
		gbc_txtDetailAfOrder.gridy = 5;
		panelPerson.add(txtDetailAfOrder, gbc_txtDetailAfOrder);
		txtDetailAfOrder.setColumns(1);
		
		txtDetailDateinameOrder = new JTextField();
		GridBagConstraints gbc_txtDetailDateinameOrder = new GridBagConstraints();
		gbc_txtDetailDateinameOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailDateinameOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailDateinameOrder.gridx = 11;
		gbc_txtDetailDateinameOrder.gridy = 6;
		panelPerson.add(txtDetailDateinameOrder, gbc_txtDetailDateinameOrder);
		txtDetailDateinameOrder.setColumns(1);
		
		txtDetailDateiortOrder = new JTextField();
		GridBagConstraints gbc_txtDetailDateiortOrder = new GridBagConstraints();
		gbc_txtDetailDateiortOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailDateiortOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailDateiortOrder.gridx = 11;
		gbc_txtDetailDateiortOrder.gridy = 7;
		panelPerson.add(txtDetailDateiortOrder, gbc_txtDetailDateiortOrder);
		txtDetailDateiortOrder.setColumns(1);
		
		txtDetailPkOrder = new JTextField();
		GridBagConstraints gbc_txtDetailPkOrder = new GridBagConstraints();
		gbc_txtDetailPkOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailPkOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailPkOrder.gridx = 11;
		gbc_txtDetailPkOrder.gridy = 8;
		panelPerson.add(txtDetailPkOrder, gbc_txtDetailPkOrder);
		txtDetailPkOrder.setColumns(1);
		
		txtDetailRkOrder = new JTextField();
		GridBagConstraints gbc_txtDetailRkOrder = new GridBagConstraints();
		gbc_txtDetailRkOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailRkOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailRkOrder.gridx = 11;
		gbc_txtDetailRkOrder.gridy = 9;
		panelPerson.add(txtDetailRkOrder, gbc_txtDetailRkOrder);
		txtDetailRkOrder.setColumns(1);
		
		txtDetailStatusOrder = new JTextField();
		GridBagConstraints gbc_txtDetailStatusOrder = new GridBagConstraints();
		gbc_txtDetailStatusOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailStatusOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailStatusOrder.gridx = 11;
		gbc_txtDetailStatusOrder.gridy = 10;
		panelPerson.add(txtDetailStatusOrder, gbc_txtDetailStatusOrder);
		txtDetailStatusOrder.setColumns(1);
		
		txtDetailRolleOrder = new JTextField();
		GridBagConstraints gbc_txtDetailRolleOrder = new GridBagConstraints();
		gbc_txtDetailRolleOrder.insets = new Insets(0, 0, 5, 5);
		gbc_txtDetailRolleOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDetailRolleOrder.gridx = 11;
		gbc_txtDetailRolleOrder.gridy = 11;
		panelPerson.add(txtDetailRolleOrder, gbc_txtDetailRolleOrder);
		txtDetailRolleOrder.setColumns(1);
		
		JButton btnSearchPerson = new JButton("Suchen");
		GridBagConstraints gbc_btnSearchPerson = new GridBagConstraints();
		gbc_btnSearchPerson.anchor = GridBagConstraints.EAST;
		gbc_btnSearchPerson.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchPerson.gridx = 3;
		gbc_btnSearchPerson.gridy = 2;
		panelPerson.add(btnSearchPerson, gbc_btnSearchPerson);
		
		JButton btnAlleAnzeigen_1 = new JButton("Alle anzeigen");
		GridBagConstraints gbc_btnAlleAnzeigen_1 = new GridBagConstraints();
		gbc_btnAlleAnzeigen_1.anchor = GridBagConstraints.WEST;
		gbc_btnAlleAnzeigen_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnAlleAnzeigen_1.gridx = 7;
		gbc_btnAlleAnzeigen_1.gridy = 2;
		panelPerson.add(btnAlleAnzeigen_1, gbc_btnAlleAnzeigen_1);
		
		JButton btnSuchen = new JButton("Suchen");
		GridBagConstraints gbc_btnSuchen = new GridBagConstraints();
		gbc_btnSuchen.anchor = GridBagConstraints.EAST;
		gbc_btnSuchen.insets = new Insets(0, 0, 5, 5);
		gbc_btnSuchen.gridx = 9;
		gbc_btnSuchen.gridy = 2;
		panelPerson.add(btnSuchen, gbc_btnSuchen);
		
		scrollPanePerson = new JScrollPane();
		GridBagConstraints gbc_scrollPanePerson = new GridBagConstraints();
		gbc_scrollPanePerson.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPanePerson.fill = GridBagConstraints.BOTH;
		gbc_scrollPanePerson.gridx = 1;
		gbc_scrollPanePerson.gridy = 3;
		gbc_scrollPanePerson.gridwidth = 3;
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
		gbc_scrollPaneOrder.gridx = 7;
		gbc_scrollPaneOrder.gridy = 3;
		gbc_scrollPaneOrder.gridwidth = 3;
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
		
		JLabel lblDetailsPerson = new JLabel("Details:");
		lblDetailsPerson.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblDetailsPerson = new GridBagConstraints();
		gbc_lblDetailsPerson.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetailsPerson.gridx = 4;
		gbc_lblDetailsPerson.gridy = 3;
		panelPerson.add(lblDetailsPerson, gbc_lblDetailsPerson);
		
		JLabel lblDetailsOrder = new JLabel("Details:");
		lblDetailsOrder.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblDetailsOrder = new GridBagConstraints();
		gbc_lblDetailsOrder.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetailsOrder.gridx = 10;
		gbc_lblDetailsOrder.gridy = 3;
		panelPerson.add(lblDetailsOrder, gbc_lblDetailsOrder);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 4;
		gbc_lblName.gridy = 4;
		panelPerson.add(lblName, gbc_lblName);
		
		JLabel lblTitel = new JLabel("Titel:");
		GridBagConstraints gbc_lblTitel = new GridBagConstraints();
		gbc_lblTitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitel.gridx = 10;
		gbc_lblTitel.gridy = 4;
		panelPerson.add(lblTitel, gbc_lblTitel);
		
		JLabel lblVorname = new JLabel("Vorname:");
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname.gridx = 4;
		gbc_lblVorname.gridy = 5;
		panelPerson.add(lblVorname, gbc_lblVorname);
		
		JLabel lblArtDerFertigung = new JLabel("Art der Fertigung:");
		GridBagConstraints gbc_lblArtDerFertigung = new GridBagConstraints();
		gbc_lblArtDerFertigung.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtDerFertigung.gridx = 10;
		gbc_lblArtDerFertigung.gridy = 5;
		panelPerson.add(lblArtDerFertigung, gbc_lblArtDerFertigung);
		
		JLabel lblTelefonnummer = new JLabel("Telefonnummer:");
		GridBagConstraints gbc_lblTelefonnummer = new GridBagConstraints();
		gbc_lblTelefonnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefonnummer.gridx = 4;
		gbc_lblTelefonnummer.gridy = 6;
		panelPerson.add(lblTelefonnummer, gbc_lblTelefonnummer);
		
		JLabel lblDateiname = new JLabel("Dateiname:");
		GridBagConstraints gbc_lblDateiname = new GridBagConstraints();
		gbc_lblDateiname.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateiname.gridx = 10;
		gbc_lblDateiname.gridy = 6;
		panelPerson.add(lblDateiname, gbc_lblDateiname);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 4;
		gbc_lblEmail.gridy = 7;
		panelPerson.add(lblEmail, gbc_lblEmail);
		
		JLabel lblOrderDateiort = new JLabel("Dateiort:");
		GridBagConstraints gbc_lblOrderDateiort = new GridBagConstraints();
		gbc_lblOrderDateiort.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrderDateiort.gridx = 10;
		gbc_lblOrderDateiort.gridy = 7;
		panelPerson.add(lblOrderDateiort, gbc_lblOrderDateiort);
		
		JLabel lblRolle = new JLabel("Rolle:");
		GridBagConstraints gbc_lblRolle = new GridBagConstraints();
		gbc_lblRolle.insets = new Insets(0, 0, 5, 5);
		gbc_lblRolle.gridx = 4;
		gbc_lblRolle.gridy = 8;
		panelPerson.add(lblRolle, gbc_lblRolle);
		
		JLabel lblPrognostizierteKosten = new JLabel("Prognostizierte Kosten:");
		GridBagConstraints gbc_lblPrognostizierteKosten = new GridBagConstraints();
		gbc_lblPrognostizierteKosten.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrognostizierteKosten.gridx = 10;
		gbc_lblPrognostizierteKosten.gridy = 8;
		panelPerson.add(lblPrognostizierteKosten, gbc_lblPrognostizierteKosten);
		
		JLabel lblStrae = new JLabel("Stra\u00DFe:");
		GridBagConstraints gbc_lblStrae = new GridBagConstraints();
		gbc_lblStrae.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrae.gridx = 4;
		gbc_lblStrae.gridy = 9;
		panelPerson.add(lblStrae, gbc_lblStrae);
		
		JLabel lblReelleKosten = new JLabel("Reelle Kosten:");
		GridBagConstraints gbc_lblReelleKosten = new GridBagConstraints();
		gbc_lblReelleKosten.insets = new Insets(0, 0, 5, 5);
		gbc_lblReelleKosten.gridx = 10;
		gbc_lblReelleKosten.gridy = 9;
		panelPerson.add(lblReelleKosten, gbc_lblReelleKosten);
		
		JLabel lblHausnummer = new JLabel("Hausnummer:");
		GridBagConstraints gbc_lblHausnummer = new GridBagConstraints();
		gbc_lblHausnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblHausnummer.gridx = 4;
		gbc_lblHausnummer.gridy = 10;
		panelPerson.add(lblHausnummer, gbc_lblHausnummer);
		
		JLabel lblStatus = new JLabel("Status:");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 10;
		gbc_lblStatus.gridy = 10;
		panelPerson.add(lblStatus, gbc_lblStatus);
		
		JLabel lblPlz = new JLabel("PLZ:");
		GridBagConstraints gbc_lblPlz = new GridBagConstraints();
		gbc_lblPlz.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlz.gridx = 4;
		gbc_lblPlz.gridy = 11;
		panelPerson.add(lblPlz, gbc_lblPlz);
		
		JLabel lblRolleDerPerson = new JLabel("Rolle der Person:");
		GridBagConstraints gbc_lblRolleDerPerson = new GridBagConstraints();
		gbc_lblRolleDerPerson.insets = new Insets(0, 0, 5, 5);
		gbc_lblRolleDerPerson.gridx = 10;
		gbc_lblRolleDerPerson.gridy = 11;
		panelPerson.add(lblRolleDerPerson, gbc_lblRolleDerPerson);
		
		JLabel lblStadt = new JLabel("Stadt:");
		GridBagConstraints gbc_lblStadt = new GridBagConstraints();
		gbc_lblStadt.insets = new Insets(0, 0, 5, 5);
		gbc_lblStadt.gridx = 4;
		gbc_lblStadt.gridy = 12;
		panelPerson.add(lblStadt, gbc_lblStadt);
		
		JButton btnSaveOrder = new JButton("Speichern");
		GridBagConstraints gbc_btnSaveOrder = new GridBagConstraints();
		gbc_btnSaveOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaveOrder.gridx = 11;
		gbc_btnSaveOrder.gridy = 12;
		panelPerson.add(btnSaveOrder, gbc_btnSaveOrder);
		
		JLabel lblLand = new JLabel("Land:");
		GridBagConstraints gbc_lblLand = new GridBagConstraints();
		gbc_lblLand.insets = new Insets(0, 0, 5, 5);
		gbc_lblLand.gridx = 4;
		gbc_lblLand.gridy = 13;
		panelPerson.add(lblLand, gbc_lblLand);
		
		JButton btnSavePerson = new JButton("Speichern");
		GridBagConstraints gbc_btnSavePerson = new GridBagConstraints();
		gbc_btnSavePerson.insets = new Insets(0, 0, 5, 5);
		gbc_btnSavePerson.gridx = 5;
		gbc_btnSavePerson.gridy = 14;
		panelPerson.add(btnSavePerson, gbc_btnSavePerson);
		
		JButton btnNewPerson = new JButton("Neue Person");
		GridBagConstraints gbc_btnNewPerson = new GridBagConstraints();
		gbc_btnNewPerson.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewPerson.gridx = 1;
		gbc_btnNewPerson.gridy = 16;
		panelPerson.add(btnNewPerson, gbc_btnNewPerson);
		
		JButton btnDeletePerson = new JButton("Person l\u00F6schen");
		GridBagConstraints gbc_btnDeletePerson = new GridBagConstraints();
		gbc_btnDeletePerson.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeletePerson.gridx = 3;
		gbc_btnDeletePerson.gridy = 16;
		panelPerson.add(btnDeletePerson, gbc_btnDeletePerson);
		
		JButton btnCreateOrder = new JButton("Auftrag erstellen");
		GridBagConstraints gbc_btnCreateOrder = new GridBagConstraints();
		gbc_btnCreateOrder.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreateOrder.gridx = 7;
		gbc_btnCreateOrder.gridy = 16;
		panelPerson.add(btnCreateOrder, gbc_btnCreateOrder);
		
		JButton btnDeleteOrder = new JButton("Auftrag l\u00F6schen");
		GridBagConstraints gbc_btnDeleteOrder = new GridBagConstraints();
		gbc_btnDeleteOrder.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeleteOrder.gridx = 9;
		gbc_btnDeleteOrder.gridy = 16;
		panelPerson.add(btnDeleteOrder, gbc_btnDeleteOrder);
		
		JPanel panelBauteil = new JPanel();
		tabbedPane.addTab("Bauteileverwaltung", null, panelBauteil, null);
		GridBagLayout gbl_panelBauteil = new GridBagLayout();
		gbl_panelBauteil.columnWidths = new int[]{0};
		gbl_panelBauteil.rowHeights = new int[]{0};
		gbl_panelBauteil.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelBauteil.rowWeights = new double[]{Double.MIN_VALUE};
		panelBauteil.setLayout(gbl_panelBauteil);
		
		JPanel panelFinanz = new JPanel();
		tabbedPane.addTab("Finanzverwaltung", null, panelFinanz, null);
		panelFinanz.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPaneFinanz = new JTabbedPane(JTabbedPane.TOP);
		panelFinanz.add(tabbedPaneFinanz);
		
		JPanel panelTopf = new JPanel();
		tabbedPaneFinanz.addTab("T\u00F6pfe & Kassen", null, panelTopf, null);
		GridBagLayout gbl_panelTopf = new GridBagLayout();
		gbl_panelTopf.columnWidths = new int[]{0};
		gbl_panelTopf.rowHeights = new int[]{0};
		gbl_panelTopf.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelTopf.rowWeights = new double[]{Double.MIN_VALUE};
		panelTopf.setLayout(gbl_panelTopf);
		
		JPanel panelRechnung = new JPanel();
		tabbedPaneFinanz.addTab("Rechnungen", null, panelRechnung, null);
		GridBagLayout gbl_panelRechnung = new GridBagLayout();
		gbl_panelRechnung.columnWidths = new int[]{0};
		gbl_panelRechnung.rowHeights = new int[]{0};
		gbl_panelRechnung.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelRechnung.rowWeights = new double[]{Double.MIN_VALUE};
		panelRechnung.setLayout(gbl_panelRechnung);
		
		JPanel panelOffen = new JPanel();
		tabbedPane.addTab("Offene Auftr\u00E4ge", null, panelOffen, null);
		GridBagLayout gbl_panelOffen = new GridBagLayout();
		gbl_panelOffen.columnWidths = new int[]{0};
		gbl_panelOffen.rowHeights = new int[]{0};
		gbl_panelOffen.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelOffen.rowWeights = new double[]{Double.MIN_VALUE};
		panelOffen.setLayout(gbl_panelOffen);
		setVisible(true);
		
		DataBase.closeConnection();
	}
}
