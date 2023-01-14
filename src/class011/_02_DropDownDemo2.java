package class011;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static utils.BaseClass.*;

public class _02_DropDownDemo2 {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        WebElement countryDD = driver.findElement(By.cssSelector("select[name='country']"));
        Select select =new Select(countryDD);

       //Note: Select class provides three different options(methods) to select a value from a drop-down

        //1- By Index
        select.selectByIndex(1);
        Thread.sleep(2000);

        //2-By value
        select.selectByValue("TR");
        Thread.sleep(2000);

        //3-By visible text
        select.selectByVisibleText("Canada");

        //Other way to select using Visible text (Still we use Select class, but not VisibleText() method
        final var countries = select.getOptions();
        for (int i = 0; i < countries.size(); i++) {
            if(countries.get(i).equals("Germany")){
                countries.get(i).click();
                break;
            }
        }

        tearDown();
    }
}
