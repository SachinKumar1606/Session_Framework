package com.Week3.Day1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.Week3.Day1.DemoTestNG1.driver;

public class DemoTestNG3 {
    @Test
    public void cart(){
        driver.findElement(By.className("shopping_cart_link")).click();

    }


    @Test
    public void validate(){
        String exp = "https://www.saucedemo.com/cart.html";
        String act= driver.getCurrentUrl();
        Assert.assertEquals(act,exp);
    }
}
