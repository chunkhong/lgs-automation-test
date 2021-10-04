package lgs.analytics.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lgs.analytics.base.TestBase;

public class FiltersPane extends TestBase{
		//Page Element
		@FindBy(css="filter-pane-modern #exploreFilterContainer filter .filterCardTitleSection button:nth-of-type(1)")
		WebElement accSnapshotAff_Id_Filter;
		
		@FindBy(css="exploration outspace-pane filter-pane-modern #exploreFilterContainer filter .cardHeader button:nth-of-type(1)")
		WebElement accAccountAff_Id_Imc_No_Filter;
		
		@FindBy(css="filter-pane-modern #exploreFilterContainer filter .filterContent .filterTypeSelection mat-select")
		WebElement filterType;
		
		@FindBy(css="body .cdk-overlay-container mat-option:nth-of-type(1)")
		WebElement filterTypeOption1;
	
		@FindBy(css="filter-pane-modern #exploreFilterContainer filter .filterContent advanced-filter mat-select:nth-of-type(1)")
		WebElement showItemValue;
		
		@FindBy(css="body .cdk-overlay-container mat-option:nth-of-type(5)")
		WebElement showItemValueOption5;
		
		@FindBy(css="filter-pane-modern #exploreFilterContainer filter:nth-of-type(2) .filterContent .filterTypeSelection mat-select")
		WebElement imcFilterType;
		
		@FindBy(xpath="//*[@id=\"exploreFilterContainer\"]/div[2]/div/filter[1]/div/div[1]/div[1]/button[1]")
		WebElement hatvAff_Id_Filter;
		
		@FindBy(xpath="//*[@id=\"exploreFilterContainer\"]/div[2]/div/filter[2]/div/div[1]/div[1]/button[1]")
		WebElement hatvIMC_Id_Filter;
		
		@FindBy(css="filter-pane-modern #exploreFilterContainer filter .filterContent advanced-filter #inputTheme input")
		WebElement aboNoInputBox;
		
		@FindBy(css="filter-pane-modern #exploreFilterContainer filter .filterContent advanced-filter .applyFilter")
		WebElement applyFilterBtn;
		
		@FindBy(css="filter-pane-modern #exploreFilterContainer filter:nth-child(2) .filterContent advanced-filter #inputTheme input")
		WebElement imcNoInputBox;
		
		@FindBy(css="filter-pane-modern #exploreFilterContainer filter:nth-child(2) .filterContent advanced-filter .applyFilter")
		WebElement imcNoApplyFilterBtn;
		
		//Initializing Page Objects
		public FiltersPane() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public void clickHatv_Aff_Id_Filter(){
			hatvAff_Id_Filter.click();
		}
		
		public void clickHatv_IMC_NO_Filter(){
			hatvIMC_Id_Filter.click();
		}
		
		public void clickAccSnapshot_Aff_Id_Filter(){
			accSnapshotAff_Id_Filter.click();
		}
		
		public void clickAccCount_Aff_Id_Filter(){
			accAccountAff_Id_Imc_No_Filter.click();
		}
		
		public void clickFilterType(){
			filterType.click();
		}
		
		public void selectFilterTypeOption1() {
			filterTypeOption1.click();
		}
		
		public void clickShowItemValue(){
			showItemValue.click();
		}
		
		public void selectShowItemValueOption5() {
			showItemValueOption5.click();
		}
		
		public void enterABOno(String aboNo) {
			aboNoInputBox.clear();
			aboNoInputBox.sendKeys(aboNo);
		}
		
		public void clickApplyFilterBtn() {
			applyFilterBtn.click();
		}
		
		public void clickIMCFilterType(){
			imcFilterType.click();
		}
		
		public void enterIMCno(String aboNo) {
			imcNoInputBox.clear();
			imcNoInputBox.sendKeys(aboNo);
		}
		
		public void clickImcNoApplyFilterBtn() {
			imcNoApplyFilterBtn.click();
		}
		
		//combine actions
		public void fillInAffNo(String affId) {
			clickHatv_Aff_Id_Filter();
			clickFilterType();
			selectFilterTypeOption1();
			clickShowItemValue();
			selectShowItemValueOption5();
			enterABOno(affId);
			clickApplyFilterBtn();
		}
		
		public void fillInABONo(String aboNo) {
			clickHatv_IMC_NO_Filter();
			clickIMCFilterType();
			selectFilterTypeOption1();
			clickShowItemValue();
			selectShowItemValueOption5();
			enterIMCno(aboNo);
			clickImcNoApplyFilterBtn();
		}
		
		public void fillInAffNoImcNo(String affId) {
			clickAccCount_Aff_Id_Filter();
			clickFilterType();
			selectFilterTypeOption1();
			clickShowItemValue();
			selectShowItemValueOption5();
			enterABOno(affId);
			clickApplyFilterBtn();
		}
}
