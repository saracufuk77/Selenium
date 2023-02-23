package class019_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseClass;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _04_ActionClassDemo extends BaseClass {
    public static void main(String[] args) throws AWTException {
        setUp("https://www.ebay.com/");
        WebElement myEBay = driver.findElement(By.linkText("My eBay"));

        Actions actions =new Actions(driver);
        actions.moveToElement(myEBay).perform();

        //once you hover over an element, now you can verify anything on that page/dropdown
        String summaryText = driver.findElement(By.xpath("(//*[@class='gh-eb-oa thrd'])[1]")).getText();
        if(summaryText.contains("Summary")){
            System.out.println("Hover over 'My Ebay' worked ");
        }
        else
            System.out.println("Hover did not work.");

        WebElement electronicsMenu = driver.findElement(By.linkText("Electronics"));
        actions.moveToElement(electronicsMenu).perform(); //Hover on Electronics menu
        wait(1);
        actions.contextClick(electronicsMenu).perform(); //right clcik on lectronics menu
        wait(1);
        //electronicsMenu.sendKeys(Keys.ESCAPE);        //for some reason this escape did not worke
        //actions.sendKeys(Keys.ESCAPE).perform();     //for some reason this escape did not worke

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        wait(1);

        driver.navigate().to("https://demoqa.com/buttons"); // Naviate to another new website
        wait(1);

        actions.doubleClick(driver.findElement(By.cssSelector("#doubleClickBtn"))).perform(); //here we are locating DoubleClick Me button
        System.out.println(driver.findElement(By.id("doubleClickMessage")).getText());

        //click on the "Right Click Me" button and print its text message to the console
        actions.contextClick(driver.findElement(By.id("rightClickBtn"))).perform();
        System.out.println(driver.findElement(By.id("rightClickMessage")).getText());

        wait(1);
        tearDown();
    }
}
