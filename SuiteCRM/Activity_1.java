 /*Verify the website title Goal: Read the title of the website and verify the text 
  * a. Open a browser.
  *  b. Navigate to ‘http://alchemy.hguy.co/crm’. 
  *  c. Get the title of the website. 
  *  d. Make sure it matches “SuiteCRM” exactly.
  *  e. If it matches, close the browser. 
  */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_1 {
	
	//Create a new instance of the Firefox driver
	WebDriver driver;
	
	@BeforeMethod
	public void OpenBrowser()
	{
		//Open a browser and Navigate to site
		driver =new FirefoxDriver();
		
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test
	public void VerifyPage() 
	{
		// Get the title of the website.
		String pagetitle=driver.getTitle();
		System.out.println("The Page title is :"+pagetitle);
		
		//Make sure it matches “SuiteCRM” exactly.
		Assert.assertEquals("SuiteCRM", pagetitle);
	  
	}
	
	@AfterMethod()
	public void CloseBroser()
	{
		// close the browser
		driver.close();
	}
}

