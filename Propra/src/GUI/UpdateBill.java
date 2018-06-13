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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateBill extends JFrame {

	private JPanel contentPane;
	private JTextField txtRechnungsName;
	private JTextField txtAuftragsgeber;
	private JTextField txtAnsprechsp;
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
		
		
		
		int colnr  = MainMenu.tblBills.getSelectedRow();
		//int id_Bill, String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, String betrag, String beschreibung;
		String id_Bill = MainMenu.tblBills.getModel().getValueAt(colnr, 0).toString();
		String rechnungsnameOld = MainMenu.tblBills.getModel().getValueAt(colnr, 1).toString();
		String id_AuftraggeberOld = MainMenu.tblBills.getModel().getValueAt(colnr, 2).toString();
		String id_AnsprechpartnerOld = DataBase.getIdAPbyBillId(id_Bill);
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
		
		txtAuftragsgeber = new JTextField(id_AuftraggeberOld);
		txtAuftragsgeber.setBounds(124, 72, 86, 20);
		contentPane.add(txtAuftragsgeber);
		txtAuftragsgeber.setColumns(10);
		
		txtAnsprechsp = new JTextField(id_AnsprechpartnerOld);
		txtAnsprechsp.setBounds(124, 103, 86, 20);
		contentPane.add(txtAnsprechsp);
		txtAnsprechsp.setColumns(10);
		
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
				DataBase.getConnection();
				String rechnungsname = txtRechnungsName.getText();
				int id_Auftraggeber = Integer.parseInt(txtAuftragsgeber.getText());
				int id_Ansprechpartner = Integer.parseInt(txtAnsprechsp.getText());
				String artBezahlung = txtZahlungsArt.getText();
				String betrag = txtBetrag.getText();
				String beschreibung = txtBeschreibung.getText();
				
				int id_Bill_int = Integer.parseInt(id_Bill);
				
				Finanzverwaltung.alterBill(id_Bill_int, rechnungsname, id_Auftraggeber, id_Ansprechpartner, artBezahlung, betrag, beschreibung);
				DataBase.refreshBill();
				DataBase.refreshRechn();
				DataBase.closeConnection();
				dispose();
				
			}
		});
		btnUpdate.setBounds(121, 227, 89, 23);
		contentPane.add(btnUpdate);
	}

}