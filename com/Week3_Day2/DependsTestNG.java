package com.Week3_Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DependsTestNG {

    WebDriver driver;
    SoftAssert soft =new SoftAssert();

    @BeforeSuite
    public void setup(){
        System.out.println("1");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
    }


    @Test
    public void login(){
        System.out.println("2");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test(dependsOnMethods = "login")
    public void checkLogin(){
        System.out.println("3");
        String act=driver.getCurrentUrl();
        String exp="https://www.saucedemo.com/inventory.html";
        soft.assertEquals(act,exp);
        soft.assertAll();
    }

    @Test(dependsOnMethods = "checkLogin")
    public void logout() throws InterruptedException {
        System.out.println("4");
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
    }

    @Test (dependsOnMethods = "logout")
    void checkLogout(){
        System.out.println("5");
        String exp = "https://www.saucedemo.com/";
        String act = driver.getCurrentUrl();
        soft.assertEquals(act,exp);
        soft.assertAll();
    }

    @AfterSuite
    void closeAll(){
        System.out.println("6");
        driver.quit();
    }

}
