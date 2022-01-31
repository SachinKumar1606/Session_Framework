package com.dataDriven;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class DataDrivenTestNG {
    static WebDriver driver;

    @DataProvider(name = "LoginDetails")
    public Object[][] login() throws IOException {
        String path = System.getProperty("user.dir") + "/TestData/Login.xlsx";
        System.out.println(path);
        //Reading the Excel file
        FileInputStream file = new FileInputStream(path);
        //Reading the workBook
        XSSFWorkbook bk = new XSSFWorkbook(file);
        //Reading the sheet
        XSSFSheet sh = bk.getSheetAt(0);
        //printing the no of coloum in the sheets
        int i = sh.getLastRowNum();
//        int j = sh.getRepeatingColumns().getLastColumn();

        Object[][] arr = new Object[i][2];
        for (int a = 0; a <= i; a++) {
            arr[a][0] = sh.getRow(a).getCell(0).getStringCellValue();
            arr[a][1] = sh.getRow(a).getCell(1).getStringCellValue();
        }
        System.out.println(arr[1][0]);
        return arr;
    }

    @Test(dataProvider = "LoginDetails")
    public void signToSwag(String uname, String pass) {
        System.out.println(uname + "\t" + pass);
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to("https://www.saucedemo.com/");
//        driver.findElement(By.id("user-name")).sendKeys(uname);
//        driver.findElement(By.id("password")).sendKeys(pass);
//        driver.findElement(By.id("login-button")).click();
//        String exp="https://www.saucedemo.com/inventory.html";
//        String act;
//        act=driver.getCurrentUrl();
//        Assert.assertEquals(act,exp);
//        driver.close();
    }
}
