package Data;

public class ComponentObjektRAM {

	int ID_Bauteil;
	int ID_Kategorie;
	String name;
	String link;
	int mengeLagernd;
	int mengeBestellt;
	int mengeGeplant;
	String lagerort;
	double preis;
	
	public int getID_Bauteil() {
		return ID_Bauteil;
	}
//	public int getID_Kategorie() {
//		return ID_Kategorie;
//	}
	public String getName() {
		return name;
	}
	public String getLink() {
		return link;
	}
	public int getMengeLagernd() {
		return mengeLagernd;
	}
	public int getMengeBestellt() {
		return mengeBestellt;
	}
	public int getMengeGeplant() {
		return mengeGeplant;
	}
	public String getLagerort() {
		return lagerort;
	}
	public int getID_Kategorie() {
		return ID_Kategorie;
	}
	public double getPreis() {
		return preis;
	}
	public ComponentObjektRAM(int iD_Bauteil, String name, String link, int mengeLagernd,
			int mengeBestellt, int mengeGeplant, String lagerort, int id_Kategorie, double preis) {
		super();
		ID_Bauteil = iD_Bauteil;
//		ID_Kategorie = iD_Kategorie;
		this.name = name;
		this.link = link;
		this.mengeLagernd = mengeLagernd;
		this.mengeBestellt = mengeBestellt;
		this.mengeGeplant = mengeGeplant;
		this.lagerort = lagerort;
		this.ID_Kategorie = id_Kategorie;
		this.preis = preis;
	}
	
	public ComponentObjektRAM() {}
	@Override
	public String toString() {
		return "ComponentObjektRAM [ID_Bauteil=" + ID_Bauteil  + ", name=" + name
				+ ", link=" + link + ", mengeLagernd=" + mengeLagernd + ", mengeBestellt=" + mengeBestellt
				+ ", mengeGeplant=" + mengeGeplant + ", lagerort=" + lagerort + "]";
	}
	
	
}
