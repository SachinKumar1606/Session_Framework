package com.dataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExcelDataProvider {
    @DataProvider(name="DaTa")
    public Object[][] testData() throws IOException {

        DataTestNG ex =new DataTestNG();
        ex.data();
        int row = ex.a;
        int col = ex.b;
        System.out.println(row+"     "+col);
        Object[][] arr = new Object[row+1][2];
        for (int i=1;i<=row;i++){
                String data1= ex.getData(i,0);
                String data2= ex.getData(i,1);
                arr[i][0]= data1;
                arr[i][1] = data2;
                System.out.println(data1+"\t"+data2);
        }
        System.out.println(arr);
        arr[0][0]="standard_user";
        arr[0][1]="secret_sauce";
        return arr;
    }
    @Test(dataProvider = "DaTa")
    public void login(String name,String pass){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
        WebElement s = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String act = s.getText();
        driver.close();
        Assert.assertEquals(act,"PRODUCTS");

    }



}
