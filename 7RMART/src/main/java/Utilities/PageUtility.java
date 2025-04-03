package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	public void mouseHoverAction(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public void doubleClickAction(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void rightClickAction(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void draganddropAction(WebDriver driver, WebElement drag, WebElement drop) {
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
		;

	}

	public void scrolldownLittle(WebElement element, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,+500)", "");   //Scroll down little

	}

	public void scrollTopTOExtremeBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");// top to extreme bottom

	}

	public void scrollLeftToRight(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(-150,0)",""); //scroll from Left to Right
	}
	
	public void scrollBottomToTop(WebDriver driver)
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-150)","");// scroll bottom to top little
		
	}
	
	public void scrollRightToLeft(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(150,0)",""); //scroll left to right
	}
	public void clickUsingJavascriptExecutor(WebDriver driver)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",driver);
		js.executeScript("arguments[0].click();", "");

	}

	
}
