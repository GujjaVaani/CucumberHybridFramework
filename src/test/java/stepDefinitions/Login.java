package stepDefinitions;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


public class Login {

	WebDriver driver;
	private LoginPage login;
	private AccountPage account;
	private CommonUtils CommonUtils;
	private DriverFactory driverfactory;
@Given("User has navigated to login page")
public void user_has_navigated_to_login_page() {
	driverfactory=new DriverFactory();
	driver=driverfactory.getDriver();
	HomePage home=new HomePage(driver);
	home.clickOnMyAccount();
	login=home.selectLoginOption();
   
}

@When("^User enter valid email address (.+) into email field$")
public void user_enter_valid_email_address_into_email_field(String email) {
	
	login.enterEmailField(email);
	
}

@When("^User has entered valid password (.+) into password field.$")
public void user_has_entered_valid_password_into_password_field(String password) {
	login = new LoginPage(driver);
	login.enterPassword(password);
	//driver.findElement(By.id("input-password")).sendKeys(password);
}

@When("Click on Continue button")
public void click_on_continue_button() {
	 account=login.clickOnLogin();
	
  
}

@Then("User should get successfully logged in")
public void user_should_get_successfully_logged_in() {
 
	//System.out.println(account.verifySuccessfullylogged());
	Assert.assertTrue(account.verifySuccessfullylogged());
}

@When("User enter invalid email address into email field")
public void user_enter_invalid_email_address_into_email_field() {
	
	CommonUtils = new CommonUtils();
	login.enterEmailField(CommonUtils.getEmailWithTimeStamp());
	
	//driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
	
	
}

@When("User has entered invalid password {string} into password field.")
public void user_has_entered_invalid_password_into_password_field(String password) {
	
	login.enterPassword(password);
	//driver.findElement(By.id("input-password")).sendKeys(password);
}


@Then("User should get getproper warning message about credentials mismatch.")
public void user_should_get_getproper_warning_message_about_credentials_mismatch() {
	
  Assert.assertTrue(login.verifyWarningMessageonMismatchCredentials().contains("Warning: No match for E-Mail Address and/or Password."));
}

@When("User dont enter email address into email field")
public void user_dont_enter_email_address_into_email_field() {
	
	
	login.enterEmailField("");
	

}

@When("User dont enter valid password into password field.")
public void user_dont_enter_valid_password_into_password_field() {
	login.enterPassword("");
	
}


}
