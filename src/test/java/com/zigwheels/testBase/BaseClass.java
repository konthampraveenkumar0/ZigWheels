package com.zigwheels.testBase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.zigwheels.base.DriverFactory;
import com.zigwheels.utilities.ConfigReader;

public class BaseClass 
{
	
	public WebDriver driver;
	public static Logger logger ;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) 
	{
		logger=LogManager.getLogger(this.getClass());
		driver=DriverFactory.getDriver(browser);
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

}
