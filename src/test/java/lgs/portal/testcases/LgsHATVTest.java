package lgs.portal.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lgs.portal.base.LgsTestBase;
import lgs.portal.pages.HATVCasesPage;
import lgs.portal.pages.LgsHomePage;
import lgs.portal.pages.LgsLandingPage;

public class LgsHATVTest extends LgsTestBase{
	LgsLandingPage landingPage;
	ssoSignInPage ssoPage;
	LgsHomePage lgsHomePage;
	HATVCasesPage hatvCasesPage;
	
	public LgsHATVTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LgsLandingPage();
		ssoPage = new ssoSignInPage();
		lgsHomePage = new LgsHomePage();
		hatvCasesPage = new HATVCasesPage();
	}
	
	@Test
	public void GoToHATVCasesPage() throws InterruptedException {
		landingPage.clickLoginButton();
		ssoPage.enterNativeId();
		ssoPage.enterPasword();
		ssoPage.clickSubmit();
		lgsHomePage.clickHATVCasesLink();
		Thread.sleep(3000);
		Assert.assertTrue(hatvCasesPage.getPageHeader().contains("HATV Cases"));
	}
	
	@Test
	public void GoToAllCasesTab() throws InterruptedException {
		landingPage.clickLoginButton();
		ssoPage.enterNativeId();
		ssoPage.enterPasword();
		ssoPage.clickSubmit();
		lgsHomePage.clickHATVCasesLink();
		Thread.sleep(3000);
		hatvCasesPage.clickAllCasesTab();
		Thread.sleep(2000);
	}
	
	@Test
	public void GoToUnassignedCasesTab() throws InterruptedException {
		landingPage.clickLoginButton();
		ssoPage.enterNativeId();
		ssoPage.enterPasword();
		ssoPage.clickSubmit();
		lgsHomePage.clickHATVCasesLink();
		Thread.sleep(3000);
		hatvCasesPage.clickUnAssignedCasesTab();
		Thread.sleep(2000);
	}
	
	@Test
	public void SearchABO() throws InterruptedException {
		landingPage.clickLoginButton();
		ssoPage.enterNativeId();
		ssoPage.enterPasword();
		ssoPage.clickSubmit();
		Thread.sleep(3000);
		hatvCasesPage.enterABONoToSearch("2007120");
		Thread.sleep(2000);
		hatvCasesPage.clickSearchButton();
		Thread.sleep(2000);
		hatvCasesPage.clickSearchResult();
		Thread.sleep(8000);
	}
	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}
}
