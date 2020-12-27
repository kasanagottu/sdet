 /*Traversing tables Goal: Open the accounts page and print the contents of the table. 
  * a. Open the browser to the Alchemy CRM site and login.
  * b. Navigate to the Sales -> Accounts page. 
  * c. Find the table on the page and print the names of the first 5 odd-numbered rows of the table to the console. 
  * d. Close the browser.
  */


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_8 {
	// Create a new instance of the Firefox driver
	WebDriver driver;

	@BeforeClass
	public void OpenBrowser() {
		// Open a browser and Navigate to site
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}

	@Test(priority = 1)
	public void UserLogin() throws InterruptedException {
		// Find and select the username and password fields
		WebElement UserName = driver.findElement(By.id("user_name"));
		WebElement UserPassword = driver.findElement(By.id("username_password"));
		// Enter login credentials into the respective fields
		UserName.sendKeys("admin");
		UserPassword.sendKeys("pa$$w0rd");
		// Click on login button
		driver.findElement(By.id("bigbutton")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void PrintFirst5Names() throws InterruptedException

	{
		// Find the Sales and mouse over on that to Click on the Leads
		WebElement ElementName = driver.findElement(By.id("grouptab_0"));
		String SalesField = ElementName.getText();
		Assert.assertEquals(SalesField, "SALES");
		System.out.println("ElementName is :" + ElementName.getText());
		Actions sales = new Actions(driver);
		sales.moveToElement(ElementName);
		sales.click().build().perform();
		// Click on the Accounts
		driver.findElement(By.id("moduleTab_9_Accounts")).click();
		Thread.sleep(5000);

		// Find the no. of rows in table
		List<WebElement> noOfrows = driver.findElements(By.xpath("//table[contains(@class,'list view table-responsive')]/tbody/tr"));    
		int totalrows=noOfrows.size();
		
		System.out.println("No of rows are : " + totalrows);
		// Find the no. of columns in first row in table
		List<WebElement> noOfcol = driver.findElements(By.xpath("//table[contains(@class,'list view table-responsive')]/tbody/tr[1]/td"));
		System.out.println("No of Columns are : " + noOfcol.size());
		
		//print the names of the first 5 odd-numbered rows of the table to the console. 
		List<WebElement> NameVal = driver.findElements(By.xpath("//table[contains(@class,'list view table-responsive')]/tbody/tr/td[3]"));//Output first 5 odd-numbered rows from Name Column
		//List<WebElement> NameColRow = driver.findElements(By.xpath("//table[contains(@class,'list view table-responsive')]/tbody/tr/td")); // Output: First row values
		
		for (int i = 0; i < 10; i=i+2) 
		{
				String NameText = NameVal.get(i).getText();
				System.out.println("The Name Column Values are :" + NameText);
				
		}
		
	/*	
		for(WebElement cellValue : NameCol) {
            System.out.println("Cell Value: " + cellValue.getText());

		} */
		
		

	}
	
	@AfterClass()
	public void CloseBroser()	{
		//Close the browser
	    driver.close();
	}
}


