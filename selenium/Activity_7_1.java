package demoSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_7_1 {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		
		//Open browser		
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		
		//Verifying the page title
		String pagetitle=driver.getTitle();
		System.out.println(" The page title is :"+pagetitle);
		
		 //Finding username and password fields and enter the values
		
		driver.findElement(By.xpath("//input[starts-with(@class,'username')]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[contains(@class,'password')]")).sendKeys("password");
		
		 //Click Log in
		 driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		 
		//Print login message
	      String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	      System.out.println("Login message: " + loginMessage);
	        
	      //Close browser
	     driver.close();
	 
		
		
		
	}

}
