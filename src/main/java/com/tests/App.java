package com.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
//import util.logs.LogUtil;

/**
 * Hello world!
 *
 */
public class App 
{
	//IOSElement, WebElement,MobileElement,AndroidElement
	public static AndroidDriver<WebElement> adriver;
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );
//        WebDriver driver;
/*        System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
		System.setProperty("browser","Firefox");
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, LogUtil.logs); 
	
	//	WebDriver driver = new FirefoxDriver(capabilities);
		
		driver.get("www.gmail.com");
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.withMessage("Time out after 10 Seconds");*/
//    }
//    
//    void testAndroiddriver()
//    {
        AppiumDriverLocalService service = AppiumDriverLocalService
        		.buildService(new AppiumServiceBuilder()
        		.usingDriverExecutable(new File("C:\\Program Files (x86)\\Appium\\node.exe"))
        		.withAppiumJS(new File("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"))
        		.withLogFile(new File("C:\\AppiumServerlogs.txt")));
        	service.start();
    	DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        try {
			adriver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        adriver.get("http://google.com");
        adriver.findElement(By.name("q")).sendKeys("Hello Appium");
        Thread.sleep(3000);
        adriver.quit();
        service.stop();
    }
    
}
