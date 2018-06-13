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
		setTitle("Neuen Auftrag erstellen");
		setBounds(100, 100, 250, 396);
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
		btnCreate.setBounds(135, 11, 89, 23);
		contentPane.add(btnCreate);
		
		txtHeader = new JTextField();
		txtHeader.setBounds(138, 45, 86, 20);
		contentPane.add(txtHeader);
		txtHeader.setColumns(10);
		
		txtAf = new JTextField();
		txtAf.setBounds(138, 76, 86, 20);
		contentPane.add(txtAf);
		txtAf.setColumns(10);
		
		txtFilename = new JTextField();
		txtFilename.setBounds(138, 107, 86, 20);
		contentPane.add(txtFilename);
		txtFilename.setColumns(10);
		
		txtRepository = new JTextField();
		txtRepository.setBounds(138, 135, 86, 20);
		contentPane.add(txtRepository);
		txtRepository.setColumns(10);
		
		txtPk = new JTextField();
		txtPk.setBounds(138, 166, 86, 20);
		contentPane.add(txtPk);
		txtPk.setColumns(10);
		
		txtRk = new JTextField();
		txtRk.setBounds(138, 197, 86, 20);
		contentPane.add(txtRk);
		txtRk.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(138, 228, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(138, 259, 86, 20);
		contentPane.add(txtSurname);
		txtSurname.setColumns(10);
		
		txtJob = new JTextField();
		txtJob.setBounds(138, 290, 86, 20);
		contentPane.add(txtJob);
		txtJob.setColumns(10);
		
		JLabel lblTitel = new JLabel("Titel:");
		lblTitel.setBounds(10, 48, 118, 14);
		contentPane.add(lblTitel);
		
		JLabel lblAf = new JLabel("Art der Fertigung:");
		lblAf.setBounds(10, 79, 118, 14);
		contentPane.add(lblAf);
		
		JLabel lblDateiname = new JLabel("Dateiname:");
		lblDateiname.setBounds(10, 110, 118, 14);
		contentPane.add(lblDateiname);
		
		JLabel lblDateiort = new JLabel("Dateiort:");
		lblDateiort.setBounds(10, 141, 118, 14);
		contentPane.add(lblDateiort);
		
		JLabel lblPk = new JLabel("Praktische Kosten:");
		lblPk.setBounds(10, 172, 118, 14);
		contentPane.add(lblPk);
		
		JLabel lblRk = new JLabel("Reelle Kosten:");
		lblRk.setBounds(10, 203, 118, 14);
		contentPane.add(lblRk);
		
		JLabel lblName = new JLabel("Nachname:");
		lblName.setBounds(10, 234, 118, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Vorname:");
		lblSurname.setBounds(10, 265, 118, 14);
		contentPane.add(lblSurname);
		
		JLabel lblRolle = new JLabel("Rolle:");
		lblRolle.setBounds(10, 296, 118, 14);
		contentPane.add(lblRolle);
	}
}
