package StepDefination;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import PageObjects.HomePage;
import PageObjects.CAContentPage;
import PageObjects.CApropertiespage;
import PageObjects.COpropertiespage;
import PageObjects.CreateCO;
import PageObjects.CreatePart;
import PageObjects.Login;
import PageObjects.Messagedetailspage;
import PageObjects.Notificationandapprovalpage;
import PageObjects.PartEBOMPage;
import PageObjects.Partchangemanagementpage;
import PageObjects.SetCredentials;
import PageObjects.Taskapprovalpage;

public class Sanity01 {

	static WebDriver driver;
	public static WebDriverWait wait;
	public static List<WebElement> List;
	
	public Login log;
	public SetCredentials setcreds;
	public CreatePart part;
	public ReportFunctions statusreport;
	public HomePage home;
	public PartEBOMPage partproperty;
	public ReadExcel excel;
	public CreateCO co;
	public Partchangemanagementpage chngmgntmnt;
	public COpropertiespage content;
	public CApropertiespage capage;
	public CAContentPage cacontent;
	public Notificationandapprovalpage mails;
	public Messagedetailspage maildetails;
	public Taskapprovalpage task;
	
	@Before
	public void beforeexecution()
	{
		statusreport = new ReportFunctions(driver);
		
		statusreport.logger("Execution started");
	}
	
	@Given("^Experience url is Open$")
	public void experience_url_is_Open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	    
		System.setProperty("webdriver.gecko.driver",(".//Drivers/geckodriver.exe"));
		driver = new FirefoxDriver();
		driver.get("https://ootb19x.processia2003.com/3dspace/");
		driver.manage().window().maximize();
		
