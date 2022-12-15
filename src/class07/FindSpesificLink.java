package class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/*
TC 4.3: Print visible links from the Exelenter Homepage
     1. Open the Chrome browser
     2. Go to Exelenter Website
     3. Iterate through the links until you find "Enroll Now"
     4. Once expected keyword is found, print it and exit
     5. Close the browser
 */
public class FindSpesificLink {

    static String expectedtext="Contact";
    private static String url = "https://exelenter.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(2000);

        //find all links in Exelenter
        final var allLinksExelenter = driver.findElements(By.tagName("a"));
        System.out.println("number of links"+allLinksExelenter.size());
        int totalLinksExelenter=allLinksExelenter.size();
        System.out.println("totalLinksExelenter = " + totalLinksExelenter);


        for (WebElement link : allLinksExelenter) {
            String linkText=link.getText();
            if(!linkText.isEmpty()){
                System.out.println(linkText);
            }

            if(linkText.contentEquals(expectedtext)){
                System.out.println("Expected text is found: "+linkText);
                break;
            }
        }

        Thread.sleep(2000);
        driver.close();
    }

}