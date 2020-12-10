package com.visionIt.orangehrm.Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Helper {

	public static void dropDownValue(WebElement ele,String visibleText) {
		
		new Select(ele).selectByVisibleText(visibleText);
	
	}
	
public static void dropDownValue(WebElement ele,int index) {
		
		new Select(ele).selectByIndex(index);
	
	}
	
public static void dropDownValue(String visibleText,WebElement ele) {
	
	new Select(ele).selectByValue(visibleText);

}
	
	
}
