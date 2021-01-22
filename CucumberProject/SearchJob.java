package com.cucumber_stepDefinitions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchJob {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^User Open WebBrowser and Navigate JobsPage$")
	public void OpenBrowser() throws InterruptedException {
		// Declare new WebDriver
		driver = new FirefoxDriver();

		// Declare new WebDriverWait
		 wait = new WebDriverWait(driver, 10);

		// Navigate to the activity page
		driver.get("https://alchemy.hguy.co/jobs");
		//Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Jobs']")));
		driver.findElement(By.xpath("//a[text()='Jobs']")).click();

	}

	@When("^Find and Type the Keywords to search for jobs$")
	public void find_input_field() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("VSDET Tester1");
		Thread.sleep(100);
	}

	@When("change the Job type to only Full Time jobs")
	public void change_job_type() throws Exception {
		List<WebElement> CheckBox = driver.findElements(By.xpath("//input[@name='filter_job_type[]']"));
		int CountOfCheckBoxes = CheckBox.size();
		System.out.println("Count of Check boxes:" + CountOfCheckBoxes);
		// CheckBox.get(0).getText();

		for (int i = 0; i < CountOfCheckBoxes - 1; i++) {
			// Create a boolean variable to store true/false.
			Boolean is_selected = CheckBox.get(i).isSelected();
			String CheckBoxValue = CheckBox.get(i).getAttribute("value");
			System.out.println("The value is:" + CheckBoxValue);
			// If 'is_selected' is true that means the that checkbox is selected.
			if (is_selected == true) {
				CheckBox.get(i).click();

			} else {

				System.out.println("The Check box is already unchecked");
			}
		}
		driver.findElement(By.xpath("//input[@id='job_type_full-time']")).click();
		// Click on the Search Jobs button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(200);
	}

	@When("^Find a job and to see job details$")
	public void FindingJob() {

		driver.findElement(By.xpath("//li[starts-with(@class,'post-')]")).click();
		// List<WebElement> list =
		// driver.findElements(By.xpath("//li[starts-with(@class,'post-')]")).
		
	}

	@When("^Find the title of the job and print it to the console$")
	public void PrintTtile() {
		// Find the title of the job listing using XPath
		String Jobtitle = driver.getTitle();
		// print it to the console
		System.out.println("The Job title is: " + Jobtitle);
	}

	@When("^Find and Click on the Apply for job button$")
	public void ApplyButton() {

		// Find and Click on the “Apply for job” button
		driver.findElement(By.xpath("//input[@class='application_button button']")).click();
	}
	
	@Then("^Close the browser for Search$")
	public void CloseBrowser() {
		driver.quit();
	} 



}
