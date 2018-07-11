package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import Data.CategoryObjektRAM;
import Data.DataBase;
import Data.TreeBauteile;
import Data.TreeErstellen;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class AlterCategory extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	public static JTree actualTreeCategory;


	public AlterCategory() {
		
		
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)
				MainMenu.treeCategory.getLastSelectedPathComponent();
			
		DataBase.loadCategoriesToRAM();
		
		String[] categoryNames = new String[DataBase.categories.size()];
		int[] categoryIds = new int[DataBase.categories.size()];
		int[] categoryParentId = new int[DataBase.categories.size()];
		String parentName = "";
		int parentId = 0;
//		String[] parentNames = new String[DataBase.categories.size()];
		
		for (int i = 0; i < DataBase.categories.size(); i++) {
			categoryNames[i] = DataBase.categories.get(i).getName();
			categoryIds[i] = DataBase.categories.get(i).getIdCategory();
			categoryParentId[i] = DataBase.categories.get(i).getIdParent();
		}

		for (CategoryObjektRAM c : DataBase.categories) {
			if (c.getName().equals(node.toString())) {
				parentId = c.getIdParent();
			}
		}
		
		for (CategoryObjektRAM c : DataBase.categories) {
			if (parentId == c.getIdCategory()) {
				parentName = c.getName();
			}
		}
		
//		for (int i = 0; i < parentNames.length; i++) {
//			System.out.println(categoryNames[i]);
//			System.out.println(categoryIds[i]);
//			System.out.println(categoryParentId[i]);
//			System.out.println(parentNames[i]);
//		}
		
			
		setTitle("Kategorie bearbeiten");
		setBounds(100, 100, 450, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 204, 14);
		contentPane.add(lblName);
		
		JLabel lblOberklasse = new JLabel("Oberklasse:");
		lblOberklasse.setBounds(10, 36, 204, 14);
		contentPane.add(lblOberklasse);
		
		txtName = new JTextField();
		txtName.setBounds(224, 8, 200, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		txtName.setText(node.toString());
		
		JComboBox comboBoxParent = new JComboBox(categoryNames);
		comboBoxParent.setBounds(224, 33, 200, 20);
		contentPane.add(comboBoxParent);
		
		for (int i = 0; i< categoryNames.length; i++) {
			if (categoryNames[i].equals(node.toString())) {
				txtName.setText(categoryNames[i]);
				comboBoxParent.setSelectedItem(parentName);
			}
		}
		
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int id = -1;
				int parentId = -1;
				
				for (int i = 0; i< categoryNames.length; i++) {
					if (categoryNames[i].equals(node.toString())) {
						id = categoryIds[i];
					}
				}
				
				for (int i = 0; i < DataBase.categories.size(); i++) {
					if (categoryNames[i].equals(comboBoxParent.getSelectedItem())) {
						parentId = categoryIds[i];
					}
				}
				
				TreeBauteile.alterTKat(id, parentId, txtName.getText());

					actualTreeCategory = new JTree(TreeErstellen.createTree());
					MainMenu.treeCategory = actualTreeCategory;
					MainMenu.scrollPaneCategory.setViewportView(MainMenu.treeCategory);
					
					dispose();
			}
		});
		btnSpeichern.setBounds(335, 64, 89, 23);
		contentPane.add(btnSpeichern);
	}
}
