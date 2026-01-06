package testScript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.WaitUtility;

public class Base {

	public WebDriver driver;
	
	@BeforeMethod
	public void browserInitialization() {
		driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize()	;
		}
	
//	@AfterMethod
	public void browserclose() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}

}
