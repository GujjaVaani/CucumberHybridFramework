package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver=driver;
	}

	public void clickOnElement(WebElement element,long durationInSeconds) {
		WebElement webElement=waitForElement(element, durationInSeconds);
		webElement.click();
	}
	
	public void typeTextIntoElement(WebElement element,String textToBeTyped,long durationInSeconds) {
		
		WebElement webElement=waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);

	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		 webElement=wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void selectOptionDropdown(WebElement element,long durationInSeconds,String dropdowntext)
	{
		WebElement webElement=waitForElement(element, durationInSeconds);
		Select select=new Select(element);
		select.selectByVisibleText(dropdowntext);
		
	}
	
	public Alert waitForAlert(long durationInSeconds) {
		Alert alert=null;
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			 alert=wait.until(ExpectedConditions.alertIsPresent());
			}catch(Throwable e) {
				e.printStackTrace();
			}
			return alert;
	}
	
	public void acceptAlert(long durationInSeconds) {
		Alert alert=waitForAlert(durationInSeconds);
		alert.accept();
	}
	public void dismissAlert(long durationInSeconds) {
		Alert alert=waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public void mouseHoverAndClick(WebElement element,long durationInSeconds) {
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		Actions act=new Actions(driver);
		act.moveToElement(webElement);
	}

	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		// TODO Auto-generated method stub
	
		WebElement webElement=null;
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement=wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	public void javaScriptClick(WebElement element,long durationInSeconds)
	{
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", webElement);
		
	}
	public void javaScriptSendKeys(WebElement element,long durationInSeconds,String textToBeTyped)
	{
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeTyped+"'", webElement);
		
	}

	public String getTextFromElement(WebElement element, long durationInSeconds) {
		// TODO Auto-generated method stub
		WebElement webElement=waitForVisibilityOfElement(element,durationInSeconds);
		return webElement.getText();
		
		
	}

	public boolean ismessageDisplayed(WebElement element, long durationInSeconds) {
		// TODO Auto-generated method stub
		WebElement webElement;
		try {
		 webElement=waitForVisibilityOfElement(element,durationInSeconds);
		return webElement.isDisplayed();
		}catch(Throwable e) {
			
			return false;
		}
		
	}
	
	
	
	
	
	
	
	
	
}
