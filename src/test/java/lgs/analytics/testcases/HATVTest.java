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
		Thread.sleep(3000);
		filtersPane.fillInABONo("2007120");
		Thread.sleep(3000);
		hatvPage.scrollToTitle("Volume Fluc");
		Assert.assertTrue(hatvPage.volumeFlucTitleDisplay());
		Assert.assertTrue(hatvPage.volumeFlucChartDisplay());
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}
}
