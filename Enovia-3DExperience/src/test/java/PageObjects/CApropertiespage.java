package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefination.ReadExcel;
import StepDefination.ReportFunctions;

public class CApropertiespage {

	WebDriver driver;
	WebDriverWait wait;
	
	public ReadExcel read;
	public ReportFunctions statusreport;
	
	public  CApropertiespage(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	@FindBy(xpath="//li[@name='li_type_ChangeAction']")
	WebElement caname;
	
	@FindBy(xpath="//td[@id='ECMCAEditDetails']")
	WebElement editicon;
	
	@FindBy(xpath="//div[@id='ReviewrHidePerson']")
	WebElement addreviewpeople;
	
	@FindBy(xpath="//input[@class='sn-search-field uwa-autocomplete nv-autocomplete-input']")
	WebElement Globalsearchtextbox;
	
	@FindBy(xpath="//div[@class='run_btn_search fonticon fonticon-search']")
	WebElement globalsearchicon;
	
	@FindBy(xpath="//div[@class='wux-controls-abstract wux-layouts-collectionview-cell wux-cell-responsivetile-large-allow' and @is-visible='true']//*[@search-item-predicate-value='Admin Platform']")
	WebElement admin_platform;
	
	@FindBy(xpath="//button[@id='id_in_app_ok']")
	WebElement okbutton;
	
	@FindBy(xpath="//button[@class='btn-primary']")
	WebElement donebutton;
	
	@FindBy(xpath="//td[@id='AEFLifecyclePromote']")
	WebElement promote;
	
	@FindBy(xpath="//tr[@id='calc_State']//td[@class='field'][1]")
	WebElement state;
	
	@FindBy(xpath="//input[@name='chkList']")
	WebElement selectallcheckbox;
	
	@FindBy(xpath="//a[contains(text(),'CO-')]")
	WebElement COnumber;
	
	public void switchframespropertiespage()
	{
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ECMCAProperties");
	}
	
	public void clickcaname() throws InterruptedException
	{
		statusreport = new ReportFunctions(driver);
		caname.click();
		Thread.sleep(1000);
		statusreport.logger("Clicked on CA name");
	}
	
	public void clickediticon()
	{
		statusreport = new ReportFunctions(driver);
		editicon.click();
		statusreport.logger("Clicked on Edit icon");
	}
	
	public void clickaddpeoplelink() throws InterruptedException
	{
		statusreport = new ReportFunctions(driver);
		addreviewpeople.click();
		Thread.sleep(1000);
		statusreport.logger("Clicked on add people link");
	}
	
	public void globalsearch()
	{
		statusreport = new ReportFunctions(driver);
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tn-header-title']")));
		
		Globalsearchtextbox.click();
		Globalsearchtextbox.sendKeys("Admin_Platform");
		System.out.println("search item entered");
		globalsearchicon.click();
		statusreport.logger("clicked on global search button");
	}
	public void selectreviewer()
	{
		statusreport = new ReportFunctions(driver);
		admin_platform.click();
		statusreport.logger("Reviewer selected");
	}
	
	public void clickonOK()
	{
		statusreport = new ReportFunctions(driver);
		okbutton.click();
		statusreport.logger("Clicked on ok button");
	}
	
	public void clickondone()
	{
		statusreport = new ReportFunctions(driver);
		donebutton.click();
		statusreport.logger("Clicked on Done button on CA page");
	}
	
	public void clickpromote()
	{
		statusreport = new ReportFunctions(driver);
		promote.click();
		statusreport.logger("Clicked on Promote button");
	}
	
	public void switchframelifecycle()
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
	
	public void getcastate(String castate) throws IOException
	{
		statusreport = new ReportFunctions(driver);
		String actualcastate = state.getText();
		statusreport.logger(actualcastate);

		if (actualcastate.equalsIgnoreCase(castate))
		{
			System.out.println("CA Promoted to: "+actualcastate+" state successfully");
			statusreport.screenshot( "CA promote to "+actualcastate+" state success.jpg");
		}
		else
		{
			System.out.println("CA promote failed");
			statusreport.screenshot("CA promote to Inwork state Failed.jpg");
		}
	}
	
	public void switchtodefault()
	{
		statusreport = new ReportFunctions(driver);
		driver.switchTo().defaultContent();
		statusreport.logger("Moved to default content");
	}
	
	public void clickconumber()
	{
		statusreport = new ReportFunctions(driver);
		COnumber.click();
		statusreport.logger("Clicked on CO number");
	}
}
