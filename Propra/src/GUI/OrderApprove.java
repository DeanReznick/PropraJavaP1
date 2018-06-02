package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.BauteileAuftragsabwicklung;
import Data.DataBase;
import Data.PersonenFertigungsverwaltung;
import Exceptions.InvalidArgumentsException;
import Exceptions.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OrderApprove extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtVorname;
	private JTextField txtRolle;
	private JTextField txtDatum;
	private JTextField txtBauteilID;
	private JTextField txtBauteilName;
	private JTextField txtMenge;
	private JTextField txtLagernd;
	private JTextField txtPrice;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OrderApprove frame = new OrderApprove();
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
	public OrderApprove() {
		
		DataBase.getConnection();
		
		int colnr  = MainMenu.tblOffeneAuftraege.getSelectedRow();
		
		String idAenderung = MainMenu.tblOffeneAuftraege.getModel().getValueAt(colnr, 0).toString();
		String lastName = MainMenu.tblOffeneAuftraege.getModel().getValueAt(colnr, 4).toString();
		String firstName = MainMenu.tblOffeneAuftraege.getModel().getValueAt(colnr, 3).toString();
		String role = DataBase.getRolleByPersonId(MainMenu.tblOffeneAuftraege.getModel().getValueAt(colnr, 2).toString());
		String date = MainMenu.tblOffeneAuftraege.getModel().getValueAt(colnr, 5).toString();
		String idComponent = MainMenu.tblOffeneAuftraege.getModel().getValueAt(colnr, 1).toString();
		String component = DataBase.getBauteilName(Integer.parseInt(MainMenu.tblOffeneAuftraege.getModel().getValueAt(colnr, 1).toString()));
		String amount = MainMenu.tblOffeneAuftraege.getModel().getValueAt(colnr, 6).toString();
		int[] amounts = DataBase.getMengenBauteile(Integer.parseInt(MainMenu.tblOffeneAuftraege.getModel().getValueAt(colnr, 1).toString()));
		String stock = Integer.toString(amounts[0]);
		
		setBounds(100, 100, 312, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 58, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setBounds(10, 83, 46, 14);
		contentPane.add(lblVorname);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 33, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblRolle = new JLabel("Rolle:");
		lblRolle.setBounds(10, 108, 46, 14);
		contentPane.add(lblRolle);
		
		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setBounds(10, 155, 46, 14);
		contentPane.add(lblDatum);
		
		JLabel lblBauteilId = new JLabel("Bauteil ID:");
		lblBauteilId.setBounds(10, 180, 61, 14);
		contentPane.add(lblBauteilId);
		
		JLabel lblBauteil = new JLabel("Bauteil:");
		lblBauteil.setBounds(10, 205, 46, 14);
		contentPane.add(lblBauteil);
		
		JLabel lblMenge = new JLabel("Menge:");
		lblMenge.setBounds(10, 230, 46, 14);
		contentPane.add(lblMenge);
		
		JLabel lblMengeLagernd = new JLabel("Auf Lager:");
		lblMengeLagernd.setBounds(10, 255, 89, 14);
		contentPane.add(lblMengeLagernd);
		
		JButton btnBestaetigen = new JButton("Bestaetigen");
		btnBestaetigen.setEnabled(false);
		btnBestaetigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				DataBase.getConnection();
				
				BauteileAuftragsabwicklung.process(Integer.parseInt(idAenderung), Integer.parseInt(amount), txtPrice.getText());
			
				dispose();
				}
				catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				}finally {
					DataBase.refreshChange();
					DataBase.refreshOrder();
					DataBase.closeConnection();
				}
			}
		});
		btnBestaetigen.setBounds(10, 340, 89, 23);
		contentPane.add(btnBestaetigen);
		
		JButton btnAblehnen = new JButton("Ablehnen");
		btnAblehnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BauteileAuftragsabwicklung.deleteAuftrag(Integer.parseInt(idAenderung));
				DataBase.refreshChange();
				
			}
		});
		btnAblehnen.setBounds(127, 340, 89, 23);
		contentPane.add(btnAblehnen);
		
		txtID = new JTextField(idAenderung);
		txtID.setBounds(130, 30, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		txtID.setEditable(false);
		
		txtName = new JTextField(lastName);
		txtName.setBounds(130, 55, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		txtName.setEditable(false);
		
		txtVorname = new JTextField(firstName);
		txtVorname.setBounds(130, 80, 86, 20);
		contentPane.add(txtVorname);
		txtVorname.setColumns(10);
		txtVorname.setEditable(false);
		
		txtRolle = new JTextField(role);
		txtRolle.setBounds(130, 105, 86, 20);
		contentPane.add(txtRolle);
		txtRolle.setColumns(10);
		txtRolle.setEditable(false);
		
		txtDatum = new JTextField(date);
		txtDatum.setBounds(130, 152, 86, 20);
		contentPane.add(txtDatum);
		txtDatum.setColumns(10);
		txtDatum.setEditable(false);
		
		txtBauteilID = new JTextField(idComponent);
		txtBauteilID.setEditable(false);
		txtBauteilID.setBounds(130, 177, 86, 20);
		contentPane.add(txtBauteilID);
		txtBauteilID.setColumns(10);
		
		txtBauteilName = new JTextField("<dynamic>");
		txtBauteilName.setEditable(false);
		txtBauteilName.setBounds(130, 202, 86, 20);
		contentPane.add(txtBauteilName);
		txtBauteilName.setColumns(10);
		
		txtMenge = new JTextField(amount);
		txtMenge.setBounds(130, 227, 86, 20);
		contentPane.add(txtMenge);
		txtMenge.setColumns(10);
		
		txtLagernd = new JTextField(stock);
		txtLagernd.setBounds(130, 252, 86, 20);
		contentPane.add(txtLagernd);
		txtLagernd.setColumns(10);
		txtLagernd.setEditable(false);
		
		JLabel lblPreis = new JLabel("Preis:");
		lblPreis.setBounds(10, 315, 46, 14);
		contentPane.add(lblPreis);
		
		txtPrice = new JTextField();
		txtPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (!txtPrice.getText().equals("")) {
					btnBestaetigen.setEnabled(true);
				} else {
				btnBestaetigen.setEnabled(false);
				}
			}
		});
		txtPrice.setBounds(127, 312, 86, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		DataBase.closeConnection();
	}
}
