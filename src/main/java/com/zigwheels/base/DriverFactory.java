package com.zigwheels.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory 
{
	public static WebDriver driver;

    @SuppressWarnings("deprecation")
	public static WebDriver getDriver(String operating_System,String browserName) throws MalformedURLException {
    	 
    	WebDriver driver = null;

        String execution_env="local";
        
        //for remote running 
        if(execution_env.equals("remote"))
        {
        	
        	//ro run remotely -  open cmd at selenium-servre jar file location and run the command (java -jar selenium-server-4.35.0.jar standalone)
        	//keep this command running in the cmd , go to the url it provides ( http://10.109.177.95:4444) 
        	// run the code in the eclipse and see the results in the url 
        	
        	DesiredCapabilities capabilities=new DesiredCapabilities();
        	
        	//setting operating system
        	if(operating_System.equalsIgnoreCase("windows"))
            {
            	capabilities.setPlatform(Platform.WIN11);
            }
        	else if(operating_System.equalsIgnoreCase("mac"))
            {
            	capabilities.setPlatform(Platform.MAC);
            }
        	else
        	{
        		System.out.println("No such Operating system");
        	}
        	
        	//setting browser
        	switch(browserName.toLowerCase())
        	{
        		case "chrome": capabilities.setBrowserName("chrome"); break;
        		case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
        		default : System.out.println("No matching browser"); break;
        	}
        	driver=new RemoteWebDriver(new URL("http://10.109.177.95:4444/wd/hub"),capabilities);
        }
    	
		//for local running 
        if(execution_env.equals("local"))
        {
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
        }
        
  
        return driver;
    }
    
    public static WebDriver getCurrentDriver() {
        return driver;
    }
    
}
