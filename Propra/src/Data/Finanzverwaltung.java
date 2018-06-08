package Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import GUI.GUILogin;

public class Finanzverwaltung {

	// Rechnung 
	
	public static void addBill(String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, String betrag, String beschreibung) {
		DataBase.getConnection();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "INSERT INTO Rechnung (Rechnungsname, Auftraggeber, Ansprechpartner, Bezahlung_Art, Betrag, Beschreibung, Bearbeiter, TimeStamp) VALUES ('"+ rechnungsname +"', " +  id_Auftraggeber + ", " + id_Ansprechpartner + ", '" + artBezahlung + "', '" + betrag +"','"  + beschreibung +"', " +  DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn) + ",'" + timeStamp +"');";
		DataBase.executeQuery(query);
		
		
		
		int id_Bill = DataBase.getSpecificID("current", "SELECT max(ID_Rechnung) as current FROM 'Rechnung';"); 
		DataBase.closeConnection();
		
		DataBase.getConnection();
	
		
		changeStatusBill(id_Bill, "Rechnung wurde erstellt."); 
				
		DataBase.closeConnection();
		
		// Könnte der Teil hin, dass die Aufträge dann gelöscht werden. 
		
	}
	
	public static void alterBill(int id_Bill, String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, String betrag, String beschreibung) {
		
		DataBase.getConnection();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "UPDATE Rechnung SET Rechnungsname='"  + rechnungsname + "' , Auftraggeber= "+ id_Auftraggeber + ", Ansprechpartner = " + id_Ansprechpartner + ", Bezahlung_Art='" + artBezahlung + "' Betrag = '" + betrag +"' , Beschreibung = '" + beschreibung +"', Timestamp = '" + timeStamp +"' WHERE ID_Rechnung = " + id_Bill + "';";  
		DataBase.executeQuery(query); 
		DataBase.closeConnection();
		
	}

	public static void deleteBill(int id_Rechnung) {
		
		DataBase.getConnection();
		String query = "DELETE FROM Rechnung WHERE ID_Rechnung = "+ id_Rechnung +";"; 
		DataBase.executeQuery(query);
		
		// Status löschen 
		int id_Status = DataBase.getSpecificID("ID_Status", "SELECT ID_Status FROM 'Mischtabelle-Rechnung-Status' WHERE ID_Rechnung = " + id_Rechnung +";"); 

		query = "DELETE FROM 'Mischtabelle-Rechnung-Status' WHERE ID_Rechnung = "+ id_Rechnung +";"; 
		DataBase.executeQuery(query);
		
		query = "DELETE FROM 'Status_Rechnung' WHERE ID_Status = "+ id_Status +";"; 
		DataBase.executeQuery(query);
		
		DataBase.closeConnection();
		
	}
	
	
	public static void changeStatusBill(int id_Bill, String statusBill) {
		
		DataBase.getConnection();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "INSERT INTO 'Status_Rechnung' (Name)" + 
				"VALUES ('"+ statusBill +"');";
		DataBase.executeQuery(query);
		
		int id_Status = DataBase.getSpecificID("current", "SELECT max(ID_Status) as current FROM 'Status_Rechnung';"); 
		
		query = "INSERT INTO 'Mischtabelle-Rechnung-Status' (ID_Rechnung, ID_Status, Timestamp, Bearbeiter)" + 
					"VALUES ("+ id_Bill + ", " + id_Status + ", '" + timeStamp + "', " +  DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn) +");"; 
		
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
	}
	
	
	public static void addOrderToBill(int id_Order, int id_Bill) {
		
		
		// Status prüfen
		// Preis ändern -> Float Real ? 
		// Mischtabelle (X) 
		
		DataBase.getConnection();
	
		
		
		String query = "INSERT INTO 'Mischtabelle-Rechnung-Auftrag' (ID_Rechnung, ID_Auftrag)" + 
				"VALUES ("+ id_Bill +", " + id_Order + ");";
		DataBase.executeQuery(query);
		

		//query = "INSERT INTO AuftragBeendet SELECT ID_Auftrag, Titel, AF, Dateiname, Dateiort, PK, RK FROM  Auftrag WHERE ID_Auftrag = " + id_Order + ";";
		//DataBase.executeQuery(query);
		
		//query = "DELETE FROM Auftrag WHERE ID_Auftrag = "+ id_Order +";"; 
		//DataBase.executeQuery(query);
	
		query = "UPDATE Auftrag SET ID_Rechnung="  + id_Bill + " WHERE ID_Auftrag = " + id_Order + "';";  
		DataBase.executeQuery(query);

		DataBase.closeConnection();
		
		//. .
	
	}
	
	
	public static void deleteOrderFromBill(int id_Order) {
		// Neue ID !
		
	}
	
}
