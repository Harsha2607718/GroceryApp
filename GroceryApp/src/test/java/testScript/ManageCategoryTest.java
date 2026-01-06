package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {

	@Test
	public void verifyCategory() throws IOException, AWTException, InterruptedException {
		String user=ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin=ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignIn();
		
		ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage.clickManageCategoryMoreInfo();
		managecategorypage.clickNew();
		
		String category=ExcelUtility.readStringData(1, 0, "Category");
		managecategorypage.enterCategory(category);
		
		managecategorypage.clickDiscount();
		
		ContactUsPage contact=new ContactUsPage(driver);
		contact.scrollpage();
		
		managecategorypage.chooseFile();
		managecategorypage.clickSave();
		
		boolean alert=managecategorypage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
}
