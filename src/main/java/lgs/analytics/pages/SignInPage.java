package lgs.analytics.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lgs.analytics.base.TestBase;

public class SignInPage extends TestBase {
    
    //Page factory
	@FindBy(name="loginfmt")
	WebElement email;
	
	@FindBy(id="idSIButton9")
	WebElement nextButton;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(id="idSIButton9")
	WebElement signInButton;
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void enterEmail() {
		email.sendKeys(prop.getProperty("ssousername"));
	}
}
