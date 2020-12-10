package com.visionIt.orangehrm.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.visionIt.orangehrm.Utility.Helper;

public class AddUserPage {

	@FindBy(id="btnAdd")
	@CacheLookup
	WebElement btnAdd;
	
	@FindBy(id="systemUser_userType")
	@CacheLookup
	WebElement systemUserDD;
			
	@FindBy(id="systemUser_employeeName_empName")
	@CacheLookup
	WebElement employeeName;
	
	@FindBy(id="systemUser_userName")
	@CacheLookup
	WebElement userName;
	
	@FindBy(id="systemUser_status")
	@CacheLookup
	WebElement statusDD;
	
	@FindBy(id="systemUser_password")
	@CacheLookup
	WebElement userPassword;
	
	@FindBy(id="systemUser_confirmPassword")
	@CacheLookup
	WebElement  confirmPassword;
	
	@FindBy(id="btnSave")
	@CacheLookup
	WebElement btnSave;

	WebDriver driver;
	public AddUserPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void AddNewUser(String selectRole,String EmployeeName,String username,String status,
			String password,String confirmPassword)
	{
		try 
		{
			btnAdd.click();
			
			Helper.dropDownValue(systemUserDD,selectRole);
			employeeName.sendKeys(EmployeeName);
			userName.sendKeys(username);
			Helper.dropDownValue(statusDD, status);		
			userPassword.sendKeys(password);
			this.confirmPassword.sendKeys(confirmPassword);
			btnSave.click();
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
	
}
