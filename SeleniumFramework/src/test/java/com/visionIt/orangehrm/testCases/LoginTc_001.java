package com.visionIt.orangehrm.testCases;

import org.testng.annotations.Test;

import com.visionIt.orangehrm.pageObject.LoginPage;
import com.visionIt.orangehrm.testBase.TestBase;

public class LoginTc_001 extends TestBase {

	@Test
	public void loginOrangeHrm_Test() {
		
	 LoginPage login=new LoginPage(driver);
	// login.loginOrangeHrm(configData.getUsername(),configData.getUserPassword());
	 
	 login.loginOrangeHrm(xlsData.getStringcellData("login", 0, 0), xlsData.getStringcellData("login", 0, 1));
	}
	
}
