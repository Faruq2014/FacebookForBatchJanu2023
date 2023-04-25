package com.facebook_interface;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageTime {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openApp() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		//popular method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//selenium default value is =30 seconds
		//Industry standard value is =30 seconds
		//implicitlyWait=imply to all findElmemet() and findElmemets()
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
		//pageLoadTimeout()=imply for loading dom on the browser
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(6));
		//scriptTimeout()=imply to script to be executed in time.
		

	}
	
	@Test
	public void getTitleTest() {
		//public String getTitle() is returning title of the page
		String expectedTitle=driver.getTitle();
		System.out.println("this is expected facebook title >>> "+expectedTitle);
		String actualTitle="Facebook - log in or sign up";
		Assert.assertEquals(expectedTitle, actualTitle,"Did not match");
		
		driver.findElement(By.id("email")).sendKeys("fj@bmail.com");
		driver.findElement(By.id("pass")).sendKeys("df123");
		driver.findElement(By.name("login")).click();
	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
	

}
