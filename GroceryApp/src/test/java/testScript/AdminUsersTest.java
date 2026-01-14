package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {

	LogoutPage logoutpage;
	AdminUsersPage adminuserspage;

	@Test(description = "Test case to verify that the appropriate alert is displayed correctly when a new user is created or when the user already exists")
	public void verifyAdminUsers() throws IOException {
		String user = ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pin);
		// loginpage.enterPassword(pin);
		logoutpage = loginpage.clickSignIn();

		// AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		FakerUtility fakerutility = new FakerUtility();
		String username = fakerutility.creatARandomFirstName();
		String password = fakerutility.creatARandomFirstName();
		//String selectbyvalue = "staff";//read from excel
		String value=ExcelUtility.readStringData(1, 2, "AdminUsers");		
		adminuserspage = logoutpage.clickAdminUsersMoreInfo();
		adminuserspage.clickNew().enterUsername(username).enterPassword(password).selectUserType(value)
				.clickSave();

		// String username=ExcelUtility.readStringData(1, 0, "AdminUsers");
		// String password=ExcelUtility.readStringData(1, 1, "AdminUsers");
		/*
		 * adminuserspage.enterUsername(username);
		 * adminuserspage.enterPassword(password);
		 * adminuserspage.selectUserType(selectbyvalue); adminuserspage.clickSave();
		 */
		boolean alert = adminuserspage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ADMINUSERS_ERROR);
	}
}
