package amazon_source;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Analyzer implements IRetryAnalyzer
{
    int initialcount = 0;
    int retrycouunt = 1;
	@Override
	public boolean retry(ITestResult result) 
	{
		if(initialcount<retrycouunt)
		{
			initialcount++;
			return true;
		}
		return false;
	}

}
