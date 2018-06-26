package Data;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import GUI.MainMenu;
public class DataBase {

	public static Connection c = null; 
	
	
	public static ArrayList<PersonObjektRAM> people = new ArrayList<PersonObjektRAM>(); 
	public static ArrayList<OrderObjektRAM> orders = new ArrayList<OrderObjektRAM>();
	public static ArrayList<StatusObjektRAM> status_list = new ArrayList<StatusObjektRAM>();  //  Status-objects for a specific Person. Will be overwritten !!
	public static ArrayList<OffenerAuftragObjektRAM> offeneAuftraege = new ArrayList<OffenerAuftragObjektRAM>();
	
	public static OrderObjektRAM order = null; 
	
	
	
	public static void getConnection() {
	
		  
		//Verbindungsaufbau zur Datenbank	
	      try {
	    	 File desktopDir = new File(System.getProperty("user.home"), "Desktop");
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:"+ desktopDir.getPath() +"\\Projekt1-DB.db");
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
	
	
	public static String getRolleByOrderId(String id_auftrag) {
		String rolle = null;
		Statement stmt = null;
		try{
		String sqlRolle = "SELECT Rolle FROM 'Mischtabelle-Person-Auftrag' WHERE ID_Auftrag like'" + id_auftrag + "';";
		
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sqlRolle);
			
			
				while(rs.next()) {rolle = rs.getString("Rolle");}
				stmt.close();
		}catch ( Exception e ) {
		      System.err.println( "ID Order not found");
		      
		   }
		
		return rolle;
		
	}
	
	public static String getPersonById(int id_person) {
		String fullName = null;
		Statement stmt = null;
		String firstName = null;
		String lastName = null;
		try{
		String sqlGetPerson = "SELECT Name, Vorname FROM Person WHERE ID_Person =" + id_person + ";";
		
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sqlGetPerson);
			
			
				while(rs.next()) {
					firstName = rs.getString("Vorname");
					lastName = rs.getString("Name");}
				stmt.close();
		}catch ( Exception e ) {
		      System.err.println( "ID Order not found");
		      
		   }
		
		fullName = firstName + " " + lastName;
		return fullName;
		
	}
	
	
	public static String getIdAPbyBillId(String id_bill) {
		String idAp = null;
		Statement stmt = null;
		try{
		String sqlIdAp = "SELECT Ansprechpartner FROM Rechnung WHERE ID_Rechnung like '" + id_bill + "';";
		
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sqlIdAp);
			
			
				while(rs.next()) {idAp = rs.getString("Ansprechpartner");}
				stmt.close();
		}catch ( Exception e ) {
		      System.err.println( "ID Bill not found");
		      
		   }
		
		return idAp;
		
	}
	
	
	public static String getBezahlungBill(String id_bill) {
		String art = null;
		Statement stmt = null;
		try{
		String sqlIdAp = "SELECT Bezahlung_Art FROM Rechnung WHERE ID_Rechnung like '" + id_bill + "';";
		
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sqlIdAp);
			
			
				while(rs.next()) {art = rs.getString("Bezahlung_Art");}
				stmt.close();
		}catch ( Exception e ) {
		      System.err.println( "ID Bill not found");
		      
		   }
		
		return art;
		
	}
	
	
	public static ArrayList<String> getCategoryList() {
		
		
		
		ArrayList<String> comboList = new ArrayList<String>();
		
		String category = null;
		Statement stmt = null;
		
		try {
		String sql = "SELECT Name FROM Kategorie";
		
			
		
				stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
				while(rs.next()) {category = rs.getString("Name");
				comboList.add(category);}
				
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		return comboList;
		
	}
	
	public static String getRolleByPersonId(String id_person) {
		
		String rolle = null;
		Statement stmt = null;
		try{
		String sqlRolle = "SELECT Rolle FROM Person WHERE ID_Person like'" + id_person + "';";
		
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sqlRolle);
			
			
				while(rs.next()) {rolle = rs.getString("Rolle");}
				stmt.close();
		}catch ( Exception e ) {
		      System.err.println( "ID Order not found");
		      
		   }
		
		return rolle;
		
	}
	
	public static String getStatusBeiAuftragId(String id_auftrag) {
		String status = null;
		Statement stmt = null;
		try{
		String sqlStatus = "SELECT Status FROM Status WHERE ID_Auftrag like'" + id_auftrag + "';";
		
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sqlStatus);
			
			
				while(rs.next()) {status = rs.getString("Status");}
				stmt.close();
		}catch ( Exception e ) {
		      System.err.println( "ID Order not found");
		      
		   }
		
		return status;
		
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
		
		getConnection();
		
		people.removeAll(people); 

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
	   closeConnection();
		
	}
	
