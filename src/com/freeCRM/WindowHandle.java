package com.freeCRM;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println(count);
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				System.out.println(driver.getTitle());
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
		driver.close();

	}
}
