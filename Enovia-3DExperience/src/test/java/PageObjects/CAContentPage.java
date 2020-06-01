package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefination.ReadExcel;

public class CAContentPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public ReadExcel read;
	
	public  CAContentPage(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	@FindBy(xpath="//input[@name='chkList']")
	WebElement selectallcheckbox;
	
	@FindBy(xpath="/html/body/form[1]/div[1]/div[1]/div/div[2]/table/tbody/tr/td[9]")
	WebElement toolsicon;
	
	@FindBy(xpath="/html/body/div[5]/div/ul/li[7]/a/label")
	WebElement masspromote;
	
	@FindBy(xpath="//button[@class='btn-primary']")
	WebElement Closebutton;
	
	public void switchframescontentpage()
	{
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ECM3DAffectedItemsCA");
	}
	
		public void selectallparts()
	{
		selectallcheckbox.click();
		System.out.println("Select all checkbox clicked");
	}
	
	public void clicktoolsicon()
	{
		toolsicon.click();
		System.out.println("Tools Icon clicked");
	}
	
	public void clickmasspromote()
	{
		masspromote.click();
		System.out.println("Clicked on Mass Promote");
	}
	
	public void clickclosebutton()
	{
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		Closebutton.click();
		System.out.println("Window is closed");
		
		
		// Close the new window, if that window no more required
		//driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
	}
}
