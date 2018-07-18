package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
				actualTreeCategory.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						DefaultMutableTreeNode node = (DefaultMutableTreeNode)
								actualTreeCategory.getLastSelectedPathComponent();
						
						String[] categoryNames = new String[DataBase.categories.size()];
						int[] categoryIds = new int[DataBase.categories.size()];
						
						for (int i = 0; i < DataBase.categories.size(); i++) {
							categoryNames[i] = DataBase.categories.get(i).getName();
							categoryIds[i] = DataBase.categories.get(i).getIdCategory();
						}
						
						for (int i = 0; i< categoryNames.length; i++) {
							if (categoryNames[i].equals(node.toString())) {
								System.out.println(categoryNames[i]);
								DataBase.showComponentsOfCategory(categoryIds[i]);
							}
						}
						

					}
				});
				MainMenu.treeCategory = actualTreeCategory;
//				treeCategory.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//				treeCategory.addTreeSelectionListener(this);
				MainMenu.scrollPaneCategory.setViewportView(MainMenu.treeCategory);
				
				dispose();
				} catch (InvalidArgumentsException ex) {
					JOptionPane.showMessageDialog(null, ex);
				} finally {
					MainMenu.comboBoxCategory.removeAllItems();
					DataBase.loadCategoriesToRAM();
					String[] categoryName = new String[DataBase.categories.size()];
					int index = 0;
					
					for (CategoryObjektRAM c : DataBase.categories) {
						MainMenu.comboBoxCategory.addItem(c.getName());
						index++;
					}
					
				}
				
				
			}
		});
		btnKategorieErstellen.setBounds(140, 70, 150, 23);
		contentPane.add(btnKategorieErstellen);
	}
}
