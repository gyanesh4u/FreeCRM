package com.freeCRM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zoopla {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.zoopla.co.uk/");
		driver.switchTo().activeElement().sendKeys("london");
		driver.findElement(By.xpath("//button[@id='search-submit']")).sendKeys(Keys.ENTER);
		
		int count = 1;
		List<WebElement> text = driver.findElements(By.xpath("/li[" + count + "]/div[1]/div[2]/a[1]"));

		System.out.println(count);
		for (int i = 0; i < count; i++) {
			WebElement allText = text.get(i);
			System.out.println(allText.getText());

		}

	}
}
