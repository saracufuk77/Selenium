package class019_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

public class _09_JSExecuterDemo2 extends BaseClass {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Large & Deep DOM")).click();
        wait(2);

        String script="arguments[0].scrollIntoView(true);";
       //1. way: using web element::this will take us directly to the table, scrolling based on the element location.
//        WebElement table = driver.findElement(By.id("large-table"));
//        ((JavascriptExecutor)driver).executeScript(script,table);

        //2. way: using exact coordinates:: scrolling based on exact coordinates where I want to move on the page
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(250,2650)");
        tearDown();
    }
}
