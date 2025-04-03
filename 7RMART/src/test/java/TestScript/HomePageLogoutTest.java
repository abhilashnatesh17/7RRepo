package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.Constant;
import Pages.LoginPage;
import Pages.HomePageLogoutPage;

public class HomePageLogoutTest extends Base{
	@Test
	public void verifyTheUserAbleToSuccessFullyLogout()
	{
		String username="admin";
		String password="admin";
		
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
