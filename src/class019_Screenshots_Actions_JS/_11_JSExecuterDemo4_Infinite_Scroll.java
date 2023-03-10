package class019_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

public class _11_JSExecuterDemo4_Infinite_Scroll extends BaseClass {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Infinite Scroll")).click();
        wait(2);
//        "window.scrollTo(0, document.body.scrollHeight)"
        List<WebElement> paragraphs = driver.findElements(By.className("jscroll-added"));
        JavascriptExecutor jsExecuter = (JavascriptExecutor) driver;
        String script ="window.scrollTo(0, document.body.scrollHeight)";

        while(paragraphs.size()<25){
            jsExecuter.executeScript(script);
            paragraphs = driver.findElements(By.className("jscroll-added"));
        }
        System.out.println("No of paragraphs: "+paragraphs.size());
        wait(2);

        //after scrolling down for certain number paragraphs, we are scrolling back to the top of the page using below code
        jsExecuter.executeScript("window.scrollBy(0,-document.body.scrollHeight || -document.documentElement.scrollHeight)","");

        tearDown();
    }
}
