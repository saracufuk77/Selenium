package class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constants;

public class xpathDemo {
    private static String url="https://exelentersdet.com/";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver",Constants.CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@name='txtPassword']")).sendKeys("Exelent2022Sdet!");
        driver.findElement(By.xpath("//*[@value='LOGIN']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Welcome')]")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//a[@href='/symfony/web/index.php/auth/logout']")).click();
        //driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
        //driver.findElement(By.xpath("//a[starts-with(text(),'Logout')]")).click();
       // driver.findElement(By.xpath(""))

        Thread.sleep(2000);
        driver.close();

    }
}
