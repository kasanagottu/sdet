package com.cucumber_stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateMultipleVacancies {
	
	WebDriver driver;
	WebDriverWait wait;
	public String JobTitle;
	public String JobVacancy;
	public String HiringManager;
		
	@Given("Open ​OrangeHRM​ page and Navigate to vacancies page")
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
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Recruitment")));
		driver.findElement(By.linkText("Recruitment")).click();
		//Click on the Vacancies Link
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Vacancies")));
		driver.findElement(By.linkText("Vacancies")).click();
		
	}
	
	@When("^Click on “Add” button to navigate “Add Job Vacancy” form$")
	public void Click_add_button() {
	    // Click on the Add button
		driver.findElement(By.id("btnAdd")).click();
		
	}
	     
	@And("^Fill out the necessary details \"(.*)\" and \"(.*)\" and \"(.*)\" Click on the Save button$")
	public void Fill_details_and_Save(String JobTitle, String JobVacancy,String HiringManager) {
		
	    //Click on the "Job Title" button
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("addJobVacancy_jobTitle")));
		//Selecting the Job Title 
		Select itemSelect=new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
		itemSelect.selectByVisibleText(JobTitle);
		//Enter the Vacancy Name
		driver.findElement(By.id("addJobVacancy_name")).sendKeys(JobVacancy);
		//Enter the Hiring Manager
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(HiringManager);
		//Enter Number of Positions
		driver.findElement(By.id("addJobVacancy_noOfPositions")).sendKeys("1");
		//Enter Description
		driver.findElement(By.id("addJobVacancy_description")).sendKeys("testing");
		//Click on the Save Button
		driver.findElement(By.id("btnSave")).click();
		
	}
	      
	@Then("^Validate that all vacancies \"(.*)\" and \"(.*)\" and \"(.*)\" have been created$")
	public void ValidateJobVacancies(String JobTitle, String JobVacancy,String HiringManager) throws Exception {
		//Click on the Vacancies Link
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Vacancies")));
		driver.findElement(By.linkText("Vacancies")).click();
		//Selecting the Job Title 
		Select ExpJobTile=new Select(driver.findElement(By.id("vacancySearch_jobTitle")));
		ExpJobTile.selectByVisibleText(JobTitle);
		Thread.sleep(200);
		//Selecting the Job Vacancy
		Select ExpJobVacancy=new Select(driver.findElement(By.id("vacancySearch_jobVacancy")));
		ExpJobVacancy.selectByVisibleText(JobVacancy);
		Thread.sleep(200);
		//Selecting the Hiring Manager
		Select ActHManager=new Select(driver.findElement(By.id("vacancySearch_hiringManager")));
		ActHManager.selectByVisibleText(HiringManager);
		driver.findElement(By.id("btnSrch")).click();
		Thread.sleep(200);
		String ActJobVacancy = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[2]")).getText();
		if (ActJobVacancy.equals(JobVacancy)) {
			System.out.println("The created Job Vacancy was successfully displayed :" + ActJobVacancy + ":" + JobVacancy);
		} else {
			System.out.println("The created Job Vacancy was not displayed :" + ActJobVacancy + ":" + JobVacancy);
		}
	}	
	
	@Then("^Close the browser multiple JobVacancy$")
	public void CloseBrowser() {
		driver.quit();
	}




}
