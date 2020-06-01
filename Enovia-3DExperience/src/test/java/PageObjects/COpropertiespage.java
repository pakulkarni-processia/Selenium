package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefination.ReadExcel;

public class COpropertiespage {

	WebDriver driver;
	WebDriverWait wait;
	
	public ReadExcel read;
	
	public  COpropertiespage(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	@FindBy(xpath="/html/body/form[1]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td[3]")
	WebElement partno;
	
	@FindBy(xpath="//li[@name='li_type_ChangeOrder']")
	WebElement conumber;
	
	@FindBy(xpath="//*[@id=\"ECMCOEditDetails\"]")
	WebElement editbutton;
	
	@FindBy(xpath="/html/body/div[2]/form/table/tbody/tr[18]/td[2]/table/tbody/tr/td[2]/input")
	WebElement approvallistbutton;
	
	@FindBy(xpath="//button[@class='btn-primary']")
	WebElement Donebutton;
	
	@FindBy(xpath="//*[@id=\"AEFLifecyclePromote\"]")
	WebElement promotebutton;
	
	@FindBy(xpath="/html/body/div[2]/form/table/tbody/tr[6]/td[4]")
	WebElement state;
	
	@FindBy(xpath="//li[@title='Content']")
	WebElement Content;
	
	@FindBy(xpath="/html/body/form[1]/div[2]/div[5]/div[2]/table/tbody/tr[2]/td[6]")
	WebElement CAname;
	
	public void switchframe()
	{
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ECMCRCOAffectedItems");
	}
	
	public String verifyconumber()
	{
		
		read = new ReadExcel();
		
		String [] array = read.readpartnumber("PartDetails", "Parent");
		if (partno.equals(array[1]))
				{
			System.out.println("Part added in CO");
			
				}
		else
		{
			System.out.println("Part no not present in CO");
		}
		return "True";
		
	}
	
	public void clickconumber() throws InterruptedException
	{
		conumber.click();
		System.out.println("Clicked on CO number on CO page");
		Thread.sleep(1000);
	}
	
	public void clickeditbutton()
	{
		editbutton.click();
		System.out.println("Clicked on Edit icon");
	}
	
	public void switchframeonpropertiespage()
	{
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ECMCOProperties");
		System.out.println("Framed Switched");
	}
	
	public void clickonapprovallistbutton()
	{
		approvallistbutton.click();
		System.out.println("Clicked on Approval List");
	}
	
	public void clickondone()
	{
		Donebutton.click();
		System.out.println("Clicked on Done button");
	}
	
	public void promoteco() throws InterruptedException
	{
		promotebutton.click();
		System.out.println("Clicked on Promote button");
		Thread.sleep(2000);
	}
	
	public void switchframeonlifecycle()
	{
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ECMLifecycle");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("AEFLifecycleBasic");
		System.out.println("Frame switched");
	}
	
	public String getcostate()
	{
		String costate = state.getText();
		System.out.println(costate);
		return costate;
	}
	
	public void clickcontent() throws InterruptedException
	{
		Content.click();
		System.out.println("Clicked on Content category");
		Thread.sleep(1000);
	}
	
	public void clickcaname()
	{
		CAname.click();
		System.out.println("Clicked on CA Name");
	}
}
