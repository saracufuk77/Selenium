package Class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _04_TestCase01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver_win32/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        String title = driver.getTitle();
        System.out.println("title = " + title);
        if(title.equals("Amazon.com. Spend less. Smile more.")){
            System.out.println("Title is correct");
            //if we test the "test pass" cases, it is called positive testing. pass olmasini bekliyoruz.
        }else{
            //if we test the fail cases, it is called negative testing. fail olmasini bekliyoruz.
            System.out.println("Title is wrong");
        }
        driver.close();
    }
}
