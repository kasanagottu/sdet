/*Get the copyright text Goal: Print the first copyright text in the footer to the console 
 * a. Open a browser.
 * b. Navigate to ‘http://alchemy.hguy.co/crm’.
 * c. Get the first copyright text in the footer. 
 * d. Print the text to the console. 
 * e. Close the browser
 */
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Activity_3 {
	
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
	public void VerifyfooterOne() 
	{
		// Get the first copyright text in the footer.
		String footertext = driver.findElement(By.xpath("//a[@id='admin_options']")).getText();

		//Print the text to the console.
		System.out.println("The first copyright text is :"+footertext);
	}
	
	@AfterMethod()
	public void CloseBroser()	{
		//Close the browser
	    driver.close();
	}
}



