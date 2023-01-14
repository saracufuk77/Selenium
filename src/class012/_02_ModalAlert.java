package class012;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class _02_ModalAlert {
    public static void main(String[] args) {
        setUp("https://demoqa.com/modal-dialogs"); //switcth  to URL = https://demoqa.com/modal-dialogs
        WebElement modalAlert = driver.findElement(By.cssSelector("button[class='mr-4 mt-2 btn btn-primary']"));//find we element or modal alert type (HTML based alert)
        modalAlert.click();                 //click to trigger. launch it
        System.out.println(modalAlert.getText());

        WebElement modalBody = driver.findElement(By.xpath("//*[@class='modal-body']"));
        System.out.println(modalBody.getText());

        driver.findElement(By.xpath("//button[text()='Close']")).click(); // I am closing the modal by clicking the close button




        tearDown();

    }
}
