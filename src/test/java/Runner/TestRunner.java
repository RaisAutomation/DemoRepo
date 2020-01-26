package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"C:\\Users\\Dell\\eclipse-workspace\\CucumberTestPOM\\src\\test\\java\\features\\LogIn.feature" }, glue = {
				"com.heroku.test" }, format = { "pretty",
						"html:test-output" }, monochrome = true, strict = true, dryRun = false)

public class TestRunner {

}
