package com.freeCRM;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle1 {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		Set<String> allWindows = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindows);
		driver.switchTo().window(tabs.get(3));
		driver.close();
		driver.switchTo().window(tabs.get(2));
		driver.close();
		driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(tabs.get(0));
		System.out.println(driver.getTitle());
		driver.close();
	}

}
