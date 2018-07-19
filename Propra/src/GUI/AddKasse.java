package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.DataBase;
import Data.Finanzverwaltung;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddKasse extends JFrame {

	private JPanel contentPane;
	private JTextField txtNummer;
	private JTextField txtSoll;
	private JTextField txtIst;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddKasse frame = new AddKasse();
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
	public AddKasse() {
		setTitle("Kasse hinzufuegen");
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
		comboBoxArt.setBounds(124, 8, 100, 20);
		contentPane.add(comboBoxArt);
		
		JLabel lblNummer = new JLabel("Nummer:");
		lblNummer.setBounds(10, 39, 90, 14);
		contentPane.add(lblNummer);
		
		txtNummer = new JTextField();
		txtNummer.setBounds(124, 36, 100, 20);
		contentPane.add(txtNummer);
		txtNummer.setColumns(10);
		
		JLabel lblSoll = new JLabel("Soll:");
		lblSoll.setBounds(10, 65, 46, 14);
		contentPane.add(lblSoll);
		
		JLabel lblIst = new JLabel("Ist:");
		lblIst.setBounds(10, 90, 46, 14);
		contentPane.add(lblIst);
		
		txtSoll = new JTextField();
		txtSoll.setBounds(124, 62, 100, 20);
		contentPane.add(txtSoll);
		txtSoll.setColumns(10);
		
		txtIst = new JTextField();
		txtIst.setBounds(124, 87, 100, 20);
		contentPane.add(txtIst);
		txtIst.setColumns(10);
		
		JButton btnHinzufuegen = new JButton("Hinzufuegen");
		btnHinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String kasseNr = txtNummer.getText();
					int testNr = Integer.parseInt(kasseNr);
					
					Finanzverwaltung.addKasse(comboBoxArt.getSelectedItem().toString(), txtNummer.getText(), Integer.parseInt(txtSoll.getText()), Integer.parseInt(txtIst.getText()));
					dispose();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Nummer, Soll und Ist müssen Zahlen sein!");
				} finally {
				DataBase.refreshKasse();
				
			}
			}
		});
		btnHinzufuegen.setBounds(63, 118, 100, 23);
		contentPane.add(btnHinzufuegen);
	}
}
