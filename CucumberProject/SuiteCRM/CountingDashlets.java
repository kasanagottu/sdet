package com.cucumber_stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CountingDashlets {
	WebDriver driver;
	WebDriverWait wait;

	@Given("Open the browser to the ​CRM​ site and login")
	public void Login_CRM() {
		// Declare new WebDriver
		driver = new FirefoxDriver();
		// Declare new WebDriverWait
		wait = new WebDriverWait(driver, 10);

		driver.get("http://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
		// Find and select the username and password fields
		WebElement UserName = driver.findElement(By.id("user_name"));
		WebElement UserPassword = driver.findElement(By.id("username_password"));

		// Enter login credentials into the respective fields
		UserName.sendKeys("admin");
		UserPassword.sendKeys("pa$$w0rd");
		// Click on login button
		driver.findElement(By.id("bigbutton")).click();
	}

	@When("Count number of Dashlets on homepage")
	public void CountDashlets() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> DashletsCount = driver.findElements(By.className("dashlet-title"));
		System.out.println("Count of Dashlets on the page : " + DashletsCount.size());

	}

	@And("^Print number and title of each Dashlet into console")
	public void PrintTitleDashlets() throws Throwable {
		List<WebElement> DashletTitles = driver.findElements(By.className("dashlet-title"));
		for (WebElement dashletTitle : DashletTitles) {
			System.out.println("Dashlet title is :"+dashletTitle.getText());
		}
	}

	@Then("^Close browser for Counting$")
	public void closeBrowser() {
		driver.quit();

	}
}
