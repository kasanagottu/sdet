package com.cucumber_stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScheduleMeeting {

	WebDriver driver;
	WebDriverWait wait;

	@Given("User Open WebBrowser and Navigate to Schedule a Meeting")
	public void Login_CRM() throws InterruptedException {
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
		//Navigate to Activities -> Meetings -> Schedule a Meeting. 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("grouptab_3")));
		Actions meeting = new Actions(driver);
		meeting.moveToElement(driver.findElement(By.id("grouptab_3"))).build().perform();
		meeting.moveToElement(driver.findElement(By.linkText("Meetings"))).build().perform();
    	driver.findElement(By.linkText("Meetings")).click();
    	//Click on the Schedule Meeting link
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text() = 'Schedule Meeting']")));
    	driver.findElement(By.xpath("//div[text() = 'Schedule Meeting']")).click();
    	Thread.sleep(100);
	}
	@When("^Enter details of the meeting$")
	public void meetingName() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_first_name")));
		driver.findElement(By.id("name")).sendKeys("Testing Meeting");
	}
	       
	@And("^Search for members \"(.*)\" and \"(.*)\" and \"(.*)\" add them to the meeting using example$")
	public void SearchAndAdd(String FirstName, String LastName, String Email) throws Exception {

			driver.findElement(By.id("search_first_name")).sendKeys(FirstName);
			driver.findElement(By.id("search_last_name")).sendKeys(LastName);
			driver.findElement(By.id("search_email")).sendKeys(Email);
			//Click on the Search button
			driver.findElement(By.id("invitees_search")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("invitees_add_1")));
			//Click on the add button to add invite
			driver.findElement(By.id("invitees_add_1")).click();
			//Click on the Save button
			driver.findElement(By.id("SAVE_HEADER")).click();	
			Thread.sleep(100);
	}
	
	@And("^Navigate to View Meetings and confirm$")
    public void VerfiyMeeting() {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab0")));
    	String MeetingName = driver.findElement(By.xpath("//h2[@class = 'module-title-text']")).getText();
    	System.out.println("The scheduled meeting is: " + MeetingName);
    	Assert.assertEquals(MeetingName, "TESTING MEETING");
    	
    }
	
	@Then("^Close browser for meeting$")
	public void closeBrowser() {
		driver.quit();
	}

}
