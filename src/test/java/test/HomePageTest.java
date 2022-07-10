package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.HomePage;
import pom.KiteZerodhaLoginPage;
import utility.Excel;

public class HomePageTest{

	WebDriver driver;
	@BeforeMethod
	public void openBrowser() 
	{
		driver = Browser.chromeBrowser();
	}
	
	@Test
	public void Login() throws InterruptedException, EncryptedDocumentException, IOException
	{
		KiteZerodhaLoginPage kitezerodhaloginpage = new KiteZerodhaLoginPage(driver);	

		boolean s = kitezerodhaloginpage.clickOnKiteLogo();
		Assert.assertTrue(s);; //hard assert
		kitezerodhaloginpage.text();
		kitezerodhaloginpage.enterUserName(Excel.getData("Zerodha1", 0, 1));
		kitezerodhaloginpage.enterPassword(Excel.getData("Zerodha1", 1, 2));
		kitezerodhaloginpage.clickOnLogin();		
		
		kitezerodhaloginpage.enterPIN(Excel.getData("Zerodha1", 2, 0),driver);
		kitezerodhaloginpage.clickOnLogin();
		
		HomePage homepage = new HomePage(driver);
		Thread.sleep(2000);
		homepage.moveOnShares(driver);
		homepage.clickOnBuy(driver);	
		homepage.clickOnCancel(driver);
		
		homepage.clickOnSell(driver);
		homepage.clickOnCancel(driver);
		
		homepage.clickOnMarketDepth(driver);
		homepage.clickOnChart(driver);		
	}
	
//	@Test(priority = 1)
//	public void searchField() throws InterruptedException
//	{
//	
////		KiteZerodhaLoginPageTest login = new KiteZerodhaLoginPageTest();
////		login.LoginTest(driver);
//		
//		HomePage homepage = new HomePage(driver);
//		homepage.enterInSearchBox(driver);
//	}
}
