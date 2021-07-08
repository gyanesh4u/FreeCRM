package com.freeCRM;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenshotFailed {
WebDriver driver;
	@BeforeMethod
	public void openApp()
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		Reporter.log("opening browser");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("navigating to url");
		driver.get("https://classic.crmpro.com/index.html");
	}
	
	@Test(priority=1)
	public void loginTest()
	{
		driver.findElement(By.name("username")).sendKeys("gyanesh5u");
		driver.findElement(By.name("password")).sendKeys("windowvista");
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
		Reporter.log("logged in as user");
		String homepageTitle = driver.getTitle();
		Assert.assertEquals(homepageTitle,"CRMPRO");
		
	}

	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			takeScreenshot(driver, result.getName());
		}
		driver.quit();
	}
	

public static void takeScreenshot(WebDriver driver, String testMethodName){
	try {
		Date d = new Date();
		String date = d.toString().replaceAll(":", "_");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("E:\\Advanced Automation\\FreeCRM\\screenshot"+testMethodName+"_"+date+".png");
		FileUtils.copyFile(srcFile, destFile);
	} catch (Exception e) {
	}
}
}