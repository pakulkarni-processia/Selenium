package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefination.Sanity01;

public class Login {

	WebDriver driver;
	
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
	
	
}
