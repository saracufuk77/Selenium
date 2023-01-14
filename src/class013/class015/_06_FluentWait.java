package class013.class015;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static utils.BaseClass.*;

public class _06_FluentWait {
    public static void main(String[] args) {
        setUp("https://omayo.blogspot.com/");

        FluentWait<WebDriver> fluentWait =new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(15));  //wait for up to 15 seconds
        fluentWait.pollingEvery(Duration.ofSeconds(1)); //keep checking for the presenece of elements in every 1 seconds. Normally IntellJ do it in every 500 miliseconds.
        fluentWait.ignoring(NoSuchElementException.class); //do not Throw exception until max time (15 secondes ) is reached.

        driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Facebook")));
        driver.findElement(By.linkText("Facebook")).click();


        tearDown();
    }
}