		//log = new Login(driver);
	
	}

	@When("^experience logo is displayed$")
	public void experience_logo_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		log = new Login(driver);
		statusreport = new ReportFunctions(driver);
		
		log.checkforlogo();
	}


	@When("^Enter credentials in \"([^\"]*)\" and \"([^\"]*)\" and click on Login button$")
	public void enter_credentials_in_and_and_click_on_Login_button(String username, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		statusreport = new ReportFunctions(driver);
		log = new Login(driver);
		
		log.waitfor();
		
		log.setusername(username);
		log.setpassword(password);
		
		statusreport.screenshot( "Login Success.jpg" );
		
		log.clicklogin();
		
		statusreport.logger("Wait Time Started");
		Thread.sleep(40000);
			    //throw new PendingException();
		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		statusreport.logger("Wait Time Ended");
	   	}
	

	@Then("^Verify Login is success$")
	public void verify_Login_is_success() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		
		home = new HomePage(driver);
		
		home.loginsuccess();
	}

	@Then("^Click on Profile logo and update Credentials$")
	public void click_on_Profile_logo_and_update_Credentials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		home = new HomePage(driver);
		setcreds = new SetCredentials(driver);
		
		home.accesstopmenubar("profile", "alt");
		
		String menu = "My Credentials";
		
			home.accesstopprofilemenu("topbar-menu-dd responsive-dropdown-menu profile",menu);
			
			WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='wrap-outer popup-dialog  sign-in security-context']")));
			
			setcreds.updateorganization();
			setcreds.updatecollabspac();
			setcreds.updaterole();
			setcreds.okclick();
			
	}

	@Then("^Verify Credentials are updated for user$")
	public void verify_Credentials_are_updated_for_user() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		statusreport = new ReportFunctions(driver);
		
		if (driver.findElement(By.xpath("//div[@class ='topbar-menu']")).isDisplayed())
		{
			System.out.println("Credentials Updated");
			statusreport.screenshot( "Credentials updated.jpg" );
			statusreport.logger("Credentials updated");
			
		}
		else
		{
			System.out.println("Credentials update Failed");
			statusreport.screenshot( "Credentials update Failed.jpg" );
			statusreport.logger("Credentials update Failed");
		}
		
	}

	@Given("^User login to (\\d+)DExperience$")
	public void user_login_to_DExperience(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		home = new HomePage(driver);
		
		home.hidepanel();
	}

	@When("^Click on Add button and Navigate to Engineering, Part, Create Part$")
	public void click_on_Add_button_and_Navigate_to_Engineering_Part_Create_Part() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		home = new HomePage(driver);
		
		wait = new WebDriverWait(driver, 60);// 1 minute
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='topbar-menu']")));
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		System.out.println("50");
		
		home.accesstopmenubar("add topbar", "plus");
		home.accesstopplusemenu("Engineering","Part","Create Part");
		
	}
	
	@When("^Enter details in Mandatory fields on create Part page$")
	public void enter_details_in_Mandatory_fields_on_create_Part_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		statusreport = new ReportFunctions(driver);
		part = new CreatePart(driver);
		part.waitfor();
		part.createpart();
	}

	@When("^Click on Ok button$")
	public void click_on_Ok_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		part = new CreatePart(driver);
		part.clickok();
		driver.switchTo().parentFrame();
	}

	@Then("^Verify Part is Created successfully$")
	public void verify_Part_is_Created_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		statusreport = new ReportFunctions(driver);
		excel = new ReadExcel();
		partproperty = new PartEBOMPage(driver);
		
		Thread.sleep(20000);
		
		partproperty.createpartstatus();
		
		
	}
	
	@Given("^Parent part is created and properties page is open$")
	public void parent_part_is_created_and_properties_page_is_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		partproperty = new PartEBOMPage(driver);
		
		partproperty.visibilityofpartpropertypage();
	
	}

	@Given("^navigate to categories EBOM$")
	public void navigate_to_categories_EBOM() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		
		partproperty = new PartEBOMPage(driver);
		
		Thread.sleep(5000);
		partproperty.ebom();
		Thread.sleep(10000);
		partproperty.ENCBOMframe();
		
		
		partproperty.visibilityofebompage();
		
		
	}
	
	@Given("^click on Insert Part Button, Insert as child New part$")
	public void click_on_Insert_Part_Button_Insert_as_child_New_part() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
			
		
		partproperty = new PartEBOMPage(driver);
		
		Thread.sleep(5000);
		//partproperty.clickonediticon();
		partproperty.clickdisplaymodeicon();
		partproperty.selecttableview();
		Thread.sleep(1000);
		partproperty.clickcheckboxtoenterchildpart();
		partproperty.clickonInsertparticon();
		partproperty.selectinsertpart();
		
		partproperty.switchtodefault();
		
				
		Thread.sleep(1000);
		
		
	}

	@Given("^enter details in mandatory fields$")
	public void enter_details_in_mandatory_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		part = new CreatePart(driver);
				
		part.createpart();
	}

	@Given("^click on OK button$")
	public void click_on_OK_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		part = new CreatePart(driver);
		
		part.clickok();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	}

	@Then("^verify part is created successfully under parent part$")
	public void verify_part_is_created_successfully_under_parent_part() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		partproperty = new PartEBOMPage(driver);
		statusreport = new ReportFunctions(driver);
		excel = new ReadExcel();
		partproperty.ENCBOMframe();
		partproperty.visibilityofchildpart();
		
	}

	//@Given("^part properties EBOM category page is open$")
	//public void part_properties_EBOM_category_page_is_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	//}

	@When("^select all part checkbox, click on Change, Change Order, Add To New$")
	public void select_all_part_checkbox_click_on_Change_Change_Order_Add_To_New() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		partproperty = new PartEBOMPage(driver);
		
		//partproperty.ENCBOMframe();
		partproperty.clickcheckboxtoenterchildpart();
		partproperty.clickcheckboxtoenterchildpart();
		partproperty.clickonchangeicon();
		partproperty.clicknewchangeorder();
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	
		
	}

	@When("^Enter mandatory fields on change order page$")
	public void enter_mandatory_fields_on_change_order_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		
		co = new CreateCO(driver);
		
		co.waitforsideframe();
		co.createco();
		co.clickok();
		
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
	}

	@Then("^navigate to categories Change management$")
	public void navigate_to_categories_Change_management() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		chngmgntmnt = new Partchangemanagementpage(driver);
		
		chngmgntmnt.clickchngmngmntctgry();
		
	}

	@Then("^Verify Change Order is created successfully$")
	public void verify_Change_Order_is_created_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new PendingException();
		
		chngmgntmnt = new Partchangemanagementpage(driver);
		statusreport = new ReportFunctions(driver);
	
		chngmgntmnt.navigatetoframe();
		chngmgntmnt.iscodisplayed();
		statusreport.screenshot("CO Created successfully.jpg");
	}

	//("^Change management page is open$")
	//public void change_management_page_is_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		
		
		//chngmgntmnt = new Partchangemanagementpage(driver);
			
		//chngmgntmnt.openco();
		//Thread.sleep(2000);
	//}

	@When("^click on Change order name$")
	public void click_on_Change_order_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		chngmgntmnt = new Partchangemanagementpage(driver);
		
		chngmgntmnt.openco();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
	}

	//@Then("^verify all selected part is added under Content, Proposed Change\\.$")
	//public void verify_all_selected_part_is_added_under_Content_Proposed_Change() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		//content = new COpropertiespage(driver);
		//content.switchframe();
		//content.verifyconumber();
		//driver.switchTo().defaultContent();
				
