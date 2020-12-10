package com.visionIt.orangehrm.testBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.visionIt.orangehrm.Utility.ConfigDataProvider;
import com.visionIt.orangehrm.Utility.XLSXDataProvider;

public class TestBase {
 
	 public WebDriver driver=null;
	public ConfigDataProvider configData;
	public XLSXDataProvider xlsData;
	 @BeforeSuite
	 public void setupSuite() throws IOException
	 {
		 configData = new ConfigDataProvider();
		xlsData= new XLSXDataProvider();
	 }
	 
	 
	 @Parameters("Browser")
	@BeforeMethod
	public void setUp(@Optional("Chrome")String browsername)
	{
		 
		 if(browsername.equals("Chrome")) {
			 System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				driver=new ChromeDriver();
		 }
		 else if(browsername.equals("Firefox")) {
			 System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
				driver=new FirefoxDriver();
		 }
		 
		
		//driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		driver.get(configData.getUrl());
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
}
