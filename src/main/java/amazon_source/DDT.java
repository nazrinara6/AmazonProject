package amazon_source;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class DDT 
{
	public static String username, password_valid, password_invalid, your_name, mobile, password_signup, your_name2, state, street_name, city_name, pinCode, mobile2, searchItem, searchItem2, card_cvv,card_number,card_name;
  
	public void ddt_login() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\ROG\\eclipse-workspace\\Project_Amazon\\DDT\\AmazonSheet.xlsx");
		Workbook w1 = WorkbookFactory.create(f1);
	    username = NumberToTextConverter.toText(w1.getSheet("Login").getRow(1).getCell(0).getNumericCellValue());
	    password_valid = w1.getSheet("Login").getRow(1).getCell(1).getStringCellValue();
	    password_invalid = w1.getSheet("Login").getRow(1).getCell(2).getStringCellValue();
	}
	
	public void ddt_signup() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\ROG\\eclipse-workspace\\Project_Amazon\\DDT\\AmazonSheet.xlsx");
		Workbook w1 = WorkbookFactory.create(f1);   
	    your_name = w1.getSheet("Signup").getRow(1).getCell(0).getStringCellValue();
	    mobile = NumberToTextConverter.toText(w1.getSheet("Signup").getRow(1).getCell(1).getNumericCellValue());
	    password_signup = w1.getSheet("Signup").getRow(1).getCell(2).getStringCellValue();
	}
	
	public void ddt_addressInfo() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\ROG\\eclipse-workspace\\Project_Amazon\\DDT\\AmazonSheet.xlsx");
		Workbook w1 = WorkbookFactory.create(f1);   
	    your_name2 = w1.getSheet("Address").getRow(1).getCell(0).getStringCellValue();
	    street_name = w1.getSheet("Address").getRow(1).getCell(1).getStringCellValue();
	    city_name = w1.getSheet("Address").getRow(1).getCell(2).getStringCellValue();
	    state = w1.getSheet("Address").getRow(1).getCell(3).getStringCellValue();
	    pinCode = NumberToTextConverter.toText(w1.getSheet("Address").getRow(1).getCell(4).getNumericCellValue());
	    mobile2 = NumberToTextConverter.toText(w1.getSheet("Address").getRow(1).getCell(5).getNumericCellValue());
	}
	
	public void ddt_search() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\ROG\\eclipse-workspace\\Project_Amazon\\DDT\\AmazonSheet.xlsx");
		Workbook w1 = WorkbookFactory.create(f1);   
	    searchItem = w1.getSheet("Search").getRow(1).getCell(0).getStringCellValue();
	    searchItem2 = w1.getSheet("Search").getRow(2).getCell(0).getStringCellValue();
	}
	
	public void ddt_cardInfo() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\ROG\\eclipse-workspace\\Project_Amazon\\DDT\\AmazonSheet.xlsx");
		Workbook w1 = WorkbookFactory.create(f1);   
	    card_cvv = NumberToTextConverter.toText(w1.getSheet("CardDetails").getRow(1).getCell(0).getNumericCellValue());
	    card_number = NumberToTextConverter.toText(w1.getSheet("CardDetails").getRow(1).getCell(1).getNumericCellValue());
	    card_name =  w1.getSheet("CardDetails").getRow(1).getCell(2).getStringCellValue();
	}
	
}
