package com.zigwheels.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.zigwheels.utilities.ExcelUtils;

public class HomePage 
{
	private WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void searchForBikes() throws IOException
	{
		WebElement searchField=driver.findElement(By.xpath("//*[@id='headerSearch']"));
		searchField.click();
		searchField.sendKeys("Upcoming Honda Bikes");
//		System.out.println(ExcelUtils.getFileDetails());
		Actions actions=new Actions(driver);
//		actions.sendKeys(Keys.DOWN).perform();
		actions.sendKeys(Keys.ENTER).perform();
	}

}
