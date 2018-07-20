package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Data.DataBase;
import Data.Finanzverwaltung;

public class AddTopf extends JFrame {

	private JPanel contentPane;
	private JTextField txtSoll;
	private JTextField txtIst;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddTopf frame = new AddTopf();
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
	public AddTopf() {
		setTitle("Topf hinzufuegen");
		setBounds(100, 100, 362, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKasse = new JLabel("Kasse:");
		lblKasse.setBounds(10, 11, 90, 14);
		contentPane.add(lblKasse);
		
		int count = MainMenu.tblKasse.getRowCount();
		String[] idList = new String[count];
		String[] kasseName = new String[count];
		String[] idUndName = new String[count];
				
		for(int row=0; row < MainMenu.tblKasse.getRowCount(); row++) {
		 String id = MainMenu.tblKasse.getModel().getValueAt(row, 0).toString();
		 String name = MainMenu.tblKasse.getModel().getValueAt(row, 1).toString();
		 idList[row] = id;
		 kasseName[row] = name;
		 idUndName[row] = id +" " + name;
		}
		
		JComboBox comboBoxArt = new JComboBox(idUndName);
		comboBoxArt.setBounds(124, 8, 212, 20);
		contentPane.add(comboBoxArt);
		
		JLabel lblSoll = new JLabel("Soll:");
		lblSoll.setBounds(10, 36, 46, 14);
		contentPane.add(lblSoll);
		
		JLabel lblIst = new JLabel("Ist:");
		lblIst.setBounds(10, 61, 46, 14);
		contentPane.add(lblIst);
		
		txtSoll = new JTextField();
		txtSoll.setBounds(124, 33, 212, 20);
		contentPane.add(txtSoll);
		txtSoll.setColumns(10);
		
		txtIst = new JTextField();
		txtIst.setBounds(124, 58, 212, 20);
		contentPane.add(txtIst);
		txtIst.setColumns(10);
		
		JButton btnHinzufuegen = new JButton("Hinzufuegen");
		btnHinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String[] idKasse = comboBoxArt.getSelectedItem().toString().split(" ");
				String id = idKasse[0];
				try{
				
				Finanzverwaltung.addTopf(Integer.parseInt(id), Integer.parseInt(txtSoll.getText()), Integer.parseInt(txtIst.getText()));
				dispose();
				}catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Soll und Ist müssen Zahlen sein!");
				} finally {
					DataBase.refreshTopf();
					
					
			}
				
			}
		});
		btnHinzufuegen.setBounds(181, 89, 155, 23);
		contentPane.add(btnHinzufuegen);
	}
}
