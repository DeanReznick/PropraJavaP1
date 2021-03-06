package Data;
import java.awt.Component;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;

import GUI.MainMenu;
public class DataBase {

	public static Connection c = null; 
	
	
	public static ArrayList<PersonObjektRAM> people = new ArrayList<PersonObjektRAM>(); 
	public static ArrayList<OrderObjektRAM> orders = new ArrayList<OrderObjektRAM>();
	public static ArrayList<StatusObjektRAM> status_list = new ArrayList<StatusObjektRAM>();  //  Status-objects for a specific Person. Will be overwritten !!
	public static ArrayList<OffenerAuftragObjektRAM> offeneAuftraege = new ArrayList<OffenerAuftragObjektRAM>();
	public static ArrayList<ComponentObjektRAM> components = new ArrayList<ComponentObjektRAM>();
	public static ArrayList<CategoryObjektRAM> categories = new ArrayList<CategoryObjektRAM>();
	
	public static OrderObjektRAM order = null; 
	
	
	
	public static void getConnection() {
	
		  if(c == null)
		  {
			//Verbindungsaufbau zur Datenbank	
		      try {
		    	 File desktopDir = new File(System.getProperty("user.home"), "Desktop");
		         Class.forName("org.sqlite.JDBC");
		         c = DriverManager.getConnection("jdbc:sqlite:Projekt1-DB.db");
		         c.setAutoCommit(false);
		      } catch ( Exception e ) {
		         System.err.println( e.getClass().getName() + ": " + e.getMessage() ); 
		      }
		      System.out.println("Opened database successfully");
		  }
		
	      
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
		
		
		
		people.removeAll(people); 

		int ID_Person; 
		String name; 
		String telefonnummer; 
		String mail; 
		String timestamp; 
		String rolle; 
		String passwort; 
		String land; 
		String stra�e; 
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
	    	  stra�e = rs.getString("stra�e"); 
	    	  ort = rs.getString("ort"); 
	    	  plz = rs.getInt("plz"); 
	    	  hausnummer = rs.getString("Hausnummer"); 
	    	  vorname = rs.getString("vorname");
	    	  
	    	  PersonObjektRAM person = new PersonObjektRAM( ID_Person, name, telefonnummer,  mail, timestamp, rolle,  passwort,  land,  stra�e,ort, plz, hausnummer,vorname); 
	    	  
	    	  people.add(person); 
	    	  
	      }
	     
	      stmt.close();
	    
	   } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      
	   }
	   System.out.println("Operation done successfully");
	   
		
	}
	
public static void loadOrdersToRAM() {
		
	
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
	   
	   
		
	}

	public static void loadComponentsToRAM() {
		
		
		
		components.removeAll(components); 
	
		int ID_Bauteil;
		int ID_Kategorie;
		String name;
		String link;
		int mengeLagernd;
		int mengeBestellt;
		int mengeGeplant;
		String lagerort;
		
		Statement stmt = null;
	
	   
	   try {
	    
		   //Query 
		   String query = "SELECT * FROM TBauteil;"; 
		   
		   // Getting Data from Database
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( query );
	      
	      while ( rs.next() ) {
	    	  ID_Bauteil = rs.getInt("ID_TBauteil");
//	    	  ID_Kategorie = rs.getInt("ID_Kategorie"); 
	    	  name = rs.getString("Name"); 
	    	  link = rs.getString("Link"); 
	    	  mengeLagernd = rs.getInt("MengeLagernd"); 
	    	  mengeBestellt = rs.getInt("MengeBestellt"); 
	    	  mengeGeplant = rs.getInt("MengeGeplant"); 
	    	  lagerort = rs.getString("Lagerort");
	    	  int category = rs.getInt("ID_TKategorie");
	    	  double preis = rs.getDouble("Preis");
	    	  
	    	  ComponentObjektRAM component = new ComponentObjektRAM( ID_Bauteil, name,  link, mengeLagernd, mengeBestellt,  mengeGeplant,  lagerort, category, preis); 
	    	  
	    	  components.add(component); 
	    	  
	      }
	     
	      stmt.close();
	    
	   } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      
	   }
	   System.out.println("Operation done successfully");
	   
		
	}
	
