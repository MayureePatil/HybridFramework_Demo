package com.visionIt.orangehrm.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver;

	//WebElement repository at page level
	@FindBy(name="txtUsername")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement userpassword;
	
	@FindBy(id = "btnLogin")
	WebElement loginbtn;
	
	public LoginPage( WebDriver driver) {
	
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public HomePage loginOrangeHrm(String uname,String pass)
	{
		username.sendKeys(uname);
		userpassword.sendKeys(pass);
		loginbtn.click();
		
		
		return new HomePage(driver);
		
	}

	
	
}
