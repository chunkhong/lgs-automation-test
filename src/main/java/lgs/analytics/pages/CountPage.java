package lgs.analytics.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lgs.analytics.base.TestBase;

public class CountPage extends TestBase{
	//Page factory
	@FindBy(css="div[title=\"ABO Counts\"]")
	WebElement pageHeader;
	
	@FindBy(css="div[title=\"Group Size\"]")
	WebElement groupSizeTitle;
	
	@FindBy(css="div[tab-order=\"70000\"] .cartesianChart")
	WebElement groupSizeChart;
	
	@FindBy(css="div[tab-order=\"42000\"] .bodyCells")
	WebElement groupSizePivotTable;
	
	//Initializing Page Objects
	public CountPage() {
		PageFactory.initElements(driver, this);
	}
		
	//Actions
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
}
