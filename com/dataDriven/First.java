package com.dataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class First {
    WebDriver driver;
    String setup(String user, String pass){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).submit();
        String act = driver.getCurrentUrl();
        return act;

    }
    void close(){
        driver.quit();
    }
    void callMain() throws IOException, InterruptedException {
        //Reading the file path

        String path = System.getProperty("user.dir") + "/TestData/Login.xlsx";
        //Reading the Excel file
        FileInputStream file = new FileInputStream(path);
        //Reading the workBook
        XSSFWorkbook bk = new XSSFWorkbook(file);
        //Reading the sheet
        XSSFSheet sh = bk.getSheetAt(0);
        //printing the no of coloum in the sheets
        System.out.println(sh.getLastRowNum());
        //Reading the file data using for loop
        for(int i=1; i<=sh.getLastRowNum();i++){
            System.out.print(sh.getRow(i).getCell(0).getStringCellValue()+"\t");
            System.out.println(sh.getRow(i).getCell(1).getStringCellValue());
            sh.getRow(i).createCell(2).setCellValue("" +
                    "Data Fetch");
            FileOutputStream outFile =new FileOutputStream(path);
            bk.write(outFile);
            outFile.close();
        }
        for (int i = 1; i <= sh.getLastRowNum(); i++) {
            String user = sh.getRow(i).getCell(0).getStringCellValue();
            String pass = sh.getRow(i).getCell(1).getStringCellValue();
            String exp = sh.getRow(i).getCell(3).getStringCellValue();
            String act = setup(user, pass);
            FileOutputStream outFile =new FileOutputStream(path);
            if(exp.equals(act)){
                sh.getRow(i).createCell(4).setCellValue(act);
                sh.getRow(i).createCell(5).setCellValue("Test Case Pass");
                bk.write(outFile);
            }
            else{
                sh.getRow(i).createCell(4).setCellValue(act);
                sh.getRow(i).createCell(5).setCellValue("Test Case Fail");
//                FileOutputStream outFile =new FileOutputStream(path);
                bk.write(outFile);
            }


//            outfile.close();

            Thread.sleep(2000);
            close();
        }


    }
    void writeTo () throws IOException {
        //Reading the file path
            String path = System.getProperty("user.dir")+"/TestData/Login.xlsx";
        //Reading the Excel file
        FileInputStream file = new FileInputStream(path);
        //Reading the workBook
        Workbook wb = WorkbookFactory.create(file);
//                XSSFWorkbookFactory(file);

        //Get first sheet from the workbook.
        //If there have >1 sheet in your workbook, you can change it here IF you want to edit other sheets.
        Sheet sheet1 = wb.getSheetAt(1);
        FileOutputStream fos = new FileOutputStream(path);
        Row row = sheet1.getRow(0);
        for(int i=5; i<=10;i++){
            Cell column = row.createCell(i);
            column.setCellValue("I am active "+i);
            System.out.println(column.getStringCellValue());

            wb.write(fos);
        }
        fos.flush();

        fos.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        First obj = new First();
        obj.callMain();
//        obj.writeTo();
    }
}
