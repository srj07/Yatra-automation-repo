package booking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	WebDriver driver;
	Properties prop = new Properties();

	public WebDriver initializeDriver() throws IOException {

		FileInputStream fi = new FileInputStream(
				"C:\\Users\\MyPc\\eclipse-workspace3\\YatraBooking\\src\\main\\java\\booking\\data.properties");
		prop.load(fi);

		String browserName = prop.getProperty("Browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D://ChromeDriver//Chromedriver.exe");
			ChromeOptions ci = new ChromeOptions();
			ci.addArguments("--disable-notifications");
			driver = new ChromeDriver(ci);
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D://GeckoDriver//geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public String getScreenShotPath(String testcaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\Reports\\" + testcaseName + ".png";
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;

	}

}
