package com.uiautomation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.actiondriver.Action;
import com.uiautomation.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	
	@FindBy(xpath = "//span[text()='Thank you for your purchase!']")
	private WebElement purchaseOrderConfirmationMsg;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateOrderConfirmationMsgHeading() {
		return Action.isDisplayed(getDriver(), purchaseOrderConfirmationMsg);
	}
	
	public String validateConfirmationMsg() {
		return purchaseOrderConfirmationMsg.getText();
	}
}
