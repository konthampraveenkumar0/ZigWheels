package com.zigwheels.stepDefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.zigwheels.base.DriverFactory;
import com.zigwheels.pages.HomePage;
import com.zigwheels.pages.UsedCars;

import io.cucumber.java.en.Then;

public class UsedCarsSteps 
{
	
	public WebDriver driver=null;
	public Logger logger=LogManager.getLogger(this.getClass());
	public HomePage homePage;
	public UsedCars usedCars;
	
	public UsedCarsSteps()
	{
		driver=BikesSteps.driver;
//		driver=DriverFactory.getDriver("chrome");
	}

//	@When("the user searches for {string}")
//	public void userSearchesForUsedCars(String query) throws IOException, InterruptedException {
//	    homePage.SearchFor(query);
//	    usedCars = new UsedCars(driver);
//	}

	@Then("the used car list should be displayed")
	public void validateUsedCarList() {
//		driver=DriverFactory.getCurrentDriver();
		logger.info("Validating used car list");
		usedCars=new UsedCars(driver);
	    Assert.assertTrue("Used car list is not displayed",usedCars.verifyFullList());
	}

	@Then("popular car models should be visible")
	public void validatePopularModels() {
		logger.info("Checking for popular car models");
		usedCars=new UsedCars(driver);
	    Assert.assertTrue("Popular car models not visible",usedCars.checkPopularModels());
	   
	}

}
