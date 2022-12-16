package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxPOM.UtilityNew;





public class BaseNew 
{
	protected static WebDriver driver;
	
	public void launchBrowser() throws InterruptedException, IOException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\My_16 evning batch\\selenium\\chromedriver.exe");
						  
	    driver = new ChromeDriver();//2] create object
						  
		driver.manage().window().maximize();//3]maximize browser
		
		driver.get(UtilityNew.readDataFromPropertyFile("url"));//only this change property file use
		
		Reporter.log("Launching browser", true);
		Reporter.log("Launching browser", true);
		Reporter.log("Launching browser", true);
		Reporter.log("Launching browser", true);
		Reporter.log("Launching browser", true);
		
		Thread.sleep(1000);
	}
	

}
