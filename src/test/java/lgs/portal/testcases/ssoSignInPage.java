package lgs.portal.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lgs.portal.base.LgsTestBase;

public class ssoSignInPage extends LgsTestBase{
	//Page Element
	@FindBy(id="okta-signin-username")
	WebElement nativeID;
	
	@FindBy(id="okta-signin-password")
	WebElement password;
			
	@FindBy(id="okta-signin-submit")
	WebElement submitButton;
			
	//Initializing Page Objects
	public ssoSignInPage() {
		PageFactory.initElements(driver, this);
	}
			
	//Actions
	public void enterNativeId(){
		nativeID.sendKeys(prop.getProperty("ssousername"));
	}
	
	public void enterPasword(){
		password.sendKeys(prop.getProperty("ssopassword"));
	}
	
	public void clickSubmit(){
		submitButton.click();
	}
}
