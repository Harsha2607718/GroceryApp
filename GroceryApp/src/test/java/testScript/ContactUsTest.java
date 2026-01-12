package testScript;

import java.io.IOException;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.ContactUsPage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ContactUsTest extends Base {

	LogoutPage logoutpage;
	ContactUsPage contactus;

	@Test(groups = {
			"regression" }, description = "Test case to verify that the success alert is displayed correctly when contact details are updated")
	public void verifyContactUs() throws IOException {
		String user = ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pin);
		// loginpage.enterPassword(pin);
		logoutpage = loginpage.clickSignIn();

		// ContactUsPage contactus=new ContactUsPage(driver);
		FakerUtility faker = new FakerUtility();
		String randomaddress = faker.generateAddress();

		contactus = logoutpage.clickManageContactMoreInfo();
		int num = new Random().nextInt(4) + 2;
		contactus.clickAction().clearAdress().enterAddress(randomaddress).clearDeliveryTime().enterDeliveryTime(num)
				.scrollContactUsPage().waitMethod().clickUpdate();

		// contactus.clearAdress();
		/*
		 * contactus.enterAddress(randomaddress); contactus.clearDeliveryTime();
		 * 
		 * contactus.enterDeliveryTime(num);
		 */
		// contactus.scrollpage();
		/*
		 * contactus.waitmethod(); contactus.clickUpdate();
		 */

		boolean alert = contactus.isAlertDisplayedForContactUpdate();
		Assert.assertTrue(alert,Constant.CONTACTUS_ERROR);

	}
}
