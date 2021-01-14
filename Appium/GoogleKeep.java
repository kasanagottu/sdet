package com.appilum.actviites;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleKeep {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	String titleName;
	String NoteDesc;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "RedMi5");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);
		caps.setCapability("unicodeKeyboard", false);
		caps.setCapability("resetKeyboard", false);
			
		// Instantiate Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 20);
	}

	@Test
	public void CreateNote()  {

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("new_note_button"))).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Enter title name
		driver.findElementById("editable_title").clear();
		driver.findElementById("editable_title").sendKeys("Actvities");
		titleName = driver.findElementById("editable_title").getText();
		
		//Enter Note description
		driver.findElementById("edit_note_text").clear();
		driver.findElementById("edit_note_text").sendKeys("Complete the Project Actvities");
		NoteDesc=driver.findElementById("edit_note_text").getText();
		//Click on the Back button
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]").click();
				
	}
	@Test
	public void VerifyNote()  {
	//get the values and store them into variable
			String titletext = driver.findElementById("index_note_title").getText();
			System.out.println(titletext);
			String Desc = driver.findElementById("index_note_text_description").getText();
			System.out.println(Desc);
			
			Assert.assertEquals(titletext,titleName);
			Assert.assertEquals(NoteDesc,Desc);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}