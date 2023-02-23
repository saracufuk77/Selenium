package class019_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utils.BaseClass;

import java.time.Duration;

import static utils.BaseClass.*;

public class HW_ActionClass extends BaseClass {
    public static void main(String[] args) {
        setUp("https://exelenter.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //hover the element courses
        WebElement courses = driver.findElement(By.xpath("(//*[@class='ct-menu-item'])[3]"));

        Actions actions=new Actions(driver);
        actions.moveToElement(courses).perform();
        wait(1);

        driver.findElement(By.xpath("//*[@id='menu-item-9053']/a")).click(); //click Java-sdet

        //grab the title and print it
        String title = driver.findElement(By.xpath("//*[@class='ct-title1 style4']/h3")).getText();
        System.out.println(title);
        wait(1);

        //open a new tab and navigate to google
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://google.com");
        wait(1);

        //go to google and type "Exelenter" + space + title + enter
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Exelenter", Keys.SPACE,title,Keys.ENTER);
        wait(1);

        //just click the link which contains text "Exelenter" in its link.
        driver.findElement(By.partialLinkText("exelenter")).click();
        wait(1);

        //verify it is worked or not.
        String newTitle = driver.findElement(By.xpath("//*[@class='ct-title1 style4']/h3")).getText();
        if(newTitle.equals(title))
            System.out.println("Exelenter website is found and clicked successfully. Test passed");
        else
            System.out.println("Test Failed");

        tearDown();
    }
}
