package com.assignment.automation.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.chrome.ChromeOptions;



public class BaseClass
{
	
	public static WebDriver driver;
	static DesiredCapabilities ieCapabilities;

	public static WebDriver machint_launchBrowser(String browserType, String appURL) throws Exception  
	{
		switch (browserType)
		{
		case "Chrome":
			initChromeDriver(appURL);
			break;
			
		case "Firefox":
			initFirefoxDriver(appURL);
			break;
			
		case "InternetExplorer":
			initInternetExplorer(appURL);
			break;
			
		default:
			System.out.println("browser : " + browserType+ " is invalid");
		}
		return driver;
	}

	public static void initChromeDriver(String appURL) throws Exception {
		System.out.println("Launching google chrome with new profile..");
	   
	    WebDriverManager.chromedriver().setup();
	    WebDriverManager.chromedriver().version("91.0.4472.101").setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get(appURL);
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public static void initFirefoxDriver(String appURL) throws Exception 
	{
	    System.out.println("Launching Firefox browser..");
	    //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
	    WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get(appURL);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	public static void initInternetExplorer(String appURL) throws Exception 
	{
		System.out.println("Launching InternetExplorer browser..");
	    //System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
		WebDriverManager.iedriver().setup();
	    ieCapabilities = DesiredCapabilities.internetExplorer();
	    ieCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false); 
	    ieCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept");
//	    ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true); 
	    ieCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true); 
	    ieCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true); 
	    ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
	    ieCapabilities.setCapability("disable-popup-blocking", true);
	    ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
	    ieCapabilities.setJavascriptEnabled(true);
		
	    driver = new InternetExplorerDriver(ieCapabilities);
	    driver.manage().window().maximize();
	    driver.get(appURL);
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	
}

