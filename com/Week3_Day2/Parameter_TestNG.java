package com.Week3_Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Parameter_TestNG {

    public static WebDriver driver;
    SoftAssert soft= new SoftAssert();
    @BeforeSuite
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
    }
    @Test
    @Parameters({"uname","pass"})
    void login(String uname,String pass){
        driver.findElement(By.id("user-name")).sendKeys(uname);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
    }
    @Test
    void check(){
        String exp = "https://www.saucedemo.com/inventory.html";
        String act = driver.getCurrentUrl();
        soft.assertEquals(act,exp);
        soft.assertAll();
    }
    @Test
    void logout() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
    }
    @Test
    void check2(){
        String exp = "https://www.saucedemo.com/";
        String act = driver.getCurrentUrl();
        soft.assertEquals(act,exp);
        soft.assertAll();
    }

    @AfterSuite
    void closeBrowser(){
        driver.quit();
    }

}
