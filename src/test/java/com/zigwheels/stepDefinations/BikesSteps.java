package com.zigwheels.stepDefinations;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.zigwheels.base.DriverFactory;
import com.zigwheels.pages.BikesPage;
import com.zigwheels.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class BikesSteps 
{
	public static WebDriver driver;
	public Logger logger=LogManager.getLogger(this.getClass());
	public HomePage homePage;
	public BikesPage bikesPage;

	@Given("the user is on the ZigWheels homepage")
	public void userIsOnHomepage() throws MalformedURLException {
		logger.info("Launching ZigWheels homepage");
		driver=DriverFactory.getDriver("windows","chrome");
	    driver.get("https://www.zigwheels.com/");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    homePage = new HomePage(driver);
	    logger.info("Homepage loaded successfully");
	}

	@When("the user searches for {string}")
	public void userSearchesFor(String query) throws IOException, InterruptedException {
		logger.info("Searching for: {}", query);
	    homePage.SearchFor(query);
	}

	@Then("the page title should be {string}")
	public void validatePageTitle(String expectedTitle) {
		String actualTitle=driver.getTitle();
		logger.info("Validating page title. Expected: {}, Actual: {}", expectedTitle, actualTitle);
	    Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Then("all listed bikes should be of brand {string}")
	public void validateBikeBrand(String brand) {
	    bikesPage=new BikesPage(driver);
	    logger.info("Validating bike brand: {}", brand);
	    Assert.assertFalse(bikesPage.BikeDetailsList.isEmpty());
	    Assert.assertTrue(bikesPage.verifyAllBikesAreHonda());
	}

	@Then("all bike cards should have name, price, and launch date")
	public void validateBikeCardDetails() {
		bikesPage=new BikesPage(driver);
		logger.info("Validating bike card details");
	    Assert.assertTrue(bikesPage.verifyBikeCardDetails());
	}

	@Then("at least one bike should be priced below ₹4 Lakhs")
	public void validatePriceThreshold() {
		bikesPage=new BikesPage(driver);
//		Assert.assertTrue(false);
		logger.info("Checking for bikes priced below ₹4 Lakhs");
	    Assert.assertTrue(bikesPage.verifyPriceBelowThreshold());
	   
	}


}
