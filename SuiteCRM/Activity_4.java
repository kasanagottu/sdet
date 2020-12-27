 /*Logging into the site Goal: Open the site and login with the credentials provided
  * a. Open the browser
  * b. Navigate to ‘https://alchemy.hguy.co/crm’. 
  * c. Find and select the username and password fields
  * d. Enter login credentials into the respective fields 
  * e. Click login 
  * f. Verify that the homepage has opened. 
  * g. Close the browser. 
  */

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Activity_4 {
	
	//Create a new instance of the Firefox driver
	WebDriver driver;
	
	@BeforeClass
	public void OpenBrowser()
	{
		//Open a browser and Navigate to site
		driver =new FirefoxDriver();
		
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void UserLogin() throws InterruptedException 
	{
		//Find and select the username and password fields
		
		WebElement UserName = driver.findElement(By.id("user_name"));
		
		WebElement UserPassword = driver.findElement(By.id("username_password"));

		//Enter login credentials into the respective fields
		UserName.sendKeys("admin");
		UserPassword.sendKeys("pa$$w0rd");
		
		//Click on login button
		driver.findElement(By.id("bigbutton")).click();
		Thread.sleep(2000);
		
		
	}
	
	@Test
	public void VerifyHomePage() 
	{
		WebElement HomePage=driver.findElement(By.xpath("//a[contains(@class,'home-icon')]"));
		
		Assert.assertTrue(HomePage.isDisplayed());
		
		//Boolean testpass=HomePage.isDisplayed();
		
		//System.out.println(testpass);
	}	
	
	@AfterClass()
	public void CloseBroser()	{
		//Close the browser
	    driver.close();
	}
}

