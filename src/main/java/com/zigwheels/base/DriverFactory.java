package com.zigwheels.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory 
{

    public static WebDriver getDriver(String browserName) {
    	 
        WebDriver driver;
        
        
        switch (browserName.toLowerCase()) {
            case "chrome":
            	ChromeOptions options = new ChromeOptions();
            	options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
            	EdgeOptions option1 = new EdgeOptions();
                option1.addArguments("--disable-notifications");
                driver = new EdgeDriver(option1);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        
  
        return driver;
    }
    
}
