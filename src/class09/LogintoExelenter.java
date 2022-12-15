package class09;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LogintoExelenter {
    public static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {
        String filePath = System.getProperty("user.dir") + "/configs/configuration.properties";
        FileInputStream fis =new FileInputStream(filePath);
        Properties properties = new Properties();
        properties.load(fis);

        final var browser = properties.getProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe");
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.geckodriver.driver", "drivers/geckodriver.exe");
                //bunun gecko driver in da sorun oldu, calismadi. Gecko driver i msedge ile degistirdik calisti. interesting but true
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                System.setProperty("webdriver.msedgedriver.driver", "drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            }
        }
        driver.get(properties.getProperty("url"));



        Thread.sleep(2000);
        driver.close();
    }
}
