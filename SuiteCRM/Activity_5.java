/* Getting colors Goal: Get the color of the navigation menu
 * a. Open a browser. 
 * b. Navigate to ‘http://alchemy.hguy.co/crm’ and login using the credentials provided. 
 * c. Get the color of the navigation menu and print it to the console. 
 * d. Close the browser.
 */


import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Activity_5 {
	
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
	public void VerifyColor()
	{
		//Get the color of the navigation menu 
		String NavigationColor=driver.findElement(By.xpath("//div[@id='toolbar']")).getCssValue("color");
		//printing the color to the console.
		System.out.println("The color of the Navigation menu:"+NavigationColor);
		
		String BackgroundColor=driver.findElement(By.xpath("//div[@id='toolbar']")).getCssValue("background-color");
		System.out.println("The color of the Back ground Color is:"+BackgroundColor);
		
		
	}
	
	@AfterClass()
	public void CloseBroser()	{
		//Close the browser
	    driver.close();
	}
}

