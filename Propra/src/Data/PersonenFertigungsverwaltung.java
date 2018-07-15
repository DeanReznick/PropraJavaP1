package Data;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import GUI.GUILogin;

public class PersonenFertigungsverwaltung {

	//Possible changes/extensions: 

	//Entry timestamp change
	
	
	
	public static void createNewPerson(String name, String vorname, String telefonnummer, String mail, String land, String straﬂe, String ort, String hausnummer, int plz) {
		
		//String name, String telefonnummer, String mail, String land, String straﬂe, String ort, String hausnummer, int plz
		
		
		//Procedure:
		
		//Formulate SQL Query on the basis of the transferred values. 
		//Pass this query to the database module from which the query is executed. 
		
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		
		
		String query = "INSERT INTO Person (Name, Vorname,  Telefonnummer, Mail, Land, Straﬂe, Ort, Hausnummer, Plz, Timestamp) " +
                 "VALUES ( '" + name +"', '"+ vorname +"', '"+ telefonnummer + "','" + mail  + "','"+  land  + "','" + straﬂe  + "','" + ort  + "','"+ hausnummer  + "',"+ plz  + ",'"+ timeStamp  + "');"; 
		int check = DataBase.getIdPersonByNameSurname(name, vorname);
		
		//If the account already exists, the ID is returned. The program does not create a new account and outputs the error code -1.
			
		if (check == -1) {
			DataBase.executeQuery(query); // Query: Table person 
		}else {
			System.out.println("(PFV): Person existiert bereits. Code: -1");
		}
		
	}
	
	public static void createNewPerson(String name, String vorname, String telefonnummer, String mail, String land, String straﬂe, String ort, String hausnummer, int plz, String job, String password) {
		
	    //String name, String telefonnummer, String mail, String land, String straﬂe, String ort, String hausnummer, int plz
	    
	    
	    //Procedure:
	    
	    //Formulate SQL Query on the basis of the transferred values. 
	    //Pass this query to the database module from which the query is executed. 
	    
	    
	    String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
	    
	    
	    String query = "INSERT INTO Person (Name, Vorname,  Telefonnummer, Mail, Land, Straﬂe, Ort, Hausnummer, Plz, Timestamp, Rolle, Passwort) " +
	                 "VALUES ( '" + name +"', '"+ vorname +"', '"+ telefonnummer + "','" + mail  + "','"+  land  + "','" + straﬂe  + "','" + ort  + "','"+ hausnummer  + "',"+ plz  + ",'"+ timeStamp  + "', '"+  job + "', '" +  Authentication.sha256(password) +"');"; 
	    int check = DataBase.getIdPersonByNameSurname(name, vorname);
	    
	    //If the account already exists, the ID is returned. The program does not create a new account and outputs the error code -1.
	      
	    if (check == -1) {
	      DataBase.executeQuery(query); // Query: Table person
	      
	    }else {
	      System.out.println("(PFV): Person existiert bereits. Code: -1");
	    
	      
	    }
	    
	  }
	
	
	public static boolean deletePerson(String name, String vorname ) {
		
		 // Deletes person entries from the database. 
		String query = "DELETE FROM Person WHERE name like '" + name + "' AND vorname like '"+  vorname +"';"; 
		DataBase.executeQuery(query); 
		
		return true; 
		
	}
	
	
	public static boolean deletePersonById(int id) {
		
		int id_login = GUILogin.id_signedIn; 
	
		if (id_login == id) {
			return false; 
		}else {
			 // Deletes person entries from the database. 
			String query = "DELETE FROM Person WHERE ID_Person=" + id + ";"; 
			DataBase.executeQuery(query); 
			
			removePersonFromArrayList(id);
			
			return true; 
		}
		
	
		
	}
	
	public static void removePersonFromArrayList(int id) {
		
		for (int i = 0; i < DataBase.people.size(); i++) {
			   if (DataBase.people.get(i).getID_Person() == id) {
				   DataBase.people.remove(i);
			   }
		   }
		
	}
	
	
	public static void changeNameSurname(String name_old, String surname_old, String name, String surname) {
		
		//Modification of a data record. The person to be changed is searched by name and surname. You can also only edit both entries together (as tuples). 
		//Note: The function could of course also be programmed differently. 
		
			
		String query = "UPDATE Person SET name = '" + surname + "', vorname = '" + name  + "' WHERE name = '"+ surname_old + "' and vorname = '" + name_old +"';";  
		
		DataBase.executeQuery(query); 
			
	}
	
	public static void changeRolle(int id_Person, String rolle) {
		
		
		String query = "UPDATE Person SET Rolle = '" + rolle + "' WHERE ID_Person = "+ id_Person + ";"; 
		DataBase.executeQuery(query);
		
	
	}
	
	
public static void changeName(String name_old, String surname_old, String name, String surname) {
		
		//Modification of a data record. The person to be changed is searched by name and surname. You can also only edit both entries together (as tuples). 
		//Note: The function could of course also be programmed differently. 
		
			
		String query = "UPDATE Person SET name = '" + name + "' WHERE name = '"+ name_old + "' and vorname = '" + surname_old +"';";  
		
		DataBase.executeQuery(query); 
		
		
		
		
		
	}
	
	
	
	
	public static void changePhoneNumber (String name, String surname, String number) {
		
		String query = "UPDATE Person SET telefonnummer = '" + number + "' WHERE name like '"+ surname + "' and vorname like '" + name+"';";  
		DataBase.executeQuery(query);
		
		
		
		
		
	}
	
public static void changeMail (String name, String surname, String mail) {
	
		String query = "UPDATE Person SET mail = '" + mail + "' WHERE name like '"+ surname + "' and vorname like '" + name+"';";  
		DataBase.executeQuery(query);
		
}
	
