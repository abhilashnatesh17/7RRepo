package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.Constant;
import Pages.LoginPage;
import Utilities.ExcelUtility;
import Pages.HomePageLogoutPage;

public class HomePageLogoutTest extends Base{
	@Test (description="verify The User Is Able To Successfully logout")
	public void verifyTheUserAbleToSuccessFullyLogout() throws IOException
	{
//		String username="admin";
//		String password="admin";
		
		String username=ExcelUtility.getStringData(1,0,"login");  
		String password=ExcelUtility.getStringData(1,1,"login");
		
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
		
		HomePageLogoutPage logoutpage=new HomePageLogoutPage(driver);
		logoutpage.adminClick();
		logoutpage.logOut();
		boolean alert=logoutpage.SuccessFullyLogout();
		Assert.assertTrue(alert, Constant.HOMEPAGELOGOUT);
	}

}
