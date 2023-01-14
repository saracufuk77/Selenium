package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//THIS CLASS IS USED TO LAUNCH AND QUIT THE BROWSER
public class BaseClass {
    public static WebDriver driver;
    public static void setUp(String url){
        //1.way : hard coding (not recommended)
        //System.setProperty("Webdriver.chrome.driver",Constants.CHROME_DRIVER_PATH);
        //WebDriver driver = new ChromeDriver();
        //driver.get(url);

        //2.way : Soft Coding (Recommended)
        // I need filePath

        ConfigsReader.loadProperties(Constants.CONFIGURATION_FILEPATH); // Replaced hard-coded filePath with Constants
        switch (ConfigsReader.getProperties("browser").toLowerCase()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
                driver = new FirefoxDriver();
            }
            default -> throw new RuntimeException("Browser is not supported");
        }

       // driver.get(ConfigsReader.getProperties("url"));
        driver.get(url);
        driver.manage().window().maximize();

    }

    public static void tearDown()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver != null) {     // This lline is optional. We only use it to prevent NullPointerException.
            driver.quit();
        }
    }

}
