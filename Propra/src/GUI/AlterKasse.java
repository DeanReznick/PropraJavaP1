package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Data.DataBase;
import Data.Finanzverwaltung;

public class AlterKasse extends JFrame {

	private JPanel contentPane;
	private JTextField txtNummer;
	private JTextField txtSoll;
	private JTextField txtIst;
	
	int colnr = MainMenu.tblKasse.getSelectedRow();
	
	private String id = MainMenu.tblKasse.getModel().getValueAt(colnr, 0).toString();
	private String oldArt = MainMenu.tblKasse.getModel().getValueAt(colnr, 1).toString();
	private String oldNumber = MainMenu.tblKasse.getModel().getValueAt(colnr, 2).toString();
	private String oldSoll = MainMenu.tblKasse.getModel().getValueAt(colnr, 3).toString();
	private String oldIst = MainMenu.tblKasse.getModel().getValueAt(colnr, 4).toString();


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AlterKasse frame = new AlterKasse();
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
	public AlterKasse() {
		setTitle("Kasse aendern");
		setBounds(100, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArt = new JLabel("Art:");
		lblArt.setBounds(10, 11, 90, 14);
		contentPane.add(lblArt);
		
		String[] comboBoxValues = {"Barkasse", "Konto", "Kostenstelle"};
		
		JComboBox comboBoxArt = new JComboBox(comboBoxValues);
		comboBoxArt.setSelectedItem(oldArt);
		comboBoxArt.setBounds(124, 8, 100, 20);
		contentPane.add(comboBoxArt);
		
		JLabel lblNummer = new JLabel("Nummer:");
		lblNummer.setBounds(10, 39, 90, 14);
		contentPane.add(lblNummer);
		
		txtNummer = new JTextField(oldNumber);
		txtNummer.setBounds(124, 36, 100, 20);
		contentPane.add(txtNummer);
		txtNummer.setColumns(10);
		
		JLabel lblSoll = new JLabel("Soll:");
		lblSoll.setBounds(10, 65, 46, 14);
		contentPane.add(lblSoll);
		
		JLabel lblIst = new JLabel("Ist:");
		lblIst.setBounds(10, 90, 46, 14);
		contentPane.add(lblIst);
		
		txtSoll = new JTextField(oldSoll);
		txtSoll.setBounds(124, 62, 100, 20);
		contentPane.add(txtSoll);
		txtSoll.setColumns(10);
		
		txtIst = new JTextField(oldIst);
		txtIst.setBounds(124, 87, 100, 20);
		contentPane.add(txtIst);
		txtIst.setColumns(10);
		
		JButton btnHinzufuegen = new JButton("Ändern");
		btnHinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Finanzverwaltung.alterKasse(Integer.parseInt(id), comboBoxArt.getSelectedItem().toString(), txtNummer.getText(), Integer.parseInt(txtSoll.getText()), Integer.parseInt(txtIst.getText()));
				DataBase.refreshKasse();
				dispose();
			}
		});
		btnHinzufuegen.setBounds(63, 118, 100, 23);
		contentPane.add(btnHinzufuegen);
	}
}
