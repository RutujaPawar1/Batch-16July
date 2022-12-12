package neoStoxPOM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityNew {

	
	 public static String readDataFromPropertyFile(String key) throws IOException
	 {
		 //create object of properties class---->java
		 Properties props = new Properties();
		 
		 //create object of fileImputStream ad pass properties file path as a parameter
		 
		 FileInputStream myFile = new FileInputStream("C:\\Users\\pawar rutuja\\eclipse-workspace\\16JUL_A_EVEN\\NeoStox.properties");
		 props.load(myFile);
		 
		 String value = props.getProperty(key);
		 Reporter.log("Reading "+key+" from property file", true);
		 return value;
	 }
	
	 public static void screenshot(WebDriver driver, String screenShotName) throws
		IOException, InterruptedException
		{
		wait(driver,5000);
	
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination =new File("C:\\My_16 evning batch\\selenium\\screenshot//myfile1"+screenShotName+".png");
		FileHandler.copy(src, destination);
		Reporter.log("taking screenshot", true);
	     }
		
	public static void scrollIntoView(WebDriver driver, WebElement element)
		{
			wait(driver,5000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			Reporter.log("Scrolling into view", true);
		}

	public static void wait(WebDriver driver, int waitTime)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
			Reporter.log("Waiting for "+waitTime+"ms",true);
		}
	
	
	
}
