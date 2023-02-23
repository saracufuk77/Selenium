package class012_Alerts_PopUps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class _01_Alert_Demo {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://selenium08.blogspot.com/2019/07/alert-test.html");   // switch to URL: https://selenium08.blogspot.com/2019/07/alert-test.html

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

        Thread.sleep(2000);

        //handling confirmation error
        driver.findElement(By.cssSelector("button#confirm")).click();
        Alert confirmationAlert = driver.switchTo().alert();
        String confirmationAlerttext = confirmationAlert.getText();
        System.out.println("confirmationAlerttext = " + confirmationAlerttext);
        confirmationAlert.dismiss();            //dismiss=Cancel button

        Thread.sleep(2000);

        //Handling prompt alert
        driver.findElement(By.id("prompt")).click();
        Alert promptAlert = driver.switchTo().alert();
        String promtAlertText = promptAlert.getText();
        System.out.println("promtAlertText = " + promtAlertText);
        promptAlert.sendKeys("ufuk sarac");    //sending values to input text
        promptAlert.accept();                           //press ok button to close the alert

        String enteredText = driver.findElement(By.xpath("//div[contains(text(),'ufuk')]")).getText();
        System.out.println("enteredText = " + enteredText);

        String expectedText="ufuk";
        if(enteredText.contains("ufuk")){
            System.out.println(" text is added successfully. Test passed");  //happy path : olumlu testing, basarili olan testler
        }else
            System.err.println("Text is NOT added. Test failed");



        tearDown();
    }
}
