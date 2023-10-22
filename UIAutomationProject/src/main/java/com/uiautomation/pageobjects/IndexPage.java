package com.uiautomation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.actiondriver.Action;
import com.uiautomation.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//a[@aria-label='store logo']//img")
	private WebElement appLogo;
	
	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchProductBox;
	
	@FindBy(xpath = "button[title='Search']")
	private WebElement searchBtn;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() {
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {	
		return Action.isDisplayed(getDriver(), appLogo);
	}
	
	public String getAppTitle() {
		String appTitle = getDriver().getTitle();
		return appTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchBtn);
		return new SearchResultPage();
	}
}
