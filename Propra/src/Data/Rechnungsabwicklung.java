package Data;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import GUI.GUILogin;

public class Rechnungsabwicklung {

	
	//BRechnung
	
	public static void sumKosten(){
		
	}
	
	public static void createBRechnung(String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, double betrag, String beschreibung) {
			// +  DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn) + ",'"

			
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
			String query = "INSERT INTO BRechnung (Name, Id_Auftraggeber, Id_Ansprechpartner, Art_Bezahlung, Betrag, Beschreibung, Timestamp, Typ) VALUES ('"+ rechnungsname +"', " +  id_Auftraggeber + ", " + id_Ansprechpartner + ", '" + artBezahlung + "', " + betrag +",'"  + beschreibung +"', '" + timeStamp +"', 'Bauteilrechnung');";
			System.out.println(query);
			DataBase.executeQuery(query);
			
		
	}
	
	public static void AddTBauteilToBRechnung(int id_TBauteil, int id_BRechnung) {

	
		String query = "INSERT INTO 'Mischtabelle-TBauteil-BRechnung'(ID_TBauteil, Id_BRechnung) VALUES ("+ id_TBauteil +", " + id_BRechnung +");";
		System.out.println(query);
		DataBase.executeQuery(query);
	
		
		
	}
	public static void delteTBauteilFromBRechnung(int id_TBauteil, int id_BRechnung) {
		
	
		String query = "DELETE FROM 'Mischtabelle-TBauteil-BRechnung' WHERE ID_TBauteil = "+id_TBauteil+" AND ID_BRechnung = "+ id_BRechnung+";"; 
		DataBase.executeQuery(query);
		
		
		
	}
	
	public static void alterBRechnung(int id_Bill, String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, double betrag, String beschreibung, int id_Topf) {
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "UPDATE BRechnung SET Name='"  + rechnungsname + "' , Id_Auftraggeber= "+ id_Auftraggeber + ", Id_Ansprechpartner = " + id_Ansprechpartner + ", Art_Bezahlung='" + artBezahlung + "', Betrag = '" + betrag +"' , Beschreibung = '" + beschreibung +"', Timestamp = '" + timeStamp +"', ID_Topf = "+ id_Topf +" WHERE ID_BRechnung = " + id_Bill + ";";  
		System.out.println(query);
		
		DataBase.executeQuery(query); 
		
	}
	
	public static void delteBRechnung(int id_BRechnung) throws SQLException {
		
		
		changeMengeLagernd(id_BRechnung); 
		
		
	
		String query = "DELETE FROM BRechnung WHERE ID_BRechnung = "+ id_BRechnung +";"; 
		System.out.println(query);
		DataBase.executeQuery(query); 
		
		
		
		query = "DELETE FROM 'Mischtabelle-TBauteil-BRechnung' WHERE ID_BRechnung = "+ id_BRechnung +";"; 
		System.out.println(query);
		DataBase.executeQuery(query); 
		
		
	
		
		// Mischtabelle mit löschen!! -> Meherere Ids? -> ID Rechnugn löschen !
		
		
	}
	
	
	public static void changeMengeLagernd( int id_BRechnung) throws SQLException {
		
		ArrayList<MengenTBauteilObjektRAM> list = DataBase.createMTBObjektRAM(id_BRechnung); 
	
		
		//System.out.println(list.toString());
		
		Iterator<MengenTBauteilObjektRAM> it = list.iterator(); 
		
		while(it.hasNext()) {
			MengenTBauteilObjektRAM tmp = it.next(); 
			
			
			
			
			int mengeUpdate  = tmp.getMengeLagernd() + tmp.getMenge(); 
			
			String query = "UPDATE TBauteil SET mengeLagernd = "+ mengeUpdate +" WHERE ID_TBauteil = "+ tmp.getId_TBauteil()+ ";"; 
			DataBase.executeQuery(query);
			
			
			
			
		}
		
		
	}
	
	
	
	
	// ARechnung
	
