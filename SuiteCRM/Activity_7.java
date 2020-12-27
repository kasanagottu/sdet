 /*Reading additional information Goal: Reading a popup that contains additional information about the account/lead. 
  * a. Open the browser to the Alchemy CRM site and login. 
  * b. Navigate to Sales -> Leads 
  * c. In the table, find the Additional information icon at the end of the row of your newly created lead. Click it. 
  * d. Read the popup and print the phone number displayed in it. 
  * e. Close the browser
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

public class Activity_7 {
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
	public void PrintMobileNum() throws InterruptedException

	{
		// Find the Sales and mouse over on that to Click on the Leads
		WebElement ElementName = driver.findElement(By.id("grouptab_0"));
		String SalesField = ElementName.getText();
		Assert.assertEquals(SalesField, "SALES");
		System.out.println("ElementName is :" + ElementName.getText());
		Actions sales = new Actions(driver);
		sales.moveToElement(ElementName);
		sales.click().build().perform();
		// Click on the Leads
		driver.findElement(By.id("moduleTab_9_Leads")).click();
		Thread.sleep(5000);

		// Find the no. of rows in table
		List<WebElement> noOfrows = driver.findElements(By.xpath("//table[contains(@class,'list view table-responsive')]/tbody/tr"));    
		int totalrows=noOfrows.size();
		
		System.out.println("No of rows are : " + totalrows);
		// Find the no. of columns in first row in table
		List<WebElement> noOfcol = driver.findElements(By.xpath("//table[contains(@class,'list view table-responsive')]/tbody/tr[1]/td"));
		System.out.println("No of Columns are : " + noOfcol.size());
		
		//Click on the Additional information icon at the end of the row  
		WebElement AddDetailLink= driver.findElement(By.xpath("//table[contains(@class,'list view table-responsive')]/tbody/tr[1]/td[10]/span/span[contains(@title,'Additional')]"));
		AddDetailLink.click();
		Thread.sleep(2000);
		// Read the popup and print in the Console
		String MobileNum = driver.findElement(By.xpath("//span[contains(@class,'phone')]")).getText();
		System.out.println("The Mobile Number is :"+MobileNum);
				
		}
	
	@AfterClass()
	public void CloseBroser()	{
		//Close the browser
		   driver.close();
	}
}


