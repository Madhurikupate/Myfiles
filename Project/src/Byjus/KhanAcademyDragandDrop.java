package Byjus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import graphql.Assert;

public class KhanAcademyDragandDrop {

	WebDriver driver;
	 @BeforeMethod
	 public void Setup() {
	  System.setProperty("webdriver.chrome.driver","C:\\installer\\update\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	  driver.get("https://www.khanacademy.org/");
	 }
	 
	 @Test
	 public void LoginTest() throws InterruptedException{
		 
		 driver.findElement(By.xpath("//button[@data-test-id='learn-menu-dropdown']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[text()='Class 1']")).click();
		 Thread.sleep(2000);
		 
		 String address = driver.findElement(By.xpath("//h1[text()='Class 1 math (India)']")).getText();
		  if(address.equals("Class 1 math (India)")) {
		   Assert.assertTrue(true);
		  }
		  else {
		   Assert.assertTrue(false);
		  }
		  
		  driver.findElement(By.xpath("//h3[@class='_k50sd54']")).click();
		  Thread.sleep(2000);
		  
		 
	 }
	 public void TearDown() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.quit();
	 }
}
