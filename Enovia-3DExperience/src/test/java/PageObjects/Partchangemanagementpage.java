package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Partchangemanagementpage {

	
	WebDriver driver;
	WebDriverWait wait;
	
	public  Partchangemanagementpage(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	
	@FindBy(xpath="//li[@title='Change Management']")
	WebElement chngmngmnt;
	
	@FindBy(xpath="/html/body/form[1]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td[3]/table/tbody/tr/td/a")
	WebElement coname;
	
	public void clickchngmngmntctgry() throws InterruptedException
	{
		chngmngmnt.click();
		Thread.sleep(2000);
	}
	
	public void navigatetoframe()
	{
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ECMCOs");
	}
	
	public void iscodisplayed()
	{
		if(coname.isDisplayed())
		{
			System.out.println("CO is created successfully");
			String cono = coname.getText();
			System.out.println("CO number is:"+cono); 	
		}
		else 
		{
			System.out.println("CO is not created");
		}
		
	}
	
	public void openco() 
	{
		coname.click();
		System.out.println("Clicked on CO Name on Part CM page");
		
	}
	
}
