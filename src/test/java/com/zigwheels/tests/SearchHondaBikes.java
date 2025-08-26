package com.zigwheels.tests;
import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zigwheels.pages.BikesPage;
import com.zigwheels.pages.GoogleLoginPage;
import com.zigwheels.pages.HomePage;
import com.zigwheels.pages.UsedCars;
import com.zigwheels.testBase.BaseClass;
import com.zigwheels.utilities.ExcelUtils;
public class SearchHondaBikes extends BaseClass
{
	
	
	public HomePage homePage;
	public BikesPage bikesPage;
	public UsedCars usedCars;
	public GoogleLoginPage googleLoginPage;
	public String SearchData[];

	
	//testcases for honda bikes 
	
	@Test(priority=1)
	public void verifyNavigationtoUpcomingHondaBikes() throws IOException, InterruptedException
	{
		homePage=new HomePage(driver);
		logger.info("Homepage loaded successfully");
		Thread.sleep(3000);
		SearchData=ExcelUtils.getFileDetails();
		homePage.SearchFor(SearchData[0]);
		logger.info("navigated to upcoming honda bikes");
		Assert.assertEquals(driver.getTitle(),"Honda Upcoming Bikes in India - Check Price, Launch Date, Images and Latest News");
	}

	@Test(priority=2)
	public void testSearchUpcomingHondaBikes()
	{
		bikesPage=new BikesPage(driver);
		logger.info("Validating bike brand: Honda");
		Assert.assertFalse(bikesPage.BikeDetailsList.isEmpty(), "Bike list is empty");
		Assert.assertTrue(bikesPage.verifyAllBikesAreHonda(),"Not all bikes are Honda brand");
		
	}
	
	@Test(priority=3)
	public void testBikeCardDetails()
	{
		bikesPage=new BikesPage(driver);
		logger.info("Validating bike card details");
		Assert.assertTrue(bikesPage.verifyBikeCardDetails(),"Some bike cards have missing details");
	}
	
	@Test(priority = 4)
    public void testPriceBelowThreshold() {
		bikesPage=new BikesPage(driver);
		logger.info("Checking for bikes priced below ₹4 Lakhs");
        Assert.assertTrue(bikesPage.verifyPriceBelowThreshold(), "No bikes found under ₹4 Lakhs");
    }
	
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//used cars in chennai
	
	
	@Test(priority=11)
	public void validateCars() throws IOException, InterruptedException
	{
		homePage.SearchFor(SearchData[1]);
		usedCars=new UsedCars(driver);
		logger.info("Validating used car list");
		Assert.assertTrue(usedCars.verifyFullList());
		
	}
	
	@Test(priority=12,dependsOnMethods= {"validateCars"})
	public void checkBoxes() throws InterruptedException
	{
		System.out.println();
		logger.info("Checking for popular car models");
//		Assert.assertTrue(usedCars.checkPopularModels(),"No popular cars displayed");
	}
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	google login 
	
	
	@Test(priority=21)
	public void navigateToNewWindow() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
////		homePage.goToHomePage();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
//		googleLoginPage.clickLoginButton();
//		googleLoginPage.clickGoogleLogin();
//		Assert.assertTrue(googleLoginPage.switchToGoogleWindow(), "Window not changed");
		
		googleLoginPage=new GoogleLoginPage(driver);
		logger.info("Clicking login button");
		googleLoginPage.clickLoginButton();
		logger.info("Clicking Google login option");
		googleLoginPage.clickGoogleLogin();
		logger.info("Switching to Google login window");
		Assert.assertTrue(googleLoginPage.switchToGoogleWindow(),"Switching to Google Login window Failed !!");
		
	}
	
	@Test(priority=22)
	public void validateEmail()
	{
		logger.info("Entering email");
		googleLoginPage.sendEmail("cyiegviyebvi@gmail.com");
		System.out.println(googleLoginPage.getEmailErrorMessage2());
	}
	
}
