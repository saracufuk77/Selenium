package class013.class015;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.BaseClass.*;

/*
 *  Task: Get the text from a link which will load a paragraph when you click on it.
 *    1. Go to this URL: http://uitestpractice.com/Students/Contact
 *    2. Click on the link where it says 'This is a Ajax link'
 *    3. First use without wait, handle the exception, should say "Element is not found, Please wait longer for element to become visible".
 *    4. Wait for its content to load and retrieve the text from it and print it to the console.
 */
public class _03_ExplicitWait {
    public static void main(String[] args) {
        setUp("http://uitestpractice.com/Students/Contact");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));  // Explicit is not global. waits for a specific condition of element
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // this is a GLOBAL wait. Applies entire elements in the class
//        driver.manage().window().maximize();   // element exception error baska elemanla cakistigi icin cikmisti. maksimize ederek cozuldu. her seferinde maks yapmamak icin base class a maximize ekledik.
        try {
            driver.findElement(By.linkText("This is a Ajax link")).click();
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ContactUs p")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.ContactUs p")));
            System.out.println(driver.findElement(By.cssSelector("div.ContactUs p")).getText());
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("Element is not found, Please wait longer for element to become visible ");
        }
        tearDown();
    }
}
