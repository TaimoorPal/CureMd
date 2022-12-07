package Lab7_Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Main {
	WebDriver driver;
	//Logger log = Logger.getLogger("MainProgram");
	POM obj;
	Actions act;

	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject");
		//PropertyConfigurator.configure("log4j.properties");

	}

	//@AfterMethod
	//public void close() {
	//	driver.close();
	//}
	@Test
	public void Test1() throws InterruptedException {
		obj = new POM(driver);
		obj.ManagerLogin();
		obj.AddCustomer();
		obj.AddCustomerAccount("Taimoor", "Ahmed", "52000");
		obj.OpenAccount();
	}
}
