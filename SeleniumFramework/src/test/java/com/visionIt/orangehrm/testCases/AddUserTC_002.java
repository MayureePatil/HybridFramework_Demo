package com.visionIt.orangehrm.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.visionIt.orangehrm.pageObject.AddUserPage;
import com.visionIt.orangehrm.pageObject.HomePage;
import com.visionIt.orangehrm.pageObject.LoginPage;
import com.visionIt.orangehrm.testBase.TestBase;

public class AddUserTC_002 extends TestBase {

	@Test(dataProvider = "getExcelData")
	public void AddNewUser(String userRole,String empname,String userName,String status,
			String password,String confirmPassword)
	{
		LoginPage login=new LoginPage(driver);
		//login.loginOrangeHrm(uname, pass);
	HomePage homepage= login.loginOrangeHrm(xlsData.getStringcellData("login", 0, 0), xlsData.getStringcellData("login", 0, 1));
		AddUserPage adduser=homepage.navigateToAddUserPage(); 
		adduser.AddNewUser(userRole, empname, userName, status, password, confirmPassword);
	}
	
	@DataProvider
	public Object[][] getExcelData()
	{
		Object[][] data=xlsData.excelTestData("addUser");
		return data;
		
	}
	
}
