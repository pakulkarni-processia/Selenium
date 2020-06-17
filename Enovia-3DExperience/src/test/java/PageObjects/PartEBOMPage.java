package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefination.ReadExcel;
import StepDefination.ReportFunctions;

public class PartEBOMPage {

	ReportFunctions statusreport;
	ReadExcel excel;
	WebDriver driver;
	WebDriverWait wait;
	List<WebElement> List;
	
	public  PartEBOMPage(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	@FindBy (xpath = "//div[@id ='ExtpageHeadDiv']")
	WebElement pagehead;
	
	@FindBy(xpath = "//li[@title='Engineering BOM']")
	WebElement ebom;
	
	@FindBy(xpath= "//td[@id='ENCIndentedBOMEditAll']")
	WebElement pencilicon;
	
	@FindBy(xpath="//input[@name='chkList']")
	WebElement partcheckbox;
	
	@FindBy(xpath="//td[@title='Insert Part']")
	WebElement insertparticon;
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/div[2]/ul/li[2]/a/label")
	WebElement Inserparttext;
	
	@FindBy(xpath = "/html/body/form[1]/div[2]/div[2]/div[2]/table/tbody/tr[3]/td[2]/div/table/tbody/tr/td[6]")
	WebElement firstchildpart;
	
	@FindBy(css="//*[@id=\"ApplyButton\"]")
	WebElement savebutton;
	
	@FindBy(xpath="//*[@id=\"displayModeMenu\"]")
	WebElement displaymodeicon;
	
	@FindBy(xpath="/html/body/div[11]/div/ul/li[1]/a/label")
	WebElement tableoption;

	@FindBy(xpath="//td[@title='Change']")
	WebElement changeicon;
	
	@FindBy(xpath="/html/body/div[5]/div/div[2]/div[2]/ul/li[2]/a/label")
	WebElement newchangeorder;
	
	public void  visibilityofpartpropertypage()
	{
		statusreport = new ReportFunctions(driver);
		if(pagehead.isDisplayed())
		{
			statusreport.logger("Part Properties page is open");
		}
		else 
		{
			statusreport.logger("Part Properties page is not open");
		}
	}
	
	public void visibilityofebompage()
	{
		
		if(pencilicon.isDisplayed())
		{
			statusreport.logger("EBOM Properties page is open");
		}
		else 
		{
			statusreport.logger("EBOM Properties page is not open");
		}
	}
	
	public String partnumber()
	{
	
		String Partnumber= null;
		if(pagehead.isDisplayed())
	{
	
		List = driver.findElements(By.xpath("//div[@id ='ExtpageHeadDiv']"));
		
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
				int begin = text.indexOf("Part");
				String temp=text.substring(begin, text.length()-1);
				
				int end = temp.indexOf("class");
				begin = 0;
				
				Partnumber = temp.substring(begin, end-2);
				
				System.out.println(Partnumber);
								
				break;
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return Partnumber;
	}
	
	public void ebom()
	{
		statusreport = new ReportFunctions(driver);
		ebom.click();
		statusreport.logger("clicked on BOM link");
	}
	
	public void clickonediticon()
	{
		statusreport = new ReportFunctions(driver);		
		pencilicon.click();
		statusreport.logger("Clicked on Pensil icon");
	}
	public void clickcheckboxtoenterchildpart() throws InterruptedException
	{
		statusreport = new ReportFunctions(driver);
		partcheckbox.click();
		Thread.sleep(1000);
		
		statusreport.logger("Clicked on child checkbox");
	}
	
	public void clickonInsertparticon()
	{
		statusreport = new ReportFunctions(driver);
		insertparticon.click();
		statusreport.logger("Clicked on Insert Part icon");
	}
	
	
	public void selectinsertpart()
	{
		statusreport = new ReportFunctions(driver);
		Inserparttext.click();
		statusreport.logger("Clicked on Insert Part text from menu");
	}
	
	public void visibilityofchildpart() throws IOException, InterruptedException
	{
		statusreport = new ReportFunctions(driver);
		if(firstchildpart.isDisplayed())
		{
			statusreport.logger("Child Part Created");
			String childpartno = firstchildpart.getText();
			
			excel.writeexcel("PartDetails",childpartno,2); 
			//driver.switchTo().defaultContent();
			Thread.sleep(2000);
			statusreport.screenshot( "Childpart inserted success.jpg");
			
		}
		else
		{
			statusreport.logger("Child Part Creation Failed");
			System.out.println("Child Part Create Failed");
			statusreport.screenshot( "Child Part Create Failed.jpg");
		}
		
	}
	
	public void clickonsavebutton()
	{
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(savebutton)).click();
	}
	
	public void ENCBOMframe()
	{
		statusreport = new ReportFunctions(driver);
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ENCBOM");
		statusreport.logger("Frame Switched");
	}
	
	public void clickdisplaymodeicon()
	{
		statusreport = new ReportFunctions(driver);
		displaymodeicon.click();
		statusreport.logger("display mode icon is clicked");
	}
	
	public void selecttableview()
	{
		statusreport = new ReportFunctions(driver);
		tableoption.click();
		statusreport.logger("Table view option is selected");
	}
	
	public void clickonchangeicon()
	{
		statusreport = new ReportFunctions(driver);
		changeicon.click();
		statusreport.logger("Chnage icon is clicked");
	}
	
	public void clicknewchangeorder()
	{
		statusreport = new ReportFunctions(driver);
		newchangeorder.click();
		statusreport.logger("new change order is clicked");
	}
	
	public void createpartstatus() throws IOException
	{
		statusreport = new ReportFunctions(driver);
		excel = new ReadExcel();
		
		
		String Partnumber = partnumber();
		
		if(Partnumber!=null)
		{
			excel.writeexcel("PartDetails",Partnumber,1); 
					
			System.out.println("Part is created successfully");
			statusreport.screenshot( "Part created successfully.jpg" );
			statusreport.logger("Part created successfully");
		}
		else
		{
			System.out.println("Part creation failed");
			statusreport.screenshot( "Part creation failed.jpg" );
			statusreport.logger("Part creation failed");	
		}
	}
	
	public void switchtodefault()
	{
		driver.switchTo().defaultContent();
	}
	
	public void waitforrightpanel()
	{
		statusreport = new ReportFunctions(driver);
		
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='rightSlideIn']")));
		statusreport.logger("Right panel found");
	}
}
