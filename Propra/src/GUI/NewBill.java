package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.BauteileAuftragsabwicklung;
import Data.DataBase;
import Data.Finanzverwaltung;
import Data.PersonObjektRAM;
import Data.Rechnungsabwicklung;
import Exceptions.InvalidArgumentsException;
import Exceptions.Manager;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class NewBill extends JFrame {

	private JPanel contentPane;
	public static JTextField txtRechnungsName;
	public static JTextField txtZahlungsArt;
	public static JTextField txtBetrag;
	public static JTextField txtBeschreibung;
	private JComboBox comboBoxAuftraggeber;
	private JComboBox comboBoxAnsprechpartner;
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewBill frame = new NewBill();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public NewBill() {
		setTitle("Neue Rechnung erstellen");
		DataBase.loadPeopleToRAM();
		
		ArrayList<Integer> count = new ArrayList<Integer>();
		for (PersonObjektRAM p : DataBase.people) {
			count.add(p.getID_Person());
		}
		
		String[] personName = new String[count.size()];
		int[] idList = new int[count.size()];
		int i = 0;
		
		for (PersonObjektRAM p : DataBase.people) {
			personName[i] = p.getVorname() + " " + p.getName();
			idList[i] = p.getID_Person();
			i++;
		}
//		int count = MainMenu.tblPersonen.getRowCount();
//		String[] list = new String[count];
//		String[] personName = new String[count];
//		
//		
//		
//		for(int row=0; row < MainMenu.tblPersonen.getRowCount(); row++) {
//		 String id = MainMenu.tblPersonen.getModel().getValueAt(row, 0).toString();
//		 String lastName = MainMenu.tblPersonen.getModel().getValueAt(row, 1).toString();
//		 String firstName = MainMenu.tblPersonen.getModel().getValueAt(row, 2).toString();
//		 String fullName = firstName + " " + lastName;
//		 list[row] = id;
//		 personName[row] = fullName;
//		
//		}
		
		
		
		setBounds(100, 100, 267, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRechnungsName = new JTextField();
		txtRechnungsName.setBounds(124, 41, 86, 20);
		contentPane.add(txtRechnungsName);
		txtRechnungsName.setColumns(10);
		
		JComboBox comboBoxAuftraege = new JComboBox();
		comboBoxAuftraege.setBounds(124, 227, 86, 20);
		contentPane.add(comboBoxAuftraege);
		
		comboBoxAuftraggeber = new JComboBox(personName);
		comboBoxAuftraggeber.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String auftraggeber_name = comboBoxAuftraggeber.getSelectedItem().toString();
				int index = 0;
				
				for (int i = 0; i<personName.length; i++) {
					if (auftraggeber_name.equals(personName[i])) {
						index = i;
					}
				}
				int auftraggeber_id = idList[index];
				
				System.out.println(auftraggeber_name);
				System.out.println(auftraggeber_id);
				Statement stmtOrderBills = null;
//				String sqlOrdersBills = "SELECT Auftrag.* FROM Auftrag LEFT JOIN 'Mischtabelle-Person-Auftrag' ON Auftrag.ID_Auftrag = 'Mischtabelle-Person-Auftrag'.ID_Auftrag WHERE Auftrag.ID_Auftrag =" + auftraggeber_id + ";";
				String sqlOrdersBills = "SELECT * FROM 'Mischtabelle-Person-Auftrag' where ID_Person = " + auftraggeber_id + ";";
				ResultSet rsOrdersBills = null;
				
				try {
					stmtOrderBills = DataBase.c.createStatement();
					rsOrdersBills = stmtOrderBills.executeQuery(sqlOrdersBills);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
				  ArrayList<Integer> ids = new ArrayList<Integer>();
//				  ArrayList<String> orderNames = new ArrayList<String>();
			        try {
						while(rsOrdersBills.next()){
							int x = rsOrdersBills.getInt("ID_Auftrag");
//							String y = rsOrdersBills.getString("Name");
						    ids.add(x);
//						    orderNames.add(y);
						}
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
			        for (int i = 0; i < ids.size(); i++) {
			        	comboBoxAuftraege.addItem(ids.get(i));
			        }
			        
			}
		});
		comboBoxAuftraggeber.setBounds(124, 72, 86, 20);
		contentPane.add(comboBoxAuftraggeber);
		
		
		
		
		
		comboBoxAnsprechpartner = new JComboBox(personName);
		
//		comboBoxAnsprechpartner.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				
//				
//				
//				String auftraggeber_name = comboBoxAuftraggeber.getSelectedItem().toString();
//				String[] parts = auftraggeber_name.split(" ");
//				String name = parts[0]; 
//				String surname = parts[1];
//				
//				int auftraggeber_id = DataBase.getIdPersonByNameSurname(name, surname);
//				System.out.println(name);
//				System.out.println(auftraggeber_id);
//				Statement stmtOrderBills = null;
//				String sqlOrdersBills = "SELECT * FROM 'Mischtabelle-Person-Auftrag' where ID_Person = 20";
//				ResultSet rsOrdersBills = null;
//				
//				try {
//					rsOrdersBills = stmtOrderBills.executeQuery(sqlOrdersBills);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				
//				  ArrayList rows = new ArrayList();
//			        try {
//						while(rsOrdersBills.next()){
//							String x = rsOrdersBills.getString("ID_Auftrag");
//						    rows.add(x);
//						}
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//			        comboBoxAuftraege.setModel((ComboBoxModel) new DefaultComboBoxModel(rows.toArray()));
//			
//				
//			     
//			}
//		});
		comboBoxAnsprechpartner.setBounds(124, 103, 86, 20);
		contentPane.add(comboBoxAnsprechpartner);
		
		txtZahlungsArt = new JTextField();
		txtZahlungsArt.setBounds(124, 134, 86, 20);
		contentPane.add(txtZahlungsArt);
		txtZahlungsArt.setColumns(10);
		
		txtBetrag = new JTextField();
		txtBetrag.setBounds(124, 165, 86, 20);
		contentPane.add(txtBetrag);
		txtBetrag.setColumns(10);
		
		txtBeschreibung = new JTextField();
		txtBeschreibung.setBounds(124, 196, 86, 20);
		contentPane.add(txtBeschreibung);
		txtBeschreibung.setColumns(10);
		
		JLabel lblRechnungsname = new JLabel("Rechnungsname:");
		lblRechnungsname.setBounds(10, 44, 104, 14);
		contentPane.add(lblRechnungsname);
		
		JLabel lblNewLabel = new JLabel("Auftragsgeber:");
		lblNewLabel.setBounds(10, 75, 104, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAnsprechspartner = new JLabel("Ansprechspartner:");
		lblAnsprechspartner.setBounds(10, 106, 104, 14);
		contentPane.add(lblAnsprechspartner);
		
		JLabel lblZahlungsart = new JLabel("Zahlungsart");
		lblZahlungsart.setBounds(10, 137, 104, 14);
		contentPane.add(lblZahlungsart);
		
		JLabel lblBetrag = new JLabel("Betrag:");
		lblBetrag.setBounds(10, 168, 104, 14);
		contentPane.add(lblBetrag);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		lblBeschreibung.setBounds(10, 199, 104, 14);
		contentPane.add(lblBeschreibung);
		
		JButton btnErstellen = new JButton("Erstellen");
		btnErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				
				
				String auftraggeber_name = comboBoxAuftraggeber.getSelectedItem().toString();
				int indexAuftraggeber = -1;
				for (int i=0;i<personName.length;i++) {
				    if (personName[i].equals(auftraggeber_name)) {
				        indexAuftraggeber = i;
				        break;
				    }
				}
				int auftraggeber_id = idList[indexAuftraggeber];
				
				
				
				
				
				String ansprechpartner_name = comboBoxAnsprechpartner.getSelectedItem().toString();
				int indexAnsprechpartner = -1;
				for (int i=0;i<personName.length;i++) {
				    if (personName[i].equals(ansprechpartner_name)) {
				        indexAnsprechpartner = i;
				        break;
				    }
				}
				int ansprechpartner_id = idList[indexAnsprechpartner];
				
				
				String rechnungsname = txtRechnungsName.getText();
				String artBezahlung = txtZahlungsArt.getText();
				double betrag = Double.parseDouble(txtBetrag.getText());
				String beschreibung = txtBeschreibung.getText();
				
				int id_Auftrag = Integer.parseInt(comboBoxAuftraege.getSelectedItem().toString());
				Rechnungsabwicklung.createARechnung(rechnungsname, auftraggeber_id, ansprechpartner_id, artBezahlung, betrag, beschreibung, id_Auftrag);
				
			
				dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnErstellen.setBounds(124, 294, 89, 23);
		contentPane.add(btnErstellen);
		
		JLabel lblAuftrag = new JLabel("Auftrag:");
		lblAuftrag.setBounds(10, 230, 46, 14);
		contentPane.add(lblAuftrag);
		
		
		
		
	}
}
