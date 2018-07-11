package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.TreeSelectionModel;

import Data.CategoryObjektRAM;
import Data.DataBase;
import Data.TreeBauteile;
import Data.TreeErstellen;
import Exceptions.InvalidArgumentsException;
import Exceptions.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class AddCategory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	public static JTree actualTreeCategory;

	public AddCategory() {
		setTitle("Neue Kategorie");
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
		
		
		Iterator<CategoryObjektRAM> it = DataBase.categories.iterator(); 
		
		
		while(it.hasNext()) {
			CategoryObjektRAM tmp = it.next(); 
			
			comboBoxParent.addItem(tmp.getName());
			
		}
		
		
		
		
		JButton btnKategorieErstellen = new JButton("Kategorie erstellen");
		btnKategorieErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				int index = comboBoxParent.getSelectedIndex(); 
				
				CategoryObjektRAM obj = DataBase.categories.get(index); 
				
				int id = obj.getIdCategory(); 
				
				System.out.println(id);
				
				Manager.duplicateCategory(txtName.getText());
				
				TreeBauteile.addTKat(id, txtName.getText());
				
				actualTreeCategory = new JTree(TreeErstellen.createTree());
				MainMenu.treeCategory = actualTreeCategory;
//				treeCategory.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//				treeCategory.addTreeSelectionListener(this);
				MainMenu.scrollPaneCategory.setViewportView(MainMenu.treeCategory);
				
				dispose();
				} catch (InvalidArgumentsException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
				
			}
		});
		btnKategorieErstellen.setBounds(140, 70, 150, 23);
		contentPane.add(btnKategorieErstellen);
	}
}
