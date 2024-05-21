package Testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Ultilities.ExcelReader;
import Ultilities.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class driver {

	public static WebDriver driver;

	public static ExcelReader excel = new ExcelReader("C:\\Users\\GOAKHILA\\eclipse-workspace\\SeleniumAssessement\\src\\test\\resources\\Excel\\Xyzbank.xlsx");
	public static ExtentReports report = ExtentManager.getInstance();
	public static ExtentTest test;


	@BeforeSuite
	public void openbrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

//	@AfterSuite
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}

	}
}
