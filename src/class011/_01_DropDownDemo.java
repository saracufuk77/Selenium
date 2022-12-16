package class011;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;
/*
1-extend edebiliriz.
2-baselClass.Setup diye direk yazabiliriz
3-yukaridaki gibi yapabiliriz
 */

public class _01_DropDownDemo {
    public static void main(String[] args) throws InterruptedException {
        setUp();

        List<WebElement> countries = driver.findElements(By.cssSelector("select[name='country']"));
        for (WebElement country : countries) {
            System.out.println(country.getText());
        }

        //second way: using css selector
        WebElement countryDD = driver.findElement(By.cssSelector("select[name='country']"));
        Select select =new Select(countryDD);

        //get the size of the dropdown
        final var countriesList = select.getOptions();
        System.out.println("Total number of countries: "+ countriesList.size());

        //loop through all countries using their index
        for (WebElement country : countriesList) {
                country.click();
                if(country.getText().equals("Turkey")){
                    country.click();
                    break;
                }
        }

            Thread.sleep(50);


//        for (int i = 0; i < countriesList.size(); i++) {
//            countriesList.get(i).click();
//            Thread.sleep(50);
//        }

         tearDown();
    }
}
