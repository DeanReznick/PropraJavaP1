package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.BauteileAuftragsabwicklung;
import Data.DataBase;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddToCategory extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddToCategory frame = new AddToCategory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddToCategory(){
		
		int count = MainMenu.tblCategory.getRowCount();
		String[] list = new String[count];
		
		
		
		for(int row=0; row < MainMenu.tblCategory.getRowCount(); row++) {
		 String name = MainMenu.tblCategory.getModel().getValueAt(row, 0).toString();
		 list[row] = name;
		
		}
		
		int selectedRowIndex = MainMenu.tblComponents.getSelectedRow();
		int component_id = Integer.parseInt(MainMenu.tblComponents.getModel().getValueAt(selectedRowIndex, 0).toString());
		
		
		
		      
		   
		
		
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(list);
		comboBox.setBounds(10, 100, 129, 20);
		contentPane.add(comboBox);
		
		int category_id = Integer.parseInt(comboBox.getSelectedItem().toString());
		JLabel lblKategorie = new JLabel("Kategorie:");
		lblKategorie.setBounds(10, 75, 129, 14);
		contentPane.add(lblKategorie);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BauteileAuftragsabwicklung.addBauteilToKategorie(category_id, component_id);
			}
		});
		btnAdd.setBounds(149, 99, 89, 23);
		contentPane.add(btnAdd);
	}
}
