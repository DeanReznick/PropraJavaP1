package Data;

public class TreeBauteile {

	/*public static void main(String[] args) {
		// ID_TKategorie, Name, Link, MengeLagernd, MengeBestellt, MengeGeplant, Lagerort, Preis
		
		//addTBauteil("Feder", "/feder", 10, 1, 100, "ORT A", 100); 
		//alterTBauteil(1,1,"Feder groß", "/feder", 10, 1, 100, "ORT A", 100); 
		//delteTBauteil(1); 
		//addTKat("Kat1"); 

		//alterTKat(2,2,"KAT A"); 
		//delteTKat(3); 
	}*/

	public static void addTKat(int id_Parent, String name) {
		
		DataBase.getConnection();
		
		String query = "INSERT INTO TKategorie (ID_Parent, Name) VALUES ("+
						 id_Parent + ", '" + name +"');"; 
		
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
		
	}
		
	public static void addTKat(String name) {
		
		DataBase.getConnection();
		
		String query = "INSERT INTO TKategorie (ID_Parent, Name) VALUES ("+
						 "1, '" + name +"');"; 
		
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
	}
		public static void alterTKat(int id_TKat, int id_Parent, String name) {
		DataBase.getConnection();
		//prüfen ob es die neue Parent Kat gibt! Dropdown? 
		String query = "UPDATE TKategorie SET Name = '" + name + "', ID_Parent = "+ id_Parent +" WHERE ID_TKategorie = "+ id_TKat +";";  
		DataBase.executeQuery(query); 
		DataBase.closeConnection();
		
	}
	public static void delteTKat(int id_TKat) {
		DataBase.getConnection();
		
		String query = "UPDATE TBauteil SET ID_TKategorie = (Select ID_Parent FROM TKategorie WHERE ID_TKategorie = "+id_TKat +") WHERE ID_TKategorie = "+ id_TKat +";";
		DataBase.executeQuery(query);
		
		
		 query = "DELETE FROM TKategorie WHERE ID_TKategorie = " + id_TKat +";"; 
		DataBase.executeQuery(query);
		
		//UPDATE TBauteil SET ID_TKategorie = (Select ID_Parent FROM TKategorie WHERE ID_TKategorie = 4) WHERE ID_TKategorie = 4; 
		
		// Alle die dran hängen...
			
		DataBase.closeConnection();
	}
	
	//Bauteil
	public static void addTBauteil(int id_TKat, String name, String link, int mengeLagernd, int mengeBestellt, int mengeGeplant, String lagerort, float preis) {
		DataBase.getConnection();
		
		String query = "INSERT INTO TBauteil (ID_TKategorie, Name, Link, MengeLagernd, MengeBestellt, MengeGeplant, Lagerort, Preis) VALUES ("+
						id_TKat +",'"+ name + "','" + link +"', "+ mengeLagernd +", " + mengeBestellt +", " + mengeGeplant + ",'" + lagerort + "',"+ preis +");"; 
		
		DataBase.executeQuery(query);
		DataBase.closeConnection();
	}
	
	public static void addTBauteil( String name, String link, int mengeLagernd, int mengeBestellt, int mengeGeplant, String lagerort, float preis) {
		DataBase.getConnection();
		// Wird die id_Kat nicht explizit angegeben. Wird der Default 1 gesetzt. 
		String query = "INSERT INTO TBauteil (ID_TKategorie, Name, Link, MengeLagernd, MengeBestellt, MengeGeplant, Lagerort, Preis) VALUES ("+
						"1,'"+ name + "','" + link +"', "+ mengeLagernd +", " + mengeBestellt +", " + mengeGeplant + ",'" + lagerort + "',"+ preis +");"; 
		
		DataBase.executeQuery(query);
	    DataBase.closeConnection();
	}
		
	public static void alterTBauteil(int id_TBauteil, int id_TKat, String name, String link, int mengeLagernd, int mengeBestellt, int mengeGeplant, String lagerort, float preis) {
		DataBase.getConnection();
		// ID_TKategorie, Name, Link, MengeLagernd, MengeBestellt, MengeGeplant, Lagerort, Preis
		String query = "UPDATE TBauteil SET ID_TKategorie = " + id_TKat + ", name = '" + name +"', link = '" + link +"', mengeLagernd = "
				+ mengeLagernd +", MengeBestellt = " + mengeBestellt + ", MengeGeplant = " + mengeGeplant +", Lagerort ='" + lagerort + "', Preis =" + preis 
				+ " WHERE ID_TBauteil = "+ id_TBauteil +";";  
		DataBase.executeQuery(query);
		
		DataBase.closeConnection();
	}
	public static void delteTBauteil(int id_TBauteil) {
		DataBase.getConnection();
		
		String query = "DELETE FROM TBauteil WHERE ID_TBauteil = " + id_TBauteil +";"; 
		DataBase.executeQuery(query);
		DataBase.closeConnection();
		
	}
	

	
}
