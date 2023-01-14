package class016;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;
import static utils.CommonMethods.clickButwaitForClickability;
import static utils.CommonMethods.clickRadioOrCheckBox;

public class _02_RadioAndCheckBoxFunctions2 {
    public static void main(String[] args) {
        setUp("https://demoqa.com/radio-button");
        WebElement noRadioBtn = driver.findElement(By.id("noRadio"));
        WebElement yesRadioBtn = driver.findElement(By.id("yesRadio"));
        boolean noRadiBtnEnabled = noRadioBtn.isEnabled();
        System.out.println("noRadiBtnEnabled = " + noRadiBtnEnabled);

        yesRadioBtn.click();
//        clickRadioOrCheckBox(noRadioBtn);
//        clickButwaitForClickability(yesRadioBtn);
//        clickRadioOrCheckBox(yesRadioBtn);

        tearDown();
    }


}
