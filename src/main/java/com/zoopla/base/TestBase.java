package com.zoopla.base; 

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger("DevpinoyLogger");
	public static String browser;
	public static WebDriver wait;
		
	public static void initConfiguration(){
		if(Constants.browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/executables/geckodriver.exe");
			
			driver = new FirefoxDriver();
			log.debug("Launching Firefox");
		}else if(Constants.browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/executables/chromedriver.exe");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

			driver = new ChromeDriver(options);
			log.debug("Launching Chrome");
		}else if(Constants.browser.equalsIgnoreCase("ie")){
			
			System.setProperty("webdriver.ie.driver", "./src/test/resources/executables/IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
			log.debug("Launching IE");
		}
		
	driver.get(Constants.testsiteurl);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT,TimeUnit.SECONDS);
	
	}
	
  }


	

