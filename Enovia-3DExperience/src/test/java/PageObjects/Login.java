package PageObjects;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefination.ReportFunctions;
import StepDefination.Sanity01;

public class Login {

	WebDriver driver;
	WebDriverWait wait;
	ReportFunctions statusreport;
	
	public  Login(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
		
	@FindBy(name="username")
	WebElement usernamelocator;
	
	@FindBy(name="password")
	WebElement passwordlocator; 
	
	@FindBy(className="commands")
	WebElement loginbutton;
	
	
	public String gettitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
		
	public void setusername(String uname)	
	{
		usernamelocator.sendKeys(uname);
	}

	public void setpassword(String pswrd)	
	{
		passwordlocator.sendKeys(pswrd);
	}

	public void clicklogin()	
	{
		loginbutton.click();
	}
	
	public void waitfor()
	{
		
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	}
	
	public void checkforlogo()
	{
		statusreport = new ReportFunctions(driver);
		String ExpTitle = "3DPassport - Login";
		String title = gettitle();
		System.out.println(title);
			Assert.assertEquals(ExpTitle, title);
		//statusreport.screenshot(driver, "logo.jpg");
		statusreport.logger("Login Page is Displayed");
	}
	
}
