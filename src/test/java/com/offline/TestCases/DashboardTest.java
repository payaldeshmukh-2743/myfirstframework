package com.offline.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.offline.qa.Base.TestBase;
import com.offline.qa.Pages.Dashboard;
import com.offline.qa.Pages.LoginPage;

public class DashboardTest extends TestBase {
	LoginPage login;
	Dashboard dashboard;

	public DashboardTest() throws Exception {
		super();

	}

	@BeforeMethod
	public void SetUp() throws Exception {
		Initialization();
		login = new LoginPage();
		login.ValidLogin();
		dashboard = new Dashboard();

	}

	@Test(enabled = false, groups = { "smoke", "regression" })
	public void LogoHeadingTest() {
		String Heading = dashboard.LogoHeading();
		String ExpectedHeading = "Admin";
		Assert.assertEquals(Heading, ExpectedHeading);
	}

	@Test(enabled = false, groups = { "smoke", "regression" })
	public void UsernameTest() {
		String ActualUserName = dashboard.UserName();
		String ExpectedUserName = "Kiran";
		Assert.assertEquals(ActualUserName, ExpectedUserName);
	}

	@Test(enabled = false, groups = { "smoke", "regression" })
	public void DashboardHeadingTest() {
		String ActualDashboardHeading = dashboard.DashboardHeading();
		String ExpectedDashboardHeading = "Dashboard Control panel";
		Assert.assertEquals(ActualDashboardHeading, ExpectedDashboardHeading);
	}

	@Test(enabled = false, groups = { "smoke", "sanity" })
	public void dashboardLinkTest() {
		dashboard.DashBoardLink();
		String ActualDashboardHeading = dashboard.DashboardHeading();
		String ExpectedDashboardHeading = "Dashboard Control panel";
		Assert.assertEquals(ActualDashboardHeading, ExpectedDashboardHeading);

	}

	// not able to read this data with framework
	@Test(enabled = false, groups = {  "sanity", "regression" })
	public void ReadDashboardDataTest() throws Exception {
		dashboard.DashBoardLink();
		dashboard.ReadDashBoardData();
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
