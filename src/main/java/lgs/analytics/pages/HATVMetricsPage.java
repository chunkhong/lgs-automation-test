package lgs.analytics.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lgs.analytics.base.TestBase;

public class HATVMetricsPage extends TestBase{
	
	//Page factory
	@FindBy(css="visual-container-repeat visual-container:nth-of-type(4) visual-modern .textRun")
	WebElement pageHeader;
	
	@FindBy(css="div[title=\"Volume Fluctuation\"]")
	WebElement volumeFlucTitle;
	
	@FindBy(css="div[tab-order=\"81000\"] .cartesianChart")
	WebElement volumeFlucChart;
	
	//Initializing Page Objects
	public HATVMetricsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String getPageheader() {
		return pageHeader.getText();
	}
	
	public void scrollToTitle(String title) {
		if (title == "Volume Fluc") {
			// Actions class with moveToElement()
		    Actions a = new Actions(driver);
		    a.moveToElement(volumeFlucTitle);
		    a.perform();
		}
	}
	
	public Boolean volumeFlucTitleDisplay() {
		return volumeFlucTitle.isDisplayed();
	}
	
	public Boolean volumeFlucChartDisplay() {
		return volumeFlucChart.isDisplayed();
	}
	
}
