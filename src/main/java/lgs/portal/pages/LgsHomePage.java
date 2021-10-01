package lgs.portal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lgs.portal.base.LgsTestBase;

public class LgsHomePage extends LgsTestBase{
	//Page Element
	@FindBy(linkText="HATV Cases")
	WebElement hatvCasesLink;
			
			
	//Initializing Page Objects
	public LgsHomePage() {
		PageFactory.initElements(driver, this);
	}
			
	//Actions
	public void clickHATVCasesLink() throws InterruptedException {
		hatvCasesLink.click();
		Thread.sleep(2000);
	}
}
