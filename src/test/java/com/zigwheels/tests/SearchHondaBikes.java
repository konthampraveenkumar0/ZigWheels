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
	public void verifyNavigationtoUsedCarsinChennai() throws IOException, InterruptedException
	{
		
		homePage.SearchFor(SearchData[1]);
		logger.info("navigated to UsedCars in Chennai page");
		Assert.assertEquals(driver.getTitle(),"Used Cars in Chennai - 1624 Second Hand Cars for Sale in Chennai");
	}
	
	
	@Test(priority=12)
	public void validateCars() throws IOException, InterruptedException
	{
		
		usedCars=new UsedCars(driver);
		logger.info("Validating used car list");
		Assert.assertTrue(usedCars.verifyFullList());
		
	}
	
	@Test(priority=13,dependsOnMethods= {"validateCars"})
	public void checkBoxes() throws InterruptedException
	{
		System.out.println();
		logger.info("Checking for popular car models");
//		Assert.assertTrue(usedCars.checkPopularModels(),"No popular cars displayed");
	}
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	google login 

	
	@Test(priority=21)
	public void testLoginOptions() throws InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		logger.info("Navigated to Home Page");
		googleLoginPage=new GoogleLoginPage(driver);
		logger.info("Clicking login button");
		googleLoginPage.clickLoginButton();
		
		String actualFaceBookText = googleLoginPage.getFaceBookText();
	    String actualAppleText = googleLoginPage.getAppleText();
	    String actualGoogleText = googleLoginPage.getGoogleText();

	    System.out.println("Facebook Text: " + actualFaceBookText);
	    System.out.println("Apple Text: " + actualAppleText);
	    System.out.println("Google Text: " + actualGoogleText);

	    boolean allMatch = actualFaceBookText.equals("Facebook") &&
	                       actualAppleText.equals("Apple") &&
	                       actualGoogleText.equals("Google");

	    Assert.assertTrue(allMatch, "One or more login button texts do not match expected values.");
	
	}
	
	@Test(priority=22)
	public void navigateToGoogleLoginWindow() 
	{
		logger.info("Clicking Google login option");
		googleLoginPage.clickGoogleLogin();
		logger.info("Switching to Google login window");
		Assert.assertTrue(googleLoginPage.switchToGoogleWindow(),"Switching to Google Login window Failed !!");
		
	}
	
	@Test(priority=23)
	public void validateEmail()
	{
		logger.info("Entering email");
		googleLoginPage.sendEmail("praveen@gmail.com");
		System.out.println(googleLoginPage.getEmailErrorMessage2());
	}
	
}
