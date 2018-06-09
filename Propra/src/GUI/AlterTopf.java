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

public class AlterTopf extends JFrame {

	private JPanel contentPane;
	private JTextField txtSoll;
	private JTextField txtIst;

	
	int colnr = MainMenu.tblTopf.getSelectedRow();
	
	private String idTopf = MainMenu.tblTopf.getModel().getValueAt(colnr, 0).toString();
	private String oldIdKasse = MainMenu.tblTopf.getModel().getValueAt(colnr, 1).toString();
	private String oldSoll = MainMenu.tblTopf.getModel().getValueAt(colnr, 2).toString();
	private String oldIst = MainMenu.tblTopf.getModel().getValueAt(colnr, 3).toString();


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AlterTopf frame = new AlterTopf();
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
	public AlterTopf() {
		setTitle("Topf ändern");
		setBounds(100, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKasse = new JLabel("Kasse:");
		lblKasse.setBounds(10, 11, 90, 14);
		contentPane.add(lblKasse);
		
		int count = MainMenu.tblKasse.getRowCount();
		String[] idList = new String[count];
				
		for(int row=0; row < MainMenu.tblKasse.getRowCount(); row++) {
		 String id = MainMenu.tblKasse.getModel().getValueAt(row, 0).toString();
		 idList[row] = id;
		 		
		}
		
		JComboBox comboBoxArt = new JComboBox(idList);
		comboBoxArt.setSelectedItem(oldIdKasse);
		comboBoxArt.setBounds(124, 8, 100, 20);
		contentPane.add(comboBoxArt);
		
		JLabel lblSoll = new JLabel("Soll:");
		lblSoll.setBounds(10, 36, 46, 14);
		contentPane.add(lblSoll);
		
		JLabel lblIst = new JLabel("Ist:");
		lblIst.setBounds(10, 61, 46, 14);
		contentPane.add(lblIst);
		
		txtSoll = new JTextField(oldSoll);
		txtSoll.setBounds(124, 33, 100, 20);
		contentPane.add(txtSoll);
		txtSoll.setColumns(10);
		
		txtIst = new JTextField(oldIst);
		txtIst.setBounds(124, 58, 100, 20);
		contentPane.add(txtIst);
		txtIst.setColumns(10);
		
		JButton btnAlter = new JButton("Ändern");
		btnAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataBase.getConnection();
				Finanzverwaltung.alterTopf(Integer.parseInt(idTopf), Integer.parseInt(comboBoxArt.getSelectedItem().toString()), Integer.parseInt(txtSoll.getText()), Integer.parseInt(txtIst.getText()));
				DataBase.refreshTopf();
				DataBase.closeConnection();
				dispose();
			}
		});
		btnAlter.setBounds(63, 118, 100, 23);
		contentPane.add(btnAlter);
	}
}
