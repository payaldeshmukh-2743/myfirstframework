package com.offline.TestCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.offline.qa.Base.TestBase;
import com.offline.qa.Pages.Dashboard;
import com.offline.qa.Pages.LoginPage;
import com.offline.qa.Pages.Users;

public class UsersTest extends TestBase {
	LoginPage Login;
	Dashboard Dashboard;
	Users User;

	public UsersTest() throws Exception {
		super();

	}

	@BeforeMethod
	public void SetUp() throws Exception {
		Initialization();
		Login = new LoginPage();
		Login.ValidLogin();
		Dashboard = new Dashboard();
		Dashboard.UsersLink();
		User = new Users();

	}

	@Test(enabled = false, groups = { "smoke", "sanity" })
	public void UserHeadingTest() {
		String ExpectedUserHeading = User.UsersHeading();
		String ActualUserHeading = "Users";
		Assert.assertEquals(ActualUserHeading, ExpectedUserHeading);
	}

	@Test(enabled = false, groups = { "smoke", "sanity"})
	public void UserListHeadingTest() {
		String ExpectedUserListHeading = User.UsersHeading();
		String ActualUserListHeading = "Users";
		Assert.assertEquals(ExpectedUserListHeading, ActualUserListHeading);

	}

	@Test(enabled = false, groups = { "smoke", "sanity"})
	public void ReadUserListTableDataTest() {
		User.ReadUserListData();
	}

	@Test(enabled = false, groups = {  "sanity" })
	public void StateOptionTest() {
		User.ClickOnAddUser();
		ArrayList<String> expectedstateOption = new ArrayList<String>();
		expectedstateOption.add("--Select State--");
		expectedstateOption.add("Maharashtra");
		expectedstateOption.add("Delhi");
		expectedstateOption.add("HP");
		expectedstateOption.add("Punjab");

		List<String> ActualStateOption = User.GetStateOption();
		Assert.assertEquals(ActualStateOption, expectedstateOption);

	}

	@Test(enabled = false, groups = { "smoke", "sanity", "regression" })
	public void AddUserButtonTest() {
		User.ClickOnAddUser();

	}

	@Test(enabled = false, groups = { "smoke", "sanity" })
	public void AddUserHeadingTest() {
		User.ClickOnAddUser();
		String ActualHeading = User.AddUserHeading();
		String ExpectedHeading = "Add Userv";
		Assert.assertEquals(ActualHeading, ExpectedHeading);
	}

	@Test(enabled = false, groups = { "smoke", "sanity", "regression" })
	public void AddUserFormTest() {
		User.ClickOnAddUser();
		String ActualHeading = User.UserFormHeading();
		String ExpectedHeading = "Horizontal Form";
		Assert.assertEquals(ActualHeading, ExpectedHeading);
	}

	@Test(dataProvider = "Data", dataProviderClass = com.offline.qa.Util.DataProviderManual.class, enabled = true, groups = {
			"smoke", "sanity", "regression" })
	public void AddUserWithDataProviderManualTest(String Name, String Mobile, String Email, String Gender, String state,
			String Password) throws Exception {
		User.ClickOnAddUser();
		Thread.sleep(2000);
		String Expected = User.AddUser(Name, Mobile, Email, Gender, state, Password);
		String Actual = "User Added Successfully. You can not see added user.";
		Assert.assertEquals(Actual, Expected);
	}

	@Test(dataProvider = "ExcelData", dataProviderClass = com.offline.qa.Util.DataProviderExcelReadNew.class, enabled = true, groups = {
			"smoke", "sanity", "regression" })
	public void AddUserWithDataProviderExcelTest(String Name, String Mobile, String Email, String Gender, String state,
			String Password) throws Exception {
		User.ClickOnAddUser();
		Thread.sleep(2000);
		String Expected = User.AddUser(Name, Mobile, Email, Gender, state, Password);
		String Actual = "User Added Successfully. You can not see added user.";
		Assert.assertEquals(Actual, Expected);
	}

	@Test(enabled = false, groups = { "smoke", "sanity", "regression" })
	public void AddValidUserTest() throws Exception {
		User.ClickOnAddUser();
		Thread.sleep(2000);
		String Expected = User.AddUser("Payal", "9823873382", "payal@gmail.com", "Female", "Delhi", "123455");
		String Actual = "User Added Successfully. You can not see added user.";
		Assert.assertEquals(Actual, Expected);
	}

	@Test(enabled = false, groups = { "smoke", "sanity", "regression" })
	public void AddUserCancelButtonTest() throws Exception {
		User.ClickOnAddUser();
		Thread.sleep(2000);
		User.ClickOnAddUser_cancelButton();
		String ExpectedUserHeading = User.UsersHeading();
		String ActualUserHeading = "Users";
		Assert.assertEquals(ActualUserHeading, ExpectedUserHeading);
	}

	// org.openqa.selenium.StaleElementReferenceException: stale element reference:
	// element is not attached to the page document

	@Test(enabled = false, groups = { "smoke", "sanity", "regression" })
	public void AddUserAlertMessageTest() {
		User.ClickOnAddUser();
		String Actual = User.AddAlertMessage("Payal", "9823873382", "payal@gmail.com", "Female", "Delhi", "123455");
		String Expected = "User Added Successfully. You can not see added user.";
		Assert.assertEquals(Actual, Expected);
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}
