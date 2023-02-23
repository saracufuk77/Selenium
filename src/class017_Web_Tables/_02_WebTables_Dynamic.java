package class017_Web_Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

import static utils.BaseClass.*;

public class _02_WebTables_Dynamic {
    public static void main(String[] args) {
        setUp("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");

        //first we need to login
        driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_password']")).sendKeys("test");
        driver.findElement(By.cssSelector("#ctl00_MainContent_login_button")).click();

        //Getting rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='SampleTable']//tr"));
        System.out.println("number if rows: "+rows.size());

        System.out.println("============print rows==============");
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }

        //If I do not want to print header
        System.out.println("==========print the rows without header==========");
        for (int i = 1; i < rows.size(); i++) {
            System.out.println(rows.get(i).getText());
        }

        // Printing columns
        List<WebElement> columns = driver.findElements(By.xpath("//table[@class='SampleTable']//tr[1]/th"));
        int NumOfTotalColumns = columns.size();
        System.out.println("NumOfTotalColumns = " + NumOfTotalColumns);


        tearDown();
    }
}
