package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {

	@Test
	public void verifyLogout() throws IOException {
		String user=ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin=ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignIn();
		LogoutPage logoutpage=new LogoutPage(driver);
		logoutpage.clickLogout();
		boolean loginpage_signinbutton=loginpage.isLoginPageDisplayed();
		Assert.assertTrue(loginpage_signinbutton);
	}
}
