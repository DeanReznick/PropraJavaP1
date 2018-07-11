package Data;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryObjektRAM {

	int idCategory;
	int idParent;
	String name;
	ArrayList<Integer> c = new ArrayList<Integer>(); 
	
						
	
	
	public void fillChildren() throws SQLException {
		
		
		// Was ist meine ID 
		// Welche kat haben diese ID als Parent. 
		// Diese Kat in Liste. 
		
		
		c.removeAll(c); 
		
		
		
		c = DataBase.getIDParents(idCategory);
	
		
		
		
		
	}
	
	
	public CategoryObjektRAM(int idCategory, int idParent, String name) {
		super();
		this.idCategory = idCategory;
		this.idParent = idParent;
		this.name = name;
	}
	
	public CategoryObjektRAM() {}
	
	public int getIdCategory() {
		return idCategory;
	}
	public int getIdParent() {
		return idParent;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "CategoryObjektRAM [idCategory=" + idCategory + ", idParent=" + idParent + ", name=" + name + "]";
	}
}
