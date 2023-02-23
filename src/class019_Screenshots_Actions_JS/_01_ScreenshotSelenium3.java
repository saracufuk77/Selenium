package class019_Screenshots_Actions_JS;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import utils.BaseClass;
import utils.ConfigsReader;

import java.io.File;
import java.io.IOException;

public class _01_ScreenshotSelenium3 extends BaseClass {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com/");


        //login to the web application
        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperties("username"));
        sendText(driver.findElement(By.id("txtPassword")),ConfigsReader.getProperties("password"));
        clickButwaitForClickability(driver.findElement( By.id("btnLogin")));


        //buraya wait ekeyecegiz ki, screenshot alindigi anda ekranda henuz gorunmeyen sekiller(yellow circle) gorunene kadar beklesin.
        //1.way: local explicit wait here
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.className("flot-overlay")));

        //2.way: use one of the wait functions from the Commonmethods.

        waitForPresenceOfElements(By.className("flot-overlay"));
        //waitForVisibiltyOfElement(By.className("flot-overlay"));

        //3.way
        wait(2);

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile,new File("screenshots/dashboard4.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Screenshot is not taken");
        }



        tearDown();
    }
}
