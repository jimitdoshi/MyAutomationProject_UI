package com.uiautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.uiautomation.base.BaseClass;
import com.uiautomation.dataprovider.DataProviders;
import com.uiautomation.pageobjects.HomePage;
import com.uiautomation.pageobjects.IndexPage;
import com.uiautomation.pageobjects.LoginPage;
import com.uiautomation.utility.Log;

public class LoginPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName) {
		launchApp(browserName);
	}
	
	@Test(dataProvider = "credentials" ,  dataProviderClass = DataProviders.class)
	public void loginTest(String uname, String pwd) {
		Log.startTestCase("LoginTest start");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(uname, pwd);
		String actualURL = homePage.getCurrentURL();
		String expectedURL = "https://magento.softwaretestingboard.com/";
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
