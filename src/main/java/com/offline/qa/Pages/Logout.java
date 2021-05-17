package com.offline.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.offline.qa.Base.TestBase;

public class Logout extends TestBase {
	
@FindBy(xpath="//*[@class='login-box-body']//p[2]")@CacheLookup WebElement LogoutMessage;

	public Logout()throws Exception  {
		PageFactory.initElements(driver, this);		}
	
	public String LogoutMessage() {
		String logoutMessage=LogoutMessage.getText();
		return logoutMessage;
		
	}
	
	
}
