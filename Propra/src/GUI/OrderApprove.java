package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderApprove frame = new OrderApprove();
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
	public OrderApprove() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnBestaetigen.setBounds(10, 340, 89, 23);
		contentPane.add(btnBestaetigen);
		
		JButton btnAblehnen = new JButton("Ablehnen");
		btnAblehnen.setBounds(127, 340, 89, 23);
		contentPane.add(btnAblehnen);
		
		txtID = new JTextField();
		txtID.setBounds(130, 30, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		txtID.setEditable(false);
		
		txtName = new JTextField();
		txtName.setBounds(130, 55, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		txtName.setEditable(false);
		
		txtVorname = new JTextField();
		txtVorname.setBounds(130, 80, 86, 20);
		contentPane.add(txtVorname);
		txtVorname.setColumns(10);
		txtVorname.setEditable(false);
		
		txtRolle = new JTextField();
		txtRolle.setBounds(130, 105, 86, 20);
		contentPane.add(txtRolle);
		txtRolle.setColumns(10);
		txtRolle.setEditable(false);
		
		txtDatum = new JTextField();
		txtDatum.setBounds(130, 152, 86, 20);
		contentPane.add(txtDatum);
		txtDatum.setColumns(10);
		txtDatum.setEditable(false);
		
		txtBauteilID = new JTextField();
		txtBauteilID.setBounds(130, 177, 86, 20);
		contentPane.add(txtBauteilID);
		txtBauteilID.setColumns(10);
		
		txtBauteilName = new JTextField();
		txtBauteilName.setBounds(130, 202, 86, 20);
		contentPane.add(txtBauteilName);
		txtBauteilName.setColumns(10);
		
		txtMenge = new JTextField();
		txtMenge.setBounds(130, 227, 86, 20);
		contentPane.add(txtMenge);
		txtMenge.setColumns(10);
		
		txtLagernd = new JTextField();
		txtLagernd.setBounds(130, 252, 86, 20);
		contentPane.add(txtLagernd);
		txtLagernd.setColumns(10);
		txtLagernd.setEditable(false);
	}
}
