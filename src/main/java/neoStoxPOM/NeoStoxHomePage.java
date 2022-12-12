package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeoStoxHomePage 
{
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okButton;
	
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
	
	@FindBy(id = "lbl_username") private WebElement userName;
	
	@FindBy(id = "lbl_curbalancetop") private WebElement accountBalance;
	
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logOutButton;
	

	public NeoStoxHomePage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	public void handlePopUp(WebDriver driver) throws InterruptedException
	{
		if(okButton.isDisplayed())
		{
		UtilityNew.wait(driver, 5000);
		Thread.sleep(3000);
		okButton.click();
		Reporter.log("Handeling popup", true);
		Reporter.log("clicking on ok button of PopUp", true);
		
		UtilityNew.wait(driver, 5000);
		Thread.sleep(10000);
		closeButton.click();
		Reporter.log("clicking on close button of popup", true);
		}
		else
		{
			Reporter.log("there is no popup", true);
			Thread.sleep(3000);
		}
	}
	public String getActualUserName(WebDriver driver)
	{
		UtilityNew.wait(driver, 5000);
		String actualUserName = userName.getText();
		Reporter.log("getting actual user name", true);
		String realUserName = actualUserName.substring(3);
		Reporter.log("Actual user name is "+realUserName, true);
		return actualUserName;
	}
	
	public String getAccountBalance(WebDriver driver)
	{
		UtilityNew.wait(driver, 5000);
		String accBalance = accountBalance.getText();
		Reporter.log("getting accBalance", true);
		Reporter.log("Account Balance is"+accBalance, true);
		return accBalance;
		
	}
	
	public void logOut(WebDriver driver)
	{
		UtilityNew.wait(driver, 5000);
		userName.click();
		UtilityNew.wait(driver, 5000);
		logOutButton.click();
		Reporter.log("logging out", true);
	}
}
