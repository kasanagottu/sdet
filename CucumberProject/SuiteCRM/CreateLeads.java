package com.cucumber_stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeads {

	WebDriver driver;
	WebDriverWait wait;

	@Given("User Open WebBrowser and Navigate to Home Page")
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

	@When("Navigate to Create Lead")
	public void ToCreateLead() throws InterruptedException {
		// Find the Sales and mouse over on that to Click on the Leads
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_0")));
		WebElement ElementName = driver.findElement(By.id("grouptab_0"));
		String SalesField = ElementName.getText();
		Assert.assertEquals(SalesField, "SALES");
		System.out.println("ElementName is :" + ElementName.getText());
		Actions sales = new Actions(driver);
		sales.moveToElement(ElementName).build().perform();    
		//sales.click().build().perform();
		// Click on the Leads
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Leads")));
		sales.moveToElement(driver.findElement(By.linkText("Leads"))).build().perform();
		driver.findElement(By.id("moduleTab_9_Leads")).click();
		Thread.sleep(500);
		// Click on the Create Lead
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Create Lead")));
		driver.findElement(By.linkText("Create Lead")).click();
		Thread.sleep(1000);
					
	}
	
	@Then("^Fill all necessary details \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" to create lead accounts and Click Save$")
	public void Create_lead_Acc_ClickSave(String title, String Fname, String Lname, String eMail) {
	    // Write code here that turns the phrase above into concrete actions
	   	WebElement Title = driver.findElement(By.id("salutation"));
		Select dropdown = new Select(Title);
		dropdown.selectByVisibleText(title);

		WebElement Name = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(Name));
		Name.sendKeys(Fname);

		WebElement Surname = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(Surname));
		Surname.sendKeys(Lname);

		WebElement Email = driver.findElement(By.xpath("//*[@id=\"Leads0emailAddress0\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(Email));
		Email.sendKeys(eMail);
		//Click on the Save button  
		//driver.findElement(By.id("SAVE")).click();
		driver.findElement(By.cssSelector("div.buttons:nth-child(5) > input:nth-child(1)")).click();
	}
	      
	@And("^Navigate to View Leads page to see results as \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void validateResult(String title, String Fname, String Lname) throws Throwable{
		Thread.sleep(5000);
		String FullName = title+" "+Fname +" " +Lname;
       	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab0")));
    	String Name = driver.findElement(By.xpath("//h2[@class = 'module-title-text']")).getText();
    	//System.out.println("The Lead name is : " + FullName);
    	//System.out.println("The Lead name is : " + Name);
    	Assert.assertEquals(Name,FullName);
    //	System.out.println("The Lead name is : " + FullName);
		
	}
	
	@Then("^Close browser for CreateLeads$")
	public void closeBrowser() {
		driver.quit();
	}
}