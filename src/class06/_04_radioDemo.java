package class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class _04_radioDemo {
    private static String url = "https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //we are retrieveing the list of the elements
        List<WebElement> browsers = driver.findElements(By.xpath("//input[@name='browser']"));

        //get the size of the browsers lists
        int browsersCount = browsers.size();
        System.out.println("browsersCount = " + browsersCount);

        //Iterate thorough the list and print them in the console
        //Regular Loop
        int count=1;
        for (int i = 0; i < browsers.size(); i++) {
            String attributeValue = browsers.get(i).getAttribute("value");
            System.out.println(count+". " + attributeValue);
            count++;
        }
        System.out.println("************************");
        //Enhanced Loops
        for (WebElement browser : browsers) {
            System.out.println(browser.getAttribute("value"));
        }
        System.out.println("=================================");
        //Select only element which are only enabled but not selected
        for (WebElement browser : browsers) {
            if(browser.isEnabled() && !browser.isSelected()){
                System.out.println(browser.getAttribute("value"));
            }
        }

        System.out.println("++++++++++++++++++++++++++");

        //Loop through the web elements and when find the Opera is found, click on it.
        for (WebElement browser : browsers) {
            if(browser.getAttribute("value").equals("Opera")){
                browser.click();
                System.out.println("Opera is found and clicked");
                break;
            }
        }

        Thread.sleep(2000);
        driver.close();


    }
}
