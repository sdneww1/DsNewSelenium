package stepdefinitions;

import org.testng.Assert;
import driverfactory.DriverFactory;
import pages.LunchPage;
import io.cucumber.java.en.*;

public class LunchPageSteps {

	LunchPage lunchPage = new LunchPage(DriverFactory.getDriver());

	@Given("User is in the NumpyNinja page")
	public void user_is_in_numpy_ninja_page() {
		lunchPage.navigateTo();
	}

	@When("User clicks the Get Started button for home page")
	public void user_clicks_get_started_button() {
		lunchPage.clickGetStarted();
	}

	@Then("User is navigated to home page from NumpyNinja page")
	public void user_is_navigated_to_home_page() {
		Assert.assertTrue(lunchPage.isHomePageDisplayed(), "Home page is not displayed");
	}

	@Then("User Verify the heading {string}")
	public void user_verify_the_heading(String expectedHeading) {
		String actualHeading = lunchPage.getHeadingText();
		Assert.assertEquals(actualHeading, expectedHeading);
	}

	@Then("User Verify the subheading {string}")
	public void user_verify_the_subheading(String expectedSubHeading) {
		String actualSubHeading = lunchPage.getSubHeadingText();
		Assert.assertEquals(actualSubHeading, expectedSubHeading);
	}
}
