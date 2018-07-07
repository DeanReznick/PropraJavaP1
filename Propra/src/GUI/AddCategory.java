package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.TreeBauteile;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCategory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;

	public AddCategory() {
		setTitle("Neue Kategorie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 194, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(214, 8, 210, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblOberkategorie = new JLabel("Oberkategorie:");
		lblOberkategorie.setBounds(10, 36, 194, 14);
		contentPane.add(lblOberkategorie);
		
		JComboBox comboBoxParent = new JComboBox();
		comboBoxParent.setBounds(214, 39, 210, 20);
		contentPane.add(comboBoxParent);
		
		JButton btnKategorieErstellen = new JButton("Kategorie erstellen");
		btnKategorieErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TreeBauteile.addTKat(Integer.parseInt(comboBoxParent.getName()), txtName.getText());
			}
		});
		btnKategorieErstellen.setBounds(140, 70, 150, 23);
		contentPane.add(btnKategorieErstellen);
	}
}
