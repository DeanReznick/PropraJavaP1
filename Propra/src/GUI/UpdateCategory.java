package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.BauteileAuftragsabwicklung;
import Data.DataBase;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCategory extends JFrame {

	private JPanel contentPane;
	private JTextField txtCategory;
	
	int colnr  = MainMenu.tblCategory.getSelectedRow();
	
	private int id = Integer.parseInt(MainMenu.tblCategory.getModel().getValueAt(colnr, 0).toString());

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdateCategory frame = new UpdateCategory();
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
	public UpdateCategory() {
		setTitle("Kategorie ändern");
		setBounds(100, 100, 173, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCategory = new JTextField();
		txtCategory.setBounds(61, 106, 86, 20);
		contentPane.add(txtCategory);
		txtCategory.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 109, 46, 14);
		contentPane.add(lblName);
		
		JButton btnAendern = new JButton("Aendern");
		btnAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataBase.getConnection();
				String name = txtCategory.getText();
				BauteileAuftragsabwicklung.renameKategrie(id, name);
				DataBase.refreshCategory();
				DataBase.closeConnection();
				dispose();
			}
		});
		btnAendern.setBounds(58, 137, 89, 23);
		contentPane.add(btnAendern);
	}
}
