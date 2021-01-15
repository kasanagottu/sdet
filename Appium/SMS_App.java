package com.appilum.actviites;
import java.net.MalformedURLException;
import java.net.URL;
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

public class SMS_App {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "RedMi5");
		caps.setCapability("platformName", "Android");
		// Use your own device's messaging app
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", ".ui.ConversationListActivity");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 30);
	}


    @Test
    public void smsTest() {
        // Locate the button to write a new message and click it
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Create New Message\")")).click();

        // Enter the number to send message to
        String contactBoxLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/auto_complete_contact\")";
        // Enter your own phone number
        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("9849512345");

        // Focus on the message text box
        String messageBoxLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/hint_message\")";
        driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();

        // Type in a message
        messageBoxLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/sms_edit_text\")";
        MobileElement composeMessageInput = driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
        composeMessageInput.sendKeys("Hello from Appium");

        // Send the message
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send SMS\")")).click();

        // Wait for message to show
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text_view")));

        // Assertion
        String messageLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/message_text_view\")";
        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}