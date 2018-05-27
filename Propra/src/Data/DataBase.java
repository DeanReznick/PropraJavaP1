package Data;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import GUI.MainMenu;
public class DataBase {

	public static Connection c = null; 
	
	
	public static ArrayList<PersonObjektRAM> people = new ArrayList<PersonObjektRAM>(); 
	public static ArrayList<StatusObjektRAM> status_list = new ArrayList<StatusObjektRAM>();  //  Status-objects for a specific Person. Will be overwritten !!
	
	
	public static void getConnection() {
		
		//Verbindungsaufbau zur Datenbank	
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:Projekt1-DB.db");
	         c.setAutoCommit(false);
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() ); 
	      }
	      System.out.println("Opened database successfully");
}
	
	public static void closeConnection() {
		try {
			DataBase.c.close();
		} catch (Exception ex) {
			System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
		}
	}
	
	public static void executeQuery(String query) {
			Statement stmt = null;
	      
	      try {
	         stmt = c.createStatement();
	         stmt.executeUpdate(query);
	         stmt.close();
	         c.commit();
	      
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() ); 
	      }
	      System.out.println("The task was processed successfully.");
		
	}
	
	public static int getIdPersonByNameSurname(String name, String surname) {
			
		//SELECT ID_Person FROM Person WHERE name like 'Kern' and vorname like 'Dean'; 
		   Statement stmt = null;
		   int id = -1; 
		   try {
		    
			   //Query 
			   String query = "SELECT ID_Person FROM Person WHERE name like'" + name  +"' and vorname like '" + surname +"';";
			   
			   // Getting Data from Database
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( query );
		      
		      while ( rs.next() ) {
		          id = rs.getInt("ID_Person");
		      }
		     
		      stmt.close();
		    
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      
		   }
		   System.out.println("Operation done successfully");
		
	return id; // -1 = Keiner
	
	}
	
	public static int getSpecificID(String name_id, String query) {
	    
	    
	       Statement stmt = null;
	       int id = -1; 
	       try {
	        
	      
	         // Getting Data from Database
	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( query );
	          
	          while ( rs.next() ) {
	              id = rs.getInt(name_id);
	          }
	         
	          stmt.close();
	        
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          
	       }
	       System.out.println("Operation done successfully");
	    
	    return id; // -1 = no Entry
	    
	  }
	
	public static void loadPeopleToRAM() {
		

		int ID_Person; 
		String name; 
		String telefonnummer; 
		String mail; 
		String timestamp; 
		String rolle; 
		String passwort; 
		String land; 
		String straﬂe; 
		String ort; 
		int plz; 
		String hausnummer; 
		String vorname;
		
		Statement stmt = null;

	   
	   try {
	    
		   //Query 
		   String query = "SELECT * FROM Person;"; 
		   
		   // Getting Data from Database
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( query );
	      
	      while ( rs.next() ) {
	    	  ID_Person = rs.getInt("ID_Person");
	    	  name = rs.getString("name"); 
	    	  telefonnummer = rs.getString("telefonnummer"); 
	    	  mail = rs.getString("mail"); 
	    	  timestamp = rs.getString("Timestamp"); 
	    	  rolle = rs.getString("rolle"); 
	    	  passwort = rs.getString("passwort"); 
	    	  land = rs.getString("land"); 
	    	  straﬂe = rs.getString("straﬂe"); 
	    	  ort = rs.getString("ort"); 
	    	  plz = rs.getInt("plz"); 
	    	  hausnummer = rs.getString("Hausnummer"); 
	    	  vorname = rs.getString("vorname");
	    	  
	    	  PersonObjektRAM person = new PersonObjektRAM( ID_Person, name, telefonnummer,  mail, timestamp, rolle,  passwort,  land,  straﬂe,ort, plz, hausnummer,vorname); 
	    	  
	    	  people.add(person); 
	    	  
	      }
	     
	      stmt.close();
	    
	   } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      
	   }
	   System.out.println("Operation done successfully");
		
	}
	
	
