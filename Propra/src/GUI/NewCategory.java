package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.BauteileAuftragsabwicklung;
import Data.DataBase;
import Exceptions.InvalidArgumentsException;
import Exceptions.Manager;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCategory extends JFrame {

	private JPanel contentPane;
	public static JTextField txtCategory;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewCategory frame = new NewCategory();
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
	public NewCategory() {
		setTitle("Neue Kategorie erstellen");
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
		
		JButton btnErstellen = new JButton("Erstellen");
		btnErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String name = txtCategory.getText();
				Manager.checkStandardCategory(name);
				BauteileAuftragsabwicklung.createKategorie(name);
				DataBase.refreshCategory();
				dispose();
				} catch (InvalidArgumentsException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnErstellen.setBounds(58, 137, 89, 23);
		contentPane.add(btnErstellen);
	}
}
