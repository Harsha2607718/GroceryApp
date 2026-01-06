package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement locator_admin;
	@FindBy(xpath="//i[contains(@class,'ace-icon fa fa-power-off')]")WebElement locator_adminlogo;
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickLogout() {
		locator_admin.click();
		locator_adminlogo.click();
	}
	
	
	
}
