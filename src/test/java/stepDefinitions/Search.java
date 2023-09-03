
package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;


public class Search {
WebDriver driver;
private HomePage home;
private SearchPage search;
private DriverFactory driverfactory;
	@Given("User opens the application")
	public void user_opens_the_application() {

		driverfactory=new DriverFactory();
		driver=driverfactory.getDriver();
		
	}

	@When("User enters valid product {string} into search field")
	public void user_enters_valid_product_into_search_field(String product) {
	   
		 home= new HomePage(driver);
		home.searchTextField(product);
		//driver.findElement(By.name("search")).sendKeys(product);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		search=home.selectSearchButton();
	  //driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		
	  Assert.assertTrue(search.isProductAvailable());
	 // int a= 10/0;
	}
	@When("User enters invalid product {string} into search field")
	public void user_enters_invalid_product_into_search_field(String invalidproduct) {
	    // Write code here that turns the phrase above into concrete actions
		home= new HomePage(driver);
		home.searchTextField(invalidproduct);
		
		//driver.findElement(By.name("search")).sendKeys(invalidproduct);
	}

	
	@Then("User should get message about no product matching")
	public void user_should_get_message_about_no_product_matching() {
		
		
	   Assert.assertEquals("Products meeting the search criteria", search.noProdutMessage());
		
	}

	@When("User dont enter any product name into search field")
	public void user_dont_enter_any_product_name_into_search_field() {
	//intentionally left the function
		home= new HomePage(driver);
	}
}
