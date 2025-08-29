package com.zigwheels.stepDefinations;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import com.zigwheels.pages.GoogleLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleLoginSteps 
{
	
	protected static WebDriver driver2;
	public Logger logger=LogManager.getLogger(this.getClass());
	public GoogleLoginPage googleLoginPage;
	public static String current_id;
	
	public GoogleLoginSteps()
	{
		
//		UsedCarsSteps us=new UsedCarsSteps();
		driver2=BikesPageSteps.driver;
		
		googleLoginPage=new GoogleLoginPage(driver2);
		
		
	}
	@Given("the user is on the ZigWheels homepage")
	public void the_user_is_on_the_zig_wheels_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver2.navigate().back();
		driver2.navigate().to("https://zigwheels.com");
		logger.info("User is on the homepage");
    
	}

	@When("the user clicks the login button")
	public void clickLoginButton() {
	    googleLoginPage = new GoogleLoginPage(driver2);
	    logger.info("Clicking login button");
	    googleLoginPage.clickLoginButton();
	}
	
	@Then("all the login options should be displayed correctly")
	public void all_the_login_options_should_be_displayed_correctly() {
	    // Write code here that turns the phrase above into concrete actions
		googleLoginPage = new GoogleLoginPage(driver2);
		 
        String actualFaceBookText = googleLoginPage.getFaceBookText();
        String actualAppleText = googleLoginPage.getAppleText();
        String actualGoogleText = googleLoginPage.getGoogleText();
 
        logger.info("Facebook Text: {}", actualFaceBookText);
        logger.info("Apple Text: {}", actualAppleText);
        logger.info("Google Text: {}", actualGoogleText);
 
        boolean allMatch = actualFaceBookText.equals("Facebook") &&
                           actualAppleText.equals("Apple") &&
                           actualGoogleText.equals("Google");
 
        Assert.assertTrue(allMatch, "One or more login button texts do not match expected values.");
	}
	
	@When("clicks the Google login option")
	public void clickGoogleLogin() {
//		googleLoginPage = new GoogleLoginPage(driver2);
		logger.info("Clicking Google login option");
		current_id=driver2.getWindowHandle();
	    googleLoginPage.clickGoogleLogin();
	}

	@Then("the Google login window should open")
	public void switchToGoogleWindow() {
//		googleLoginPage = new GoogleLoginPage(driver2);
		logger.info("Switching to Google login window");
		System.out.println(current_id);
	    Assert.assertTrue(googleLoginPage.switchToGoogleWindow());
	}

	@When("the user enters email {string}")
	public void enterEmail(String email) {
//		googleLoginPage = new GoogleLoginPage(driver2);
		logger.info("Entering email: {}", email);
	    googleLoginPage.sendEmail(email);
	    
	}

	@Then("the email error message should be displayed")
	public void validateEmailError() {
//		googleLoginPage = new GoogleLoginPage(driver2);
		String actualError = googleLoginPage.getEmailErrorMessage2();
		logger.info("Email error message received: {}", actualError);
	    Assert.assertTrue(actualError.equals("Sign in"),"Error message not displayed");
	    driver2.close();
	    driver2.switchTo().window(current_id);
	    driver2.navigate().refresh();
	   
	}


}

