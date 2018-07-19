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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		System.out.println("idList länge" +idList.length);
		System.out.println("personen länge:" +personName.length);
		
		setBounds(100, 100, 365, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRechnungsName = new JTextField();
		txtRechnungsName.setBounds(124, 41, 170, 20);
		contentPane.add(txtRechnungsName);
		txtRechnungsName.setColumns(10);
		
		
		txtBetrag = new JTextField();
		txtBetrag.setBounds(124, 165, 170, 20);
		contentPane.add(txtBetrag);
		txtBetrag.setColumns(10);
		
		JComboBox comboBoxAuftraege = new JComboBox();
		
		comboBoxAuftraege.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxAuftraege.addItem("0 Titel");
				String idName_Auftrag = null;
				try {
					idName_Auftrag = comboBoxAuftraege.getSelectedItem().toString();
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String id_Auftrag = null;
				Statement stmtOrderBills;
				try {
					String[] parts = idName_Auftrag.split(" ");
					id_Auftrag = parts[0]; 
					stmtOrderBills = null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String sqlOrdersBills = "SELECT PK FROM Auftrag WHERE ID_Auftrag = " + id_Auftrag + ";";
				//String sqlOrdersBills = "SELECT * FROM 'Mischtabelle-Person-Auftrag' where ID_Person = " + auftraggeber_id + ";";
				ResultSet rsOrdersBills = null;
				
				try {
					stmtOrderBills = DataBase.c.createStatement();
					rsOrdersBills = stmtOrderBills.executeQuery(sqlOrdersBills);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
				  String pk = "0";
				
			        try {
						while(rsOrdersBills.next()){
							
							pk = rsOrdersBills.getString("PK");
						  
						    
						}
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
			        
			        comboBoxAuftraege.removeItem("0 Titel");
			        txtBetrag.setText(pk);
			}
		});
		
	
		
		comboBoxAuftraege.setBounds(124, 227, 170, 20);
		contentPane.add(comboBoxAuftraege);
		
		comboBoxAuftraggeber = new JComboBox(personName);
		comboBoxAuftraggeber.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String auftraggeber_name = comboBoxAuftraggeber.getSelectedItem().toString();
				int index = 0;
				
				ArrayList<Integer> ids = new ArrayList<Integer>();
						
				for (int i = 0; i<personName.length; i++) {
					if (auftraggeber_name.equals(personName[i])) {
						index = i;
					}
				}
				int auftraggeber_id = idList[index];
				
				
				for (int i = 0; i<personName.length; i++) {
				System.out.println(personName[i]);
				}
				
				//System.out.println(auftraggeber_name);
				//System.out.println(auftraggeber_id);
				Statement stmtOrderBills = null;
				String sqlOrdersBills = "SELECT Auftrag.* FROM Auftrag INNER JOIN 'Mischtabelle-Person-Auftrag' ON Auftrag.ID_Auftrag = 'Mischtabelle-Person-Auftrag'.ID_Auftrag WHERE 'Mischtabelle-Person-Auftrag'.ID_Person =" + auftraggeber_id + ";";
				//String sqlOrdersBills = "SELECT * FROM 'Mischtabelle-Person-Auftrag' where ID_Person = " + auftraggeber_id + ";";
				ResultSet rsOrdersBills = null;
				
				try {
					stmtOrderBills = DataBase.c.createStatement();
					rsOrdersBills = stmtOrderBills.executeQuery(sqlOrdersBills);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
				  
				  ArrayList<String> orderNames = new ArrayList<String>();
				  
				  ArrayList<String> orderIdsNames = new ArrayList<String>();
			        try {
						while(rsOrdersBills.next()){
							int x = rsOrdersBills.getInt("ID_Auftrag");
							String z = rsOrdersBills.getString("ID_Auftrag");
							String y = rsOrdersBills.getString("Titel");
							String pk = rsOrdersBills.getString("PK");
						    ids.add(x);
						    orderNames.add(y);
						    
						    orderIdsNames.add(z + " " + y);
						    
						    System.out.println(z + " " + y);
						    
						}
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
			        
			      
			        
			        try {
						comboBoxAuftraege.removeAllItems();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        
			        System.out.println("size of the combobox after remove all" + comboBoxAuftraege.getComponentCount());
			        System.out.println("size of ids" +ids.size());
			        for (int i = 0; i < orderIdsNames.size(); i++) {
			        	
			        
			        	comboBoxAuftraege.addItem(orderIdsNames.get(i));
			        	
			        	System.out.println(orderIdsNames.get(i));
			      
			        }
			        System.out.println("size of the combobox after adding" + comboBoxAuftraege.getComponentCount());
			       
			        
			}
		});
		comboBoxAuftraggeber.setBounds(124, 72, 170, 20);
		contentPane.add(comboBoxAuftraggeber);
		
		
		
		
		
		comboBoxAnsprechpartner = new JComboBox(personName);
		

		comboBoxAnsprechpartner.setBounds(124, 103, 170, 20);
		contentPane.add(comboBoxAnsprechpartner);
		
		txtZahlungsArt = new JTextField();
		txtZahlungsArt.setBounds(124, 134, 170, 20);
		contentPane.add(txtZahlungsArt);
		txtZahlungsArt.setColumns(10);
		
		
		
		
		txtBeschreibung = new JTextField();
		txtBeschreibung.setBounds(124, 196, 170, 20);
		contentPane.add(txtBeschreibung);
		txtBeschreibung.setColumns(10);
		
		
		
		
		
		int countTopf = MainMenu.tblTopf.getRowCount();
		String[] idListTopf = new String[countTopf];
				
		for(int row=0; row < MainMenu.tblTopf.getRowCount(); row++) {
		 String idTopf = MainMenu.tblTopf.getModel().getValueAt(row, 0).toString();
		 if( idTopf.equals("-1")){ 
			 idListTopf[row] = "Default";
		 }
		 else {
			 idListTopf[row] = idTopf;
		 }
		}
		
		 JComboBox CBTopf = new JComboBox(idListTopf);
			CBTopf.setBounds(124, 258, 170, 20);
			contentPane.add(CBTopf);
			
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
				
				String idName_Auftrag = comboBoxAuftraege.getSelectedItem().toString();
				String[] parts = idName_Auftrag.split(" ");
				String id_Auftrag = parts[0]; // 004
				String part2 = parts[1]; // 034556
				
				String id_topf_String = CBTopf.getSelectedItem().toString();
				int id_topf;
				if(id_topf_String.equals("Default")){
					id_topf = -1;
					}
				
				else {
					id_topf =Integer.parseInt(id_topf_String);
				}
				
				
				Rechnungsabwicklung.createARechnung(rechnungsname, auftraggeber_id, ansprechpartner_id, artBezahlung, betrag, beschreibung, Integer.parseInt(id_Auftrag), id_topf);
				DataBase.refreshRechnungA();
				
			
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
		
		JLabel lblTopf = new JLabel("Topf:");
		lblTopf.setBounds(10, 261, 46, 14);
		contentPane.add(lblTopf);
		


	
		
		


		
	}
}

