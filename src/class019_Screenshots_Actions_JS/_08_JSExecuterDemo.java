package class019_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import static utils.BaseClass.*;

public class _08_JSExecuterDemo extends BaseClass {
    public static void main(String[] args) {
        setUp("https://www.ebay.com");

        driver.findElement(By.linkText("Electronics")).click();
        wait(2);

        String script= "arguments[0].scrollIntoView(true);"; //This is JS script which can be copied from web

        WebElement popularCellPhones = driver.findElement(By.id("s0-27_1-9-0-1[4]-0-2-0-title"));
        ((JavascriptExecutor)driver).executeScript(script,popularCellPhones);  //we are scrolling down to "Popular Cell Phones"

        wait(2);
        WebElement shopByCategory = driver.findElement(By.id("s0-27_1-9-0-1[1]-0-2-0-title"));
        ((JavascriptExecutor)driver).executeScript(script,shopByCategory);  //we are scrolling up to "Shop By Category" section

        wait(2);
        //we click on video games category
        driver.findElement(By.xpath("(//*[@class='b-visualnav__img b-visualnav__img__default'])[6]")).click();


        tearDown();
    }
}
