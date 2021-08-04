package home;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ValiadateTitleSearch {
public WebDriver driver;
		
	
	public  ValiadateTitleSearch(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void getTitle() {
		
		String actual = driver.getTitle();
		String  Expected = "Yatra.com | Bengaluru to Delhi flights";
		Assert.assertEquals(actual,Expected);
	}


}
