package lgs.portal.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lgs.portal.base.LgsTestBase;
import lgs.portal.pages.LgsLandingPage;

public class LgsLoginTest extends LgsTestBase{
	LgsLandingPage landingPage;
	ssoSignInPage ssoPage;
	
	public LgsLoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LgsLandingPage();
		ssoPage = new ssoSignInPage();
	}
	
	@Test
	public void LoginInTest() throws InterruptedException {
		landingPage.clickLoginButton();
		ssoPage.enterNativeId();
		ssoPage.enterPasword();
		ssoPage.clickSubmit();
	}
	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}
}
