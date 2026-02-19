package runner;

import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import utils.ConfigReader;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = { "hooks","stepdefinitions" },
		tags = "",
		//plugin = { "pretty","html:cucumber-reports.html","json:target/jsonReports/cucumber.json","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
		plugin = { 
				"pretty",
				"html:target/cucumber-reports.html",
				"json:target/jsonReports/cucumber.json",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		},
		dryRun = false,
		monochrome = false
		)
public class Runner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeClass
	@Parameters({"browserType"})
	public void beforeClass() {
		String browser = System.getProperty("browser", "chrome");
		LoggerFactory.getLogger(Runner.class)
		.info("Running tests in browser: {}", browser);
		ConfigReader.setBrowserType(browser);
	}



}









//@BeforeClass
//@Parameters({"browserType"})
//public void beforeClass(@Optional("edge") String browser) {
//  LoggerFactory.getLogger(Runner.class).info("Running tests in browser: {}", browser);
//  ConfigReader.setBrowserType(browser);
//}


