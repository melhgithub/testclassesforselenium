package com.maven.seleniumtest1.test1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1class {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		
		System.out.println("sayfa baslik : " + driver.getTitle());
		
		System.out.println("sayfa link : " + driver.getCurrentUrl());
		System.out.println("===================");
		System.out.println("sayfa html : " + driver.getPageSource());
		System.out.println("===================");
		
		System.out.println(driver.getWindowHandle());
		
		
;	}
}
