package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.BauteileAuftragsabwicklung;
import Data.DataBase;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPrice extends JFrame {

	private JPanel contentPane;
	private JTextField txtPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPrice frame = new AddPrice();
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
	public AddPrice() {
		
		setBounds(100, 100, 233, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(74, 75, 86, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 78, 46, 14);
		contentPane.add(lblPrice);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String price = txtPrice.getText();
				try{
					DataBase.getConnection();
					DefaultTableModel model = (DefaultTableModel) MainMenu.tblComponents.getModel();
					//get selected row index
					int selectedRowIndex = MainMenu.tblComponents.getSelectedRow();
					System.out.println(selectedRowIndex);
					String tableClick = MainMenu.tblComponents.getModel().getValueAt(selectedRowIndex, 0).toString();
					int id = Integer.parseInt(tableClick);
					BauteileAuftragsabwicklung.addPrice(id, price);
					DataBase.refreshComponent();
					dispose();
					}
					catch (Exception ex){
						JOptionPane.showMessageDialog(null, ex);
					}finally {
						DataBase.refreshComponent();
						DataBase.closeConnection();
						
					}
			}
		});
		btnSave.setBounds(74, 106, 89, 23);
		contentPane.add(btnSave);
	}

}
