package class011_DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static utils.BaseClass.*;

public class _04_DropDown_ArrayList {
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        WebElement months = driver.findElement(By.cssSelector("select[name='Month']"));
        Select select = new Select(months);

        final var listOfMonths = select.getOptions();
        final var totalMonths = listOfMonths.size();

        // this is the list we are given for the test case, required for the company/project.
        //Let's assume customer wants to see these mentioned months in the application

        List<String> expectedList = new ArrayList<>();
        expectedList.add("March");
        expectedList.add("June");
        expectedList.add("November");
        expectedList.add("July");
        expectedList.add("December");

        //convert weblement list to a string list and then compare

        List<String> actualList=new ArrayList<>();
        for (WebElement month : listOfMonths) {
            actualList.add(month.getText());
        }

        if(actualList.containsAll(expectedList))
            System.out.println("test passed");
        else
            System.out.println("test failed");




        tearDown();
    }
}
