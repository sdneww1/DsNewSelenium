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

public class LunchPage {

    public WebDriver driver;
    private WebDriverWait wait;
    private static Logger logger = LogManager.getLogger(LunchPage.class);

    @FindBy(xpath = "//button[text()='Get Started']")
    private WebElement getStartedBtn;

    @FindBy(tagName = "h1")
    private WebElement heading;

    @FindBy(tagName = "p")
    private WebElement subHeading;

    public LunchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateTo() {
        driver.get(ConfigReader.getUrl());
        logger.info("Navigated to Home Page");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getHeadingText() {
        return heading.getText();
    }

    public String getSubHeadingText() {
        return subHeading.getText();
    }

    public void clickGetStarted() {
        WaitHelper.waitForClickable(getStartedBtn).click();
        logger.info("Clicked Get Started button");
    }

    public boolean isHomePageDisplayed() {
        return getPageTitle().contains("NumpyNinja");
    }
}



