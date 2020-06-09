package StepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.HomePage;
import PageObjects.Login;

public class Test {

	 ReportFunctions statusreport;
	 WebDriverWait wait;
	 WebDriver driver;
	 Login log;
	 HomePage home;
	
	@FindBy(xpath="//input[@class='sn-search-field uwa-autocomplete nv-autocomplete-input']")
	
	WebElement Globalsearchtextbox;
	
	@FindBy(xpath="//div[@class='run_btn_search fonticon fonticon-search']")
	
	WebElement globalsearchicon;
	
	@FindBy(xpath="//div[@class='wux-controls-abstract wux-layouts-collectionview-cell wux-cell-responsivetile-large-allow' and @is-visible='true']//*[@search-item-predicate-value='CA-48851417-00000078'][1]")
	
	WebElement CAnumber;
	
	@FindBy(xpath="//span[@class='item-text' and contains(text(),'Display detail')]")
	
	WebElement Displaydetails;
	
	public  Test(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	public  void rightclickcano() throws InterruptedException
	{
		
		Actions actions = new Actions(driver);
		
		actions.contextClick(CAnumber).perform();
		
		Displaydetails.click();
		Thread.sleep(5000);
	}
	
	
	
	public  void globalsearch() throws InterruptedException
	{
		statusreport = new ReportFunctions(driver);
		//wait = new WebDriverWait(driver,60);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tn-header-title']")));
		
		Globalsearchtextbox.click();
		Globalsearchtextbox.sendKeys("CA-48851417-00000078");
		System.out.println("search item entered");
		globalsearchicon.click();
		statusreport.logger("clicked on global search button");
		Thread.sleep(5000);
	}
	
	public   void launchbrowser() throws InterruptedException
	{
		//System.setProperty("webdriver.gecko.driver",(".//Drivers/geckodriver.exe"));
		//driver = new FirefoxDriver();
		//driver.get("https://ootb19x.processia2003.com/3dspace/");
		//driver.manage().window().maximize();
		
		//log = new Login(driver);
		
		statusreport = new ReportFunctions(driver);
		
		String ExpTitle = "3DPassport - Login";
		String title = log.gettitle();
		System.out.println(title);
				Assert.assertEquals(ExpTitle, title);
		//statusreport.screenshot(driver, "logo.jpg");
		System.out.println("Login page is displayed");
		
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		log.setusername("admin_platform");
		log.setpassword("enoviaV6");
		
		//statusreport.screenshot( "Login Success.jpg" );
		
		log.clicklogin();
		
		System.out.println("Wait Time Started");
		Thread.sleep(40000);
			    //throw new PendingException();
		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		System.out.println("Wait Time Ended");
		
		
	}
	
	public  void approvetask() throws InterruptedException
	{
home = new HomePage(driver);
		
		home.switchtodefault();
		home.getparentwindow();
		home.clickonnotification();
		Thread.sleep(5000);
		home.switchtonotificationwindow();	
	}
	
	
	

}
