package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features/Sanity01-ReleaseEBOM-Newpart.Feature",
		glue = {"StepDefination"},
		plugin = {"pretty:target/cucumber-pretty.txt","html:target/test-output-html","json:target/cucumber.json", "junit:junit_xml/cucumber.xml"},
		monochrome = true, //display console output in readable format
		strict = true, //it will check if any step is not defined
		dryRun = true // top check mapping is proper between feature and steps
		)


public class TestRunner {

}
