package pom;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	@FindBy (xpath = "//button[text()='B ']") private WebElement buyButton;
	@FindBy (xpath = "//button[text()='S ']") private WebElement sellButton;
	@FindBy (xpath = "//span[@class='icon icon-trash']") private WebElement deleteButton;
	@FindBy (xpath = "//span[@class='icon icon-align-center']") private WebElement marketDepth;
	@FindBy (xpath = "(//span[@class='icon icon-trending-up'])[1]") private WebElement chart;
	@FindBy (xpath = "//span[@class='icon icon-ellipsis']") private WebElement moreButton;
	@FindBy (xpath = "//button[text()='Cancel ']") private WebElement cancelButton;
	@FindBy (xpath = "//span[text()='ONGC']") private WebElement shares;
	@FindBy (xpath = "//input[@icon='search']") private WebElement searchBox;
	@FindBy (xpath = "//span[@class='icon icon-plus']") private WebElement plusButton;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void moveOnShares(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(shares).perform();
	}
	public void clickOnBuy(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(buyButton).click().perform();		
	}
	
	public void clickOnCancel(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(cancelButton));
		cancelButton.click();
	}
	
	public void clickOnSell(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(sellButton).click().perform();
		
	}
	
	public void clickOnMarketDepth(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(marketDepth).click().perform();
	}
	
	public void clickOnChart(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(chart).click().perform();
	}
	
	public void enterInSearchBox(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys("ONGC");
		
		Actions action = new Actions(driver);
		Thread.sleep(1500);
		action.moveToElement(shares).perform();
		Thread.sleep(1500);
		action.moveToElement(plusButton).click().perform();	
	}
}
