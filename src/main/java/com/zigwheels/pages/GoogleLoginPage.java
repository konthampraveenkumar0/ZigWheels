package com.zigwheels.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleLoginPage
{
	
    public WebDriver driver;
    
    public GoogleLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   
    //login button element
    @FindBy(xpath = "//*[@id='forum_login_title_lg']/div/div/img")
    WebElement loginButton;

    //google button
    @FindBy(xpath = "//*[@id='myModal3-modal-content']/div[1]/div/div[3]/div[6]/div/span[2]")
    WebElement googleLoginButton;
    
    //email id field
    @FindBy(xpath = "//*[@id='identifierId']")
    WebElement emailIdField;
    
    
    //next button for email element
    @FindBy(xpath = "//*[@id='identifierNext']/div/button/span")
    WebElement emailNextButton;
    
    //passwordField
    @FindBy(xpath="//*[@id='hiddenEmail']")
    WebElement passwordField;
    
    @FindBy(xpath="(//*[@class='VfPpkd-vQzf8d'])[2]")
    WebElement passwordNextField;
    
    @FindBy(xpath = "//*[@id=\"i8\"]/div")
    WebElement emailErrorMessage;
    
    @FindBy(xpath="//*[@id='headingText']/span")
    WebElement emailErrorMessage2;
    
    @FindBy(xpath = "//*[@id='c0']/div[2]")
    WebElement passwordErrorMessage;
    
    /////login ways
    @FindBy(xpath="//*[@class='lgn-sc fb c-p txt-l pl-30 pr-30']/span[2]")
    WebElement facebook_button;
    
    @FindBy(xpath="//*[@id='appleSignIn']")
    WebElement apple_button;
    
    
    
    
    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickGoogleLogin() {
        googleLoginButton.click();
    }

   
    public boolean switchToGoogleWindow() {
        // Switch to Google window and perform login
    	String currentWindowId=driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            
            if(!currentWindowId.equals(winHandle)) 
            {
            	driver.switchTo().window(winHandle);
            	return true;
            }
        }
        driver.switchTo().window(currentWindowId);
        return false;
    }
    
    public void sendEmail(String email)
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
    	emailField.sendKeys(email);
    	emailNextButton.click();
    }
    
    public void sendPassword(String password)
    {
    	passwordField.sendKeys(password);
    	passwordNextField.click();
    }
    

    public String getEmailErrorMessage() 
    {
        return emailErrorMessage.getText();
    }
    public String getEmailErrorMessage2() {
        return emailErrorMessage2.getText();
    }
    
    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }
    
    public String getFaceBookText()
    {
    	return facebook_button.getText();
    }
    
    public String getAppleText()
    {
    	return apple_button.getText();
    }
    
    public String getGoogleText()
    {
    	return googleLoginButton.getText();
    }
    
}