package GUI;
// Test123


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.Authentication;
import Data.DataBase;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class GUILogin extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_surname;
	private int counter_try = 0;
	private JPasswordField txt_password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		DataBase.getConnection();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILogin frame = new GUILogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		 DataBase.loadStatusToRam(21);
		 DataBase.closeConnection();
		 
		 
	}

	/**
	 * Create the frame.
	 */
	public GUILogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(105, 11, 40, 14);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Name:");
		lblUsername.setBounds(10, 50, 214, 14);
		contentPane.add(lblUsername);
		
		txt_name = new JTextField();
		txt_name.setBounds(10, 75, 214, 20);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		JLabel lblPassword = new JLabel("Surname:");
		lblPassword.setBounds(10, 106, 214, 14);
		contentPane.add(lblPassword);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(10, 186, 214, 20);
		contentPane.add(txt_password);

		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu x;
				try {
						String name = txt_name.getText(); 
						String surname = txt_surname.getText(); 
						String password = txt_password.getText();  
					 
						
					
					if(Authentication.checkCredentials(name, surname, password)) {
						x = new MainMenu();
						x.setVisible(true);
						dispose();
					}else {
						if(++ counter_try < 4) {
						
							JOptionPane.showMessageDialog(null, 
		                              "Eingaben stimmen nicht! Versuch: " + counter_try + " von 3", 
		                              "Fehler", 
		                              JOptionPane.WARNING_MESSAGE);
						}else {
							setVisible(false); 
							dispose();
						}
		
					}
				
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(10, 228, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("Password:");
		label.setBounds(10, 161, 214, 14);
		contentPane.add(label);
		
		txt_surname = new JTextField();
		txt_surname.setColumns(10);
		txt_surname.setBounds(10, 131, 214, 20);
		contentPane.add(txt_surname);
		
		JLabel lblNewLabel = new JLabel("Klein, Anna, 123");
		lblNewLabel.setBounds(10, 25, 115, 14);
		contentPane.add(lblNewLabel);
		
		
	}
}
