package lgs.analytics.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lgs.analytics.base.TestBase;

public class PBIAnalyticsHomePage extends TestBase{
	
	
	//Page Element
	@FindBy(css="pbi-card[aria-label=\"Sales Support@CMP\"]")
	WebElement prodImage;
	
	@FindBy(css="app-consumption-navigation-pane h4")
	WebElement pageHeader;
	
	@FindBy(css="span[title=\"Count\"]")
	WebElement countTab;
	
	@FindBy(css="span[title=\"HATV\"]")
	WebElement hatvTab;
	
	//Initializing Page Objects
	public PBIAnalyticsHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void clickprodImage() throws InterruptedException {
		prodImage.click();
	}
	
	public String getPageheader() {
		return pageHeader.getText();
	}
	
	public void clickCountTab(){
		countTab.click();
	}
	
	public HATVMetricsPage clickHATVTab() throws InterruptedException {
		hatvTab.click();
		return new HATVMetricsPage();
	}
}

