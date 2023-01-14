package class017_Web_Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;

public class _01_Recap_Wait_Types {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Dynamic Controls")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());

        WebElement button = driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"));
        System.out.println("button Text = " + button.getText());
        button.click();

        String message = driver.findElement(By.id("message")).getText();
        System.out.println("message = " + message);

        System.out.println("button Text2 = " + button.getText());
        button.click();
        message = driver.findElement(By.id("message")).getText();
        System.out.println("message2 = " + message);

        tearDown();

    }
}
