package com.cucumber_stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateProduct {

	WebDriver driver;
	WebDriverWait wait;

	@Given("User Open WebBrowser and Navigate to Create Product")
	public void Login_CRM_NavigateProducts() throws InterruptedException {
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
		Thread.sleep(200);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions Product = new Actions(driver);
		// Navigate to All -> Products-> Create Product. 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("grouptab_5")));
		Product.moveToElement(driver.findElement(By.id("grouptab_5"))).build().perform();
		// Find product link and Click on it
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[text()='Products']")));
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		// Find and Click on the Create Product
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text() = 'Create Product']")));
		driver.findElement(By.xpath("//div[text() = 'Create Product']")).click();
	}
	@And("^User enters product details \"(.*)\" and \"(.*)\" and Click Save button$")
	public void Create_Product(String ProdName, String ProdPrice) throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'contact']")));
		driver.findElement(By.id("name")).sendKeys(ProdName);
		driver.findElement(By.id("price")).sendKeys(ProdPrice);
		driver.findElement(By.id("contact")).sendKeys("Venkat K");
		driver.findElement(By.id("description")).sendKeys("Products-Testing");
		//Click on the Save button
		driver.findElement(By.id("SAVE")).click();
		Thread.sleep(200);
	}
	
	@Then("^User navigates to View Products page to Validate \"(.*)\" listed$")
	public void productDetails(String ProdName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab-content-0")));
		String ProductName = driver.findElement(By.xpath("//h2[@class = 'module-title-text']")).getText();
		System.out.println("The product created is: " + ProductName);
		Assert.assertEquals(ProductName, ProdName);
		
	}
	@Then("^Close browser for Product$")
	public void closeBrowser() {
		driver.quit();
	}

}
