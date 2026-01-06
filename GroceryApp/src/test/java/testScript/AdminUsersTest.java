package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	
	@Test
	public void verifyAdminUsers() throws IOException {
		String user=ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin=ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignIn();
		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickAdminUsersMoreInfo();
		adminuserspage.clickNew();
		
		FakerUtility fakerutility=new FakerUtility();
		String username=fakerutility.creatARandomFirstName();
		String password=fakerutility.creatARandomFirstName();
		//String username=ExcelUtility.readStringData(1, 0, "AdminUsers");
		//String password=ExcelUtility.readStringData(1, 1, "Loginpage");
		String selectbyvalue="staff";
		adminuserspage.enterUsername(username);
		adminuserspage.enterPassword(password);
		adminuserspage.selectUserType(selectbyvalue);
		adminuserspage.clickSave();
		boolean alert=adminuserspage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
}
