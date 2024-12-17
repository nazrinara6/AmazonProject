package amazon_source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DDT
{
	public static WebDriver driver;
	
	//step 1	
	@FindBy(id = "ap_email")
	WebElement un;
	
	@FindBy(id = "continue")
	WebElement continue_email;
	
	@FindBy(name = "password")
	WebElement pwd;
	
	@FindBy(id = "signInSubmit")
	WebElement signIn_to_Amazon;
	
	//step 2
	public void email()
	{
		un.sendKeys(username);
	}
	public void continue_un()
	{
		continue_email.click();
	}
	public void pass()
	{
		pwd.sendKeys(password_valid);
	}
	public void sign_in_to_amazon()
	{
		signIn_to_Amazon.click();
	}
	public void pass_incorrect()
	{
		pwd.sendKeys(password_invalid);
	}
		
	//step 3
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


}
