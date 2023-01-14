package class013.class015;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.BaseClass.*;
/*
 *  HW: Explicit Wait
 *    1. Go to this URL: "https://the-internet.herokuapp.com/dynamic_loading/2"
 *    2. Click on the 'Start' button, it will load Hello World text after some time.
 *    3. Using Explicit Wait (NOT implicit) wait for the Hello World text to become available.
 *    4. Once the element is visible, grab it and print it to the console.
 *    5. Close the browser.
 *      Bonus: Use Try-Catch in case if your automation fails, but your browser still does close. (Intentionally fail it = Negative Testing).
 */
public class _04_Explicit_HW {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://the-internet.herokuapp.com/dynamic_loading/2");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40)); //implicit wait. dynamic wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));


        try {
            driver.findElement(By.cssSelector("div[id='start'] button")).click();
            //Thread.sleep(10); // static wait. even element is found in the 3 sc, we will be wasting 7 second
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish h4")));
            wait.until(ExpectedConditions.textToBe(By.cssSelector("div#finish h4"), "Hello World!"));
            System.out.println(driver.findElement(By.cssSelector("div#finish h4")).getText());

        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("Element is not found. wait longer for the element to become visible on the UI");
        }

        tearDown();

    }
}
