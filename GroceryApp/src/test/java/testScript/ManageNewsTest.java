package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	LogoutPage logoutpage;
	ManageNewsPage managenewspage;

	@Test(description = "Test case to verify that the success alert is displayed correctly when news is created")
	public void verifyManageNews() throws IOException {
		String user = ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pin);
		// loginpage.enterPassword(pin);
		logoutpage = loginpage.clickSignIn();
		// ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage = logoutpage.clickManageNewsMoreInfo();
		String newstext = ExcelUtility.readStringData(1, 0, "ManageNews");
		managenewspage.clickNew().enterTheNews(newstext).clickSave();
		// managenewspage.enterTheNews(newstext);
		// managenewspage.clickSave();
		boolean newssuccessalert = managenewspage.isSuccessAlertDisplayed();
		Assert.assertTrue(newssuccessalert,Constant.MANAGENEWS_ERROR);
	}
}
