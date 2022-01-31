package com.Week3.Day1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestNG2 extends  DemoTestNG1{
    @Test
    void login(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    void valid(){
        String exp="https://www.saucedemo.com/inventory.html";
        String act;
        act=driver.getCurrentUrl();
        Assert.assertEquals(act,exp);
    }

}
