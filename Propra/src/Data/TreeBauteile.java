package Data;

public class TreeBauteile {

	public static void main(String[] args) {
		// ID_TKategorie, Name, Link, MengeLagernd, MengeBestellt, MengeGeplant, Lagerort, Preis
		
		//addTBauteil("Feder", "/feder", 10, 1, 100, "ORT A", 100); 
		//alterTBauteil(1,1,"Feder groﬂ", "/feder", 10, 1, 100, "ORT A", 100); 
		delteTBauteil(1); 
		
		
		
	}

	public static void addTKat() {
		
	}
		
	public static void alterTKat() {
		DataBase.getConnection();
		// Alle die dran h‰ngen... 
		
		
		DataBase.closeConnection();
	}
	public static void delteTKat() {
		DataBase.getConnection();
		
		
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
