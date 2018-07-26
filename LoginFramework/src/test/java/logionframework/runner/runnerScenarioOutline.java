package logionframework.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(
	
		//location of feature file and step definition file and plug in for reports
	features = {"src\\test\\java\\logionframework\\features\\ScenarioOutline\\"},
	glue = {"logionframework\\steps\\ScenarioOutline\\"},
	monochrome = true,
	dryRun = false,
	tags = {},
	plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json",
			"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
	
)

public class runnerScenarioOutline extends AbstractTestNGCucumberTests {

}
