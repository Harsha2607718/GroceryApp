package pages;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ContactUsPage {
	public WebDriver driver;

//	@FindBy(xpath = "//div[@class='row']//div[3]//a")WebElement managecontact_moreinfo;
	@FindBy(xpath = "//tbody//tr//td[6]//a")
	WebElement actionbutton;
	@FindBy(css = "textarea[placeholder='Enter the Address']")
	WebElement addresstextbox;
	@FindBy(css = "textarea[placeholder='Enter Delivery Time']")
	WebElement deliverytimelocator;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement updatebutton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement alert_contactupdated;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void clickManageContactMoreInfo() { managecontact_moreinfo.click(); }
	 */

	public ContactUsPage clickAction() {
		actionbutton.click();
		return this;
	}

	public ContactUsPage clearAdress() {
		addresstextbox.clear();
		return this;
	}

	public ContactUsPage enterAddress(String address) {
		addresstextbox.sendKeys(address);
		return this;
	}

	public ContactUsPage clearDeliveryTime() {
		deliverytimelocator.clear();
		return this;
	}

	public ContactUsPage enterDeliveryTime(int num) {
		deliverytimelocator.sendKeys(String.valueOf(num));
		return this;
	}

	public ContactUsPage scrollContactUsPage() {
		PageUtility pageutility = new PageUtility();
		pageutility.scrollByPixel(driver, 200, 500);
		return this;
	}

	public ContactUsPage waitMethod() {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToBeClickable(driver, updatebutton);
		return this;
	}

	public ContactUsPage clickUpdate() {
		updatebutton.click();
		return this;
	}

	public boolean isAlertDisplayedForContactUpdate() {
		return alert_contactupdated.isDisplayed();
	}
}
