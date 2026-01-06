package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	
	@Test
	public void verifyManageNews() throws IOException {
		String user=ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin=ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignIn();
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickManageNewsMoreInfo();
		managenewspage.clickNew();
		String newstext=ExcelUtility.readStringData(1, 0, "ManageNews");
		managenewspage.enterTheNews(newstext);
		managenewspage.clickSave();
		boolean newssuccessalert=managenewspage.isSuccessAlertDisplayed();
		Assert.assertTrue(newssuccessalert);
	}
}
