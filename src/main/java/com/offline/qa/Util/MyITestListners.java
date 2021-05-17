package com.offline.qa.Util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.offline.qa.Base.TestBase;

public class MyITestListners extends TestBase implements ITestListener {

	public MyITestListners() throws Exception {
		super();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start:" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Sucess:" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure:" + result.getName());
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(srcFile,
					new File(currentDir + "/ScreenShot/" + result.getName()+System.currentTimeMillis() + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped:" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On Test Failedwithin Success Percentage:" + result.getName());
	}

	public void onStart(ITestContext context) {
		System.out.println("On Suite Start:" + context.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("On Suite Finish:" + context.getName());

	}

}
