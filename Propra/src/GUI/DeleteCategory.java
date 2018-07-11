package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import Data.BauteileAuftragsabwicklung;
import Data.DataBase;
import Data.PersonenFertigungsverwaltung;
import Data.TreeBauteile;
import Data.TreeErstellen;

public class DeleteCategory extends JFrame {

	private JPanel contentPane;
	public static JTree actualTreeCategory;

	
	public DeleteCategory() {
		setTitle("Kategorie löschen");
		
		setBounds(100, 100, 400, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoYouReally = new JLabel("Möchten Sie diese Kategorie wirklich löschen?");
		lblDoYouReally.setBounds(5, 5, 374, 14);
		contentPane.add(lblDoYouReally);
		
		JButton btnDeleteCategory = new JButton("Kategorie löschen");
		btnDeleteCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)
					MainMenu.treeCategory.getLastSelectedPathComponent();
				
				DataBase.loadCategoriesToRAM();
				
				String[] categoryNames = new String[DataBase.categories.size()];
				int[] categoryIds = new int[DataBase.categories.size()];
				
				for (int i = 0; i < DataBase.categories.size(); i++) {
					categoryNames[i] = DataBase.categories.get(i).getName();
					categoryIds[i] = DataBase.categories.get(i).getIdCategory();
					System.out.println(categoryNames[i]);
					System.out.println(categoryIds[i]);
				}
				
				for (int i = 0; i< categoryNames.length; i++) {
					if (categoryNames[i].equals(node.toString())) {
						System.out.println(categoryNames[i]);
						TreeBauteile.delteTKat(categoryIds[i]);
					}
				}

				actualTreeCategory = new JTree(TreeErstellen.createTree());
				MainMenu.treeCategory = actualTreeCategory;
//				treeCategory.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//				treeCategory.addTreeSelectionListener(this);
				MainMenu.scrollPaneCategory.setViewportView(MainMenu.treeCategory);
				
				dispose();
//			    if (node == null)
//			    //Nothing is selected.     
//			    return;
		
//			    Object nodeInfo = node.getUserObject();
//			    if (node.isLeaf()) {
//			        BookInfo book = (BookInfo)nodeInfo;
//			        displayURL(book.bookURL);
//			    } else {
//			        displayURL(helpURL); 
//			    }
			    
//				DefaultTableModel model = (DefaultTableModel) MainMenu.tblCategory.getModel();
//				//get selected row index
//				int selectedRowIndex = MainMenu.tblCategory.getSelectedRow();
//				System.out.println(selectedRowIndex);
//				String tableClick = MainMenu.tblCategory.getModel().getValueAt(selectedRowIndex, 0).toString();
//				int id = Integer.parseInt(tableClick);
//				System.out.println(id);
//				BauteileAuftragsabwicklung.deleteKategorie(id);
//				
//				model.removeRow(selectedRowIndex);
//				DataBase.closeConnection();
//				dispose();
			}
		});
		btnDeleteCategory.setBounds(5, 47, 150, 23);
		contentPane.add(btnDeleteCategory);
		
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

