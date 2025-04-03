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
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newvalue;
	@FindBy(xpath="//input[@id='username']")private WebElement usernamevalue;
	@FindBy(xpath="//input[@id='password']")private WebElement passwordvalue;
	@FindBy(xpath="//select[@name='user_type']")private WebElement usertype;
	@FindBy(xpath="//button[@name='Create']")private WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[7]")private WebElement deleteuser;
	
	
/*	public void adminusermoreinfo()
	{
		adminuser.click();
	} */
	public AdminUserPage newvalue()
	{
		newvalue.click();
		return this;
	}
	public AdminUserPage usernamevalue(String adminusername)
	{
		usernamevalue.sendKeys(adminusername);
		return this;
	}
	public AdminUserPage passwordvalue(String adminpassword)
	{
		passwordvalue.sendKeys(adminpassword);
		return this;
	}

	public AdminUserPage usertype()
	{
		Select select=new Select(usertype);
		select.selectByIndex(4);
		return this;
	}
	public AdminUserPage save()
	{
		save.click();
		return this;
	}
	public AdminUserPage deleteuser()
	{
		deleteuser.click();
		driver.switchTo().alert().accept();
		return this;
	}	
	public boolean alert()
	{
		return alert.isDisplayed();
	}

}
