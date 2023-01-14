package class013;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _03_Task {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://ui.vision/demo/webtest/frames/");

        //Task : go to frame 5 and get the text from the link and print it to the console and click on the link.

        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='frame_5.html']")));
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'https://')]"));
        System.out.println("webaddress = " + element.getText());

        Thread.sleep(2000);
        element.click();
        

        tearDown();

    }
}
