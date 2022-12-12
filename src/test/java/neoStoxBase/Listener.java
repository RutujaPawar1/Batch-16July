package neoStoxBase;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxBase.BaseNew;
import neoStoxPOM.UtilityNew;


public class Listener extends BaseNew implements ITestListener 
{
	
	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getName();
		Reporter.log("Tc "+methodName+" is completed successfuly ", true);
	}
	
	
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("Tc "+result.getName()+" is failed ", true);
		try {
			UtilityNew.screenshot(driver, result.getName());// ji TC faile zali tyacha fkt screenshot ghenar
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("Tc "+result.getName()+" is skipped please check...", true);
	}

}
