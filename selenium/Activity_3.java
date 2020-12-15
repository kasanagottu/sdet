package demoSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_3 {

	public static void main(String[] args) {
		
		// Create a new instance of the Firefox driver
		WebDriver driver=new FirefoxDriver();
		
		//Open the browser
		driver.get("https://www.training-support.net/selenium/simple-form");
		
		//Find the page title and print it
		String Pagetitle= driver.getTitle();
		System.out.println("The page title is :"+Pagetitle);
		
		//Find the input fields
		WebElement FirstName=driver.findElement((By.id("firstName")));
		WebElement LastName=driver.findElement((By.id("lastName")));
		 //Enter text
		FirstName.sendKeys("Venkat");
		LastName.sendKeys("K");
		
		 //Enter Email
		driver.findElement(By.id("email")).sendKeys("venkat@gmail.com");
		//Enter the contact number			
		driver.findElement(By.id("number")).sendKeys("12345578");
		//Click Submit
		//driver.findElement(By.cssSelector("ui green button")).click();
		driver.findElement(By.cssSelector(".ui.green.button")).click();
		//Close the browser
       // driver.close();
		
	}

}
