package PageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefination.ReportFunctions;



public class Notificationandapprovalpage {

	WebDriver driver;
	List<WebElement> List;
	ReportFunctions statusreport;
	Taskapprovalpage task;
	
	public  Notificationandapprovalpage(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	
	@FindBy(xpath="//a[contains (text(),'New Task Assignment Notice')]")
	WebElement newtaskassignmentnotice;
	
	@FindBy(xpath="//a[contains (text(),'Task IT-')]")
	WebElement TaskID;
	
	@FindBy(xpath="//td[@id='APPApproveTask']")
	WebElement approvalbutton;
	
	@FindBy(xpath="//textarea[@id='Comments']")
	WebElement commenttextbox;
	
	@FindBy(xpath="//button[@class='btn-primary']")
	WebElement approvebutton;
	
	@FindBy(xpath="//tr[@id='calc_ApprovalStatus']//td[@class='field'][1]")
	WebElement Approvalstatus;
	
	
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
	
	public void switchframe()
	{
		statusreport = new ReportFunctions(driver);
		statusreport.logger("Switching frame on notification page");
		driver.switchTo().frame("pagecontent");
		statusreport.logger("Frame switched on message list window");
	}
	
	public void clicknewtaskassign()
	{
		statusreport = new ReportFunctions(driver);
		newtaskassignmentnotice.click();
		statusreport.logger("Click on first occurance of new task assign");
	}
	
	public void navigateandapprovetask() throws InterruptedException
	{
		
		String notificationwindow;
		String maildetailswindow;
		String approvalpage;
		
		statusreport = new ReportFunctions(driver);
		 notificationwindow = driver.getWindowHandle();
		System.out.println("winHandleBefore:"+notificationwindow);

		
		switchframe();
		Thread.sleep(4000);
		clicknewtaskassign();
		Thread.sleep(4000);
		
		// Perform the click operation that opens new window
		Set<String>windowhandles = driver.getWindowHandles();
		ArrayList<String>	 windowlist = new ArrayList<String>(windowhandles);
		System.out.println(windowlist);
		//count the handles Here count is=2
		int count = windowhandles.size();
		System.out.println("Count of windows:"+windowhandles.size()); 
		// Switch to new window opened
		Iterator<String> iterator = windowhandles.iterator();
		
				while (iterator.hasNext())
				{
				 maildetailswindow=iterator.next();
				if (!notificationwindow.equalsIgnoreCase(maildetailswindow))
				{
			System.out.println("Second window:"+maildetailswindow);
		    driver.switchTo().window(windowlist.get(count-1));
		    statusreport.logger("Window switched to message details page");
		}
		Thread.sleep(1000);
		// Perform the actions on new window
		switchframemessagedetailspage();
		Thread.sleep(1000);
		TaskID();
		Thread.sleep(4000);
		
		windowhandles = driver.getWindowHandles();
		 windowlist = new ArrayList(windowhandles);
		System.out.println(windowlist);
		//count the handles Here count is=2
		count = windowhandles.size();
		System.out.println("Count of windows:"+windowhandles.size()); 
		// Switch to new window opened
		 iterator = windowhandles.iterator();
		
				while (iterator.hasNext())
				{
					approvalpage=iterator.next();
				if (!notificationwindow.equalsIgnoreCase(approvalpage)) 
				{
			System.out.println("Third window:"+approvalpage);
		    driver.switchTo().window(windowlist.get(count-1));
		    statusreport.logger("Window switched to approval page");
		}
		
		task = new Taskapprovalpage(driver);
		
		task.switchframeonapprovalpage();
		task.clickonapproval();
		
		task.switchtodefault();
		Thread.sleep(5000);
		
		task.switchtocommentframe();
		task.enterapprovalcomment();
		task.clickapprovebutton();
		Thread.sleep(6000);
		task.switchtodefault();
		Thread.sleep(1000);
		task.switchframeonapprovalpage();
		
		String status = task.checkapprovalstatus();
		
		if (status.equals("Approved "))
		{
			statusreport.logger("Status is Approved");
		}
		else
		{
			statusreport.logger("Status is not Approved");
		}	
		
		driver.close();
		driver.switchTo().window(maildetailswindow);
		
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(notificationwindow);
		
	}
	
}
	}
}
