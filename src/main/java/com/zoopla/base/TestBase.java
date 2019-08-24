package com.zoopla.base; 

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class TestBase {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger("DevpinoyLogger");
	public static WebDriver wait; // never used

    public static final String BROWSER = "chrome";
    public static final String TEST_URL = "https://www.zoopla.co.uk";
    public static final int PAGE_LOAD_TIMEOUT = 10;
    public static final int IMPLICIT_WAIT = 10;
		
	public static void initConfiguration(){
		if(BROWSER.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/executables/geckodriver.exe");
			
			driver = new FirefoxDriver();
			log.debug("Launching Firefox");
		}else if(BROWSER.equalsIgnoreCase("chrome")){
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
		}else if(BROWSER.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "./src/test/resources/executables/IEDriverServer.exe");

			driver = new InternetExplorerDriver();
			log.debug("Launching IE");
		}
		
	driver.get(TEST_URL);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,TimeUnit.SECONDS);
	
	}
	
  }


	

