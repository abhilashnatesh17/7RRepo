package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.Constant;
import Pages.HomePageLogoutPage;
import Pages.LoginPage;
import Pages.ManageCatagoryPage;
import Pages.ManageNewsPage;


public class ManageCatagoryTest extends Base {
	
	public ManageCatagoryPage managecatagorypage;
	public HomePageLogoutPage homepagelogoutpage;
	
	@Test
	public void manageCatagory()
	{
	
	String username="admin";
	String password="admin";
	String catagoryValue="Helloo";
	
LoginPage loginpage=new LoginPage(driver);
	
	loginpage.enterUsername(username).enterPassword(password);

	homepagelogoutpage=loginpage.signIn();
	
	managecatagorypage=homepagelogoutpage.manageCatagorymoreinfo();
	managecatagorypage.clickNew().enterTheCatagory(catagoryValue).selectGroups().saveButton();

	}
	@Test
	public void searchCatagories()
	{
		String username="admin";
		String password="admin";
		
		String searchcatagory="aaassdd";
		
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterUsername(username).enterPassword(password);
	
		homepagelogoutpage=loginpage.signIn();
		
		managecatagorypage=homepagelogoutpage.manageCatagorymoreinfo();
		
		managecatagorypage.search().searchValue(searchcatagory).clickSearch();
	
		boolean alert=managecatagorypage.listedCatagory();
		Assert.assertTrue(alert, Constant.MANAGESEARCHCATAGORYLISTED);
		
	}
}