public static void loadOrdersToRAM() {
		
	getConnection();
		orders.removeAll(orders); 

		int idAuftrag; 
		String titel; 
		String af; 
		String dateiname; 
		String dateiort; 
		String pk; 
		String rk; 
		
		Statement stmt = null;

	   
	   try {
	    
		   //Query 
		   String query = "SELECT * FROM Auftrag;"; 
		   
		   // Getting Data from Database
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( query );
	      
	      while ( rs.next() ) {
	    	  idAuftrag = rs.getInt("ID_Auftrag");
	    	  titel = rs.getString("Titel"); 
	    	  af = rs.getString("AF"); 
	    	  dateiname = rs.getString("Dateiname"); 
	    	  dateiort = rs.getString("Dateiort"); 
	    	  pk = rs.getString("PK"); 
	    	  rk = rs.getString("RK"); 
	    	  
	    	  OrderObjektRAM order = new OrderObjektRAM( idAuftrag, titel, af,  dateiname, dateiort, pk,  rk); 
	    	  
	    	  orders.add(order); 
	    	  
	      }
	     
	      stmt.close();
	    
	   } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      
	   }
	   System.out.println("Operation done successfully");
	   
	   closeConnection();
		
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
		MainMenu.scrollPanePerson.setViewportView(MainMenu.tblPersonen);
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
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID-Person", "Name", "Vorname", "Email"}, 0) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

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
				String id = rs.getString("ID_Person");
			    String a = rs.getString("Name");
			    String b = rs.getString("Vorname");
			    String c = rs.getString("Mail");
			    
			    model.addRow(new Object[]{id, a, b,c});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainMenu.tblPersonen.setModel(model);
		MainMenu.scrollPanePerson.setViewportView(MainMenu.tblPersonen);
		TableColumnModel tcm = MainMenu.tblPersonen.getColumnModel();
		tcm.removeColumn( tcm.getColumn(0) );
		
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
		
		int id = getIdPersonByNameSurname(lastName, firstName);
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "Status"}, 0) {
			
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
				String idAuftrag = rs.getString("ID_Auftrag");
			    String a = rs.getString("Titel");
			    String b = DataBase.getStatusBeiAuftragId(idAuftrag);
			    
			    model.addRow(new Object[]{idAuftrag, a, b});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainMenu.tblAuftraege.setModel(model);
		MainMenu.scrollPaneOrder.setViewportView(MainMenu.tblAuftraege);
		TableColumnModel tcm = MainMenu.tblAuftraege.getColumnModel();
		tcm.removeColumn( tcm.getColumn(0) );
		
		closeConnection();
	}

	public static void searchComponent(String search) {
	
	getConnection();
	
	DefaultTableModel modelComponents = new DefaultTableModel(new String[]{"ID Bauteil", "Name","Link", "Menge lagernd", "Menge bestellt", "Menge geplant", "Lagerort"}, 0) {
		
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
	
	String sqlsearch = "SELECT * FROM Bauteil WHERE UPPER(Name) like UPPER('%" + search + "%');";
	
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
			String a1 = rs.getString("ID_Bauteil");
		    String b1 = rs.getString("Name");
		    String c1 = rs.getString("Link");
		    String d1 = rs.getString("MengeLagernd");
		    String e1 = rs.getString("MengeBestellt");
		    String f1 = rs.getString("MengeGeplant");
		    String g1 = rs.getString("Lagerort");
		    
		    modelComponents.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1});
		   
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	MainMenu.tblComponents.setModel(modelComponents);
//	MainMenu.scrollPane_3.setViewportView(MainMenu.tblComponents);
	
	closeConnection();
}
	
	public static void searchBill(String search) {
		
		getConnection();
		
		DefaultTableModel modelRechnung = new DefaultTableModel(new String[]{"ID_Rechnung", "Rechnungsname", "Auftraggeber", "Betrag", "Beschreibung", "Bearbeiter", "Timestamp"}, 0) {
			
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
		
		String sqlsearch = "SELECT * FROM Rechnung WHERE UPPER(Rechnungsname) like UPPER('%" + search + "%');";
		
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
				String a1 = rs.getString("ID_Rechnung");
			    String b1 = rs.getString("Rechnungsname");
			    String c1 = rs.getString("Auftraggeber");
			    String d1 = rs.getString("Betrag");
			    String e1 = rs.getString("Beschreibung");
			    String f1 = rs.getString("Bearbeiter");
			    String g1 = rs.getString("Timestamp");
			    
			    modelRechnung.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1});
			   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainMenu.tblRechn.setModel(modelRechnung);
