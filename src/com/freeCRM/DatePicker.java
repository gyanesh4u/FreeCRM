package com.freeCRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		driver.findElement(By.name("username")).sendKeys("gyanesh4u");
		driver.findElement(By.name("password")).sendKeys("windowvista");
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
		driver.switchTo().frame("mainpanel");
		String date = "30-April-2019";
		String dateArr[] = date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];

		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);

		Select select1 = new Select(driver.findElement(By.name("slctYear")));
		select1.selectByVisibleText(year);

		String beforeXpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath = "]/td[";

		final int totalWeekDays = 7;
boolean flag=false;
		for (int rowNum = 2; rowNum <= 7; rowNum++) {
			for (int colNum = 1; colNum <= totalWeekDays; colNum++) {
				String dayVal = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
				System.out.println(dayVal);
				if(dayVal.equals(day))
				{
					driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
					flag=true;
					break;
				}
			}
			if(flag){
				break;
			}
		}
	}

}
