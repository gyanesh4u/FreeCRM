package com.freeCRM;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PropertiesLogin {
	WebDriver driver;
	Properties prop;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		Reporter.log("opening browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("navigating to url");
		prop = new Properties();
		try {
			prop.load(new FileInputStream("./config.properties"));
		} catch (Exception e) {

		}
		String Url = prop.getProperty("url");
		driver.get(Url);
	}

	@Test
	public void loginTest() {
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
		Reporter.log("logged in as user");
		String homepageTitle = driver.getTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
