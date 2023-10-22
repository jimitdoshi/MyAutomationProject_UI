package com.uiautomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.uiautomation.actiondriver.Action;
import com.uiautomation.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	
	public static Properties prop;
	//public static WebDriver driver;
	
	//Declaring ThreadLocal Driver for the parallel execution
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	@BeforeSuite
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		try {
			prop = new Properties();//creating a new reference object of Properties class
			
			//FileInputStream ip = new FileInputStream("eclipse-workspace\\UIAutomationProject\\Configuration\\Config.properties");
			System.out.println(System.getProperty("user.dir"));
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	@Parameters("browser")
	public static void launchApp(String browserName) {
		WebDriverManager.chromedriver().setup(); //Removing dependency of setting the driver path by using DriverManager
		//String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		if(browserName.contains("Chrome")) {
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		}
		else if(browserName.contains("Firefox")) {
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}
		else if(browserName.contains("IE")) {
			//driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(url);	
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
