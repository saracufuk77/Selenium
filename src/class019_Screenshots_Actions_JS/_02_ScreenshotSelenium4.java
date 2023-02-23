package class019_Screenshots_Actions_JS;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import utils.BaseClass;
import utils.ConfigsReader;

import java.io.File;
import java.io.IOException;

public class _02_ScreenshotSelenium4 extends BaseClass {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com/");


        //login to the web application
        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperties("username"));
        sendText(driver.findElement(By.id("txtPassword")),ConfigsReader.getProperties("password"));
        clickButwaitForClickability(driver.findElement( By.id("btnLogin")));

        /*
        In selenium 4, we have 2 new methods for taking screenshots.
            *1.method : GetScreenshotAs();
            *2.method : getFullPageScreenshotAs();   ===========> this method is ONLY available with Firefox driver. Not chrome

        These methods are new to Selenium 4 and are not available in Selenium 3.
        Using these methods, we can take sceenshots in 2 different ways
            1. Section-level screenshots, specific to particular web element of the page
            2. Full-page screenshots, entire page

         */

        //How to take screenshot of particular, an element within a page
        WebElement quickLaunge = driver.findElement(By.className("quickLaungeContainer"));
        File sourceFile = quickLaunge.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(sourceFile,new File("screenshots/quickLaunge2.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to take screenshot");
        }


        tearDown();
    }
}
