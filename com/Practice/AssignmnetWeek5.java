package com.Practice;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AssignmnetWeek5 {
    ArrayList<String> collection = new ArrayList<>();
    void collectData() throws IOException {
        String path = System.getProperty("user.dir") + "/TestData/testData.xlsx";
        //Reading the Excel file
        FileInputStream file = new FileInputStream(path);
        //Reading the workBook
        XSSFWorkbook bk = new XSSFWorkbook(file);
        //Reading the sheet
        XSSFSheet sh = bk.getSheetAt(0);
        //printing the no of coloum in the sheets
        System.out.println(sh.getLastRowNum());
        //Reading the file data using for loop
        for(int i=0; i<=sh.getLastRowNum();i++) {
            String word = sh.getRow(i).getCell(0).getStringCellValue();
            collection.add(word);
        }
        System.out.println(collection);
    }
    public void check() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the string: ");
        String s1 = sc.nextLine();
        for (String e : collection) {
            s1=s1.replace(e, "#####");
        }
        System.out.println(s1);
    }


    public static void main(String[] args) throws IOException {
        AssignmnetWeek5 obj = new AssignmnetWeek5();
        obj.collectData();
        obj.check();
    }
}
