package class010;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _02ReadFromExcel {
    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/testData/EmployeeList.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook =new XSSFWorkbook(fis);
        Sheet sheet1= workbook.getSheet("Sheet1");
        final var headerRow = sheet1.getRow(0);
        for (int i = 0; i <headerRow.getPhysicalNumberOfCells() ; i++) {
            System.out.println(headerRow.getCell(i));
        }

        System.out.println("QA?: " + sheet1.getRow(1).getCell(4));

        //total number of rows
        final var numberOfRows = sheet1.getPhysicalNumberOfRows();
        //total number of columns
        final var numofcols = sheet1.getRow(0).getLastCellNum();
        System.out.println("============================");
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numofcols; j++) {
                System.out.print(sheet1.getRow(i).getCell(j)+" ");
            }
            System.out.println(" ");
        }


    }
}
