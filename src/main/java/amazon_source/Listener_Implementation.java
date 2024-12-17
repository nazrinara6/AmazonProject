package amazon_source;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener_Implementation implements ITestListener
{
    public static WebDriver driver;
	@Override
	public void onTestStart(ITestResult result)
	{
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Date d1 = new Date();
		Date c_Date = new Date(d1.getTime());
		//System.out.println(c_Date);
		String saveDate = c_Date.toString();
		String get_CurrentDateTime = saveDate.substring(saveDate.length()-4).concat("_").concat(saveDate.substring(4, 19));
		String CurrentDateTime_1 = get_CurrentDateTime.replace(":", "");
		String FinalDateTime = CurrentDateTime_1.replace(" ", "_");
		System.out.println(FinalDateTime);
		
		ITestListener.super.onTestSuccess(result);
		Reporter.log("Testcase successful");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\ROG\\eclipse-workspace\\Project_Amazon\\Screenshot\\pass\\"+FinalDateTime+".png");
		try 
		{
			FileHandler.copy(source, destination);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		Date d1 = new Date();
		Date c_Date = new Date(d1.getTime());
		//System.out.println(c_Date);
		String saveDate = c_Date.toString();
		String get_CurrentDateTime = saveDate.substring(saveDate.length()-4).concat("_").concat(saveDate.substring(4, 19));
		String CurrentDateTime_1 = get_CurrentDateTime.replace(":", "");
		String FinalDateTime = CurrentDateTime_1.replace(" ", "_");
		System.out.println(FinalDateTime);
		
		ITestListener.super.onTestFailure(result);
		Reporter.log("Testcase failed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\ROG\\eclipse-workspace\\Project_Amazon\\Screenshot\\fail\\"+FinalDateTime+".png");
		try 
		{
			FileHandler.copy(source, destination);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	


}
