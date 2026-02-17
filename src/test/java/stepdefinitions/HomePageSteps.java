package stepdefinitions;

import org.testng.Assert;
import driverfactory.DriverFactory;
import pages.HomePage;
import io.cucumber.java.en.*;

public class HomePageSteps {

	HomePage homePage = new HomePage(DriverFactory.getDriver());
	
	@Given("User is in the NumpyNinja Home page")
	public void user_is_in_numpy_ninja_home_page() {
		homePage.navigateToHome();
	}

	  @Then("User Verify the title {string}")
	    public void user_verify_the_heading(String expectedHeading) {
	        String actualHeading = homePage.getHomePageHeading();
	        Assert.assertEquals(actualHeading, expectedHeading);
	    }
}
