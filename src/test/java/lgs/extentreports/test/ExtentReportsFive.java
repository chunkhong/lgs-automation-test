package lgs.extentreports.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReportsFive {
	
	@Test
	public void extendTest() throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html").viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.TEST,ViewName.CATEGORY}).apply();
		ExtentSparkReporter failedspark = new ExtentSparkReporter("target/failed-Spark.html").filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		
		failedspark.config().setDocumentTitle("Failed Test");
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		extent.attachReporter(spark,failedspark);
		
		ExtentTest test = extent.createTest("Login Test");
		test.pass("Login Test started successsfully");
		test.info("URL is loaded");
		test.info("Values entered");
		test.pass("Login Test completed successfully");
		test.pass(MarkupHelper.createLabel("Login Test completed successfully", ExtentColor.GREEN));
		
		Map<String,String> map = new HashMap<>();
		map.put("fname", "ChunKhong");
		map.put("lname", "Cheong");
		map.put("compname", "Amway");
		
		//map.forEach((k,v)->test.pass(k+":"+v));
		test.pass(MarkupHelper.createUnorderedList(map).getMarkup());
		ExtentTest test1 = extent.createTest("Homepage Test");
		test1.pass("Homepage Test started successsfully");
		test1.info("URL is loaded");
		test1.info("Values entered");
		test1.fail("Homepage Test Failed");
		test.fail(MarkupHelper.createLabel("Homepage Test Failed", ExtentColor.RED));
		
		extent.flush();
		Desktop.getDesktop().browse(new File("target/Spark.html").toURI());
		Desktop.getDesktop().browse(new File("target/failed-Spark.html").toURI());
	}
}
