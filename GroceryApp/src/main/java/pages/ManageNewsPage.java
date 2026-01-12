package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {

	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();

//	@FindBy(xpath = "//div[@class='row']//div[7]//a")WebElement managenews_moreinfo;
	@FindBy(xpath = "//a[contains(@onclick,'click_button(1)')]")
	WebElement locator_new;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement textarea;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement successalert;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void clickManageNewsMoreInfo() {
	 * waitutility.waitForElementToBeClickable(driver, managenews_moreinfo);//to
	 * delay managenews_moreinfo.click(); }
	 */

	public ManageNewsPage clickNew() {
		locator_new.click();
		return this;
	}

	public ManageNewsPage enterTheNews(String news) {
		textarea.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickSave() {
		savebutton.click();
		return this;
	}

	public boolean isSuccessAlertDisplayed() {
		return successalert.isDisplayed();

	}
}
