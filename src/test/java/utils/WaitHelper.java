package utils;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverfactory.DriverFactory;

public class WaitHelper {

    private static final long DEFAULT_TIMEOUT = 20; // seconds

    private static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    // Wait for element to be visible
    public static WebElement waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for element to be clickable
    public static WebElement waitForClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for element to be present in DOM by locator
    public static WebElement waitForPresence(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait for element to disappear
    public static boolean waitForInvisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // Wait for page title
    public static boolean waitForTitleContains(String title) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.titleContains(title));
    }
}
