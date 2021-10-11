package lgs.extentreports.test;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class AttachScreenshotTest {
	ExtentReports extent;
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() throws IOException {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		spark.loadXMLConfig(new File("extentconfig.xml"));
		extent.attachReporter(spark);
	}
	
	@AfterSuite
	public void tearDown() throws IOException {
		driver.quit();
		extent.flush();
		Desktop.getDesktop().browse(new File("index.html").toURI());
	}
	
	@Test
	public void attachScreenShot() throws IOException {
		ExtentTest test = extent.createTest("First Test");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MYU076GJ\\Documents\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		test.pass("Browser opened");
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
		
		test.pass("Value entered",MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotPath()).build());
		test.pass("test finished");
		test.pass(MarkupHelper.createLabel("First Test completed successfully", ExtentColor.GREEN));
	}
	
	public String getScreenshotPath() throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshots/image.png";
		FileUtils.copyFile(source, new File(path));
		return path;
	}
	
	public String getScreenshotBase64() throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshots/image.png";
		FileUtils.copyFile(source, new File(path));
		byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(path));
		return Base64.getEncoder().encodeToString(imageBytes);	
	}
}
