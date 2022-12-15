package Class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) {
        //1-Establish a connection with the driver/derivers
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver_win32/chromedriver.exe");
        //to get the path, right click on drivers and get the path

        //2-open the browser using the chrome driver's constructors
        WebDriver driver =new ChromeDriver();//Launch browser for us

        //Navigate to website
        driver.get("https://www.google.com");

        //Retrieve the title of current website and store it in a string
        String title=driver.getTitle();
        System.out.println("title = " + title);

        //got to website, retrieve the url and print it
        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);

        //quit() Close all browsers
        //close() Close only the active browser window
        driver.quit();

    }
}
