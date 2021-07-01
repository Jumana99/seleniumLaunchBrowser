

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;

import java.util.*;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args)  throws InterruptedException {
		// TODO Auto-generated method stub

		//System.out.println("Hello\nJumana");
		//System.out.println("yesss");
		String webSite = "https://www.google.com/";
		String keyToSearch = "youtube";
		String expectedResult = "youtube.com";
		String value;
		
		
		try {
		Assert.assertNotNull(webSite);
		
		//System property for chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jumanaS\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		//.\\driver\\chromedriver.exe
		
		//C:\\Users\\jumanaS\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe
		
		//Instantiate a chromeDriver class
		WebDriver driver = new ChromeDriver();
		
	
		//launch Website
		//driver.navigate().to(webSite);
		 driver.get(webSite);
		
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		

		//search for element
		WebElement elementSearch = driver.findElement(By.name("q"));//finding the web element using name locator
		elementSearch.sendKeys(new String[]{keyToSearch});
		elementSearch.submit();
		
		//Thread.sleep(2000);
		

	
		//check if the results contain "youtube.com"
		
		try{
		
		WebElement elementLink = driver.findElement(By.xpath(".//link[contains(@href,'" + expectedResult+ "')]"));
		//WebElement elementLink = driver.findElement(By.xpath(".//link[contains(@href,'youtube.com')]"));
		//System.out.println("Number of web elements: " +linksList.size());
		System.out.println("Element Link: " +elementLink);
		
		value = elementLink.getAttribute("href");
		System.out.println("\nValue = "+value);
		

		
		System.out.println("\nThe page sourse is contain the element.");
		
		
	
		
		//assert if true
		try {
			Assert.assertTrue(value.contains(expectedResult));

			System.out.println("\nyoutube.com is present on the home page.");
		}catch (AssertionError e)
			{
				System.out.println(e);
			}
		

		//NoSuchElementException
		
		}catch(NoSuchElementException e) {
			System.out.println(e);
		}
		
	
		
		
		
		/*if (driver.getPageSource().contains(expectedResult)) {
			System.out.println("Contain the element");
		}
		
		else {
			System.out.println("Doesn't contain the element");
		}*/

		
		
			driver.close();
			//driver.quit();
			
	    }catch(AssertionError e) {
			System.out.println(e);
		}
		
	}
	

}