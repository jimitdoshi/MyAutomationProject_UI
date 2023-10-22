package com.uiautomation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.actiondriver.Action;
import com.uiautomation.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(id="email")
	private WebElement userNameField;
	
	@FindBy(name="login[password]")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@class='action login primary']//span[text()='Sign In']")
	private WebElement signInBtn;
	
	@FindBy(xpath="//a[@class='action create primary']//span[text()='Create an Account']")
	private WebElement createAnAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String userName, String password) {
		Action.type(userNameField, userName);
		Action.type(passwordField, password);
		Action.click(getDriver(), signInBtn);
		return new HomePage();
	}
	
	public AccountCreationPage createNewAccount() {
		Action.click(getDriver(), createAnAccountBtn);
		return new AccountCreationPage();
	}
}
