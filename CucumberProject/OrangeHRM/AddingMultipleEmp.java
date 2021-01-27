package com.cucumber_stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddingMultipleEmp {
	
	WebDriver driver;
	WebDriverWait wait;
	public String Empid;
			
	@Given("Open ​OrangeHRM​ page and Navigate to PIM page")
	public void Login_HRM() {
		// Declare new WebDriver
		driver = new FirefoxDriver();
		// Declare new WebDriverWait
		wait = new WebDriverWait(driver, 10);

	    driver.get("http://alchemy.hguy.co/orangehrm");
		driver.manage().window().maximize();
		//Enter User Name
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		//Enter Password
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		// Click on login button
		driver.findElement(By.id("btnLogin")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
	}
	
	@When("^Click on “Add” button to add a new Employee$")
	public void Click_add_button() {
	    // Click on the Add button
		driver.findElement(By.id("btnAdd")).click();
   }
	@And("^Make sure “Create Login Details” checkbox is checked$")
	public void Check_Create_Login_Details() {
	    // Click on the Add button
		driver.findElement(By.id("chkLogin")).click();
	}
	     
	@And("^Fill necessary emp details \"(.*)\" and \"(.*)\" and \"(.*)\" Click on the Save button$")
	public void Fill_details_and_Save(String FirstName, String LastName,String UserName) throws InterruptedException {
		
	    //Enter First Name
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("firstName")));
		driver.findElement(By.id("firstName")).sendKeys(FirstName);
		//Enter Last Name
		driver.findElement(By.id("lastName")).sendKeys(LastName);
		Thread.sleep(100);
		//Get Employee ID
		Empid=driver.findElement(By.id("employeeId")).getAttribute("value");
		
		System.out.println("The Employee id :"+Empid);
		//Enter User Name
		driver.findElement(By.id("user_name")).sendKeys(UserName);
		//Click on the Save Button
		driver.findElement(By.id("btnSave")).click();
		
	}
	@And("^Validate that all employees have been created$")
	public void ValidateEmp() throws InterruptedException {
	    // Click on the PIM Link
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		//Click on the Employee List
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		//Enter emp id in the id field
		driver.findElement(By.id("empsearch_id")).sendKeys(Empid);
		//Click on the search button
		driver.findElement(By.id("searchBtn")).click(); 
		Thread.sleep(200);
		String ExpEmpID= driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[2]")).getText();
		System.out.println("The Created Employee ID is: " + ExpEmpID);

		if (Empid.equalsIgnoreCase(ExpEmpID)) {
			System.out.println("The created employee id "+Empid+" is displayed on employee information page");
		} else {
			System.out.println("The created employee id is displayed on employee information page");
		}

	}
	
	@Then("^Close browser for multiple Employees$")
	public void CloseBrowser() {
		driver.quit();
	}

}
