package lgs.analytics.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lgs.analytics.base.TestBase;
import lgs.analytics.pages.CountPage;
import lgs.analytics.pages.FiltersPane;
import lgs.analytics.pages.HATVMetricsPage;
import lgs.analytics.pages.PBIAnalyticsHomePage;
import lgs.analytics.pages.PowerBIHomePage;

public class ABOCountTest extends TestBase{
	PowerBIHomePage homePage;
	PBIAnalyticsHomePage analyticsHomePage;
	FiltersPane filtersPane;
	CountPage countPage;
	
	public ABOCountTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new PowerBIHomePage();
		analyticsHomePage = new PBIAnalyticsHomePage();
		filtersPane = new FiltersPane();
		countPage = new CountPage();
	}
	
	@Test
	public void validateABOCountPage() throws InterruptedException {
		homePage.loginPBI();
		analyticsHomePage.clickprodImage();
		Assert.assertTrue(analyticsHomePage.getPageheader().contains("Sales Support@CMP"));
		Thread.sleep(15000);
		analyticsHomePage.clickCountTab();
		Thread.sleep(4000);
		Assert.assertTrue(countPage.getPageheader().contains("ABO Counts"));
		countPage.clickPrfYrFilter();
		countPage.select2020PrfYr();
		countPage.clicLosFilter();
		countPage.selectPlatinumGroup();
		filtersPane.fillInAffNoImcNo("0702007120");
		Assert.assertTrue(countPage.getGroupSizeTitle().contains("Group Size"));
		Assert.assertTrue(countPage.groupSizeChartDisplay());
		Assert.assertTrue(countPage.groupSizePivotTableDisplay());
		countPage.scrollToElement("Sponsoring");
		Assert.assertTrue(countPage.getsponsoringTitle().contains("Sponsoring"));
		Assert.assertTrue(countPage.sponsoringChartDisplay());
		Assert.assertTrue(countPage.sponsoringPivotTableDisplay());
		countPage.scrollToElement("Contributors");
		Assert.assertTrue(countPage.getContributorsTitle().contains("Contributors"));
		Assert.assertTrue(countPage.contributorsChartDisplay());
		Assert.assertTrue(countPage.contributorsPivotTableDisplay());
		countPage.scrollToElement("Contributing ABO");
		Assert.assertTrue(countPage.getContributingAboTitle().contains("Contributing ABO Percentage"));
		Assert.assertTrue(countPage.contributingAboChartDisplay());
		Assert.assertTrue(countPage.contributingAboPivotTableDisplay());
		countPage.scrollToElement("Contributing ABO");
		Assert.assertTrue(countPage.get90DaysTitle().contains("90 Day Activation"));
		Assert.assertTrue(countPage._90DaysChartDisplay());
		Assert.assertTrue(countPage._90DaysPivotTableDisplay());
		countPage.scrollToElement("Cust / Member");
		Assert.assertTrue(countPage.getcustMemberTitle().contains("Customer / Member Count"));
		Assert.assertTrue(countPage.custMemberChartDisplay());
		Assert.assertTrue(countPage.custMemberPivotTableDisplay());
		countPage.scrollToElement("Average Number");
		Assert.assertTrue(countPage.getAvgNumberTitle().contains("Average Number of Customers / Members per Contributor"));
		Assert.assertTrue(countPage.avgNumberChartDisplay());
		Assert.assertTrue(countPage.avgNumberPivotTableDisplay());
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}
}
