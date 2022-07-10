package pom;


import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteZerodhaSignUpPage {
	WebDriver driver;
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signUp; 
	@FindBy(xpath="//input[@type='text']")private WebElement mobileNumber;
	@FindBy(xpath="//button[@type='submit']")private WebElement clickONContinue;

	public KiteZerodhaSignUpPage (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void clickOnSignUp() throws InterruptedException {
		signUp.click();
	}
	
	public void enterMobileNumber(String mbNumber1, WebDriver driver) throws InterruptedException
	{	
		ArrayList<String> list = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		Thread.sleep(1000);
		
		mobileNumber.sendKeys(mbNumber1);
	}

	public void clickOnContinue() 
	{
		clickONContinue.click();
	}

}
