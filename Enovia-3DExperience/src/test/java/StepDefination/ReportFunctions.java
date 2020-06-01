package StepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportFunctions {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ReadExcel read;
	
	public  ReportFunctions(WebDriver newdriver)
	{
		driver = newdriver;
		PageFactory.initElements(newdriver, this);
	}
	
	public final byte[] screen = null;
	public void screenshot(String name) throws IOException
	{
		File  screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File DestFile= new File ("target/screenshots/"+name);

		//Copy file at destination
     
		FileUtils.copyFile(screenshot,DestFile);
		System.out.println("File copied");
	
		  	} 
	
	public void logger (String logtext)
	{
		
		String log4jConfPath = "src/test/resources/log4j2.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		Logger logger = Logger.getLogger(ReportFunctions.class);		
		logger.info(logtext);
}

}
