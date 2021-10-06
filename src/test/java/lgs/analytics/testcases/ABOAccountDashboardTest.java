package lgs.analytics.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lgs.analytics.base.TestBase;
import lgs.analytics.pages.AccountSnapshotPage;
import lgs.analytics.pages.CountPage;
import lgs.analytics.pages.FiltersPane;
import lgs.analytics.pages.IncomePage;
import lgs.analytics.pages.PBIAnalyticsHomePage;
import lgs.analytics.pages.PowerBIHomePage;
import lgs.analytics.pages.ProductivityPage;

public class ABOAccountDashboardTest extends TestBase{
	PowerBIHomePage homePage;
	PBIAnalyticsHomePage analyticsHomePage;
	AccountSnapshotPage accSnapshotPage;
	FiltersPane filtersPane;
	CountPage countPage;
	ProductivityPage productivityPage;
	IncomePage incomePage;
	
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
		countPage = new CountPage();
		productivityPage = new ProductivityPage();
		incomePage = new IncomePage();
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
	
	@Test
	public void ValidateProductivityPage() throws InterruptedException {
		homePage.loginPBI();
		analyticsHomePage.clickprodImage();
		Assert.assertTrue(analyticsHomePage.getPageheader().contains("Sales Support@CMP"));
		Thread.sleep(15000);
		analyticsHomePage.clickProductivityTab();
		Thread.sleep(4000);
		Assert.assertTrue(productivityPage.getPageheader().contains("Productivity"));
		filtersPane.fillInAffNoImcNo("0702007120");
		productivityPage.clickPrfYrFilter();
		productivityPage.select2020PrfYr();
		productivityPage.clickCurrencyFilter();
		productivityPage.selectLocalCurrency();
		Assert.assertTrue(productivityPage.getRevenueTitle().contains("Revenue"));
		Assert.assertTrue(productivityPage.revenueChartDisplay());
		Assert.assertTrue(productivityPage.revenuePivotTableDisplay());
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
	}
	
	@Test
	public void ValidateIncomePage() throws InterruptedException {
		homePage.loginPBI();
		analyticsHomePage.clickprodImage();
		Assert.assertTrue(analyticsHomePage.getPageheader().contains("Sales Support@CMP"));
		Thread.sleep(15000);
		analyticsHomePage.clickIncomeTab();
		Thread.sleep(4000);
		Assert.assertTrue(incomePage.getPageheader().contains("Income"));
		filtersPane.fillInAffNoImcNo("1007289922");
		Assert.assertTrue(incomePage.getIncomeAmtTitle().contains("Core vs. Incentive Income Amounts"));
		Assert.assertTrue(incomePage.incomeAmtChartDisplay());
		Assert.assertTrue(incomePage.incomeAmtPivotTableDisplay());
		incomePage.scrollToElement("Total Bonus");
		Assert.assertTrue(incomePage.getTotalBonusTitle().contains("Top5 Bonuses received"));
		Assert.assertTrue(incomePage.totalBonusChartDisplay());
		Assert.assertTrue(incomePage.totalBonusPivotTableDisplay());
		incomePage.scrollToElement("Icome Breakdown");
		Assert.assertTrue(incomePage.getIncomeBreakdownTitle().contains("Core vs. Incentive Income Breakdown"));
		Assert.assertTrue(incomePage.incomeBreakdownPivotTableDisplay());
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}
}
