package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{

	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String user=ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin=ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignIn();
		boolean homepage=loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepage);//Hard Assert-->classname.methodname
	}
	
	@Test
	public void verifyUserLoginWithCorrectUnameAndIncorrectPassword() throws IOException {
		String user=ExcelUtility.readStringData(2, 0, "Loginpage");
		String pin=ExcelUtility.readStringData(2, 1, "Loginpage");		System.out.println("username:" + user + " password:" + pin);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignIn();
		boolean alert=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);//Hard Assert-->classname.methodname
	}
	
	@Test
	public void verifyUserLoginWithIncorrectUnameAndCorrectPassword() throws IOException {
		String user=ExcelUtility.readStringData(3, 0, "Loginpage");
		String pin=ExcelUtility.readStringData(3, 1, "Loginpage");
		System.out.println("username:" + user + " password:" + pin);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignIn();
		boolean alert=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);//Hard Assert-->classname.methodname
	}
	
	@Test
	public void verifyUserLoginWithIncorrectUnameAndIncorrectPassword() throws IOException {
		String user=ExcelUtility.readStringData(4, 0, "Loginpage");
		String pin=ExcelUtility.readStringData(4, 1, "Loginpage");
		System.out.println("username:" + user + " password:" + pin);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignIn();
		boolean alert=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);//Hard Assert-->classname.methodname
	}
	
}
