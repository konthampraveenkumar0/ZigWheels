package com.zigwheels.stepDefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import com.zigwheels.pages.GoogleLoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleLoginSteps 
{
	
	public static WebDriver driver2=null;
	public Logger logger=LogManager.getLogger(this.getClass());
	public GoogleLoginPage googleLoginPage;
	
	public GoogleLoginSteps()
	{
		driver2=BikesSteps.driver;
//		googleLoginPage=new GoogleLoginPage(driver2);
		
	}
	
	@When("the user clicks the login button")
	public void clickLoginButton() {
//		driver2.navigate().back();
	    googleLoginPage = new GoogleLoginPage(driver2);
	    logger.info("Clicking login button");
	    googleLoginPage.clickLoginButton();
	}

	@When("clicks the Google login option")
	public void clickGoogleLogin() {
		googleLoginPage = new GoogleLoginPage(driver2);
		logger.info("Clicking Google login option");
	    googleLoginPage.clickGoogleLogin();
	}

	@Then("the Google login window should open")
	public void switchToGoogleWindow() {
		googleLoginPage = new GoogleLoginPage(driver2);
		logger.info("Switching to Google login window");
	    Assert.assertTrue(googleLoginPage.switchToGoogleWindow());
	}

	@When("the user enters email {string}")
	public void enterEmail(String email) {
		googleLoginPage = new GoogleLoginPage(driver2);
		logger.info("Entering email: {}", email);
	    googleLoginPage.sendEmail(email);
	}

	@Then("the email error message should be displayed")
	public void validateEmailError() {
		googleLoginPage = new GoogleLoginPage(driver2);
//	    System.out.println(googleLoginPage.getEmailErrorMessage2());
		String actualError = googleLoginPage.getEmailErrorMessage2();
		logger.info("Email error message received: {}", actualError);
	    Assert.assertTrue(actualError.equals("Sign in"),"Error message not displayed");
	    
	}


}
