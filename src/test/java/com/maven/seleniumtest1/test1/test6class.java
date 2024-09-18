package com.maven.seleniumtest1.test1;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test6class {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
		driver.get("https://www.bestbuy.com");
		
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		
		System.out.println(buttons.size());
		
		for (WebElement each:buttons){
			System.out.println(each.getText());
		}
		
		driver.close();
		
	}
}