package amazon_source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage
{
	public static WebDriver driver;
	
	//step 1
	@FindBy(xpath = "(//div[@class='a-box ya-card--rich'])[4]")
	WebElement yourAddress;
	
	@FindBy(xpath = "//div[@class='a-column a-span4 a-spacing-none a-spacing-top-mini address-column'][1]")
	WebElement addAddress;
	
	//step 2 
	public void your_address()
	{
		yourAddress.click();	
	}
	public void add_address()
	{
		addAddress.click();	
	}
	
	//step 3
	public YourAccountPage(WebDriver driver)  
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
/*	List<WebElement> li =driver.findElements(By.xpath("(//div[@class='a-container']/div/ul)[2]"));
	int count = li.size();
	System.out.println(count);
	Thread.sleep(2000);
	
	for(int i=0;i<count;i++)
	{
		WebElement e2 = li.get(i);
		String s1 = e2.getText();
		System.out.println(s1);
	}
*/
}
