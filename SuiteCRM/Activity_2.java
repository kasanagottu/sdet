/*Get the url of the header image Goal: Print the url of the header image to the console 
 * a. Open a browser.
 * b. Navigate to ‘http://alchemy.hguy.co/crm’.
 * c. Get the url of the header image.
 * d. Print the url to the console.
 * e. Close the browser
 */
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Activity_2 {
	
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
	public void PrintImgURL() 
	{
		// Get the url of the header image.
		String himage = driver.findElement(By.xpath("//img[contains(@src,'/default/images/company_logo.png')]")).getAttribute("src");

		//Print the url to the console.
		System.out.println("The image of the URL is :"+himage);
	}
	
	@AfterMethod()
	public void CloseBroser()
	{
		//Close the browser
	   driver.close();
	}
}

