package com.freeCRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreatingNewCustomer {
	WebDriver driver;

	@BeforeMethod
	public void openApp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		Reporter.log("opening browser");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Reporter.log("navigating to url");
		driver.get("https://classic.crmpro.com/index.html");
	}

	@DataProvider(name = "getContactsData")
	public Object[][] getContactsTestData() {
		Object contactsData[][] = TestUtil.getTestData("contacts");
		return contactsData;
	}

	@Test(dataProvider = "getContactsData")
	public void createContactsTest(String firstname, String lastname) throws Exception {
		driver.findElement(By.name("username")).sendKeys("gyanesh4u");
		driver.findElement(By.name("password")).sendKeys("windowvista");
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
		Reporter.log("logged in as user");
		driver.switchTo().frame("mainpanel");
		WebElement contacts = driver.findElement(By.xpath("//a[.='Contacts']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(contacts).perform();
		driver.findElement(By.xpath("//a[.='New Contact']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("first_name")).sendKeys(firstname);
		driver.findElement(By.id("surname")).sendKeys(lastname);
		createContactsTest(firstname, lastname);
		driver.findElement(By.xpath("//*[text()='Contact Information']/following::tr[1]//input[2]")).click();
		Thread.sleep(8000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
