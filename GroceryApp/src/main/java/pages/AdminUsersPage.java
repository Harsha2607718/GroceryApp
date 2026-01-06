package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//div[@class='row']//div[1]//div//a")WebElement adminusers_moreinfo;
	@FindBy(xpath = "//a[contains(@onclick,'click_button(1)')]")WebElement locator_new;
	@FindBy(css = "input#username")WebElement locator_username;
	@FindBy(css = "input#password")WebElement locator_password;
	@FindBy(css = "select#user_type")WebElement usertype_dropdown;
	@FindBy(xpath = "//i[contains(@class,'fa-save')]")WebElement savebutton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement usercreated_alert;
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")WebElement useralreadyexists_alert;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAdminUsersMoreInfo() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, adminusers_moreinfo);
		adminusers_moreinfo.click();
	}
	
	public void clickNew() {
		locator_new.click();
	}
	
	public void enterUsername(String uname) {
		locator_username.sendKeys(uname);
	}
	
	public void enterPassword(String password) {
		locator_password.sendKeys(password);
	}
	
	public void selectUserType(String value) {
		Select select=new Select(usertype_dropdown);
		select.selectByValue(value);
	}
	
	public void clickSave() {
		savebutton.click();
	}
	
	public boolean isAlertDisplayed() {
	    try {
	        if (usercreated_alert.isDisplayed()) {
	            return true;
	        }
	    } 
	    catch (Exception ignored) {
	    	
	    }

	    try {
	        if (useralreadyexists_alert.isDisplayed()) {
	            return true;
	        }
	    } 
	    catch (Exception ignored) {
	    	
	    }

	    return false;
	}

}
