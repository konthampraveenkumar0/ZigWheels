package com.zigwheels.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zigwheels.models.Bike;

public class BikesPage 
{
	
	public List<Bike>BikeDetailsList;
	
	public WebDriver driver;
	public BikesPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		//fetching bikes details to BikeDetailsList
		BikeDetailsList=new ArrayList<>();
		for(int i=0;i<BikesNameList.size();i++)
		{
			
			
			//convert string price to double 
			String string_price=BikesPriceList.get(i).getText();
			string_price=string_price.replace("Rs. ","").trim();
			Double double_price;
			if (string_price.contains("Lakh")) {
				string_price = string_price.replace("Lakh", "").trim();
	            double_price=Double.parseDouble(string_price) * 100000;
	        } else {
	        	string_price = string_price.replace(",", "").trim();
	        	double_price=Double.parseDouble(string_price);
	        }
			
			//create object for bike class
			Bike bike=new Bike(BikesNameList.get(i).getText(),double_price,BikesExpectedDateList.get(i).getText());
			BikeDetailsList.add(bike);
		}
	}
	
	@FindBy(xpath = "//*[@id='modelList']/li//a/strong")
    private List<WebElement> BikesNameList;

    @FindBy(xpath = "//*[@id='modelList']/li/div/div[3]/div[1]")
    private List<WebElement> BikesPriceList;

    @FindBy(xpath = "//*[@id='modelList']/li/div/div[3]/div[2]")
    private List<WebElement> BikesExpectedDateList;
	
	public boolean verifyAllBikesAreHonda()
	{
		System.out.println("Upcoming Honda Bikes Names :");
		System.out.println();
		for(Bike bike:BikeDetailsList)
		{
			if(!bike.getName().toLowerCase().contains("honda"))
			{
				System.out.println("❌ Non-Honda bike found: " + bike.getName());
				return false;
			}
			else
			{
				System.out.println(bike.getName());
			}
		}
		System.out.println();
		return true;
	}
	
	public boolean verifyBikeCardDetails() {
        for (Bike bike : BikeDetailsList) {
            if (bike.getName().isEmpty() || bike.getPrice() <= 0 || bike.getExp_date().isEmpty()) {
                System.out.println("❌ Incomplete bike card: " + bike);
                return false;
            }
        }
        return true;
    }
	
	public boolean verifyPriceBelowThreshold()
	{
		System.out.println("Bikes Price less than 4 Lakhs :");
		System.out.println();
		int count=0;
		for(Bike bike:BikeDetailsList)
		{
			if(bike.getPrice()<400000)
			{
				System.out.println(bike.getName()+" - ₹ "+bike.getPrice()+" - "+bike.getExp_date());
				count++;
			}
		}
		
		return count>0;
	}
	
	
	
	
}
