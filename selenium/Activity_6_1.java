package demoSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_6_1 {

	public static void main(String[] args) {
		
		WebDriver driver =new FirefoxDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
        
        //Open browser
		
		driver.get("https://training-support.net/selenium/dynamic-controls");


        //Find checkbox and toggle button
		
		WebElement Checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
		
		WebElement Buttonn=driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
		
		//Click the toggle button
		Buttonn.click();
		
		//Wait for checkbox to disappear
		wait.until(ExpectedConditions.invisibilityOf(Checkbox));
		//Click toggle button again
		Buttonn.click();
		
		//Wait for checkbox to appear
        wait.until(ExpectedConditions.visibilityOf(Checkbox));
        Checkbox.click();
        
        //Close browser
        driver.close();
	        
	}

}
