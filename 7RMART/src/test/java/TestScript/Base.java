package TestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Constants.Constant;
import Utilities.ScreenshotUtility;
import Utilities.WaitUtilities;


public class Base {
	public WebDriver driver;
	public ScreenshotUtility scrshot; 
	public Properties properties;
	public FileInputStream fileinputstream;
	
	
	@BeforeMethod(alwaysRun=true) 
	@Parameters("browser")
	public void browserInitilazation(String browser)throws Exception 
	{	
		try {														
			properties = new Properties();
			fileinputstream = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);

		} catch (Exception e) {
			System.out.println("Error");
		}
		
		
		if(browser.equalsIgnoreCase("chrome"))		
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			throw new Exception("Driver is not available");
		}
	//	driver=new ChromeDriver();
	//	driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtilities.IMPLICIT_WAIT));
		driver.manage().window().maximize(); 	
	}
	@AfterMethod
	
	public void browserQuit(ITestResult iTestResult) throws IOException { 
		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
			ScreenshotUtility scrShot = new ScreenshotUtility(); 
			scrShot.getScreenShot(driver, iTestResult.getName()); 
		} 
 
	}

}
