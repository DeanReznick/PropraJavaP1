package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.BauteileAuftragsabwicklung;
import Data.DataBase;
import Data.Finanzverwaltung;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class NewBill extends JFrame {

	private JPanel contentPane;
	private JTextField txtRechnungsName;
	private JTextField txtZahlungsArt;
	private JTextField txtBetrag;
	private JTextField txtBeschreibung;
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
		
		
		setBounds(100, 100, 267, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRechnungsName = new JTextField();
		txtRechnungsName.setBounds(124, 41, 86, 20);
		contentPane.add(txtRechnungsName);
		txtRechnungsName.setColumns(10);
		
		comboBoxAuftraggeber = new JComboBox(personName);
		comboBoxAuftraggeber.setBounds(124, 72, 86, 20);
		contentPane.add(comboBoxAuftraggeber);
		
		comboBoxAnsprechpartner = new JComboBox(personName);
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
				DataBase.getConnection();
				
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
				
				Finanzverwaltung.addBill(rechnungsname, auftraggeber_id, ansprechpartner_id, artBezahlung, betrag, beschreibung);
				DataBase.refreshBill();
				DataBase.refreshRechn();
				DataBase.closeConnection();
				dispose();
				
			}
		});
		btnErstellen.setBounds(121, 227, 89, 23);
		contentPane.add(btnErstellen);
		
		
	}
}