//		MainMenu.scrollPane_3.setViewportView(MainMenu.tblComponents);
		
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
		MainMenu.txtSearchPerson.setText("");
		
		MainMenu.tblPersonen.setModel(model);
	
		closeConnection();
	}
	
	public static void refreshPersonen() {

		getConnection();
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID_Person", "Name", "Vorname", "Email"}, 0) {
			
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
			    
			    model.addRow(new Object[]{a,b,c,e});
			   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainMenu.txtSearchPerson.setText("");
		
		MainMenu.tblPersonen.setModel(model);
		TableColumnModel tcm = MainMenu.tblPersonen.getColumnModel();
		tcm.removeColumn( tcm.getColumn(0) );
	
		closeConnection();
	}
	
public static void refreshBill2() {
		
		getConnection();
		DefaultTableModel modelRechnung = new DefaultTableModel(new String[]{"ID_Rechnung", "Rechnungsname", "Auftraggeber", "Betrag", "Beschreibung", "Bearbeiter", "Timestamp"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			
		String sqlRechnung = "SELECT * FROM Rechnung";
		
		ResultSet rsRechnung = null;
		
		Statement stmt = null;
		try {
			stmt = DataBase.c.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			rsRechnung = stmt.executeQuery(sqlRechnung);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try{
		while(rsRechnung.next())
		{
			String a1 = rsRechnung.getString("ID_Rechnung");
		    String b1 = rsRechnung.getString("Rechnungsname");
		    String c1 = rsRechnung.getString("Auftraggeber");
//		    String d1 = rsRechnung.getString("Bezahlung_Art");
		    String e1 = rsRechnung.getString("Betrag");
		    String f1 = rsRechnung.getString("Beschreibung");
		    String g1 = rsRechnung.getString("Bearbeiter");
		    String h1 = rsRechnung.getString("Timestamp");
		    
		    modelRechnung.addRow(new Object[]{a1, b1,c1, e1, f1, g1, h1});
		}
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainMenu.tblRechn.setModel(modelRechnung);

		closeConnection();
		
	}
	
	
	public static void refreshOrder() {

		getConnection();
		
		DefaultTableModel modelAuftrag = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "Status"}, 0) {
			
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
				String id = rs.getString("ID_Auftrag");
			    String a = rs.getString("Titel");
			    String b = DataBase.getStatusBeiAuftragId(id);
			    
			    modelAuftrag.addRow(new Object[]{id, a, b});
			   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MainMenu.tblAuftraege.setModel(modelAuftrag);
		TableColumnModel tcm = MainMenu.tblAuftraege.getColumnModel();
		tcm.removeColumn( tcm.getColumn(0) );
	
		closeConnection();
	}
	
	public static void refreshOrderBill() {

		getConnection();
		
		DefaultTableModel modelAuftrag = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status", "Rolle"}, 0) {
			
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

		String sql = "SELECT * FROM Auftrag WHERE ID_Rechnung is null;";
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
			    String h1 = DataBase.getStatusBeiAuftragId(a1);
			    String j1 = DataBase.getRolleByOrderId(a1);
			    
			    modelAuftrag.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1, j1});
			   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MainMenu.tblAuftraegeRechnung.setModel(modelAuftrag);
	
		closeConnection();
	}
	
	public static void refreshOrdersInBill() {
		getConnection();
		

		int selectedRowIndexBills = MainMenu.tblBills.getSelectedRow();
		int id_Rechnung = Integer.parseInt(MainMenu.tblBills.getModel().getValueAt(selectedRowIndexBills, 0).toString());
		DefaultTableModel modelOrderBill = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status", "Rolle"}, 0) {
			
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
		//String sqlOrderBill = "SELECT Auftrag.* FROM Auftrag INNER JOIN 'Mischtabelle-Rechnung-Auftrag' ON Auftrag.ID_Auftrag = 'Mischtabelle-Rechnung-Auftrag'.ID_Auftrag WHERE 'Mischtabelle-Rechnung-Auftrag'.ID_Rechnung like '" + idbill +"';";
			String sqlOrderBill = "SELECT Auftrag.* FROM Auftrag INNER JOIN 'Mischtabelle-Rechnung-Auftrag' ON Auftrag.ID_Auftrag = 'Mischtabelle-Rechnung-Auftrag'.ID_Auftrag WHERE 'Mischtabelle-Rechnung-Auftrag'.ID_Rechnung =" + id_Rechnung + ";";			ResultSet rsOrderBill = null;
			try {
				rsOrderBill = stmt.executeQuery(sqlOrderBill);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		//String r = null;
		//String sqlRolle = "SELECT Rolle FROM Mischtabelle-Person-Auftrag WHERE ID_Auftrag =" + r + ";";
		
		try{
		while(rsOrderBill.next())
		{
			String a1 = rsOrderBill.getString("ID_Auftrag");
		    String b1 = rsOrderBill.getString("Titel");
		    String c1 = rsOrderBill.getString("AF");
		    String d1 = rsOrderBill.getString("Dateiname");
		    String e1 = rsOrderBill.getString("Dateiort");
		    String f1 = rsOrderBill.getString("PK");
		    String g1 = rsOrderBill.getString("RK");
		    String h1 = DataBase.getStatusBeiAuftragId(a1);
		    
		    String j1 = DataBase.getRolleByOrderId(a1);
		    //System.out.println(a1);
		   // System.out.println(j1);
		  
		    
		    modelOrderBill.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1, j1});
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		MainMenu.tblOrdersInBill.setModel(modelOrderBill);
		
		closeConnection();
	}
	
	
	
	public static void refreshComponent() {

		getConnection();
		
	DefaultTableModel modelComponents = new DefaultTableModel(new String[]{"ID Bauteil", "Name","Link", "Menge lagernd", "Menge bestellt", "Menge geplant", "Lagerort", "Preis"}, 0) {
			
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

		String sql = "SELECT * FROM Bauteil";
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
				String a1 = rs.getString("ID_Bauteil");
			    String b1 = rs.getString("Name");
			    String c1 = rs.getString("Link");
			    String d1 = rs.getString("MengeLagernd");
			    String e1 = rs.getString("MengeBestellt");
			    String f1 = rs.getString("MengeGeplant");
			    String g1 = rs.getString("Lagerort");
			    int id = Integer.parseInt(a1);
			    
			    String h1 =BauteileAuftragsabwicklung.getComponentPrice(id);
			    
			    modelComponents.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1});
			   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MainMenu.tblComponents.setModel(modelComponents);
	
		closeConnection();
	}
	
	
	public static void refreshComponentCategory() {

		getConnection();
		
	DefaultTableModel modelComponents = new DefaultTableModel(new String[]{"ID Bauteil", "Name","Link", "Menge lagernd", "Menge bestellt", "Menge geplant", "Lagerort", "Preis"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			int colnr  = MainMenu.tblCategory.getSelectedRow();
			
			String id = MainMenu.tblCategory.getModel().getValueAt(colnr, 0).toString();
		Statement stmt = null;
		try {
			stmt = DataBase.c.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		String sql = "SELECT Bauteil.* FROM Bauteil INNER JOIN 'Mischtabelle-Kategorie-Bauteil' on Bauteil.ID_Bauteil = 'Mischtabelle-Kategorie-Bauteil'.ID_Bauteil where 'Mischtabelle-Kategorie-Bauteil'.ID_Kategorie ="+id+";";
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
				String a1 = rs.getString("ID_Bauteil");
			    String b1 = rs.getString("Name");
			    String c1 = rs.getString("Link");
			    String d1 = rs.getString("MengeLagernd");
			    String e1 = rs.getString("MengeBestellt");
			    String f1 = rs.getString("MengeGeplant");
			    String g1 = rs.getString("Lagerort");
			    int id1 = Integer.parseInt(a1);
			    
			    String h1 =BauteileAuftragsabwicklung.getComponentPrice(id1);
			    
			    modelComponents.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1});
			   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MainMenu.tblComponents.setModel(modelComponents);
	
		closeConnection();
	}
	
	public static void refreshKasse() {

		getConnection();
		
		DefaultTableModel modelKasse = new DefaultTableModel(new String[]{"ID_Kasse", "Art", "Nummer", "Soll", "Ist"}, 0) {
			
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

		String sql = "SELECT * FROM Kasse;";
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
				String a1 = rs.getString("ID_Kasse");
			    String b1 = rs.getString("Art");
			    String c1 = rs.getString("Nummer");
			    String d1 = rs.getString("Soll");
			    String e1 = rs.getString("Ist");
			    			    
			    modelKasse.addRow(new Object[]{a1, b1,c1,d1,e1});
			   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MainMenu.tblKasse.setModel(modelKasse);
	
		closeConnection();
	}

	public static void refreshTopf() {

		getConnection();
		
		DefaultTableModel modelTopf = new DefaultTableModel(new String[]{"ID_Topf", "ID_Kasse", "Soll", "Ist"}, 0) {
			
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

		String sql = "SELECT Topf.*, 'Mischtabelle-Kasse-Topf'.ID_Kasse FROM Topf LEFT JOIN 'Mischtabelle-Kasse-Topf' ON Topf.ID_Topf = 'Mischtabelle-Kasse-Topf'.ID_Topf;";
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
				String a1 = rs.getString("ID_Topf");
			    String b1 = rs.getString("ID_Kasse");
			    String c1 = rs.getString("Soll");
			    String d1 = rs.getString("Ist");
			    			    
			    modelTopf.addRow(new Object[]{a1,b1,c1,d1});
			   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MainMenu.tblTopf.setModel(modelTopf);
	
		closeConnection();
	}
	
	public static void refreshBill () {
		getConnection();
		
		DefaultTableModel modelBill = new DefaultTableModel(new String[]{"ID_Rechnung", "Rechnungsname", "Auftraggeber", "Betrag", "Beschreibung", "TimeStamp"}, 0) {
			
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

		String sql = "SELECT * FROM Rechnung";
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
				String a1 = rs.getString("ID_Rechnung");
			    String b1 = rs.getString("Rechnungsname");
			    String c1 = rs.getString("Auftraggeber");
			   // String d1 = rsBill.getString("Ansprechpartner");
			   // String e1 = rsBill.getString("Bezahlung_Art");
			    String f1 = rs.getString("Betrag");
			    String g1 = rs.getString("Beschreibung");
			   // String h1 = rsBill.getString("Bearbeiter");
			    String j1 = rs.getString("TimeStamp");
			   
			  
			    
			    modelBill.addRow(new Object[]{a1, b1,c1,f1,g1, j1});
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MainMenu.tblBills.setModel(modelBill);
	
		closeConnection();
		
		
		
	}
	
	public static void refreshRechn () {
		getConnection();
		
		DefaultTableModel modelBill = new DefaultTableModel(new String[]{"ID_Rechnung", "Rechnungsname", "Auftraggeber", "Betrag", "Beschreibung", "TimeStamp"}, 0) {
			
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

		String sql = "SELECT * FROM Rechnung";
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
				String a1 = rs.getString("ID_Rechnung");
			    String b1 = rs.getString("Rechnungsname");
			    String c1 = rs.getString("Auftraggeber");
			   // String d1 = rsBill.getString("Ansprechpartner");
			   // String e1 = rsBill.getString("Bezahlung_Art");
			    String f1 = rs.getString("Betrag");
			    String g1 = rs.getString("Beschreibung");
			   // String h1 = rsBill.getString("Bearbeiter");
			    String j1 = rs.getString("TimeStamp");
			   
			  
			    
			    modelBill.addRow(new Object[]{a1, b1,c1,f1,g1, j1});
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MainMenu.tblRechn.setModel(modelBill);
	
		closeConnection();
		
		
		
	}
	public static void refreshCategory() {

		getConnection();
		
		DefaultTableModel modelCategory = new DefaultTableModel(new String[]{"ID", "Kategorie"}, 0) {
			
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

		String sql = "SELECT * FROM Kategorie";
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
				String a1 = rs.getString("ID_Kategorie");
			    String b1 = rs.getString("Name");
			   
			    
			    
			 
			  
			    
			    modelCategory.addRow(new Object[]{a1, b1});
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MainMenu.tblCategory.setModel(modelCategory);
	
		closeConnection();
	}

	
	public static void refreshChange() {

		getConnection();
		
		DefaultTableModel modelOffeneAuftraege = new DefaultTableModel(new String[]{"ID ƒnderung", "ID Bauteil","ID Person", "Vorname", "Name", "Timestamp", "Aenderung"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};	
			
			DataBase.loadOffeneAuftraegeToRam();
			
			
			for(OffenerAuftragObjektRAM tmp: DataBase.offeneAuftraege) {
				
			int id_aenderung = tmp.getid_aenderung();
			int id_bauteil = tmp.getId_bauteil();
			int id_person = tmp.getId_person();
			String vorname = tmp.getVorname();
			String name = tmp.getName();
			String timestamp = tmp.getTimestamp();
			int aenderung = tmp.getAenderung();
			
			
			 modelOffeneAuftraege.addRow(new Object[]{id_aenderung, id_bauteil, id_person, vorname, name, timestamp, aenderung});
			
			
			
	
			}
			
			MainMenu.tblOffeneAuftraege.setModel(modelOffeneAuftraege);
		
		
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
	  
	  // Offene Auftraege 
	  
	  public static void loadOffeneAuftraegeToRam() {
		  
		  	offeneAuftraege.removeAll(offeneAuftraege); 
		  
		  
			int id_aenderung; 
			int id_bauteil; 
			int id_person; 
			String name;
			String vorname;
			String timestamp; 
			int aenderung; 
			int lager;
			
	
			
			Statement stmt = null;
		    
		   try {
		    
		     // Getting Data from Database
		      stmt = c.createStatement();
		      String query = "SELECT ƒnderung.*, Person.name, Person.vorname, Bauteil.* FROM ƒnderung INNER JOIN Person ON ƒnderung.ID_Person = Person.ID_Person INNER JOIN Bauteil on ƒnderung.ID_Bauteil = Bauteil.ID_Bauteil;"; 
		      
		      ResultSet rs = stmt.executeQuery(query);
		      
		      while ( rs.next() ) {
		    	  id_aenderung = rs.getInt("ID_ƒnderung"); 
		    	  id_bauteil = rs.getInt("ID_Bauteil"); 
		    	  id_person = rs.getInt("ID_Person"); 
		    	  timestamp = rs.getString("timestamp"); 
		    	  aenderung = rs.getInt("ƒnderung"); 
		    	  name = rs.getString("Name"); 
		    	  vorname = rs.getString("Vorname"); 
		    	  lager = rs.getInt("MengeLagernd");
		    	  
		    	  OffenerAuftragObjektRAM tmp = new OffenerAuftragObjektRAM(id_aenderung,id_bauteil,id_person,name, vorname,timestamp, aenderung, lager); 
		    	  offeneAuftraege.add(tmp);
		      }
		      
		      stmt.close();
		    
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      
		   }
		   System.out.println("Operation done successfully");
		  }
	  
	  
	  public static void loadAuftragID(int id_aenderung) {
		  
		  	offeneAuftraege.removeAll(offeneAuftraege); 
		  
			int id_bauteil; 
			int id_person; 
			String name;
			String vorname;
			String timestamp; 
			int aenderung; 
			int lager;
	
			
			Statement stmt = null;
		    
		   try {
		    
		     // Getting Data from Database
		      stmt = c.createStatement();
		      String query = "SELECT ƒnderung.*, Person.name, Person.vorname, Bauteil.* FROM ƒnderung INNER JOIN Person ON ƒnderung.ID_Person = Person.ID_Person INNER JOIN Bauteil on ƒnderung.ID_Bauteil = Bauteil.ID_Bauteil WHERE ID_ƒnderung like '" + id_aenderung +"';"; 
		      
		      ResultSet rs = stmt.executeQuery(query);
		      
		      while ( rs.next() ) {
		    	  id_aenderung = rs.getInt("ID_ƒnderung"); 
		    	  id_bauteil = rs.getInt("ID_Bauteil"); 
		    	  id_person = rs.getInt("ID_Person"); 
		    	  timestamp = rs.getString("timestamp"); 
		    	  aenderung = rs.getInt("ƒnderung"); 
		    	  name = rs.getString("Name"); 
		    	  vorname = rs.getString("Vorname"); 
		    	  lager = rs.getInt("MengeLagernd");
		    	  
		    	  OffenerAuftragObjektRAM tmp = new OffenerAuftragObjektRAM(id_aenderung,id_bauteil,id_person,name, vorname,timestamp, aenderung, lager); 
		    	  offeneAuftraege.add(tmp);
		      }
		      
		      stmt.close();
		    
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      
		   }
		   System.out.println("Operation done successfully");
		  }
	  
	  public static void getNameSurname(int id_person) {
		  	
		  	people.removeAll(people); 
		  
		  	String name;
			String vorname;
			
			Statement stmt = null;
		    
		   try {
		    
		     // Getting Data from Database
		      stmt = c.createStatement();
		      String query = "SELECT * FROM Person WHERE ID_Person = " + id_person + ";"; 
		      
		      ResultSet rs = stmt.executeQuery(query);
		      
		      while ( rs.next() ) {
		    	  name = rs.getString("Name"); 
		    	  vorname = rs.getString("Vorname"); 
		    	  
		    	  PersonObjektRAM tmp = new PersonObjektRAM( id_person, name,"","", "", "", "", "", "", "",0, "",vorname); 
		    	 
		    	  people.add(tmp);
		      }
		      
		      stmt.close();
		    
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      
		   }
		   System.out.println("Operation done successfully");
		  }
	  
	  ///----
	  
	  public static int[] getMengenBauteile (int id_bauteil) {
		  
		int mengeLagernd; 
		int mengeBestellt; 
		int mengeGeplant; 
		
		int [] mengen = new int[3]; 
		Statement stmt = null;
	   
	   try {
	    
		   //Query 
		   String query = "SELECT * FROM Bauteil WHERE ID_Bauteil = " + id_bauteil + ";"; 
		   
		   // Getting Data from Database
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( query );
	      
	      while ( rs.next() ) {
	    	mengeLagernd = rs.getInt("MengeLagernd"); 
	    	mengeBestellt = rs.getInt("MengeBestellt"); 
	    	mengeGeplant = rs.getInt("MengeGeplant");
	    	
	    	mengen[0] = mengeLagernd; 
	    	mengen[1] = mengeBestellt; 
	    	mengen[2] = mengeGeplant; 
	    	  
	      }
	     
	      stmt.close();
	    
	   } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      
	   }
	   
	   System.out.println("Operation done successfully");
	   return mengen; 
	}
	 
	  public static String getBauteilName (int id_bauteil) {
		  String name = "";
		  
			Statement stmt = null;
		   
		   try {
		    
			   //Query 
			   String query = "SELECT Name FROM Bauteil WHERE ID_Bauteil = " + id_bauteil + ";"; 
			   
			   // Getting Data from Database
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( query );
		      
		      while ( rs.next() ) {
		    	name = rs.getString("Name");		    	  
		      }
		     
		      stmt.close();
		    
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      
		   }
		   
		   System.out.println("Operation done successfully");
		   return name; 
		}
	  
	  public static ArrayList<Integer> getBauteileIDByKategorie (int id_kategorie) {
		  
		  	ArrayList<Integer> ids = new ArrayList<Integer>(); 
		  
			Statement stmt = null;
		   
		   try {
		    
			   //Query 
			   String query = "SELECT ID_Kategorie FROM 'Mischtabelle-Kategorie-Bauteil' WHERE ID_Kategorie ="+ id_kategorie + ";"; 
			   
			   // Getting Data from Database
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( query );
		      int id; 
		      while ( rs.next() ) {
		    	id = rs.getInt("ID_Kategorie");	
		    	ids.add(id); 
		    	
		      }
		     
		      stmt.close();
		    
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      
		   }
		   
		   System.out.println("Operation done successfully");
		   return ids; 
		}
	  //------------
	  
	  public static void createOrderObjektRAM (int id_Order) {
		  
		  int id_Auftrag; 
		  String titel; 
		  String af;
		  String dateiname;
		  String dateiort;
		  String pk;
		  String rk;
					  
		  Statement stmt = null;
		   
		   try {
		    
			   //Query 
			   String query = "SELECT * Auftrag WHERE ID_Auftrag ="+ id_Order + ";"; 
			   
			   // Getting Data from Database
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( query );
		
		      while ( rs.next() ) {
		    	id_Auftrag = rs.getInt("ID_Auftrag");	
		    	titel = rs.getString("Titel"); 
		    	af = rs.getString("AF"); 
		    	dateiname = rs.getString("Dateiname");
		    	dateiort = rs.getString("Dateiort");
		    	pk = rs.getString("PK");
		    	rk = rs.getString("RK"); 
		    	
		    	order = new OrderObjektRAM( id_Auftrag,  titel,  af, dateiname, dateiort, pk,  rk); // Testen !
		    	
		      }
		     
		      stmt.close();
		    
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      
		   }
		   
		   System.out.println("Operation done successfully");
	    
	  }
	  
	  //----
	  
	  public static String getRolleByIDPerson(int id_Person) {
		 
		  String rolle = null;
					  
		  Statement stmt = null;
		   
		   try {
		    
			   //Query 
			   String query = "SELECT Rolle FROM Person WHERE ID_Person ="+ id_Person + ";"; 
			   
			   // Getting Data from Database
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( query );
		
		      while ( rs.next() ) {
		    	 
		    	rolle = rs.getString("Rolle"); 
		    		    	
		      }
		     
		      stmt.close();
		    
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      
		   }
		   
		   System.out.println("Operation done successfully");
	     
		  return rolle; 
	  }
	  
	  
	  //------------------------------
	  public static String[] getNameVornameByMail(String mail) {
		  
		  String [] namen = new String[2]; 
		  String vorname = ""; 
		  String name = ""; 
		  
		  Statement stmt = null;
		   
		   try {
		    
			   //Query 
			   String query = "SELECT * FROM Person WHERE Mail like '"+ mail + "';"; 
			   
			   // Getting Data from Database
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( query );
		
		      while ( rs.next() ) {
		    	 
		    	vorname = rs.getString("Vorname"); 
		    	name = rs.getString("Name"); 
		    	
		    	namen[0] = vorname; 
		    	namen[1] = name; 
		    	
		      }
		     
		      stmt.close();
		    
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      
		   }
		   
		   System.out.println("Operation done successfully");
	     
		   return namen; 
		  
	  }
	  
	  
	  
}