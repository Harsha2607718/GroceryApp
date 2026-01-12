package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {

	public WebDriver driver;

	/*
	 * @FindBy(xpath = "//div[@class='row']//div[9]//a") WebElement
	 * managecategory_moreinfo;
	 */
	@FindBy(css = "a[onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(css = "input[placeholder='Enter the Category']")
	WebElement categorytextbox;
	@FindBy(id = "134-selectable")
	WebElement discountlocator;
	@FindBy(css = "input#main_img")
	WebElement choosefilebutton;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement usercreated_alert;
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")
	WebElement useralreadyexists_alert;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void clickManageCategoryMoreInfo() { managecategory_moreinfo.click();
	 * }
	 */

	public ManageCategoryPage clickNew() {
		newbutton.click();
		return this;
	}

	public ManageCategoryPage enterCategory(String category) {
		categorytextbox.sendKeys(category);
		return this;
	}

	public ManageCategoryPage clickDiscount() {
		discountlocator.click();
		return this;
	}

	public ManageCategoryPage scrollManageCategoryPage() {
		PageUtility pageutility = new PageUtility();
		pageutility.scrollByPixel(driver, 200, 500);
		return this;
	}

	public ManageCategoryPage chooseFile() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(choosefilebutton, Constant.APPLE);
		return this;
	}

	public ManageCategoryPage clickSave() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, savebutton);
		Actions actions = new Actions(driver);
		actions.click(savebutton).perform();
		return this;
	}

	public boolean isAlertDisplayed() {
		try {
			if (usercreated_alert.isDisplayed()) {
				return true;
			}
		} catch (Exception ignored) {

		}

		try {
			if (useralreadyexists_alert.isDisplayed()) {
				return true;
			}
		} catch (Exception ignored) {

		}

		return false;
	}
}
