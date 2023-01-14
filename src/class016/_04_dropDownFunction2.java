package class016;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;
import static utils.CommonMethods.clickDropDown;
import static utils.CommonMethods.*;

public class _04_dropDownFunction2 {
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        String expectedText = "April";

        //Method1: without Select class
        List<WebElement> listOfMonths = driver.findElements(By.cssSelector("select[name='Month'] option"));
        selectDdValue(listOfMonths,"July");

//        for (WebElement month : listOfMonths) {
//            String actualText = month.getText();
//            if (actualText.equals(expectedText)) {
//                month.click();
//                break;
//            }
//        }

        //Method2 : useing Select Class(If DD dropdown is build in Select class and has options; use this approach.)
        WebElement monthsDD = driver.findElement(By.cssSelector("select[name='Month']"));
        selectDdValue(monthsDD,"June");   //selecting by visibletext
        selectDdValue(monthsDD,5); // selecting by index

//        Select select =new Select(monthsDD);
//        List<WebElement> months = select.getOptions();
//        for (WebElement month : months) {
//            if(month.getText().equals(expectedText)){
//                select.selectByVisibleText(expectedText);
//                break;
//            }
//        }

        tearDown();
    }

}
