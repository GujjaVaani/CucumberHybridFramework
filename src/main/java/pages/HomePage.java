package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementutils;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
		elementutils=new ElementUtils(driver);
	}
	
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	public void clickOnMyAccount() {
		
		elementutils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//myAccountDropMenu.click();
	}
	@FindBy(linkText="Login")
	private WebElement loginOption;
	public LoginPage selectLoginOption() {
		
		//loginOption.click();
		elementutils.clickOnElement(loginOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	public RegisterPage selectRegister() {
		// TODO Auto-generated method stub
		elementutils.clickOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//registerOption.click();
		return new RegisterPage(driver);
	}
	
	@FindBy(name="search")
	private WebElement SearchField;
	public void searchTextField(String productName) {
		elementutils.typeTextIntoElement(SearchField, productName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//SearchField.sendKeys(productName);
	}
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	private WebElement searchButton;
	public SearchPage selectSearchButton() {
		//searchButton.click();
		elementutils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchPage(driver);
	}
}
