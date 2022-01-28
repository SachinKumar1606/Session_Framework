package com.dataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DataFetch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://bbc.com");
        List<WebElement> list = driver.findElements(By.xpath("//a[@class='media__link']"));

        list.forEach(name->{
            System.out.println(name.getText());
        });


    }


}
