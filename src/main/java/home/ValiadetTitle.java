package home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ValiadetTitle {
	
	public WebDriver driver;
		
	
	public  ValiadetTitle(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void getTitle() {
		
		String actual = driver.getTitle();
		String  Expected = "Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com";
		Assert.assertEquals(actual,Expected);
	}

}
