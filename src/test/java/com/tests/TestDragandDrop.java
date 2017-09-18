package com.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class TestDragandDrop {
	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// starting the Appium server code
		/*
		 * AppiumDriverLocalService service = AppiumDriverLocalService
		 * .buildService(new AppiumServiceBuilder() .usingDriverExecutable(new
		 * File("C:\\Program Files (x86)\\Appium\\node.exe")) .withAppiumJS(new
		 * File(
		 * "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"
		 * )) .withLogFile(new File("c:\\appiumlogs\\logs.txt")));
		 * 
		 * service.start();
		 */

		File app = new File(System.getProperty("user.dir") + "//apk//drag.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");

		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

		System.out.println(driver.getPageSource());
		// driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();

		// xml code
		//driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Basic')]")).click();

		String text = "Basic";
//		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+text+"\")").click();
//		//Thread.sleep(2000);
//		
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.mobeta.android.demodslv:id/text")));
//		
//		
//		System.out.println(driver.getPageSource());
//		
//		MobileElement draggable = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Brad')]/preceding-sibling::android.widget.ImageView"));
//		MobileElement droppable = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Kurt')]/preceding-sibling::android.widget.ImageView"));
//		
//		
//		TouchAction action = new TouchAction(driver);
//		action.longPress(draggable).moveTo(droppable).release().perform();
		
		
		
		Thread.sleep(4000);
		driver.quit();
		// service.stop();
	}
}
