package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.DataBase;
import Data.PersonenFertigungsverwaltung;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private static final long serialVersionUID = 1L;
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
		setTitle("Person l\u00F6schen");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int selectedRow = MainMenu.tblPersonen.getSelectedRow();
		String firstName = MainMenu.tblPersonen.getModel().getValueAt(selectedRow, 2).toString();
		String lastName = MainMenu.tblPersonen.getModel().getValueAt(selectedRow, 1).toString();
		
		JLabel lblDoYouReally = new JLabel("M�chten Sie die Person " + firstName + " " + lastName + " wirklich l�schen?");
		lblDoYouReally.setBounds(5, 5, 374, 14);
		contentPane.add(lblDoYouReally);
		
		JButton btnDeletePerson = new JButton("Person l�schen");
		btnDeletePerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) MainMenu.tblPersonen.getModel();
				//get selected row index
				int selectedRowIndex = MainMenu.tblPersonen.getSelectedRow();
				String tableClick = MainMenu.tblPersonen.getModel().getValueAt(selectedRowIndex, 0).toString();
				int id = Integer.parseInt(tableClick);
				
				
				boolean result = PersonenFertigungsverwaltung.deletePersonById(id);
				
				if (result == true) {
					model.removeRow(selectedRowIndex);
					DataBase.loadPeopleToRAM();
					
				
				}else {
					JOptionPane.showMessageDialog(null, "Unzulaessige Aktion", "Unzulaessige Aktion" , JOptionPane.ERROR_MESSAGE);
				}
				
				dispose();
			}
		});
		btnDeletePerson.setBounds(5, 47, 150, 23);
		contentPane.add(btnDeletePerson);
		
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
