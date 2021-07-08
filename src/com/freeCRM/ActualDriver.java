package com.freeCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ActualDriver {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		ListenerHelper listen=new ListenerHelper();
		EventFiringWebDriver browser=new EventFiringWebDriver(driver);
		browser.register(listen);
		browser.get("https://www.google.com");
		browser.findElement(By.name("q")).sendKeys("Sendkeys with listener");
		browser.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']")).click();
	}
}
