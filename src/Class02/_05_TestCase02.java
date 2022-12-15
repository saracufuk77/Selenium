package Class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _05_TestCase02 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();


        driver.get("https://exelenter.com");
        Thread.sleep(2000);
        driver.navigate().to("https://google.com");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        String actualURL="https://exelenter.com";
        System.out.println("actualURL = " + actualURL);
        String expectedURL=driver.getCurrentUrl();
        System.out.println("expectedURL = " + expectedURL);

        if(expectedURL.contains( "ExeLEnTER".toLowerCase())){
            System.out.println("Test passed");
        }else System.out.println("Test failed");

        //another way to verify
        boolean exelenter=driver.getCurrentUrl().contains("exelenter".toLowerCase());
        System.out.println("test pass: " + exelenter);


        driver.quit();
    }
}
