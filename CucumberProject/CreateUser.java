package com.cucumber_stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateUser {

	WebDriver driver;
	WebDriverWait wait;
	String UserName = "Venkatt";

	@Given("^User Open WebBrowser and Navigate LoginPage$")
	public void OpenBrowser() throws InterruptedException {
		// Declare new WebDriver
		driver = new FirefoxDriver();

		// Declare new WebDriverWait
		wait = new WebDriverWait(driver, 10);

		// Navigate to the activity page
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		Thread.sleep(500);

	}

	@When("^User enters username and password$")
	public void EnterCredentials() {
		// Enter username
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("user_login")));
		driver.findElement(By.id("user_login")).sendKeys("root");
		// Enter password
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		// Click Login button
		driver.findElement(By.id("wp-submit")).click();
	}

	@And("^Click User from Left section$")
	public void ClickOnUser() throws Exception {
		Actions Linktxt = new Actions(driver);
		Linktxt.moveToElement(driver.findElement(By.linkText("Users"))).build().perform();
		Thread.sleep(200);
	}

	@And("^User Click AddNew button$")
	public void AddNew() throws Exception {

		driver.findElement(By.linkText("Add New")).click();
	}

	@When("^Fill all Neccesary data$")
	public void FillData() {

		driver.findElement(By.id("user_login")).sendKeys(UserName);
		driver.findElement(By.id("email")).sendKeys("venkat@test.com");
		driver.findElement(By.id("first_name")).sendKeys("Venkatesh");
		driver.findElement(By.id("last_name")).sendKeys("K");
	}

	@When("^User Click the Add New User button$")
	public void AddNewUser() {

		driver.findElement(By.id("createusersub")).click();
	}

	@Then("^Verify that the user was created$")
	public void verify_that_the_user_was_created() throws Exception {

		driver.findElement(By.id("user-search-input")).sendKeys(UserName);
		driver.findElement(By.id("search-submit")).click();
		Thread.sleep(200);

		String ExpUserName = driver
				.findElement(By.xpath(
						"//table[contains(@class,'wp-list-table widefat fixed striped users')]/tbody/tr[1]/td[1]"))
				.getText();

		System.out.println("The Created user name is: " + ExpUserName);

		if (UserName.equalsIgnoreCase(ExpUserName)) {
			System.out.println("The created user is displayed on Users Page");
		} else {
			System.out.println("The created user is not displayed on Users Page");
		}

	}

	@Then("^User Close the browser$")
	public void CloseBrowser() {
		driver.quit();
	}

}
