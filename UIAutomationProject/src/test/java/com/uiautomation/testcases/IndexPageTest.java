package com.uiautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.uiautomation.base.BaseClass;
import com.uiautomation.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass{
	
	IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName) {
		launchApp(browserName);
	}
	
	@Test
	public void verifyLogo() throws Throwable {
		indexPage = new IndexPage();
		boolean res = indexPage.validateLogo();
		Assert.assertEquals(res, true);
	}
	
	@Test
	public void verifyTitle() {
		String appTitle = indexPage.getAppTitle();
		Assert.assertEquals(appTitle, "Home Page");
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
