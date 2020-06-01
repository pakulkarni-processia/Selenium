package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefination.ReadExcel;

public class CApropertiespage {

	WebDriver driver;
	WebDriverWait wait;
	
	public ReadExcel read;
	
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
	
	@FindBy(xpath="//span[@search-item-predicate-value='Admin Platform']")
	WebElement admin_platform;
	
	@FindBy(xpath="//button[@id='id_in_app_ok']")
	WebElement okbutton;
	
	@FindBy(xpath="//button[@class='btn-primary']")
	WebElement donebutton;
	
	@FindBy(xpath="//td[@id='AEFLifecyclePromote']")
	WebElement promote;
	
	@FindBy(xpath="/html/body/div[2]/form/table/tbody/tr[10]/td[2]")
	WebElement state;
	
	@FindBy(xpath="//input[@name='chkList']")
	WebElement selectallcheckbox;
	
	public void switchframespropertiespage()
	{
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ECMCAProperties");
	}
	
	public void clickcaname() throws InterruptedException
	{
		caname.click();
		Thread.sleep(1000);
	}
	
	public void clickediticon()
	{
		editicon.click();
		System.out.println("Clicked on Edit icon");
	}
	
	public void clickaddpeoplelink()
	{
		addreviewpeople.click();
		System.out.println("Clicked on add people link");
	}
	
	public void globalsearch()
	{
		Globalsearchtextbox.click();
		Globalsearchtextbox.sendKeys("Admin_Platform");
		System.out.println("search item entered");
		globalsearchicon.click();
		System.out.println("clicked on global search button");
	}
	public void selectreviewer()
	{
		admin_platform.click();
		System.out.println("Reviewer selected");
	}
	
	public void clickonOK()
	{
		okbutton.click();
		System.out.println("Clicked on ok button");
	}
	
	public void clickondone()
	{
		donebutton.click();
		System.out.println("Clicked on Done button on CA page");
	}
	
	public void clickpromote()
	{
		promote.click();
		System.out.println("Clicked on Promote button");
	}
	
	public void switchframelifecycle()
	{
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ECMLifecycle");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("AEFLifecycleBasic");
		System.out.println("Frame switched");
	}
	
	public String getcastate()
	{
		String castate = state.getText();
		System.out.println(castate);
		return castate;
	}
	
	
}
