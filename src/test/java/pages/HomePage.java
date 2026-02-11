package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

import utils.WaitHelper;


public class HomePage {
	
	public WebDriver driver;
	WebDriverWait wait;
	private static Logger logger = LogManager.getLogger();	
	
	 @FindBy(xpath = "//button[text()='Get Started']")
	    private WebElement getStartedBtn;
	 
	 public HomePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
	 
	 
	 // Common navigation
	    public void navigateTo(String url) {
	    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.get(ConfigReader.getUrl());
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

}



