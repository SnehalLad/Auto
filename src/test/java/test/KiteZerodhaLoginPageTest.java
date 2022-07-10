package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.KiteZerodhaLoginPage;
import utility.Excel;

public class KiteZerodhaLoginPageTest {
	WebDriver driver;
	
	@BeforeMethod
	public void OpenBrowser() {
		driver = Browser.chromeBrowser();
	}
	
	@Test
	public void LoginTest() throws EncryptedDocumentException, IOException  {

		KiteZerodhaLoginPage kitezerodhaloginpage = new KiteZerodhaLoginPage(driver);	
		
		boolean s = kitezerodhaloginpage.clickOnKiteLogo();
		Assert.assertTrue(s);; //hard assert
		kitezerodhaloginpage.text();
		kitezerodhaloginpage.enterUserName(Excel.getData("Zerodha1", 0, 1));
		kitezerodhaloginpage.enterPassword(Excel.getData("Zerodha1", 1, 2));
		kitezerodhaloginpage.clickOnLogin();		
		
		kitezerodhaloginpage.enterPIN(Excel.getData("Zerodha1", 2, 0),driver);
		kitezerodhaloginpage.clickOnLogin();
		}
	
	@Test(priority = 1)
	public void forgetPassword() {
		
		KiteZerodhaLoginPage kitezerodhaloginpage = new KiteZerodhaLoginPage(driver);	
		
		System.out.println("URL before forgetPassClick: " + driver.getCurrentUrl());
		kitezerodhaloginpage.clickOnforgetPass();
		
		System.out.println("URL after forgetPassClick: " + driver.getCurrentUrl());
		driver.navigate().back();
		
		kitezerodhaloginpage.clickOnZerodhaTextLink();		
		driver.navigate().back();
		
		kitezerodhaloginpage.clickOnAndroidLink();			
		driver.switchTo().parentFrame();
			
		kitezerodhaloginpage.clickOniOSLink();			
	}	
	
	@Test(priority = 2)
	public void t()
	{
		System.out.println("a");
	}
}