package com.uiautomation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.actiondriver.Action;
import com.uiautomation.base.BaseClass;

public class PaymentPage extends BaseClass{
	
	@FindBy(xpath = "//button[@title='Place Order']")
	private WebElement placeOrderBtn;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickPlaceOrder() {
		Action.click(getDriver(), placeOrderBtn);
		return new OrderConfirmationPage();
	}

}
