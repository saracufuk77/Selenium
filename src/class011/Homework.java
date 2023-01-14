package class011;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

/*
1. Go to https://the-internet.herokuapp.com/
2. Find the Checkboxes link, click on it
3. Once you are on the Checkboxes homepage you will see two Checkboxes:
      - checkbox 1
      - checkbox 2

  4. Using your Selenium knowledge. Please check and verify if each checkbox is:
        1. isDisplayed (True or False) ?
        2. isEnabled (T or F) ?
        3. isSelected (T or F) ?

5. Print the results to the console.
6. Exit the browser.
 */
public class Homework {
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        WebElement checkboxMenu = driver.findElement(By.xpath("//ul/li[6]/a"));
        checkboxMenu.click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
        for (int i = 0; i < checkboxes.size(); i++) {
            if(checkboxes.get(i).isDisplayed()){
                System.out.println("checkbox"+(i+1)+ " is displayed");
            }else{
                System.out.println("checkbox"+(i+1)+ " is not displayed");
            }
        }
        System.out.println("=======================");
        for (int i = 0; i< checkboxes.size(); i++) {
            if(checkboxes.get(i).isEnabled()){
                System.out.println("checkbox"+(i+1)+ " is enabled");
            }else{
                System.out.println("checkbox"+(i+1)+ " is not enabled");
            }
        }
        System.out.println("=========================");
        for (int i = 0; i < checkboxes.size(); i++) {
            if(checkboxes.get(i).isSelected()){
                System.out.println("checkbox"+(i+1)+ " is selected");
            }else{
                System.out.println("checkbox"+(i+1)+ " is not selected");
            }
        }
        tearDown();
    }
}
