package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class KiteZerodhaLoginPage {
	WebDriver driver;
	@FindBy(xpath="//img[@alt='Kite']") private WebElement kiteLogo;
	@FindBy(xpath="//h2[text()='Login to Kite']")private WebElement textDisplay;
	@FindBy(xpath="//input[@type='text']")private WebElement userName;
	@FindBy(xpath="//input[@type='password']")private WebElement password;
	@FindBy(xpath="//button[@type='submit']")private WebElement Login;
	@FindBy(xpath="//a[@class='text-light forgot-link']")private WebElement forgetPass;
	@FindBy(xpath="//img[@alt='Kite Android']") private WebElement androidLink;
	@FindBy(xpath="//img[@alt='Kite iOS']") private WebElement iOSLink;
	@FindBy(xpath="//img[@alt='Zerodha']") private WebElement zerodhaTextLink;
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signUp; 
	@FindBy(xpath="//input[@id='pin']")private WebElement PIN;
	
	
	public KiteZerodhaLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public boolean clickOnKiteLogo() 
	{
		return kiteLogo.isDisplayed();
		
	}
	
	public void text() 
	{				
		System.out.println("Text on login page= "+textDisplay.getText());
		System.out.println("Text diplayed= "+textDisplay.isDisplayed());
	}

	public void enterUserName(String name)
	{	
		userName.sendKeys(name);
	}

	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}

	public void clickOnLogin() 
	{
		Login.click();
	}

	public void clickOnforgetPass()
	{
		forgetPass.click();
	}
	
	public void clickOnAndroidLink()
	{
		androidLink.click();
	}
		
	public void clickOniOSLink() 
	{	
		iOSLink.click();
	}
	
	public void clickOnZerodhaTextLink() 
	{	
		zerodhaTextLink.click();
	}
	
	public void enterPIN(String pin,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf(PIN));
		
		PIN.sendKeys(pin);
	}
	
	public void clickOnSignUp() {
		signUp.click();
	}
}
