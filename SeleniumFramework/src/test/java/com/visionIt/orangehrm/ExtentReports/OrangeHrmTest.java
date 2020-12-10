package com.visionIt.orangehrm.ExtentReports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class OrangeHrmTest {

	public ExtentHtmlReporter htmlReporter;
	
	public ExtentReports report;
	
	public ExtentTest test;
	public static WebDriver driver;
	@BeforeTest
	public void setupExtent()
	{
		File fs=new File("./Reports/Orange_hrm.html");
		htmlReporter=new ExtentHtmlReporter(fs);
		
		htmlReporter.config().setDocumentTitle("Automation_Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("HostName","LocalHost");
		report.setSystemInfo("OS","Win10");
		report.setSystemInfo("TesterName","Mayuree");
		report.setSystemInfo("Browser","Chrome");	
	}
	
	@AfterTest
	public void endReport()
	{
		
		report.flush();
	}
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void VerifyTitleTest()
	{
			test=report.createTest("VerifyTitleTest");
	String actualtitle=driver.getTitle();
	String ExpectedTitle="OrangeHRM";
	Assert.assertEquals(actualtitle, ExpectedTitle);
	
	}
	@Test
	public void verifyLogo()
	{
		test=report.createTest("verifyLogo");
		boolean	status=driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")).isDisplayed();
		//Assert.assertTrue(status);
		//For failed testCase Demo
		Assert.assertFalse(status);
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,"TtestCase is failed"+result.getName());
			test.log(Status.FAIL,"Test case failed"+result.getThrowable());	
			
			String screenShot=OrangeHrmTest.captureScreenShot(driver,result.getName());
			test.log(Status.FAIL,"capture"+test.addScreenCaptureFromPath(screenShot));
			
			//String path=captureScreenShot(result.getName());
			//test.addScreenCaptureFromPath(path);
			//test.fail("TestCase Failed",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		
		
		  else if(result.getStatus()==ITestResult.SUCCESS) { test.log(Status.PASS,
		  "Test case executed"+result.getName()); }
		  
		  else if(result.getStatus()==ITestResult.SKIP) { test.log(Status.SKIP,
		  "Test case executed"+result.getName()); }
	
		
		driver.quit();
	}
	public static String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		String dateFormat = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		String path="./ScreenShot/"+screenShotName+dateFormat+".png";
		
		File destFile=new File(path);		
		
		FileHandler.copy(srcfile, destFile);	
		return path;
	}
	
	
	
	
}
