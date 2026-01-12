package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	@FindBy(name = "username")
	WebElement usernamelocator;
	@FindBy(name = "password")
	WebElement passwordlocator;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinbutton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboardlocator;
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")
	WebElement alertlocator;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// 1st parameter:local driver,2nd parameter:current class' instance
												// driver.initElements() --> to initialize webelements
	}

	public LoginPage enterUsername(String username) {
		usernamelocator.sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		passwordlocator.sendKeys(password);
		return this;
	}

	public LogoutPage clickSignIn() {
		signinbutton.click();
		return new LogoutPage(driver);
	}

	public boolean isHomePageDisplayed() {
		return dashboardlocator.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alertlocator.isDisplayed();

	}

	public boolean isLoginPageDisplayed() {
		return signinbutton.isDisplayed();

	}
}
