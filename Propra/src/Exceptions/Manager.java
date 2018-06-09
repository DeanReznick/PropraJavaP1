package Exceptions;

import java.awt.Color;

//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;

import Data.DataBase;
import GUI.AddPerson;
import GUI.Aendern;
import GUI.NewOrder;
import GUI.UpdateOrder;

public class Manager {

	public static void checkStandard(String forename, String name, String mail, String street, int plz, String city, String country, String houseNumber, String phone) throws InvalidArgumentsException
	{
		if (name.length() == 0 || forename.length() == 0 || country.length() == 0 || plz == 0 || street.length() == 0 || houseNumber.length() == 0 || city.length() == 0) {
			AddPerson.txtName.setBackground(Color.RED);
			AddPerson.txtVorname.setBackground(Color.RED);
			AddPerson.txtLand.setBackground(Color.RED);
			AddPerson.txtPlz.setBackground(Color.RED);
			AddPerson.txtStr.setBackground(Color.RED);
			AddPerson.txtHaus.setBackground(Color.RED);
			AddPerson.txtOrt.setBackground(Color.RED);
			throw new InvalidArgumentsException("Please fill in all values.");
		}
		if (name.length() < 2) {
			AddPerson.txtName.setBackground(Color.RED);
			throw new InvalidArgumentsException("name " + name + " to short!");
		}
		if (forename.length() < 2) {
			AddPerson.txtVorname.setBackground(Color.RED);
			throw new InvalidArgumentsException("forename " + forename + " to short!");
		}
		if (street.length() < 3) {
			AddPerson.txtStr.setBackground(Color.RED);
			throw new InvalidArgumentsException("Street name to short! Please check your input: " + street);
		}
//		if (isValidEmailAddress(mail)) {
//			AddPerson.txtMail.setBackground(Color.RED);
//			throw new InvalidArgumentsException("not an email: " + mail + ". Please insert a valid email address.");
//		}
		if (plz < 0) {
			AddPerson.txtPlz.setBackground(Color.RED);
			throw new InvalidArgumentsException("Please insert a valid PLZ");
		}
		if (city.length() < 2) {
			AddPerson.txtOrt.setBackground(Color.RED);
			throw new InvalidArgumentsException("Name of the city is too short: " + city);
		}
		if (phone.length() == 0 && mail.length() == 0) {
			AddPerson.txtTel.setBackground(Color.RED);
			AddPerson.txtMail.setBackground(Color.RED);
			throw new InvalidArgumentsException("Please fill in a phone number or an email address.");
		}
	}
	
	/*public static boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}*/
	
	
	public static boolean personExists(String name, String surname) {
		boolean result = true; 
		int id = DataBase.getIdPersonByNameSurname(name, surname);
		if(id==0) { result = false;}
		
		return result;
	}
	
	public static void checkAendernStandard(String forename, String name, String mail, String street, int plz, String city, String country, String houseNumber, String phone) throws InvalidArgumentsException
	{
		if (name.length() == 0 || forename.length() == 0 || country.length() == 0 || plz == 0 || street.length() == 0 || houseNumber.length() == 0 || city.length() == 0) {
			Aendern.txtName.setBackground(Color.RED);
			Aendern.txtVorname.setBackground(Color.RED);
			Aendern.txtLand.setBackground(Color.RED);
			Aendern.txtPlz.setBackground(Color.RED);
			Aendern.txtStr.setBackground(Color.RED);
			Aendern.txtHaus.setBackground(Color.RED);
			Aendern.txtOrt.setBackground(Color.RED);
			throw new InvalidArgumentsException("Please fill in all values.");
		}
		if (name.length() < 2) {
			Aendern.txtName.setBackground(Color.RED);
			throw new InvalidArgumentsException("name " + name + " to short!");
		}
		if (forename.length() < 2) {
			Aendern.txtVorname.setBackground(Color.RED);
			throw new InvalidArgumentsException("forename " + forename + " to short!");
		}
		if (street.length() < 3) {
			Aendern.txtStr.setBackground(Color.RED);
			throw new InvalidArgumentsException("Street name to short! Please check your input: " + street);
		}
		if (plz < 0) {
			Aendern.txtPlz.setBackground(Color.RED);
			throw new InvalidArgumentsException("Please insert a valid PLZ");
		}
		if (city.length() < 2) {
			Aendern.txtOrt.setBackground(Color.RED);
			throw new InvalidArgumentsException("Name of the city is too short: " + city);
		}
		if (phone.length() == 0 && mail.length() == 0) {
			Aendern.txtTel.setBackground(Color.RED);
			Aendern.txtMail.setBackground(Color.RED);
			throw new InvalidArgumentsException("Please fill in a phone number or an email address.");
		}
	}
	
	
	public static void checkStandardOrder(String header, String af, String filename, String repository, String pk, String rk, String name, String surname, String job) throws InvalidArgumentsException
	{
		if (header.length() == 0 || af.length() == 0 || filename.length() == 0 || repository.length() == 0 || pk.length() == 0 || rk.length() == 0 || name.length() == 0 || surname.length() == 0 || job.length() == 0) {
			NewOrder.txtHeader.setBackground(Color.RED);
			NewOrder.txtAf.setBackground(Color.RED);
			NewOrder.txtFilename.setBackground(Color.RED);
			NewOrder.txtRepository.setBackground(Color.RED);
			NewOrder.txtPk.setBackground(Color.RED);
			NewOrder.txtRk.setBackground(Color.RED);
			NewOrder.txtName.setBackground(Color.RED);
			NewOrder.txtSurname.setBackground(Color.RED);
			NewOrder.txtJob.setBackground(Color.RED);
		
			throw new InvalidArgumentsException("Please fill in all values.");
		}
		if (header.length() < 2) {
			NewOrder.txtHeader.setBackground(Color.RED);
			throw new InvalidArgumentsException("Header " + header + " to short!");
		}
		
		
		
		DataBase.getConnection();
		int id = -1;
	    id = DataBase.getIdPersonByNameSurname(name, surname);
		
		
		if(id == -1) {
			NewOrder.txtName.setBackground(Color.RED);
			NewOrder.txtSurname.setBackground(Color.RED);
			throw new InvalidArgumentsException("Person not found!!!");
			
			
		}
		
		
	}
	
	public static void checkStandardOrderUpdate(String header, String af, String filename, String repository, String pk, String rk) throws InvalidArgumentsException
	{
		if (header.length() == 0 || af.length() == 0 || filename.length() == 0 || repository.length() == 0 || pk.length() == 0 || rk.length() == 0) {
			UpdateOrder.txtHeader.setBackground(Color.RED);
			UpdateOrder.txtAf.setBackground(Color.RED);
			UpdateOrder.txtFilename.setBackground(Color.RED);
			UpdateOrder.txtRepository.setBackground(Color.RED);
			UpdateOrder.txtPk.setBackground(Color.RED);
			UpdateOrder.txtRk.setBackground(Color.RED);
			
		
			throw new InvalidArgumentsException("Please fill in all values.");
		}
		
		
		
		
		
		
		
	}
	
	
}
