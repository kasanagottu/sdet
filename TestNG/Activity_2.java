package pkgTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity_2 {
	
	WebDriver driver;
	
	//@BeforeClass
	 @BeforeTest
	public void OpenBrowser()
	{
		//Create a new instance of the Firefox driver
		driver=new FirefoxDriver();
		
		//Open browser
		driver.get("https://www.training-support.net/selenium/target-practice");
	}
	
	@Test
	public void VerifyPageTitle()
	{
		String titlepage=driver.getTitle();
		System.out.println("The Page title is :"+titlepage);
		Assert.assertEquals("Target Practice", titlepage);
	}
	
	@Test
	public void findColor()
	{
		//WebElement sbutton= driver.findElement(By.xpath("//button[contains(text(),'black')]"));
		WebElement sbutton = driver.findElement(By.cssSelector("button.black"));
		String txtval=sbutton.getText();
		boolean txt=sbutton.isDisplayed();
		System.out.println("The Value is:"+txt);
		System.out.println("The color Name is:"+txtval);
		Assert.assertEquals(txtval,"Black1"); //give incorrect color name and make it fail
		
	}
	
	
    @Test(enabled = false)
    public void testCase3() {
        //This test will be skipped and not counted
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }
    
    @Test
    public void testCase4() {
        //This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");      
    }
 
   // @AfterClass
    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}    

