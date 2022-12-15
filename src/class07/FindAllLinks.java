package class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindAllLinks {
    private static String url = "https://amazon.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //Find all the links existing links in a given website =====> answer: by using tagName
        final var alllinks = driver.findElements(By.tagName("a"));
        System.out.println("alllinks = " + alllinks.size());

        //count and the print all the links. do not print empty or blank links
        int count=0;
        for (WebElement alllink : alllinks) {
            final var alllinkText = alllink.getText();
            if(!alllinkText.isEmpty() && !alllinkText.isBlank()){
                System.out.println(alllinkText);
                count++;
            }
        }
        System.out.println("count = " + count);
        Thread.sleep(2000);
        driver.close();

    }
}