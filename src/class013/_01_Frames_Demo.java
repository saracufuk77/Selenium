package class013;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class _01_Frames_Demo {
    public static void main(String[] args) throws InterruptedException {
        setUp("http://www.uitestpractice.com/Students/Switchto");

        System.out.println(driver.findElement(By.xpath("//*[contains(text(),'2022')]")).getText());

        //trying to sent SDET to the frame's input text box
        // before interacting with a frame, first we need switcth to it, then take action. Otherwise we get an exception.
        /*
        *we can switch to a frame using three different methods
        * 1-by index
        * 2-by ID or Name
        * 3-by webelement of the frame/iframe
         */

        //1- By Index
        driver.switchTo().frame(0);
        WebElement textbox = driver.findElement(By.id("name"));
        textbox.sendKeys("SDET");

        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//*[contains(text(),'2022')]")).getText());

        Thread.sleep(2000);

        //2-By ID or Name

        driver.switchTo().frame("iframe_a");
        textbox.clear();
        textbox.sendKeys("QA Engineer");
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        //3-By Frame Web element
        WebElement frame = driver.findElement(By.cssSelector("iframe[src='/Demo.html']"));// here we identify web element ans store it
        driver.switchTo().frame(frame);    //switch to frame by its element
        textbox.clear();
        textbox.sendKeys("Frame by Webelement");


        tearDown();
    }
}
