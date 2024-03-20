package assessment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utility.Constants;
import utility.ExcelUtils2;

public class TestClass extends BaseClass {
	
	
	static ExcelUtils2 excelUtils = new ExcelUtils2();
	static String excelFilePath =   Constants.Path_TestData + Constants.File_TestData;


	
	@Test
	public void Register() throws Exception {
		
		excelUtils.setExcelFile(excelFilePath,"Sheet1");

        
        for(int i=1;i<=excelUtils.getRowCountInSheet();i++) {
        	
        	driver.findElement(By.linkText("Log in")).click();
    		driver.findElement(By.xpath("//button[text()='Register']")).click();
    		
    		//Identify the WebElements for the registration
    		
    		WebElement fname = driver.findElement(By.id("FirstName"));
    		WebElement lname = driver.findElement(By.id("LastName"));
    		Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
    		Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
    		Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
    		WebElement email = driver.findElement(By.id("Email"));
    		WebElement company = driver.findElement(By.id("Company"));
    		WebElement password = driver.findElement(By.id("Password"));
    		WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
    		
    		 //calling the ExcelUtils class method to name the workbook and sheet
            
            
        	Thread.sleep(500);
        	
        	if(excelUtils.getCellData(i, 0).equals("Male")) {
        		driver.findElement(By.id("gender-male")).click();
        	} else
        	{
        		driver.findElement(By.id("gender-female")).click();
        	}
        	
        	Thread.sleep(100);
        	fname.clear();
        	fname.sendKeys(excelUtils.getCellData(i,1));
        	Thread.sleep(100);
        	lname.clear();
        	lname.sendKeys(excelUtils.getCellData(i,2));
        	Thread.sleep(100);
        	day.selectByValue(excelUtils.getCellData(i,3));
        	Thread.sleep(100);
        	month.selectByVisibleText(excelUtils.getCellData(i,4));
        	Thread.sleep(100);
        	year.selectByValue(excelUtils.getCellData(i,5));
        	Thread.sleep(100);
        	email.clear();
        	email.sendKeys(excelUtils.getCellData(i,6));
        	Thread.sleep(100);
        	company.clear();
        	company.sendKeys(excelUtils.getCellData(i,7));
        	Thread.sleep(100);
        	password.clear();
        	password.sendKeys(excelUtils.getCellData(i,8));
        	Thread.sleep(100);
        	confirmPassword.clear();
        	confirmPassword.sendKeys(excelUtils.getCellData(i,9));
        	
        	//click on Register
        	driver.findElement(By.id("register-button")).click();
        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        	driver.findElement(By.cssSelector("html>body>div:nth-of-type(6)>div:nth-of-type(3)>div>div>div>div:nth-of-type(2)>div:nth-of-type(2)>a")).click();
        	
        }
	
	}
	
}
