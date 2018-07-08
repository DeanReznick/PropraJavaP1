
package Data;

public class MengenTBauteilObjektRAM {

	private int id_TBauteil; 
	private int menge; 
	private int mengeLagernd;
	

	
	public MengenTBauteilObjektRAM(int id_TBauteil, int menge, int mengeLagernd) {
		super();
		this.id_TBauteil = id_TBauteil;
		this.menge = menge;
		this.mengeLagernd = mengeLagernd;
	}
	
	
	public int getId_TBauteil() {
		return id_TBauteil;
	}
	public int getMenge() {
		return menge;
	}
	public int getMengeLagernd() {
		return mengeLagernd;
	}


	@Override
	public String toString() {
		return "MengenTBauteilObjektRAM [id_TBauteil=" + id_TBauteil + ", menge=" + menge + ", mengeLagernd="
				+ mengeLagernd + "]";
	}
	
	
	
}