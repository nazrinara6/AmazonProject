package amazon_test;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import amazon_source.Listener_Implementation;

@Listeners(amazon_source.Listener_Implementation.class)

public class LaunchQuit extends Listener_Implementation
{
	@BeforeMethod
	public void launch()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}

}
