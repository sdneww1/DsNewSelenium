package driverfactory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver initBrowser(String browserType) {
		if (browserType == null || browserType.isEmpty()) {
			throw new IllegalArgumentException("Browser type must be provided!");
		}

		browserType = browserType.trim().toLowerCase();
		BrowserOptions options = new BrowserOptions();

		switch (browserType) {
		case "chrome":
			driver.set(new ChromeDriver(options.chromeOption()));
			break;
		case "edge":
			driver.set(new EdgeDriver(options.edgeOption()));
			break;
		case "firefox":
			driver.set(new FirefoxDriver(options.firefoxOption()));
			break;
		default:
			throw new IllegalStateException("Unexpected browserType: " + browserType);
		}

		WebDriver drv = getDriver();
		drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		drv.manage().window().maximize();
		drv.manage().deleteAllCookies();

		return drv;
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove(); // important for parallel tests
		}
	}
}
