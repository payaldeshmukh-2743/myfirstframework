package com.offline.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.offline.qa.Base.TestBase;
import com.offline.qa.Pages.Dashboard;
import com.offline.qa.Pages.LoginPage;
import com.offline.qa.Pages.Logout;

public class LogoutTest extends TestBase {
	LoginPage login;
	Dashboard dashboard;
	Logout Logout;

	public LogoutTest() throws Exception {
		super();

	}

	@BeforeMethod
	public void setup() throws Exception {
		Initialization();
		login = new LoginPage();
		login.ValidLogin();
		dashboard = new Dashboard();
		dashboard.LogoutLink();
		Logout = new Logout();

	}

	@Test(enabled = false, groups = { "smoke", "sanity", "regression" })
	public void logoutmessagetest() {
		String actualmessage = Logout.LogoutMessage();
		String Expectedmessage = "Logout successfully";
		Assert.assertEquals(actualmessage, Expectedmessage);
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
