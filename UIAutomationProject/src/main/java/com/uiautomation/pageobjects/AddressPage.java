package com.uiautomation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.actiondriver.Action;
import com.uiautomation.base.BaseClass;

public class AddressPage extends BaseClass{
	
	@FindBy(xpath = "//input[@name='street[0]']")
	private WebElement streetAddressField;
	
	@FindBy(xpath = "//select[@name='country_id']")
	private WebElement countrySelection;
	
	@FindBy(xpath = "//input[@name='postcode']")
	private WebElement postalCodeField;
	
	@FindBy(xpath = "//select[@name='region_id']")
	private WebElement stateSelection;
	
	@FindBy(xpath = "//input[@name='city']")
	private WebElement cityField;
	
	@FindBy(xpath = "//input[@name='telephone']")
	private WebElement phoneNumberField;
	
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement nextBtn;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectCountry(String country) {
		Action.selectByVisibleText(country, countrySelection);
	}
	
	public void selectState(String state) {
		Action.selectByVisibleText(state, stateSelection);
	}
	
	public void enterStreetAddress(String streetAddress) {
		Action.type(stateSelection, streetAddress);
	}
	
	public void enterPostalCode(String postalCode) {
		Action.type(postalCodeField, postalCode);
	}
	
	public void enterCity(String city) {
		Action.type(cityField, city);
	}
	
	public void enterPhoneNumber(String phoneNumber) {
		Action.type(phoneNumberField, phoneNumber);
	}
	
	public PaymentPage clickOnNext() {
		Action.click(getDriver(), nextBtn);
		return new PaymentPage();
	}

}
