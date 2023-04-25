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

public class FindElement {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openApp() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
	}
	
	@Test
	public void getTitleTest() {

		
		//driver.findElement(By.id("email")).sendKeys("fj@bmail.com");
		//driver.findElement(By.id("pass")).sendKeys("df123");
		//driver.findElement(By.name("login")).click();
		
		//driver.findElement(By.id("email")).sendKeys("Faruq");
		//driver.findElement(By.name("email")).sendKeys("Molla");
		driver.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("Tuhin");
	}
	
	@AfterMethod
	public void closeApp() {
		//driver.close();
	}
	

}
