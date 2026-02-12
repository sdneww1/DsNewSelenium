package stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverfactory.DriverFactory;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExcelReader;
import io.cucumber.java.en.*;

public class LoginPageSteps {
	private static Logger logger = LogManager.getLogger();
	private HomePage homePage;
	private LoginPage loginPage;
    WebDriver driver;
	
	public LoginPageSteps() {
		
		 driver = DriverFactory.getDriver();
	        homePage = new HomePage(driver);
	        loginPage = new LoginPage(driver);
//		HomePage homePage = new HomePage(DriverFactory.getDriver());
//		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	}

	@Given("User is on the Signin page")
	public void user_is_on_signin_page() {
		driver.get(ConfigReader.getUrl() + "login");
		 
	}

	@When("The user clicks login button with valid credentials from sheet {string} with {string}")
	public void user_login_with_excel_data(String sheetName, String testcaseId) throws IOException {

	    Map<String, String> testData = ExcelReader.getTestData(sheetName, testcaseId);

	    loginPage.enterUsername(testData.get("UserName"));
	    loginPage.enterPassword(testData.get("Password"));
	    loginPage.clickLogin();
	}
	
	@Then("The user should navigate to Data Structure Home Page with message {string}")
	public void verify_login_success(String expectedMessage) {

	    String actualMessage = loginPage.getLoginSuccessMessage();

	    Assert.assertEquals(actualMessage, expectedMessage);
	}

}
