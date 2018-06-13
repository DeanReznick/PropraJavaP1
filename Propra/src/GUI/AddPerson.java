package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.DataBase;
import Data.PersonObjektRAM;
import Data.PersonenFertigungsverwaltung;
import Exceptions.InvalidArgumentsException;
import Exceptions.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

public class AddPerson extends JFrame {

	private JPanel contentPane;
	public static JTextField txtName;
	public static JTextField txtVorname;
	public static JTextField txtTel;
	public static JTextField txtMail;
	public static JTextField txtLand;
	public static JTextField txtPlz;
	public static JTextField txtStr;
	public static JTextField txtHaus;
	public static JTextField txtOrt;
	private JTextField txt_Password;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddPerson frame = new AddPerson();
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
	public AddPerson() {
		setTitle("Neue Person hinzuf\u00FCgen");
		
		setBounds(100, 100, 325, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewPerson = new JLabel("Neue Person");
		lblNewPerson.setBounds(10, 11, 78, 14);
		contentPane.add(lblNewPerson);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 36, 58, 14);
		contentPane.add(lblName);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setBounds(10, 61, 58, 14);
		contentPane.add(lblVorname);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setBounds(10, 86, 46, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(10, 111, 46, 14);
		contentPane.add(lblMail);
		
		JLabel lblLand = new JLabel("Land:");
		lblLand.setBounds(10, 136, 46, 14);
		contentPane.add(lblLand);
		
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setBounds(10, 161, 46, 14);
		contentPane.add(lblPlz);
		
		JLabel lblStr = new JLabel("Str:");
		lblStr.setBounds(10, 213, 46, 14);
		contentPane.add(lblStr);
		
		JLabel lblHausnr = new JLabel("Hausnr:");
		lblHausnr.setBounds(10, 238, 46, 14);
		contentPane.add(lblHausnr);
		
		JLabel lblRolle = new JLabel("Rolle:");
		lblRolle.setBounds(10, 281, 46, 14);
		contentPane.add(lblRolle);
		
		txtName = new JTextField();
		txtName.setBounds(96, 33, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtVorname = new JTextField();
		txtVorname.setBounds(96, 58, 86, 20);
		contentPane.add(txtVorname);
		txtVorname.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setBounds(96, 83, 86, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		txtMail = new JTextField();
		txtMail.setBounds(96, 108, 86, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		txtLand = new JTextField();
		txtLand.setBounds(96, 133, 86, 20);
		contentPane.add(txtLand);
		txtLand.setColumns(10);
		
		txtPlz = new JTextField();
		txtPlz.setBounds(96, 158, 86, 20);
		contentPane.add(txtPlz);
		txtPlz.setColumns(10);
		
		txtStr = new JTextField();
		txtStr.setBounds(96, 210, 86, 20);
		contentPane.add(txtStr);
		txtStr.setColumns(10);
		
		txtHaus = new JTextField();
		txtHaus.setBounds(96, 235, 86, 20);
		contentPane.add(txtHaus);
		txtHaus.setColumns(10);
		
		JComboBox combo_job = new JComboBox();
		combo_job.setBounds(96, 278, 86, 20);
		contentPane.add(combo_job);
		
		txtOrt = new JTextField();
		txtOrt.setBounds(96, 184, 86, 20);
		contentPane.add(txtOrt);
		txtOrt.setColumns(10);
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setBounds(10, 187, 46, 14);
		contentPane.add(lblOrt);
		
		JLabel lblPassword = new JLabel("Passwort:");
		lblPassword.setBounds(10, 315, 58, 14);
		contentPane.add(lblPassword);
		
		txt_Password = new JTextField();
		txt_Password.setColumns(10);
		txt_Password.setBounds(96, 309, 86, 20);
		contentPane.add(txt_Password);
		
		combo_job.addItem("Kunde");
		combo_job.addItem("Intern"); 
		
		JButton btnHinzufuegen = new JButton("Hinzufuegen");
		btnHinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBase.getConnection();
				try {
					txtName.setBackground(Color.WHITE);
					txtVorname.setBackground(Color.WHITE);
					txtTel.setBackground(Color.WHITE);
					txtMail.setBackground(Color.WHITE);
					txtLand.setBackground(Color.WHITE);
					txtPlz.setBackground(Color.WHITE);
					txtStr.setBackground(Color.WHITE);
					txtHaus.setBackground(Color.WHITE);
					txtOrt.setBackground(Color.WHITE);
					
				String name = txtName.getText();
				String vorname = txtVorname.getText();
				String tel = txtTel.getText();
				String mail = txtMail.getText();
				String land = txtLand.getText();
				int PLZ = Integer.parseInt(txtPlz.getText());
				String str = txtStr.getText();
				String hausnr = txtHaus.getText();
				String ort = txtOrt.getText();
				String rolle = combo_job.getSelectedItem().toString();
				
				String password = txt_Password.getText(); 
				
				Manager.checkStandard(vorname, name, mail, str, PLZ, ort, land, hausnr, tel);
				//PersonObjektRAM p = new PersonObjektRAM(0, name, tel ,mail, "lala","lala", "lala", land, str, ort,PLZ, hausnr,vorname);
				PersonenFertigungsverwaltung.createNewPerson(name, vorname, tel, mail, land, str, ort, hausnr, PLZ, rolle, password);
				
				DataBase.refreshDatabase();
				dispose();
				
				}catch (InvalidArgumentsException ex){
					JOptionPane.showMessageDialog(null, ex);
				}catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "PLZ has to be a number.");
					txtPlz.setBackground(Color.RED);
				} finally {
					DataBase.closeConnection();
				}
			 
			}
		});
		btnHinzufuegen.setBounds(96, 343, 89, 23);
		contentPane.add(btnHinzufuegen);
		
		
	}
	
}
