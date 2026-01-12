package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	// Select class methods

	public void selectByVisibleTextMethod(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);

	}

	public void selectByValueMethod(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByIndexMethod(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// Actions class methods

	public void dragAndDropMethod(WebDriver driver, WebElement source, WebElement destination) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, destination).perform();
	}

	public void rightClickMethod(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void doubleClickMethod(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void mouseHoverMethod(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// JavaScriptExecutor methods

	public void setValueUsingJavaScript(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + value + "';", element);
	}

	public void clickUsingJavaScript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// Positive y value → scroll down
	// Negative y value → scroll up
	public void scrollByPixel(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public void scrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	// select class methods
	// actions class methods
	// javascriptexecutor methods
}
