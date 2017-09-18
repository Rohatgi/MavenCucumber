package com.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class NativeElments {
	public static AndroidDriver<WebElement> driver;
    public static void main( String[] args ) throws InterruptedException, MalformedURLException
    {
	 AppiumDriverLocalService service = AppiumDriverLocalService
     		.buildService(new AppiumServiceBuilder()
     		.usingDriverExecutable(new File("C:\\Program Files (x86)\\Appium\\node.exe"))
     		.withAppiumJS(new File("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"))
     		.withLogFile(new File("C:\\AppiumServerlogs.txt")));
     	service.start();
     	// Deploy apk
// 	File app = new File("C:\\Projects\\Appium\\selendroid-test-app-0.17.0.apk");
     	DesiredCapabilities capabilities = new DesiredCapabilities();
     	
     capabilities.setCapability("deviceName","Android");
     //Deploy apk
//     capabilities.setCapability("app",app.getAbsolutePath());
     // Already deployed app
   capabilities.setCapability("appPackage","io.selendroid.testapp");
   capabilities.setCapability("appActivity",".HomeScreenActivity");
//     capabilities.setCapability("appPackage","com.whatsapp");
//     capabilities.setCapability("appActivity","com.whatsapp.Main");
     
	 driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
    driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("Hello Appium !!");
     Thread.sleep(3000);
     driver.quit();
     service.stop();
    }
}
