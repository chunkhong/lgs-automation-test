package lgs.analytics.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lgs.analytics.base.TestBase;

public class AccountSnapshotPage extends TestBase{
		
		//Page Element
		@FindBy(css="div[tab-order=\"23000\"] .textbox .textRun")
		WebElement pageHeader;
		
		@FindBy(css="div[title=\"ABO Counts\"]")
		WebElement aboCountTitle;
		
		@FindBy(css="div[title=\"Group Size\"]")
		WebElement groupSizeTitle;
		
		@FindBy(css="div[tab-order=\"27000\"] .cardItemContainer .caption")
		WebElement groupSizeAmount;
		
		@FindBy(css="div[tab-order=\"29000\"] .indicatorText")
		WebElement groupSizePerct;
		
		@FindBy(css="div[title=\"Sponsoring\"]")
		WebElement sponsoringTitle;
		
		@FindBy(css="div[tab-order=\"5000\"] .cardItemContainer .caption")
		WebElement sponsoringAmount;
		
		@FindBy(css="div[tab-order=\"6000\"] .indicatorText")
		WebElement sponsoringPerct;
		
		@FindBy(css="div[title=\"Contributing ABO Percentage\"]")
		WebElement contrABOPerctTitle;
		
		@FindBy(css="div[tab-order=\"34000\"] .cardItemContainer .caption")
		WebElement contrABOPerctValue;
		
		@FindBy(css="div[tab-order=\"36000\"] .indicatorText")
		WebElement contrABOPerctPerct;
		
		@FindBy(css="div[title=\"90 Day Activation\"]")
		WebElement _90DaysActivationTitle;
		
		@FindBy(css="div[tab-order=\"41000\"] .cardItemContainer .caption")
		WebElement _90DaysActivationValue;
		
		@FindBy(css="div[tab-order=\"43000\"] .indicatorText")
		WebElement _90DaysActivationPerct;
		
		@FindBy(css="div[title=\"Platinum and Above Count\"]")
		WebElement platinumAndAboveTitle;
		
		@FindBy(css="div[tab-order=\"13000\"] .cardItemContainer .caption")
		WebElement platinumAndAboveValue;
		
		@FindBy(css="div[tab-order=\"15000\"] .indicatorText")
		WebElement platinumAndAbovePerct;
		
		@FindBy(css="div[title=\"Productivity\"]")
		WebElement productivityTitle;
		
		@FindBy(css="div[title=\"Revenue\"]")
		WebElement revenueTitle;
		
		@FindBy(css="div[tab-order=\"53000\"] .cardItemContainer .caption")
		WebElement revenueAmount;
		
		@FindBy(css="div[tab-order=\"55000\"] .indicatorText")
		WebElement revenuePerct;
		
		@FindBy(css="div[title=\"Group Sales PV\"]")
		WebElement groupSalesPVTitle;
		
		@FindBy(css="div[tab-order=\"56000\"] .cardItemContainer .caption")
		WebElement groupSalesPVAmount;
		
		@FindBy(css="div[tab-order=\"58000\"] .indicatorText")
		WebElement groupSalesPVPerct;
		
		@FindBy(css="div[title=\"Group Sales PV per Contributing ABO\"]")
		WebElement groupSalesPVperABOTitle;
		
		@FindBy(css="div[tab-order=\"63000\"] .cardItemContainer .caption")
		WebElement groupSalesPVperABOAmount;
		
		@FindBy(css="div[tab-order=\"65000\"] .indicatorText")
		WebElement groupSalesPVperABOPerct;
		
		@FindBy(css="div[title=\"Renewal Rates\"]")
		WebElement renewalRatesTitle;
		
		@FindBy(css="div[title=\"1st Year Renewal Rates\"]")
		WebElement firstYrRenewalRatesTitle;
		
		@FindBy(css="div[tab-order=\"77000\"] .cardItemContainer .caption")
		WebElement firstYrRenewalRatesAmount;
		
		@FindBy(css="div[tab-order=\"83000\"] .indicatorText")
		WebElement firstYrRenewalRatesPerct;
		
		@FindBy(css="div[title=\"2nd Year Renewal Rates\"]")
		WebElement secondYrRenewalRatesTitle;
		
		@FindBy(css="div[tab-order=\"79000\"] .cardItemContainer .caption")
		WebElement secondYrRenewalRatesAmount;
		
		@FindBy(css="div[tab-order=\"84000\"] .indicatorText")
		WebElement secondYrRenewalRatesPerct;
		
