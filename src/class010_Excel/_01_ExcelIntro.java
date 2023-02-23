package class010_Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class _01_ExcelIntro {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\Owner\\Desktop\\poi1.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = new XSSFWorkbook(fis);
        final var sheet1 = workbook.getSheet("Sheet1");
        Row row = sheet1.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println("cell = " + cell);

        Row row1 = sheet1.getRow(2);
        Cell cell1 = row1.getCell(2);
        System.out.println("cell1 = " + cell1);

        System.out.println(sheet1.getRow(3).getCell(2));

        // Second way: Identifiying cell values based on data types using .getcelltypes() method
        final var r0c2cellType = sheet1.getRow(0).getCell(2).getCellType();
        System.out.println("r0c2cellType = " + r0c2cellType);

        final var stringCellValue = sheet1.getRow(0).getCell(2).getStringCellValue(); // .toString()
        System.out.println("stringCellValue = " + stringCellValue);

        // 1st way of the accessing cell value
        final var cellValue2 = sheet1.getRow(0).getCell(2);
        System.out.println("cellValue2 = " + cellValue2);

        //you caannot get String from Numeric of vice versa.if data type is mismatch you will get IllegalStateException
        System.out.println(sheet1.getRow(2).getCell(4).getCellType());
        //final var cellValue = sheet1.getRow(2).getCell(4).getStringCellValue();
        final var numericCellValue = sheet1.getRow(2).getCell(4).getNumericCellValue();
        System.out.println("numericCellValue = " + numericCellValue);

        //How to find total number of the columns
        final var lastCellNum = sheet1.getRow(0).getLastCellNum();
        System.out.println("lastCellNum = " + lastCellNum);

        //How to find the number of the rows
        System.out.println("number of rows: " + sheet1.getPhysicalNumberOfRows());

        //todo open new workbook and name it EmployeeList.xlsx


    }
}
