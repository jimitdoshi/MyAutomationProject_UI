package com.uiautomation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.actiondriver.Action;
import com.uiautomation.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	@FindBy(xpath = "//div[text()='S']")
	private WebElement productSize;
	
	@FindBy(xpath = "//div[@aria-label='Blue']")
	private WebElement productColor;
	
	@FindBy(xpath = "//input[@title='Qty']")
	private WebElement productQuantity;
	
	@FindBy(xpath = "//button[@title='Add to Cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "(//span[@class='counter qty'])[1]")
	private WebElement counterQtnBtn;
	
	@FindBy(xpath = "//div[contains(text(),'You added')]")
	private WebElement addToCartMessage;
	
	@FindBy(xpath = "//button[text()='Proceed to Checkout']")
	private WebElement proceedToCheckoutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantity) {
		Action.type(productQuantity, quantity);
	}
	
	public void selectSize(String size) {
		Action.selectByVisibleText(size, productSize);
	}
	
	public void selectColor() {
		Action.click(getDriver(), productColor);
	}
	
	public void clickOnAddToCart() {
		Action.click(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddToCartMessage() {
		return Action.isDisplayed(getDriver(), addToCartMessage);
	}
	
	public void clickOnCounterQtn() {
		Action.click(getDriver(), counterQtnBtn);
	}
	
	public AddressPage clickOnProceedToCheckout() {
		Action.JSClick(getDriver(), proceedToCheckoutBtn);
		return new AddressPage();
	}
}
