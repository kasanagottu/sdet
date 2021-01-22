package com.cucumber_stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PostingJob extends BaseClass {

	// WebDriver driver;
	// WebDriverWait wait;

	@Given("^User Open WebBrowser and Navigate to Post a Job$")
	public void OpenBrowser() throws InterruptedException {
		// Declare new WebDriver
		// driver = new FirefoxDriver();

		// Declare new WebDriverWait
		// WebDriverWait wait = new WebDriverWait(driver, 10);

		// Navigate to the Jobs Posting page
		driver.get("https://alchemy.hguy.co/jobs");
		// Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Post a Job']")));
		driver.findElement(By.xpath("//a[text()='Post a Job']")).click();
		driver.manage().window().maximize();
	}

	@Given("^User enters \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void FillDetails(String Email, String JobTilte, String application, String Desc, String company_name)
			throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='create_account_email']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys(JobTilte);
		// Switch to frame to enter text in Description field
		driver.switchTo().frame("job_description_ifr");
		System.out.println("***Switched to the iframe****");
		Thread.sleep(100);
		// Enter text in Description field
		driver.findElement(By.id("tinymce")).sendKeys(Desc);
		// Switch to Default content
		driver.switchTo().defaultContent();
		Thread.sleep(100);
		// Enter URL in Application URL field
		driver.findElement(By.xpath("//input[@id='application']")).sendKeys(application);
		// Enter Company name
		driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys(company_name);
		// Click on Preview button
		driver.findElement(By.xpath("//input[@name='submit_job']")).click();
		// Click on Save Draft button
		// driver.findElement(By.xpath("//input[@name='save_draft']")).click();
		// Click on Submit Listing Draft button
		driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
		Thread.sleep(100);

		if (driver.getPageSource().contains("Job listed successfully.")) {
			System.out.println("The Job listed successfully");
		} else {
			System.out.println("The Job posting unsuccessfully");
		}
	}

	@Then("^Verify posted job \"(.*)\" on Jobs page$")
	public void VerifyPostedJob(String JobTitle) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Jobs']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search_keywords']")))
				.sendKeys(JobTitle);

	//	driver.findElement(By.xpath("//div[name(@class='search_submit')]")).click();
	
		String PostName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'"+JobTitle+"')]")))
				.getText();
		System.out.println("The PostName is: " + PostName);
		Assert.assertEquals(PostName, JobTitle);

		if (PostName.equals(JobTitle)) {
			System.out.println("The created post was successfully displayed on Jobs Page:" + PostName + ":" + JobTitle);
		} else {
			System.out.println("The created post was not displayed on Jobs Page:" + PostName + ":" + JobTitle);
		}

	}

	@Then("^Close the browser for Posting Job$")
	public void closeBrowser() {
		driver.quit();

	}

}
