package com.offline.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class seleniumRun {
	@Test
public void name() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Selenium Software\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[contains(text(),'Register a new membership')]")).click();
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Payal");
		driver.findElement(By.xpath("//*[@id='mobile']")).sendKeys("Deshmukh");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("payaldeshmukh@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-block btn-flat']")).click();
}
}
