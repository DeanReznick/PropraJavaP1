package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.BauteileAuftragsabwicklung;
import Data.DataBase;
import Data.PersonenFertigungsverwaltung;

public class DeleteComponent extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DeleteOrder frame = new DeleteOrder();
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
	public DeleteComponent() {
		setTitle("Bauteil löschen");
		
		setBounds(100, 100, 400, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoYouReally = new JLabel("Möchten Sie dieses Bauteil wirklich löschen?");
		lblDoYouReally.setBounds(5, 5, 374, 14);
		contentPane.add(lblDoYouReally);
		
		JButton btnDeleteOrder = new JButton("Bauteil löschen");
		btnDeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) MainMenu.tblComponents.getModel();
				//get selected row index
				int selectedRowIndex = MainMenu.tblComponents.getSelectedRow();
				System.out.println(selectedRowIndex);
				String tableClick = MainMenu.tblComponents.getModel().getValueAt(selectedRowIndex, 0).toString();
				int id = Integer.parseInt(tableClick);
				System.out.println(id);
				BauteileAuftragsabwicklung.deleteBauteil(id);
				
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
		btnCancel.setBounds(229, 47, 150, 23);
		contentPane.add(btnCancel);
	}
	}


