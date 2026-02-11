package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

	private WebDriver driver;

	@BeforeAll
	public static void loadConfig() {
		ConfigReader.loadProperties();
	}

//    @Before
//    public void setup(Scenario scenario) {
//        driver = DriverFactory.initBrowser(ConfigReader.getBrowserType());
//        driver.get(ConfigReader.getUrl());
//    }
	@Before
	public void setup(Scenario scenario) {
		String browser = ConfigReader.getBrowserType(); // get browser type
		System.out.println("=== Starting test in browser: " + browser + " ==="); // print to console
		driver = DriverFactory.initBrowser(browser);
		driver.get(ConfigReader.getUrl());
	}

	@AfterStep
	public void takeScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