	public static void createARechnung(String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, double betrag, String beschreibung, int id_Auftrag, int id_Topf) {
		// +  DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn) + ",'"

		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "INSERT INTO ARechnung (Name, Id_Auftraggeber, Id_Ansprechpartner, Art_Bezahlung, Betrag, Beschreibung, Timestamp, ID_Auftrag, ID_Topf, Typ) VALUES ('"+ rechnungsname +"', " +  id_Auftraggeber + ", " + id_Ansprechpartner + ", '" + artBezahlung + "', " + betrag +",'"  + beschreibung +"', '" + timeStamp +"', "+ id_Auftrag +", " + id_Topf+", 'Auftrags-Rechnung' );";
		System.out.println(query);
		DataBase.executeQuery(query);
		
		
		// im Auftrag Verankern
		
		int id = DataBase.getSpecificID("current", "SELECT max(ID_ARechnung) as current FROM ARechnung;");
		
		
		
		query = "UPDATE Auftrag SET ID_ARechnung = "+id+" WHERE ID_Auftrag = "+id_Auftrag+";"; 
		System.out.println(query);
		DataBase.executeQuery(query);
	
		
		
		
	}
	
	
	
	public static void createARechnung(String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, double betrag, String beschreibung, int id_Auftrag) {
		// +  DataBase.getIdPersonByNameSurname(GUILogin.name_signedIn, GUILogin.vorname_signedIn) + ",'"

		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "INSERT INTO ARechnung (Name, Id_Auftraggeber, Id_Ansprechpartner, Art_Bezahlung, Betrag, Beschreibung, Timestamp, ID_Auftrag, ID_Topf, Typ) VALUES ('"+ rechnungsname +"', " +  id_Auftraggeber + ", " + id_Ansprechpartner + ", '" + artBezahlung + "', " + betrag +",'"  + beschreibung +"', '" + timeStamp +"', "+ id_Auftrag +",  -1 , 'Auftrags-Rechnung');";
		System.out.println(query);
		DataBase.executeQuery(query);
		
		
		// im Auftrag Verankern
		
		int id = DataBase.getSpecificID("current", "SELECT max(ID_ARechnung) as current FROM ARechnung;");
		
		
		
		query = "UPDATE Auftrag SET ID_ARechnung = "+id+" WHERE ID_Auftrag = "+id_Auftrag+";"; 
		System.out.println(query);
		DataBase.executeQuery(query);
	
		
		
		
	}
	
	

	public static void alterARechnung(int id_Bill, String rechnungsname, int id_Auftraggeber, int id_Ansprechpartner, String artBezahlung, double betrag, String beschreibung, int id_Topf) {
	
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String query = "UPDATE ARechnung SET Name='"  + rechnungsname + "' , Id_Auftraggeber= "+ id_Auftraggeber + ", Id_Ansprechpartner = " + id_Ansprechpartner + ", Art_Bezahlung='" + artBezahlung + "', Betrag = '" + betrag +"' , Beschreibung = '" + beschreibung +"', Timestamp = '" + timeStamp +"', ID_Topf = "+ id_Topf + " WHERE ID_ARechnung = " + id_Bill + ";";  
		System.out.println(query);
		
		DataBase.executeQuery(query); 
		
	}
	
	public static void delteARechnung(int id_ARechnung) {

		// = NULL 
		
	
		String query = "DELETE FROM ARechnung WHERE ID_ARechnung = "+ id_ARechnung +";"; 
		System.out.println(query);
		DataBase.executeQuery(query); 
	
		
			
		// Auftrag anpassen: 
	
	
		query = "UPDATE Auftrag SET ID_ARechnung = NULL WHERE ID_ARechnung = "+id_ARechnung+";"; 
		System.out.println(query);
		DataBase.executeQuery(query);
		
		

	}
}