package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLogoutPage {
	
	WebDriver driver;
	public HomePageLogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@data-toggle='dropdown']")private WebElement adminclick;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")private WebElement logout;
	@FindBy(xpath="//body[@class='login-page']")private WebElement successfullylogout;
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]")private WebElement adminuser;
	@FindBy(xpath="(//a[@class='small-box-footer'])[11]")private WebElement managecatagory;
	@FindBy(xpath="(//a[@class='small-box-footer'])[9]")private WebElement manageinfo;
	
	
	public AdminUserPage adminUserMoreInfo()
	{
		adminuser.click();
		return new AdminUserPage(driver) ;
	}
			
	public ManageCatagoryPage manageCatagoryMoreInfo()
	{
		managecatagory.click();
		return new ManageCatagoryPage(driver);
	}
	
	public ManageNewsPage manageInfo()
	{		
		manageinfo.click();
		return new ManageNewsPage(driver);
	}
	
		
	public HomePageLogoutPage adminClick()
	{
		adminclick.click();
		return this;
	}
	public HomePageLogoutPage logOut()
	{
		logout.click();
		return this;
	}
	public boolean SuccessFullyLogout()
	{
		return successfullylogout.isDisplayed();
	}
}
