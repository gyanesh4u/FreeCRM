package com.freeCRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLogout {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		driver.findElement(By.name("username")).sendKeys("gyanesh4u");
		driver.findElement(By.name("password")).sendKeys("windowvista");
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[@href='https://classic.crmpro.com/index.cfm?logout=1']")).click();
	}
}
