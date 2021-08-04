package home;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class OneWay {

	public WebDriver driver;
	private Properties prop;

	By sel, sel1, depart, city, dest, dateselect, date1, nos, adult, child,infantno, cl, travellers;

	public OneWay(WebDriver driver, Properties prop) {

		this.driver = driver;
		this.prop = prop;

		this.sel = By.cssSelector(prop.getProperty("roundtrip_link_object"));
		this.sel1 = By.cssSelector(prop.getProperty("oneway"));
		this.depart = By.cssSelector(prop.getProperty("depart"));
		this.city = By.xpath(prop.getProperty("Source"));
		this.dest = By.xpath(prop.getProperty("Destination"));
		this.dateselect = By.xpath(prop.getProperty("Depart_date"));
		this.date1 = By.cssSelector(prop.getProperty("Origin_date"));
		this.nos = By.cssSelector(prop.getProperty("cls"));
		this.adult = By.xpath(prop.getProperty("adultno"));
		this.child = By.cssSelector(prop.getProperty("childno"));
		this.cl = By.id(prop.getProperty("search"));
		this.travellers = By.cssSelector(prop.getProperty("count_travellers"));
		this.infantno = By.cssSelector(prop.getProperty("Infant"));

	}

	public void onewaySelect() {

		driver.findElement(sel).click();
		driver.findElement(sel1).click();

	}

	public void AddDepart() {
		WebElement ele = driver.findElement(depart);
		ele.click();
		driver.findElement(city).click();
	}

	public void AddDestination() {

		driver.findElement(dest).click();
	}

	public void AddSource() {
		driver.findElement(date1).click();
		driver.findElement(dateselect).click();
	}

	public void TravellNos() throws InterruptedException {

		driver.findElement(nos).click();

		driver.findElement(adult).click();
		driver.findElement(child).click();
		 WebElement inf = 
		driver.findElement(infantno);
		 for (int i=0; i <= 3; i ++) {
			 Thread.sleep(2000);
		 		inf.click();
			}	

	}

	public void CountVerify() {
		String cf = driver.findElement(travellers).getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("5", cf);
		

	}


	public void SelectClass() {

		driver.findElement(cl).click();

	}

}