//	public static ArrayList<PersonObjektRAM> searchPerson(String search) {
//		ArrayList<PersonObjektRAM> result = new ArrayList<PersonObjektRAM>();
//		//SELECT ID_Person FROM Person WHERE name like 'Dean' or vorname like 'Dean'; 
//		   Statement stmt = null;
//		   int id = -1; 
//		   try {
//		    
//			   //Query 
//			   String query = "SELECT *, (vorname + ' ' + name) AS Name FROM Person WHERE name like '%" + search  +"%' or vorname like '%" + search + "%' or Name like '%" + search + "%';";
//			   
//			   // Getting Data from Database
//		      stmt = c.createStatement();
//		      ResultSet rs = stmt.executeQuery( query );
//		      
//		      while ( rs.next() ) {
//		          id = rs.getInt("ID_Person");
//		      }
//		     
//		      stmt.close();
//		    
//		   } catch ( Exception e ) {
//		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//		      
//		   }
//		   System.out.println("Operation done successfully");
//		
//		   for (int i = 0; i < DataBase.people.size(); i++) {
//			   String fullName = DataBase.people.get(i).getVorname() + " " + DataBase.people.get(i).getName();
//			   if (DataBase.people.get(i).getName().indexOf(search) > -1 || DataBase.people.get(i).getVorname().indexOf(search) > -1 ||  fullName.equals(search)) {
//				   result.add(DataBase.people.get(i));
//			   }
//		   }
//	return result; // -1 = Keiner
//	
//	}
	
	public static void getAllPersons() {
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Vorname", "Telefon", "Email", "Rolle",  "Straﬂe", "Hausnummer", "PLZ", "Ort", "Land"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
						
		Statement stmt = null;
		try {
			stmt = DataBase.c.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sqlsearch = "SELECT * FROM Person;";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sqlsearch);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while(rs.next())
			{
				String a = rs.getString("ID_Person");
			    String b = rs.getString("Name");
			    String c = rs.getString("Vorname");
			    String d = rs.getString("Telefonnummer");
			    String e = rs.getString("Mail");
			    String f = rs.getString("Rolle");
			    String g = rs.getString("Straﬂe");
			    String h = rs.getString("Hausnummer");
			    String i = rs.getString("PLZ");
			    String j = rs.getString("Ort");
			    String k = rs.getString("Land");
			    
			    model.addRow(new Object[]{a, b,c,d,e,f,g, h, i, j, k});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainMenu.tblPersonen.setModel(model);
		MainMenu.scrollPane.setViewportView(MainMenu.tblPersonen);
	}
	
	
	public static void searchPerson(String search) {
		
		getConnection();
		
		String firstName = null;
		String lastName = null;
		
		if (search.contains(" ")) {
		String[] parts = search.split(" ");
		firstName = parts[0]; // 004
		lastName = parts[1]; // 034556
		}
		String sqlsearch;
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Vorname", "Telefon", "Email", "Rolle",  "Straﬂe", "Hausnummer", "PLZ", "Ort", "Land"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
						
		Statement stmt = null;
		try {
			stmt = DataBase.c.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (lastName != null) {
		sqlsearch = ""
				+ "SELECT *, (vorname + ' ' + name) AS fullname "
				+ "FROM Person "
				+ "WHERE UPPER(name) like UPPER('%" + search  +"%') "
						+ "OR UPPER(vorname) like UPPER('%" + search + "%') "
								+ "OR (UPPER(vorname) like UPPER('%" + firstName + "%') "
										+ "AND UPPER(name) like UPPER('%" + lastName + "%'))"
												+ "OR (UPPER(name) like UPPER('%" + firstName + "%')"
														+ "AND UPPER(vorname) like UPPER ('%" + lastName + "%'));";
		} else {
		sqlsearch = ""
					+ "SELECT *, (vorname + ' ' + name) AS fullname "
					+ "FROM Person "
					+ "WHERE UPPER(name) like UPPER('%" + search  +"%') "
							+ "OR UPPER(vorname) like UPPER('%" + search + "%');";
		}
		
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sqlsearch);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while(rs.next())
			{
				String a = rs.getString("ID_Person");
			    String b = rs.getString("Name");
			    String c = rs.getString("Vorname");
			    String d = rs.getString("Telefonnummer");
			    String e = rs.getString("Mail");
			    String f = rs.getString("Rolle");
			    String g = rs.getString("Straﬂe");
			    String h = rs.getString("Hausnummer");
			    String i = rs.getString("PLZ");
			    String j = rs.getString("Ort");
			    String k = rs.getString("Land");
			    
			    model.addRow(new Object[]{a, b,c,d,e,f,g, h, i, j, k});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainMenu.tblPersonen.setModel(model);
		MainMenu.scrollPane.setViewportView(MainMenu.tblPersonen);
		
		closeConnection();
	}
	
public static void searchOrder(String search) {
		
		getConnection();
		
		String firstName = null;
		String lastName = null;
		
		if (search.contains(" ")) {
		String[] parts = search.split(" ");
		firstName = parts[0]; // 004
		lastName = parts[1]; // 034556
		}
		String sqlsearch;
		
		int id = getIdPersonByNameSurname(firstName, lastName);
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
						
		Statement stmt = null;
		try {
			stmt = DataBase.c.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (lastName != null) {
		sqlsearch = "SELECT *\r\n" + 
				"FROM Auftrag\r\n" + 
				"INNER JOIN 'Mischtabelle-Person-Auftrag' on Auftrag.ID_Auftrag = 'Mischtabelle-Person-Auftrag'.ID_Auftrag  WHERE ID_Person = " + id + ";";
		} else {
			sqlsearch = "SELECT * FROM Auftrag WHERE UPPER(Titel) like UPPER('%" + search + "%');";
		}
		
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sqlsearch);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while(rs.next())
			{
				String a1 = rs.getString("ID_Auftrag");
			    String b1 = rs.getString("Titel");
			    String c1 = rs.getString("AF");
			    String d1 = rs.getString("Dateiname");
			    String e1 = rs.getString("Dateiort");
			    String f1 = rs.getString("PK");
			    String g1 = rs.getString("RK");
			    String h1 = rs.getString("ID_Status");
			    
			    model.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainMenu.tblAuftraege.setModel(model);
		MainMenu.scrollPane_1.setViewportView(MainMenu.tblAuftraege);
		
		closeConnection();
	}
	
	public static void searchTable(String text) {
		TableModel model = MainMenu.tblPersonen.getModel();
	final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		
		MainMenu.tblPersonen.setRowSorter(sorter);


    	if (text.length() == 0) {
		          sorter.setRowFilter(null);
		        } 
		        
		        else if(text.contains(" ")){
		        String[] parts =	text.split(" ");
		        	for(int i = 0; i<parts.length; i++) {
		        	sorter.setRowFilter(RowFilter.regexFilter(parts[i]));
		        	}
		        	
		        }
		        
		        else {
		          sorter.setRowFilter(RowFilter.regexFilter(text));
		        }
	}
	
	public static void loadSpecificStatusToRam(int ID_status) {
		  
	    status_list.removeAll(status_list);
	    int id_status; 
	  String status; 
	  String timestamp; 
	  
	  
	  Statement stmt = null;

	   
	   try {
	    
	     //Query 
	     String query = "SELECT * FROM Status WHERE ID_Status =" + ID_status + ";"; 
	      
	     // Getting Data from Database
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( query );
	      
	      while ( rs.next() ) {
	        
	        id_status = rs.getInt("ID_Status"); 
	        status = rs.getString("Status"); 
	        timestamp = rs.getString("Timestamp"); 
	        
	        
	        StatusObjektRAM tmp = new StatusObjektRAM( status, id_status, timestamp); 
	       
	        status_list.add(tmp); // Just 1 objekt

	        
	      }
	     
	      stmt.close();
	    
	   } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      
	   }
	   System.out.println("Operation done successfully");
	  
	  
	}
	
	public static void refreshDatabase() {

		getConnection();
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Vorname", "Telefon", "Email", "Rolle",  "Straﬂe", "Hausnummer", "PLZ", "Ort", "Land"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		
		Statement stmt = null;
		try {
			stmt = DataBase.c.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		String sql = "SELECT * FROM Person";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while(rs.next())
			{
				String a = rs.getString("ID_Person");
			    String b = rs.getString("Name");
			    String c = rs.getString("Vorname");
			    String d = rs.getString("Telefonnummer");
			    String e = rs.getString("Mail");
			    String f = rs.getString("Rolle");
			    String g = rs.getString("Straﬂe");
			    String h = rs.getString("Hausnummer");
			    String i = rs.getString("PLZ");
			    String j = rs.getString("Ort");
			    String k = rs.getString("Land");
			    
			    model.addRow(new Object[]{a, b,c,d,e,f,g, h, i, j, k});
			   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainMenu.txtSuchen.setText("");
		
		MainMenu.tblPersonen.setModel(model);
	
		closeConnection();
	}
	
	
	public static void refreshOrder() {

		getConnection();
		
		DefaultTableModel modelAuftrag = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		
		Statement stmt = null;
		try {
			stmt = DataBase.c.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		String sql = "SELECT * FROM Auftrag";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while(rs.next())
			{
				String a1 = rs.getString("ID_Auftrag");
			    String b1 = rs.getString("Titel");
			    String c1 = rs.getString("AF");
			    String d1 = rs.getString("Dateiname");
			    String e1 = rs.getString("Dateiort");
			    String f1 = rs.getString("PK");
			    String g1 = rs.getString("RK");
			    String h1 = rs.getString("ID_Status");
			    
			    modelAuftrag.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1});
			   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MainMenu.tblAuftraege.setModel(modelAuftrag);
	
		closeConnection();
	}
	  
	  
	public static void loadStatusToRam(int ID_order) {
	    
	    status_list.removeAll(status_list);

	    int id_status; 
	    String status; 
	    String timestamp; 
	    
	    
	    Statement stmt = null;

	     
	     try {
	      
	       //Query 
	       String query = "SELECT * FROM Status WHERE ID_Auftrag =" + ID_order + ";"; 
	       
	       // Getting Data from Database
	        stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery( query );
	        
	        while ( rs.next() ) {
	          
	          id_status = rs.getInt("ID_Status"); 
	          status = rs.getString("Status"); 
	          timestamp = rs.getString("Timestamp"); 
	          
	          
	          StatusObjektRAM tmp = new StatusObjektRAM( status, id_status, timestamp); 
	         
	          status_list.add(tmp); 
	  
	          
	        }
	       
	        stmt.close();
	      
	     } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        
	     }
	     System.out.println("Operation done successfully");
	     }
	
	  
	  public static String getPassword(String query) {
	    String password = null; 
	  Statement stmt = null;
	    
	   try {
	    
	     // Getting Data from Database
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( query );
	      
	      while ( rs.next() ) {
	        password = rs.getString("passwort"); 
	        
	      }
	     
	      stmt.close();
	    
	   } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      
	   }
	   System.out.println("Operation done successfully");
	   
	   return password; 
	   
	  }
}
