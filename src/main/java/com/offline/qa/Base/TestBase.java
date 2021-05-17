package com.offline.qa.Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static Properties config;
	public static WebDriver driver;

	public TestBase() throws Exception {
		config = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\HP\\eclipse-workspace\\Offline\\src\\main\\java\\com\\offline\\qa\\Config\\config.properties");
		config.load(fis);

	}

	public static void Initialization() {
		String Browser_Name = config.getProperty("Browser");
		if (Browser_Name.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}

		else if (Browser_Name.equalsIgnoreCase("Chrome")) {
			// --to handle ssl certificate in case of https
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Driver\\chromedriver.exe");
			/*
			 * ChromeOptions handlingSSL = new ChromeOptions();
			 * handlingSSL.setAcceptInsecureCerts(true);
			 * driver = new ChromeDriver(handlingSSL);
			 */
			driver = new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("PageLoadTime")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("ImplicitWait")), TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get(config.getProperty("URL"));
		 driver.get("C:\\Selenium Software\\Offline Website\\index.html");

	}

}
