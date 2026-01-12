package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.ContactUsPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryTest extends Base {

	LogoutPage logoutpage;
	ManageCategoryPage managecategorypage;

	@Test(retryAnalyzer = retry.Retry.class, description = "Test case to verify alerts for new and existing category scenarios.")
	public void verifyCategory() throws IOException, AWTException, InterruptedException {
		String user = ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pin);

		logoutpage = loginpage.clickSignIn();

		// ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage = logoutpage.clickManageCategoryMoreInfo();
		String category = ExcelUtility.readStringData(1, 0, "Category");
		managecategorypage.clickNew().enterCategory(category).clickDiscount().scrollManageCategoryPage().chooseFile()
				.clickSave();

		// managecategorypage.enterCategory(category);

		// managecategorypage.clickDiscount();

		// managecategorypage.chooseFile();

		// managecategorypage.clickSave();

		boolean alert = managecategorypage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.MANAGECATEGORY_ERROR);
	}
}
