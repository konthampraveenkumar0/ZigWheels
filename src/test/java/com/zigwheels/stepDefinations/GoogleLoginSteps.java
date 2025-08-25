package com.zigwheels.stepDefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.zigwheels.base.DriverFactory;
import com.zigwheels.pages.GoogleLoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleLoginSteps 
{
	
	public static WebDriver driver;
	public Logger logger=LogManager.getLogger(this.getClass());
	public GoogleLoginPage googleLoginPage;
	
	public GoogleLoginSteps()
	{
		driver=BikesSteps.driver;
//		driver=DriverFactory.getDriver("chrome");
	}
	
	@When("the user clicks the login button")
	public void clickLoginButton() {
//		driver=DriverFactory.getCurrentDriver();
	    googleLoginPage = new GoogleLoginPage(driver);
	    logger.info("Clicking login button");
	    googleLoginPage.clickLoginButton();
	}

	@When("clicks the Google login option")
	public void clickGoogleLogin() {
		googleLoginPage = new GoogleLoginPage(driver);
		logger.info("Clicking Google login option");
	    googleLoginPage.clickGoogleLogin();
	}

	@Then("the Google login window should open")
	public void switchToGoogleWindow() {
		googleLoginPage = new GoogleLoginPage(driver);
		logger.info("Switching to Google login window");
	    Assert.assertTrue(googleLoginPage.switchToGoogleWindow());
	}

	@When("the user enters email {string}")
	public void enterEmail(String email) {
		googleLoginPage = new GoogleLoginPage(driver);
		logger.info("Entering email: {}", email);
	    googleLoginPage.sendEmail(email);
	}

	@Then("the email error message should be displayed")
	public void validateEmailError() {
		googleLoginPage = new GoogleLoginPage(driver);
//	    System.out.println(googleLoginPage.getEmailErrorMessage2());
		String actualError = googleLoginPage.getEmailErrorMessage2();
		logger.info("Email error message received: {}", actualError);
	    Assert.assertTrue("Error message not displayed", actualError.equals("Sign in"));
	    
	}


}
