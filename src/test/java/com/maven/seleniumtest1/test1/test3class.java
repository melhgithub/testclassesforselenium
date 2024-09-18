package com.maven.seleniumtest1.test1;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test3class {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		System.out.println(driver.manage().window().getSize());
		
		System.out.println(driver.manage().window().getPosition());
		
		//driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		//driver.manage().window().minimize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
}
