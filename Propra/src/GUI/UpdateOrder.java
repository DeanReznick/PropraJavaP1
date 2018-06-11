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
		Statement stmt = null;
		DataBase.getConnection();
		
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
		
		
		
		setBounds(100, 100, 229, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtHeader = new JTextField(headerOld);
		txtHeader.setBounds(98, 45, 86, 20);
		contentPane.add(txtHeader);
		txtHeader.setColumns(10);
		
		txtAf = new JTextField(afOld);
		txtAf.setBounds(98, 76, 86, 20);
		contentPane.add(txtAf);
		txtAf.setColumns(10);
		
		txtFilename = new JTextField(filenameOld);
		txtFilename.setBounds(98, 107, 86, 20);
		contentPane.add(txtFilename);
		txtFilename.setColumns(10);
		
		txtRepository = new JTextField(repositoryOld);
		txtRepository.setBounds(98, 138, 86, 20);
		contentPane.add(txtRepository);
		txtRepository.setColumns(10);
		
		txtPk = new JTextField(pkOld);
		txtPk.setBounds(98, 169, 86, 20);
		contentPane.add(txtPk);
		txtPk.setColumns(10);
		
		txtRk = new JTextField(rkOld);
		txtRk.setBounds(98, 200, 86, 20);
		contentPane.add(txtRk);
		txtRk.setColumns(10);
		
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
		
		
		
		
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBase.getConnection();
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
				DataBase.closeConnection();
				dispose();
				}
				
				catch (InvalidArgumentsException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
				
			}
		});
		btnSave.setBounds(98, 11, 89, 23);
		contentPane.add(btnSave);
		
		txtJob = new JTextField(jobOld);
		txtJob.setBounds(98, 293, 86, 20);
		contentPane.add(txtJob);
		txtJob.setColumns(10);
		
		JLabel lblJob = new JLabel("Job:");
		lblJob.setBounds(10, 296, 46, 14);
		contentPane.add(lblJob);
	}
}
