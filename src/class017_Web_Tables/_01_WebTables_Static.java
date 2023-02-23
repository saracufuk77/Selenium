package class017_Web_Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

import static utils.BaseClass.*;

public class _01_WebTables_Static {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(By.cssSelector("table#table1 tbody tr"));

        System.out.println("Number of rows: "+rows.size());

        for (WebElement row : rows) {
            System.out.println(row.getText());
        }

        System.out.println("===========printing another way========");

        Iterator<WebElement> iterator = rows.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getText());
        }

        System.out.println("=====Print number of columns");

        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']//th"));

        System.out.println("Number of Columns is: "+ columns.size());

        for (WebElement column : columns) {
            System.out.print(column.getText()+" | ");
        }


        tearDown();
    }
}
