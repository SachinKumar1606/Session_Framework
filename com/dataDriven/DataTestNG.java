package com.dataDriven;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class DataTestNG {

    public int a,b;
    FileInputStream file;
    XSSFWorkbook bk;
    XSSFSheet sh;

    public void data() throws IOException {
        String path = System.getProperty("user.dir") + "/TestData/Login.xlsx";
        System.out.println(path);
        //Reading the Excel file
        file = new FileInputStream(path);
        //Reading the workBook
        bk = new XSSFWorkbook(file);
        //Reading the sheet
        sh = bk.getSheetAt(0);
        a = sh.getLastRowNum();
        b = sh.getRow(0).getPhysicalNumberOfCells();

    }
    String getData(int row, int col){
        String data = sh.getRow(row).getCell(col).getStringCellValue();
        return data;
    }
}
