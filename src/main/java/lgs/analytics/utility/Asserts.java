package lgs.analytics.utility;

import lgs.analytics.base.TestBase;

public class Asserts extends TestBase{
	
	public Asserts() {
		super();
	}
	
	public Boolean TextContains(String actualText, String expectedText) {
		boolean status;
		status = false;
		
		if (actualText.contains(expectedText)){
			status = true;
		}
		return status;
	}
	
	public Boolean TextEqual(String actualText, String expectedText) {
		boolean status;
		status = false;
		
		if (actualText.equals(expectedText)){
			status = true;
		} 
		return status;
	}
	
	public Boolean AnyText(String actualText) {
		boolean status;
		status = false;
		
		if (actualText.length() > 0){
			status = true;
		} 
		return status;
	}
}
