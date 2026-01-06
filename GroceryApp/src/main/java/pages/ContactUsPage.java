package pages;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//div[@class='row']//div[3]//a")WebElement managecontact_moreinfo;
	@FindBy(xpath = "//tbody//tr//td[6]//a")WebElement actionbutton;
	@FindBy(css = "textarea[placeholder='Enter the Address']")WebElement addresstextbox;
	@FindBy(css = "textarea[placeholder='Enter Delivery Time']")WebElement deliverytimelocator;
	@FindBy(xpath = "//button[@type=\"submit\"]")WebElement updatebutton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement alert_contactupdated;
	
	public ContactUsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickManageContactMoreInfo() {
		managecontact_moreinfo.click();
	}
	
	public void clickAction() {
		actionbutton.click();
	}
	
	public void clearAdress() {
		addresstextbox.clear();
	}
	
	public void enterAddress(String address) {
		addresstextbox.sendKeys(address);
	}
	
	public void clearDeliveryTime() {
		deliverytimelocator.clear();
	}
	
	public void enterDeliveryTime(int num) {
		deliverytimelocator.sendKeys(String.valueOf(num));
	}
	
	public void scrollpage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}
	
	public void clickUpdate() {
		updatebutton.click();
	}
	
	public boolean isAlertDisplayedForContactUpdate() {
		return alert_contactupdated.isDisplayed();
	}
}
