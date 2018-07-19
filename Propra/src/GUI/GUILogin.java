package GUI;
// Test1

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.ARechnungObjektRAM;
import Data.Authentication;
import Data.DataBase;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Window.Type;

public class GUILogin extends JFrame {
	public static String name_signedIn;
	public static String vorname_signedIn; 
	public static int id_signedIn; 
		
	private JPanel contentPane;
	private JTextField txt_mail;
	private int counter_try = 0;
	private JPasswordField txt_password;
	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		
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
		
		
//		 DataBase.closeConnection();
	}

	/**
	 * Create the frame.
	 */
	public GUILogin() {
		setTitle("Login");
		DataBase.getConnection();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 243, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Sitka Banner", Font.BOLD, 24));
		lblLogin.setBounds(55, 0, 102, 39);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("E-Mail:");
		lblPassword.setBounds(10, 50, 214, 14);
		contentPane.add(lblPassword);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(10, 130, 214, 20);
		contentPane.add(txt_password);

		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu x;
				try {
					
					
					
					
						String mail = txt_mail.getText(); 
						String password = txt_password.getText();  
						
						if (mail.equals("") | password.equals("")){
			
							JOptionPane.showMessageDialog(null, 
		                              "Bitte vollständige Eingaben tätigen." ,"Fehler", 
		                              JOptionPane.WARNING_MESSAGE);
						
						}else {
							
							
							String[] namen = new String[2]; 
							namen = DataBase.getNameVornameByMail(mail); 
							
							
							
							
							
							int id = DataBase.getIdPersonByNameSurname(namen[1], namen[0]); 
							
						
							
							String vorname = namen[0]; 
							String name = namen[1]; 
							
							
							
												
							name_signedIn = name; 
							vorname_signedIn = vorname; 
							id_signedIn = id; 
							
							
							
						if(Authentication.checkCredentials(name, vorname, password)) {
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
						
						
						
					} 
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, 
                            "Fehler bei der Eingabe.", 
                            "Fehler", 
                            JOptionPane.WARNING_MESSAGE);
			
				
				}catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, 
                            "Fehler bei der Eingabe.", 
                            "Fehler", 
                            JOptionPane.WARNING_MESSAGE);
				}
			}
		}
			
				);
		btnLogin.setBounds(10, 172, 217, 23);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("Password:");
		label.setBounds(10, 105, 214, 14);
		contentPane.add(label);
		
		txt_mail = new JTextField();
		txt_mail.setColumns(10);
		txt_mail.setBounds(10, 75, 214, 20);
		contentPane.add(txt_mail);
		
		SwingUtilities.getRootPane(btnLogin).setDefaultButton(btnLogin);
	}
}
