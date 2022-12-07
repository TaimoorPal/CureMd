package Lab7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class POM {
	WebDriver driver;
	Select se;

	@FindBy (xpath="//button[text()='Customer Login']")
	WebElement customerLoginButton;
	
	@FindBy (xpath="//button[text()='Bank Manager Login']")
	WebElement bankManagerLoginButton;
	
	@FindBy (xpath="//select[@id='userSelect']")
	WebElement yourNameDropDown;
	
	@FindBy (xpath="//button[@class='btn btn-default']")
	WebElement loginButton;
	
	@FindBy (xpath="//button[@ng-class='btnClass1']")
	WebElement addCustomerButton1;
	
	@FindBy (xpath="//button[@ng-class='btnClass2']")
	WebElement openAccountButton;
	
	@FindBy (xpath="//button[@ng-class='btnClass3']")
	WebElement customersButton;
	
	@FindBy (xpath="//input[@ng-model='fName']")
	WebElement firstNameField;
	
	@FindBy (xpath="//input[@ng-model='lName']")
	WebElement lastNameField;
	
	@FindBy (xpath="//input[@ng-model='postCd']")
	WebElement postalCodeField;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement addCustomerButton2;
	
	@FindBy (xpath="//select[@id='userSelect']")
	WebElement customerNameDropDown;
	
	@FindBy (xpath="//select[@id='currency']")
	WebElement currencyDropDown;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement processButton;
	
	@FindBy (xpath="//button[@ng-click='home()']")
	WebElement homeButton;
	
	@FindBy (xpath="//button[@ng-class='btnClass2']")
	WebElement depositButton;
	
	@FindBy (xpath="//button[@ng-class='btnClass3']")
	WebElement withdrawalButton;
	
	@FindBy (xpath="//input[@ng-model='amount']")
	WebElement depositAmountField;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement depositButton2;
	
	@FindBy (xpath="//input[@ng-model='amount']")
	WebElement withdrawalAmountField;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement withDrawalButton2;
	
	@FindBy (xpath="//button[@ng-show='showDate']")
	WebElement resetButton;
	
	public void ManagerLogin() {
		bankManagerLoginButton.click();
	}
	public void AddCustomer() {
		addCustomerButton1.click();
	}
	public void AddCustomerAccount(String fname, String lname, String postalcode) {
		firstNameField.sendKeys(fname);
		lastNameField.sendKeys(lname);
		postalCodeField.sendKeys(postalcode);
		addCustomerButton2.click();
	}
	public void OpenAccount() {
		se = new Select(customerNameDropDown);
		se.selectByValue(null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public POM(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }
}
