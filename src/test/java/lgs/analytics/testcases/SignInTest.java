package lgs.analytics.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lgs.analytics.base.TestBase;
import lgs.analytics.pages.PBIAnalyticsHomePage;
import lgs.analytics.pages.PowerBIHomePage;

public class SignInTest extends TestBase{
	PowerBIHomePage homePage;
	PBIAnalyticsHomePage analyticsHomePage;
	
	public SignInTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new PowerBIHomePage();
		analyticsHomePage = new PBIAnalyticsHomePage();
	}
	
	@Test
	public void PBIHomePageTitleTest() {
		String title = homePage.validatePBIHOmePageTitle();
		Assert.assertTrue(title.contains("Power BI"));
	}
	
	@Test
	public void LoginInTest() throws InterruptedException {
		homePage.clickSignInButton();
		homePage.enterEmail();
		homePage.clickNextButton();
		homePage.enterPassword();
		homePage.clickSubmitButton();
	}
	
	@Test
	public void LoginProdEnv() throws InterruptedException {
		LoginInTest();
		analyticsHomePage.clickprodImage();
		Assert.assertTrue(analyticsHomePage.getPageheader().contains("Sales Support@CMP"));
	}
	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}
}
