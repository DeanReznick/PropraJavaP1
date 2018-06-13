package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.Finanzverwaltung;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TopfRechnung extends JFrame {

	private JPanel contentPane;
	private JTextField txtTopfID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopfRechnung frame = new TopfRechnung();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TopfRechnung() {
		
		setBounds(100, 100, 158, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTopfID = new JTextField();
		txtTopfID.setBounds(31, 52, 86, 20);
		contentPane.add(txtTopfID);
		txtTopfID.setColumns(10);
		
		JButton btnBestaetigen = new JButton("Bestaetigen");
		btnBestaetigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					int colnrRechnung = MainMenu.tblRechn.getSelectedRow();
					String idTopf = txtTopfID.getText();
					String idRechnung = MainMenu.tblRechn.getModel().getValueAt(colnrRechnung, 0).toString();
					
					Finanzverwaltung.addBillToTopf(Integer.parseInt(idRechnung), Integer.parseInt(idTopf));
					dispose();
					} catch (ArrayIndexOutOfBoundsException ex) {
						JOptionPane.showMessageDialog(null, "Fehler");
					}
			}
		});
		btnBestaetigen.setBounds(28, 134, 89, 23);
		contentPane.add(btnBestaetigen);
	}
}
