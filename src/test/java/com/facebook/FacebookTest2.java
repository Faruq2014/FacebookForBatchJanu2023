package com.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookTest2 {

	public static void main(String[] args) {
		// TODO open Facebook main page using selenium
		
		//open Edge browser
		  //open exe file
		WebDriverManager.edgedriver().setup();
		 //open the browser
		WebDriver driver = new EdgeDriver();
		//open facebook app
		driver.get("https://www.facebook.com/");
		
	}

}
