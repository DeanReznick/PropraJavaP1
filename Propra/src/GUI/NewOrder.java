package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.DataBase;
import Data.PersonenFertigungsverwaltung;
import Exceptions.InvalidArgumentsException;
import Exceptions.Manager;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewOrder extends JFrame {

	private JPanel contentPane;
	public static JTextField txtHeader;
	public static JTextField txtAf;
	public static JTextField txtFilename;
	public static JTextField txtRepository;
	public static JTextField txtPk;
	public static JTextField txtRk;
	public static JTextField txtName;
	public static JTextField txtSurname;
	public static JTextField txtJob;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewOrder frame = new NewOrder();
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
	public NewOrder() {
		
		setBounds(100, 100, 229, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreate = new JButton("Erstellen");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				txtHeader.setBackground(Color.WHITE);
				txtAf.setBackground(Color.WHITE);
				txtFilename.setBackground(Color.WHITE);
				txtRepository.setBackground(Color.WHITE);
				txtPk.setBackground(Color.WHITE);
				txtRk.setBackground(Color.WHITE);
				txtName.setBackground(Color.WHITE);
				txtSurname.setBackground(Color.WHITE);
				txtJob.setBackground(Color.WHITE);
				
				DataBase.getConnection();
				String header = txtHeader.getText();
				String af = txtAf.getText();
				String filename = txtFilename.getText();
				String repository = txtRepository.getText();
				String pk = txtPk.getText();
				String rk = txtRk.getText();
				String name = txtName.getText();
				String surname = txtSurname.getText();
				String job = txtJob.getText();
				
			
					Manager.checkStandardOrder(header, af, filename, repository, pk, rk, name, surname, job);
				
				
				PersonenFertigungsverwaltung.createNewOrder(header, af, filename, repository, pk, rk, name, surname, job);
				DataBase.refreshOrder();
				DataBase.refreshOrderBill();
				dispose();
				}
				catch (InvalidArgumentsException ex){
					JOptionPane.showMessageDialog(null, ex);
				}finally {
					DataBase.closeConnection();
				}
				
				
				
				
				
				
			}
		});
		btnCreate.setBounds(98, 11, 89, 23);
		contentPane.add(btnCreate);
		
		txtHeader = new JTextField();
		txtHeader.setBounds(98, 45, 86, 20);
		contentPane.add(txtHeader);
		txtHeader.setColumns(10);
		
		txtAf = new JTextField();
		txtAf.setBounds(98, 76, 86, 20);
		contentPane.add(txtAf);
		txtAf.setColumns(10);
		
		txtFilename = new JTextField();
		txtFilename.setBounds(98, 107, 86, 20);
		contentPane.add(txtFilename);
		txtFilename.setColumns(10);
		
		txtRepository = new JTextField();
		txtRepository.setBounds(98, 138, 86, 20);
		contentPane.add(txtRepository);
		txtRepository.setColumns(10);
		
		txtPk = new JTextField();
		txtPk.setBounds(98, 169, 86, 20);
		contentPane.add(txtPk);
		txtPk.setColumns(10);
		
		txtRk = new JTextField();
		txtRk.setBounds(98, 200, 86, 20);
		contentPane.add(txtRk);
		txtRk.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(98, 231, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(98, 262, 86, 20);
		contentPane.add(txtSurname);
		txtSurname.setColumns(10);
		
		txtJob = new JTextField();
		txtJob.setBounds(98, 293, 86, 20);
		contentPane.add(txtJob);
		txtJob.setColumns(10);
		
		JLabel lblTitel = new JLabel("Titel:");
		lblTitel.setBounds(10, 48, 46, 14);
		contentPane.add(lblTitel);
		
		JLabel lblAf = new JLabel("AF:");
		lblAf.setBounds(10, 79, 46, 14);
		contentPane.add(lblAf);
		
		JLabel lblDateiname = new JLabel("Dateiname:");
		lblDateiname.setBounds(10, 110, 78, 14);
		contentPane.add(lblDateiname);
		
		JLabel lblDateiort = new JLabel("Dateiort:");
		lblDateiort.setBounds(10, 141, 78, 14);
		contentPane.add(lblDateiort);
		
		JLabel lblPk = new JLabel("PK:");
		lblPk.setBounds(10, 172, 46, 14);
		contentPane.add(lblPk);
		
		JLabel lblRk = new JLabel("RK:");
		lblRk.setBounds(10, 203, 46, 14);
		contentPane.add(lblRk);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 234, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(10, 265, 78, 14);
		contentPane.add(lblSurname);
		
		JLabel lblRolle = new JLabel("Rolle:");
		lblRolle.setBounds(10, 296, 46, 14);
		contentPane.add(lblRolle);
	}
}
