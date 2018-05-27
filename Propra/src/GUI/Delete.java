package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.DataBase;
import Data.PersonenFertigungsverwaltung;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Delete frame = new Delete();
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
	public Delete() {
		DataBase.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoYouReally = new JLabel("Do you really want to delete this person?");
		lblDoYouReally.setBounds(5, 5, 374, 14);
		contentPane.add(lblDoYouReally);
		
		JButton btnDeletePerson = new JButton("Delete Person");
		btnDeletePerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) MainMenu.tblPersonen.getModel();
				//get selected row index
				int selectedRowIndex = MainMenu.tblPersonen.getSelectedRow();
				String tableClick = MainMenu.tblPersonen.getModel().getValueAt(selectedRowIndex, 0).toString();
				int id = Integer.parseInt(tableClick);
				PersonenFertigungsverwaltung.deletePersonById(id);
				
				model.removeRow(selectedRowIndex);
				DataBase.closeConnection();
				dispose();
			}
		});
		btnDeletePerson.setBounds(5, 47, 150, 23);
		contentPane.add(btnDeletePerson);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(229, 47, 150, 23);
		contentPane.add(btnCancel);
	}

}
