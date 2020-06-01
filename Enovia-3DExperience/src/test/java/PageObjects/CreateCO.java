package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCO {

	WebDriver driver;
	WebDriverWait wait;
	
	public  CreateCO(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	
	@FindBy(xpath="//textarea[@id='DescriptionId']")
	WebElement codescription;
	
	@FindBy(xpath="//select[@id='CategoryOfChangeId']")
	WebElement chngctgrydropdown;
	
	@FindBy(xpath="//button[@class='btn-primary']")
	WebElement okbutton;
	
	public void enterdescription()
	{
	//driver.findElement(By.cssSelector("#DescriptionId")).sendKeys("Automation Test Description");
		codescription.sendKeys("Automation Test Description");
		System.out.println("Description entered");
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
	
	public void chngctgrydrpdwn()
	{
		
		Select catgryname = new Select(chngctgrydropdown);
		chngctgrydropdown.click();
		catgryname.selectByVisibleText("unassigned");
		System.out.println("Autoname series selected");
	}
	
	
	public void createco() throws InterruptedException
	
	{
		driver.switchTo().frame("slideInFrame");
		System.out.println("Frame switched");
				
		Thread.sleep(5000);
		
		enterdescription();
		//chngctgrydrpdwn();
		
		
	}
	
	public void clickok() throws InterruptedException
	{
		okbutton.click();
		System.out.println("Ok Button clicked");
		Thread.sleep(3000);
	}
	
	public void waitforsideframe()
	{
		
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='rightSlideIn']")));
		System.out.println("Right panel found");
	}
}
