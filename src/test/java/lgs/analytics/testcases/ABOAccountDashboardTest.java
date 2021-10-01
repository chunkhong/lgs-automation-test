package lgs.analytics.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lgs.analytics.base.TestBase;
import lgs.analytics.pages.AccountSnapshotPage;
import lgs.analytics.pages.FiltersPane;
import lgs.analytics.pages.PBIAnalyticsHomePage;
import lgs.analytics.pages.PowerBIHomePage;

public class ABOAccountDashboardTest extends TestBase{
	PowerBIHomePage homePage;
	PBIAnalyticsHomePage analyticsHomePage;
	AccountSnapshotPage accSnapshotPage;
	FiltersPane filtersPane;
	
	public ABOAccountDashboardTest() {
		super();
	}
	
	public void ABO_Counts_KPIs_Display() {
		Assert.assertTrue(accSnapshotPage.getABOCountTitle().contains("ABO Counts"));
		Assert.assertTrue(accSnapshotPage.getGroupSizeTitle().contains("Group Size"));
		Assert.assertTrue(accSnapshotPage.getGroupSizeAmount().length() > 0);
		Assert.assertTrue(accSnapshotPage.getGroupSizePerct().length() > 0);
		Assert.assertTrue(accSnapshotPage.getSponsoringTitle().contains("Sponsoring"));
		Assert.assertTrue(accSnapshotPage.getSponsoringAmount().length() > 0);
		Assert.assertTrue(accSnapshotPage.getSponsoringPerct().length() > 0);
		Assert.assertTrue(accSnapshotPage.getContABOPerctTitle().contains("Contributing ABO Percentage"));
		Assert.assertTrue(accSnapshotPage.getContABOPerctValue().length() > 0);
		Assert.assertTrue(accSnapshotPage.getContABOPerctPerct().length() > 0);
		Assert.assertTrue(accSnapshotPage.get90DaysActivTitle().contains("90 Day Activation"));
		Assert.assertTrue(accSnapshotPage.get90DaysActiveValue().length() > 0);
		Assert.assertTrue(accSnapshotPage.get90DaysActivePerct().length() > 0);
		Assert.assertTrue(accSnapshotPage.getPlatinumAndAboveTitle().contains("Platinum and Above Count"));
		Assert.assertTrue(accSnapshotPage.getPlatinumAndAboveValue().length() > 0);
		Assert.assertTrue(accSnapshotPage.getPlatinumAndAbovePerct().length() > 0);
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
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new PowerBIHomePage();
		analyticsHomePage = new PBIAnalyticsHomePage();
		accSnapshotPage =  new AccountSnapshotPage();
		filtersPane = new FiltersPane();
	}
	
	@Test
	public void ABO_AccountDashboard_KPIs_Display () throws InterruptedException {
		homePage.loginPBI();
		analyticsHomePage.clickprodImage();
		Assert.assertTrue(analyticsHomePage.getPageheader().contains("Sales Support@CMP"));
		Thread.sleep(15000);
		Assert.assertTrue(accSnapshotPage.getPageHeader().contains("Account Snapshot"));
		filtersPane.clickAccSnapshot_Aff_Id_Filter();
		Thread.sleep(2000);
		filtersPane.clickFilterType();
		filtersPane.selectFilterTypeOption1();
		filtersPane.clickShowItemValue();
		filtersPane.selectShowItemValueOption5();
		filtersPane.enterABOno("0702007120");
		filtersPane.clickApplyFilterBtn();
		Thread.sleep(5000);
		ABO_Counts_KPIs_Display();
		Productivity_KPIs_Display();
		Renewal_Rates_KPIs_Display();
		Thread.sleep(3000);
	}
	
	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}
}
