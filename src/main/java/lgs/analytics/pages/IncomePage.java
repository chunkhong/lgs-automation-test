package lgs.analytics.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lgs.analytics.base.TestBase;

public class IncomePage extends TestBase{
	@FindBy(css="div[title=\"Income\"]")
	WebElement pageHeader;
	
	@FindBy(css="div[title=\"Core vs. Incentive Income Amounts\"]")
	WebElement incomeAmtTitle;
	
	@FindBy(css="div[tab-order=\"40000\"] .cartesianChart")
	WebElement incomeAmtChart;
	
	@FindBy(css="div[tab-order=\"19000\"] .bodyCells")
	WebElement incomeAmtPivotTable;
	
	@FindBy(css="div[title=\"Top5 Bonuses received\"]")
	WebElement totalBonusTitle;
	
	@FindBy(css="div[tab-order=\"17000\"] .donutChart")
	WebElement totalBonusChart;
	
	@FindBy(css="div[tab-order=\"18000\"] .bodyCells")
	WebElement totalBonusPivotTable;
	
	@FindBy(css="div[title=\"Core vs. Incentive Income Breakdown\"]")
	WebElement incomeBreakdownTitle;
	
	@FindBy(css="div[tab-order=\"11000\"] .bodyCells")
	WebElement incomeBreakdownPivotTable;
	
	@FindBy(css="div[title=\"Personal Income Comparison\"]")
	WebElement incomeComparisonTitle;
	
	@FindBy(css="div[tab-order=\"57000\"] .cartesianChart")
	WebElement incomeComparisonChart;
	
	@FindBy(css="div[tab-order=\"58000\"] .bodyCells")
	WebElement incomeComparisonPivotTable;
	
	@FindBy(css="div[title=\"ABO Group Income Analytics\"]")
	WebElement incomeAnalyticsTitle;
	
	@FindBy(css="div[tab-order=\"64000\"] .cartesianChart")
	WebElement incomeAnalyticsChart;
	
	@FindBy(css="div[tab-order=\"65000\"] .bodyCells")
	WebElement incomeAnalyticsPivotTable;
	
	//Initializing Page Objects
	public IncomePage() {
		PageFactory.initElements(driver, this);
	}
			
	//Actions
	public void scrollToElement(String title) {
		if (title == "Total Bonus") {
			// Actions class with moveToElement()
		    Actions a = new Actions(driver);
		    a.moveToElement(totalBonusChart);
		    a.perform();
		}else if (title == "Income Breakdown") {
			// Actions class with moveToElement()
		    Actions a = new Actions(driver);
		    a.moveToElement(incomeBreakdownPivotTable);
		    a.perform();
		}else if (title == "Income Comparison") {
			// Actions class with moveToElement()
		    Actions a = new Actions(driver);
		    a.moveToElement(incomeComparisonChart);
		    a.perform();
		}else if (title == "Income Analytics") {
			// Actions class with moveToElement()
		    Actions a = new Actions(driver);
		    a.moveToElement(incomeAnalyticsChart);
		    a.perform();
		}
	}
	public String getPageheader() {
		return pageHeader.getText();
	}
	
	public String getIncomeAmtTitle() {
		return incomeAmtTitle.getText();
	}
	
	public Boolean incomeAmtChartDisplay() {
		return incomeAmtChart.isDisplayed();
	}
	
	public Boolean incomeAmtPivotTableDisplay() {
		return incomeAmtPivotTable.isDisplayed();
	}
	
	public String getTotalBonusTitle() {
		return totalBonusTitle.getText();
	}
	
	public Boolean totalBonusChartDisplay() {
		return totalBonusChart.isDisplayed();
	}
	
	public Boolean totalBonusPivotTableDisplay() {
		return totalBonusPivotTable.isDisplayed();
	}
	
	public String getIncomeBreakdownTitle() {
		return incomeBreakdownTitle.getText();
	}
	
	public Boolean incomeBreakdownPivotTableDisplay() {
		return incomeBreakdownPivotTable.isDisplayed();
	}
	
	public String getImcomeComparisonTitle() {
		return incomeComparisonTitle.getText();
	}
	
	public Boolean incomeComparisonChartDisplay() {
		return incomeComparisonChart.isDisplayed();
	}
	
	public Boolean incomeComparisonPivotTableDisplay() {
		return incomeComparisonPivotTable.isDisplayed();
	}
	
	public String getImcomeAnalyticsTitle() {
		return incomeAnalyticsTitle.getText();
	}
	
	public Boolean incomeAnalyticsChartDisplay() {
		return incomeAnalyticsChart.isDisplayed();
	}
	
	public Boolean incomeAnalyticsPivotTableDisplay() {
		return incomeAnalyticsPivotTable.isDisplayed();
	}
}
