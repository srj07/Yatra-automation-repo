package booking;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportings {
	static ExtentReports extent = new ExtentReports();;

	public static ExtentReports getReport()
	{
		String path =System.getProperty("user.dir")+"\\reports\\Index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
	

		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sreeraj");
		return extent;
		
	}

}
