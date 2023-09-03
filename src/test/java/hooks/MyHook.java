package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHook {

	WebDriver driver=null;
	private ConfigReader configreader;
	private DriverFactory driverfactory;
	@Before
	public void setUp(){
		
		
	   Properties prop=new ConfigReader().intializeProperties();
		
	   //configreader=new ConfigReader();
		//Properties prop=configreader.intializeProperties();
		
		
		//DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driverfactory=new DriverFactory();
		driver=driverfactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
				
		

	}
	@After
	public void tearDown(Scenario scenario) {
		
		String scenarioName=scenario.getName().replace(" ", "_");

		if(scenario.isFailed()) {
       byte[] srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		
		
		driver.quit();
	}
}

