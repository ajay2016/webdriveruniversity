package logionframework.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
	
		//location of feature file and step definition file and plug in for reports
	features = {"src/test/java/logionframework/features/"},
	glue = {"logionframework/steps/"},
	monochrome = true,
	dryRun = false,
	tags = {},
	plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json",
			"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
	
)

public class Runner {

}
