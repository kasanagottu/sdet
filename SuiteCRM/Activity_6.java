/* Menu checking Goal: Make sure that the “Activities” menu item exists and is clickable 
 * a. Open a browser.
 * b. Navigate to ‘http://alchemy.hguy.co/crm’ and login using the credentials provided. 
 * c. Locate the navigation menu. 
 * d. Ensure that the “Activities” menu item exists. 
 * e. Close the browser
 */

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Activity_6 {
	
	//Create a new instance of the Firefox driver
	WebDriver driver;
	
	@BeforeClass
	public void OpenBrowser()
	{
		//Open a browser and Navigate to site
		driver =new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
	}
	
	@Test (priority = 1)
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
		Thread.sleep(5000);
		
	/*	Boolean ActTab=driver.findElement(By.xpath("//a[@id='grouptab_3']")).isDisplayed();
		
		System.out.println("The Activities Link is Exist :"+ActTab);
		
		Boolean ActLink=driver.findElement(By.xpath("//a[@id='grouptab_3']")).isEnabled();
				
		if(ActLink=true)
		{
			System.out.println("The Menu item-> Activities is Clickable :"+ActLink);
		}else {
			System.out.println("The Menu item-> Activities is not Cickable");
		}*/
	
	}

	 @Test (priority = 2)
	public void MenuItems()
	{
		//Locate the navigation menu. & Ensure that the “Activities” menu item exists.
		 
		 Boolean ActTab=driver.findElement(By.xpath("//a[@id='grouptab_3']")).isDisplayed();
			
			System.out.println("The Activities Link is Exist :"+ActTab);
		 
		 Boolean ActLink=driver.findElement(By.xpath("//a[@id='grouptab_3']")).isEnabled();
		 
		 if(ActLink=true)
			{
				System.out.println("The Menu item-> Activities is Clickable :"+ActLink);
			}else {
				System.out.println("The Menu item-> Activities is not Clickable");
			}
		
	}	
		
	
	
	@AfterClass()
	public void CloseBroser()	{
		//Close the browser
	    driver.close();
	}
}


/*String  MenuAct=driver.findElement(By.xpath("//*[@id=\"grouptab_3\"]")).getText();
System.out.println(MenuAct); 
  String actcol=driver.findElement(By.xpath("//a[@id='grouptab_3']")).getText();
			System.out.println("the tab name is :"+actcol);
		//boolean MenuAct=driver.findElement(By.linkText("Activities")).isEnabled();
		
		//boolean MenuAct1=driver.findElement(By.cssSelector("[id='grouptab_3']")).isEnabled();
		
		
		
	}	
	
	 /*	if(MenuAct=true)
		{
			System.out.println("The Menu item : Activities is -> existed"+MenuAct);
		}	
		else { 
			System.out.println("The Menu item : Activities is -> not existed");
		}
		
		boolean checkclicking=driver.findElement(By.xpath("//a[@id='grouptab_3']")).isEnabled();
		
		if(checkclicking=true)
		{
			System.out.println("The Menu item-> Activities is clickable"+checkclicking);
		}else {
			System.out.println("The Menu item-> Activities is not clickable");
		}
	} */