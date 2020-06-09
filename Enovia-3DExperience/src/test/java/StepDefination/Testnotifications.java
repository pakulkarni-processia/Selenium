package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.HomePage;
import PageObjects.Login;
import cucumber.api.java.en.Given;

public class Testnotifications {

	 ReportFunctions statusreport;
	 WebDriverWait wait;
	 WebDriver driver;
	 Login log;
	 HomePage home;
	 Test test;
	 
	@Given("^Navigate to open notification$")
	public void navigate_to_open_notification() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		System.setProperty("webdriver.gecko.driver",(".//Drivers/geckodriver.exe"));
		driver = new FirefoxDriver();
		driver.get("https://ootb19x.processia2003.com/3dspace/");
		driver.manage().window().maximize();
		
		log = new Login(driver);
		
		
		test = new Test(driver);
		
		test.launchbrowser();
		test.globalsearch();
		test.rightclickcano();
		test.approvetask();
	}
}
