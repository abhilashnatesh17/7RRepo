package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {		
	
	public void selectByIndex(WebElement usertype,int indexvalue)
	{
		Select select =new Select(usertype);
		select.selectByIndex(4);
	}
	public void selectByValue(WebElement usertype,String value)
	{
		Select select=new Select(usertype);
		select.selectByValue("Staff");
	}
	public void selectByVisibleText(WebElement usertype,String value)
	{
		Select select=new Select(usertype);
		select.selectByVisibleText("Admin");
	}

}
