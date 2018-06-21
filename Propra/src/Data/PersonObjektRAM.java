package Data;

public class PersonObjektRAM {

	int ID_Person; 
	String name; 
	String telefonnummer; 
	String mail; 
	String Timestamp; 
	String rolle; 
	String passwort; 
	String land; 
	String straﬂe; 
	String ort; 
	int plz; 
	String Hausnummer; 
	String vorname;
	/**
	 * @return the iD_Person
	 */
	public int getID_Person() {
		return ID_Person;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the telefonnummer
	 */
	public String getTelefonnummer() {
		return telefonnummer;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return Timestamp;
	}
	/**
	 * @return the rolle
	 */
	public String getRolle() {
		return rolle;
	}
	/**
	 * @return the passwort
	 */
	public String getPasswort() {
		return passwort;
	}
	/**
	 * @return the land
	 */
	public String getLand() {
		return land;
	}
	/**
	 * @return the straﬂe
	 */
	public String getStraﬂe() {
		return straﬂe;
	}
	/**
	 * @return the ort
	 */
	public String getOrt() {
		return ort;
	}
	/**
	 * @return the plz
	 */
	public int getPlz() {
		return plz;
	}
	/**
	 * @return the hausnummer
	 */
	public String getHausnummer() {
		return Hausnummer;
	}
	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}
	public PersonObjektRAM(int iD_Person, String name, String telefonnummer, String mail, String timestamp,
			String rolle, String passwort, String land, String straﬂe, String ort, int plz, String hausnummer,
			String vorname) {
		super();
		ID_Person = iD_Person;
		this.name = name;
		this.telefonnummer = telefonnummer;
		this.mail = mail;
		Timestamp = timestamp;
		this.rolle = rolle;
		this.passwort = passwort;
		this.land = land;
		this.straﬂe = straﬂe;
		this.ort = ort;
		this.plz = plz;
		Hausnummer = hausnummer;
		this.vorname = vorname;
	}
	
	public PersonObjektRAM() {
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonObjektRAM [ID_Person=" + ID_Person + ", name=" + name + ", telefonnummer=" + telefonnummer
				+ ", mail=" + mail + ", Timestamp=" + Timestamp + ", rolle=" + rolle + ", passwort=" + passwort
				+ ", land=" + land + ", straﬂe=" + straﬂe + ", ort=" + ort + ", plz=" + plz + ", Hausnummer="
				+ Hausnummer + ", vorname=" + vorname + "]";
	}
	
	
	
	
	
	
}
