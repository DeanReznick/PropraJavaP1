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

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class NewOrder extends JFrame {

	private JPanel contentPane;
	public static JTextField txtHeader;
	public static JTextField txtAf;
	public static JTextField txtFilename;
	public static JTextField txtRepository;
	public static JTextField txtPk;
	public static JTextField txtRk;
	public static JTextField txtJob;
	public static JComboBox comboBoxName;

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
		setBounds(100, 100, 350, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DataBase.loadPeopleToRAM();
		
		String[] persons = new String[DataBase.people.size()];
		String name;
		int i = 0;
		
		for (PersonObjektRAM p : DataBase.people) {
			name = p.getVorname() + " " + p.getName();
			persons[i] = name;
			i++;
		}
		
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
				comboBoxName.setBackground(Color.WHITE);
				txtJob.setBackground(Color.WHITE);
				
	
				String header = txtHeader.getText();
				String af = txtAf.getText();
				String filename = txtFilename.getText();
				String repository = txtRepository.getText();
				String pk = txtPk.getText();
				String rk = txtRk.getText();
				String name = comboBoxName.getSelectedItem().toString();
				String job = txtJob.getText();
				
			
					Manager.checkStandardOrder(header, af, filename, repository, pk, rk, name, job);
				
					String[] parts = name.split(" ");
					String firstname = parts[0];
					String lastname = parts[1];
				PersonenFertigungsverwaltung.createNewOrder(header, af, filename, repository, pk, rk, lastname, firstname, job);
				DataBase.refreshOrder();
//				DataBase.refreshOrderBill();
				dispose();
				}
				catch (InvalidArgumentsException ex){
					JOptionPane.showMessageDialog(null, ex);
				}finally {
					DataBase.loadOrdersToRAM();
					
				}
				
				
				
				
				
				
			}
		});
		btnCreate.setBounds(194, 214, 130, 23);
		contentPane.add(btnCreate);
		
		txtHeader = new JTextField();
		txtHeader.setBounds(138, 8, 186, 20);
		contentPane.add(txtHeader);
		txtHeader.setColumns(10);
		
		txtAf = new JTextField();
		txtAf.setBounds(138, 33, 186, 20);
		contentPane.add(txtAf);
		txtAf.setColumns(10);
		
		txtFilename = new JTextField();
		txtFilename.setBounds(138, 58, 186, 20);
		contentPane.add(txtFilename);
		txtFilename.setColumns(10);
		
		txtRepository = new JTextField();
		txtRepository.setBounds(138, 83, 186, 20);
		contentPane.add(txtRepository);
		txtRepository.setColumns(10);
		
		txtPk = new JTextField();
		txtPk.setBounds(138, 108, 186, 20);
		contentPane.add(txtPk);
		txtPk.setColumns(10);
		
		txtRk = new JTextField();
		txtRk.setBounds(138, 133, 186, 20);
		contentPane.add(txtRk);
		txtRk.setColumns(10);
		
		txtJob = new JTextField();
		txtJob.setBounds(138, 183, 186, 20);
		contentPane.add(txtJob);
		txtJob.setColumns(10);
		
		JLabel lblTitel = new JLabel("Titel:");
		lblTitel.setBounds(10, 11, 118, 14);
		contentPane.add(lblTitel);
		
		JLabel lblAf = new JLabel("Art der Fertigung:");
		lblAf.setBounds(10, 36, 118, 14);
		contentPane.add(lblAf);
		
		JLabel lblDateiname = new JLabel("Dateiname:");
		lblDateiname.setBounds(10, 61, 118, 14);
		contentPane.add(lblDateiname);
		
		JLabel lblDateiort = new JLabel("Dateiort:");
		lblDateiort.setBounds(10, 86, 118, 14);
		contentPane.add(lblDateiort);
		
		JLabel lblPk = new JLabel("Praktische Kosten:");
		lblPk.setBounds(10, 111, 118, 14);
		contentPane.add(lblPk);
		
		JLabel lblRk = new JLabel("Reelle Kosten:");
		lblRk.setBounds(10, 136, 118, 14);
		contentPane.add(lblRk);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 161, 118, 14);
		contentPane.add(lblName);
		
		JLabel lblRolle = new JLabel("Rolle:");
		lblRolle.setBounds(10, 186, 118, 14);
		contentPane.add(lblRolle);
		
		comboBoxName = new JComboBox(persons);
		comboBoxName.setBounds(138, 158, 186, 20);
		contentPane.add(comboBoxName);
	}
}
