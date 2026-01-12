package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {

	LogoutPage logoutpage;

	@Test(description = "Test case to verify that the user is logged out successfully from the application")
	public void verifyLogout() throws IOException {
		String user = ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pin);
		logoutpage = loginpage.clickSignIn();
		// LogoutPage logoutpage=new LogoutPage(driver);
		logoutpage.clickLogout();
		boolean loginpage_signinbutton = loginpage.isLoginPageDisplayed();
		Assert.assertTrue(loginpage_signinbutton,Constant.LOGOUT_ERROR);
	}
}
