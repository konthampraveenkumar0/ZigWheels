package com.zigwheels.tests;

import java.net.MalformedURLException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.zigwheels.base.DriverFactory;
import com.zigwheels.pages.BikesPage;
import com.zigwheels.pages.GoogleLoginPage;
import com.zigwheels.pages.HomePage;
import com.zigwheels.testBase.BaseClass;
import com.zigwheels.utilities.ConfigReader;

public class demo extends BaseClass
{
	
	public HomePage homePage;
	public BikesPage bikesPage;
	public GoogleLoginPage googleLoginPage;
	
	public void setup()
	{
		logger=LogManager.getLogger(this.getClass());
		driver=DriverFactory.getDriver(ConfigReader.getBrowser());
		driver.get(ConfigReader.getAppUrl());
		logger.info("URL launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( 10));
		logger.info("Window got maximised");

	}
	

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=10)
	public void navigateToNewWindow()
	{
		googleLoginPage.clickLoginButton();
		googleLoginPage.clickGoogleLogin();
		Assert.assertTrue(googleLoginPage.switchToGoogleWindow(), "Window not changed");
	}
	
	@Test(priority=11)
	public void validateEmail(String email)
	{
		googleLoginPage.sendEmail(email);
		System.out.println(googleLoginPage.getEmailErrorMessage());
	}

}
