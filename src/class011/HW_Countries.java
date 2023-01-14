package class011;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static utils.BaseClass.*;

public class HW_Countries {
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");
        WebElement countryDD = driver.findElement(By.cssSelector("select[name='country'"));
        Select select =new Select(countryDD);

        //1 st way using select class
        //select.selectByVisibleText("United States of America");

        //2 nd way using loop
        final var listOfCountries = select.getOptions();

//        for (WebElement country : listOfCountries) {
//            if(country.getText().equals("United States of America")){
//                country.click();
//                System.out.println("USA is found and selected");
//                break;
//            }
//        }

        //3 rd way

        for (WebElement country : listOfCountries) {
            if (!country.getText().equals("Morocco")){
                country.click();
            }else{
                country.click();
                System.out.println("found: "+country.getText());
                break;
            }
        }

        tearDown();
    }
}
