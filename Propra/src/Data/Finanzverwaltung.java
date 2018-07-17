package Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import GUI.GUILogin;

public class Finanzverwaltung {

	// Rechnung 
	
	
	
	public static void changeStatusBill(int id_Bill, String statusBill) {
		
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "INSERT INTO 'Status_Rechnung' (Name)" + 
				"VALUES ('"+ statusBill +"');";
		DataBase.executeQuery(query);
		
		int id_Status = DataBase.getSpecificID("current", "SELECT max(ID_Status) as current FROM 'Status_Rechnung';"); 
		
		query = "INSERT INTO 'Mischtabelle-Rechnung-Status' (ID_Rechnung, ID_Status, Timestamp, Bearbeiter)" + 
					"VALUES ("+ id_Bill + ", " + id_Status + ", '" + timeStamp + "', " +  DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn) +");"; 
		
		DataBase.executeQuery(query);
		
		
	}
	
	
	public static void addOrderToBill(int id_Order, int id_Bill) {
		
		
		// Status prüfen
		// Preis ändern -> Float Real ? 
		// Mischtabelle (X) 
		
		
			
		String query = "INSERT INTO 'Mischtabelle-Rechnung-Auftrag' (ID_Rechnung, ID_Auftrag)" + 
				"VALUES ("+ id_Bill +", " + id_Order + ");";
		DataBase.executeQuery(query);
		

		//query = "INSERT INTO AuftragBeendet SELECT ID_Auftrag, Titel, AF, Dateiname, Dateiort, PK, RK FROM  Auftrag WHERE ID_Auftrag = " + id_Order + ";";
		//DataBase.executeQuery(query);
		
		//query = "DELETE FROM Auftrag WHERE ID_Auftrag = "+ id_Order +";"; 
		//DataBase.executeQuery(query);
	
		query = "UPDATE Auftrag SET ID_Rechnung="  + id_Bill + " WHERE ID_Auftrag = " + id_Order + ";";  
		DataBase.executeQuery(query);

		
		
		//. .
	
	}
	
	
	public static void deleteOrderFromBill(int id_Order) {
		
		
		String query = "DELETE FROM 'Mischtabelle-Rechnung-Auftrag' WHERE ID_Auftrag = "+ id_Order +";"; 
		System.out.println(id_Order);
		
		DataBase.executeQuery(query);
		

		//query = "INSERT INTO AuftragBeendet SELECT ID_Auftrag, Titel, AF, Dateiname, Dateiort, PK, RK FROM  Auftrag WHERE ID_Auftrag = " + id_Order + ";";
		//DataBase.executeQuery(query);
		
		//query = "DELETE FROM Auftrag WHERE ID_Auftrag = "+ id_Order +";"; 
		//DataBase.executeQuery(query);
	
		query = "UPDATE Auftrag SET ID_Rechnung= null WHERE ID_Auftrag = " + id_Order + ";";  
		DataBase.executeQuery(query);

		
		
	}
	
	//____________________________
	
	
	public static void addKasse(String art, String nummer, int soll, int ist) {
		
		
		String query = "INSERT INTO Kasse (Art, Nummer, Soll, Ist) VALUES ('"+ art +"', '" +  nummer + "', " + soll + ", " + ist + ");";
		DataBase.executeQuery(query);
		
		
		
	}
	public static void alterKasse(int id_Kasse, String art, String nummer, int soll, int ist) {
		
		String query = "UPDATE Kasse SET Art= '" + art + "', Nummer = '"+ nummer + "', Soll = " + soll +", Ist = " + ist +" WHERE ID_Kasse = " + id_Kasse + ";";  
		DataBase.executeQuery(query);
		
		
		
	}
	public static void deleteKasse(int id_Kasse) {
		
		
		String query = "DELETE FROM Kasse WHERE ID_Kasse = "+ id_Kasse +";"; 
		
		DataBase.executeQuery(query);
		
		
		
		
		
	}
	public static void addTopf(int id_Kasse, int soll, int ist) {
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		
		String query = "INSERT INTO Topf (Soll, Ist) VALUES ("+ soll +", " + ist + ");";
		DataBase.executeQuery(query);
		
		int id_Topf = DataBase.getSpecificID("current", "SELECT max(ID_Topf) as current FROM Topf;"); 
		
		// Topf Kasse zuordnen.
		
		//Mischtabelle-Kasse-Topf
		
		query = "INSERT INTO 'Mischtabelle-Kasse-Topf' (ID_Kasse, ID_Topf, ID_Bearbeiter, Timestamp) VALUES ("+ id_Kasse +", " + id_Topf + ", " + DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn)+ ",'"+ timeStamp +"');";
		DataBase.executeQuery(query);
		
		
		
	}
	public static void alterTopf(int id_Topf, int id_Kasse, int soll, int ist) {
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		
		String query = "UPDATE Topf SET Soll= " + soll + ", Ist = "+ ist + " WHERE ID_Topf = " + id_Topf + ";";  
		DataBase.executeQuery(query);
		query = "DELETE FROM 'Mischtabelle-Kasse-Topf' WHERE ID_Topf = "+ id_Topf +";"; 
		DataBase.executeQuery(query);
		query = "INSERT INTO 'Mischtabelle-Kasse-Topf' (ID_Kasse, ID_Topf, ID_Bearbeiter, Timestamp) VALUES ("+ id_Kasse +", " + id_Topf + ", " + DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn)+ ",'"+ timeStamp +"');";
		DataBase.executeQuery(query);
		
		
		
		
	}
	public static void deleteTopf(int id_Topf) {
			
		
		String query = "DELETE FROM Topf WHERE ID_Topf = " + id_Topf + ";";  
		DataBase.executeQuery(query);
		
		
		query = "UPDATE ARechnung SET ID_Topf = -1 WHERE ID_Topf = " + id_Topf + ";"; 
		
		DataBase.executeQuery(query);
		
		query = "UPDATE BRechnung SET ID_Topf = -1 WHERE ID_Topf = " + id_Topf + ";"; 
		
		DataBase.executeQuery(query);
		
		
		
	}
	public static void addBillToTopf(int id_Bill, int id_Topf) {
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		
		String query = "INSERT INTO 'Mischtabelle-Topf-Rechnung' (ID_Topf, ID_Rechnung, ID_Bearbeiter, Timestamp) VALUES (" + id_Topf +", " + id_Bill +", " + DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn)+ ",'"+ timeStamp +"');";
		DataBase.executeQuery(query);
		
		
	}
	public static void deleteBillFromTopf(int id_Bill) {
		
		
		String query = "DELETE FROM 'Mischtabelle-Topf-Rechnung' WHERE ID_Rechnung = " + id_Bill + ";";
		DataBase.executeQuery(query);
		
		
		
	}
	
	public static int getIDRechnungByOrder(int id_Order) {
		
		
		int id_Bill = DataBase.getSpecificID("ID_Rechnung", "SELECT * FROM 'Mischtabelle-Rechnung-Auftrag' WHERE ID_Auftrag =" + id_Order+";");
		
		
		return id_Bill; 
		
	}
	
}
