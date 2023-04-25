package com.facebook_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;

//open app
	@BeforeMethod
	public void openApp() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		driver.get("https://www.facebook.com/");

	}

	// valid login
	@Test
	public void validLoginTest() {
		System.out.println("valid login test");
		driver.findElement(By.id("email")).sendKeys("fj@bmail.com");
		driver.findElement(By.id("pass")).sendKeys("df123");
		driver.findElement(By.name("login")).click();

	}

	// invalid login
	@Test
	public void invalidLoginTest() {
		System.out.println("invalid login test");
		driver.findElement(By.id("email")).sendKeys("fj@bmail.com");
		driver.findElement(By.id("pass")).sendKeys("y789y");
		driver.findElement(By.name("login")).click();

	}
	@Test
	public void failLoginTest() {
		System.out.println("invalid login test");
		driver.findElement(By.id("email")).sendKeys("fj@bmail.com");
		driver.findElement(By.id("pass")).sendKeys("y789y");
		driver.findElement(By.name("login1")).click();

	}
	
	@Test(dependsOnMethods="failLoginTest")
	public void skipLoginTest() {
		System.out.println("invalid login test");
		driver.findElement(By.id("email")).sendKeys("fj@bmail.com");
		driver.findElement(By.id("pass")).sendKeys("y789y");
		driver.findElement(By.name("login1")).click();

	}

	// close browser
	@AfterMethod
	public void closeApp() {
	driver.close();
	}

}
