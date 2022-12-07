package Lab7;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import RobotClassAssignment.POM;

public class Main {

	WebDriver driver;
	Logger log = Logger.getLogger("MainProgram");
	POM obj;
	Actions act;

	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\4397\\Documents\\SQA\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject");
		PropertyConfigurator.configure("log4j.properties");

	}

	@AfterMethod
	public void close() {
		driver.close();
	}
	public void Test1() {
		
	}
}
