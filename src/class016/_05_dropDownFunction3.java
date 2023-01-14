package class016;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;
public class _05_dropDownFunction3 {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://vitalets.github.io/combodate/");

        WebElement dayDD = driver.findElement(By.xpath("(//select[@class='day '])[1]"));
        WebElement monthDD = driver.findElement(By.xpath("(//select[@class='month '])[1]"));
        WebElement yearDD = driver.findElement(By.xpath("(//select[@class='year '])[1]"));

        //Go and selecet March 20, 2014
        selectDdValue(dayDD,"20");
        selectDdValue(monthDD,3);
        selectDdValue(yearDD,"2014");

        Thread.sleep(2000);
        //let's assume dropdwn does not have Class tag, how would you locate and select dates from it?
        List<WebElement> daysDD = driver.findElements(By.xpath("(//select[@class='day '])[1]/option"));
        selectDdValue(dayDD,"17");



        tearDown();
    }
}
