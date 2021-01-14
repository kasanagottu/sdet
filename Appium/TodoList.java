package com.appilum.actviites;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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

public class TodoList {

	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
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
	public void CreateToDoLists() throws InterruptedException {

		driver.get("https://www.training-support.net/selenium");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Create array list for list of tasks
		String[] tasksList = { "Add tasks to list", "Get number of tasks", "Clear the list" };
		// wait until screen visible
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));
		// Finding and clicking on the "To-Do-List"
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(2)"));
		Thread.sleep(500);
		MobileElement listitem = driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]");
		listitem.click();

		Thread.sleep(2000);
		// wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"tasksCard\")")));

		MobileElement taskinput = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")"));
		Thread.sleep(200);
		MobileElement addtaskbtn = driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")"));

		for (String list : tasksList) {
			taskinput.sendKeys(list);
			addtaskbtn.click();
		}

	}

	@Test
	public void VerifyToDoLists() throws InterruptedException {
		// Get the total number of lists
		List<MobileElement> taskslist = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
		int CountOftasks = taskslist.size();
		System.out.println("The Number of Tasks: " + CountOftasks);

		// Check the list of tasks with assertion
		Assert.assertEquals(CountOftasks, 3);

		// Click on each of the tasks added to strike them out
		for (MobileElement task : taskslist) {
			task.click();
		}

		// Clear the tasks
		driver.findElement(MobileBy.AndroidUIAutomator("textContains(\"Clear List\")")).click();
		Thread.sleep(1000);
		// Check the list of tasks with assertion after clearing the tasks
		List<MobileElement> taskslistt = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
		int CountOftaskss = taskslistt.size();
		Assert.assertEquals(CountOftaskss, 0);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}