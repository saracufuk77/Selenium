package class019_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseClass;

import static utils.BaseClass.*;

public class _05_ActionKeyPress extends BaseClass {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Key Presses")).click(); //click on the Key Presses
        wait(1);

        WebElement inputField = driver.findElement(By.id("target"));  //Locate input fieldand store it in a web element

        Actions actions=new Actions(driver);
        inputField.sendKeys("A");
        wait(1);
        inputField.sendKeys(Keys.SPACE);
        wait(1);
        inputField.sendKeys("B");
        wait(1);
        inputField.sendKeys(Keys.BACK_SPACE); //Similar to backspace in windows, it will dleete the last character.
        wait(1);
        inputField.sendKeys("C");
        wait(1);
        inputField.sendKeys(Keys.ARROW_LEFT);
        wait(1);
        inputField.sendKeys(Keys.SPACE, Keys.SPACE,Keys.SPACE);
        wait(1);
        inputField.sendKeys(Keys.ARROW_RIGHT, Keys.SPACE);
        wait(1);
        inputField.sendKeys(Keys.SHIFT + "abc");  //combination pressing  of shift + letters ====> makes all letters capital


        tearDown();
    }
}
