package com.facebook_interface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetUrl {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openApp() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		driver.get("https://www.facebook.com/");

	}
	@Test
	public void getUrlTest() {
		String actualUrl="https://www.facebook.com/";
		String expectedUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "****Url did not match****");
	}
	
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
	

}
