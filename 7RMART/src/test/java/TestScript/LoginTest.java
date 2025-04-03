package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.Constant;

import java.io.IOException;
import Pages.LoginPage;
import Utilities.ExcelUtility;


public class LoginTest extends Base {
	
	@Test(description="verify The User Is Able To Login Using Valid Credentials")
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
	@Test (description="verify The User Is Able To Login Using Correct Username And WrongPassword")
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
		boolean alertValue=loginPage.loginPageRedAlert();
		Assert.assertTrue(alertValue, Constant.VERIFYTHEUSERISABLETOLOGINUSINGCORRECTUSERNAMEANDWRONGPASSWORD);
	} 
	@Test (description="verify The User Is Able To Login Using InCorrect Username And Correct Password")
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
		boolean inCorrect=loginPage.loginPageRedAlert();
		Assert.assertTrue(inCorrect, Constant.VERIFYTHEUSERISABLETOLOGINUSINGINCORRECTUSERNAMEANDCORRECTPASSWORD);
	}	
	@Test (description="verify The User Is Able To Login Using InCorrect Username And InCorrect Password")
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
		boolean inCorrectUserandPass=loginPage.loginPageRedAlert();
		Assert.assertTrue(inCorrectUserandPass, Constant.VERIFYTHEUSERISABLETOLOGINUSINGINCORRECTUSERNAMEANDINCORRECTPASSWORD);
	}

}
