package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import reusableComponents.Reusable_Methods;

public class Login_Page_Pom extends Reusable_Methods{
	
	public Login_Page_Pom() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@name='txtMobile']")
	private WebElement userName;
	
	
	@FindBy(xpath = "//input[@name='txtPassword']")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginButton;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	
	
	

}
