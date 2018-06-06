package Data;

public class OrderObjektRAM {

	private int id_Auftrag; 
	private String titel; 
	private String af; 
	private String rk;
	
	public OrderObjektRAM(int id_Auftrag, String titel, String af, String rk) {
		super();
		this.id_Auftrag = id_Auftrag;
		this.titel = titel;
		this.af = af;
		this.rk = rk;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id_Auftrag=" + id_Auftrag + ", titel=" + titel + ", af=" + af + ", rk=" + rk + "] ; ";
	} 
	
}
