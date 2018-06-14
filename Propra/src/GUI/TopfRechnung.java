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
import javax.swing.JComboBox;

public class TopfRechnung extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TopfRechnung frame = new TopfRechnung();
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
	public TopfRechnung() {
		
		int count = MainMenu.tblTopf.getRowCount();
		String[] list = new String[count];
		
		
		
		for(int row=0; row < MainMenu.tblTopf.getRowCount(); row++) {
		 String id = MainMenu.tblTopf.getModel().getValueAt(row, 0).toString();
		 list[row] = id;
		 }
		
		setTitle("Rechnung einem Topf hinzufügen");
		setBounds(100, 100, 158, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox(list);
		comboBox.setBounds(28, 53, 89, 20);
		contentPane.add(comboBox);
		
		JButton btnBestaetigen = new JButton("Bestaetigen");
		btnBestaetigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					int colnrRechnung = MainMenu.tblRechn.getSelectedRow();
					int idTopf = Integer.parseInt(comboBox.getSelectedItem().toString());
					String idRechnung = MainMenu.tblRechn.getModel().getValueAt(colnrRechnung, 0).toString();
					
					Finanzverwaltung.addBillToTopf(Integer.parseInt(idRechnung), idTopf);
					dispose();
					} catch (ArrayIndexOutOfBoundsException ex) {
						JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Rechnung aus.");
					}
			}
		});
		btnBestaetigen.setBounds(28, 134, 89, 23);
		contentPane.add(btnBestaetigen);
		
	}
}
