package com.appilum.actviites;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Popupscard {

	WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
    	DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "RedMi5");
		caps.setCapability("platformName", "Android");
	    caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void ALoginSucess() throws Exception  {
    	 //Opening the URL   	 	
    	driver.get("https://www.training-support.net/selenium");
       //Wait
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);               
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));
        
     	// Finding and clicking on the "Login Form"
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(2)"));
		Thread.sleep(500);
	    driver.findElementByXPath("//android.view.View[contains(@text,'Popups')]").click();
	    Thread.sleep(500);
		//Clicking on the Sign in button
		driver.findElement(MobileBy.AndroidUIAutomator("textContains(\"Sign In\")")).click();
		//Enter the User Name		
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin");
		//Enter the Password Name
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password");
		//Clicking on the Login button
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
		//capturing the welcome message and storing it in a variable
		String WelcomeText = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
		//Printing welcome message in console
		System.out.println("The Welcome string is: "+WelcomeText);
		//Verifying the welcome message
		Assert.assertEquals(WelcomeText, "Welcome Back, admin");   
    }
    @Test
    public void BLoginFailure() throws Exception  {
    	Thread.sleep(500);
    	//Clicking on the Sign in button
    	driver.findElement(MobileBy.AndroidUIAutomator("textContains(\"Sign In\")")).click();
		//Enter the User Name		
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin1");
		//Enter the Password Name
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password");
		//Clicking on the Login button
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
		//capturing the welcome message and storing it in a variable
		String WelcomeText = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
		//Printing welcome message in console
		System.out.println("The Welcome string is: "+WelcomeText);
		//Verifying the welcome message
		Assert.assertEquals(WelcomeText, "Invalid Credentials");
    }
    
    @AfterClass
	public void afterClass() {
		driver.quit();
	}

} 