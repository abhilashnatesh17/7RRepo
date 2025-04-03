package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.Constant;

import java.io.IOException;
import Pages.LoginPage;
import Utilities.ExcelUtility;


public class LoginTest extends Base {
	
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
	//	String username="admin";	
	//	String password="admin";
		
		String username=ExcelUtility.getStringData(1,0,"login");  
		String password=ExcelUtility.getStringData(1,1,"login");
		
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.signIn();
		boolean isloaded=loginPage.isHomePageLoaded();
		Assert.assertTrue(isloaded, Constant.VERIFYTHEUSERISABLETOLOGINUSINGVALIDCREDENTIALS);
	}
	@Test 
	public void verifyTheUserIsAbleToLoginUsingCorrectUsernameAndWrongPassword() throws IOException
	{
				
	//	String username="admin";
	//	String password="wrongpassword"; 
		
		String username=ExcelUtility.getStringData(2,0,"login");  
		String password=ExcelUtility.getStringData(2,1,"login");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.signIn();
		boolean alertValue=loginPage.redAlert();
		Assert.assertTrue(alertValue, Constant.VERIFYTHEUSERISABLETOLOGINUSINGCORRECTUSERNAMEANDWRONGPASSWORD);
	} 
	@Test
	public void verifyTheUserIsAbleToLoginUsingInCorrectUsernameAndCorrectPassword() throws IOException
	{
				
	//	String username="wrongusername";
	//	String password="admin";  
		
		String username=ExcelUtility.getStringData(3,0,"login");  
		String password=ExcelUtility.getStringData(3,1,"login");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.signIn();
		boolean inCorrect=loginPage.incorrectUsername();
		Assert.assertTrue(inCorrect, Constant.VERIFYTHEUSERISABLETOLOGINUSINGINCORRECTUSERNAMEANDCORRECTPASSWORD);
	}	
	@Test
	public void verifyTheUserIsAbleToLoginUsingInCorrectUsernameAndInCorrectPassword() throws IOException 
	{
				
	//	String username="wrongusername";
	//	String password="wrongpassword";  
		
		String username=ExcelUtility.getStringData(4,0,"login"); 
		String password=ExcelUtility.getStringData(4,1,"login");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.signIn();
		boolean inCorrectUserandPass=loginPage.IncorrectUsernameAndPassword();
		Assert.assertTrue(inCorrectUserandPass, Constant.VERIFYTHEUSERISABLETOLOGINUSINGINCORRECTUSERNAMEANDINCORRECTPASSWORD);
	}

}
