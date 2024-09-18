package com.maven.seleniumtest1.test1;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test4class {
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.amazon.com");
		
		WebElement aramaKutusu = driver.findElement(By.id("captchacharacters"));
		aramaKutusu.sendKeys("Nutella");
		aramaKutusu.submit();
		
		WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
		
		System.out.println(sonucYazisi.getText());
		
		driver.close();
	
	}
}
