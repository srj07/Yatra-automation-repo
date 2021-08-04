package booking;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import home.OneWay;
import home.ValiadateTitleSearch;
import home.ValiadetTitle;

public class HomePage extends BaseClass {

	public WebDriver driver;

	OneWay ow;

	@BeforeTest
	public void Setup() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("Url"));
		driver.manage().window().maximize();

	}

	
	@Test(priority=0)
	public void RouteAdd() {

		ValiadetTitle bp = new ValiadetTitle(driver);
		bp.getTitle();
		ow = new OneWay(driver, prop);
		ow.onewaySelect();
		ow.AddDepart();
		ow.AddDestination();
		

	}
	@Test(priority=1)
	public void AddCalendar() throws InterruptedException {
		ow = new OneWay(driver,prop);
		ow.AddSource();
	   ow.TravellNos();
	   ow.CountVerify();
	   ow.SelectClass();

		
	}
	
	@Test(priority=2,dependsOnMethods={"AddCalendar"})
	public void ValidateSearchTitle() {
		ValiadateTitleSearch vt = new ValiadateTitleSearch(driver);
		
		vt.getTitle();
	}
	
	
	
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
