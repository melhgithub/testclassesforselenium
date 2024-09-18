package com.maven.seleniumtest1.test1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test10class {
	
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
	public void test01(){
		driver.get("https:amazon.com");
		
		WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	
		searchBar.sendKeys("Nutella");
		
		searchBar.submit();
		
		WebElement sonucYazi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
		
		String actualYaziStr = sonucYazi.getText();
		
		String expectedString = "Nutella";
		
		if(actualYaziStr.contains(expectedString)) {
			System.out.println("Passed");
		}
		else {
			System.out.println("nope");
		}
				
				
	
	}
}