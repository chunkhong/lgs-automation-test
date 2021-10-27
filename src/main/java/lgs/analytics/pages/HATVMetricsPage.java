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
	
	@FindBy(css="div[tab-order=\"76000\"] i")
	WebElement perfYrFilter;
	
	@FindBy(css="div[aria-label=\"PF 2021\"]")
	WebElement Yr2021Option;
	
	@FindBy(css="div[title=\"Qualified Months\"]")
	WebElement qualifiedMonthsTitle;
	
	@FindBy(css="div[tab-order=\"108000\"] .bodyCells div div div")
	WebElement qualifiedMonthsValue;
	
	@FindBy(css="div[title=\"Volume Fluctuation\"]")
	WebElement volumeFlucTitle;
	
	@FindBy(css="div[tab-order=\"81000\"] .cartesianChart")
	WebElement volumeFlucChart;
	
	@FindBy(css="div[tab-order=\"81000\"] .labelGraphicsContext text:nth-of-type(12)")
	WebElement volumeFlucMonthlyValue;
	
	
	//Initializing Page Objects
	public HATVMetricsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String getPageheader() {
		return pageHeader.getText();
	}
	
	public void clickPerfYrFilter() {
		perfYrFilter.click();
	}
	
	public void clickYr2021Option() {
		Yr2021Option.click();
	}
	
	public void scrollToElement(String title) {
		if (title == "Volume Fluc") {
			// Actions class with moveToElement()
		    Actions a = new Actions(driver);
		    a.moveToElement(volumeFlucChart);
		    a.perform();
		}
	}
	
	public Boolean qualifiedMonthsTitleDisplay() {
		return qualifiedMonthsTitle.isDisplayed();
	}
	
	public String qualifiedMonthsValue() {
		return qualifiedMonthsValue.getText();
	}
	
	public Boolean volumeFlucTitleDisplay() {
		return volumeFlucTitle.isDisplayed();
	}
	
	public Boolean volumeFlucChartDisplay() {
		return volumeFlucChart.isDisplayed();
	}
	
	public String volumeFlucMonthlyValue() {
		return volumeFlucMonthlyValue.getText();
	}
}
