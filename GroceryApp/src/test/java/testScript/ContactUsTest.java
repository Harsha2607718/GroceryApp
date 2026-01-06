package testScript;

import java.io.IOException;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ContactUsTest extends Base{

	@Test
	public void verifyContactUs() throws IOException {
		String user=ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin=ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignIn();
		
		ContactUsPage contactus=new ContactUsPage(driver);
		contactus.clickManageContactMoreInfo();
		contactus.clickAction();
		
		contactus.clearAdress();
		FakerUtility faker=new FakerUtility();
		String randomaddress=faker.generateAddress();
		contactus.enterAddress(randomaddress);
		
		contactus.clearDeliveryTime();
		int num = new Random().nextInt(4) + 2;
		contactus.enterDeliveryTime(num);
		
		contactus.scrollpage();
		contactus.clickUpdate();
		
		boolean alert=contactus.isAlertDisplayedForContactUpdate();
		Assert.assertTrue(alert);
		
	}
}
