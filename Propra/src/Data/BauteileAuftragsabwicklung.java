package Data;

import GUI.GUILogin;

public class BauteileAuftragsabwicklung {

	
/*	public static void main(String[] args) {
		loadOffeneAuftraege(); 
		process(16,3, "300 Euro"); 
		
		
	}*/

	
	public static void process(int id_aenderung, int aenderung, String preis ) {
		
		// pr�fen (evtl. pr�fen ob die �nderung  geht) 
		DataBase.getConnection();
		DataBase.loadAuftragID(id_aenderung);
		
		OffenerAuftragObjektRAM tmp = DataBase.offeneAuftraege.get(0); 
		
		// Bauteile �ndern Menge 
		if (aenderung <= tmp.lager) {
			//M�glich
			int menge_neu = tmp.lager - aenderung; 
			String query = "UPDATE Bauteil SET MengeLagernd = " + menge_neu + " WHERE ID_Bauteil = "+ tmp.id_bauteil +";";  
			DataBase.executeQuery(query);
			
		}else {
			
			// ERROR geht nicht. Hier der Teil ! 
		}
	
		// Auftrag erstellen 
		DataBase.getNameSurname(tmp.id_person);
		System.out.println(DataBase.people.toString());
	
		String vorname = DataBase.people.get(0).getVorname();
		String name =  DataBase.people.get(0).getName(); 
		
		System.out.println(DataBase.getIdPersonByNameSurname(name, vorname));
		PersonenFertigungsverwaltung.createNewOrder("Kauf-Bauteile: (ID) " + tmp.id_bauteil, "Mitnahme Artikel", "-", "-", preis + "", preis + "",  name, vorname, "Kunde");
		
		//String query =""; 
		//PersonenFertigungsverwaltung.addJobOrderPerson(DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn), , "Betreuer");
		
		// �nderung l�schen
		String query = "DELETE FROM �nderung WHERE ID_�nderung = " + id_aenderung +";"; 
		DataBase.executeQuery(query);
	
		DataBase.closeConnection();
		
	}
	
	
	public static void deleteAuftrag(int id_aenderung) {
		DataBase.getConnection();
		String query = "DELETE FROM �nderung WHERE ID_�nderung = " + id_aenderung +";"; 
		DataBase.executeQuery(query);
		DataBase.closeConnection();
	}
	
	public static void loadOffeneAuftraege() {
		
		DataBase.getConnection();
		DataBase.loadOffeneAuftraegeToRam();
		System.out.println(DataBase.offeneAuftraege.toString()); 
		DataBase.closeConnection();
	
	}
}
