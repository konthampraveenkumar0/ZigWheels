package com.zigwheels.hooks;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.zigwheels.base.DriverFactory;
import com.zigwheels.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks 
{
		
		public static WebDriver driver;
		
		
		@Before
		public void setUp() throws MalformedURLException
		{
			driver=DriverFactory.getDriver("windows","chrome");
			driver.get(ConfigReader.getAppUrl());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		
		@After
		public void tearDown()
		{
			driver.quit();
		}

}