//	}

	@Then("^navigate to categories, CO name$")
	public void navigate_to_categories_CO_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		
		content = new COpropertiespage(driver);
		
		content.clickconumber();
		
	}

	@Then("^click on Edit and added Approver List$")
	public void click_on_Edit_and_added_Approver_List() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		content = new COpropertiespage(driver);
		
		content.switchframeonpropertiespage();
		content.clickeditbutton();
		
		content.clickonapprovallistbutton();
		
		
		}

	@Then("^Click on Done button$")
	public void click_on_Done_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		content = new COpropertiespage(driver);
		content.clickondone();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}

	@Then("^Promote CO to In Work state$")
	public void promote_CO_to_In_Work_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		
		content = new COpropertiespage(driver);
		statusreport = new ReportFunctions(driver);
		
		content.switchframeonlifecycle();
		content.promoteco();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		content.switchframeonpropertiespage();
		
		content.getcostate("In Work ");
		
		
	}

	@Then("^validate the Approval list is added$")
	public void validate_the_Approval_list_is_added() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^change order page is open$")
	public void change_order_page_is_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^navigate to Categories, Content$")
	public void navigate_to_Categories_Content() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		content = new COpropertiespage(driver);
		driver.switchTo().defaultContent();
		content.clickcontent();
		Thread.sleep(2000);
		
	}

	@When("^click on CA name under Related Change Action$")
	public void click_on_CA_name_under_Related_Change_Action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
	content = new COpropertiespage(driver);
		
		content.switchframe();
		content.clickcaname();
		Thread.sleep(1000);
	}

	@When("^navigate to categories , CA Name$")
	public void navigate_to_categories_CA_Name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   //throw new PendingException();
		
		capage = new CApropertiespage(driver);	
		driver.switchTo().defaultContent();
		capage.clickcaname();
		Thread.sleep(1000);
	}

	@When("^click on Edit and add reviewer$")
	public void click_on_Edit_and_add_reviewer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		capage = new CApropertiespage(driver);
		
		capage.switchframespropertiespage();
		capage.clickediticon();
		Thread.sleep(1000);
		capage.clickaddpeoplelink();
		Thread.sleep(2500);
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		capage.globalsearch();
		Thread.sleep(7000);
		capage.selectreviewer();
		
		capage.clickonOK();
		Thread.sleep(4000);
	}

	@When("^Click on Done$")
	public void click_on_Done() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		capage = new CApropertiespage(driver);
		capage.switchframespropertiespage();
		capage.clickondone();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
	}

	@When("^Promote CA to In work state\\.$")
	public void promote_CA_to_In_work_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		
		capage = new CApropertiespage(driver);
		
		capage.switchframelifecycle();
		capage.clickpromote();
		Thread.sleep(5000);
	}

	@Then("^validate CA is promoted to Inwork state$")
	public void validate_CA_is_promoted_to_Inwork_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		capage = new CApropertiespage(driver);
		statusreport = new ReportFunctions(driver);
		capage.switchtodefault();
		Thread.sleep(1000);
		capage.switchframespropertiespage();
		
		capage.getcastate("In Work ");
		
		capage.switchtodefault();
	}

	
	@When("^Select all parts check box$")
	public void select_all_parts_check_box() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		cacontent = new CAContentPage(driver);
		Thread.sleep(2000);
		
		cacontent.switchframescontentpage();
		cacontent.selectallparts();
	}

	@When("^Click Tools- Mass Promote$")
	public void click_Tools_Mass_Promote() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		cacontent = new CAContentPage(driver);
		
		cacontent.clicktoolsicon();
		cacontent.clickmasspromote();
		Thread.sleep(5000);
	}

	@Then("^Verify all parts are promotes to Frozen state$")
	public void verify_all_parts_are_promotes_to_Frozen_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Close - Success message displayed$")
	public void close_Success_message_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new PendingException();
		cacontent = new CAContentPage(driver);
		statusreport = new ReportFunctions(driver);
		
		statusreport.screenshot("Mass Promote success.jpg");
		cacontent.clickclosebutton();
		
	}
	
	@Given("^Navigate to CA properties page$")
	public void Navigate_to_CA_properties_page() throws Throwable{
		
		capage = new CApropertiespage(driver);	
		driver.switchTo().defaultContent();
		capage.clickcaname();
		Thread.sleep(2000);
	}
	
	@Given("^Click on Promote$")
	public void click_on_Promote() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		
		capage = new CApropertiespage(driver);
		
		capage.switchframelifecycle();
		capage.clickpromote();
		Thread.sleep(8000);
		capage.switchtodefault();
	}

	@Then("^verify CA is promoted to In Approval state$")
	public void verify_CA_is_promoted_to_In_Approval_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		capage = new CApropertiespage(driver);
		statusreport = new ReportFunctions(driver);
		
		capage.switchframespropertiespage();
		
		capage.getcastate("In Approval ");
		
	}

	@When("^navigate to Messages \\(Icon\\)$")
	public void navigate_to_Messages_Icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		home = new HomePage(driver);
		
		home.switchtodefault();
		home.getparentwindow();
		home.clickonnotification();
		Thread.sleep(5000);
		home.switchwindows("Switched to Notification window");
			
		
	}

	@When("^Click on New Task Assignment Notice$")
	public void click_on_New_Task_Assignment_Notice() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // new PendingException();
		
		statusreport = new ReportFunctions(driver);
		home = new HomePage(driver);
		// Perform the actions on new window
		
		mails = new Notificationandapprovalpage(driver);
		
		String window = driver.getWindowHandle();
		statusreport.logger("Current window handle is:"+window);
		mails.switchframe();
		
		Thread.sleep(4000);
		mails.clicknewtaskassign();
		Thread.sleep(4000);
	home.switchwindows("Window switched to message details page");
		
	}

	@When("^Click on Inbox Task IT-XXX no$")
	public void click_on_Inbox_Task_IT_XXX_no() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		home = new HomePage(driver);
		statusreport = new ReportFunctions(driver);
		
		Thread.sleep(1000);
		// Perform the actions on new window
		maildetails = new Messagedetailspage(driver);
		
		maildetails.switchframemessagedetailspage();
		Thread.sleep(1000);
		maildetails.TaskID();
		Thread.sleep(4000);
		home.switchwindows("switched to task approval window");
		
	}

	@When("^Click on Approve button from tool bar$")
	public void click_on_Approve_button_from_tool_bar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		
		statusreport = new ReportFunctions(driver);
		// Perform the click operation that opens new window

		// Switch to new window opened
		

		// Perform the actions on new window
		task = new Taskapprovalpage(driver);
		
		task.switchframeonapprovalpage();
		task.clickonapproval();
		
		task.switchtodefault();
		Thread.sleep(5000);
	
	}
	

	@When("^enter comments and click on Approve button$")
	public void enter_comments_and_click_on_Approve_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		
		statusreport = new ReportFunctions(driver);

		task = new Taskapprovalpage(driver);
		
		task.switchtocommentframe();
		task.enterapprovalcomment();
		task.clickapprovebutton();
		Thread.sleep(6000);
		task.switchtodefault();
		Thread.sleep(1000);
		task.switchframeonapprovalpage();
		
	}

	@When("^Close the window and refresh CA page$")
	public void close_the_window_and_refresh_CA_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		
		statusreport = new ReportFunctions(driver);

		task = new Taskapprovalpage(driver);
		home = new HomePage(driver);
		
		task.checkapprovalstatus("Approved ");
		
			
		home.closecurrentwindow();
		home.closecurrentwindow();
		home.closecurrentwindow();
		
		    home.clickrefreshbutton();
		    Thread.sleep(8000);
		    
		 
	}

	@Then("^verify CA is promoted to Approved state$")
	public void verify_CA_is_promoted_to_Approved_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		capage = new CApropertiespage(driver);
		statusreport = new ReportFunctions(driver);
		
		capage.switchframespropertiespage();
		
		capage.getcastate("Approved ");
		
	}

	@Given("^click on CO name from CA properties page$")
	public void click_on_CO_name_from_CA_properties_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		capage = new CApropertiespage(driver);
		statusreport = new ReportFunctions(driver);
		
			
		capage.clickconumber();
		Thread.sleep(7000);
		
	}

	@Then("^verify CO page is open$")
	public void verify_CO_page_is_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		content = new COpropertiespage(driver);
		statusreport = new ReportFunctions(driver);
		
		content.switchtodefaultframe();
		content.checkcopageload();
		
	}

	@Then("^click on CO name from Categories, Properties page display$")
	public void click_on_CO_name_from_Categories_Properties_page_display() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		content = new COpropertiespage(driver);
		
		content.clickconumber();
		Thread.sleep(5000);
	}

	@Then("^Click on Approvals then click on task ID$")
	public void click_on_Approvals_then_click_on_task_ID() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		content = new COpropertiespage(driver);
		
		content.switchtoframeforapprovals();
		content.clickonapprovaltab();
		Thread.sleep(3000);
		content.switchframefortaskapproval();
		content.clickontasknumberforapprove();
		Thread.sleep(6000);
		
	}

	@Then("^click on Approve from tool bar$")
	public void click_on_Approve_from_tool_bar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new PendingException();
		
		home = new HomePage(driver);
		home.switchwindows("Switched to approval page");
		Thread.sleep(2000);
		
		task = new Taskapprovalpage(driver);
		
		task.switchframeonapprovalpage();
		task.clickonapproval();
		Thread.sleep(4000);
		
		task.switchtodefault();
		Thread.sleep(5000);
		
	}

	@Then("^enter comments, click on Approve$")
	public void enter_comments_click_on_Approve() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		

		task = new Taskapprovalpage(driver);
		task.switchtocommentframe();
		task.enterapprovalcomment();
		task.clickapprovebutton();
		Thread.sleep(7000);
	}

	@Then("^close the window$")
	public void close_the_window() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		statusreport = new ReportFunctions(driver);
		task = new Taskapprovalpage(driver);
		task.switchtodefault();
		task.switchframeonapprovalpage();
		task.checkapprovalstatus("Approved ");
		
			
		home = new HomePage(driver);
		
		home.closecurrentwindow();
		Thread.sleep(2000);
		
	}

	@Then("^verify CO is promoted to Complete state Automatically$")
	public void verify_CO_is_promoted_to_Complete_state_Automatically() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		
		home = new HomePage(driver);
		driver.switchTo().defaultContent();
		 home.clickrefreshbutton();
		    Thread.sleep(8000);
		    
		    content = new COpropertiespage(driver);
			statusreport = new ReportFunctions(driver);
			
			
			//driver.switchTo().defaultContent();
			Thread.sleep(2000);
			content.switchframeonpropertiespage();
			
			content.getcostate("Complete ");
			
	}

	@Given("^navigate to categories, content$")
	public void navigate_to_categories_content() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		
		content = new COpropertiespage(driver);
		driver.switchTo().defaultContent();
		content.clickcontent();
		Thread.sleep(2000);
		
	}

	@Given("^click on CA$")
	public void click_on_CA() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
