package com.zigwheels.stepDefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import com.zigwheels.pages.HomePage;
import com.zigwheels.pages.UsedCars;

import io.cucumber.java.en.Then;

public class UsedCarsSteps {

	
	public static WebDriver driver1;
	public Logger logger=LogManager.getLogger(this.getClass());
	public HomePage homePage;
	public UsedCars usedCars;
	
	public UsedCarsSteps()
	{
		driver1=GoogleLoginSteps.driver2;
//		usedCars=new UsedCars(driver1);
	}

//	@When("the user searches for {string}")
//	public void userSearchesForUsedCars(String query) throws IOException, InterruptedException {
//	    homePage.SearchFor(query);
//	    usedCars = new UsedCars(driver);
//	}

	@Then("the used car list should be displayed")
	public void validateUsedCarList() {
		logger.info("Validating used car list");
		usedCars=new UsedCars(driver1);
	    Assert.assertTrue(usedCars.verifyFullList(),"Used car list is not displayed");
	}

	@Then("popular car models should be visible")
	public void validatePopularModels() {
		logger.info("Checking for popular car models");
		usedCars=new UsedCars(driver1);
//	    Assert.assertTrue(usedCars.checkPopularModels(),"Popular car models not visible");
	   
	}

}
