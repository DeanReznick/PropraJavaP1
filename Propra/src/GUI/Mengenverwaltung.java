package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.BauteileAuftragsabwicklung;
import Data.DataBase;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Mengenverwaltung extends JFrame {

	private JPanel contentPane;
	private JTextField txtMenge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mengenverwaltung frame = new Mengenverwaltung();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mengenverwaltung() {
		int colnr  = MainMenu.tblComponents.getSelectedRow();
		int bauteil_id = Integer.parseInt(MainMenu.tblComponents.getModel().getValueAt(colnr, 0).toString());
		
		System.out.println(bauteil_id);
		
		
		setBounds(100, 100, 235, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAutomatischeBestellung = new JButton("Automatische Bestellung");
		btnAutomatischeBestellung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BauteileAuftragsabwicklung.calculateMengeBestellt(bauteil_id);
				DataBase.refreshComponent();
			}
		});
		btnAutomatischeBestellung.setBounds(26, 150, 167, 23);
		contentPane.add(btnAutomatischeBestellung);
		
		JButton btnBestaetigung = new JButton("Lieferung angekommen");
		btnBestaetigung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BauteileAuftragsabwicklung.calculateMengeLagernd(bauteil_id);
				DataBase.refreshComponent();
			}
		});
		btnBestaetigung.setBounds(26, 195, 167, 23);
		contentPane.add(btnBestaetigung);
		
		txtMenge = new JTextField();
		txtMenge.setBounds(107, 57, 86, 20);
		contentPane.add(txtMenge);
		txtMenge.setColumns(10);
		
		JLabel lblMenge = new JLabel("Menge:");
		lblMenge.setBounds(26, 60, 60, 14);
		contentPane.add(lblMenge);
		
		JButton btnBestellen = new JButton("Bestellen");
		btnBestellen.setBounds(26, 88, 167, 23);
		contentPane.add(btnBestellen);
	}
}
