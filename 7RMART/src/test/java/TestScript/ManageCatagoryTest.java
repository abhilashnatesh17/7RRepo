package TestScript;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.Constant;
import Pages.HomePageLogoutPage;
import Pages.LoginPage;
import Pages.ManageCatagoryPage;
import Pages.ManageNewsPage;
import Utilities.ExcelUtility;



public class ManageCatagoryTest extends Base {
	
	public ManageCatagoryPage managecatagorypage;
	public HomePageLogoutPage homepagelogoutpage;
	
	@Test (description="verify The User Is Able To create manage catagory list using Valid Credentials")
	public void manageCatagory() throws IOException
	{
	
	//String username="admin";
	//String password="admin";
	
	String username=ExcelUtility.getStringData(1,0,"login");  
	String password=ExcelUtility.getStringData(1,1,"login");
	
//	String catagoryValue="Helloo";
	
	String catagoryValue=ExcelUtility.getStringData(2, 1, "MangeSearchCatagory");
	
LoginPage loginpage=new LoginPage(driver);
	
	loginpage.enterUsername(username).enterPassword(password);

	homepagelogoutpage=loginpage.signIn();
	
	managecatagorypage=homepagelogoutpage.manageCatagoryMoreInfo();
	managecatagorypage.clickNew().enterTheCatagory(catagoryValue).selectGroups().saveButton();

	}
	@Test (description="verify The User Is Able To search manage catagory list using Valid Credentials")
	public void searchCatagories() throws IOException
	{
//		String username="admin";
//		String password="admin";
		
		String username=ExcelUtility.getStringData(1,0,"login");  
		String password=ExcelUtility.getStringData(1,1,"login");
		
	//	String searchcatagory="aaassdd";
		
		String searchcatagory=ExcelUtility.getStringData(1, 0, "MangeSearchCatagory");
		
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterUsername(username).enterPassword(password);
	
		homepagelogoutpage=loginpage.signIn();
		
		managecatagorypage=homepagelogoutpage.manageCatagoryMoreInfo();
		
		managecatagorypage.search().searchValue(searchcatagory).clickSearch();
	
		boolean alert=managecatagorypage.listedCatagory();
		Assert.assertTrue(alert, Constant.MANAGESEARCHCATAGORYLISTED);
		
	}
}