	public static void changeAddressDataSet(String name, String surname, String country, String street, String location, String number, int zipCode ) {
		
		String query = "UPDATE Person SET land = '" + country + "', straﬂe= '" + street  + "' , ort= '" + location + "' , Hausnummer = '" + number +"' , PLZ ='" + zipCode + "' WHERE name like '"+ surname + "' and vorname like '" + name +"';";  	
		DataBase.executeQuery(query); 
		
		
	}


	  //----------------------------------------------------
	  // ODER
	  
	  
	  public static void createNewOrder(String header, String af, String filename, String repository, String pk, String rk, String name, String surname, String job ) {
		 
	    // Create a new job and assign it to a person. 
	    //The necessary entries are created in the mixing table. 
	    
	    //Procedure: 

	      //(1) Create order
	      //(2a) ID of the order Get order from the database
	      //(2b) Get ID of person to be assigned from the database
	      //(3) Ids in the mixing table
	    
	    String query = "INSERT INTO Auftrag (Titel, af,  Dateiname, Dateiort, pk, rk) VALUES ( '" + header +"', '"+ af +"', '"+ filename + "','" + repository  + "','"+  pk  + "','" + rk  + "');"; 
	    DataBase.executeQuery(query); 
	    String searchQuery = "SELECT ID_Auftrag FROM Auftrag WHERE titel like '" + header +"' and af like '" + af + "' and Dateiname like '" + filename +"';"; 
	    int id_order = DataBase.getSpecificID("ID_Auftrag", searchQuery); 
	    int id_person = DataBase.getIdPersonByNameSurname(name, surname);
	    String queryMTable = "INSERT INTO 'Mischtabelle-Person-Auftrag' (ID_Person, ID_Auftrag, Rolle) VALUES ( " + id_person +", "+ id_order +" , '"+ job + "');"; 
	    DataBase.executeQuery(queryMTable); 
	    
	    
	    // NEW: 23.5.2018 
	    String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime()); // Could be outsourced to its own function. 
	    String query_status = "INSERT INTO Status (ID_Auftrag, Status, Timestamp) VALUES (" + id_order + ", 'Request was created in the system.' , '" + timeStamp +"');";
	    DataBase.executeQuery(query_status); 
	    int id_status = DataBase.getSpecificID("ID_Status", "SELECT ID_Status FROM Status WHERE timestamp like '" + timeStamp + "';"); 
	    String query_add_status_to_oder = "UPDATE Auftrag SET ID_status ="  + id_status + " WHERE ID_Auftrag = " + id_order + ";";  
	    DataBase.executeQuery(query_add_status_to_oder); 
	    
	  }
	  
	  public static void changeDataSetOrder(int id, String header, String af, String filename, String repository, String pk, String rk) {
		
	    String query = "UPDATE Auftrag SET titel = '" + header + "' , af = '"+ af +"', Dateiname = '" + filename +"' , Dateiort='" + repository +"', pk = '" + pk +"' , rk = '" + rk +"' WHERE ID_Auftrag = "+ id + ";";  
	      
	    DataBase.executeQuery(query);
	    
	    
	    
	  }
	  
	  
	  public static void changeJobOrderPerson(int id_person, int id_order, String job) {
		  
	    String query = "UPDATE 'Mischtabelle-Person-Auftrag' SET rolle = '" + job + "' WHERE ID_Person = "+ id_person + " AND ID_Auftrag = " + id_order +";";  
	    
	    DataBase.executeQuery(query);
	   
	  }
	  
	  
	  public static void addJobOrderPerson(int id_person, int id_order, String job) {
		  
		    String query = "INSERT INTO 'Mischtabelle-Person-Auftrag' (rolle, ID_Auftrag, ID_Person) VALUES ('" + job + "', " + id_order + "," + id_person +");";  
 
		    DataBase.executeQuery(query);
		    
		  }
		  
	  
	  
	  
	  
	  public static void deleteOrder(int id_Order) {
		  
	    //Procedure: 
	      //(1) Deleting an order from the database
	      //(2) Delete the relevant entry in the mixing table. 
	    
	    String query = "DELETE FROM Auftrag WHERE ID_Auftrag = " + id_Order + ";"; 
	    DataBase.executeQuery(query);
	    query = "DELETE FROM 'Mischtabelle-Person-Auftrag' WHERE ID_Auftrag = " + id_Order + ";"; 
	    DataBase.executeQuery(query);
	    
	    // DELTE stati
	    
	    query = "DELETE FROM Status WHERE ID_Auftrag = " + id_Order + ";";
	    DataBase.executeQuery(query);
	    
	    
	    
	  }
	  
	  
	  public static void alterStatus(int id_order, String new_Status) {
		  
		  
	    
	    String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime()); // Could be outsourced to its own function. 
	    String query_status = "INSERT INTO Status (ID_Auftrag, Status, Timestamp) VALUES (" + id_order + ", '" +new_Status +"' , '" + timeStamp +"');";
	    DataBase.executeQuery(query_status); 
	    int id_status = DataBase.getSpecificID("ID_Status", "SELECT ID_Status FROM Status WHERE timestamp like '" + timeStamp + "';"); 
	    String query_add_status_to_oder = "UPDATE Auftrag SET ID_status ="  + id_status + " WHERE ID_Auftrag = " + id_order + ";";  
	    DataBase.executeQuery(query_add_status_to_oder); 
	   
	    
	  }
	  
	    
	}