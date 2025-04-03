package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtilities;

public class ManageCatagoryPage {
	
WebDriver driver;
	
	public ManageCatagoryPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	//@FindBy(xpath="(//a[@class='small-box-footer'])[11]")private WebElement managecatagory;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement ClickNew;
	@FindBy(xpath="//input[@class='form-control']")private WebElement CatagoryValue;
	@FindBy(xpath="//li[@id='134-selectable']")private WebElement SelectGroups;
	@FindBy(xpath="//button[@type='submit']")private WebElement Save;
	@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement Search;
	@FindBy(xpath="//input[@type='text']")private WebElement SearchValue;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")private WebElement ClickSearch;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")private WebElement ListedCatagories ;

/*	public void manageCatagorymoreinfo()
	{
		managecatagory.click();
	} */
	public ManageCatagoryPage clickNew()
	{
		ClickNew.click();
		return this;
	}
	public ManageCatagoryPage enterTheCatagory(String catagoryValue)
	{
		CatagoryValue.sendKeys(catagoryValue);
		return this;
	}
	public ManageCatagoryPage selectGroups()
	{
		SelectGroups.click();
		return this;
	}
	public ManageCatagoryPage saveButton()
	{
		Save.click();
		return this;
	}
	public ManageCatagoryPage search()
	{
		Search.click();
		return this;
	}
	public ManageCatagoryPage searchValue(String searchcatagory)
	{
		SearchValue.sendKeys(searchcatagory);
		return this;
	}
	public ManageCatagoryPage clickSearch()
	{
//		WaitUtilities waitutilities =new WaitUtilities();
//		waitutilities.waitForElementToBeClickable(driver, ClickSearch);
		
		ClickSearch.click();
		return this;
	}
	public boolean listedCatagory()
	{
		return ListedCatagories.isDisplayed();
	}
}
