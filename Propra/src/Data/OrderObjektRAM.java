package Data;

public class OrderObjektRAM {

	private int id_Auftrag; 
	private String titel; 
	private String af; 
	private String rk;
	private String pk;
	private String dateiname;
	private String dateiort;
	
	public OrderObjektRAM(int id_Auftrag, String titel, String af, String dateiname, String dateiort, String pk, String rk) {
		super();
		this.id_Auftrag = id_Auftrag;
		this.titel = titel;
		this.af = af;
		this.dateiname = dateiname;
		this.dateiort = dateiort;
		this.pk = pk;
		this.rk = rk;
	}

	
	public int getId_Auftrag() {
		return id_Auftrag;
	}


	public String getTitel() {
		return titel;
	}


	public String getAf() {
		return af;
	}


	public String getRk() {
		return rk;
	}


	public String getPk() {
		return pk;
	}


	public String getDateiname() {
		return dateiname;
	}


	public String getDateiort() {
		return dateiort;
	}


	public OrderObjektRAM() {
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id_Auftrag=" + id_Auftrag + ", titel=" + titel + ", af=" + af + ", rk=" + rk + "] ; ";
	} 
	
}
