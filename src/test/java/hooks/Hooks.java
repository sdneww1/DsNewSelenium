package hooks;

import java.util.Collection;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hooks.Hooks;
import driverfactory.DriverFactory;
import utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

	private WebDriver driver;
	public static Collection<String> scenarioTags;
	private static final Logger logger =
	        LoggerFactory.getLogger(Hooks.class);

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
		scenarioTags = scenario.getSourceTagNames(); 
		logger.info("Starting test '{}' ",
                scenario.getName(), scenarioTags);
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
