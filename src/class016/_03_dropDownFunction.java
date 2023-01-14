package class016;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;

public class _03_dropDownFunction {
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        String expectedText="June";
        List<WebElement> ListOfMonths = driver.findElements(By.xpath("//*[@name='Month']/option"));

        clickDropDown(ListOfMonths,expectedText);

//        for (WebElement month : ListOfMonths) {
//            String actualText = month.getText();
//            if(actualText.equals(expectedText)){
//                month.click();
//                break;
//            }
//        }

        tearDown();
    }

}
