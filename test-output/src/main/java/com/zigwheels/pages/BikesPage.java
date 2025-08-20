package com.zigwheels.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BikesPage 
{

	public WebDriver driver;
	public BikesPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void ListBikes()
	{
		List<WebElement> list = driver.findElements(By.xpath("//*[@id='modelList']/li//a"));
//		for(int i=0;i<list.size();i++)
//		{
//			System.out.println(list.get(i).getText());
//		}
		for(int i=0;i<4;i++)
		{
			System.out.println(driver.findElement(By.xpath("//*[@id='modelList']/li//a")).getText());
		}
	}
	
	public void listBikesLessThan4L()
	{
		List<WebElement> list = driver.findElements(By.xpath("//*[@id='modelList']/li/div/div[3]/div"));
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
		}
	}
}
