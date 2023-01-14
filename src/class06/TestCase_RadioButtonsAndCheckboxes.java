package class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
/*
TC 4.1: Selecting Colors:
Open the Chrome browser
Go to provided “URL” page where checkboxes are present
Loop through the list of elements and find Yellow & Orange colors
Select both and print their names to the console
Close the browser
 */
public class TestCase_RadioButtonsAndCheckboxes {
    private static String url = "https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        List<WebElement> colors = driver.findElements(By.cssSelector("input[name='color']"));

        for (WebElement color : colors) {
            String colorName = color.getAttribute("value");
            if(colorName.equalsIgnoreCase("yellow") || colorName.equalsIgnoreCase("orange")){
                color.click();
                    System.out.println(colorName);
            }
        }

        System.out.println("=====================");
//        for (WebElement color : colors) {
//            String colorName = color.getAttribute("value");
//            while (colorName.equalsIgnoreCase("yellow") || colorName.equalsIgnoreCase("orange")){
//                color.click();
//                System.out.println(colorName);
//                break;
//            }
//        }

        Thread.sleep(2000);
        driver.close();
    }
}
