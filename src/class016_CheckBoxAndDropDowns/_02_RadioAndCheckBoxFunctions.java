package class016_CheckBoxAndDropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _02_RadioAndCheckBoxFunctions {
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");

        //Loop through all colors and select and click on green color
        List<WebElement> colorsList = driver.findElements(By.name("color"));
        List<WebElement> browserList = driver.findElements(By.name("browser"));

        String expectedValue="green";
        String expectedValue2="Mozilla";

//        for (WebElement color : colorsList) {
//            if(color.getAttribute("value").equals(expectedValue)){
//                color.click();
//                break;
//            }
//        }

        clickRadioOrCheckBox(colorsList,expectedValue);
        clickRadioOrCheckBox(browserList,expectedValue2);

        tearDown();
    }


}
