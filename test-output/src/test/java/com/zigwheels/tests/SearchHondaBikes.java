package com.zigwheels.tests;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zigwheels.base.DriverFactory;
import com.zigwheels.pages.BikesPage;
import com.zigwheels.pages.HomePage;
import com.zigwheels.utilities.ConfigReader;
public class SearchHondaBikes 
{
	
	private static WebDriver driver;
	public HomePage homePage;
	public BikesPage bikesPage;

	@Test(priority=0)
	public void setup() 
	{
		driver=DriverFactory.getDriver(ConfigReader.getBrowser());
		driver.get(ConfigReader.getAppUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( 10));

	}
	
	@Test(priority=1)
	public void searchBikes() throws IOException
	{
		homePage=new HomePage(driver);
		homePage.searchForBikes();
	}

	
	@Test(priority=2)
	public void listBikes()
	{
		bikesPage=new BikesPage(driver);
		bikesPage.ListBikes();
	}
	
	public void listBikesLessThan4L()
	{
		bikesPage.ListBikes();
	}
	
	@Test(priority=3)
	public void tearDown()
	{
		driver.quit();
	}
}
