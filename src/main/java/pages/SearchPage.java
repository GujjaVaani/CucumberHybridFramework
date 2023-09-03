package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchPage {

	private ElementUtils elementutils;
	WebDriver driver;
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
		 elementutils=new ElementUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement productavail;
	public boolean isProductAvailable() {
		
		//return productavail.isDisplayed();
	return elementutils.ismessageDisplayed(productavail, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	@FindBy(tagName="h2")
	private WebElement prodmsg;
	public String noProdutMessage() {
		//return prodmsg.getText();
		return elementutils.getTextFromElement(prodmsg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
