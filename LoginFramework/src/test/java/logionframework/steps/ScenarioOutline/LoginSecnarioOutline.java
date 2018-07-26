package logionframework.steps.ScenarioOutline;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSecnarioOutline {
	
	WebDriver driver;
	String browser = "Chrome";
	
	@Before
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
		driver.close();
		driver.quit();
		//driver = null;

	}
	
	@Given("^User navigates to \"([^\"]*)\"$")
	public void user_navigates_to(String url) throws Throwable {
		driver.get(url);
	    
	}

	@When("^User clicks on login-portal link$")
	public void user_clicks_on_login_link() throws Throwable {
		driver.findElement(By.id("login-portal")).click();
	    
	}

	@When("^User enters the \"([^\"]*)\" username$")
	public void user_enters_the_username(String username) throws Throwable {
		
		@SuppressWarnings("unused")
		String windowHandleBefore = driver.getWindowHandle();
		//Iterate over window handles and switch to new window
		for(String windowHandle:driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
			
		}
		driver.findElement(By.id("text")).sendKeys(username); 
	}

	@When("^User enters the \"([^\"]*)\" password$")
	public void user_enters_the_password(String password) throws Throwable {
		
		driver.findElement(By.id("password")).sendKeys(password);
	    
	}

	@When("^Click on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.id("login-button")).click();
	    
	}

	@Then("^User should be presented with the following alert \"([^\"]*)\"$")
	public void user_should_be_presented_with_the_following_alert(String message) throws Throwable {
		
		// delay
				WebDriverWait wait = new WebDriverWait(driver,5);
				wait.until(ExpectedConditions.alertIsPresent());
				
				Alert al = driver.switchTo().alert();
				System.out.println(al.getText());
				
				
				if(al.getText().equalsIgnoreCase(message)) {
					System.out.println("Message Validated");					
				}
				al.accept();//ok
//				al.dismiss();// cancel
				
				driver.switchTo().defaultContent();
				
	    
	}



}
