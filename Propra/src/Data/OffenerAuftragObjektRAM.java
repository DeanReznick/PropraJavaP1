package Data;

public class OffenerAuftragObjektRAM {

	int id_aenderung; 
	int id_bauteil; 
	int id_person; 
	String name;
	String vorname;
	String timestamp; 
	int aenderung; 
	int lager;
	
	
	
	public OffenerAuftragObjektRAM(int id_aenderung, int id_bauteil, int id_person, String name, String vorname,
			String timestamp, int aenderung, int lager) {

		this.id_aenderung = id_aenderung;
		this.id_bauteil = id_bauteil;
		this.id_person = id_person;
		this.name = name;
		this.vorname = vorname;
		this.timestamp = timestamp;
		this.aenderung = aenderung;
		this.lager = lager;
	}
	
	
	public String toString() {
		return "OffenerAuftragObjektRAM [id_aenderung=" + id_aenderung + ", id_bauteil=" + id_bauteil + ", id_person="
				+ id_person + ", name=" + name + ", vorname=" + vorname + ", timestamp=" + timestamp + ", aenderung="
				+ aenderung + ", lager=" + lager + "]";
	}
	/**
	 * @return the id_aenderung
	 */
	public int getid_aenderung() {
		return id_aenderung;
	}
	/**
	 * @return the id_bauteil
	 */
	public int getId_bauteil() {
		return id_bauteil;
	}
	/**
	 * @return the id_person
	 */
	public int getId_person() {
		return id_person;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * @return the aenderung
	 */
	public int getAenderung() {
		return aenderung;
	}
	/**
	 * @return the lager
	 */
	public int getLager() {
		return lager;
	}
	
	
	
	
}
