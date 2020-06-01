package PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetCredentials {

	WebDriver localdriver;
	List<WebElement> List;
	
	public  SetCredentials(WebDriver newdriver)
	{
		localdriver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	@FindBy(id="Organization")
	WebElement Organization;
	
	@FindBy(id="Project")
	WebElement Collabspace;
	
	@FindBy(id="Role")
	WebElement Role;
	
	@FindBy(xpath="//button[@class='btn-primary']")
	WebElement okbutton;
	
	public void updateorganization()
	{
	
	
	//WebElement Organization = localdriver.findElement(By.id("Organization"));
	Select Organization1 = new Select(Organization);
	Organization1.selectByVisibleText("Company Name");
	System.out.println("Organization selected");
	}
	public void updatecollabspac()
	{
	//WebElement Collabspace = localdriver.findElement(By.id("Project"));
	Select CBspace = new Select(Collabspace);
	CBspace.selectByVisibleText("Default");
	System.out.println("Collab Space selected");
	}
	public void updaterole()
	{
	//WebElement Role = localdriver.findElement(By.id("Role"));
	Select Role1 = new Select(Role);
	Role1.selectByVisibleText("Leader");
	System.out.println("Role selected");
	}
	//status.screenshot(localdriver, "Credentials set.jpg");
	
	//localdriver.findElement(By.xpath("//button[@class='btn-primary']")).click();
	public void okclick() throws InterruptedException 
	{
		okbutton.click();
		Thread.sleep(10000);
		localdriver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		System.out.println("Role and Collab space changed");	
	}
	
	
	
}
