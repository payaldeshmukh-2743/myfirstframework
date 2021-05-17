package com.offline.TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test {
	@org.testng.annotations.Test
	public void test() {
		ExtentHtmlReporter reporter= new ExtentHtmlReporter("C:\\Users\\HP\\eclipse-workspace\\Offline\\Reports\\learn_automation.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("LoginTest");
		logger.log(Status.INFO, "Login to amazon");
		System.out.println("tttt");
		
	}
}
