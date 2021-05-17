package com.offline.TestCases;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.offline.qa.Base.TestBase;
import com.offline.qa.Pages.Dashboard;
import com.offline.qa.Pages.LoginPage;
import com.offline.qa.Pages.Operators;

public class OperatorTest extends TestBase {
	LoginPage Login;
	Dashboard dashboard;
	Operators operator;

	public OperatorTest() throws Exception {
		super();

	}

	@BeforeMethod
	public void Setup() throws Exception {
		Initialization();
		Login = new LoginPage();
		Login.ValidLogin();
		dashboard = new Dashboard();
		dashboard.OperatorsLink();
		operator = new Operators();

	}

	@Test(enabled = true, groups = { "smoke", "sanity" })
	public void OperatorsHeadingTest() {
		String actual_Heading = operator.operatorsHeading();
		String Expected_Heading = "Operators";
		Assert.assertEquals(actual_Heading, Expected_Heading);
	}

	@Test(enabled = true, groups = {  "sanity" })
	public void Operators_ListTest() {
		String actual_Heading = operator.operator_ListHeading();
		String Expected_Heading = "Operator List";
		Assert.assertEquals(actual_Heading, Expected_Heading);

	}

	@Test(enabled = true, groups = { "sanity" })
	public void ReadOperatorListTableTest() {
		operator.ReadOperatorListData();
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
