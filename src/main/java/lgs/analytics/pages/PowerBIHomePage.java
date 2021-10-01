package lgs.analytics.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lgs.analytics.base.TestBase;

public class PowerBIHomePage extends TestBase{
	
	//Page factory
	@FindBy(linkText="Sign in")
	WebElement SignInButton;
	
	@FindBy(name="loginfmt")
	WebElement email;
	
	@FindBy(id="idSIButton9")
	WebElement nextButton;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(id="idSIButton9")
	WebElement submitButton;
	
	//Initializing Page Objects
	public PowerBIHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatePBIHOmePageTitle() {
		return driver.getTitle();
	}
	
	public void clickSignInButton() throws InterruptedException {
		SignInButton.click();
		Thread.sleep(2000);
		//Switch to new window opened
	    for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	    }  
	}
	
	public void enterEmail() throws InterruptedException {
		email.sendKeys(prop.getProperty("ssousername"));
		Thread.sleep(2000);
	}
	
	public void clickNextButton() throws InterruptedException{
		nextButton.click();
		Thread.sleep(2000);
	}
	
	public void enterPassword(){
		password.sendKeys(prop.getProperty("ssopassword"));
	}
	
	public PBIAnalyticsHomePage clickSubmitButton() throws InterruptedException {
		submitButton.click();
		Thread.sleep(2000); 
		return new PBIAnalyticsHomePage();
	}
	
	public void loginPBI() throws InterruptedException {
		clickSignInButton();
		enterEmail();
		clickNextButton();
		enterPassword();
		clickSubmitButton();
	}
}
