package Data;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;

public class TreeErstellen {

	
		
	public static void addKnoten(CategoryObjektRAM obj, DefaultMutableTreeNode currentNode) {
		
		// Root	
		// Zunächst Root-Obj 
		
		
		
		
		
		
		DefaultMutableTreeNode category = null;
		
		Iterator<Integer> it = obj.c.iterator();
		
		
		System.out.println(obj.c.size());
		
		
	
		while(it.hasNext()) {
			
			Integer tmp = it.next(); 
			
			// ID -> hole Objekt -> Namne -> kommt dazu
			
			ArrayList<CategoryObjektRAM> liste =  DataBase.categories; 
			
			
			System.out.println(liste.size());
			
			Iterator<CategoryObjektRAM> it2 = liste.iterator(); 
			
			while(it2.hasNext()) {
				CategoryObjektRAM tmp_obj = it2.next(); 
				
				System.out.println("------>>>>>>" + tmp_obj.getName());
				
				if(tmp_obj.getIdCategory() == tmp.intValue()) {
					
					// Hinzufügen. 
					
					// currentnode.add(tmp_obj.getname)
					
					//System.out.println("------>>>>>>" + tmp_obj.getName());
					
					
					category = new DefaultMutableTreeNode(tmp_obj.getName());
					currentNode.add(category);
					
					addKnoten(tmp_obj, category); 
					
					
					
				}
				
				
				
			}
			
			
			
			
			// addKnoten(Objekt ID oben)

			
			
			
			
			
			
			
			
		}
		
		
		
	}

	public static DefaultMutableTreeNode createTree() {
		 DefaultMutableTreeNode top = null;

		 
	      DataBase.loadCategoriesToRAM();	
	      
	  
	      Iterator<CategoryObjektRAM> it = DataBase.categories.iterator();
	      
	      
	      
	      while(it.hasNext()) {
	    	  
	    	  CategoryObjektRAM tmp = it.next(); 
	    	  
	    	  
	    	  if(tmp.getIdCategory() == 1) {
	    		  
	    		  	top = new DefaultMutableTreeNode(tmp.getName()); 
	    		  // System.out.println("----->");
	    		   TreeErstellen.addKnoten(tmp, top);
	    		  
	    		  
	    	  }
	    	  
	    	  
	    	  
	      }
	      
	
		return top;
	}
	
	
	
	
}
