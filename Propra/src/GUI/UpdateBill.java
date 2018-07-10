package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.DataBase;
import Data.Finanzverwaltung;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateBill extends JFrame {

	private JPanel contentPane;
	private JTextField txtRechnungsName;
	private JComboBox comboBoxAuftraggeber;
	private JComboBox comboBoxAnsprechpartner;
	private JTextField txtZahlungsArt;
	private JTextField txtBetrag;
	private JTextField txtBeschreibung;

	
	
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public UpdateBill() {
		setTitle("Rechnungsdaten ändern");
		
		int count = MainMenu.tblPersonen.getRowCount();
		String[] list = new String[count];
		String[] personName = new String[count];
		
		
		
		for(int row=0; row < MainMenu.tblPersonen.getRowCount(); row++) {
		 String id = MainMenu.tblPersonen.getModel().getValueAt(row, 0).toString();
		 String lastName = MainMenu.tblPersonen.getModel().getValueAt(row, 1).toString();
		 String firstName = MainMenu.tblPersonen.getModel().getValueAt(row, 2).toString();
		 String fullName = firstName + " " + lastName;
		 list[row] = id;
		 personName[row] = fullName;
		
		}
		
		int colnr  = MainMenu.tblBills.getSelectedRow();
		//int id_Bill, String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, String betrag, String beschreibung;
		String id_Bill = MainMenu.tblBills.getModel().getValueAt(colnr, 0).toString();
		String rechnungsnameOld = MainMenu.tblBills.getModel().getValueAt(colnr, 1).toString();
		String id_AuftraggeberOld = MainMenu.tblBills.getModel().getValueAt(colnr, 2).toString();
		String auftraggeberName = DataBase.getPersonById(Integer.parseInt(id_AuftraggeberOld));
//		System.out.println(auftraggeberName);
		String id_AnsprechpartnerOld = DataBase.getIdAPbyBillId(id_Bill);
		String ansprechpartnerName = DataBase.getPersonById(Integer.parseInt(id_AnsprechpartnerOld));
//		System.out.println(ansprechpartnerName);
		String artBezahlungOld = DataBase.getBezahlungBill(id_Bill);
		String betragOld = MainMenu.tblBills.getModel().getValueAt(colnr, 3).toString();
		String beschreibungOld = MainMenu.tblBills.getModel().getValueAt(colnr, 4).toString();
		System.out.println(id_Bill);
		
		System.out.println(id_AnsprechpartnerOld);
		setBounds(100, 100, 267, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRechnungsName = new JTextField(rechnungsnameOld);
		txtRechnungsName.setBounds(124, 41, 86, 20);
		contentPane.add(txtRechnungsName);
		txtRechnungsName.setColumns(10);
		
		comboBoxAuftraggeber = new JComboBox(personName);
		comboBoxAuftraggeber.setSelectedItem(auftraggeberName);
		comboBoxAuftraggeber.setBounds(124, 72, 86, 20);
		contentPane.add(comboBoxAuftraggeber);
		
		comboBoxAnsprechpartner = new JComboBox(personName);
		comboBoxAnsprechpartner.setSelectedItem(ansprechpartnerName);
		comboBoxAnsprechpartner.setBounds(124, 103, 86, 20);
		contentPane.add(comboBoxAnsprechpartner);
		
		txtZahlungsArt = new JTextField(artBezahlungOld);
		txtZahlungsArt.setBounds(124, 134, 86, 20);
		contentPane.add(txtZahlungsArt);
		txtZahlungsArt.setColumns(10);
		
		txtBetrag = new JTextField(betragOld);
		txtBetrag.setBounds(124, 165, 86, 20);
		contentPane.add(txtBetrag);
		txtBetrag.setColumns(10);
		
		txtBeschreibung = new JTextField(beschreibungOld);
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
		
		JButton btnUpdate = new JButton("Aendern");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String auftraggeber_name = comboBoxAuftraggeber.getSelectedItem().toString();
				int indexAuftraggeber = -1;
				for (int i=0;i<personName.length;i++) {
				    if (personName[i].equals(auftraggeber_name)) {
				        indexAuftraggeber = i;
				        break;
				    }
				}
				int auftraggeber_id = Integer.parseInt(list[indexAuftraggeber]);
				
				String ansprechpartner_name = comboBoxAnsprechpartner.getSelectedItem().toString();
				int indexAnsprechpartner = -1;
				for (int i=0;i<personName.length;i++) {
				    if (personName[i].equals(ansprechpartner_name)) {
				        indexAnsprechpartner = i;
				        break;
				    }
				}
				int ansprechpartner_id = Integer.parseInt(list[indexAnsprechpartner]);
				
				String rechnungsname = txtRechnungsName.getText();
				String artBezahlung = txtZahlungsArt.getText();
				String betrag = txtBetrag.getText();
				String beschreibung = txtBeschreibung.getText();
				
				int id_Bill_int = Integer.parseInt(id_Bill);
				
				Finanzverwaltung.alterBill(id_Bill_int, rechnungsname, auftraggeber_id, ansprechpartner_id, artBezahlung, betrag, beschreibung);
				DataBase.refreshBill();
				DataBase.refreshBill2();
				
				dispose();
				
			}
		});
		btnUpdate.setBounds(121, 227, 89, 23);
		contentPane.add(btnUpdate);
		
	}

}