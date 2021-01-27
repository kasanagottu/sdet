package com.cucumber_stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddingCandidate {
	WebDriver driver;
	WebDriverWait wait;
	public String CandidateName;

	@Given("^Open ​OrangeHRM​ page and login with credentials$")
	public void Login_HRM() {
		// Declare new WebDriver
		driver = new FirefoxDriver();
		// Declare new WebDriverWait
		wait = new WebDriverWait(driver, 10);

		driver.get("http://alchemy.hguy.co/orangehrm");
		driver.manage().window().maximize();
		// Enter User Name
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		// Enter Password
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		// Click on login button
		driver.findElement(By.id("btnLogin")).click();
	}

	@When("^Navigate to Recruitment page and navigate to add candidate information$")
	public void NavigateToVacanciesPageA() {
		// Click on the Recruitment Link
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Recruitment")));
		driver.findElement(By.linkText("Recruitment")).click();
		// Click on the Candidates Link
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Candidates")));
		driver.findElement(By.linkText("Candidates")).click();
		// Click on the Add button Link
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("btnAdd")));
		driver.findElement(By.name("btnAdd")).click();
	}

	@And("^Fill details of the candidate \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void Fill_details_and_Save(String FName, String LName, String Email) {
		// Enter First Name
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("addCandidate_firstName")));
		driver.findElement(By.id("addCandidate_firstName")).sendKeys(FName);
		// Enter Last Name
		driver.findElement(By.id("addCandidate_lastName")).sendKeys(LName);
		//concating the first name and last name
		CandidateName=FName+" "+LName;
			
		System.out.println("The Candidate Name is :"+CandidateName);
		// Enter Email
		driver.findElement(By.id("addCandidate_email")).sendKeys(Email);
		// Enter Contact Number
		driver.findElement(By.id("addCandidate_contactNo")).sendKeys("9849512345");
		// Selecting the Job Vacancy
		Select itemSelect = new Select(driver.findElement(By.id("addCandidate_vacancy")));
		itemSelect.selectByVisibleText("DevOps Specialist");
		// Enter the Vacancy Name
		driver.findElement(By.name("addCandidate[comment]")).sendKeys("Candidate-testing");

	}

	@And("^Upload a resume to the form and Click Save$")
	public void UploadResumceAndSave() {
		// Click on the Browse button
		WebElement UploadResume = driver.findElement(By.id("addCandidate_resume"));
		UploadResume.sendKeys("C:\\Users\\VENKATESHAMKASANAGOT\\Desktop\\Sample_CV.docx");
		// Click on the Save button
		driver.findElement(By.id("btnSave")).click();
	}
	@Then("^Validate candidate entry \"(.*)\"$")
	public void ValidateJobVacancy(String CandidateName) throws Exception {
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Candidates")));
		driver.findElement(By.linkText("Candidates")).click();
		//Enter Candidate Name
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("candidateSearch_candidateName")));
		driver.findElement(By.id("candidateSearch_candidateName")).sendKeys(CandidateName);
		driver.findElement(By.id("btnSrch")).click();
		Thread.sleep(500);
		String ActCandidateName = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[2]/td[3]")).getText();
		if (ActCandidateName.equals(CandidateName)) {
			System.out.println("The Candidate was successfully created :" + ActCandidateName + ":" + CandidateName);
		} else {
			System.out.println("The Candidate was not displayed :" + ActCandidateName + ":" + CandidateName);
		}
	}	
	@Then("^Close the browser for Candidate$")
	public void closeBrowser() {
		driver.quit();

	}

}
