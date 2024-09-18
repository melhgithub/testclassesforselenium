package com.maven.seleniumtest1.test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test14class2softassert {
	
	WebDriver driver;
	
	@Test
	public void testAssert() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://automationexercise.com");
		
		SoftAssert softAssert = new SoftAssert();
		
		String expectedUrl = "https://automationexercise.com/";
		String actualUrl = driver.getCurrentUrl();
		softAssert.assertEquals(actualUrl, expectedUrl, "Url Test :");
		
		driver.findElement(By.xpath("//*[text()=' Products']")).click();
		
		WebElement allProducts = driver.findElement(By.xpath("//*[text()='All Products']"));
		softAssert.assertTrue(allProducts.isDisplayed(),"All products :");
	
		List<WebElement> productList = driver.findElements(By.xpath("//*[text()='View Product']"));

		softAssert.assertTrue(productList.size()>0, "Product List Test :");
	
		driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();
		
		WebElement productName = driver.findElement(By.xpath("(//h2)[3]"));
		softAssert.assertTrue(productName.isDisplayed(), "Product Name Visible Test :");
		
		WebElement category = driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
		softAssert.assertTrue(category.isDisplayed(), "Category Visible Test :");
		softAssert.assertAll();
		
		driver.close();
	}
}
