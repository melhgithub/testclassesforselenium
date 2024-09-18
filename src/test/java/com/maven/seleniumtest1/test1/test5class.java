package com.maven.seleniumtest1.test1;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test5class {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
		driver.get("https://www.facebook.com");
		
		
		WebElement email = driver.findElement(By.xpath("//input[@data-testid='royal_email']"));
	
		WebElement pass = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
		
		email.sendKeys("deneme@gmail.com");
		
		pass.sendKeys("deneme");
		
		driver.findElement(By.xpath("//button[@data-testid='royal_login_button']")).click();
	
	}
}
