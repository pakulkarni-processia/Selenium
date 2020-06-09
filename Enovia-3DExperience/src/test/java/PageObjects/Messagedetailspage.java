package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefination.ReportFunctions;

public class Messagedetailspage {

	WebDriver driver;
	List<WebElement> List;
	ReportFunctions statusreport;
	public String Fourthwindow;
	Taskapprovalpage task;
	
	public  Messagedetailspage(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	@FindBy(xpath="//a[contains (text(),'Task IT-')]")
	WebElement TaskID;
	
	public void switchframemessagedetailspage()
	{
		statusreport = new ReportFunctions(driver);
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("pagecontent");
		statusreport.logger("Frame switched on mail detail page");
	}
	
	public void TaskID()
	{
		statusreport = new ReportFunctions(driver);
		TaskID.click();
		statusreport.logger("Clicked on Task ID on mail details page");
	}
	
	public void switchtotaskapprovalwindow() throws InterruptedException
	{
		String winHandleBefore1 = driver.getWindowHandle();
		statusreport = new ReportFunctions(driver);
		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String windowhandles : driver.getWindowHandles()){
			System.out.println("Fourth window:"+windowhandles);
		    driver.switchTo().window(windowhandles);
		    statusreport.logger("switched to task approval window");
		}

		// Perform the actions on new window
		//task = new Taskapprovalpage(driver);
		
	//	task.switchframeonapprovalpage();
		//task.clickapprovebutton();
		
	//	task.switchtodefault();
		//Thread.sleep(3000);
		//task.switchtocommentframe();
		//task.enterapprovalcomment();
		//task.clickapprovebutton();
		//Thread.sleep(2000);
		//task.switchframeonapprovalpage();
		//task.checkapprovalstatus();
		
		
		
		// Close the new window, if that window no more required
		//driver.close();

		// Switch back to original browser (first window)
		//driver.switchTo().window(winHandleBefore);
		
	}
	
	public void closeapprovalwindow()
	{
		driver.getWindowHandles();
		 driver.switchTo().window(Fourthwindow);
		 driver.close();
		
	}
}
