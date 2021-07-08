package com.freeCRM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]")).click();

		List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='DayPicker-Body']//div[1]"));

		for (WebElement ele : allDates) {

			String date = ele.getText();

			if (date.equalsIgnoreCase("30")) {
				ele.click();
				break;
			}

		}
	}
}