package com.dataDriven;

import org.apache.poi.xssf.usermodel.*;

import java.io.*;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

        String[][] tabArray = null;

        try {

            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet
            String path = System.getProperty("user.dir") + "/TestData/Login.xlsx";
            ExcelWBook = new XSSFWorkbook(path);

            ExcelWSheet = ExcelWBook.getSheetAt(0);

            int startRow = 1;

            int startCol = 1;

            int ci,cj;

            int totalRows = ExcelWSheet.getLastRowNum();

            // you can write a function as well to get Column count

            int totalCols = 2;

            tabArray=new String[totalRows][totalCols];

            ci=0;

            for (int i=startRow;i<=totalRows;i++, ci++) {

                cj=0;

                for (int j=startCol;j<=totalCols;j++, cj++){

                    tabArray[ci][cj]=getCellData(i,j);

                    System.out.println(tabArray[ci][cj]);

                }

            }

        }

        catch (FileNotFoundException e){

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        catch (IOException e){

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return(tabArray);

    }

    public static String getCellData(int RowNum, int ColNum) throws Exception {

        try {

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            int dataType = Cell.getErrorCellValue();

            if (dataType == 3) {

                return "";

            } else {

                String CellData = Cell.getStringCellValue();

                return CellData;

            }
        }catch (Exception e){

                System.out.println(e.getMessage());

                throw (e);

            }

        }
}