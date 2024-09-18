package com.maven.seleniumtest1.test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test14class1assert {
	
	WebDriver driver;
	
	@Test
	public void testAssert() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://automationexercise.com");
		
		String expectedUrl = "https://automationexercise.com/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		
		driver.findElement(By.xpath("//*[text()=' Products']")).click();
		
		WebElement allProducts = driver.findElement(By.xpath("//*[text()='All Products']"));
		Assert.assertTrue(allProducts.isDisplayed());
	
		List<WebElement> productList = driver.findElements(By.xpath("//*[text()='View Product']"));

		Assert.assertTrue(productList.size()>0);
	
		driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();
		
		WebElement productName = driver.findElement(By.xpath("(//h2)[3]"));
		Assert.assertTrue(productName.isDisplayed());
		
		WebElement category = driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
		Assert.assertTrue(category.isDisplayed());
		
		driver.close();
	}
}
