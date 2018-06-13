package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import Data.DataBase;
import Data.PersonenFertigungsverwaltung;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlterStatus extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Status;
	private int id_order = 0;


	
	
	public AlterStatus(int id_order) {
		setTitle("Status ändern");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 77);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_Status = new JTextField();
		txt_Status.setBounds(76, 8, 239, 20);
		contentPane.add(txt_Status);
		txt_Status.setColumns(10);
		this.id_order = id_order; 
		
		JButton btnNewButton = new JButton("Ändern");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				PersonenFertigungsverwaltung.alterStatus(id_order, txt_Status.getText());
				DataBase.refreshOrder();
				dispose(); 
				 
				
				
			}
		});
		btnNewButton.setBounds(325, 7, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewStatus = new JLabel("Neuer Status:");
		lblNewStatus.setBounds(10, 11, 70, 14);
		contentPane.add(lblNewStatus);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txt_Status, btnNewButton}));
	}

}
