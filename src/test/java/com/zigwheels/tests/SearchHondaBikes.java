package com.zigwheels.tests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zigwheels.pages.BikesPage;
import com.zigwheels.pages.GoogleLoginPage;
import com.zigwheels.pages.HomePage;
import com.zigwheels.pages.UsedCars;
import com.zigwheels.testBase.BaseClass;
public class SearchHondaBikes extends BaseClass
{
	
	
	public HomePage homePage;
	public BikesPage bikesPage;
	public GoogleLoginPage googleLoginPage;
	public UsedCars usedCars;

	
	//testcases for honda bikes 
	
	@Test(priority=1)
	public void verifyNavigationtoUpcomingHondaBikes() throws IOException, InterruptedException
	{
		homePage=new HomePage(driver);
		logger.info("launched driver");
		homePage.SearchFor("Upcoming Honda");
		logger.info("navigated to upcoming honda bikes");
		Assert.assertEquals(driver.getTitle(),"Honda Upcoming Bikes in India - Check Price, Launch Date, Images and Latest News");
	}

	@Test(priority=2)
	public void testSearchUpcomingHondaBikes()
	{
		bikesPage=new BikesPage(driver);
		Assert.assertFalse(bikesPage.BikeDetailsList.isEmpty(), "Bike list is empty");
		Assert.assertTrue(bikesPage.verifyAllBikesAreHonda(),"Not all bikes are Honda brand");
		
	}
	
	@Test(priority=3)
	public void testBikeCardDetails()
	{
		Assert.assertTrue(bikesPage.verifyBikeCardDetails(),"Some bike cards have missing details");
	}
	
	@Test(priority = 4)
    public void testPriceBelowThreshold() {
        Assert.assertTrue(bikesPage.verifyPriceBelowThreshold(), "No bikes found under ₹4 Lakhs");
    }
	
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//used cars in chennai
	
	
	@Test(priority=11)
	public void validateCars() throws IOException, InterruptedException
	{
		homePage.SearchFor("Used Cars In Chen");
		usedCars=new UsedCars(driver);
		Assert.assertTrue(usedCars.verifyFullList());
		
	}
	
	@Test(priority=12,dependsOnMethods= {"validateCars"})
	public void checkBoxes() throws InterruptedException
	{
		System.out.println();
		usedCars.checkPopularModels();
	}
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	//google login 
	
	
//	@Test(priority=21)
//	public void navigateToNewWindow()
//	{
//		homePage.goToHomePage();
//		googleLoginPage.clickLoginButton();
//		googleLoginPage.clickGoogleLogin();
//		Assert.assertTrue(googleLoginPage.switchToGoogleWindow(), "Window not changed");
//	}
//	
//	@Test(priority=22)
//	public void validateEmail(String email)
//	{
//		googleLoginPage.sendEmail(email);
//		System.out.println(googleLoginPage.getEmailErrorMessage());
//	}
	
}
