package com.uiautomation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.actiondriver.Action;
import com.uiautomation.base.BaseClass;

public class SearchResultPage extends BaseClass{
	
	@FindBy(xpath = "(//img[@class='product-image-photo'])[1]")
	private WebElement productResultImg;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductResultAvailable() {
		return Action.isDisplayed(getDriver(), productResultImg);
	}
	
	public AddToCartPage clickOnProduct() {
		Action.click(getDriver(), productResultImg);
		return new AddToCartPage();
	}
}
