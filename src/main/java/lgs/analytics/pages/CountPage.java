package lgs.analytics.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		}
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
}
