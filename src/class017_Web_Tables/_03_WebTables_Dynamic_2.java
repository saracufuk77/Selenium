package class017_Web_Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _03_WebTables_Dynamic_2 {
    public static void main(String[] args) throws InterruptedException {
        setUp("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");

        //first we need to login
        driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_password']")).sendKeys("test");
        driver.findElement(By.cssSelector("#ctl00_MainContent_login_button")).click();

        Thread.sleep(1000);

        //Get the rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='SampleTable']//tr"));
        int numOfRows = rows.size();

        //task: Selecting a spesific row and delete it.
        String expected_Value = "Charles Dodgeson";
        List<WebElement> actualValues = driver.findElements(By.xpath("(//table[@class='SampleTable']//tr/td[2])"));
        for (int i = 0; i < actualValues.size(); i++) {
            if(actualValues.get(i).getText().equals(expected_Value)){
                driver.findElement(By.xpath("(//input[@type='checkbox'])"+"["+(i+1)+"]")).click();
                Thread.sleep(1000);
                driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete")).click();
                Thread.sleep(1000);
                break;
            }
        }
        //Verify it is deleted or not
        List<WebElement> rows2 = driver.findElements(By.xpath("//table[@class='SampleTable']//tr"));
        int numOfRows2 = rows2.size();
        System.out.println("Number of rows before deletion: "+numOfRows);
        System.out.println("Number of rows after deletion: "+numOfRows2);
        if(numOfRows2==(numOfRows-1)){
            System.out.println("Deletion is successful.");
        }
        tearDown();
    }
}
