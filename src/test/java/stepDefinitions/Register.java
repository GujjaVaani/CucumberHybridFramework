package stepDefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	private RegisterPage register;
	private AccountSuccessPage accountsucess;
	private CommonUtils CommonUtils;
	private DriverFactory driverfactory;

	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {

		
		
		driverfactory=new DriverFactory();
		driver=driverfactory.getDriver();
		HomePage home = new HomePage(driver);
		home.clickOnMyAccount();
		register=home.selectRegister();

		

	}

	@When("User enters the below fields")
	public void user_enters_the_below_fields(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
     
		Map<String, String> datamap = dataTable.asMap(String.class, String.class);

		register.enterFirstName(datamap.get("firstName"));
		register.enterLastName(datamap.get("lastName"));
	    CommonUtils = new CommonUtils();
		register.enteremail(CommonUtils.getEmailWithTimeStamp());
		register.enterphone(datamap.get("telephone"));
		register.enterpassword(datamap.get("password"));
		register.enterConfirmPassword(datamap.get("password"));
	

	}

	@When("user selects privacy policy field")
	public void user_selects_privacy_policy_field() {

		register.selectPrivacypolicyfield();
		// driver.findElement(By.name("agree")).click();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {

		accountsucess=register.clickOnContinue();
		// driver.findElement(By.xpath("//input[@value='Continue']")).click();

	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {

		
		Assert.assertEquals("Your Account Has Been Created!", accountsucess.getPageHeading());
	}

	@When("user select yes for newsletter")
	public void user_select_yes_for_newsletter() {

		register.selectnewsletterOption();

		// driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
	}

	@When("User enters the duplicate below fields")
	public void user_enters_the_duplicate_below_fields(DataTable dataTable) {
	

		Map<String, String> datamap = dataTable.asMap(String.class, String.class);

		register.enterFirstName(datamap.get("firstName"));
		register.enterLastName(datamap.get("lastName"));
		register.enteremail(datamap.get("email"));
		register.enterphone(datamap.get("telephone"));
		register.enterpassword(datamap.get("password"));
		register.enterConfirmPassword(datamap.get("password"));

	

	}

	@Then("User should get a proper warning message about duplicate email")
	public void user_should_get_a_proper_warning_message_about_duplicate_email() {
		
		
		
		Assert.assertTrue(register.duplicateAccountWarnigmessage()
				.contains("Warning: E-Mail Address is already registered!"));

	}

	@When("User dont enters the any details into fields")
	public void user_dont_enters_the_any_details_into_fields() {
		register.enterFirstName("");
		register.enterLastName("");
		register.enteremail("");
		register.enterphone("");
		register.enterpassword("");
		register.enterConfirmPassword("");
		
	
		
	}

	@Then("User should get a proper warning message for every mandatory field")
	public void user_should_get_a_proper_warning_message_for_every_mandatory_field() {
		Assert.assertTrue(register.duplicateAccountWarnigmessage()
				.contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",
				register.warningFirsName());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",
				register.warningLastName());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",
				register.emailWarnMessage());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
				register.phoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!",
				register.passwordWarningMessage());
	}

}
