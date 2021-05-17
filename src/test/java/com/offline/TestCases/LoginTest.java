package com.offline.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.offline.qa.Base.TestBase;
import com.offline.qa.Pages.Dashboard;
import com.offline.qa.Pages.LoginPage;

@Listeners(com.offline.qa.Util.MyITestListners.class)
public class LoginTest extends TestBase {
	LoginPage Login;
	Dashboard dashboard;

	public LoginTest() throws Exception {
		super();

	}

	@BeforeMethod
	public void SetUp() throws Exception {
		Initialization();
		Login = new LoginPage();
	}

	@Test(dataProvider = "Data", dataProviderClass = com.offline.qa.Util.DataProviderManual.class, enabled = false, groups = {
			"regression" })
	public void LoginWithDataProviderManualTest(String EmailData, String PasswordData) throws Exception {

		dashboard = Login.Login(EmailData, PasswordData);
		String ActualTitle = dashboard.LogoHeading();
		String ExpectedTitle = "Admin";
		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@Test(dataProvider = "Data", dataProviderClass = com.offline.qa.Util.DataProviderManual.class, enabled = false, groups = {
			"regression" })
	public void RegisterNewMemberWithDataProviderManualTest(String Name, String Mobile, String Email, String Password)
			throws Exception {
		Login.RegisterNewMember(Name, Mobile, Email, Password);

	}

	@Test(dataProvider = "ExcelData", dataProviderClass = com.offline.qa.Util.DataProviderExcelReadNew.class, enabled = true, groups = {
			"regression" })
	public void LoginWithDataProviderExcelTest(String EmailData, String PasswordData) throws Exception {
		dashboard = Login.Login(EmailData, PasswordData);
		// Login.LoginWithDataProvider(EmailData, PasswordData);
		// Thread.sleep(1000);
	}

	@Test(dataProvider = "ExcelData", dataProviderClass = com.offline.qa.Util.DataProviderExcelReadNew.class, enabled = true, groups = {
			"regression" })
	public void RegisterNewMemberWithDataProviderExcelTest(String Name, String Mobile, String Email, String Password)
			throws Exception {
		Login.RegisterNewMember(Name, Mobile, Email, Password);

	}

	@Test(enabled = false, groups = { "smoke", "sanity" })
	public void ValidLoginTest() throws Exception {
		Login.ValidLogin();
		Thread.sleep(2000);
	}

	@Test(enabled = , groups = { "smoke", "sanity" })
	public void EmailfieldTest() {

		String actualEmailerror = Login.EmailfieldVerification("test@gmail.com");
		String expectedEmailError = "Please enter email as kiran@gmail.com";
		Assert.assertEquals(actualEmailerror, expectedEmailError);
	}

	@Test(enabled = false, groups = { "smoke", "sanity" })
	public void PasswordfieldTest() {

		String actualPassworderror = Login.PasswordFieldVerification("test");
		String expectedPasswordError = "Please enter password 123456";
		Assert.assertEquals(actualPassworderror, expectedPasswordError);
	}

	@Test(enabled = false, groups = { "sanity" })
	public void FailureTest11() {
		Assert.assertTrue(false);
	}

	@Test(enabled = false, groups = { "sanity" })
	public void FailureTest22() {
		Assert.assertFalse(true);
	}

	@Test(enabled = false, groups = { "smoke", "sanity" })
	public void SignInButtonDisplayTest() {

		boolean status = Login.SignInButtonIsDisplay();
		Assert.assertEquals(status, true);
	}

	@Test(enabled = false, groups = { "smoke", "sanity" })
	public void SignButtonEnableTest() {

		boolean status = Login.SignInButtonIsEnable();
		Assert.assertEquals(status, true);
	}

	@Test(enabled = false, groups = { "smoke", "sanity", "regression" })
	public void registerNewmemeberTest() throws Exception {
		Login.RegisterNewMember("Payal", "9823873382", "Payal@gmail.co", "Payal@1234");
	}

	@Test(enabled = false, groups = { "smoke", "sanity", "regression" })
	public Dashboard SignInTest() throws Exception {
		String ActualEmailFieldError = Login.EmailfieldVerification("kiran@gmail.com");
		String expectedEmailfieldError = "";
		Assert.assertEquals(ActualEmailFieldError, expectedEmailfieldError);
		String actualPasswordFieldError = Login.PasswordFieldVerification("123456");
		String expectedpasswordfieldError = "";
		Assert.assertEquals(actualPasswordFieldError, expectedpasswordfieldError);
		Login.ClickSignInButton();
		// System.out.println("In dashboard");
		return new Dashboard();
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
