package class018_calendars.Calendars.Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _01_Simple_Calender {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://demoqa.com/date-picker");

       //choose july 1 st, 1977
        //click on the date-picker field
        driver.findElement(By.cssSelector("#datePickerMonthYearInput")).click();

        //select months from the calender drop down
        WebElement monthDD = driver.findElement(By.xpath("//*[@class='react-datepicker__month-select']"));
        selectDdValue(monthDD,"July");

        //pick year
        WebElement yearDD = driver.findElement(By.xpath("//*[@class='react-datepicker__year-select']"));
        selectDdValue(yearDD,"1977");
        Thread.sleep(1000);

        //pick day
        List<WebElement> daysDD = driver.findElements(By.xpath("//*[@class='react-datepicker__week']/div"));
        selectDdValue(daysDD,"1");
        Thread.sleep(1000);

        //check it works or not?
        WebElement element = driver.findElement(By.cssSelector("#datePickerMonthYearInput"));
        String value = element.getAttribute("value");
        System.out.println("value = " + value);

        tearDown();
    }
}
