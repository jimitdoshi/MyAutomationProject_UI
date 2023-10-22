package com.uiautomation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.actiondriver.Action;
import com.uiautomation.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//span[@class='customer-name active']//span[text()='Change']")
	private WebElement menuBtn;
	
	@FindBy(xpath = "(//a[text()='My Wish List '])[1]")
	private WebElement myWishListBtn;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateMenuBtn() {
		return Action.isDisplayed(getDriver(), menuBtn);
	}
	
	public boolean validateMyWishListBtn() {
		return Action.isDisplayed(getDriver(), myWishListBtn);
	}
	
	public MyWishListPage clickMyWishListBtn() {
		Action.click(getDriver(), menuBtn);
		Action.click(getDriver(), myWishListBtn);
		return new MyWishListPage();
	}
	
	public String getCurrentURL() {
		return getDriver().getCurrentUrl();
	}
}
