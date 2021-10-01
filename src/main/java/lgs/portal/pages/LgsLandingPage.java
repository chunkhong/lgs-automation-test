package lgs.portal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lgs.portal.base.LgsTestBase;

public class LgsLandingPage extends LgsTestBase{
	//Page Element
	@FindBy(xpath="/html/body/app-root/div/app-login/div/div/div/div[2]/div/div/button")
	WebElement loginButton;
		
		
	//Initializing Page Objects
	public LgsLandingPage() {
		PageFactory.initElements(driver, this);
	}
		
	//Actions
	public void clickLoginButton() throws InterruptedException {
		loginButton.click();
		Thread.sleep(2000);
	}
}
