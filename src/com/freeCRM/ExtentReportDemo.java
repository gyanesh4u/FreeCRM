package com.freeCRM;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {
	@Test
	public void loginTest() throws IOException {
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/gyanesh.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("LoginTest");
		logger.log(Status.INFO,"Login to amazon");
		logger.log(Status.PASS, "Title is verified");
		extent.flush();
		ExtentTest logger1=extent.createTest("LogoffTest");
		logger1.log(Status.FAIL, "Title verified");
		logger1.fail("Failed",MediaEntityBuilder.createScreenCaptureFromPath("E:\\Advanced Automation\\FreeCRM\\screenshotloginTest_Tue Mar 19 19_18_01 IST 2019.png").build());
		extent.flush();
		System.out.println("This is login to amazon");
	}
}
