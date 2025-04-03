package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	WebDriver driver;
	public AdminUserPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this); 
	}
//	@FindBy(xpath="(//a[@class='small-box-footer'])[1]")private WebElement adminuser;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement adminuserpageclicknewvalue;
	@FindBy(xpath="//input[@id='username']")private WebElement usernamevalue;
	@FindBy(xpath="//input[@id='password']")private WebElement passwordvalue;
	@FindBy(xpath="//select[@name='user_type']")private WebElement usertype;
	@FindBy(xpath="//button[@name='Create']")private WebElement adminuserpagesavebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement isadminuserpagealert;
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[7]")private WebElement deleteuser;
	
	
/*	public void adminusermoreinfo()
	{
		adminuser.click();
	} */
	public AdminUserPage enterTheNewValue()
	{
		adminuserpageclicknewvalue.click();
		return this;
	}
	public AdminUserPage userNameValue(String adminusername)
	{
		usernamevalue.sendKeys(adminusername);
		return this;
	}
	public AdminUserPage passwordValue(String adminpassword)
	{
		passwordvalue.sendKeys(adminpassword);
		return this;
	}

	public AdminUserPage userType()
	{
		Select select=new Select(usertype);
		select.selectByIndex(4);
		return this;
	}
	public AdminUserPage adminUserPageSave()
	{
		adminuserpagesavebutton.click();
		return this;
	}
	public AdminUserPage deleteUser()
	{
		deleteuser.click();
		driver.switchTo().alert().accept();
		return this;
	}	
	public boolean adminUserPageAlert()
	{
		return isadminuserpagealert.isDisplayed();
	}

}
