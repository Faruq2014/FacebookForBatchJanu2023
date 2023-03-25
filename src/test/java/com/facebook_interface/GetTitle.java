package com.facebook_interface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTitle {
	
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
	public void getTitleTest() {
		//public String getTitle() is returning title of the page
		String expectedTitle=driver.getTitle();
		System.out.println("this is expected facebook title >>> "+expectedTitle);
		String actualTitle="Facebook - log in or sign up";
		Assert.assertEquals(expectedTitle, actualTitle,"Did not match");
	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
	

}
