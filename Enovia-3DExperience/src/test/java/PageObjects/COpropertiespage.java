package PageObjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefination.ReadExcel;
import StepDefination.ReportFunctions;

public class COpropertiespage {

	WebDriver driver;
	WebDriverWait wait;
	
	public ReadExcel read;
	ReportFunctions statusreport;
	HomePage home;
	JavascriptExecutor js;
	
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
	
	@FindBy(xpath="//tr[@id='calc_Name']//td[@class='field' and @colspan='9']")
	WebElement state;
	
	@FindBy(xpath="//li[@title='Content']")
	WebElement Content;
	
	@FindBy(xpath="/html/body/form[1]/div[2]/div[5]/div[2]/table/tbody/tr[2]/td[6]")
	WebElement CAname;
	
	@FindBy(xpath="//span[@class='extendedHeader type-name']")
	WebElement COheader;
	
	@FindBy(xpath="//td[@class='tab-inactive' and @title='Approvals']")
	WebElement Approvalstab;
	
	@FindBy(xpath="//tr[@class='even']//a[@class='object'and contains(text(),'IT-')]")
	WebElement task;
	
	public void switchframe()
	{
		statusreport = new ReportFunctions(driver);
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ECMCRCOAffectedItems");
		statusreport.logger("Frame switched");
	}
	
	public String verifyconumber()
	{
		statusreport = new ReportFunctions(driver);
		read = new ReadExcel();
		
		String [] array = read.readpartnumber("PartDetails", "Parent");
		if (partno.equals(array[1]))
				{
			statusreport.logger("Part added in CO");
			
				}
		else
		{
			statusreport.logger("Part no not present in CO");
		}
		return "True";
		
	}
	
	public void clickconumber() throws InterruptedException
	{
		statusreport = new ReportFunctions(driver);
		conumber.click();
		statusreport.logger("Clicked on CO number on CO page");
		Thread.sleep(1000);
	}
	
	public void clickeditbutton()
	{
		statusreport = new ReportFunctions(driver);
		editbutton.click();
		statusreport.logger("Clicked on Edit icon");
	}
	
	public void switchframeonpropertiespage()
	{
		statusreport = new ReportFunctions(driver);
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ECMCOProperties");
		statusreport.logger("Framed Switched");
	}
	
	public void clickonapprovallistbutton()
	{
		statusreport = new ReportFunctions(driver);
		approvallistbutton.click();
		statusreport.logger("Clicked on Approval List");
	}
	
	public void clickondone()
	{
		statusreport = new ReportFunctions(driver);
		Donebutton.click();
		statusreport.logger("Clicked on Done button");
	}
	
	public void promoteco() throws InterruptedException
	{
		statusreport = new ReportFunctions(driver);
		promotebutton.click();
		statusreport.logger("Clicked on Promote button");
		Thread.sleep(2000);
	}
	
	public void switchframeonlifecycle()
	{
		statusreport = new ReportFunctions(driver);
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ECMLifecycle");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("AEFLifecycleBasic");
		statusreport.logger("Frame switched");
	}
	
	public void getcostate(String costate) throws IOException
	{
		statusreport = new ReportFunctions(driver);
		String actualcostate = state.getText();
		statusreport.logger(costate);
		if (actualcostate.equalsIgnoreCase(costate))
		{
			statusreport.logger("CO Promoted to: "+actualcostate+" state successfully");
			statusreport.screenshot("CO promoted to "+actualcostate+"state.jpg");
		}
		else
		{
			statusreport.logger("CO promote failed");
			statusreport.screenshot("CO promote Failed.jpg");
		}
	}
	
	public void clickcontent() throws InterruptedException
	{
		statusreport = new ReportFunctions(driver);
		Content.click();
		statusreport.logger("Clicked on Content category");
		Thread.sleep(1000);
	}
	
	public void clickcaname()
	{
		statusreport = new ReportFunctions(driver);
		CAname.click();
		statusreport.logger("Clicked on CA Name");
	}
	
	public void switchtodefaultframe()
	{
		statusreport = new ReportFunctions(driver);
		driver.switchTo().defaultContent();
		statusreport.logger("Switch to default frame on CO page");
	}
	
	public void checkcopageload()
	{
		statusreport = new ReportFunctions(driver);
		String coheader = COheader.getText();
		if (coheader.equalsIgnoreCase("Change Order"))
		{
			statusreport.logger("CO page is loaded");
		}
		else
		{
			statusreport.logger("CO page is load failed");
		}	
	}
	
	public void switchtoframeforapprovals()
	{
		statusreport = new ReportFunctions(driver);
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ECMLifecycle");
		driver.switchTo().frame("portalDisplay");
		
		statusreport.logger("Frame switched");
	}
	
	public void clickonapprovaltab() throws InterruptedException
	{
		statusreport = new ReportFunctions(driver);
		Approvalstab.click();
		Thread.sleep(1000);
		statusreport.logger("Clicked on Approval tab");
	}
	
	public void switchframefortaskapproval()
	{
		statusreport = new ReportFunctions(driver);
		driver.switchTo().defaultContent();
				
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ECMLifecycle");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("AEFLifecycleApprovals");
		
		driver.switchTo().frame("listDisplay");
		statusreport.logger("Frame switched");
	}
	
	public void clickontasknumberforapprove()
	{
		statusreport = new ReportFunctions(driver);
		js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", task);
		task.click();
		statusreport.logger("Clicked on Task");
	}
	

}
