package class013.class015;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.Instant;

public class _07PageLoadTimOut {
    public static void main(String[] args) {
//        setUp("https://exelenter.com");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));

        Instant startTime = Instant.now();
        System.out.println("startTime = " + startTime);

        try {
            driver.get("https://amazon.com");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Too slow to Load");
        }


        Instant endTime = Instant.now();
        System.out.println("endTime = " + endTime);

        Duration pageLoadTime = Duration.between(startTime, endTime);
        System.out.println("pageLoadTime = " + pageLoadTime.toMillis());

        System.out.println(driver.getTitle());

        driver.quit();

//        tearDown();

    }

}
