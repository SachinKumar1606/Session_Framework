package com.Week3_Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Parallel_Execution {

    WebDriver driver, driver1;

    @Test (threadPoolSize = 10, invocationCount = 4, timeOut = 25000)
    public void launchChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://google.com");
        driver.quit();
    }

//    @Test
//    public void launchMozila(){
//        WebDriverManager.iedriver();
//        driver1 = new InternetExplorerDriver();
//        driver1.navigate().to("https://google.com");
//        driver1.close();
//    }

}
