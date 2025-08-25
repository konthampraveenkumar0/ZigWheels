package com.zigwheels.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsedCars {
    private WebDriver driver;

    public UsedCars(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='gsc_thin_scroll']//ul//li/label")
    private List<WebElement> checkList;

    @FindBy(xpath = "//*[@class='zw-sr-searchWrap zw-sr-searchGrid']/div/div/div[3]/div[2]/a")
    private List<WebElement> AllCarModels;

    // @FindBy(xpath = "//*[@class='zw-sr-searchWrap zw-sr-searchGrid']/div/div/div[3]/div[2]/a")
    // private List<WebElement> checkedModels;

    @FindBy(xpath = "//*[@id='data-set-body']")
    WebElement noDataFound;

    public boolean verifyFullList() {
        if (AllCarModels == null || noDataFound.getText().equals("No data found")) {
            System.out.println("No cars found");
            return false;
        }
        System.out.println("All Available cars :");
        System.out.println();
        for (int i = 0; i < AllCarModels.size(); i++) {
            System.out.println(AllCarModels.get(i).getText());
        }
        return true;
    }

    public boolean checkPopularModels() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (WebElement checkbox : checkList) {
            try {
                // Scroll into view
                js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
                // Wait until clickable
                wait.until(ExpectedConditions.elementToBeClickable(checkbox));
                // Click safely
                if (!checkbox.isSelected()) {
                    try {
                        checkbox.click();
                    } catch (ElementClickInterceptedException e) {
                        // Fallback to JS click
                        js.executeScript("arguments[0].click();", checkbox);
                    }
                }
            } catch (Exception e) {
                System.out.println("Could not click checkbox: " + e.getMessage());
            }
        }

        System.out.println();
        System.out.println("checked models");
        System.out.println();

        List<WebElement> checkedModels = driver.findElements(
            By.xpath("//*[@class='zw-sr-searchWrap zw-sr-searchGrid']/div/div/div[3]/div[2]/a")
        );

        if (checkedModels.size() > 0) 
        {
        	
        	for(int i=1;i<=5;i++)
        	{
        		System.out.println(driver.findElement(By.xpath("(//*[@class='zw-sr-searchWrap zw-sr-searchGrid']/div/div/div[3]/div[2]/a)["+i+"]")).getText());
        	}
//            for (int i = 0; i < checkedModels.size(); i++) {
//                System.out.println(checkedModels.get(i).getText());
//            }
            return true;
        }
        return false;
    }
}
