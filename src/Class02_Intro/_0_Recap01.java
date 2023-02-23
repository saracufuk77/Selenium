package Class02_Intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _0_Recap01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver_win32/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        //navigating amazon.com
        driver.get("https://amazon.com");
        //maximize it
        driver.manage().window().maximize();
        //make the windows full screen
        //driver.manage().window().fullscreen();
        
        String title= driver.getTitle();
        System.out.println("title = " + title);

        //driver.close();

    }
}
