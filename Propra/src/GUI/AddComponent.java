package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Data.BauteileAuftragsabwicklung;
import Data.DataBase;
import Data.TreeBauteile;

public class AddComponent extends JFrame {

	private JPanel contentPane;
	private JTextField txtLink;
	private JTextField txtName;
	private JTextField txtStock;
	private JTextField txtOrdered;
	private JTextField txtPlanned;
	private JTextField txtStorage;
	private JTextField txtPrice;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddComponent frame = new AddComponent();
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
	public AddComponent() {
		setTitle("Bauteil hinzufuegen");
		setBounds(100, 100, 312, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 33, 86, 14);
		contentPane.add(lblName);
		
		JLabel lblLink = new JLabel("Link:");
		lblLink.setBounds(10, 58, 86, 14);
		contentPane.add(lblLink);
		
		JLabel lblStock = new JLabel("Lagernd:");
		lblStock.setBounds(10, 83, 86, 14);
		contentPane.add(lblStock);
		
		JLabel lblOrdered = new JLabel("Bestellt:");
		lblOrdered.setBounds(10, 108, 86, 14);
		contentPane.add(lblOrdered);
		
		JLabel lblBauteilId = new JLabel("Geplant:");
		lblBauteilId.setBounds(10, 133, 86, 14);
		contentPane.add(lblBauteilId);
		
		JLabel lblBauteil = new JLabel("Lagerort:");
		lblBauteil.setBounds(10, 158, 73, 14);
		contentPane.add(lblBauteil);
		
		JButton btnBestaetigen = new JButton("Bestaetigen");
		btnBestaetigen.setEnabled(false);
		btnBestaetigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				
				//Test
				//BauteileAuftragsabwicklung.addPrice((BauteileAuftragsabwicklung.newBauteil(txtName.getText(), txtLink.getText(), Integer.parseInt(txtStock.getText()), Integer.parseInt(txtOrdered.getText()), Integer.parseInt(txtPlanned.getText()), txtStorage.getText())), txtPrice.getText());
				
				TreeBauteile.addTBauteil(txtName.getText(), txtLink.getText(), Integer.parseInt(txtStock.getText()),Integer.parseInt(txtOrdered.getText()),  Integer.parseInt(txtPlanned.getText()), txtStorage.getText(), Float.parseFloat(txtPrice.getText()));
				
				
				
				
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Die Mengen und der Preis m�ssen Zahlen sein.");
				}
				catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				}finally {
					DataBase.refreshComponent();
					dispose();
					
				}
			}
		});
		btnBestaetigen.setBounds(96, 262, 116, 23);
		contentPane.add(btnBestaetigen);
		
		txtLink = new JTextField();
		txtLink.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (!txtLink.getText().equals("") && !txtName.getText().equals("") && !txtLink.getText().equals("") && !txtStock.getText().equals("") && !txtOrdered.getText().equals("") && !txtPlanned.getText().equals("") && !txtStorage.getText().equals("")) {
					btnBestaetigen.setEnabled(true);
				}
			}
		});
		txtLink.setBounds(130, 55, 86, 20);
		contentPane.add(txtLink);
		txtLink.setColumns(10);
		
		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (!txtLink.getText().equals("") && !txtName.getText().equals("") && !txtLink.getText().equals("") && !txtStock.getText().equals("") && !txtOrdered.getText().equals("") && !txtPlanned.getText().equals("") && !txtStorage.getText().equals("")) {
					btnBestaetigen.setEnabled(true);
				}
			}
		});
		txtName.setBounds(130, 30, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (!txtLink.getText().equals("") && !txtName.getText().equals("") && !txtLink.getText().equals("") && !txtStock.getText().equals("") && !txtOrdered.getText().equals("") && !txtPlanned.getText().equals("") && !txtStorage.getText().equals("")) {
					btnBestaetigen.setEnabled(true);
				}
			}
		});
		txtStock.setBounds(130, 80, 86, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		txtOrdered = new JTextField();
		txtOrdered.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (!txtLink.getText().equals("") && !txtName.getText().equals("") && !txtLink.getText().equals("") && !txtStock.getText().equals("") && !txtOrdered.getText().equals("") && !txtPlanned.getText().equals("") && !txtStorage.getText().equals("")) {
					btnBestaetigen.setEnabled(true);
				}
			}
		});
		txtOrdered.setBounds(130, 105, 86, 20);
		contentPane.add(txtOrdered);
		txtOrdered.setColumns(10);
		
		txtPlanned = new JTextField();
		txtPlanned.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (!txtLink.getText().equals("") && !txtName.getText().equals("") && !txtLink.getText().equals("") && !txtStock.getText().equals("") && !txtOrdered.getText().equals("") && !txtPlanned.getText().equals("") && !txtStorage.getText().equals("")) {
					btnBestaetigen.setEnabled(true);
				}
			}
		});
		txtPlanned.setBounds(130, 130, 86, 20);
		contentPane.add(txtPlanned);
		txtPlanned.setColumns(10);
		
		txtStorage = new JTextField();
		txtStorage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (!txtLink.getText().equals("") && !txtName.getText().equals("") && !txtLink.getText().equals("") && !txtStock.getText().equals("") && !txtOrdered.getText().equals("") && !txtPlanned.getText().equals("") && !txtStorage.getText().equals("")) {
					btnBestaetigen.setEnabled(true);
				}
			}
		});
		txtStorage.setBounds(130, 155, 86, 20);
		contentPane.add(txtStorage);
		txtStorage.setColumns(10);
		
		JLabel lblPreis = new JLabel("Preis:");
		lblPreis.setBounds(10, 183, 46, 14);
		contentPane.add(lblPreis);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(130, 180, 86, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		SwingUtilities.getRootPane(btnBestaetigen).setDefaultButton(btnBestaetigen);
		
		
	}
}