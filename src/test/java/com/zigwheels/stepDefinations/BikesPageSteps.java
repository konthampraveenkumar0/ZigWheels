package com.zigwheels.stepDefinations;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.zigwheels.pages.BikesPage;
import com.zigwheels.pages.HomePage;
import com.zigwheels.utilities.ConfigReader;
import com.zigwheels.base.DriverFactory;


import io.cucumber.java.en.*;

public class BikesPageSteps {
	
	protected static WebDriver driver;
	HomePage hp;
	BikesPage bp;
	private Logger logger=LogManager.getLogger();
//	StepDefinition sd=new StepDefinition();
	
	@Given("User launch the browser")
	public void user_launch_the_browser() throws MalformedURLException {
		driver=DriverFactory.getDriver("windows",ConfigReader.getBrowser());
	}

	@When("User opens the url {string}")
	public void user_opens_the_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( 10));
		
	}
	@When("User clicks on the search bar")
	public void user_clicks_on_the_search_bar() {
	    // Write code here that turns the phrase above into concrete actions
		hp=new HomePage(driver);
//		sd.clickSearchBar();
		logger.info("Click the search bar");
	}
	@When("User enters {string} in the search bar")
	public void user_enters_in_the_search_bar(String string) throws IOException, InterruptedException {
		System.out.println(driver);
		hp.SearchFor(string);
	}

	@When("User clicks down arrow key")
	public void user_clicks_down_arrow_key() {
		logger.info("Down arrow key pressed");
	}

	@When("User clicks enter")
	public void user_clicks_enter() {
//	    sd.clicksEnter();
		logger.info("Enter key clicked");
	}

	@Then("All bikes are displayed")
	public void validateBikeCardDetails() {
	    bp=new BikesPage(driver);
	    logger.info("Validating bike brand: Honda");
	    Assert.assertFalse(bp.BikeDetailsList.isEmpty());
	    Assert.assertTrue(bp.verifyAllBikesAreHonda());
	    logger.info("Validating bike card details");
	    Assert.assertTrue(bp.verifyBikeCardDetails());
	}
	@Then("Honda bikes with price less than {string} lacs are displayed on the console")
	public void validatePriceThreshold(String string) {
		bp=new BikesPage(driver);
	    Assert.assertEquals(bp.verifyPriceBelowThreshold(), true);
	}
}
