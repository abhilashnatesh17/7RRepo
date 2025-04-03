package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this); 
	}
	@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement loginpagedashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement loginpagealert;
	
	public LoginPage enterUsername(String username)
	{
		usernameField.sendKeys(username);
		return this;
	}
	public LoginPage enterPassword(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	public HomePageLogoutPage signIn()
	{
		signin.click();
		return new HomePageLogoutPage(driver);
	}
	public boolean loginPageRedAlert()
	{
		return loginpagealert.isDisplayed();
	}
	public boolean isHomePageLoaded()
	{
		return loginpagedashboard.isDisplayed();
	}  
}
