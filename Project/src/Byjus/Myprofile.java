package Byjus;

import graphql.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

public class Myprofile {
 WebDriver driver;
 @BeforeMethod
 public void Setup() {
  System.setProperty("webdriver.chrome.driver","C:\\Installer\\chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  driver.get("https://byjus.com/");
 }
 
 @Test
 public void LoginTest() throws InterruptedException{
  Thread.sleep(2000);
  driver.findElement(By.xpath("//input[@name=\"name\"]")).sendKeys("Gaurav");
  Thread.sleep(2000);
  driver.findElement(By.xpath("//input[@name=\"mobile\"]")).sendKeys("9370000000");
  Thread.sleep(2000);
  driver.findElement(By.xpath("//button[text()=\"Send OTP\"]")).click();
  Thread.sleep(30000);
  WebElement States = driver.findElement(By.xpath("//select[@name=\"state\"]"));
  
  Select SC = new Select(States);
  SC.selectByValue("Maharashtra");
  Thread.sleep(2000);
  
  WebElement grade = driver.findElement(By.xpath("//select[@name=\"grade\"]"));
  Select SC2 = new Select(grade);
  SC2.selectByVisibleText("Class 5");
  Thread.sleep(3000);
  
  driver.findElement(By.xpath("//button[contains(text(),\"Schedule a Free Class\")]")).click();
  Thread.sleep(15000);
  
  String name = driver.findElement(By.xpath("//span[@class=\"font-16 account-user-name\"]")).getText();
  if(name.equals("Gaurav")) {
   System.out.println("User name is valid");
  }
  String msg = driver.findElement(By.xpath("//p[@class=\"font-16 pe-2 mt-2 mb-2 booked-text\"]")).getText();
  if(msg.equals("Booking Successful!")) {
   System.out.println("Booking Successful!");
  }
  Thread.sleep(3000);
  driver.findElement(By.xpath("(//span[@class=\"nav-arrow\"]/img)[2]")).click();
  Thread.sleep(3000);
  driver.findElement(By.xpath("//span[text()=\"My profile\"]")).click();
  Thread.sleep(3000);

  driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("gaurav12@gmail.com");
  Thread.sleep(3000);

  driver.findElement(By.xpath("//input[@name=\"date_of_birth\"]")).click();
  Thread.sleep(3000);
  WebElement month = driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]"));
  Select SC3 = new Select(month);
  SC3.selectByVisibleText("April");
  Thread.sleep(3000);
  
  WebElement year = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));
  Select SC4 = new Select(year);
  SC4.selectByVisibleText("2010");
  Thread.sleep(2000);
  
  driver.findElement(By.xpath("//div[text()=\"12\"]")).click();
  Thread.sleep(3000);
  
  Actions act = new Actions(driver);
  WebElement gender = driver.findElement(By.xpath("//input[@id=\"react-select-3-input\"]"));
  act.click(gender);
  act.sendKeys("Male").perform();
  act.sendKeys(Keys.ENTER).perform();
  
  Thread.sleep(3000);
  
  WebElement city = driver.findElement(By.xpath("//input[@id=\"react-select-4-input\"]"));
  act.click(city);
  act.sendKeys("Pune");
  act.sendKeys(Keys.ENTER).perform();
  
  Thread.sleep(3000);
  driver.findElement(By.xpath("//button[text()=\"Save\"]")).click();
  Thread.sleep(5000);
  
  JavascriptExecutor JS = (JavascriptExecutor)driver;
  JS.executeScript("document.documentElement.scrollTop=0", "");
  Thread.sleep(4000);
  
  String address = driver.findElement(By.xpath("(//p)[1]")).getText();
  if(address.equals("Pune, India")) {
   Assert.assertTrue(true);
  }
  else {
   Assert.assertTrue(false);
  }
 }
 
 
 @AfterMethod
 public void tearDown() throws InterruptedException{
  Thread.sleep(4000);
  driver.quit();
 }
}