public static void loadCategoriesToRAM() {
		
		
		
		categories.removeAll(categories); 

		int ID_Category; 
		int ID_Parent;
		String name;
		
		Statement stmt = null;

	   
	   try {
	    
		   //Query 
		   String query = "SELECT * FROM TKategorie;"; 
		   
		   // Getting Data from Database
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( query );
	      
	      while ( rs.next() ) {
	    	  ID_Category = rs.getInt("ID_TKategorie");
	    	  ID_Parent = rs.getInt("ID_Parent");
	    	  name = rs.getString("name"); 
	    	  
	    	  CategoryObjektRAM category = new CategoryObjektRAM( ID_Category, ID_Parent, name); 
	    	  
	    	  categories.add(category); 
	    	  
	      }
	     
	      stmt.close();
	      
	      
	      Iterator<CategoryObjektRAM> it = categories.iterator(); 
	      
	      while (it.hasNext()) {
	    	  
	    	  CategoryObjektRAM tmp = it.next(); 
	    	  tmp.fillChildren();
	    	  
	    	 
	    	  
	    	  
	    	  
	      }
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
	//}
	
	public static void getAllPersons() {
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Vorname", "Telefon", "Email", "Rolle",  "Stra�e", "Hausnummer", "PLZ", "Ort", "Land"}, 0) {
			
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
			    String g = rs.getString("Stra�e");
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
		
		
	}
	
public static void searchOrder(String search) {
		
		
		
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
		
		
	}

	public static void searchComponent(String search) {
	
	
	
		DefaultTableModel modelComponents = new DefaultTableModel(new String[]{"ID Bauteil", "Name", "Menge lagernd", "Preis"}, 0) {
		
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
	
	String sqlsearch = "SELECT * FROM TBauteil WHERE UPPER(Name) like UPPER('%" + search + "%');";
	
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
			String a1 = rs.getString("ID_TBauteil");
		    String b1 = rs.getString("Name");
		    String c1 = rs.getString("Link");
		    String d1 = rs.getString("MengeLagernd");
		    String e1 = rs.getString("MengeBestellt");
		    String f1 = rs.getString("MengeGeplant");
		    String g1 = rs.getString("Lagerort");
		    String h1 = rs.getString("Preis");
		    
		    modelComponents.addRow(new Object[]{a1, b1,d1,h1});
		   
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	MainMenu.tblComponents.setModel(modelComponents);
//	MainMenu.scrollPane_3.setViewportView(MainMenu.tblComponents);
	TableColumnModel tcm = MainMenu.tblComponents.getColumnModel();
	tcm.removeColumn( tcm.getColumn(0) );
	
	
}
	
	public static void searchBill(String search) {
		
		
		
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

		
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Vorname", "Telefon", "Email", "Rolle",  "Stra�e", "Hausnummer", "PLZ", "Ort", "Land"}, 0) {
			
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
			    String g = rs.getString("Stra�e");
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
	
		
	}
	
	public static void refreshPersonen() {

		
		
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
			    String g = rs.getString("Stra�e");
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
	
		
	}
	
public static void refreshBill2() {
		
		
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

		
		
	}
	
	
	public static void refreshOrder() {

		
		
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
	
		
	}
	
//	public static void refreshOrderBill() {
//
//		
//		
//		DefaultTableModel modelAuftrag = new DefaultTableModel(new String[]{"ID_Auftrag", "Titel", "AF", "Dateiname", "Dateiort", "PK", "RK", "ID_Status", "Rolle"}, 0) {
//			
//			@Override
//			public boolean isCellEditable(int row, int column) {
//					return false;
//				}
//			};
//		
//		Statement stmt = null;
//		try {
//			stmt = DataBase.c.createStatement();
//		} catch (SQLException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//
//		String sql = "SELECT * FROM Auftrag WHERE ID_Rechnung is null;";
//		ResultSet rs = null;
//		try {
//			rs = stmt.executeQuery(sql);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			while(rs.next())
//			{
//				String a1 = rs.getString("ID_Auftrag");
//			    String b1 = rs.getString("Titel");
//			    String c1 = rs.getString("AF");
//			    String d1 = rs.getString("Dateiname");
//			    String e1 = rs.getString("Dateiort");
//			    String f1 = rs.getString("PK");
//			    String g1 = rs.getString("RK");
//			    String h1 = DataBase.getStatusBeiAuftragId(a1);
//			    String j1 = DataBase.getRolleByOrderId(a1);
//			    
//			    modelAuftrag.addRow(new Object[]{a1, b1,c1,d1,e1,f1,g1, h1, j1});
//			   
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		MainMenu.tblAuftraegeRechnung.setModel(modelAuftrag);
//	
//		
//	}
	
	public static void refreshOrdersInBill() {
		
		

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
		
		
	}
	
	
	
	public static void refreshComponent() {

		
		
	DefaultTableModel modelComponents = new DefaultTableModel(new String[]{"ID Bauteil", "Name", "Menge lagernd", "Preis"}, 0) {
			
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

		String sql = "SELECT * FROM TBauteil";
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
				String id = rs.getString("ID_TBauteil");
			    String name = rs.getString("Name");
			    String menge = rs.getString("MengeLagernd");
			    int idBauteil = Integer.parseInt(id);
			    
//			    String h1 =BauteileAuftragsabwicklung.getComponentPrice(idBauteil);
			    double preis = rs.getDouble("Preis");
			    
			    modelComponents.addRow(new Object[]{id, name, menge, preis});
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MainMenu.tblComponents.setModel(modelComponents);
		TableColumnModel tcm = MainMenu.tblComponents.getColumnModel();
		tcm.removeColumn( tcm.getColumn(0) );
		
		
	}
	
	
	public static void refreshComponentCategory() {

		
		
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
	
		
	}
	
	public static void refreshKasse() {

		
		
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
	
		TableColumnModel tcmKasse = MainMenu.tblKasse.getColumnModel();
		tcmKasse.removeColumn( tcmKasse.getColumn(0) );
		tcmKasse.removeColumn( tcmKasse.getColumn(1) );
		
		
		System.out.println("tblKasseRefreshed");
		
	}

	public static void refreshTopf() {

		
		
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
		
		TableColumnModel tcmTopf = MainMenu.tblTopf.getColumnModel();
		tcmTopf.removeColumn( tcmTopf.getColumn(1) );
		
		System.out.println("tblTopfRefreshed");
	
		
	}
	
	
	public static void refreshRechnungB () {
		
		
		DefaultTableModel modelRechnungB = new DefaultTableModel(new String[]{"ID_BRechnung", "Name", "ID_Auftraggeber", "Art_Bezahlung", "Betrag", "Beschreibung", "ID_Bearbeiter", "Timestamp", "ID_Ansprechpartner"}, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		String sqlRechnungB = "SELECT * FROM BRechnung";
			Statement stmt = null;
			
			try {
				stmt = DataBase.c.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		ResultSet rsRechnungB = null;
		try {
			rsRechnungB = stmt.executeQuery(sqlRechnungB);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			while(rsRechnungB.next())
			{
				String a1 = rsRechnungB.getString("ID_BRechnung");
			    String b1 = rsRechnungB.getString("Name");
			    String c1 = rsRechnungB.getString("ID_Auftraggeber");
			    String d1 = rsRechnungB.getString("Art_Bezahlung");
			    String e1 = rsRechnungB.getString("Betrag");
			    String f1 = rsRechnungB.getString("Beschreibung");
			    String g1 = rsRechnungB.getString("ID_Bearbeiter");
			    String h1 = rsRechnungB.getString("Timestamp");
			    String j1 = rsRechnungB.getString("ID_Ansprechpartner");
			    
			    
			    modelRechnungB.addRow(new Object[]{a1, b1,c1, d1, e1, f1, g1, h1, j1});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainMenu.tblRechnB.setModel(modelRechnungB);
		
		TableColumnModel tcmRechnungB = MainMenu.tblRechnB.getColumnModel();
		tcmRechnungB.removeColumn( tcmRechnungB.getColumn(0) );
		tcmRechnungB.removeColumn( tcmRechnungB.getColumn(7) );
		tcmRechnungB.removeColumn( tcmRechnungB.getColumn(5) );
		tcmRechnungB.removeColumn( tcmRechnungB.getColumn(4) );
		tcmRechnungB.removeColumn( tcmRechnungB.getColumn(2) );
		tcmRechnungB.removeColumn( tcmRechnungB.getColumn(1 ) );
	
		
		
		
		
	}
	
	
	public static void refreshRechnungA() {
		
DefaultTableModel modelRechnungA = new DefaultTableModel(new String[]{"ID_ARechnung", "Name", "ID_Auftraggeber","Art_Bezahlung", "Betrag", "Beschreibung", "ID_Bearbeiter", "Timestamp", "ID_Ansprechpartner", "ID_Auftrag"}, 0) {
			
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
		String sqlRechnungA = "SELECT * FROM ARechnung";
		ResultSet rsRechnungA = null;
		try {
			rsRechnungA = stmt.executeQuery(sqlRechnungA);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rsRechnungA.next())
			{
				String a1 = rsRechnungA.getString("ID_ARechnung");
			    String b1 = rsRechnungA.getString("Name");
			    String c1 = rsRechnungA.getString("ID_Auftraggeber");
			    String d1 = rsRechnungA.getString("Art_Bezahlung");
			    String e1 = rsRechnungA.getString("Betrag");
			    String f1 = rsRechnungA.getString("Beschreibung");
			    String g1 = rsRechnungA.getString("ID_Bearbeiter");
			    String h1 = rsRechnungA.getString("Timestamp");
			    String j1 = rsRechnungA.getString("ID_Ansprechpartner");
			    String i1 = rsRechnungA.getString("ID_Auftrag");
			    
			    modelRechnungA.addRow(new Object[]{a1, b1,c1,d1, e1, f1, g1, h1, j1, i1});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainMenu.tblRechnA.setModel(modelRechnungA);
		TableColumnModel tcmRechnungA = MainMenu.tblRechnA.getColumnModel();
		tcmRechnungA.removeColumn( tcmRechnungA.getColumn(0) );
		
		tcmRechnungA.removeColumn( tcmRechnungA.getColumn(4) );
		tcmRechnungA.removeColumn( tcmRechnungA.getColumn(4) );
	
		tcmRechnungA.removeColumn( tcmRechnungA.getColumn(5) );
		tcmRechnungA.removeColumn( tcmRechnungA.getColumn(2) );
		tcmRechnungA.removeColumn( tcmRechnungA.getColumn(4) );
		tcmRechnungA.removeColumn( tcmRechnungA.getColumn(1 ) );
		
		
	}
	
	
	public static void refreshRechn () {
		
		
		DefaultTableModel modelRechnung = new DefaultTableModel(new String[]{"ID_Rechnung", "Rechnungsname",  "Betrag", "Typ", "ID_Topf"}, 0) {
			

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
		String sqlRechnung = "SELECT ID_ARechnung AS ID_Rechnung, Name, Betrag, Typ, ID_Topf, Timestamp FROM ARechnung UNION SELECT ID_BRechnung AS ID_Rechnung, Name, Betrag, Typ, ID_Topf, Timestamp FROM BRechnung";
		ResultSet rsRechnung = null;
		try {
			rsRechnung = stmt.executeQuery(sqlRechnung);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		// 2x 
		
		// Liste = A + B 
		
		// Neue SPalte 
		// Wenn a in liste dann eintrag 'A'
		// Dann B in Liste eintrag B 
		try {
			while(rsRechnung.next())
			{
				String a1 = rsRechnung.getString("ID_Rechnung");
			    String b1 = rsRechnung.getString("Name");
			    String c1 = rsRechnung.getString("Typ");
			    String e1 = rsRechnung.getString("Betrag");
			    String d1 = rsRechnung.getString("ID_Topf");
			    

			   
			    
			    modelRechnung.addRow(new Object[]{a1, b1, e1,  c1, d1});
			    
			    
			    System.out.println("WHILE RECHNUNG LOADING DONE!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainMenu.tblRechn.setModel(modelRechnung);
		
		
		
		TableColumnModel tcmRechn = MainMenu.tblRechn.getColumnModel();
		tcmRechn.removeColumn( tcmRechn.getColumn(4) );
	
		
		System.out.println("tblRechn Refreshed");
		
		
		
		
	}
	public static void refreshCategory() {

		
		
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
	
		
	}

	
	public static void refreshChange() {

		
		
		DefaultTableModel modelOffeneAuftraege = new DefaultTableModel(new String[]{"ID �nderung", "ID Bauteil","ID Person", "Vorname", "Name", "Timestamp", "Aenderung"}, 0) {
			
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
		      String query = "SELECT �nderung.*, Person.name, Person.vorname, Bauteil.* FROM �nderung INNER JOIN Person ON �nderung.ID_Person = Person.ID_Person INNER JOIN Bauteil on �nderung.ID_Bauteil = Bauteil.ID_Bauteil;"; 
		      
		      ResultSet rs = stmt.executeQuery(query);
		      
		      while ( rs.next() ) {
		    	  id_aenderung = rs.getInt("ID_�nderung"); 
		    	  id_bauteil = rs.getInt("ID_Bauteil"); 
		    	  id_person = rs.getInt("ID_Person"); 
		    	  timestamp = rs.getString("timestamp"); 
		    	  aenderung = rs.getInt("�nderung"); 
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
		      String query = "SELECT �nderung.*, Person.name, Person.vorname, Bauteil.* FROM �nderung INNER JOIN Person ON �nderung.ID_Person = Person.ID_Person INNER JOIN Bauteil on �nderung.ID_Bauteil = Bauteil.ID_Bauteil WHERE ID_�nderung like '" + id_aenderung +"';"; 
		      
		      ResultSet rs = stmt.executeQuery(query);
		      
		      while ( rs.next() ) {
		    	  id_aenderung = rs.getInt("ID_�nderung"); 
		    	  id_bauteil = rs.getInt("ID_Bauteil"); 
		    	  id_person = rs.getInt("ID_Person"); 
		    	  timestamp = rs.getString("timestamp"); 
		    	  aenderung = rs.getInt("�nderung"); 
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
		   String query = "SELECT * FROM TBauteil WHERE ID_TBauteil = " + id_bauteil + ";"; 
		   
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
	  
	  
	  public static String pStmt(String name, String vorname) throws SQLException {
			
			
			String selectSQL = "SELECT * FROM Person WHERE Name like ? and Vorname like ?";
			PreparedStatement preparedStatement = c.prepareStatement(selectSQL);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, vorname);
			
			ResultSet rs = preparedStatement.executeQuery();
			String pw = null; 
			while (rs.next()) {
				 pw = rs.getString("Passwort");
				
			}
			return pw; 
		}
	  
	  public static void createNodes(DefaultMutableTreeNode top, int idTop) {
		  	DefaultMutableTreeNode category = null;
		    ArrayList<DefaultMutableTreeNode> categoryNames = new ArrayList<DefaultMutableTreeNode>();
		    
		    Statement stmt = null;
			   
			   try {
			    
				   //Query 
				   String query = "SELECT * FROM TKategorie;"; 
				   
				   // Getting Data from Database
			      stmt = c.createStatement();
			      ResultSet rs = stmt.executeQuery( query );			      
			      
			      while ( rs.next() ) {
			    	  
			    	int id = rs.getInt("ID_TKategorie");
			    	String name = rs.getString("Name");
			    	String parent = rs.getString("ID_Parent");
			    	
			    	if (parent != null) {
			    	CategoryObjektRAM c = new CategoryObjektRAM(id, Integer.parseInt(parent), name);
			    	categories.add(c);
			    	categoryNames.add(category = new DefaultMutableTreeNode(name));
			    	
			    	CategoryObjektRAM parentObject = new CategoryObjektRAM();
			    	
			    		int idParent = c.getIdParent();
			    		for (CategoryObjektRAM cat : categories) {
			    			if (cat.getIdCategory() == idParent) {
			    				parentObject = cat;
			    			}
			    		}
			    		if (parentObject.getIdCategory() == idTop) {
					    top.add(category);
			    		} else {
			    			category.setParent(categoryNames.get(parentObject.getIdCategory()));
			    		}
			    	}
			      }
			      
		    
//		    category = new DefaultMutableTreeNode("Books for Java Programmers");
//		    top.add(category);
//		    
//		    //original Tutorial
//		    book = new DefaultMutableTreeNode(new BookInfo
//		        ("The Java Tutorial: A Short Course on the Basics",
//		        "tutorial.html"));
//		    category.add(book);
//		    
//		    //Tutorial Continued
//		    book = new DefaultMutableTreeNode(new BookInfo
//		        ("The Java Tutorial Continued: The Rest of the JDK",
//		        "tutorialcont.html"));
//		    category.add(book);
//		    
//		    //Swing Tutorial
//		    book = new DefaultMutableTreeNode(new BookInfo
//		        ("The Swing Tutorial: A Guide to Constructing GUIs",
//		        "swingtutorial.html"));
//		    category.add(book);
//
//		    //...add more books for programmers...
//
//		    category = new DefaultMutableTreeNode("Books for Java Implementers");
//		    top.add(category);
//
//		    //VM
//		    book = new DefaultMutableTreeNode(new BookInfo
//		        ("The Java Virtual Machine Specification",
//		         "vm.html"));
//		    category.add(book);
//
//		    //Language Spec
//		    book = new DefaultMutableTreeNode(new BookInfo
//		        ("The Java Language Specification",
//		         "jls.html"));
//		    category.add(book);
	
			   } catch ( Exception e ) {
				      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				      
			}
	  }
	  



	  
	  public static ArrayList<MengenTBauteilObjektRAM> createMTBObjektRAM(int id_BRechnung) throws SQLException {
			
			
			String selectSQL = "SELECT TBauteil.ID_TBauteil as TB , 'Mischtabelle-TBauteil-BRechnung'.Menge as M , TBauteil.MengeLagernd as ML FROM TBauteil JOIN 'Mischtabelle-TBauteil-BRechnung' ON TBauteil.ID_TBauteil = 'Mischtabelle-TBauteil-BRechnung'.ID_TBauteil WHERE ID_BRechnung = ? ;";
			
			PreparedStatement preparedStatement = c.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id_BRechnung);

			
			ResultSet rs = preparedStatement.executeQuery();
			
			ArrayList<MengenTBauteilObjektRAM> list = new ArrayList<MengenTBauteilObjektRAM>(); 
			
			while (rs.next()) {
				//int id_TBauteil, int menge, int mengeLagernd
				MengenTBauteilObjektRAM tmp = new MengenTBauteilObjektRAM(rs.getInt("TB"), rs.getInt("M"), rs.getInt("ML"));
				list.add(tmp); 
				
				
			}
			return list; 
		}
	  
	  public static ArrayList<Integer> getIDParents(int id_TKategorie) throws SQLException {
			
		  
			
		    String query = "Select ID_TKategorie as T FROM TKategorie WHERE ID_Parent = ?; "; 
			
			PreparedStatement preparedStatement = c.prepareStatement(query);
			preparedStatement.setInt(1, id_TKategorie);

			
			ResultSet rs = preparedStatement.executeQuery();
			
			ArrayList<Integer> list = new ArrayList<Integer>(); 
			
			while (rs.next()) {
				
				list.add(rs.getInt("T")); // int -> Integer ? 
								
			}
			
			return list; 
			
		}


	  public static void showComponentsOfCategory(int idCategory) {
		  
			
			DefaultTableModel modelComponents = new DefaultTableModel(new String[]{"ID Bauteil", "Name", "Menge lagernd", "Preis"}, 0) {
				
				@Override
				public boolean isCellEditable(int row, int column) {
						return false;
					}
				};	
							
			Statement stmt = null;
			try {
				
			
				stmt = DataBase.c.createStatement();
			 String query = "SELECT * FROM TBauteil WHERE ID_TKategorie = " + idCategory + ";"; 
		      ResultSet rs = stmt.executeQuery( query );	
			
			
				rs = stmt.executeQuery(query);
			
			
			
			
				while(rs.next())
				{
					int idBauteil = rs.getInt("ID_TBauteil");
				    String name = rs.getString("Name");
				    String link = rs.getString("Link");
				    int stock = rs.getInt("MengeLagernd");
				    int ordered = rs.getInt("MengeBestellt");
				    int planned = rs.getInt("MengeGeplant");
				    String storage = rs.getString("Lagerort");
				    int category = rs.getInt("ID_TKategorie");
				    double preis = rs.getDouble("Preis");
				    
				    modelComponents.addRow(new Object[]{idBauteil, name,stock,preis});
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MainMenu.tblComponents.setModel(modelComponents);
			MainMenu.scrollPaneComponent.setViewportView(MainMenu.tblComponents);
			TableColumnModel tcmComponents = MainMenu.tblComponents.getColumnModel();
			tcmComponents.removeColumn( tcmComponents.getColumn(0) );
	  }
	  
	  
	  //---
	  
	  
	  
	  public static DefaultTableModel loadToARechnungObjektRAM(int id_ARechnung) throws SQLException {
	  
	  
		  DefaultTableModel model = new DefaultTableModel(new String[]{"Name","Art der Bezahlung", "Betrag", "Beschreibung", "Timestamp", "Typ"}, 0);
		    	String query = "Select * FROM ARechnung WHERE ID_ARechnung = " + id_ARechnung + ";"; 
			
		
		       Statement  stmt = c.createStatement();
		        stmt = c.createStatement();
			      ResultSet rs = stmt.executeQuery( query );			      
			      
				
				ARechnungObjektRAM tmp = null; 
					
				
				while (rs.next()) {

					
					 tmp = new ARechnungObjektRAM (rs.getInt("ID_ARechnung"), rs.getString("Name"), rs.getInt("ID_Auftraggeber"), rs.getInt("ID_Ansprechpartner"), rs.getString("Art_Bezahlung"), rs.getFloat("Betrag"),
							rs.getString("Beschreibung"), rs.getInt("ID_Bearbeiter"), rs.getString("Timestamp"), rs.getInt("ID_Auftrag"), rs.getInt("ID_Topf"), rs.getString("Typ")); 
					model.addRow(new Object[]{tmp.getName(), tmp.getArt_Bezahlung(), tmp.getBetrag(), tmp.getBeschreibung(), tmp.getTimestamp(), tmp.getTyp()});		
				}
	  	  
		return model;
				  
	  }
	  
	  public static DefaultTableModel loadToAuftragObjektRAM(int id_ARechnung) throws SQLException {
		  
		  
		  DefaultTableModel model = new DefaultTableModel(new String[]{"Titel","Art der Fertigung"}, 0);
		    	String query = "SELECT * FROM Auftrag WHERE ID_ARechnung = " + id_ARechnung + ";"; 
			
		
		       Statement  stmt = c.createStatement();
		        stmt = c.createStatement();
			      ResultSet rs = stmt.executeQuery( query );			      
			      
				
				ARechnungObjektRAM tmp = null; 
					
				
				while (rs.next()) {

					model.addRow(new Object[]{rs.getString("Titel"), rs.getString("AF")});		
				}
	  	  
		return model;
				  
	  }
	  
	  public static DefaultTableModel loadToBRechnungObjektRAM(int id_BRechnung) throws SQLException {
		  
		  
		  DefaultTableModel model = new DefaultTableModel(new String[]{"Name","Art der Bezahlung", "Betrag", "Beschreibung", "Timestamp", "Typ"}, 0);
		    	String query = "Select * FROM BRechnung WHERE ID_BRechnung = " + id_BRechnung + ";"; 
			
		
		       Statement  stmt = c.createStatement();
		        stmt = c.createStatement();
			      ResultSet rs = stmt.executeQuery( query );			      
			      
			
					
				
				while (rs.next()) {

					model.addRow(new Object[]{rs.getString("Name"), rs.getString("Art_Bezahlung"), rs.getFloat("Betrag"), rs.getString("Beschreibung"), rs.getString("Timestamp"), rs.getString("Typ")});		
				}
	  	  
		return model;
				  
	  }
	  
	  public static DefaultTableModel loadToBauteileObjektRAM(int id_BRechnung) throws SQLException {
		  
		  
		  DefaultTableModel model = new DefaultTableModel(new String[]{"Name","Menge", "Einzelpreis"}, 0);
		    	String query = "Select TBauteil.Name as name, 'Mischtabelle-TBauteil-BRechnung'.Menge as menge , TBauteil.Preis as preis FROM TBauteil LEFT JOIN 'Mischtabelle-TBauteil-BRechnung' ON TBauteil.ID_TBauteil = 'Mischtabelle-TBauteil-BRechnung'.ID_TBauteil WHERE ID_BRechnung = " + id_BRechnung + ";"; 
			
		
		       Statement  stmt = c.createStatement();
		        stmt = c.createStatement();
			      ResultSet rs = stmt.executeQuery( query );			      
			      
			
					
				
				while (rs.next()) {

					model.addRow(new Object[]{rs.getString("name"), rs.getInt("menge"), rs.getFloat("preis")});		
				}
	  	  
		return model;
				  
	  }
		  
	  
}