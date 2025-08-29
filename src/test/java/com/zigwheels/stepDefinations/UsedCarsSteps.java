package com.zigwheels.stepDefinations;

import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.zigwheels.pages.GoogleLoginPage;
import com.zigwheels.pages.HomePage;
import com.zigwheels.pages.UsedCars;

import io.cucumber.java.en.*;

public class UsedCarsSteps{
	protected WebDriver driver1;
	UsedCars uc;
	public UsedCarsSteps() {
		driver1 = GoogleLoginSteps.driver2;
		uc=new UsedCars(driver1);
	}
	
//	UsedCars uc=new UsedCars(driver);

	private Logger logger=LogManager.getLogger();
	
	@Given("User is already on the application")
	public void user_is_already_on_the_application() {
		System.out.println(driver1);
		logger.info("User is already on the application");
	}

	@Then("Search result is displayed")
	public void search_result_is_displayed() throws TimeoutException {
		logger.info("Search result is displayed");
//		System.out.println(driver);
		Assert.assertTrue(uc.verifyFullList());
	}

	@When("Search result equals {string}")
	public void search_result_equals(String string) {
	    logger.info("No used cars in Chennai");
	}

	@Then("{string} is displayed on the console")
	public void is_displayed_on_the_console(String string) {
		logger.info(string+" is displayed on the console");
	}

	@When("All cars used in Chennai are displayed")
	public void all_cars_used_in_chennai_are_displayed() {
		logger.info("All cars used in Chennai are displayed");
	}

	@When("User filters all the popular models")
	public void user_filters_all_the_popular_models() {
		logger.info("Filtering all popular models: ");
//		uc.checkPopularModels();
	}

	@Then("Filtered results are displayed")
	public void filtered_results_are_displayed() {
		logger.info("Filtered results are displayed");
	}

	@When("Filtered results equals {string}")
	public void filtered_results_equals(String string) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("No popular model cars used in Chennai");
	}

	@Then("Nothing is displayed on the console")
	public void nothing_is_displayed_on_the_console() {
	    logger.info("Nothing is displayed on the console");
	}

	@When("All popular car models are displayed")
	public void all_popular_car_models_are_displayed() {
		logger.info("All popular car models are displayed");
	}

	@Then("Names of all popular car models are displayed on the console")
	public void names_of_all_popular_car_models_are_displayed_on_the_console() {
		logger.info("Names of all popular car models are displayed on the console");
		driver1.close();
	}



}