content = new COpropertiespage(driver);
		
		content.switchframe();
		content.clickcaname();
		Thread.sleep(1000);
		
	}

	@Then("^verify CA is promoted to Complete state and part are promoted to Released state\\.$")
	public void verify_CA_is_promoted_to_Complete_state_and_part_are_promoted_to_Released_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		
		capage = new CApropertiespage(driver);	
		driver.switchTo().defaultContent();
		capage.clickcaname();
		Thread.sleep(3000);

		capage = new CApropertiespage(driver);
		statusreport = new ReportFunctions(driver);
		
		capage.switchframespropertiespage();
		
		capage.getcastate("Complete ");
				
		driver.switchTo().defaultContent();
		
	}
	
	@Then("^Signout and close window$")
	public void signout_and_close_window() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		home = new HomePage(driver);
		
		home.accesstopmenubar("profile", "alt");
		
		String menu = "Sign Out";
		
			home.accesstopprofilemenu("topbar-menu-dd responsive-dropdown-menu profile",menu);
			Thread.sleep(1000);
			System.out.println("Signed Out successfully");
			//driver.close();
			//System.out.println("Browser Closed");
	}

	
	@After
	public void scenariostatus(Scenario scenario) throws InterruptedException {
		statusreport = new ReportFunctions(driver);
	if (scenario.isFailed())
	{
		final byte[] screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	scenario.embed(screen, "image/png");		
	}
	else
	{
		final byte[] screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screen, "image/png");	
	}
}
}
