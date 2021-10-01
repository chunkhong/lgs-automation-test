package lgs.portal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lgs.portal.base.LgsTestBase;

public class HATVCasesPage extends LgsTestBase{
	//Page Element
	@FindBy(css="app-hatv-my-case-list .title")
	WebElement pageHeader;
	
	@FindBy(css="body #search")
	WebElement SearchBox;
				
	@FindBy(css=".search-box svg[data-icon=\"search\"]")
	WebElement SearchButton;
	
	@FindBy(css="app-main app-header .search-result")
	WebElement SearchResult;
	
	@FindBy(css="app-hatv-my-case-list .tab-container button:nth-of-type(1)")
	WebElement MyCasesTab;
	
	@FindBy(css="app-hatv-my-case-list .tab-container button:nth-of-type(2)")
	WebElement AllCasesTab;
	
	@FindBy(css="app-main app-hatv-my-case-list section .tab-container .unassigned-tab")
	WebElement UnAssignedCasesTab;
	
	@FindBy(css="app-main app-hatv-all-case-list section .hard-kpi-denial-tab")
	WebElement HardKPIDenialsTab;
				
	//Initializing Page Objects
	public HATVCasesPage() {
		PageFactory.initElements(driver, this);
	}
				
	//Actions
	public String getPageHeader(){
		return pageHeader.getText();
	}
	
	public void clickAllCasesTab(){
		AllCasesTab.click();
	}
	
	public void clickUnAssignedCasesTab(){
		UnAssignedCasesTab.click();
	}
	
	public void clickHardKPIDenialsTab(){
		HardKPIDenialsTab.click();
	}
	
	public void enterABONoToSearch(String aboNo){
		SearchBox.sendKeys(aboNo);
	}
	
	public void clickSearchButton(){
		SearchButton.click();
	}
	
	public void clickSearchResult(){
		SearchResult.click();
	}
}
