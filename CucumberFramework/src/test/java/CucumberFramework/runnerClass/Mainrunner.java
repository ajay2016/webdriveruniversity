package CucumberFramework.runnerClass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
	
		//location of feature file and step definition file and plug in for reports
	features = {"src/test/java/CucumberFramework/features/"},
	glue = {"CucumberFramework/stepFiles"},
	monochrome = true,
	tags = {},
	plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json",
			"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
	
)
public class Mainrunner {

}
