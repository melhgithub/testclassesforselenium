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

public class test11class {
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
		
		WebElement login = driver.findElement(By.xpath("//a[text()=' Signup / Login'] "));
		login.click();
		
		WebElement logintext = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
		Assert.assertTrue(logintext.isDisplayed());
		
		WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));

		email.sendKeys("melihdursunkisisel2@gmail.com");
		
		WebElement passwd = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
		passwd.sendKeys("12345");
		
		WebElement loginbutton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
		
		loginbutton.click();
		
		WebElement loggedas = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
		Assert.assertTrue(loggedas.isDisplayed());
		
		WebElement logout = driver.findElement(By.xpath("//a[text()=' Logout']"));
		logout.click();
		
		String expectedUrl="https://automationexercise.com/login";
		String currentUrl=driver.getCurrentUrl();
		
		Assert.assertEquals(expectedUrl, currentUrl);
	}
	@Test(dependsOnMethods = "test")
	public void test2() {
	}
	
	
	
}
