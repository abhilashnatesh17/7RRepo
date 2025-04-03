package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.Constant;
import Pages.HomePageLogoutPage;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import Utilities.ExcelUtility;




public class ManageNewsTest extends Base{
	
	public ManageNewsPage managenewspage;
	public HomePageLogoutPage homepagelogoutpage;
	
	@Test
	public void manageNews() throws IOException
	{
		String username="admin";
		String password="admin";
		
	//	String textfield="Manage News is the Discount sale upto 50%"; 
		
		String textfield=ExcelUtility.getStringData(1, 0, "ManageNews");
		
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterUsername(username).enterPassword(password); //chainning
	
		homepagelogoutpage=loginpage.signIn();
		
	
		managenewspage=homepagelogoutpage.manageinfo();
	
		managenewspage.newbutton().text(textfield).save();

		boolean alertvalue=managenewspage.alert();
		Assert.assertTrue(alertvalue, Constant.MANAGENEWSTESTCASEFAILED);
		
	}

}
