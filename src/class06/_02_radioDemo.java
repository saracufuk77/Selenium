package class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _02_radioDemo {
    private static String url = "https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //go to website find mozilla and click it.
        driver.findElement(By.xpath("//input[@name='browser'][2]")).click();

        //go to website find mozilla and verify if it is 1. displayed, 2. Emabled, 3. Selected
        boolean displayed = driver.findElement(By.xpath("//input[@name='browser'][2]")).isDisplayed(); // true
        System.out.println("displayed = " + displayed);
        boolean enabled = driver.findElement(By.xpath("//input[@name='browser'][2]")).isEnabled();  // true
        System.out.println("enabled = " + enabled);
        boolean selected = driver.findElement(By.xpath("//input[@name='browser'][2]")).isSelected(); // true
        System.out.println("selected = " + selected);

        Thread.sleep(2000);
        driver.close();


    }
}
