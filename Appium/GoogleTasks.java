package com.appilum.actviites;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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

public class GoogleTasks {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "RedMi5");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 20);
	}

	@Test
	public void Addtasks() throws InterruptedException {

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("tasks_fab"))).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Adding the first task: 
		// driver.findElementById("tasks_fab").click();
		driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
		driver.findElementById("add_task_done").click();

		// Adding the second task: 
		driver.findElementById("tasks_fab").click();
		driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
		driver.findElementById("add_task_done").click();

		// Adding the third task:
		driver.findElementById("tasks_fab").click();
		driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
		driver.findElementById("add_task_done").click();
		Thread.sleep(5000);
	}
	@Test
	public void Verifytasks() {
		// Printing the tasks which are added

		List<MobileElement> tasklist = driver.findElementsById("task_name");
		for (MobileElement tlist : tasklist) {
			System.out.println("The task name is :" + tlist.getText());
		}
		// Check all tasks are added to list (assertion)
		Assert.assertEquals(tasklist.size(), 3);
		Assert.assertEquals(tasklist.get(0).getText(), "Complete the second Activity Google Keep");
		Assert.assertEquals(tasklist.get(1).getText(), "Complete Activity with Google Keep");
		Assert.assertEquals(tasklist.get(2).getText(), "Complete Activity with Google Tasks");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}