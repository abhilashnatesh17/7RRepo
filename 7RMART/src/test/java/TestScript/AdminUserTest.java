package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.Constant;
import Pages.AdminUserPage;
import Pages.HomePageLogoutPage;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;


@Test (description="verify The User Is Able To create userpage using Valid Credentials")
public class AdminUserTest extends Base {
	
	public AdminUserPage adminuserpage;  
	public HomePageLogoutPage homepagelogoutpage;
	
	public void adminuserinfo() throws IOException
	{
		
//	String username="admin";
//	String password="admin";
	
	String username=ExcelUtility.getStringData(1,0,"login");  
	String password=ExcelUtility.getStringData(1,1,"login");
	
			
//	String adminusername="asdgfhj";
//	String adminpassword="adminads";
	
	FakerUtility faker=new FakerUtility(); 
	String adminusername=faker.creatARandomFirstName();
	
	//String adminusername=ExcelUtility.getStringData(1,0,"AdminUser");  
	String adminpassword=ExcelUtility.getStringData(1,1,"AdminUser");

	LoginPage loginpage=new LoginPage(driver);
	
	loginpage.enterUsername(username).enterPassword(password);
	
	homepagelogoutpage=loginpage.signIn();
	
	adminuserpage=homepagelogoutpage.adminUserMoreInfo();
	
	adminuserpage.enterTheNewValue().userNameValue(adminusername).passwordValue(adminpassword).userType().adminUserPageSave();

	boolean alertvalue=adminuserpage.adminUserPageAlert();
	Assert.assertTrue(alertvalue, Constant.ADMINPAGEUSERCREATED);
	
	}
	@Test (description="verify The User Is Able To delete the user")
	public void delete() throws IOException
	{
	
//	String username="admin";
//	String password="admin";
	
	String username=ExcelUtility.getStringData(1,0,"login");  
	String password=ExcelUtility.getStringData(1,1,"login");
	
	LoginPage loginpage=new LoginPage(driver);
	
	loginpage.enterUsername(username).enterPassword(password);

	homepagelogoutpage=loginpage.signIn();
	

	
	adminuserpage=homepagelogoutpage.adminUserMoreInfo();
	
	adminuserpage.deleteUser();		
	boolean alertdisplay=adminuserpage.adminUserPageAlert();
	Assert.assertTrue(alertdisplay, Constant.ADMINPAGEUSERSUCCESSFULLYDELETED);
}

}
