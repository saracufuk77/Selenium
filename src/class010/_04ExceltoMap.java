package class010;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.asn1.x509.qualified.RFC3739QCObjectIdentifiers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class _04ExceltoMap {
    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/testData/EmployeeList.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = new XSSFWorkbook(fis);
        final var sheet1 = workbook.getSheet("Sheet1");

        //prerequisite: before start looping, identify the number of rows and columns

        int rows = sheet1.getPhysicalNumberOfRows();
        //System.out.println("rows = " + rows);
        int columns = sheet1.getRow(0).getLastCellNum();
        //System.out.println("columns = " + columns);

        Map<String,String> map = new LinkedHashMap<>();
        //for loop u 1 den baslatiyoruz cunku ilk row header ve biz onu loop un icinde manuel olarak alip key yapiyoruz.
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String key = sheet1.getRow(0).getCell(j).toString();
                String value = sheet1.getRow(i).getCell(j).toString();
                map.put(key, value);
            //    System.out.println(key+":   " + value);
            }
            // System.out.println();
            Set<Map.Entry<String,String>> entries = map.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                System.out.println(entry.getKey()+": "+entry.getValue());
            }
            System.out.println();
        }


    }
}
