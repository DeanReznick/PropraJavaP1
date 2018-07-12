package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.Rechnungsabwicklung;

public class DeleteBillA extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteBillA frame = new DeleteBillA();
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
	public DeleteBillA() {
setTitle("Rechnung löschen");
		
		setBounds(100, 100, 503, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoYouReally = new JLabel("Möchten Sie diese Rechnung wirklich löschen? ");
		lblDoYouReally.setBounds(5, 5, 472, 14);
		contentPane.add(lblDoYouReally);
		
		JButton btnDeleteOrder = new JButton("Rechnung löschen");
		btnDeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) MainMenu.tblRechnA.getModel();
				//get selected row index
				int selectedRowIndex = MainMenu.tblRechnA.getSelectedRow();
				String tableClick = MainMenu.tblRechnA.getModel().getValueAt(selectedRowIndex, 0).toString();
				int id = Integer.parseInt(tableClick);
				Rechnungsabwicklung.delteARechnung(id);
				
				model.removeRow(selectedRowIndex);
				
				
				dispose();
			}
		});
		btnDeleteOrder.setBounds(5, 47, 150, 23);
		contentPane.add(btnDeleteOrder);
		
		JButton btnCancel = new JButton("Abbrechen");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(327, 47, 150, 23);
		contentPane.add(btnCancel);
	}

}
