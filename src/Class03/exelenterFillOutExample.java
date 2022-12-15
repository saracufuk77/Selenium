package Class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class exelenterFillOutExample {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://exelenter.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@href='https://exelenter.com/contact/' and @class='elementor-item' and not(@tabindex ='-1')] ")).click();
        driver.findElement(By.id("form-field-email")).sendKeys("Ufuk");
        driver.findElement(By.id("form-field-field_613ea78")).sendKeys("Sarac");
        driver.findElement(By.id("form-field-field_bfaa16e")).sendKeys("us@gmail.com");
        driver.findElement(By.id("form-field-field_ac25300")).sendKeys("123456789");
        driver.findElement(By.id("form-field-field_733d017")).sendKeys("testing");
        //driver.findElement(By.xpath("//*[text() = 'Consult Today']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Consult')]")).click();
        Thread.sleep(2000);
        driver.quit();


    }
}
