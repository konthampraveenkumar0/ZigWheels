package com.zigwheels.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage 
{
	private WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='headerSearch']")
    private WebElement searchField;
	
	@FindBy(xpath="//*[@class='zw i-b mt-5 zw-logo-a zw-srch-logo']/img")
	public WebElement gotoHomePage;
	
	public void SearchFor(String search_value) throws IOException, InterruptedException
	{
		searchField.click();
		searchField.sendKeys(search_value);
//		System.out.println(ExcelUtils.getFileDetails());
		Actions actions=new Actions(driver);
		Thread.sleep(2000);
		actions.sendKeys(Keys.DOWN).perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER).perform();
	}
	
	public void goToHomePage()
	{
		gotoHomePage.click();
	}

}
