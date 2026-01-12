package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	LogoutPage logoutpage;
	
	@Test(groups = { "regression" },description = "Test case to verify that the user is able to log in successfully using valid credentials")
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String user = ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pin);
		//loginpage.enterPassword(pin);
		logoutpage=loginpage.clickSignIn();
		boolean homepage = loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepage,Constant.VALIDLOGIN_ERROR);// Hard Assert-->classname.methodname
	}

	@Test(description = "Test case to verify invalid credentials alert for correct username and incorrect password.")
	public void verifyUserLoginWithCorrectUnameAndIncorrectPassword() throws IOException {
		String user = ExcelUtility.readStringData(2, 0, "Loginpage");
		String pin = ExcelUtility.readStringData(2, 1, "Loginpage");
		System.out.println("username:" + user + " password:" + pin);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pin);;
		//loginpage.enterPassword(pin);
		logoutpage=loginpage.clickSignIn();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.LOGININCORRECTPASSWORD_ERROR);// Hard Assert-->classname.methodname
	}

	@Test(description = "Test case to verify invalid credentials alert for incorrect username and correct password.")
	public void verifyUserLoginWithIncorrectUnameAndCorrectPassword() throws IOException {
		String user = ExcelUtility.readStringData(3, 0, "Loginpage");
		String pin = ExcelUtility.readStringData(3, 1, "Loginpage");
		System.out.println("username:" + user + " password:" + pin);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pin);
		//loginpage.enterPassword(pin);
		logoutpage=loginpage.clickSignIn();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.LOGININCORRECTUNAME_ERROR);// Hard Assert-->classname.methodname
	}

	@Test(description = "Test case to verify invalid credentials alert for incorrect username and incorrect password.")
	public void verifyUserLoginWithIncorrectUnameAndIncorrectPassword() throws IOException {
		String user = ExcelUtility.readStringData(4, 0, "Loginpage");
		String pin = ExcelUtility.readStringData(4, 1, "Loginpage");
		System.out.println("username:" + user + " password:" + pin);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pin);
		//loginpage.enterPassword(pin);
		logoutpage=loginpage.clickSignIn();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.INVALIDLOGIN_ERROR);// Hard Assert-->classname.methodname
	}

}
