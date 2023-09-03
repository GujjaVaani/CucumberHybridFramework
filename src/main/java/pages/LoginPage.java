package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementutils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}

	@FindBy(id = "input-email")
	private WebElement EmailField;

	public void enterEmailField(String email) {
		elementutils.typeTextIntoElement(EmailField, email, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		// EmailField.sendKeys(email);
	}

	@FindBy(id = "input-password")
	private WebElement LoginField;

	public void enterPassword(String password) {

		elementutils.typeTextIntoElement(LoginField, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		// LoginField.sendKeys(password);
	}

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement LoginButton;

	public AccountPage clickOnLogin() {

		// LoginButton.click();
		elementutils.clickOnElement(LoginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningmessgetext;

	public String verifyWarningMessageonMismatchCredentials() {

		return elementutils.getTextFromElement(warningmessgetext, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		// return warningmessgetext.getText();
	}

}
