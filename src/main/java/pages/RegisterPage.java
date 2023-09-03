package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementutils;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNamefield;

	public void enterFirstName(String firstName) {

		// firstNamefield.sendKeys(firstName);
		elementutils.typeTextIntoElement(firstNamefield, firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	@FindBy(id = "input-lastname")
	private WebElement lastNamefield;

	public void enterLastName(String lastName) {

		// lastNamefield.sendKeys(lastName);
		elementutils.typeTextIntoElement(lastNamefield, lastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	@FindBy(id = "input-email")
	private WebElement emailfield;

	public void enteremail(String emailWithTimeStamp) {

		// emailfield.sendKeys(emailWithTimeStamp);
		elementutils.typeTextIntoElement(emailfield, emailWithTimeStamp, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	@FindBy(id = "input-telephone")
	private WebElement phonefield;

	public void enterphone(String phone) {

		// phonefield.sendKeys(phone);
		elementutils.typeTextIntoElement(phonefield, phone, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	@FindBy(id = "input-password")
	private WebElement passwordfield;

	public void enterpassword(String password) {

		// passwordfield.sendKeys(password);
		elementutils.typeTextIntoElement(passwordfield, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	@FindBy(id = "input-confirm")
	private WebElement confirmpasswordfield;

	public void enterConfirmPassword(String password) {

		// confirmpasswordfield.sendKeys(password);
		elementutils.typeTextIntoElement(confirmpasswordfield, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	@FindBy(name = "agree")
	private WebElement selectpolicyprivacy;

	public void selectPrivacypolicyfield() {

		// selectprivacy.click();
		elementutils.clickOnElement(selectpolicyprivacy, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement clickContinue;

	public AccountSuccessPage clickOnContinue() {

		// clickContinue.click();
		elementutils.clickOnElement(clickContinue, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);

	}

	@FindBy(xpath = "//label[normalize-space()='Yes']//input[@name='newsletter']")
	private WebElement selectYesOption;

	public void selectnewsletterOption() {

		// selectYesOption.click();
		elementutils.clickOnElement(selectYesOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateAccountWarning;

	public String duplicateAccountWarnigmessage() {

		// return duplicateAccountWarning.getText();
		return elementutils.getTextFromElement(duplicateAccountWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarn;

	public String warningFirsName() {

		// return firstNameWarn.getText();
		return elementutils.getTextFromElement(firstNameWarn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarn;

	public String warningLastName() {

		// return lastNameWarn.getText();
		return elementutils.getTextFromElement(lastNameWarn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarn;

	public String emailWarnMessage() {
		// return emailWarn.getText();
		return elementutils.getTextFromElement(emailWarn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement phonewarn;

	public String phoneWarning() {

		// return phonewarn.getText();
		return elementutils.getTextFromElement(phonewarn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordwarn;

	public String passwordWarningMessage() {

		// return passwordwarn.getText();
		return elementutils.getTextFromElement(passwordwarn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
