package Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import GUI.GUILogin;

public class BauteileAuftragsabwicklung {

	
	public static void main(String[] args) {
		
		newBauteil("CNC", "-", 2, 0, 2, "Gebäude C"); 
		
	}

	
	public static void process(int id_aenderung, int aenderung, String preis ) {
	
		
		// prüfen (evtl. prüfen ob die Änderung  geht) 
		DataBase.getConnection();
		DataBase.loadAuftragID(id_aenderung);
		
		OffenerAuftragObjektRAM tmp = DataBase.offeneAuftraege.get(0); 
		
		if (aenderung < 0) {
			aenderung *= (-1); 
		}
		
		// Bauteile ändern Menge 
		if (aenderung <= tmp.lager) {
			//Möglich
			int menge_neu = tmp.lager - aenderung; 
			String query = "UPDATE Bauteil SET MengeLagernd = " + menge_neu + " WHERE ID_Bauteil = "+ tmp.id_bauteil +";";  
			DataBase.executeQuery(query);
			
			
			// Auftrag erstellen 
			DataBase.getNameSurname(tmp.id_person);
			System.out.println(DataBase.people.toString());
		
			String vorname = DataBase.people.get(0).getVorname();
			String name =  DataBase.people.get(0).getName(); 
			
			System.out.println(DataBase.getIdPersonByNameSurname(name, vorname));
			PersonenFertigungsverwaltung.createNewOrder("Kauf-Bauteile: (ID) " + tmp.id_bauteil, "Mitnahme Artikel", "-", "-", preis + "", preis + "",  name, vorname, "Kunde");
			
			//String query =""; 
			//PersonenFertigungsverwaltung.addJobOrderPerson(DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn), , "Betreuer");
			
			// Änderung löschen
			query = "DELETE FROM Änderung WHERE ID_Änderung = " + id_aenderung +";"; 
			DataBase.executeQuery(query);
		
			DataBase.closeConnection();
			
			
		}else {
			
			// ERROR geht nicht. Hier der Teil ! 
		}
	
	
		
	}
	
	public static void calculateMengeBestellt(int id_bauteil) {
		
		int [] mengen = null; 
		
		DataBase.getConnection();
		mengen = DataBase.getMengenBauteile(id_bauteil); 		
		DataBase.closeConnection();
		
		try {
			int change = mengen[2] - mengen[0]; 
			
			String query = "UPDATE Bauteil" + 
					"SET MengeBestellt = "+ change +" WHERE ID_Bauteil =" + id_bauteil +";";
			
			DataBase.getConnection();
			DataBase.executeQuery(query);
			DataBase.closeConnection();
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	}
	
	public static void calculateMengeLagernd(int id_bauteil) {
		
		int [] mengen = null; 
		
		DataBase.getConnection();
		mengen = DataBase.getMengenBauteile(id_bauteil); 		
		DataBase.closeConnection();
		
		try {
			
			int change = mengen[0] + mengen[1]; 
			String query = "UPDATE Bauteil" + 
					"SET MengeBestellt = 0 WHERE ID_Bauteil =" + id_bauteil +";";
			DataBase.getConnection();
			DataBase.executeQuery(query);
			DataBase.closeConnection();
			
			query = "UPDATE Bauteil" + 
					"SET MengeLagernd = "+ change +" WHERE ID_Bauteil =" + id_bauteil +";";
			DataBase.getConnection();
			DataBase.executeQuery(query);
			DataBase.closeConnection();
			
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		
	}
	
	public static void newBauteil(String name, String link, int mengeLagernd, int mengeBestellt, int mengeGeplant, String lagerort) {
		DataBase.getConnection();
		String query = "INSERT INTO Bauteil (Name, Link, MengeLagernd, MengeBestellt, MengeGeplant, Lagerort) VALUES ('" + name +"','"+ link +"'," + mengeLagernd +"," + mengeBestellt + "," + mengeGeplant + ",'"+ lagerort +"');";
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
		DataBase.getConnection();
		int id_current = DataBase.getSpecificID("ID_Max", "SELECT max(ID_Bauteil) as ID_Max FROM Bauteil;");
		DataBase.closeConnection();
		
		
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		
		DataBase.getConnection();
		query = "INSERT INTO 'Mischtabelle-Kategorie-Bauteil' (ID_Kategorie, ID_Bauteil, Timestamp) VALUES ( 1 , " + id_current + ",'"+ timeStamp + "');";
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
		
		
	}
	public static void deleteBauteil(int id_bauteil) {
		DataBase.getConnection();
		String query = "DELETE FROM Bauteil WHERE ID_Bauteil = "+ id_bauteil +";"; 
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
	}
	public static void changeBauteil(int id_Bauteil, String name, String link, int mengeLagernd, int mengeBestellt, int mengeGeplant, String lagerort) {
		
		String query = "UPDATE Bauteil SET Name = '"+ name +"', link = '"+ link +"', MengeLagernd =" + mengeLagernd + ", MengeBestellt = " + mengeBestellt + ", MengeGeplant = " + mengeGeplant + ", Lagerort ='" + lagerort + "' WHERE ID_Bauteil =" + id_Bauteil +";";
		DataBase.executeQuery(query);
		
	}
	
	
	public static void deleteAuftrag(int id_aenderung) {
		DataBase.getConnection();
		String query = "DELETE FROM Änderung WHERE ID_Änderung = " + id_aenderung +";"; 
		DataBase.executeQuery(query);
		DataBase.closeConnection();
	}
	
	public static void loadOffeneAuftraege() {
		
		DataBase.getConnection();
		DataBase.loadOffeneAuftraegeToRam();
		System.out.println(DataBase.offeneAuftraege.toString()); 
		DataBase.closeConnection();
	
	}
	
	// Kategorie
	
	public static void createKategorie(String name) {
		
		DataBase.getConnection();
		String query = "INSERT INTO Kategorie (Name) VALUES ('"+ name +"');"; 
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
	}

	public static void renameKategrie(int id_Kategorie, String name) {
		
		DataBase.getConnection();
		String query = "UPDATE Kategorie SET Name = '"+ name +"' WHERE ID_Kategorie = "+ id_Kategorie +";"; 
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
		
	}
	
	public static void deleteKategorie(int id_Kategorie) {
		DataBase.getConnection();
		String query = "DELETE FROM Kategorie WHERE ID_Kategorie = "+ id_Kategorie +";"; 
		DataBase.executeQuery(query);
		
		DataBase.getConnection();
		query = "DELETE FROM 'Mischtabelle-Kategorie-Bauteil' WHERE ID_Kategorie = "+ id_Kategorie +";"; 
		DataBase.executeQuery(query);
		DataBase.closeConnection();
	}
	
	public static void addBauteilToKategorie(int id_Kategorie, int id_Bauteil) {
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		
		DataBase.getConnection();
		String query = "INSERT INTO 'Mischtabelle-Kategorie-Bauteil' (ID_Kategorie, ID_Bauteil, Timestamp) VALUES (" + id_Kategorie+ " , " + id_Bauteil + ",'"+ timeStamp + "');";
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
	}
	
	public static void deleteBauteilFromKategorie(int id_Bauteil) {
		DataBase.getConnection();
		String query = "DELETE FROM 'Mischtabelle-Kategorie-Bauteil' WHERE ID_Bauteil = "+ id_Bauteil +";"; 
		DataBase.executeQuery(query);
		DataBase.closeConnection();
	}
	
}
