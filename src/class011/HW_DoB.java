package class011;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static utils.BaseClass.*;

public class HW_DoB {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://vitalets.github.io/combodate/");
        WebElement days = driver.findElement(By.xpath("(//select[@class='day '])[1]"));
        Select select = new Select(days);
//        final var listofdays = select.getOptions();



        WebElement months = driver.findElement(By.xpath("(//select[@class='month '])[1]"));
        Select select1= new Select(months);

        WebElement years = driver.findElement(By.xpath("(//select[@class='year '])[1]"));
        Select select2=new Select(years);

//        for (WebElement day : listofdays) {
//            if(day.getText().equals("12"))
//                day.click();
//        }

        if(select.isMultiple()) {
            select.selectByIndex(5);
        }
        if(select1.isMultiple()){
            select1.selectByValue("6");
        }

        if(select2.isMultiple()){
            select2.selectByValue("1977");
        }






        tearDown();

    }
}
