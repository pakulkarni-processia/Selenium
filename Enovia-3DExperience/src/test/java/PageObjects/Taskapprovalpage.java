package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefination.ReportFunctions;

public class Taskapprovalpage {

	WebDriver driver;
	List<WebElement> List;
	ReportFunctions statusreport;
	 
	
	public  Taskapprovalpage(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	@FindBy(xpath="//td[@id='APPApproveTask']")
	WebElement approvalbutton;
	
	@FindBy(xpath="//textarea[@id='Comments']")
	WebElement commenttextbox;
	
	@FindBy(xpath="//button[@class='btn-primary']")
	WebElement approvebutton;
	
	@FindBy(xpath="//tr[@id='calc_ApprovalStatus']//td[@class='field'][1]")
	WebElement Approvalstatus;
	
	@FindBy(xpath="//tr[@id='calc_State']//td[@class='field'][1]")
	WebElement Approvedstatus;
	
	public void clickonapproval()
	{
		statusreport = new ReportFunctions(driver);
		approvalbutton.click();
		statusreport.logger("Clicked on Approval icon");
	}
	
	public void switchframeonapprovalpage()
	{
		statusreport = new ReportFunctions(driver);
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("APPInboxTaskProperties");
		statusreport.logger("Frame switched on task approval page");
	}
	
	public void switchtodefault()
	{
		statusreport = new ReportFunctions(driver);
		driver.switchTo().defaultContent();
		statusreport.logger("Switched to default content");
	}
	
	public void enterapprovalcomment()
	{
		statusreport = new ReportFunctions(driver);
		commenttextbox.click();
		commenttextbox.sendKeys("Approved");
		statusreport.logger("Approval comments entered");
	}
	
	public void switchtocommentframe()
	{
		statusreport = new ReportFunctions(driver);
		driver.switchTo().frame("slideInFrame");
		statusreport.logger("Switched to frame on approval comment page");
	}
	
	public void clickapprovebutton()
	{
		statusreport = new ReportFunctions(driver);
		approvebutton.click();
		statusreport.logger("Approved button clicked");
	}
	
	public String checkapprovalstatus()
	{
		statusreport = new ReportFunctions(driver);
		String status = Approvalstatus.getText();
		statusreport.logger("Approval status is:"+status);
		return status;
		
	}
	
	public String checkapprovedstatus()
	{
		statusreport = new ReportFunctions(driver);
		String status = Approvedstatus.getText();
		statusreport.logger("Approval status is:"+status);
		return status;
		
	}
}
