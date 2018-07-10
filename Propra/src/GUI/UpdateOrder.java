package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
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

public class UpdateOrder extends JFrame {

	public JPanel contentPane;
	public static JTextField txtHeader;
	public static JTextField txtAf;
	public static JTextField txtFilename;
	public static JTextField txtRepository;
	public static JTextField txtPk;
	public static JTextField txtRk;
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
	 * @throws SQLException 
	 */
	public UpdateOrder() throws SQLException {
		setTitle("Auftragsdaten \u00E4ndern");
		Statement stmt = null;
		
		
		int colId = 0;
		int colTitel = 1;
		int colAf = 2; 
		int colDateiname = 3; 
		int colDateiort = 4; 
		int colPk= 5;
		int colRk = 6;
		int colIdStatus = 7;
		int colnr  = MainMenu.tblAuftraege.getSelectedRow();
		
		int idOld = Integer.parseInt(MainMenu.tblAuftraege.getModel().getValueAt(colnr, 0).toString());
		String headerOld = MainMenu.tblAuftraege.getModel().getValueAt(colnr, 1).toString();
		String afOld = MainMenu.tblAuftraege.getModel().getValueAt(colnr, 2).toString();
		String filenameOld = MainMenu.tblAuftraege.getModel().getValueAt(colnr, 3).toString();
		String repositoryOld = MainMenu.tblAuftraege.getModel().getValueAt(colnr, 4).toString();
		String pkOld = MainMenu.tblAuftraege.getModel().getValueAt(colnr, 5).toString();
		String rkOld = MainMenu.tblAuftraege.getModel().getValueAt(colnr, 6).toString();
		
		int colnrPers  = MainMenu.tblPersonen.getSelectedRow();
		String nameOld = MainMenu.tblPersonen.getModel().getValueAt(colnrPers, 1).toString();
		String surnameOld = MainMenu.tblPersonen.getModel().getValueAt(colnrPers, 2).toString();
		int idPerson = Integer.parseInt(MainMenu.tblPersonen.getModel().getValueAt(colnrPers, 0).toString());
		String jobOld = MainMenu.tblPersonen.getModel().getValueAt(colnrPers, 5).toString();
		
		
		
		setBounds(100, 100, 300, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtHeader = new JTextField(headerOld);
		txtHeader.setBounds(130, 8, 144, 20);
		contentPane.add(txtHeader);
		txtHeader.setColumns(10);
		
		txtAf = new JTextField(afOld);
		txtAf.setBounds(130, 33, 144, 20);
		contentPane.add(txtAf);
		txtAf.setColumns(10);
		
		txtFilename = new JTextField(filenameOld);
		txtFilename.setBounds(130, 58, 144, 20);
		contentPane.add(txtFilename);
		txtFilename.setColumns(10);
		
		txtRepository = new JTextField(repositoryOld);
		txtRepository.setBounds(130, 83, 144, 20);
		contentPane.add(txtRepository);
		txtRepository.setColumns(10);
		
		txtPk = new JTextField(pkOld);
		txtPk.setBounds(130, 108, 144, 20);
		contentPane.add(txtPk);
		txtPk.setColumns(10);
		
		txtRk = new JTextField(rkOld);
		txtRk.setBounds(130, 133, 144, 20);
		contentPane.add(txtRk);
		txtRk.setColumns(10);
		
		JLabel lblTitel = new JLabel("Titel:");
		lblTitel.setBounds(10, 11, 110, 14);
		contentPane.add(lblTitel);
		
		JLabel lblAf = new JLabel("Art der Fertigung:");
		lblAf.setBounds(10, 36, 110, 14);
		contentPane.add(lblAf);
		
		JLabel lblDateiname = new JLabel("Dateiname:");
		lblDateiname.setBounds(10, 61, 110, 14);
		contentPane.add(lblDateiname);
		
		JLabel lblDateiort = new JLabel("Dateiort:");
		lblDateiort.setBounds(10, 86, 78, 14);
		contentPane.add(lblDateiort);
		
		JLabel lblPk = new JLabel("Praktische Kosten:");
		lblPk.setBounds(10, 111, 110, 14);
		contentPane.add(lblPk);
		
		JLabel lblRk = new JLabel("Reelle Kosten:");
		lblRk.setBounds(10, 136, 110, 14);
		contentPane.add(lblRk);
		
		
		
		
		
		
		JButton btnSave = new JButton("Speichern");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
				
				
				int idNew = idOld;
				String headerNew = txtHeader.getText();
				String afNew = txtAf.getText(); 
				String filenameNew = txtFilename.getText();
				String repositoryNew = txtRepository.getText();
				String pkNew = txtPk.getText();
				String rkNew = txtRk.getText();
				String jobNew = txtJob.getText();
				
				
				Manager.checkStandardOrderUpdate(headerNew, afNew, filenameNew, repositoryNew, pkNew, rkNew);
				
				if(!headerNew.equals(headerOld) 
						||!afNew.equals(afOld) 
						||!filenameNew.equals(filenameOld)
						||!repositoryNew.equals(repositoryOld)
						||!pkNew.equals(pkOld)
						||!rkNew.equals(rkOld)
						) {
					
					
					
					PersonenFertigungsverwaltung.changeDataSetOrder(idNew, headerNew, afNew, filenameNew, repositoryNew, pkNew, rkNew);
				}
				
				
				PersonenFertigungsverwaltung.changeJobOrderPerson(idPerson, idOld, jobNew);
				
				
				
				
				
				
					
				DataBase.refreshOrder();
				DataBase.refreshOrderBill();
			
				dispose();
				}
				
				catch (InvalidArgumentsException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
				
			}
		});
		btnSave.setBounds(96, 195, 89, 23);
		contentPane.add(btnSave);
		
		txtJob = new JTextField(jobOld);
		txtJob.setBounds(130, 158, 144, 20);
		contentPane.add(txtJob);
		txtJob.setColumns(10);
		
		JLabel lblJob = new JLabel("Rolle:");
		lblJob.setBounds(10, 161, 110, 14);
		contentPane.add(lblJob);
	}
}
