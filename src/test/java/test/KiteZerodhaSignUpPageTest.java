package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.KiteZerodhaSignUpPage;
import utility.Excel;
import utility.ScreenShot;

public class KiteZerodhaSignUpPageTest {

	WebDriver driver;

	@BeforeMethod
	public void openBrowser()
	{
		driver = Browser.chromeBrowser();
	}

	@Test
	public void SignUp() throws EncryptedDocumentException, IOException, InterruptedException {
		
		KiteZerodhaSignUpPage zerodhasignuppage = new KiteZerodhaSignUpPage(driver);
		zerodhasignuppage.clickOnSignUp();
		
		String mbNumber = Excel.getData("Zerodha1", 2, 3);
		zerodhasignuppage.enterMobileNumber(mbNumber, driver);
		
		ScreenShot.main(driver, "SignUp");
		
		zerodhasignuppage.clickOnContinue();
	}
}
