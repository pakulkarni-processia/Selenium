package PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	List<WebElement> List;
	
	public  HomePage(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	@FindBy(xpath="//img[@class ='hide']")
	WebElement hidepanel;
	
	@FindBy(xpath="//div[@class='topbar-menu']")
	WebElement topbarmenu;
	
	public String loginsuccess()
	{
		if(topbarmenu.isDisplayed())
		{
			return "True";
		}
		else 
		{
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
	

	}
	

