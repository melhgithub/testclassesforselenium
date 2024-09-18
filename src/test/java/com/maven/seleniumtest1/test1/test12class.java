package com.maven.seleniumtest1.test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test12class {
	static WebDriver driver;
	
	@BeforeClass
	public static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@AfterClass
	public static void end() {
		driver.close();
	}
	
	@Test
	public void test() {
		driver.get("http://automationexercise.com");
		WebElement logoElement = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
		Assert.assertTrue(logoElement.isDisplayed());
		
		WebElement productsButton = driver.findElement(By.xpath("//a[text()=' Products']"));
		productsButton.click();
		
		WebElement allproducts = driver.findElement(By.xpath("//h2[text()='All Products']"));
		Assert.assertTrue(allproducts.isDisplayed());
		
		WebElement searchProduct = driver.findElement(By.xpath("//input[@id='search_product']"));
		searchProduct.sendKeys("deneme");
		
		driver.findElement(By.xpath("//button[@id='submit_search']")).click();
		
		WebElement searchedproducts = driver.findElement(By.xpath("//h2[text()='Searched Products']"));
		Assert.assertTrue(searchedproducts.isDisplayed());
		
		
	}
	@Test(dependsOnMethods = "test")
	public void test2() {
	}
	
	
	
}
