package com.maven.seleniumtest1.test1;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test9class {
	static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@AfterClass
	public static void tearDown() { driver.close(); }
	
	@Test
	public void test01() {
		driver.get("https://amazon.com");
	}
	
	@Test(dependsOnMethods = "test01")
	public void test02() {
		System.out.println(driver.getTitle());
	}
	
	@Test(dependsOnMethods = "test02")
	public void test03() {
		System.out.println(driver.getCurrentUrl());
	}
}
