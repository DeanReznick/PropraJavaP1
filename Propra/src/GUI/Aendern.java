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
import Data.PersonenFertigungsverwaltung;
import Exceptions.InvalidArgumentsException;
import Exceptions.Manager;

public class Aendern extends JFrame {

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
	public Aendern() {
		setTitle("Personendaten \u00E4ndern");
		
		
	
		int colnr  = MainMenu.tblPersonen.getSelectedRow();
		
		String oldname = MainMenu.tblPersonen.getModel().getValueAt(colnr, 1).toString();
		String oldvorname = MainMenu.tblPersonen.getModel().getValueAt(colnr, 2).toString();
		String oldtel = MainMenu.tblPersonen.getModel().getValueAt(colnr, 3).toString();
		String oldmail = MainMenu.tblPersonen.getModel().getValueAt(colnr, 4).toString();
		String oldrolle = MainMenu.tblPersonen.getModel().getValueAt(colnr, 5).toString();
		String oldstr = MainMenu.tblPersonen.getModel().getValueAt(colnr, 6).toString();
		String oldhaus = MainMenu.tblPersonen.getModel().getValueAt(colnr, 7).toString();
		String oldplz = MainMenu.tblPersonen.getModel().getValueAt(colnr, 8).toString();
		String oldort = MainMenu.tblPersonen.getModel().getValueAt(colnr, 9).toString();
		String oldland = MainMenu.tblPersonen.getModel().getValueAt(colnr, 10).toString();
		
		
		
		
		setBounds(100, 100, 280, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 58, 14);
		contentPane.add(lblName);
		
		
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setBounds(10, 36, 58, 14);
		contentPane.add(lblVorname);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setBounds(10, 61, 46, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(10, 86, 46, 14);
		contentPane.add(lblMail);
		
		JLabel lblLand = new JLabel("Land:");
		lblLand.setBounds(10, 111, 46, 14);
		contentPane.add(lblLand);
		
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setBounds(10, 136, 46, 14);
		contentPane.add(lblPlz);
		
		JLabel lblStr = new JLabel("Str:");
		lblStr.setBounds(10, 189, 46, 14);
		contentPane.add(lblStr);
		
		JLabel lblHausnr = new JLabel("Hausnr:");
		lblHausnr.setBounds(10, 214, 46, 14);
		contentPane.add(lblHausnr);
		
		JLabel lblRolle = new JLabel("Rolle:");
		lblRolle.setBounds(10, 239, 46, 14);
		contentPane.add(lblRolle);
		
		txtName = new JTextField(oldname);
		txtName.setBounds(96, 8, 158, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		
		txtVorname = new JTextField(oldvorname);
		txtVorname.setBounds(96, 33, 158, 20);
		contentPane.add(txtVorname);
		txtVorname.setColumns(10);
		
		txtTel = new JTextField(oldtel);
		txtTel.setBounds(96, 58, 158, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		txtMail = new JTextField(oldmail);
		txtMail.setBounds(96, 83, 158, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		txtLand = new JTextField(oldland);
		txtLand.setBounds(96, 108, 158, 20);
		contentPane.add(txtLand);
		txtLand.setColumns(10);
		
		txtPlz = new JTextField(oldplz);
		txtPlz.setBounds(96, 133, 158, 20);
		contentPane.add(txtPlz);
		txtPlz.setColumns(10);
		
		txtStr = new JTextField(oldstr);
		txtStr.setBounds(96, 186, 158, 20);
		contentPane.add(txtStr);
		txtStr.setColumns(10);
		
		txtHaus = new JTextField(oldhaus);
		txtHaus.setBounds(96, 211, 158, 20);
		contentPane.add(txtHaus);
		txtHaus.setColumns(10);
		
		txtOrt = new JTextField(oldort);
		txtOrt.setBounds(96, 158, 158, 20);
		contentPane.add(txtOrt);
		txtOrt.setColumns(10);
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setBounds(10, 161, 46, 14);
		contentPane.add(lblOrt);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(96, 236, 158, 20);
		contentPane.add(comboBox);
		
		comboBox.addItem("Kunde");
		comboBox.addItem("Intern"); 
		
		
		JButton btnAendern = new JButton("Aendern");
		btnAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBase.getConnection();
				try {
				
				int colId = 0;
				int colName = 1;
				int colVorname = 2; 
				int colTel = 3; 
				int colMail = 4; 
				int colRolle= 5;
				int colStr = 6;
				int colHaus = 7;
				int colPlz = 8;
				int colOrt = 9;
				int colLand = 10;
				
				int id = Integer.parseInt(MainMenu.tblPersonen.getModel().getValueAt(colnr, 0).toString());
				
				String nameOld = MainMenu.tblPersonen.getModel().getValueAt(colnr, colName).toString();
				String vornameOld = MainMenu.tblPersonen.getModel().getValueAt(colnr, colVorname).toString();
				String telOld = MainMenu.tblPersonen.getModel().getValueAt(colnr, colTel).toString();
				String mailOld = MainMenu.tblPersonen.getModel().getValueAt(colnr, colMail).toString();
				
				String strOld = MainMenu.tblPersonen.getModel().getValueAt(colnr, colStr).toString();
				String hausOld = MainMenu.tblPersonen.getModel().getValueAt(colnr, colHaus).toString();
				String plzOld = MainMenu.tblPersonen.getModel().getValueAt(colnr, colPlz).toString();
				String ortOld = MainMenu.tblPersonen.getModel().getValueAt(colnr, colOrt).toString();
				String landOld = MainMenu.tblPersonen.getModel().getValueAt(colnr, colLand).toString();
				String rolleOld = MainMenu.tblPersonen.getModel().getValueAt(colnr, colRolle).toString();
				
				
				
				
				
				String nameNew = txtName.getText();
				String vornameNew = txtVorname.getText();
				String telNew = txtTel.getText();
				String hausNew = txtHaus.getText();
				String landNew = txtLand.getText();
				String mailNew = txtMail.getText();
				int plzNew = Integer.parseInt(txtPlz.getText());
				String strNew = txtStr.getText();
				String ortNew = txtOrt.getText();
				String rolleNew = comboBox.getSelectedItem().toString();
				
				
				Manager.checkAendernStandard(vornameNew, nameNew, mailNew, strNew, plzNew, ortNew, landNew, hausNew, telNew);
				
				
				
				
				
				if(!nameNew.equals(nameOld) || !vornameNew.equals(vornameOld)) {
					
					PersonenFertigungsverwaltung.changeNameSurname(vornameOld, nameOld, vornameNew, nameNew);
					System.out.println(oldname);
					System.out.println(vornameNew);
					
					
				}
				
				
				if(!telNew.equals(telOld))
				{
					PersonenFertigungsverwaltung.changePhoneNumber(vornameOld, nameOld, telNew);
				}
				
				
				if(!mailNew.equals(mailOld))
				{
					PersonenFertigungsverwaltung.changeMail(vornameOld, nameOld, mailNew);
				}
				
				
				PersonenFertigungsverwaltung.changeRolle(id, rolleNew);
				
				
				
				
				if(!landNew.equals(landOld)
					|| !strNew.equals(strOld)
					|| !ortNew.equals(ortOld)
					|| !hausNew.equals(hausOld)
					|| !(plzNew == Integer.parseInt(plzOld)))
				{
					PersonenFertigungsverwaltung.changeAddressDataSet(vornameOld, nameOld, landNew, strNew, ortNew, hausNew, plzNew);
				}
				
				DataBase.refreshDatabase();
				DataBase.closeConnection();
				dispose();
				
				} catch (InvalidArgumentsException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
				
				
				
				
				
			 
			
		});
		btnAendern.setBounds(76, 277, 100, 23);
		contentPane.add(btnAendern);
		
		
	}
}
