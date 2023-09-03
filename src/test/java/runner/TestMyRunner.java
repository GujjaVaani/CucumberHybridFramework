package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src/test/resources/features",
		glue={"stepDefinitions","hooks"},
		plugin={"pretty","html:target/cucumberReports/CucumberReport.html"},
		//tags="@login",
		publish = true
		//dryRun = true
		
		)

public class TestMyRunner {

	
}
