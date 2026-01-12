package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageFooterTextTest extends Base {

	LogoutPage logoutpage;
	ManageFooterTextPage managefootertextpage;

	@Test(description = "Test case to verify that the success alert is displayed correctly when the footer text is updated")
	public void verifyManageFooterText() throws IOException {
		String user = ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pin);
		// loginpage.enterPassword(pin);
		logoutpage = loginpage.clickSignIn();

		// ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefootertextpage = logoutpage.clickManageFooterText();
		FakerUtility fakerutility = new FakerUtility();
		String email = fakerutility.generateEmail();
		managefootertextpage.clickActionButton().clearEmailTextBox().enterEmail(email).clickUpdate();
		// managefootertextpage.clearEmailTextBox();

		// managefootertextpage.enterEmail(email);

		// managefootertextpage.clickUpdate();

		boolean alert = managefootertextpage.isAlertDisplayedForUpdatedFooterText();
		Assert.assertTrue(alert,Constant.MANAGEFOOTER_ERROR);
	}
}
