package Class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsFacebook {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("WebDriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver =new ChromeDriver();

        //Navigate to Facebook
        driver.get("https://fb.com");

           Thread.sleep(2000);
        //pratice using locators to locate elemenets in Facebook
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("testpassword");
        Thread.sleep(2000);
        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);
      //  driver.findElement(By.className("_97w4")).click();
      //  driver.findElement(By.linkText("Forgot password?")).click();
      //  driver.findElement(By.partialLinkText("Forgot")).click();
        driver.findElement(By.partialLinkText("password")).click();
        driver.findElement(By.linkText("Forgot Account?")).click();

        Thread.sleep(2000);
       // driver.close();
        driver.quit();

    }
}