		@FindBy(css="div[title=\"Total Renewal Rates\"]")
		WebElement totalRenewalRatesTitle;
		
		@FindBy(css="div[tab-order=\"81000\"] .cardItemContainer .caption")
		WebElement totalRenewalRatesAmount;
		
		@FindBy(css="div[tab-order=\"85000\"] .indicatorText")
		WebElement totalRenewalRatesPerct;
		
		//Initializing Page Objects
		public void scrollToTitle(String title) {
			if (title == "Productivity") {
				// Actions class with moveToElement()
			    Actions a = new Actions(driver);
			    a.moveToElement(productivityTitle);
			    a.perform();
			}else if (title == "Renewal Rates") {
				// Actions class with moveToElement()
			    Actions a = new Actions(driver);
			    a.moveToElement(renewalRatesTitle);
			    a.perform();
			}
		}
		
		public AccountSnapshotPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public String getPageHeader(){
			return pageHeader.getText();
		}
		
		public String getABOCountTitle(){
			return aboCountTitle.getText();
		}
		
		public String getGroupSizeTitle(){
			return groupSizeTitle.getText();
		}
		
		public String getGroupSizeAmount(){
			return groupSizeAmount.getText();
		}
		
		public String getGroupSizePerct(){
			return groupSizePerct.getText();
		}
		
		public String getSponsoringTitle(){
			return sponsoringTitle.getText();
		}
		
		public String getSponsoringAmount(){
			return sponsoringAmount.getText();
		}
		
		public String getSponsoringPerct(){
			return sponsoringPerct.getText();
		}
		
		public String getContABOPerctTitle(){
			return contrABOPerctTitle.getText();
		}
		
		public String getContABOPerctValue(){
			return contrABOPerctValue.getText();
		}
		
		public String getContABOPerctPerct(){
			return contrABOPerctPerct.getText();
		}
		
		public String get90DaysActivTitle(){
			return _90DaysActivationTitle.getText();
		}
		
		public String get90DaysActiveValue(){
			return _90DaysActivationValue.getText();
		}
		
		public String get90DaysActivePerct(){
			return _90DaysActivationPerct.getText();
		}
		
		public String getPlatinumAndAboveTitle(){
			return platinumAndAboveTitle.getText();
		}
		
		public String getPlatinumAndAboveValue(){
			return platinumAndAboveValue.getText();
		}
		
		public String getPlatinumAndAbovePerct(){
			return platinumAndAbovePerct.getText();
		}
		
		public String getProductivityTitle(){
			return productivityTitle.getText();
		}
		
		public String getRevenueTitle(){
			return revenueTitle.getText();
		}
		
		public String getRevenueAmount(){
			return revenueAmount.getText();
		}
		
		public String getRevenuePerct(){
			return revenuePerct.getText();
		}
		
		public String getGroupSalesPVTitle(){
			return groupSalesPVTitle.getText();
		}
		
		public String getGroupSalesPVAmount(){
			return groupSalesPVAmount.getText();
		}
		
		public String getGroupSalesPVPerct(){
			return groupSalesPVPerct.getText();
		}
		
		public String getGroupSalesPVaboTitle(){
			return groupSalesPVperABOTitle.getText();
		}
		
		public String getGroupSalesPVaboAmount(){
			return groupSalesPVperABOAmount.getText();
		}
		
		public String getGroupSalesPVaboPerct(){
			return groupSalesPVperABOPerct.getText();
		}
		
		public String getRenewalRatesTitle(){
			return renewalRatesTitle.getText();
		}
		
		public String getFirstYrRenewalRatesTitle(){
			return firstYrRenewalRatesTitle.getText();
		}
		
		public String getFirstYrRenewalRatesAmount(){
			return firstYrRenewalRatesAmount.getText();
		}
		
		public String getFirstYrRenewalRatesPerct(){
			return firstYrRenewalRatesPerct.getText();
		}
		
		public String getSecondYrRenewalRatesTitle(){
			return secondYrRenewalRatesTitle.getText();
		}
		
		public String getSecondYrRenewalRatesAmount(){
			return secondYrRenewalRatesAmount.getText();
		}
		
		public String getSecondYrRenewalRatesPerct(){
			return secondYrRenewalRatesPerct.getText();
		}
		
		public String getTotalYrRenewalRatesTitle(){
			return totalRenewalRatesTitle.getText();
		}
		
		public String getTotalYrRenewalRatesAmount(){
			return totalRenewalRatesAmount.getText();
		}
		
		public String getTotalYrRenewalRatesPerct(){
			return totalRenewalRatesPerct.getText();
		}
}
