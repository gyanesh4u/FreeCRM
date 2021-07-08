package com.freeCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCrmLoginTest {
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
	@Test(priority=3)
	public void loginPageTitleTest()
	{
		String title = driver.getTitle();
		Reporter.log("got the login page title "+title,true);
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
	
	}

	@Test(priority=2)
	public void crmLogoTest()
	{
		boolean logo = driver.findElement(By.className("img-responsive")).isDisplayed();
		Reporter.log("got the crm logo");
		Assert.assertTrue(logo);
	}
	
	@Test(priority=1)
	public void loginTest()
	{
		driver.findElement(By.name("username")).sendKeys("gyanesh4u");
		driver.findElement(By.name("password")).sendKeys("windowvista");
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
		Reporter.log("logged in as user");
		String homepageTitle = driver.getTitle();
		Assert.assertEquals(homepageTitle,"CRMPRO");
		
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
}
