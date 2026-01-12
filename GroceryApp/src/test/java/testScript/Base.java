package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base {

	public WebDriver driver;
	public FileInputStream fileinputstream;
	public Properties properties;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void browserInitialization(String browser) throws Exception {
		// driver=new ChromeDriver();

		try {
			properties = new Properties();
			fileinputstream = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);
		} catch (Exception e) {
			System.out.println(e);
		}

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("invalid browser");
		}

		// driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility scrShot = new ScreenshotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();

		/*
		 * public void browserclose() throws InterruptedException { Thread.sleep(1500);
		 * driver.quit(); }
		 */

	}
}
