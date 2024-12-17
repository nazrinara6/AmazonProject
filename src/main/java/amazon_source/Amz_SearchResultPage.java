package amazon_source;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Amz_SearchResultPage 
{
	WebDriver driver;
	//1
	
	@FindBy(xpath="//span[@class='a-color-state a-text-bold']")
	WebElement resultOnTop;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement search;
	
	@FindBy(partialLinkText="Women")
	WebElement womenshoes;
	
	@FindBy(tagName="h2")
	List <WebElement> listofwomenshoe;
	
	@FindBy(xpath="//div[@id='departments']/ul/span/span/li")
	List <WebElement> category;
	
	@FindBy(xpath="//input[@id='p_36/range-slider_slider-item_upper-bound-slider']")
	WebElement upperpriceslider;
	
	@FindBy(xpath="//input[@id='p_36/range-slider_slider-item_lower-bound-slider']")
	WebElement lowerpriceslider;
	
	@FindBy(xpath="//div[@class='a-section sf-submit-range-button']")
	WebElement pricegobutton;
	
	@FindBy(xpath="//div[@id='p_36/range-slider_slider-item']")
	WebElement slider;

	
	@FindBy(xpath="//input[@aria-valuetext='₹3,900']")
	WebElement targetprice;
	
	@FindBy(xpath="//span[.='Customer Review']")
	WebElement custrev;
	
	@FindBy(xpath="div[@class='a-section s-range-input-container s-upper-bound']")
	WebElement slider1;
	
	@FindBy(xpath="//span[.='Price']")
	WebElement pricetitle;
	
	@FindBy(xpath="//label[@for='p_36/range-slider_slider-item_lower-bound-slider']")
	WebElement lowerprice;
	
	@FindBy(xpath="//span[@class='a-price-whole']")
	List <WebElement> afterpricerangefilter;
	
	@FindBy(xpath="//select[@name='s']")
	WebElement sortbydropdown;
	
	@FindBy(xpath="//h2/a")
	List<WebElement> productsearch1;
	
	@FindBy(xpath="//span[@class='a-price-whole']")
	List<WebElement> sortprice;
	
	@FindBy(xpath="(//span[@class='a-price-whole'])[1]")
	WebElement pricedisplay1;
	
	@FindBy(id="add-to-cart-button")
	WebElement addtocartbutton;
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement textlist;
	

	int numberofwomenshoesearch;
	WebElement selectedproductcategory;
	String selectedproductcategoryText;
	String productsearch="shoe";
	String categoryproductsearch="Women";
	String resultonamazontop;
	String finalstartprice;
	int pricelastnumber;
	int pricefirstnumber;
	
	public void searchProduct()
	{
		search.sendKeys(productsearch); 
		search.sendKeys(Keys.ENTER);
		
	}
	
	public void searchtheproduct() throws InterruptedException
	{
     String resultontoptext=resultOnTop.getText();
     int a=resultontoptext.length();
     resultonamazontop="";
     char [] d=resultontoptext.toCharArray();
     System.out.println(Arrays.toString(d));
     for(int i=0;i<a;i++)
     {
     if(Character.isAlphabetic(d[i])==true)
     {
    	 resultonamazontop=resultonamazontop+resultontoptext.charAt(i);
     }
     }
     System.out.println(resultonamazontop);
     System.out.println(a);
     System.out.println("The text in results is "+resultontoptext);
    
     Assert.assertEquals(resultonamazontop,productsearch,"Test case failed-Search is incorrect");
     System.out.println("Test Case 5 Passed: Search is giving correct result");
     Reporter.log("Test Case 5 Passed: Search is giving correct result");
   
	}
	public void usingCategoryFilter(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='departments']/ul/span/span/li")));
		int countincategory=category.size();
		System.out.println(countincategory);
	
		for(int i=0;i<countincategory;i++)
		{
			WebElement w1=category.get(i);
			String categorytext=w1.getText();
			System.out.println(categorytext);
			if(categorytext.contains(categoryproductsearch)==true)
			{
				selectedproductcategory=w1;
			}	
		}
		
		selectedproductcategoryText=selectedproductcategory.getText();
		selectedproductcategory.click();
		
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("h2")));
		int countproduct=listofwomenshoe.size();
		for(int j=0;j<countproduct;j++)
		{
			WebElement w2=listofwomenshoe.get(j);
			String womenshoetext=w2.getText();
			System.out.println(womenshoetext);
		if(womenshoetext.contains(categoryproductsearch)==true)
			{
			numberofwomenshoesearch=numberofwomenshoesearch+1;
			}	
		}
		
		System.out.println("There are around "+ numberofwomenshoesearch+ " searches found for "+categoryproductsearch+" "+productsearch );
		if(numberofwomenshoesearch>10)
		{
			Assert.assertTrue(true);
			Reporter.log("Test 6 Category passed-Category search resulted in around "+numberofwomenshoesearch+" searches based on category "+ selectedproductcategoryText);
			System.out.println("Test 6 Category passed-Category search resulted in around "+numberofwomenshoesearch+" searches based on category "+selectedproductcategoryText);
		}
		else
		{
			Assert.fail("Test Case 6 Fail-Category search failed");
		}
	}
	
	public void pricerangefilter(WebDriver driver,String finalstartprice) throws AWTException, InterruptedException
	{
		Point p1=custrev.getLocation();
		int x=p1.getX();
		int y=p1.getY();
		
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,"+(y)+")");
	String startprice=lowerprice.getText();
	System.out.println(startprice);
	Actions a1=new Actions(driver);	
	//a1.clickAndHold(lowerpriceslider).moveToLocation(114,178).release().perform();
	a1.doubleClick(pricetitle).perform();
	Robot r1=new Robot();
	r1.keyPress(KeyEvent.VK_TAB);
	for(int i=0;i<=100;i++)
	{
		Thread.sleep(100);
		r1.keyPress(KeyEvent.VK_RIGHT);
	}
	finalstartprice=lowerprice.getText();

	this.finalstartprice=finalstartprice;
	pricegobutton.click();
	}
	public void pricefilterresult()
	{System.out.println(finalstartprice);
	String finalstartprice1="";
	for(int i=0;i<finalstartprice.length();i++)
	{
		char c=finalstartprice.charAt(i);
		if(Character.isDigit(c)==true)
		{
			finalstartprice1=finalstartprice1+c;
		}
	}
	System.out.println("The finalstartprice1 is "+ finalstartprice1);
	int finalstartpricenumber=Integer.parseInt(finalstartprice1);
		
	int countinprice=afterpricerangefilter.size();
		System.out.println(afterpricerangefilter);
		System.out.println("the count of all the prices on the page= "+countinprice);
	int count=0;
		for(int i=0;i<countinprice;i++)
		{
			WebElement w1=afterpricerangefilter.get(i);
			String pricetext=w1.getText();
			String pricetext1=pricetext.replaceAll(",","");
			System.out.println(pricetext1);
			int pricenumber=Integer.parseInt(pricetext1);
			if(pricenumber>=finalstartpricenumber)
			{
				count++;
			}
		}
		System.out.println("There are "+countinprice+" prices shown on the webpage.Out of which "+count+" meet the price range criteria of "+ ">"+finalstartpricenumber);
		Assert.assertEquals(countinprice, count,"Test Case 6 failed");
		Reporter.log("Test Case 6 Passed-The price slider is giving accurate results");
		System.out.println("Test Case 6 Passed-The price slider is giving accurate results");
		}
	public void sortLowtoHigh(WebDriver driver) throws AWTException, InterruptedException
	{
		/*Thread.sleep(5000);
		int countofprice=productsearch1.size();
		System.out.println("Number of all prices before sort "+countofprice);
		System.out.println("PRICES BEFORE SORTING LOW TO HIGH");
		for(int i=0;i<countofprice;i++)
		{
		WebElement w1=productsearch1.get(i);
		String pricetext=w1.getText();
		System.out.println(pricetext);
		}*/
	
		Select s1=new Select(sortbydropdown);
		s1.selectByVisibleText("Price: Low to High");
		Robot r1=new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='a-price-whole']")));
		
		Thread.sleep(3000);
		int countofpriceaftersort=sortprice.size();
		Thread.sleep(5000);
		int productcount=productsearch1.size();
		System.out.println("Number of prices after sort "+countofpriceaftersort);
		
			WebElement w1=productsearch1.get(0);
			w1.click();
			Set<String> s3=driver.getWindowHandles();
			Iterator<String> i1=s3.iterator();
			String parentid=i1.next();
			String childid=i1.next();
			driver.switchTo().window(childid);
			String pricefirst=pricedisplay1.getText();
			pricefirstnumber=Integer.parseInt(pricefirst);
			System.out.println("Price of first item "+pricefirstnumber);
			driver.close();
			driver.switchTo().window(parentid);
			
			WebElement wlast=productsearch1.get(productcount-1);
			wlast.click();
			Set<String> s4=driver.getWindowHandles();
			Iterator<String> i2=s4.iterator();
			String parentid1=i2.next();
			String childid1=i2.next();
			driver.switchTo().window(childid1);
			String pricelast=pricedisplay1.getText();
			pricelastnumber=Integer.parseInt(pricelast);
			System.out.println("Price of last item "+pricelastnumber);
			driver.close();
			driver.switchTo().window(parentid);
			if(pricelastnumber>pricefirstnumber)
			{
				Assert.assertTrue(true, "Test case 8 failed");
				System.out.println("TestCase 8 passed- Sorting low to high successful");
				Reporter.log("TestCase 8 passed- Sorting low to high successful");
			}
			else {
				Assert.fail("TestCase 8 failed-Sorting low to high unsuccessful");
			}
		}
			
	
		/*for(int i=0;i<countofpriceaftersort;i++)
		{
		WebElement w2=sortprice.get(i);
		String pricetext1=w2.getText();
		System.out.println(pricetext1);
		}*/
				
	public void sortHightolLow(WebDriver driver) throws AWTException, InterruptedException
	{
		Select s1=new Select(sortbydropdown);
		s1.selectByVisibleText("Price: High to Low");
		Robot r1=new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='a-price-whole']")));
		
		Thread.sleep(3000);
		int countofpriceaftersort=sortprice.size();
		Thread.sleep(5000);
		int productcount=productsearch1.size();
		System.out.println("Number of prices after sort "+countofpriceaftersort);
		
			WebElement w1=productsearch1.get(0);
			w1.click();
			Set<String> s3=driver.getWindowHandles();
			Iterator<String> i1=s3.iterator();
			String parentid=i1.next();
			String childid=i1.next();
			driver.switchTo().window(childid);
			String pricefirst=pricedisplay1.getText();
			String pricefirstfinal="";
			for(int i=0;i<pricefirst.length();i++)// This logic is removing comma from the price
			{
				char c=pricefirst.charAt(i);
				if(Character.isDigit(c)==true)
				{
					pricefirstfinal=pricefirstfinal+c;
				}
			}
			pricefirstnumber=Integer.parseInt(pricefirstfinal);
			System.out.println("Price of first item "+pricefirstnumber);
			driver.close();
			driver.switchTo().window(parentid);
			
			WebElement wlast=productsearch1.get(productcount-1);
			wlast.click();
			Set<String> s4=driver.getWindowHandles();
			Iterator<String> i2=s4.iterator();
			String parentid1=i2.next();
			String childid1=i2.next();
			driver.switchTo().window(childid1);
			String pricelast=pricedisplay1.getText();
			String pricelastfinal="";
			for(int i=0;i<pricelast.length();i++)// This logic is removing comma from the price
			{
				char c=pricelast.charAt(i);
				if(Character.isDigit(c)==true)
				{
					pricelastfinal=pricelastfinal+c;
				}
			}
			pricelastnumber=Integer.parseInt(pricelastfinal);
			System.out.println("Price of last item "+pricelastnumber);
			driver.close();
			driver.switchTo().window(parentid);
			if(pricelastnumber<pricefirstnumber)
			{
				Assert.assertTrue(true, "Test case 8 failed");
				System.out.println("TestCase 8 passed- Sorting high to low successful");
				Reporter.log("TestCase 8 passed- Sorting high to low successful");
			}
			else
			{
				Assert.fail("TestCase 8 failed-Sorting high to low unsuccessful");
			}

		}
	public void addtocartNoLogin(WebDriver driver)
	{
		WebElement w1=productsearch1.get(4);
		w1.click();
		Set<String> s3=driver.getWindowHandles();
		Iterator<String> i1=s3.iterator();
		String parentid=i1.next();
		String childid=i1.next();
		driver.switchTo().window(childid);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(addtocartbutton));
		addtocartbutton.click();
	/*	Amz_CartPage cart=new Amz_CartPage(driver);
		cart.cartlinkontop(driver);
		String title=driver.getTitle();
		String acclist=textlist.getText();
		System.out.println(title);
		System.out.println(acclist);
		Assert.assertEquals(title, "Amazon.in Shopping Cart","Test Case 15 failed-unable to reach cart page without logging in failed");
		Assert.assertEquals(acclist, "Hello, sign in","Test Case 15 failed-unable to reach cart page without logging in failed");
		System.out.println("Test Case 15 passed-Reaching the cart page without logging in successful");
	Reporter.log("Test Case 15 passed-Reaching the cart page without logging in successful");
	
	*/
		}
	public Amz_SearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}