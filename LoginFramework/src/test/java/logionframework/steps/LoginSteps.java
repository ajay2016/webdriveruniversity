package logionframework.steps;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	WebDriver driver;
	String browser = "Chrome";
	
	@Before
	//browser set up
	public void setup() {
		if (browser.equals("Mozilla")) {
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			driver = new FirefoxDriver();

		} else if (browser.equals("Chrome")) {
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
			driver = new ChromeDriver();

		} else if (browser.equals("IE")) {
			System.setProperty(InternetExplorerDriver.LOG_FILE, "null");
			driver = new InternetExplorerDriver();

		} else if (browser.equals("Edge")) {
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "null");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

	}

	@After
	public void closeBrowser() {
		driver.manage().deleteAllCookies();
		driver.quit();
		driver = null;

	}
	
	@Given("^User access webdriverunivesity website$")
	public void user_access_webdriverunivesity_website() throws Throwable {
		driver.get("http://www.webdriveruniversity.com/");
	   
	}

	@When("^User clicks on Login Portal link$")
	public void user_clicks_on_Login_Portal_link() throws Throwable {
		driver.findElement(By.id("login-portal")).click();
	    
	}

	@When("^User enters a username$")
	public void user_enters_a_username() throws Throwable {
	@SuppressWarnings("unused")
	String windowHandleBefore = driver.getWindowHandle();
	//Iterate over window handles and switch to new window
	for(String windowHandle:driver.getWindowHandles()) {
		driver.switchTo().window(windowHandle);
		
	}
	driver.findElement(By.id("text")).sendKeys("Tom");
	    
	}
	
	//accept all Character Upper, Lower and numbers and special characters
	//send to the variable
	//saves repeating same method
	@When("^User enters a \"([^\"]*)\" password$")
	public void user_enters_a_password(String password) throws Throwable {
		driver.findElement(By.id("password")).sendKeys(password);
	   
	}

	@When("^User clicks on the Login button$")
	public void user_clicks_on_the_Login_button() throws Throwable {
		driver.findElement(By.id("login-button")).click();
	   
	}

	@Then("^User should be presented with a successful validation alert$")
	public void user_should_be_presented_with_a_successful_validation_alert() throws Throwable {
		
		
	   
	}

	@Then("^User should be presented with a unsuccessful validation alert$")
	public void user_should_be_presented_with_a_unsuccessful_validation_alert() throws Throwable {
	    
	}



}
