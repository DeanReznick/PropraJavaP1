package Data;

import java.beans.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import GUI.GUILogin;

public class BauteileAuftragsabwicklung {

	public static String currentPrice = "leer."; 
	/*public static void main(String[] args) {
		
		newBauteil("CNC", "-", 2, 0, 2, "Gebäude C"); 
		
	}*/

	
	public static void process(int id_aenderung, int aenderung, String preis ) {
	
		
		// prüfen (evtl. prüfen ob die Änderung  geht) 
		
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
			PersonenFertigungsverwaltung.createNewOrder("Kauf-Bauteile: ID: " + tmp.id_bauteil  + ", Menge: " + aenderung, "Mitnahme Artikel", "-", "-", preis + "", preis + "",  name, vorname, "Kunde");
			
			//String query =""; 
			//PersonenFertigungsverwaltung.addJobOrderPerson(DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn), , "Betreuer");
			
			// Änderung löschen
			query = "DELETE FROM Änderung WHERE ID_Änderung = " + id_aenderung +";"; 
			DataBase.executeQuery(query);
		
			
			
			
		}else {
			
			// ERROR geht nicht. Hier der Teil ! 
		}
	
	
		
	}
	
	public static int calculateMengeBestellt(int id_bauteil) {
		
		int [] mengen = null; 
		
		
		mengen = DataBase.getMengenBauteile(id_bauteil); 		
		
		
		try {
			int change = mengen[2] - mengen[0]; 
			
			if (change < 0) {
				return change; 
			}
			
			
			System.out.println(change);
			
			String query = "UPDATE TBauteil SET MengeBestellt = "+ change +" WHERE ID_TBauteil =" + id_bauteil +";";
			
			
			DataBase.executeQuery(query);
			
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		return 0;
	}
	
	public static void calculateMengeLagernd(int id_bauteil) {
		
		int [] mengen = null; 
		
		
		mengen = DataBase.getMengenBauteile(id_bauteil); 		
		
		
		try {
			
			int change = mengen[0] + mengen[1]; 
			String query = "UPDATE TBauteil SET MengeBestellt = 0 WHERE ID_TBauteil =" + id_bauteil +";";
			
			DataBase.executeQuery(query);
			
			
			query = "UPDATE TBauteil SET MengeLagernd = "+ change +" WHERE ID_TBauteil =" + id_bauteil +";";
			
			DataBase.executeQuery(query);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		
	}
	
	public static int newBauteil(String name, String link, int mengeLagernd, int mengeBestellt, int mengeGeplant, String lagerort) {
		
		String query = "INSERT INTO Bauteil (Name, Link, MengeLagernd, MengeBestellt, MengeGeplant, Lagerort) VALUES ('" + name +"','"+ link +"'," + mengeLagernd +"," + mengeBestellt + "," + mengeGeplant + ",'"+ lagerort +"');";
		DataBase.executeQuery(query);
		
		
		
		int id_current = DataBase.getSpecificID("ID_Max", "SELECT max(ID_Bauteil) as ID_Max FROM Bauteil;");
		
		
		
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		
		
		query = "INSERT INTO 'Mischtabelle-Kategorie-Bauteil' (ID_Kategorie, ID_Bauteil, Timestamp) VALUES ( 1 , " + id_current + ",'"+ timeStamp + "');";
		DataBase.executeQuery(query);
		
		
		return id_current;
		
	}
	public static void deleteBauteil(int id_bauteil) {
		
		String query = "DELETE FROM Bauteil WHERE ID_Bauteil = "+ id_bauteil +";"; 
		DataBase.executeQuery(query);
		
		
		// Bauteil auch aus der Mischtabelle löschen
		
		 query = "DELETE FROM 'Mischtabelle-Kategorie-Bauteil' WHERE ID_Bauteil = "+ id_bauteil +";"; 
		DataBase.executeQuery(query);
		
		
		
	}
	public static void changeBauteil(int id_Bauteil, String name, String link, int mengeLagernd, int mengeBestellt, int mengeGeplant, String lagerort) {
		
		String query = "UPDATE Bauteil SET Name = '"+ name +"', link = '"+ link +"', MengeLagernd =" + mengeLagernd + ", MengeBestellt = " + mengeBestellt + ", MengeGeplant = " + mengeGeplant + ", Lagerort ='" + lagerort + "' WHERE ID_Bauteil =" + id_Bauteil +";";
		DataBase.executeQuery(query);
		
	}
	
	
	public static void deleteAuftrag(int id_aenderung) {
		
		String query = "DELETE FROM Änderung WHERE ID_Änderung = " + id_aenderung +";"; 
		DataBase.executeQuery(query);
		
	}
	
	public static void loadOffeneAuftraege() {
		
		
		DataBase.loadOffeneAuftraegeToRam();
		System.out.println(DataBase.offeneAuftraege.toString()); 
		
	
	}
	
	// Kategorie
	
	public static void createKategorie(String name) {
		
		
		String query = "INSERT INTO Kategorie (Name) VALUES ('"+ name +"');"; 
		DataBase.executeQuery(query);
		
		
	}

	public static void renameKategrie(int id_Kategorie, String name) {
		

		String query = "UPDATE Kategorie SET Name = '"+ name +"' WHERE ID_Kategorie = "+ id_Kategorie +";"; 
		DataBase.executeQuery(query);
		
		
		
	} 
	
	public static void deleteKategorie(int id_Kategorie) {
		
		String query = "DELETE FROM Kategorie WHERE ID_Kategorie = "+ id_Kategorie +";"; 
		DataBase.executeQuery(query);
		
		
		
		// Alle Bauteile zu default
		
		ArrayList<Integer> ids = DataBase.getBauteileIDByKategorie(id_Kategorie); 

		
		
		Iterator<Integer> it = ids.iterator(); 
		
		while(it.hasNext()) {
			System.out.println("*");
			
			addBauteilToKategorie(1, it.next().intValue()); 
			
		}
		
		
		query = "DELETE FROM 'Mischtabelle-Kategorie-Bauteil' WHERE ID_Kategorie = "+ id_Kategorie +";"; 
		DataBase.executeQuery(query);
		
		
		
		
	}
	
//	public static void addBauteilToKategorie(int id_Kategorie, int id_Bauteil) {
//		
//		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
//		
//		DataBase.getConnection();
//		String query = "INSERT INTO 'Mischtabelle-Kategorie-Bauteil' (ID_Kategorie, ID_Bauteil, Timestamp) VALUES (" + id_Kategorie+ " , " + id_Bauteil + ",'"+ timeStamp + "');";
//		DataBase.executeQuery(query);
//		DataBase.closeConnection();
//		
//		
//		DataBase.getConnection();
//		query = "DELETE FROM 'Mischtabelle-Kategorie-Bauteil' WHERE ID_Kategorie = 1 AND ID_Bauteil = " + id_Bauteil + ";"; 
//		DataBase.executeQuery(query);
//		DataBase.closeConnection();
//		
//	}
	
	public static void addBauteilToKategorie(int id_Kategorie, int id_Bauteil) {
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		
		
		String query = "UPDATE 'Mischtabelle-Kategorie-Bauteil' SET ID_Kategorie = " + id_Kategorie + ", Timestamp = '" + timeStamp + "' WHERE ID_Bauteil = " + id_Bauteil + ";";
		DataBase.executeQuery(query);
		
		
		
	}
	
	public static void deleteBauteilFromKategorie(int id_Bauteil) {
		
		String query = "DELETE FROM 'Mischtabelle-Kategorie-Bauteil' WHERE ID_Bauteil = "+ id_Bauteil +";"; 
		DataBase.executeQuery(query);
		
		
		// Bauteil wird der default Zugeordnet
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		
		query = "INSERT INTO 'Mischtabelle-Kategorie-Bauteil' (ID_Kategorie, ID_Bauteil, Timestamp) VALUES ( 1 , " + id_Bauteil + ",'"+ timeStamp + "');";
		DataBase.executeQuery(query);
		
		
		
		
		
		
	}
	
	
	public static void manualOrderingOfComponents(int id_Bauteil, int quantum_ordering) {
		
		int [] mengen = DataBase.getMengenBauteile(id_Bauteil); 
		quantum_ordering += mengen[1]; 
		
		
		
		
		String query = "UPDATE TBauteil SET MengeBestellt = " + quantum_ordering + " WHERE ID_TBauteil =" + id_Bauteil +";";
		DataBase.executeQuery(query);
	
		
	}
	
	
	
public static String getComponentPrice (int id_Bauteil) {
		

		String price = "0";
		
		
		
		String priceSql = null;
		java.sql.Statement stmt = null;
		try{
		priceSql ="SELECT Preis, max(ID_Preis)  FROM PreisBauteil WHERE ID_Bauteil = " + id_Bauteil + " ;" ;
		
			stmt = DataBase.c.createStatement();
			ResultSet rs = stmt.executeQuery(priceSql);
			
			
				while(rs.next()) {price = rs.getString("Preis");}
				stmt.close();
		}catch ( Exception e ) {
		      System.err.println( "ID not found"); 
		      
		   }
		
		return price;
		
		
	}
	
public static void addPrice(int id_Bauteil, String price) {
		
		
		// Unbedingt Testen !!! 
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		
		
		String query = "INSERT INTO PreisBauteil  (ID_Bauteil, Timestamp, Preis, ID_Person) VALUES (" + id_Bauteil+ " , '" + timeStamp + "','"+ price + "', "+ DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn)+");";
		DataBase.executeQuery(query);
		
		
		
	}
	
	public static void alterPrice(int id_Bauteil, String price) {
		
		// Unbedingt Testen !!! 
		
	
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "UPDATE PreisBauteil SET Preis = '" + price + "', Timestamp = '"+ timeStamp +"', ID_Person = "+  DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn) +" WHERE ID_Bauteil =" + id_Bauteil +";";
		DataBase.executeQuery(query);
		
		
		
	}
	
	public static int getLatestPrice (int id_Bauteil) {
		
		int price = DataBase.getSpecificID("Preis", "SELECT Preis, max(ID_Preis)  FROM PreisBauteil WHERE ID_Bauteil = " + id_Bauteil + " ;" ); 
		
		currentPrice = price + ""; 
		
		return price;
	}
	
	
	
	
}
	