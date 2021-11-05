package lgs.analytics.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import lgs.analytics.base.TestBase;
import lgs.analytics.pages.AccountSnapshotPage;
import lgs.analytics.pages.CountPage;
import lgs.analytics.pages.FiltersPane;
import lgs.analytics.pages.IncomePage;
import lgs.analytics.pages.PBIAnalyticsHomePage;
import lgs.analytics.pages.PowerBIHomePage;
import lgs.analytics.pages.ProductivityPage;
import lgs.analytics.utility.Asserts;

public class ABOAccountDashboardTest extends TestBase{
	PowerBIHomePage homePage;
	PBIAnalyticsHomePage analyticsHomePage;
	AccountSnapshotPage accSnapshotPage;
	FiltersPane filtersPane;
	CountPage countPage;
	ProductivityPage productivityPage;
	IncomePage incomePage;
	
	Asserts asserts;
	boolean status = false;

	//create the htmlReporter object
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1,test2,test3;
	
	public ABOAccountDashboardTest() {
		super();
	}
	
	public void statusCheck(boolean status, ExtentTest testName, String expectedValue, String actualValue) throws Exception {
		if (status == false) {
			testName.fail(expectedValue + " Not Found !!! Actual value found = " +  actualValue,MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotPath(expectedValue)).build());
			Assert.assertTrue(status);
		}else {
			testName.pass(expectedValue + " test passed.");
		}
	}
	
	public String getScreenshotPath(String testName) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String loc = "/Screenshots/" + testName.replaceAll("\\s+", "") + ".png";
		//String path = System.getProperty("user.dir")+"/Screenshots/" + testName.replaceAll("\\s+", "") + ".png";
		String path = System.getProperty("user.dir")+ loc.replaceAll("'",""); //"/Screenshots/groupsize.png";
		FileUtils.copyFile(source, new File(path));
		return path;
	}

	public boolean ABO_Counts_KPIs_Display() throws Exception {
		status = asserts.TextEqual(accSnapshotPage.getABOCountTitle(), "ABO Counts");
		statusCheck(status, test2, "'ABO Counts Page Title'", accSnapshotPage.getABOCountTitle());
		status = asserts.TextEqual(accSnapshotPage.getGroupSizeTitle(), "-");
		statusCheck(status, test2, "'Group Size Header'", accSnapshotPage.getGroupSizeTitle());
		status = asserts.AnyText(accSnapshotPage.getGroupSizeAmount());
		statusCheck(status, test2, "'Group Size Amount'", accSnapshotPage.getGroupSizeAmount());
		status = asserts.AnyText(accSnapshotPage.getGroupSalesPVPerct());
		statusCheck(status, test2, "'Group Size Percentage'", accSnapshotPage.getGroupSizePerct());
		status = asserts.TextEqual(accSnapshotPage.getSponsoringTitle(), "Sponsoring");
		statusCheck(status, test2, "'Sponsoring Header'",accSnapshotPage.getSponsoringTitle());
		status = asserts.AnyText(accSnapshotPage.getSponsoringAmount());
		statusCheck(status, test2, "'Sponsoring Amount'", accSnapshotPage.getSponsoringAmount());
		status = asserts.AnyText(accSnapshotPage.getSponsoringPerct());
		statusCheck(status, test2, "'Sponsoring Percentage'", accSnapshotPage.getSponsoringPerct());
		status = asserts.TextEqual(accSnapshotPage.getContABOPerctTitle(), "Contributing ABO Percentage");
		statusCheck(status, test2, "'Contributing ABO Percentage Header'",accSnapshotPage.getContABOPerctTitle());
		status = asserts.AnyText(accSnapshotPage.getContABOPerctValue());
		statusCheck(status, test2, "'Contributing ABO Percentage'", accSnapshotPage.getContABOPerctValue());
		status = asserts.AnyText(accSnapshotPage.getContABOPerctPerct());
		statusCheck(status, test2, "'Contributing ABO PY Percentage'", accSnapshotPage.getContABOPerctPerct());
		status = asserts.TextEqual(accSnapshotPage.get90DaysActivTitle(), "90 Day Activation");
		statusCheck(status, test2, "'90 Day Activation Header'", accSnapshotPage.get90DaysActivTitle());
		status = asserts.AnyText(accSnapshotPage.get90DaysActiveValue());
		statusCheck(status, test2, "'90 Day Activation Percentage'", accSnapshotPage.get90DaysActiveValue());
		status = asserts.AnyText(accSnapshotPage.get90DaysActivePerct());
		statusCheck(status, test2, "'90 Day Activation PY Percentage'", accSnapshotPage.get90DaysActivePerct());
		status = asserts.TextEqual(accSnapshotPage.getPlatinumAndAboveTitle(), "Platinum and Above Count");
		statusCheck(status, test2, "'Platinum and Above Count Header'", accSnapshotPage.getPlatinumAndAboveTitle());
		status = asserts.AnyText(accSnapshotPage.getPlatinumAndAboveValue());
		statusCheck(status, test2, "'Platinum and Above Count'", accSnapshotPage.getPlatinumAndAboveValue());
		status = asserts.AnyText(accSnapshotPage.getPlatinumAndAbovePerct());
		statusCheck(status, test2, "'Platinum and Above Count Percentage'", accSnapshotPage.getPlatinumAndAbovePerct());
		return status;
	}
	
	public void Productivity_KPIs_Display() {
		accSnapshotPage.scrollToTitle("Productivity");
		Assert.assertTrue(accSnapshotPage.getProductivityTitle().contains("Productivity"));
		Assert.assertTrue(accSnapshotPage.getRevenueTitle().contains("Revenue"));
		Assert.assertTrue(accSnapshotPage.getRevenueAmount().length() > 0);
		Assert.assertTrue(accSnapshotPage.getRevenuePerct().length() > 0);
		Assert.assertTrue(accSnapshotPage.getGroupSalesPVTitle().contains("Group Sales PV"));
		Assert.assertTrue(accSnapshotPage.getGroupSalesPVAmount().length() > 0);
		Assert.assertTrue(accSnapshotPage.getGroupSalesPVPerct().length() > 0);
		Assert.assertTrue(accSnapshotPage.getGroupSalesPVaboTitle().contains("Group Sales PV per Contributing ABO"));
		Assert.assertTrue(accSnapshotPage.getGroupSalesPVaboAmount().length() > 0);
		Assert.assertTrue(accSnapshotPage.getGroupSalesPVaboPerct().length() > 0);
	}
	
	public void Renewal_Rates_KPIs_Display() {
		accSnapshotPage.scrollToTitle("Renewal Rates");
		Assert.assertTrue(accSnapshotPage.getRenewalRatesTitle().contains("Renewal Rates"));
		Assert.assertTrue(accSnapshotPage.getFirstYrRenewalRatesTitle().contains("1st Year Renewal Rates"));
		Assert.assertTrue(accSnapshotPage.getFirstYrRenewalRatesAmount().length() > 0);
		Assert.assertTrue(accSnapshotPage.getFirstYrRenewalRatesPerct().length() > 0);
		Assert.assertTrue(accSnapshotPage.getSecondYrRenewalRatesTitle().contains("2nd Year Renewal Rates"));
		Assert.assertTrue(accSnapshotPage.getSecondYrRenewalRatesAmount().length() > 0);
		Assert.assertTrue(accSnapshotPage.getSecondYrRenewalRatesPerct().length() > 0);
		Assert.assertTrue(accSnapshotPage.getTotalYrRenewalRatesTitle().contains("Total Renewal Rates"));
		Assert.assertTrue(accSnapshotPage.getTotalYrRenewalRatesAmount().length() > 0);
		Assert.assertTrue(accSnapshotPage.getTotalYrRenewalRatesPerct().length() > 0);
	}
	
	@BeforeSuite
	public void setUpExtentReport() {
		htmlReporter = new ExtentSparkReporter("analyticsextentReport.html");
		//create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new PowerBIHomePage();
		analyticsHomePage = new PBIAnalyticsHomePage();
		accSnapshotPage =  new AccountSnapshotPage();
		filtersPane = new FiltersPane();
		countPage = new CountPage();
		productivityPage = new ProductivityPage();
		incomePage = new IncomePage();
		asserts = new Asserts();
	}
	
	@Test
	public void ABO_AccountDashboard_KPIs_Display () throws Exception {
		//creates a toggle for the given test, add all log events under it
		test2 = extent.createTest("Account Dashboard Test", "test to validate account snapshot page");
		test2.log(Status.INFO, "Starting test case");
		
		homePage.loginPBI();
		analyticsHomePage.clickprodImage();
		status = asserts.TextEqual(analyticsHomePage.getPageheader(), "Sales Support@CMP");
		statusCheck(status, test2, "'Sales Support@CMP Header'", analyticsHomePage.getPageheader());
		Thread.sleep(15000);
		status = asserts.TextEqual(accSnapshotPage.getPageHeader(), "Account Snapshot");
		statusCheck(status, test2, "'Account Snapshot Header'", accSnapshotPage.getPageHeader());
		filtersPane.clickAccSnapshot_Aff_Id_Filter();
		Thread.sleep(2000);
		filtersPane.clickFilterType();
		filtersPane.selectFilterTypeOption1();
		filtersPane.clickShowItemValue();
		filtersPane.selectShowItemValueOption5();
		filtersPane.enterABOno("0702007120");
		filtersPane.clickApplyFilterBtn();
		Thread.sleep(5000);
		status = ABO_Counts_KPIs_Display();
		Productivity_KPIs_Display();
		Renewal_Rates_KPIs_Display();
		test2.pass("Account Snapshot Page Test Successfully");
		Thread.sleep(3000);
		if (status == false) {
			test2.fail("Test is Failed");
			Assert.assertTrue(status);
		}
	}
	
	@Test
	public void ValidateProductivityPage() throws InterruptedException {
		//creates a toggle for the given test, add all log events under it
		test1 = extent.createTest("Productivity Page Test", "test to validate productivity page");
		test1.log(Status.INFO, "Starting test case");
		
		homePage.loginPBI();
		test1.pass("Login Successully");
		analyticsHomePage.clickprodImage();
		status = asserts.TextEqual(analyticsHomePage.getPageheader(), "Sales Support@CMP");
		Thread.sleep(15000);
		analyticsHomePage.clickProductivityTab();
		Thread.sleep(4000);
		status = asserts.TextEqual(productivityPage.getPageheader(), "Productivity");
		test1.pass("Land to Productivity Page Successully");
		filtersPane.fillInAffNoImcNo("0702007120");
		Thread.sleep(3000);
		productivityPage.clickPrfYrFilter();
		productivityPage.select2020PrfYr();
		Thread.sleep(3000);
		productivityPage.clickCurrencyFilter();
		productivityPage.selectLocalCurrency();
		Thread.sleep(3000);
		status = asserts.TextEqual(productivityPage.getRevenueTitle(), "Revenue");
		Assert.assertTrue(productivityPage.revenueChartDisplay());
		Assert.assertTrue(productivityPage.revenuePivotTableDisplay());
		test1.pass("Revenue KPIs Display Successully");
		productivityPage.scrollToElement("Revenue Per ABO");
		Assert.assertTrue(productivityPage.getRevenuePerABOTitle().contains("Revenue per Contributing ABO"));
		Assert.assertTrue(productivityPage.revenuePerABOChartDisplay());
		Assert.assertTrue(productivityPage.revenuePerABOPivotTableDisplay());
		productivityPage.scrollToElement("Group Sales PV");
		Assert.assertTrue(productivityPage.getGroupSalesPVTitle().contains("Group Sales PV"));
		Assert.assertTrue(productivityPage.groupSalesPVChartDisplay());
		Assert.assertTrue(productivityPage.groupSalesPVPivotTableDisplay());
		productivityPage.scrollToElement("Group Sales PV Per ABO");
		Assert.assertTrue(productivityPage.getGroupSalesPVABOTitle().contains("Group Sales PV per Contributing ABO"));
		Assert.assertTrue(productivityPage.groupSalesPVABOChartDisplay());
		Assert.assertTrue(productivityPage.groupSalesPVABOPivotTableDisplay());
		productivityPage.scrollToElement("Customer & Member");
		Assert.assertTrue(productivityPage.getCustMemberTitle().contains("Customer & Member PV per Contributing ABO"));
		Assert.assertTrue(productivityPage.custMemberChartDisplay());
		Assert.assertTrue(productivityPage.custMemberPivotTableDisplay());
		productivityPage.scrollToElement("VCS PV");
		Assert.assertTrue(productivityPage.getVcsPVTitle().contains("Verified Customer Sales PV per Contributing ABO"));
		Assert.assertTrue(productivityPage.vcsPVChartDisplay());
		Assert.assertTrue(productivityPage.vcsPVPivotTableDisplay());
		productivityPage.scrollToElement("Percentage of Group Sales PV");
		Assert.assertTrue(productivityPage.getPerctGSPVTitle().contains("Percentage of Group Sales PV Generated by Customers / Members"));
		Assert.assertTrue(productivityPage.perctGSPVChartDisplay());
		Assert.assertTrue(productivityPage.perctGSPVPivotTableDisplay());
		Thread.sleep(4000);
		if (status == false) {
			test1.fail("Test is Failed");
			Assert.assertTrue(status);
		}
	}
	
	@Test
	public void ValidateIncomePage() throws InterruptedException {
		//creates a toggle for the given test, add all log events under it
		test3 = extent.createTest("Income Page Test", "test to validate income page");
		test3.log(Status.INFO, "Starting test case");
		
		homePage.loginPBI();
		analyticsHomePage.clickprodImage();
		status = asserts.TextEqual(analyticsHomePage.getPageheader(), "Sales Support@CMP");
		Thread.sleep(15000);
		analyticsHomePage.clickIncomeTab();
		Thread.sleep(4000);
		status = asserts.TextEqual(incomePage.getPageheader(), "Income");
		filtersPane.fillInAffNoImcNo("1007289922");
		Assert.assertTrue(incomePage.getIncomeAmtTitle().contains("Core vs. Incentive Income Amounts"));
		Assert.assertTrue(incomePage.incomeAmtChartDisplay());
		Assert.assertTrue(incomePage.incomeAmtPivotTableDisplay());
		incomePage.scrollToElement("Total Bonus");
		status = asserts.TextEqual(incomePage.getTotalBonusTitle(), "Income");
		if (status == false) {
			test3.fail("'" + incomePage.getTotalBonusTitle() + "' title Not equal expected Title 'Income'.");
			//Assert.assertTrue(status);
		}
		Assert.assertTrue(incomePage.getTotalBonusTitle().contains("Top5 Bonuses received"));
		Assert.assertTrue(incomePage.totalBonusChartDisplay());
		Assert.assertTrue(incomePage.totalBonusPivotTableDisplay());
		incomePage.scrollToElement("Icome Breakdown");
		status = asserts.TextEqual(incomePage.getIncomeBreakdownTitle(), "Core vs. Incentive Income Breakdown");
		Assert.assertTrue(incomePage.incomeBreakdownPivotTableDisplay());
		incomePage.scrollToElement("Income Comparison");
		Assert.assertTrue(incomePage.getImcomeComparisonTitle().contains("Personal Income Comparison"));
		Assert.assertTrue(incomePage.incomeComparisonChartDisplay());
		Assert.assertTrue(incomePage.incomeComparisonPivotTableDisplay());
		incomePage.scrollToElement("Income Analytics");
		Assert.assertTrue(incomePage.getImcomeAnalyticsTitle().contains("ABO Group Income Analytics"));
		Assert.assertTrue(incomePage.incomeAnalyticsChartDisplay());
		Assert.assertTrue(incomePage.incomeAnalyticsPivotTableDisplay());
		Thread.sleep(4000);
		test3.pass("Test Passed Successfully");
		if (status == false) {
			test3.fail("Test is Failed");
			Assert.assertTrue(status);
		}
	}
	
	@AfterMethod
	public void endTest(ITestResult result) {
		driver.quit();
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}
