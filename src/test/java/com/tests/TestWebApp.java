package com.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestWebApp {
	public static AndroidDriver<WebElement> driver;
    public static void main( String[] args ) throws InterruptedException, MalformedURLException
    {
	AppiumDriverLocalService service = AppiumDriverLocalService
    		.buildService(new AppiumServiceBuilder()
    		.usingDriverExecutable(new File("C:\\Program Files (x86)\\Appium\\node.exe"))
    		.withAppiumJS(new File("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"))
    		.withLogFile(new File("C:\\AppiumServerlogs.txt")));
    	service.start();
	DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
    
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	

    driver.get("http://google.com");
    driver.findElement(By.name("q")).sendKeys("Hello Appium");
    Thread.sleep(3000);
    driver.quit();
    service.stop();
}
}
