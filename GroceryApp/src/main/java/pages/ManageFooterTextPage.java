package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	public WebDriver driver;

//	@FindBy(xpath = "//div[@class='row']//div[8]//div//a")WebElement managefootertext_moreinfo;
	@FindBy(xpath = "//tbody//tr[1]//td[4]//a")
	WebElement actionbutton;
	@FindBy(css = "input.form-control[id=\"email\"]")
	WebElement emailtextbox;
	@FindBy(css = "button[type='submit']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement footertextupdated_alert;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void clickManageFooterText() { managefootertext_moreinfo.click(); }
	 */

	public ManageFooterTextPage clickActionButton() {
		actionbutton.click();
		return this;
	}

	public ManageFooterTextPage clearEmailTextBox() {
		emailtextbox.clear();
		return this;
	}

	public ManageFooterTextPage enterEmail(String email) {
		emailtextbox.sendKeys(email);
		return null;
	}

	public ManageFooterTextPage clickUpdate() {
		updatebutton.click();
		return this;
	}

	public boolean isAlertDisplayedForUpdatedFooterText() {
		return footertextupdated_alert.isDisplayed();
	}

}
