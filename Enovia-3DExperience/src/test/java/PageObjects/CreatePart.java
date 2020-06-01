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

public class CreatePart {

	WebDriver driver;
	WebDriverWait wait;
	
	public  CreatePart(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	@FindBy(xpath="/html/body/div[2]/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td/input[2]")
	WebElement checkbox;
	
	
	@FindBy(xpath="//*[@id=\"AutoNameSeriesId\"]")
	WebElement dropdown;
	
	@FindBy(name="VPMProductName1")
	WebElement title;
	
	@FindBy(xpath="//*[@id=\"DescriptionId\"]")
	WebElement description;
	
	@FindBy(xpath="//*[@id=\"NoOfParts\"]")
	WebElement noofparts;
	
	public void checkboxclick() throws InterruptedException
	{
	//WebElement Checkbox = driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td/input[2]"));
	checkbox.click();
	System.out.println("Autoname check box checked");
	Thread.sleep(5000);
	checkbox.click();
	Thread.sleep(5000);
	checkbox.click();
	Thread.sleep(3000);
	//driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
	
	public void seriesselection()
	{
	//*[@id="AutoNameSeriesId"]
	//*[@id="AutoNameSeriesId"]
	//WebElement Dropdown = driver.findElement(By.cssSelector("#AutoNameSeriesId"));
	Select Autoname = new Select(dropdown);
	Autoname.selectByVisibleText("General Series");
	System.out.println("Autoname series selected");
	//driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
	
	public void entertitle()
	{
	//driver.findElement(By.cssSelector("#VPMProductName1")).sendKeys("Automation");
	title.sendKeys("Automation");
	System.out.println("Product Name entered");
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
	
	public void enterdescription()
	{
	//driver.findElement(By.cssSelector("#DescriptionId")).sendKeys("Automation Test Description");
	description.sendKeys("Automation Test Description");
		System.out.println("Description entered");
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
	
	public void selectphase()
	{
	Select Phase = new Select(driver.findElement(By.cssSelector("#ReleaseProcessId")));
	Phase.selectByVisibleText("Production");
	System.out.println("Part Phase selected from dropdown");
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
	
	public void checkoptions()
	{
	driver.findElement(By.cssSelector("#Configured_html > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > input:nth-child(1)")).click();
	System.out.println("Enable Change Management check box checked");
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
}
	
	public void noofparts(CharSequence[] no)
	{
		noofparts.sendKeys(no);;
	}
	
	
	public void createpart() throws InterruptedException
	
	{
		
			
		driver.switchTo().frame("slideInFrame");
		System.out.println("Frame switched");
				
		Thread.sleep(5000);
		
		try {
			checkboxclick();
			seriesselection();
			entertitle();
			enterdescription();
			selectphase();
			//checkoptions();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void clickok()
	{
		driver.findElement(By.cssSelector(".btn-primary")).click();
				System.out.println("Ok Button clicked");
	}
}