package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

import utils.WaitHelper;


public class LoginPage {
	
	public WebDriver driver;
	WebDriverWait wait;
	private static Logger logger = LogManager.getLogger();	
	
	 @FindBy(xpath = "//button[text()='Get Started']")
	    private WebElement getStartedBtn;
	 
	 public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	 
//	 public LoginPage(WebDriver driver) {
//			this.driver = driver;
//			PageFactory.initElements(driver, this);
//			
//		}
	 
	 
	 // Common navigation
	    public void navigateTologin(String url) {
	    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.get(ConfigReader.getUrl() + "login");
	    }

	    // Common page title
	    public String getPageTitle() {
	        return driver.getTitle();
	    }

	    // Click Get Started button
	    public void clickGetStarted() {
	        WaitHelper.waitForClickable(getStartedBtn).click();
	    }

	    // Verify Home Page title
	    public boolean isHomePageDisplayed() {
	        return getPageTitle().contains("NumpyNinja");
	    }
	    
	 

	        @FindBy(id = "id_username")
	        WebElement username;

	        @FindBy(id = "id_password")
	        WebElement password;

	        @FindBy(css = "input[type='submit'][value='Login']")
	        WebElement loginButton;

	        public void enterUsername(String user) {
	            username.clear();
	            username.sendKeys(user);
	        }

	        public void enterPassword(String pass) {
	            password.clear();
	            password.sendKeys(pass);
	        }

	        public void clickLogin() {
	            loginButton.click();
	        }
	        
	        @FindBy(xpath = "//div[@role='alert']")
	        WebElement loginMessage;

	        public String getLoginSuccessMessage() {
	            //return loginMessage.getText().trim();
	        	wait.until(ExpectedConditions.visibilityOf(loginMessage));
	            return loginMessage.getText().trim();
	        }

	    }
	    






