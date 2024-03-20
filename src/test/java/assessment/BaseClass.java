package assessment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import utility.Constants;



public class BaseClass {
	
	WebDriver driver;
	
	@BeforeTest
	public void launch() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.nopComm);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
	}
	
	@AfterTest
	public void closeBrowser() throws Exception {
		Thread.sleep(100);
		driver.close();
		driver.quit();
	}

	

}
