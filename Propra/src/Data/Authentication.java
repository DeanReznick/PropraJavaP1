package Data;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class Authentication {

  public static String salt = "PROPRA";
  
  public static String sha256(String pw) {
      try{
          MessageDigest digest = MessageDigest.getInstance("SHA-256");
          byte[] hash = digest.digest((pw+salt).getBytes("UTF-8"));
          StringBuffer hexString = new StringBuffer();

          for (int i = 0; i < hash.length; i++) {
              String hex = Integer.toHexString(0xff & hash[i]);
              if(hex.length() == 1) hexString.append('0');
              hexString.append(hex);
          }

          return hexString.toString();
      } catch(Exception ex){
         throw new RuntimeException(ex);
      }
  }
  
  
  
  public static boolean checkCredentials(String name, String surname, String password) {
	DataBase.getConnection(); 
	
	if(!(DataBase.getRolleByIDPerson(DataBase.getIdPersonByNameSurname(name, surname)).equals("Intern"))){
		return false; 
	}
	  
    String query ="SELECT Passwort FROM Person WHERE name like '" + name + "' and vorname like '" + surname +"';";
    if(sha256(password).equals(DataBase.getPassword(query))){
    	DataBase.closeConnection();
      return true;
    }else {
    	DataBase.closeConnection();
      return false; 
    }
   
  }
  
}
