package com.Week3.Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
    static WebDriver driver;
    @DataProvider (name="LoginDetails")
    public Object[][] login(){
        Object[][] arr = new Object[4][2];
        arr[0][0]="standard_user";
        arr[1][0]="locked_out_user";
        arr[2][0]="problem_user";
        arr[3][0]="performance_glitch_user";
        arr[0][1]="secret_sauce";
        arr[1][1]="secret_sauce";
        arr[2][1]="secret_sauce";
        arr[3][1]="secret_sauce";
        return arr;
    }

    @Test (dataProvider = "LoginDetails")
    void signToSwag(String uname, String pass){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(uname);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
        String exp="https://www.saucedemo.com/inventory.html";
        String act;
        act=driver.getCurrentUrl();
        Assert.assertEquals(act,exp);
        driver.close();
    }
}
