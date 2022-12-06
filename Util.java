package Example;

import java.time.Duration;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Util {
	Logger log1 = Logger.getLogger("Util");
	WebDriver driver;
	@FindBy (xpath="//textarea[@id='ta1']")
	WebElement textArea1;
	
	@FindBy (xpath="//textarea[contains(text(),'The cat was playing in the garden.')]")
	WebElement textArea2;
	
	@FindBy (xpath="//table[@id='table1']")
	WebElement table1;
	
	@FindBy (xpath="//form[@name='form1']/child::input[@type='text']")
	WebElement userName1;
	
	@FindBy (xpath="//form[@name='form1']/child::input[@type='password']")
	WebElement password1;
	
	@FindBy (xpath="//button[@type='button']")
	WebElement loginButton1;
	
	@FindBy (xpath="//iframe[@id='iframe1']")
	WebElement frame1;
	
	@FindBy (xpath="//iframe[@id='iframe2']")
	WebElement frame2;
	
	@FindBy (xpath="//input[@name='userid']")
	WebElement userName2;
	
	@FindBy (xpath="//input[@name='pswrd']")
	WebElement password2;
	
	@FindBy (xpath="//input[@value='Login']")
	WebElement loginButton2;
	
	@FindBy (xpath="//select[@id='multiselect1']")
	WebElement dropDown1;
	
	@FindBy (xpath="//input[@name='fname']")
	WebElement preLoadedField;
	
	@FindBy (xpath="//button[@id='but2']")
	WebElement button2;
	
	@FindBy (xpath="//button[contains(text(),'Submit')]")
	WebElement submit;
	
	@FindBy (xpath="//button[contains(text(),'Login')]")
	WebElement loginButton3;
	
	@FindBy (xpath="//button[contains(text(),'Register')]")
	WebElement register;
	
	@FindBy (xpath="//input[@id='alert2']")
	WebElement alert1;
	
	@FindBy (xpath="//a[contains(text(),'Open a popup window')]")
	WebElement popUpWindow;
	
	@FindBy (id="para1")
	WebElement para1;
	
	@FindBy (id="para2")
	WebElement para2;
	
	@FindBy (xpath="//button[contains(text(),'Try it')]")
	WebElement tryItButton;
	
	@FindBy (xpath="//button[contains(text(),' Double click Here   ')]")
	WebElement doubleClickButton1;
	
	@FindBy (xpath="//button[contains(text(),'Check this')]")
	WebElement checkThisButton;
	
	@FindBy (xpath="//input[@id='radio1']")
	WebElement radioButton1;
	
	@FindBy (xpath="//input[@id='alert1']")
	WebElement alert2;
	
	@FindBy (id="checkbox1")
	WebElement checkBox1;
	
	@FindBy (id="checkbox2")
	WebElement checkBox2;
	
	@FindBy (id="rotb")
	WebElement textArea3;
	
	@FindBy (xpath="//input[@value='GetPrompt']")
	WebElement getPromptButton;
	
	@FindBy (xpath="//input[@value='GetConfirmation']")
	WebElement getConfirmationButton;
	
	@FindBy (xpath="//div[@id='HTML24']/child::div/input[@class='classone']")
	WebElement textArea4;
	
	@FindBy (xpath="//div[@id='HTML28']/child::div/input[@class='classone']")
	WebElement textArea5;
	
	@FindBy (xpath="//input[@value='Car']")
	WebElement radioButton2;
	
	@FindBy (xpath="//input[@value='Bag']")
	WebElement checkBox3;
	
	@FindBy (xpath="//input[@value='Book']")
	WebElement checkBox4;
	
	@FindBy (xpath="//p[@id='testdoubleclick']")
	WebElement doubleClickButton2;
	
	@FindBy (xpath="//a[@href='http://facebook.com']")
	WebElement faceBook;
	
	
	public void Task1(String text1, String text2) throws InterruptedException {
		//Sending keys to the first text field
		textArea1.sendKeys(text1);
		log1.info("textArea1 is filled");
		String t1 = textArea1.getAttribute("value");
		Assert.assertEquals(t1, "\n" + "Taimoor Ahmed Pal", "expected does not match with actual test" );
		log1.info("textArea1 assertion passed");
		Thread.sleep(2000);
		//Getting the text written in the second text field
		String textField2 = textArea2.getText();
		System.out.println(textField2);
		//Clearing the 2nd text field
		textArea2.clear();
		//Sending keys to the 2nd text field
		textArea2.sendKeys(text2);
		log1.info("textArea2 is filled");
		String t2 = textArea2.getAttribute("value");
		Assert.assertEquals(t2, text2, "expected does not match with actual test" );
		log1.info("textArea2 assertion passed");

	}
	public void Task2(String text1, String text2) throws InterruptedException {
		//Storing the rows in a variable
		List<WebElement> rows = table1.findElements(By.tagName("tr"));
		//Starting a loop to locate the colmn elements and then printing it
		for (int i = 0; i < rows.size();i++) {
			List<WebElement> columns= rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < columns.size();j++) {
				System.out.println(columns.get(j).getText() + "---");
			}
			System.out.println("");
			log1.info("Table is  Printed");

			
		}
		//locating the username, password field and sending keys and then pressing the lgin button
		userName1.sendKeys(text1);
		log1.info("Username1 Field is filled");

		Thread.sleep(3000);
		password1.sendKeys(text2);
		log1.info("Password1 Field is filled");

		Thread.sleep(3000);
		loginButton1.click();
		log1.info("LoginButton is Clicked");

	}
	public void Task3(WebDriver driver, String text1 , String text2) throws InterruptedException {
		this.driver = driver;
		String parentHandle = driver.getWindowHandle();
		Actions act = new Actions(driver);
		//Scrolling down to the page where the frames are present
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		log1.info("HomePage is Scroll down");

		Thread.sleep(3000);
		
		//Switching to first frame
		driver.switchTo().frame(frame1);
		String actualTitle1 = driver.getTitle();
		Assert.assertEquals(actualTitle1, "omayo (QAFox.com)");
		log1.info("Frame1 Assertion Passed");

		//Switching to the parent handle
		driver.switchTo().window(parentHandle);
		//switching to the second frame
		driver.switchTo().frame(frame2);
		String actualTitle2 = driver.getTitle();
		Assert.assertEquals(actualTitle2, "omayo (QAFox.com)");
		log1.info("Frame2 assertion passed");
		driver.switchTo().window(parentHandle);
		//locating the username, password field and sending keys and then pressing the lgin button
		Thread.sleep(3000);
		userName2.sendKeys(text1);
		log1.info("Username2 Field is filled");
		Thread.sleep(3000);
		password2.sendKeys(text2);
		log1.info("Password2 Field is filled");
		Thread.sleep(3000);
		loginButton2.click();
		log1.info("LoginButton2 is Clicked");
		Thread.sleep(3000);
		//Handling the alert of wrong userename or password
		driver.switchTo().alert().accept();
	}
	public void Task4(WebDriver driver) throws InterruptedException {
		

		this.driver = driver;
		String parentHandle = driver.getWindowHandle();
		dropDown1.findElement(By.xpath("//option[@value='Hyundaix']")).click();
		log1.info("Hyundai is selected from he dropdown");

		Thread.sleep(3000);
		Select dropdown1 = new Select(driver.findElement(By.id("drop1")));
		log1.info("doc3 is selected from he dropdown");
		Thread.sleep(3000);
		dropdown1.selectByValue("jkl");
		preLoadedField.clear();
		log1.info("Preloaded text is cleared");
		Thread.sleep(3000);
		preLoadedField.sendKeys("Hello World");
		log1.info("Hello World is written on the field");
		Thread.sleep(3000);
		button2.click();
		log1.info("Button2 is pressed");
		Thread.sleep(3000);
		submit.click();
		log1.info("Sbbmit button is clicked");
		Thread.sleep(3000);
		loginButton3.click();
		log1.info("Loginbutton3 is clicked");
		Thread.sleep(3000);
		register.click();
		log1.info("registerbutton is clicked");

		Thread.sleep(3000);
		alert1.click();
		log1.info("alert1 is clicked");

		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		popUpWindow.click();
		log1.info("popUpWindow is clicked");

		SwitchingWindow(driver);		
		System.out.println(para1.getText());
		System.out.println(para2.getText());
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(parentHandle);
		tryItButton.click();
		log1.info("tryItButton is clicked");

		
		Actions act = new Actions(driver);
		act.doubleClick(doubleClickButton1).build().perform();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();

		checkThisButton.click();
		log1.info("checkThisButton is clicked");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='dte']")));
		element.click();
	}
	public void Task5(WebDriver driver, String enterName) throws InterruptedException {
		this.driver = driver;
		radioButton1.click();
		log1.info("radioButton1 is clicked");
		Thread.sleep(3000);
		
		alert2.click();
		log1.info("alert2 is clicked");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		checkBox2.click();
		log1.info("checkBox2 is clicked");

		Thread.sleep(2000);
		checkBox1.click();
		log1.info("checkBox1 is clicked");

		Thread.sleep(2000);

		textArea3.getText();
		log1.info("textArea3 is clicked");

		System.out.println(textArea3);
		Thread.sleep(2000);

		getPromptButton.click();
		log1.info("getPromptButton is clicked");
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys(enterName);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		getConfirmationButton.click();
		log1.info("getConfirmationButton is clicked");

		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		textArea4.sendKeys("Located with the help of parent class HTML24");
		Thread.sleep(2000);
		textArea5.sendKeys("Located with the help of parent class HTML28");

		Thread.sleep(2000);
		radioButton2.click();
		log1.info("radioButton2 is clicked");

		Thread.sleep(2000);
		checkBox3.click();
		log1.info("checkBox3 is clicked");

		Thread.sleep(2000);
		checkBox4.click();
		log1.info("checkBox4 is clicked");

		Thread.sleep(2000);

		Actions act = new Actions(driver);
		act.doubleClick(doubleClickButton2).build().perform();
		log1.info("doubleClickButton2 is double clicked");

		Thread.sleep(3000);
		faceBook.click();
		log1.info("faceBook is clicked");

	}
	public static void SwitchingWindow(WebDriver driver) {
		for (String myhandler : driver.getWindowHandles()) {
			driver.switchTo().window(myhandler);
		}
		}
	
    public Util(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
}
