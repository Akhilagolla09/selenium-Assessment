package Webpages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testcases.driver;

public class Baseclass extends driver {

	public void clickMethod(WebElement e1) {
		e1.click();
	}

	public void sendkeysint(WebElement e2, String s) {
		e2.sendKeys(s);
	}

	public void getText(WebElement e3) {
		String s = e3.getText();
		System.out.println(s);
	}

	public void clearMethod(WebElement e4) {
		e4.clear();
	}

	public void explicitWait(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void takescreenshot(String fileName) throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(
				"C:\\Users\\GOAKHILA\\eclipse-workspace\\SeleniumAssessement\\screenshots\\" + fileName + ".jpg"));
	}

	public void exceldataid(String data) throws IOException {

		String path = "C:\\Users\\GOAKHILA\\eclipse-workspace\\SeleniumAssessement\\src\\test\\resources\\Excel\\XYZBank_id.xlsx";

		Workbook wb = new XSSFWorkbook();
		FileOutputStream fos = new FileOutputStream(path);
		Sheet sheet1 = wb.createSheet("sheet");

		Row row = sheet1.createRow(1);
		Cell cell = row.createCell(1);

		cell.setCellValue(data);

		wb.write(fos);
		fos.close();
	}

	public void exceldataaccount(String data) throws IOException {

		String path = "C:\\Users\\GOAKHILA\\eclipse-workspace\\SeleniumAssessement\\src\\test\\resources\\Excel\\XYZBank_account.xlsx";

		Workbook wb = new XSSFWorkbook();
		FileOutputStream fos = new FileOutputStream(path);
		Sheet sheet1 = wb.createSheet("sheet1");
		// int lastRow = sheet1.getLastRowNum();

		Row row = sheet1.createRow(2);
		Cell cell = row.createCell(2);

		cell.setCellValue(data);

		wb.write(fos);
		fos.close();

	}

}
