package Example;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
	
	WebDriver driver;

	Util obj ;
	String parentHandle;
	@BeforeMethod
	public void Setup() throws InterruptedException { //Before every method opening a new chrome driver for fresh environment
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\4397\\Documents\\SQA\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		PropertyConfigurator.configure("log4j.properties");

		obj = new Util(driver);
		driver.manage().window().maximize(); //Maximizing the current window
		driver.get("https://omayo.blogspot.in/");
		Thread.sleep(2000);
		
	}
	@AfterMethod //After every method waiting for 2 seconds and then close the browser
	public void Close() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}
	@Test(priority = 1, description = "This method test the first and second text field and valdiating their working by using assertion")
	public void Task1() throws InterruptedException {
		obj.Task1("Taimoor Ahmed Pal", "Haha123");
	}
	@Test(priority = 2, description = "This method gets the table from the provided web page and then print it on the console")
	public void Task2() throws InterruptedException{
		obj.Task2("Taimoor Ahmed Pal", "Haha123");

	}
	@Test(priority = 3, description = "This method test the switching of parentframe to frame1 and then frame 2")
	public void Task3() throws InterruptedException {
		obj.Task3(driver, "Taimoor Pal", "Password");
	}
	
	@Test(priority = 4, description = "This method test the clicking clearing and all about handling the alert when it is displayed")
	public void Task4() throws InterruptedException {
		obj.Task4(driver);
	}
	@Test(priority = 5, description = "This method test the radio buton, checkboxes, prompt handling and accessing dropdown")
	public void Task5() throws InterruptedException {
		obj.Task5(driver, "Taimoor Ahmed Pa");
	}
}
