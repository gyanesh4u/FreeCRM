package com.freeCRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
public static void main(String[] args) {
	
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.get("https://www.google.co.in");
	System.out.println(driver.getTitle());
	driver.quit();
}
}
