package com.uiautomation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.actiondriver.Action;
import com.uiautomation.base.BaseClass;

public class AccountCreationPage extends BaseClass{
	
	@FindBy(xpath = "//span[text()='Create New Customer Account']")
	private WebElement accountCreationPageHeadingElement;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateAccountCreationPage() {
		return Action.isDisplayed(getDriver(), accountCreationPageHeadingElement);
	}
}
