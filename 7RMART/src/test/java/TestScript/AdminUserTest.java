package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.Constant;
import Pages.AdminUserPage;
import Pages.HomePageLogoutPage;
import Pages.LoginPage;
import Pages.ManageNewsPage;


@Test
public class AdminUserTest extends Base {
	
	public AdminUserPage adminuserpage;  
	public HomePageLogoutPage homepagelogoutpage;
	
	public void adminuserinfo()
	{
		
	String username="admin";
	String password="admin";
	
			
	String adminusername="asdgfhj";
	String adminpassword="adminads";

	LoginPage loginpage=new LoginPage(driver);
	
	loginpage.enterUsername(username).enterPassword(password);
	
	homepagelogoutpage=loginpage.signIn();
	
	adminuserpage=homepagelogoutpage.adminusermoreinfo();
	
	adminuserpage.newvalue().usernamevalue(adminusername).passwordvalue(adminpassword).usertype().save();

	boolean alertvalue=adminuserpage.alert();
	Assert.assertTrue(alertvalue, Constant.ADMINPAGEUSERCREATED);
	
	}
	@Test
	public void delete()
	{
	
	String username="admin";
	String password="admin";
	
	LoginPage loginpage=new LoginPage(driver);
	
	loginpage.enterUsername(username).enterPassword(password);

	homepagelogoutpage=loginpage.signIn();
	

	
	adminuserpage=homepagelogoutpage.adminusermoreinfo();
	
	adminuserpage.deleteuser();		
	boolean alertdisplay=adminuserpage.alert();
	Assert.assertTrue(alertdisplay, Constant.ADMINPAGEUSERSUCCESSFULLYDELETED);
}

}
