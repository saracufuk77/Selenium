package class012;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class _01_Alert_Demo {
    public static void main(String[] args) {
        setUp();   // switch to URL: https://selenium08.blogspot.com/2019/07/alert-test.html

        //How to handle simple alert?
        WebElement simpleAlert = driver.findElement(By.id("simple"));
        simpleAlert.click();

        //Question: What happens if we try to click another elemanet withour handling on alert first?
        //Answer: we will get an UnhandledAlertException
        //driver.findElement(By.xpath("//div[text()='Search']")).click();


        Alert alert = driver.switchTo().alert();  //we switch the focus of the web browser to the alert window
        String alertText = alert.getText();
        System.out.println("alertText = " + alertText);
        alert.accept();     //accept : OK

        tearDown();
    }
}
