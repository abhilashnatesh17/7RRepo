package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[9]")private WebElement manageinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']")private WebElement text;
	@FindBy(xpath="//button[@type='submit']")private WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	
	public ManageNewsPage manageinfo()
	{		
		manageinfo.click();
		return this;
	}
	public ManageNewsPage newbutton()
	{
		newbutton.click();
		return this;
	}
	public ManageNewsPage text(String textfield)
	{
		text.sendKeys(textfield);
		return this;
	}
	public ManageNewsPage save()
	{ 
		save.click();
		return this;
	}
	public boolean alert()
	{
		return alert.isDisplayed();
	}

}
