package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageFooterTextTest extends Base{
	
	@Test
	public void verifyManageFooterText() throws IOException {
		String user=ExcelUtility.readStringData(1, 0, "Loginpage");
		String pin=ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignIn();
		
		ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefootertextpage.clickManageFooterText();
		managefootertextpage.clickActionButton();
		managefootertextpage.clearEmailTextBox();
		
		FakerUtility fakerutility=new FakerUtility();
		String email=fakerutility.generateEmail();
		managefootertextpage.enterEmail(email);
		
		managefootertextpage.clickUpdate();
		
		boolean alert=managefootertextpage.isAlertDisplayedForUpdatedFooterText();
		Assert.assertTrue(alert);
	}
}
