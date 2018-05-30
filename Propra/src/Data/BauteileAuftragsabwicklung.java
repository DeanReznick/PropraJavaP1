package Data;

public class BauteileAuftragsabwicklung {

	
	public static void main(String[] args) {

		loadOffeneAuftraege(); 
		
	}

	
	
	public static void loadOffeneAuftraege() {
		
		DataBase.getConnection();
		
		DataBase.loadOffeneAuftraegeToRam();
		
		System.out.println(DataBase.offeneAuftraege.toString()); 
		
		DataBase.closeConnection();
		
		
			
	}
}
