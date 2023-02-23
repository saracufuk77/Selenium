package class019_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

public class _12_JSExecuterDemo4_Infinite_Scroll_Refactor extends BaseClass {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Infinite Scroll")).click();
        wait(2);

        scrollToParagraph(13);

        tearDown();
    }

    public static void scrollToParagraph(int index){
        String script ="window.scrollTo(0, document.body.scrollHeight)";
        var jsExecuter = (JavascriptExecutor) driver;

        while (getNumberOfParagraph()<index){
            jsExecuter.executeScript(script); //scroll down by one <p> i.e paragraph
        }
        System.out.println("No of paragraphs: "+ getNumberOfParagraph());
    }

    public static int getNumberOfParagraph(){
        List<WebElement> paragraphs = driver.findElements(By.className("jscroll-added"));
        return paragraphs.size();
    }
}
