package Webpages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class scenario extends Baseclass {

	WebDriver driver;

	public scenario(WebDriver driver) {
		this.driver = driver;
	}

	By login = By.xpath("(//button[@class='btn btn-primary btn-lg'])[2]");
	By add = By.xpath("//button[@ng-class='btnClass1']");
	By fname = By.xpath("//input[@ng-model='fName']");
	By lname = By.xpath("//input[@ng-model='lName']");
	By postcode = By.xpath("//input[@placeholder='Post Code']");
	By addcustomer = By.xpath("//button[@type='submit']");
	By openaccount = By.xpath("//button[@ng-class='btnClass2']");
	By selectcustomer = By.xpath("//select[@name='userSelect']");
	By currency = By.xpath("//select[@id='currency']");
	By process = By.xpath("//button[@type='submit']");
	By customers = By.xpath("//button[@ng-class='btnClass3']");
	By search = By.xpath("//input[@placeholder='Search Customer']");

	By home = By.xpath("//button[@class='btn home']");
	By custlogin = By.xpath("//button[@ng-click='customer()']");
	By selectname = By.xpath("//select[@name='userSelect']");
	By login1 = By.xpath("//button[@class='btn btn-default']");
	By deposit = By.xpath("//button[@ng-click=\"deposit()\"]");
	By number = By.xpath("//input[@type='number']");
	By depositbutton = By.xpath("//button[@type='submit']");
	
	By withdraw = By.xpath("//button[@ng-click=\"withdrawl()\"]");

	
	public void BankManagerLogin(String Firstname, String Lastname, String PostCode) throws InterruptedException {

		WebElement banklogin = driver.findElement(login);
		clickMethod(banklogin);
		Thread.sleep(1000);

		WebElement Add = driver.findElement(add);
		clickMethod(Add);

		WebElement first = driver.findElement(fname);
		sendkeysint(first, Firstname);
		Thread.sleep(1000);

		WebElement last = driver.findElement(lname);
		sendkeysint(last, Lastname);
		Thread.sleep(1000);

		WebElement post = driver.findElement(postcode);
		sendkeysint(post, PostCode);
		Thread.sleep(1000);

		WebElement Addcustomer = driver.findElement(addcustomer);
		clickMethod(Addcustomer);
		Thread.sleep(1000);

		Alert alert = driver.switchTo().alert();
		String idtext = alert.getText();
		System.out.println(idtext);
		
		try {
			exceldataid(idtext);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		alert.accept();
	
	
		WebElement open = driver.findElement(openaccount);
		clickMethod(open);

		Select s = new Select(driver.findElement(selectcustomer));
		s.selectByVisibleText("Akhila golla");
		Thread.sleep(1000);

		Select s1 = new Select(driver.findElement(currency));
		s1.selectByValue("Rupee");
		Thread.sleep(1000);

		WebElement Process = driver.findElement(process);
		clickMethod(Process);
		Thread.sleep(2000);

		Alert alert1 = driver.switchTo().alert();
		String accountnum = alert.getText();
		System.out.println(accountnum);
		try {
			exceldataaccount(accountnum);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		alert1.accept();

		WebElement Cust = driver.findElement(customers);
		clickMethod(Cust);

		WebElement SName = driver.findElement(search);
		explicitWait(driver, 20, SName);
		sendkeysint(SName, "Akhila");

		try {
			takescreenshot("searchpage");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void CustomerLogin(String Number) throws InterruptedException {

		WebElement Home = driver.findElement(home);
		clickMethod(Home);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement Custlog = driver.findElement(custlogin);
		clickMethod(Custlog);
		
		Select s = new Select(driver.findElement(selectname));
		s.selectByValue("6");
		Thread.sleep(1000);
		
		WebElement Login1 = driver.findElement(login1);
		clickMethod(Login1);
		
		WebElement Deposit = driver.findElement(deposit);
		clickMethod(Deposit);
		
		WebElement num = driver.findElement(number);
		sendkeysint(num, Number);
		Thread.sleep(2000);
		
		WebElement Depositbutton = driver.findElement(depositbutton);
		clickMethod(Depositbutton);
		
		WebElement Withdraw = driver.findElement(withdraw);
		clickMethod(Withdraw);
		
	}

}
