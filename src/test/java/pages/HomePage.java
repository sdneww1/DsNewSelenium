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
    private WebDriverWait wait;
    private static Logger logger = LogManager.getLogger(HomePage.class);

    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToHome() {
        driver.get(ConfigReader.getUrl() + "home");
        logger.info("Navigated to Home Page");
    }

    public String getPageTitleL() {
        return driver.getTitle();
    }

   
    public boolean isHomePageDisplayed() {
        return getPageTitleL().contains("NumpyNinja");
    }
    
    @FindBy(xpath = "//a[@class='navbar-brand']")
    private WebElement homePageHeading;

    public String getHomePageHeading() {
        return homePageHeading.getText();
    }
}



