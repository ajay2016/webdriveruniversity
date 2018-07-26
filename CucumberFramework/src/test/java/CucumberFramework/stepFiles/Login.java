package CucumberFramework.stepFiles;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
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
		driver.quit();
		driver = null;

	}

	@Given("^User navigates to stackoverflow website$")
	public void user_navigates_to_stackoverflow_website() throws Throwable {
		driver.get("https://stackoverflow.com/");

	}

	@And("^User clicks on the login button on homepage$")
	public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Log In']")).click();

	}

	@And("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("ajay.skiva@gmail.com");

	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.id("password")).sendKeys("nepali1234");

	}

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.id("submit-button")).click();
		Thread.sleep(5000L);

	}

	@Then("^User should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page() throws Throwable {

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.
		 * xpath("//a[contains(text(), 'Ask Question')]"))));
		 */

		/*
		 * String text =
		 * driver.findElement(By.xpath("//a[contains(text(), 'Ask Question')]")).getText
		 * ();
		 * 
		 * if(text.equals("Ask Question")) {
		 * System.out.println("User has successfully login");
		 * 
		 * }
		 * 
		 * Assert.assertEquals("Ask Question", text);
		 */

		// check if button is displayed or not
		WebElement askQuestionButton = driver.findElement(By.xpath("//a[contains(text(), 'Ask Question')]"));
		Assert.assertEquals(true, askQuestionButton.isDisplayed());
	}

	@Given("^User navigates to stackoverflow website(\\d+)$")
	public void user_navigates_to_stackoverflow_website(int arg1) throws Throwable {

	}

	@Given("^User clicks on the login button on homepage(\\d+)$")
	public void user_clicks_on_the_login_button_on_homepage(int arg1) throws Throwable {

	}

	@Given("^User enters a valid username(\\d+)$")
	public void user_enters_a_valid_username(int arg1) throws Throwable {

	}

	@Given("^User enters a valid password(\\d+)$")
	public void user_enters_a_valid_password(int arg1) throws Throwable {

	}

	@When("^User clicks on the login button(\\d+)$")
	public void user_clicks_on_the_login_button(int arg1) throws Throwable {

	}

	@Then("^User should be taken to the successful login page(\\d+)$")
	public void user_should_be_taken_to_the_successful_login_page(int arg1) throws Throwable {

	}

}
