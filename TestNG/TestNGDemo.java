package pkgTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestNGDemo {
  @Test
  public void Google() {
	  
	// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
			
		//Open the browser
		driver.get("https://www.google.com");
			
		//Close the browser
		driver.close();
	    }
	  
	  
  }

