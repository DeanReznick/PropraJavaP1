package Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import GUI.GUILogin;

public class Rechnungsabwicklung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		createBRechnung("test", 1, 1, "Bar", 11.0, "Kredit"); 
		//alterBRechnung(1, "test", 1, 1, "Bar", 11.0, "Kredit A"); 
		//AddTBauteilToBRechnung(1,1); 
		//delteTBauteilFromBRechnung(1,1); 
	}
	
	//BRechnung
	
	public static void createBRechnung(String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, double betrag, String beschreibung) {
			// +  DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn) + ",'"

			DataBase.getConnection();
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
			String query = "INSERT INTO BRechnung (Name, Id_Auftraggeber, Id_Ansprechpartner, Art_Bezahlung, Betrag, Beschreibung, Timestamp) VALUES ('"+ rechnungsname +"', " +  id_Auftraggeber + ", " + id_Ansprechpartner + ", '" + artBezahlung + "', " + betrag +",'"  + beschreibung +"', '" + timeStamp +"');";
			System.out.println(query);
			DataBase.executeQuery(query);
			DataBase.closeConnection();
		
	}
	
	public static void AddTBauteilToBRechnung(int id_TBauteil, int id_BRechnung) {

		DataBase.getConnection();
		String query = "INSERT INTO 'Mischtabelle-TBauteil-BRechnung'(ID_TBauteil, Id_BRechnung) VALUES ("+ id_TBauteil +", " + id_BRechnung +");";
		System.out.println(query);
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
		
		
	}
	public static void delteTBauteilFromBRechnung(int id_TBauteil, int id_BRechnung) {
		
		DataBase.getConnection();
		String query = "DELETE FROM 'Mischtabelle-TBauteil-BRechnung' WHERE ID_TBauteil = "+id_TBauteil+" AND ID_BRechnung = "+ id_BRechnung+";"; 
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
		
		// ID löschen. 
		
	}
	
	public static void alterBRechnung(int id_Bill, String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, double betrag, String beschreibung) {
		DataBase.getConnection();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "UPDATE BRechnung SET Name='"  + rechnungsname + "' , Id_Auftraggeber= "+ id_Auftraggeber + ", Id_Ansprechpartner = " + id_Ansprechpartner + ", Art_Bezahlung='" + artBezahlung + "', Betrag = '" + betrag +"' , Beschreibung = '" + beschreibung +"', Timestamp = '" + timeStamp +"' WHERE ID_BRechnung = " + id_Bill + ";";  
		System.out.println(query);
		
		DataBase.executeQuery(query); 
		DataBase.closeConnection();
	}
	
	public static void delteBRechnung() {
		
		
		
		
		// Mischtabelle mit löschen!! -> Meherere Ids? 
		
		
	}
	
	// ARechnung
	
	public static void createARechnung() {
		
	}

	public static void alterARechnung() {
		
	}
	
	public static void delteARechnung() {
		
	}
}
