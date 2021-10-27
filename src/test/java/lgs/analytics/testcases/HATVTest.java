package lgs.analytics.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lgs.analytics.base.TestBase;
import lgs.analytics.pages.FiltersPane;
import lgs.analytics.pages.HATVMetricsPage;
import lgs.analytics.pages.PBIAnalyticsHomePage;
import lgs.analytics.pages.PowerBIHomePage;


public class HATVTest extends TestBase{
	PowerBIHomePage homePage;
	PBIAnalyticsHomePage analyticsHomePage;
	HATVMetricsPage hatvPage;
	FiltersPane filtersPane;
	
	public HATVTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new PowerBIHomePage();
		analyticsHomePage = new PBIAnalyticsHomePage();
		hatvPage = new HATVMetricsPage();
		filtersPane = new FiltersPane();
	}
	
	@Test
	public void validateQualifyMonthsValue() throws InterruptedException {
		homePage.loginPBI();
		analyticsHomePage.clickprodImage();
		Assert.assertTrue(analyticsHomePage.getPageheader().contains("Sales Support@CMP"));
		Thread.sleep(15000);
		analyticsHomePage.clickHATVTab();
		Thread.sleep(4000);
		Assert.assertTrue(hatvPage.getPageheader().contains("HATV Metrics"));
		Thread.sleep(4000);
		filtersPane.fillInAffNo("070");
		Thread.sleep(2000);
		filtersPane.fillInABONo("2007120");
		Thread.sleep(3000);
		Assert.assertTrue(hatvPage.qualifiedMonthsTitleDisplay());
		Assert.assertTrue(hatvPage.qualifiedMonthsValue().length() > 0);
		Thread.sleep(3000);
	}
	
	@Test
	public void validateVolumeFluc() throws InterruptedException {
		homePage.loginPBI();
		analyticsHomePage.clickprodImage();
		Assert.assertTrue(analyticsHomePage.getPageheader().contains("Sales Support@CMP"));
		Thread.sleep(15000);
		analyticsHomePage.clickHATVTab();
		Thread.sleep(4000);
		Assert.assertTrue(hatvPage.getPageheader().contains("HATV Metrics"));
		Thread.sleep(4000);
		filtersPane.fillInAffNo("070");
		Thread.sleep(2000);
		filtersPane.fillInABONo("2007120");
		Thread.sleep(3000);
		hatvPage.scrollToElement("Volume Fluc");
		Assert.assertTrue(hatvPage.volumeFlucTitleDisplay());
		Assert.assertTrue(hatvPage.volumeFlucChartDisplay());
		Thread.sleep(3000);
	}
	
	@Test
	public void validateVolumeFlucMonthlyValue() throws InterruptedException {
		homePage.loginPBI();
		analyticsHomePage.clickprodImage();
		Assert.assertTrue(analyticsHomePage.getPageheader().contains("Sales Support@CMP"));
		Thread.sleep(15000);
		analyticsHomePage.clickHATVTab();
		Thread.sleep(4000);
		Assert.assertTrue(hatvPage.getPageheader().contains("HATV Metrics"));
		Thread.sleep(4000);
		filtersPane.fillInAffNo("100");
		Thread.sleep(2000);
		filtersPane.fillInABONo("7289922");
		Thread.sleep(3000);
		hatvPage.clickPerfYrFilter();
		hatvPage.clickYr2021Option();
		Thread.sleep(5000);
		hatvPage.scrollToElement("Volume Fluc");
		Assert.assertEquals(hatvPage.volumeFlucMonthlyValue(), "25,162");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}
}
