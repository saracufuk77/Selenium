package class011;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static utils.BaseClass.*;

public class _03_DropDown_Multiple {
    public static void main(String[] args) throws InterruptedException {
        setUp(); // use this URL https://selenium08.blogspot.com/2019/11/dropdown.html

        WebElement months = driver.findElement(By.cssSelector("select[name='Month']"));
        Select select = new Select(months);

        final var listOfMonths = select.getOptions();
        final var totalMonths = listOfMonths.size();

        System.out.println("totalMonths = " + totalMonths);

        //TASK: print all months using 1. for loop 2. enhanced loop 3. iterator loop

        for (int i = 1; i <listOfMonths.size() ; i++) {
            System.out.println(listOfMonths.get(i).getText());
        }

        System.out.println("========Enhanced Loop==============");

        for (WebElement month : listOfMonths) {
            System.out.println(month.getText());
        }

        System.out.println("========Iterator Loop==============");
        final var monthIterator = listOfMonths.iterator();
        while (monthIterator.hasNext()){
            System.out.println(monthIterator.next().getText());
        }

        //Task: print only a spesific (selected) months from the list

        System.out.println("========Selected Months==============");

        //1.way: without Select
//        for (WebElement month : listOfMonths) {
//            if(month.getText().equals("March") || month.getText().equals("May") || month.getText().equals("September")){
//                month.click();
//            }
//        }

        //2.way: using Select
        if(select.isMultiple()){
            select.selectByIndex(3);    //select march
            select.selectByVisibleText("May");     //select may
            select.selectByValue("Sept");      // select september
            Thread.sleep(2000);
            select.deselectByIndex(3);    //deselect march
            Thread.sleep(2000);
            select.deselectAll();      //deselect all
        }



        tearDown();
    }
}
