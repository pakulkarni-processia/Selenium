package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PartEBOMPage {

	
	WebDriver driver;
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
	
	public String visibilityofpartpropertypage()
	{
		if(pagehead.isDisplayed())
		{
			return "True";
		}
		else 
		{
			return "False";
		}
	}
	
	public String visibilityofebompage()
	{
		
		if(pencilicon.isDisplayed())
		{
			return "True";
		}
		else 
		{
			return "False";
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
		ebom.click();
	}
	
	public void clickonediticon()
	{
				
		pencilicon.click();
		System.out.println("Clicked on Pensil icon");
	}
	public void clickcheckboxtoenterchildpart() throws InterruptedException
	{
		partcheckbox.click();
		Thread.sleep(1000);
		
		System.out.println("Clicked on child checkbox");
	}
	
	public void clickonInsertparticon()
	{
		insertparticon.click();
		System.out.println("Clicked on Insert Part icon");
	}
	
	
	public void selectinsertpart()
	{
		Inserparttext.click();
		System.out.println("Clicked on Insert Part text from menu");
	}
	
	public String visibilityofchildpart()
	{
		if(firstchildpart.isDisplayed())
		{
			System.out.println("Child Part Created");
			String childpartno = firstchildpart.getText();
			return childpartno;
			
		}
		else
		{
			System.out.println("Child Part Creation Failed");
			return "False";
		}
		
	}
	
	public void clickonsavebutton()
	{
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(savebutton)).click();
	}
	
	public void ENCBOMframe()
	{
		driver.switchTo().frame("content");
		driver.switchTo().frame("detailsDisplay");
		driver.switchTo().frame("portalDisplay");
		driver.switchTo().frame("ENCBOM");
	}
	
	public void clickdisplaymodeicon()
	{
		displaymodeicon.click();
		System.out.println("display mode icon is clicked");
	}
	
	public void selecttableview()
	{
		tableoption.click();
		System.out.println("Table view option is selected");
	}
	
	public void clickonchangeicon()
	{
		changeicon.click();
		System.out.println("Chnage icon is clicked");
	}
	
	public void clicknewchangeorder()
	{
		newchangeorder.click();
		System.out.println("new change order is clicked");
	}
}
