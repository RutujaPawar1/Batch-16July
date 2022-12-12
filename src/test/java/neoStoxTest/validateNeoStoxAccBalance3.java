package neoStoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStoxPOM.UtilityNew;

import neoStoxBase.BaseNew;
import neoStoxPOM.NeoStoxHomePage;
import neoStoxPOM.NeoStoxLoginPage;
import neoStoxPOM.NeoStoxPasswordPage;
import neoStoxPOM.NeoStoxSignInPage;

@Listeners(neoStoxBase.Listener.class)

  public class validateNeoStoxAccBalance3 extends BaseNew
    {
	NeoStoxLoginPage login;
	NeoStoxPasswordPage password;
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;
	
	@BeforeClass
	public void launchNeoStox() throws InterruptedException, IOException
	   {
		launchBrowser();//form base class
		login = new NeoStoxLoginPage(driver);
		password =new NeoStoxPasswordPage(driver);
		home =new NeoStoxHomePage(driver);
		signIn=new NeoStoxSignInPage(driver);
	   }
	
	@BeforeMethod
	public void logintoNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
	   {
		signIn.clickOnSignInButton(driver);
		Thread.sleep(1000);
		login.sendMobilenumber(driver, UtilityNew.readDataFromPropertyFile("mobileNumber"));
		login.clickOnSignInButton(driver);
		UtilityNew.wait(driver, 5000);
		
		password.enterPassword(driver, UtilityNew.readDataFromPropertyFile("password"));
		Thread.sleep(5000);
		password.clickOnSubmitButton(driver);
		Thread.sleep(15000);
		home.handlePopUp(driver);
	   }
	@Test
	public void validateAccBalance() throws IOException, InterruptedException
	  {
		Assert.assertNotNull(home.getAccountBalance(driver), "TC failed unable to fetch account Balance");
		Assert.fail();
	  }

    @Test(priority = -1)
    public void validateUserId() throws IOException, InterruptedException 
      {  
	  Assert.assertEquals(home.getActualUserName(driver), UtilityNew.readDataFromPropertyFile("userName"),"Tc is failed Actual and Expected user name are not matching");
	 
      }
    @AfterMethod
    public void logOutFromNeoStox()
      {
	  home.logOut(driver);
      }
    @AfterClass
    public void closeBrowser()
     {
	  Reporter.log("closing browser", true);
	  driver.close();
     }
}
