package Data;

public class CategoryObjektRAM {

	int idCategory;
	int idParent;
	String name;
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
