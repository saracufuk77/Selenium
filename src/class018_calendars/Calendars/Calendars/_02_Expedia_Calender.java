package class018_calendars.Calendars.Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _02_Expedia_Calender {
    public static void main(String[] args) throws InterruptedException {
/*
Let's say we want to pick for
Depart: May 17th, 2023
Return: July 26th, 2023
 */
        setUp("https://www.expedia.com/Flights");

        String departDay = "01";
        String returnDay = "15";
        String departMonthandYear="August 2023";
        String returnmonthandYear="september 2023";

        //click on the departing button to pop up the calender
        //eger reklam gelirse ve tiklama yapmazsa, boslukta tiklatma yap. bosluk elementi sec ve tikla.
        driver.findElement(By.cssSelector("h1[class='uitk-heading uitk-heading-3']")).click(); // Click elsewhere for the alert to go away.
        driver.findElement(By.id("d1-btn")).click();

        //from the opened calendar find month and year and store it in a string
        String monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText();

        while (!monthAndYear.equals(departMonthandYear)){
            //wait(1) ekle buraya
            driver.findElement(By.xpath("//div[@class='uitk-calendar']//button[2]")).click(); //click on the next button
            monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText();
        }

        //once you are on the desired element (expected month and year), loop through the days and get text value.
        List<WebElement> days = driver.findElements(By.xpath("(//table[@class='uitk-date-picker-weeks'])[1]//button"));
        for (WebElement day : days) {
            if(day.getAttribute("data-day").equals(departDay)){
                System.out.println("Departing day is: "+day.getAttribute("data-day")+" of "+monthAndYear);
                day.click();
                break;
            }
        }

        //wait(1) ekle buraya
        Thread.sleep(1000);
        //selecting month and year for return
        while (!monthAndYear.equals(returnmonthandYear)){
            //wait(1) ekle buraya
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@class='uitk-calendar']//button[2]")).click(); //click on the next button
            monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText();
        }
        //selecting the day for return
        days = driver.findElements(By.xpath("(//table[@class='uitk-date-picker-weeks'])[1]//button"));
        for (WebElement day : days) {
            if(day.getAttribute("data-day").equals(returnDay)){
                System.out.println("Returning day is: "+day.getAttribute("data-day")+" of "+monthAndYear);
                day.click();
                break;
            }
        }

        //wait(1) ekle buraya
        Thread.sleep(1000);

        //once depart and return has been selected, then click Done button.
        driver.findElement(By.xpath("(//button[text()='Done'])[2]")).click();


        tearDown();
    }
}
