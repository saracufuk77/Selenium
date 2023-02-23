package class019_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.BaseClass;

public class _06_ActionKeyChord extends BaseClass {
    public static void main(String[] args) {
        setUp("https://google.com/");

        wait(1);
        driver.findElement(By.name("q")).sendKeys("Exelenter SDET");  //tek satirda da iki satirdada yapabilirsin
        wait(1);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

       //another and short way, 2nd way
        driver.navigate().back();
        wait(2);
        driver.findElement(By.name("q")).sendKeys("Exelenter SDET", Keys.ENTER);

        // another way, 3rd way
        driver.navigate().back();
        wait(2);
        driver.findElement(By.name("q")).sendKeys(Keys.chord("Exelenter SDET"),Keys.ENTER);

        tearDown();
    }
}
