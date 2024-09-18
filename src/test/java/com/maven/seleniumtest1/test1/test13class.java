package com.maven.seleniumtest1.test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test13class {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void startup() {
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
	public void test1() {
		driver.get("https://automationexercise.com/");
		WebElement signupButton = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
		
		Actions actions=new Actions(driver);
		actions.click(signupButton).perform();
		
		WebElement nameEntry = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
		actions.click(nameEntry).sendKeys("Metin")
		.sendKeys(Keys.TAB)
		.sendKeys("metin@gmail.com")
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER)
		.perform();
		
		WebElement checkbox = driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
		actions.click(checkbox)
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB)
		.sendKeys("12345")
		.sendKeys(Keys.TAB)
		.sendKeys("1234")
		.sendKeys(Keys.TAB)
		.sendKeys("September")
		.sendKeys(Keys.TAB)
		.sendKeys("1969		")
		.sendKeys(Keys.TAB)
		.click()
		.sendKeys(Keys.TAB)
		.click()
		.sendKeys(Keys.TAB)
		.sendKeys("metin")
		.sendKeys(Keys.TAB)
		.sendKeys("Dursun")
		.sendKeys(Keys.TAB)
		.sendKeys("ben")
		.sendKeys(Keys.TAB)
		.sendKeys("haciveliler cadde no 50")
		.sendKeys(Keys.TAB)
		.sendKeys("ic kapi no 555")
		.sendKeys(Keys.TAB)
		.sendKeys("United States")
		.sendKeys(Keys.TAB)
		.sendKeys("Texas")
		.sendKeys(Keys.TAB)
		.sendKeys("Dallas")
		.sendKeys(Keys.TAB)
		.sendKeys("unknown")
		.sendKeys(Keys.TAB)
		.sendKeys("05100")
		.sendKeys(Keys.TAB)
		.sendKeys("5487539697")
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER).perform();
		
		String expectedText = "ACCOUNT CREATED!";
		
		String resultText = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();

		Assert.assertEquals(expectedText, resultText);
		
		
	}
}








