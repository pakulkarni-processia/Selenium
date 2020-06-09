package PageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefination.ReportFunctions;

public class HomePage {

	
	public String parentwindow;
	public ArrayList<String> windowlist; 
	public int windowcount;
	public Set<String> windowhandles;
	
	WebDriver driver;
	List<WebElement> List;
	ReportFunctions statusreport;
	
	Notificationandapprovalpage approve;
	Taskapprovalpage task;
	
	public  HomePage(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	@FindBy(xpath="//img[@class ='hide']")
	WebElement hidepanel;
	
	@FindBy(xpath="//div[@class='topbar-menu']")
	WebElement topbarmenu;
	
	@FindBy(xpath="//div[@class='notifications-counter']")
	WebElement notification;
	
	@FindBy(xpath="//button[@class='refresh']")
	WebElement refreshbutton;
	
	public String loginsuccess()
	{
		statusreport = new ReportFunctions(driver);
		
		if(topbarmenu.isDisplayed())
		{
			statusreport.logger("Topmenu bar displayed");
			return "True";
		}
		else 
		{
			statusreport.logger("Topmenu bar not displayed");
			return "False";
		}
	}
	
	public void hidepanel()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute
		driver.switchTo().frame("content");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='right']")));
		
					hidepanel.click();
				System.out.println("Hide button clicked");
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				driver.switchTo().parentFrame();
				System.out.println("Switched to Parent Frame");
		
	}

		
	public void accesstopmenubar(String beginname, String endname)
	{
		List = driver.findElements(By.xpath("//div[@class ='topbar-menu']"));
		String name= null;
		try 
		{
			int totalcount = List.size();
			System.out.println(totalcount);
			System.out.println(List);
			
			for (int i=0; i<totalcount; i++)
			{
				WebElement element=List.get(i);
				String text = element.getAttribute("innerHTML");
				System.out.println(text);
				int begin = text.indexOf(beginname);
				String temp=text.substring(begin, text.length()-1);
				
							
				int end = temp.indexOf(endname);
				
				begin = 0;
				System.out.println(end);
				name = temp.substring(begin, end+endname.length());
				
				System.out.println(name);
				
				break;
			}
			
			WebElement profile = driver.findElement(By.xpath("//div[@class='"+name+"']"));
			System.out.println(profile.getTagName());
			profile.click();
			
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	public void accesstopprofilemenu(String classname, String menuname)
	
	{
		 
		Actions action = new Actions(driver);
				
		List<WebElement> profilelist = driver.findElements(By.xpath("//div[@class ='"+classname+"']"));
		int pluscount = List.size();
		System.out.println("profilecount="+profilelist);
		for (int i=0; i<pluscount; i++)
		{
			WebElement element=profilelist.get(i);
			String text = element.getAttribute("innerHTML");
			System.out.println(text);
			
		
				if (text.contains(menuname))
			{
				System.out.println("Credentials Found");
				
				WebElement Credentials = driver.findElement(By.xpath("//span[text()='"+menuname+"']"));
				System.out.println(Credentials+"Found");
				action.moveToElement(Credentials).build().perform();
				
				System.out.println("Mouse Moved"+Credentials);
				action.click().perform();
				System.out.println("Clicked"+Credentials);
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				
			}
					
			break;
					
		}
	}
	
	public void accesstopplusemenu( String level1, String level2, String level3)
	{
		
		Actions action = new Actions(driver);
		
		
		List<WebElement> pluslist = driver.findElements(By.xpath("//div[@class ='topbar-menu-dd responsive-dropdown-menu add']"));
		int pluscount = List.size();
		System.out.println("pluscount="+pluscount);
		for (int i=0; i<pluscount; i++)
		{
			WebElement element=pluslist.get(i);
			String text = element.getAttribute("innerHTML");
			System.out.println(text);
			//int begin = text.indexOf("add topbar");
			if (text.contains(level1))
			{
				System.out.println(level1+"Found");
				//WebElement Engineering = driver.findElement(By.xpath("//id[contains(text(),'c336')]"));
				WebElement Level1 = driver.findElement(By.xpath("//span[text()='"+level1+"']"));
				System.out.println(Level1+"Found");
				action.moveToElement(Level1).build().perform();
				action.moveByOffset(50, -10).build().perform();
				System.out.println("Mouse Moved"+Level1);
				
				
				WebElement Level2 = driver.findElement(By.xpath("//span[text()='"+level2+"']"));
				System.out.println(Level2+"Found");
				action.moveToElement(Level2).build().perform();
				action.moveByOffset(30, -10).build().perform();
				System.out.println("Mouse Moved"+Level2);
				
				WebElement Level3 = driver.findElement(By.xpath("//span[text()='"+level3+"']"));
				System.out.println(Level3+"Found");
				action.moveToElement(Level3).build().perform();
				action.click().perform();
				//action.click(createpart).perform();
				System.out.println("Mouse Moved"+Level3);
			}
					
			break;
								}
	}
	
	public void clickonnotification()
	{
	notification.click();
	statusreport.logger("Clicked on Notification button");
	}

	public void getparentwindow()
	{
		statusreport = new ReportFunctions(driver);
		 parentwindow = driver.getWindowHandle();
		statusreport.logger("Parent window handle is:"+parentwindow);
	}
	
	@SuppressWarnings("unchecked")
	public void switchtonotificationwindow() throws InterruptedException
	{
		
		String parentwindow = driver.getWindowHandle();
			statusreport.logger("Parent window handle is:"+parentwindow);
		
		// Switch to new window opened
		Set<String>windowhandles = driver.getWindowHandles();
		 windowlist = new ArrayList(windowhandles);
		System.out.println(windowlist);
		//count the handles Here count is=2
		System.out.println("Count of windows:"+windowhandles.size()); 
		
		//Iterator<String> iterator = windowhandles.iterator();
		
		//while (iterator.hasNext())
		//{
		//String newwindow=iterator.next();
		for(String handle:windowhandles)
		{
		if (!parentwindow.equalsIgnoreCase(handle))
		{
			driver.switchTo().window(handle);
			statusreport.logger("Switched to Notifications window");
			break;
		}
		
		}
		
		approve = new Notificationandapprovalpage(driver);
		
		approve.navigateandapprovetask();


		
		for(String handle:windowhandles)
		{
		if (!parentwindow.equalsIgnoreCase(handle))
		{
			driver.switchTo().window(handle);
			statusreport.logger("Window switched:"+handle);
			driver.close();
			statusreport.logger("Window Closed:"+handle);
			driver.switchTo().window(parentwindow);
		}
		}
		
	}
	
	public void closecurrentwindow() throws InterruptedException
	{
		statusreport = new ReportFunctions(driver);
	
		windowhandles = driver.getWindowHandles();
		windowlist = new ArrayList<String>(windowhandles);
		windowcount = windowhandles.size();
		
		driver.switchTo().window(windowlist.get(windowcount-1));
			driver.close();
		    statusreport.logger("Window Closed");
		   Thread.sleep(2000);
					      		    
		    driver.switchTo().window(windowlist.get(windowcount-2));
		    statusreport.logger("Switched to next window:"+windowlist.get(windowcount-2));
		
		}
	
	public void switchtodefault()
	{
		statusreport = new ReportFunctions(driver);
		
		driver.switchTo().defaultContent();
		statusreport.logger("Switoched to default frame");
	}
	
	public void clickrefreshbutton()
	{
		statusreport = new ReportFunctions(driver);
		refreshbutton.click();
		statusreport.logger("Clicked on refresh button");
	}
	
	
	public void switchwindows(String message)
	{
		statusreport = new ReportFunctions(driver);
	String currentwindow = driver.getWindowHandle();
	statusreport.logger("Current window handle is:"+currentwindow);

	// Switch to new window opened
	windowhandles = driver.getWindowHandles();
	windowlist = new ArrayList<String>(windowhandles);
	System.out.println(windowlist);
	//count the handles Here count is=2
	windowcount = windowhandles.size();
	statusreport.logger("Count of windows:"+windowhandles.size()); 

	Iterator<String> iterator = windowhandles.iterator();
	
	while (iterator.hasNext())
	{
		String handle =iterator.next();
		if (!currentwindow.equalsIgnoreCase(handle))
		{
			driver.switchTo().window(windowlist.get(windowcount-1));
			statusreport.logger("Switched to window:"+windowlist.get(windowcount-1));
			String title = driver.getTitle();
			statusreport.logger("Current Window Title"+title);
			statusreport.logger(message);
	
		}
		statusreport.logger("Exited if condition");
	}
	statusreport.logger("Exited while loop");
	}
	
}
