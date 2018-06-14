package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.DataBase;
import Data.Finanzverwaltung;

public class DeleteTopf extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DeleteTopf frame = new DeleteTopf();
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
	public DeleteTopf() {
		setTitle("Topf l�schen");
		DataBase.getConnection();
		setBounds(100, 100, 400, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoYouReally = new JLabel("M�chten Sie diesen Topf wirklich l�schen?");
		lblDoYouReally.setBounds(5, 5, 374, 14);
		contentPane.add(lblDoYouReally);
		
		JButton btnDeleteTopf = new JButton("Topf l�schen");
		btnDeleteTopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				DefaultTableModel model = (DefaultTableModel) MainMenu.tblTopf.getModel();
				//get selected row index
				int selectedRowIndex = MainMenu.tblTopf.getSelectedRow();
				System.out.println(selectedRowIndex);
				String tableClick = MainMenu.tblTopf.getModel().getValueAt(selectedRowIndex, 0).toString();
				int id = Integer.parseInt(tableClick);
				System.out.println(id);
				Finanzverwaltung.deleteTopf(id);
				
				model.removeRow(selectedRowIndex);
				DataBase.refreshKasse();
				
				dispose();
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie einen Topf aus, den Sie l�schen m�chten.");
					dispose();
				} finally {
					DataBase.closeConnection();
				}
			}
		});
		btnDeleteTopf.setBounds(5, 47, 150, 23);
		contentPane.add(btnDeleteTopf);
		
		JButton btnCancel = new JButton("Abbrechen");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(229, 47, 150, 23);
		contentPane.add(btnCancel);
	}
	}

