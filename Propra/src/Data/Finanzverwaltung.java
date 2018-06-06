package Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import GUI.GUILogin;

public class Finanzverwaltung {

	// Rechnung 
	
	public static void addBill(String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, String betrag, String beschreibung) {
		DataBase.getConnection();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "INSERT INTO Rechnung (Rechnungsname, Auftraggeber, Ansprechpartner, Bezahlung_Art, Betrag, Beschreibung, Bearbeiter, TimeStamp)" + 
				"VALUES ('"+ rechnungsname +"', " +  id_Auftraggeber + ", " + id_Ansprechpartner + ", '" + artBezahlung + "', '" + betrag +"','"  + beschreibung +"', " +  DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn) + ",'" + timeStamp +"');";
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
		// Könnte der Teil hin, dass die Aufträge dann gelöscht werden. 
		
	}
	
	public static void alterBill(int id_Bill, String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, String betrag, String beschreibung) {
		
		DataBase.getConnection();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "UPDATE Rechnung SET Rechnungsname='"  + rechnungsname + "' , Auftraggeber= "+ id_Auftraggeber + ", Ansprechpartner = " + id_Ansprechpartner + ", Bezahlung_Art='" + artBezahlung + "' Betrag = '" + betrag +"' , Beschreibung = '" + beschreibung +"', Timestamp = '" + timeStamp +"' WHERE ID_Rchnung = " + id_Bill + "';";  
		DataBase.executeQuery(query); 
		DataBase.closeConnection();
		
	}

	public static void deleteBill(int id_Rechnung) {
		
		DataBase.getConnection();
		String query = "DELETE FROM Rechnung WHERE ID_Rechnung = "+ id_Rechnung +";"; 
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
	}
	public static void addOrderToBill(int id_Order, int id_Bill) {
		
		
		// Status prüfen
		// Preis ändern -> Float Real ? 
		
		
		// IDEE: Beschreibung += z.B. "; Bestellung XYZ, Preis XYZ, ...;"
		DataBase.getConnection();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		DataBase.createOrderObjektRAM(id_Order);
		String tmp = DataBase.getBeschreibung(id_Bill); 
		tmp += DataBase.order.toString(); 
		
		String query = "UPDATE Rechnung SET Beschreibung ='"  + tmp + "' WHERE ID_Rchnung = " + id_Bill + ", Timestamp = '" + timeStamp + "';";  
		DataBase.executeQuery(query); 
		DataBase.closeConnection();
		
		
	}
	
}
