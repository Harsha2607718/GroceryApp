package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LogoutPage {

	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement locator_admin;
	@FindBy(xpath = "//i[contains(@class,'ace-icon fa fa-power-off')]")
	WebElement locator_adminlogo;
	@FindBy(xpath = "//div[@class='row']//div[1]//div//a")
	WebElement adminusers_moreinfo;
	@FindBy(xpath = "//div[@class='row']//div[3]//a")
	WebElement managecontact_moreinfo;
	@FindBy(xpath = "//div[@class='row']//div[9]//a")
	WebElement managecategory_moreinfo;
	@FindBy(xpath = "//div[@class='row']//div[8]//div//a")
	WebElement managefootertext_moreinfo;
	@FindBy(xpath = "//div[@class='row']//div[7]//a")
	WebElement managenews_moreinfo;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AdminUsersPage clickAdminUsersMoreInfo() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, adminusers_moreinfo);
		adminusers_moreinfo.click();
		return new AdminUsersPage(driver);
	}

	public ContactUsPage clickManageContactMoreInfo() {
		managecontact_moreinfo.click();
		return new ContactUsPage(driver);
	}

	public ManageCategoryPage clickManageCategoryMoreInfo() {
		managecategory_moreinfo.click();
		return new ManageCategoryPage(driver);
	}

	public ManageFooterTextPage clickManageFooterText() {
		managefootertext_moreinfo.click();
		return new ManageFooterTextPage(driver);
	}

	public ManageNewsPage clickManageNewsMoreInfo() {
		waitutility.waitForElementToBeClickable(driver, managenews_moreinfo);// to delay
		managenews_moreinfo.click();
		return new ManageNewsPage(driver);
	}

	public LoginPage clickLogout() {
		locator_admin.click();
		locator_adminlogo.click();
		return new LoginPage(driver);
	}

}
