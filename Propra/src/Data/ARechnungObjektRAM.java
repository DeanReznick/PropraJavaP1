package Data;

public class ARechnungObjektRAM {
	

	int id_ARechnung; 
	String name; 
	int id_Auftraggeber; 
	int id_Ansprechpartner; 
	String art_Bezahlung; 
	float betrag; 
	String beschreibung; 
	int id_bearbeiter; 
	String timestamp; 
	int id_Auftrag; 
	int id_Topf; 
	String typ; 
	
	


	public ARechnungObjektRAM(int id_ARechnung, String name, int id_Auftraggeber, int id_Ansprechpartner,
			String art_Bezahlung, float betrag, String beschreibung, int id_bearbeiter, String timestamp,
			int id_Auftrag, int id_Topf, String typ) {
		super();
		this.id_ARechnung = id_ARechnung;
		this.name = name;
		this.id_Auftraggeber = id_Auftraggeber;
		this.id_Ansprechpartner = id_Ansprechpartner;
		this.art_Bezahlung = art_Bezahlung;
		this.betrag = betrag;
		this.beschreibung = beschreibung;
		this.id_bearbeiter = id_bearbeiter;
		this.timestamp = timestamp;
		this.id_Auftrag = id_Auftrag;
		this.id_Topf = id_Topf;
		this.typ = typ;
	}
	
	
	public int getId_ARechnung() {
		return id_ARechnung;
	}
	public String getName() {
		return name;
	}
	public int getId_Auftraggeber() {
		return id_Auftraggeber;
	}
	public int getId_Ansprechpartner() {
		return id_Ansprechpartner;
	}
	public String getArt_Bezahlung() {
		return art_Bezahlung;
	}
	public float getBetrag() {
		return betrag;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public int getId_bearbeiter() {
		return id_bearbeiter;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public int getId_Auftrag() {
		return id_Auftrag;
	}
	public int getId_Topf() {
		return id_Topf;
	}
	public String getTyp() {
		return typ;
	}
	
	@Override
	public String toString() {
		return "ARechnungObjektRAM [id_ARechnung=" + id_ARechnung + ", name=" + name + ", id_Auftraggeber="
				+ id_Auftraggeber + ", id_Ansprechpartner=" + id_Ansprechpartner + ", art_Bezahlung=" + art_Bezahlung
				+ ", betrag=" + betrag + ", beschreibung=" + beschreibung + ", id_bearbeiter=" + id_bearbeiter
				+ ", timestamp=" + timestamp + ", id_Auftrag=" + id_Auftrag + ", id_Topf=" + id_Topf + ", typ=" + typ
				+ "]";
	}
	
}