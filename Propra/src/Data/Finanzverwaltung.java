package Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import GUI.GUILogin;

public class Finanzverwaltung {

	// Rechnung 
	
	public static void addBill(String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, String betrag, String beschreibung) {
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "INSERT INTO Rechnung (Rechnungsname, Auftraggeber, Ansprechpartner, Bezahlung_Art, Betrag, Beschreibung, Bearbeiter, TimeStamp) VALUES ('"+ rechnungsname +"', " +  id_Auftraggeber + ", " + id_Ansprechpartner + ", '" + artBezahlung + "', '" + betrag +"','"  + beschreibung +"', " +  DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn) + ",'" + timeStamp +"');";
		DataBase.executeQuery(query);
	
		int id_Bill = DataBase.getSpecificID("current", "SELECT max(ID_Rechnung) as current FROM 'Rechnung';"); 
		
		
		
	
		
		changeStatusBill(id_Bill, "Rechnung wurde erstellt."); 
				
		
		
		// K�nnte der Teil hin, dass die Auftr�ge dann gel�scht werden. 
		
	}
	
	public static void alterBill(int id_Bill, String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, String betrag, String beschreibung) {
		
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "UPDATE Rechnung SET Rechnungsname='"  + rechnungsname + "' , Auftraggeber= "+ id_Auftraggeber + ", Ansprechpartner = " + id_Ansprechpartner + ", Bezahlung_Art='" + artBezahlung + "', Betrag = '" + betrag +"' , Beschreibung = '" + beschreibung +"', Timestamp = '" + timeStamp +"' WHERE ID_Rechnung = " + id_Bill + ";";  
		System.out.println(query);
		
		DataBase.executeQuery(query); 
		
		
	}

	public static void deleteBill(int id_Rechnung) {
		
		
		String query = "DELETE FROM Rechnung WHERE ID_Rechnung = "+ id_Rechnung +";"; 
		DataBase.executeQuery(query);
		
		// Status l�schen 
		int id_Status = DataBase.getSpecificID("ID_Status", "SELECT ID_Status FROM 'Mischtabelle-Rechnung-Status' WHERE ID_Rechnung = " + id_Rechnung +";"); 

		query = "DELETE FROM 'Mischtabelle-Rechnung-Status' WHERE ID_Rechnung = "+ id_Rechnung +";"; 
		DataBase.executeQuery(query);
		
		query = "DELETE FROM 'Status_Rechnung' WHERE ID_Status = "+ id_Status +";"; 
		DataBase.executeQuery(query);
		
		
		
	}
	
	
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
		
		
		// Status pr�fen
		// Preis �ndern -> Float Real ? 
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
		
		// mischtabelle ->
		// Topf l�schen P.2
		
		
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
		
		// Mischtabelle l�schen!
				
		
		
		String query = "DELETE FROM Topf WHERE ID_Topf = " + id_Topf + ";";  
		DataBase.executeQuery(query);
		query = "DELETE FROM 'Mischtabelle-Kasse-Topf' WHERE ID_Topf = "+ id_Topf +";"; 
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
