
package Github;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
@Test
public class GithubLogin {
	WebDriver driver;
	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\4397\\Documents\\SQA\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority=0)
	public void ValidPassUser() throws InterruptedException {
		
		driver.get("https://github.com/login");
		driver.manage().window().maximize();
		System.out.println("Signinn page is opened");
		Thread.sleep(3000);
		driver.findElement(By.id("login_field")).sendKeys("TaimoorPal");
		driver.findElement(By.id("password")).sendKeys("Taimoorpal123!@#");
		driver.findElement(By.name("commit")).click();
		Thread.sleep(3000);

		Assert.assertEquals(driver.getTitle(), "GitHub");
		driver.close();


	}
	@Test(priority=1)
	public void InvalidPassword() throws InterruptedException {
		driver.get("https://github.com/login");
		driver.manage().window().maximize();
		System.out.println("Signinn page is opened");
		Thread.sleep(3000);
		driver.findElement(By.id("login_field")).sendKeys("TaimoorPal12");
		driver.findElement(By.id("password")).sendKeys("Taimoorpal12");
		driver.findElement(By.name("commit")).click();
		Thread.sleep(3000);
		String expected = "Incorrec username or password";
		WebElement actual = driver.findElement(By.xpath("//div[@class='flash flash-full flash-error  ']"));
		Assert.assertEquals(actual, expected);
		//driver.quit();
	}
	@Test(priority=2)

	public void Null() throws InterruptedException {
		driver.get("https://github.com/login");
		driver.manage().window().maximize();
		System.out.println("Signinn page is opened");
		Thread.sleep(3000);
		driver.findElement(By.id("login_field")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.name("commit")).click();
		Thread.sleep(3000);
	}
	@Test(priority=3)

	public void SpecialCharacters() throws InterruptedException {
		driver.get("https://github.com/login");
		driver.manage().window().maximize();
		System.out.println("Signinn page is opened");
		Thread.sleep(3000);
		driver.findElement(By.id("login_field")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.name("commit")).click();
		Thread.sleep(3000);
	}
	@Test(priority=4)

	public void SearchField() throws InterruptedException {
		driver.get("https://github.com/login");
		driver.manage().window().maximize();
		System.out.println("Signinn page is opened");
		Thread.sleep(3000);
		driver.findElement(By.id("login_field")).sendKeys("TaimoorPal");
		driver.findElement(By.id("password")).sendKeys("Taimoorpal123!@#");
		driver.findElement(By.name("commit")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("TaimoorPal/CureMD"+Keys.ENTER);
		Thread.sleep(3000);
	}
	
	
}
