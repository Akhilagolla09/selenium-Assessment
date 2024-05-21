package Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Webpages.scenario;

public class scenario_test extends driver{

	@Test(dataProvider="getData")
	public void testsecnario(String Firstname,String Lastname, String PostCode, String Number)throws InterruptedException {
		
		scenario obj = new scenario(driver);
		
		obj.BankManagerLogin(Firstname,Lastname,PostCode);
		obj.CustomerLogin(Number);

		
		test = report.startTest("scenario_test");
		test.log(LogStatus.PASS, "pass");
				report.endTest(test);
				report.flush();
	}
	
	@DataProvider
	public Object[][] getData() {
		String sheetname = "magento";
		int rows = excel.getRowCount(sheetname);
		int cols = excel.getColumnCount(sheetname);
		Object[][] data = new Object[rows - 1][cols];
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				// data[0][0]
				data[rowNum - 2][colNum] = excel.getCellData(sheetname, colNum, rowNum);
			}
		}
		return data;
	}
	
}
