package stepdefinitions;

import org.testng.Assert;
import driverfactory.DriverFactory;
import pages.HomePage;
import utils.ConfigReader;
import io.cucumber.java.en.*;

public class HomePageSteps {

	HomePage homePage = new HomePage(DriverFactory.getDriver());

	@Given("User is in the NumpyNinja page")
	public void user_is_in_numpy_ninja_page() {
		homePage.navigateTo(ConfigReader.getUrl());
	}

	@When("User clicks the Get Started button for home page")
	public void user_clicks_get_started_button() {
		homePage.clickGetStarted();
	}

	@Then("User is navigated to home page from NumpyNinja page")
	public void user_is_navigated_to_home_page() {
		Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed");
	}
}
