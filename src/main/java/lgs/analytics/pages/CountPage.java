package lgs.analytics.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lgs.analytics.base.TestBase;

public class CountPage extends TestBase{
	//Page factory
	@FindBy(css="div[tab-order=\"41000\"] .slicer-dropdown-menu")
	WebElement prfYrFilter;
	
	@FindBy(css="span[title=\"PF 2020\"]")
	WebElement prfYr2020;
	
	@FindBy(css="div[tab-order=\"58000\"] .slicer-dropdown-menu")
	WebElement losFilter;
	
	@FindBy(css="span[title=\"Platinum LOS Group\"]")
	WebElement platinumGroup;
	
	@FindBy(css="div[title=\"ABO Counts\"]")
	WebElement pageHeader;
	
	@FindBy(css="div[title=\"Group Size\"]")
	WebElement groupSizeTitle;
	
	@FindBy(css="div[tab-order=\"70000\"] .cartesianChart")
	WebElement groupSizeChart;
	
	@FindBy(css="div[tab-order=\"42000\"] .bodyCells")
	WebElement groupSizePivotTable;
	
	@FindBy(css="div[title=\"Sponsoring\"]")
	WebElement sponsoringTitle;
	
	@FindBy(css="div[tab-order=\"78000\"] .cartesianChart")
	WebElement spronsoringChart;
	
	@FindBy(css="div[tab-order=\"43000\"] .bodyCells")
	WebElement sponsoringPivotTable;
	
	@FindBy(css="div[title=\"Contributors\"]")
	WebElement contributorsTitle;
	
	@FindBy(css="div[tab-order=\"94000\"] .cartesianChart")
	WebElement contributorsChart;
	
	@FindBy(css="div[tab-order=\"44000\"] .bodyCells")
	WebElement contributorsPivotTable;
	
	@FindBy(css="div[title=\"Contributing ABO Percentage\"]")
	WebElement contributingAboTitle;
	
	@FindBy(css="div[tab-order=\"95000\"] .cartesianChart")
	WebElement contributingAboChart;
	
	@FindBy(css="div[tab-order=\"45000\"] .bodyCells")
	WebElement contributingAboPivotTable;
	
	@FindBy(css="div[title=\"90 Day Activation\"]")
	WebElement _90DaysTitle;
	
	@FindBy(css="div[tab-order=\"96000\"] .cartesianChart")
	WebElement _90DaysChart;
	
	@FindBy(css="div[tab-order=\"46000\"] .bodyCells")
	WebElement _90DaysPivotTable;
	
	@FindBy(css="div[title=\"Customer / Member Count\"]")
	WebElement custMemberTitle;
	
	@FindBy(css="div[tab-order=\"8000\"] .cartesianChart")
	WebElement custMemberChart;
	
	@FindBy(css="div[tab-order=\"9000\"] .bodyCells")
	WebElement custMemberPivotTable;
	
	@FindBy(css="div[title=\"Average Number of Customers / Members per Contributor\"]")
	WebElement avgNumberTitle;
	
	@FindBy(css="div[tab-order=\"17000\"] .cartesianChart")
	WebElement avgNumberChart;
	
	@FindBy(css="div[tab-order=\"18000\"] .bodyCells")
	WebElement avgNumberPivotTable;
	
	//Initializing Page Objects
	public CountPage() {
		PageFactory.initElements(driver, this);
	}
		
	//Actions
	public void scrollToElement(String title) {
		if (title == "Sponsoring") {
			// Actions class with moveToElement()
		    Actions a = new Actions(driver);
		    a.moveToElement(spronsoringChart);
		    a.perform();
		}else if (title == "Contributors") {
			// Actions class with moveToElement()
		    Actions a = new Actions(driver);
		    a.moveToElement(contributorsChart);
		    a.perform();
		}else if (title == "Contributing ABO") {
			// Actions class with moveToElement()
		    Actions a = new Actions(driver);
		    a.moveToElement(contributingAboChart);
		    a.perform();
		}else if (title == "90 Day Activation") {
			// Actions class with moveToElement()
		    Actions a = new Actions(driver);
		    a.moveToElement(_90DaysChart);
		    a.perform();
		}else if (title == "Cust / Member") {
			// Actions class with moveToElement()
		    Actions a = new Actions(driver);
		    a.moveToElement(custMemberChart);
		    a.perform();
		}else if (title == "Average Number") {
			// Actions class with moveToElement()
		    Actions a = new Actions(driver);
		    a.moveToElement(avgNumberChart);
		    a.perform();
		}
	}
	
	public void clickPrfYrFilter() {
		prfYrFilter.click();
	}
	
	public void select2020PrfYr() {
		prfYr2020.click();
	}
	
	public void clicLosFilter() {
		losFilter.click();
	}
	
	public void selectPlatinumGroup() {
		platinumGroup.click();
	}
	
	public String getPageheader() {
		return pageHeader.getText();
	}
	
	public String getGroupSizeTitle() {
		return groupSizeTitle.getText();
	}
	
	public Boolean groupSizeChartDisplay() {
		return groupSizeChart.isDisplayed();
	}
	
	public Boolean groupSizePivotTableDisplay() {
		return groupSizePivotTable.isDisplayed();
	}
	
	public String getsponsoringTitle() {
		return sponsoringTitle.getText();
	}
	
	public Boolean sponsoringChartDisplay() {
		return spronsoringChart.isDisplayed();
	}
	
	public Boolean sponsoringPivotTableDisplay() {
		return sponsoringPivotTable.isDisplayed();
	}
	
	public String getContributorsTitle() {
		return contributorsTitle.getText();
	}
	
	public Boolean contributorsChartDisplay() {
		return contributorsChart.isDisplayed();
	}
	
	public Boolean contributorsPivotTableDisplay() {
		return contributorsPivotTable.isDisplayed();
	}
	
	public String getContributingAboTitle() {
		return contributingAboTitle.getText();
	}
	
	public Boolean contributingAboChartDisplay() {
		return contributingAboChart.isDisplayed();
	}
	
	public Boolean contributingAboPivotTableDisplay() {
		return contributingAboPivotTable.isDisplayed();
	}
	
	public String get90DaysTitle() {
		return _90DaysTitle.getText();
	}
	
	public Boolean _90DaysChartDisplay() {
		return _90DaysChart.isDisplayed();
	}
	
	public Boolean _90DaysPivotTableDisplay() {
		return _90DaysPivotTable.isDisplayed();
	}
	
	public String getcustMemberTitle() {
		return custMemberTitle.getText();
	}
	
	public Boolean custMemberChartDisplay() {
		return custMemberChart.isDisplayed();
	}
	
	public Boolean custMemberPivotTableDisplay() {
		return custMemberPivotTable.isDisplayed();
	}
	
	public String getAvgNumberTitle() {
		return avgNumberTitle.getText();
	}
	
	public Boolean avgNumberChartDisplay() {
		return avgNumberChart.isDisplayed();
	}
	
	public Boolean avgNumberPivotTableDisplay() {
		return avgNumberPivotTable.isDisplayed();
	}
}
