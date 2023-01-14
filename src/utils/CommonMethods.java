package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static utils.BaseClass.*;

public class CommonMethods {
    /**
     * Method will switch focus to next window/tab based on the window title/name
     * @param windowTitle String
     */
    public static void switchToWindow(String windowTitle) {
        Set<String> windows = driver.getWindowHandles();
        for (String windowOrTab : windows) {
            String title = driver.switchTo().window(windowOrTab).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Window is found! Page Title: " + driver.getTitle() + " URL: " + driver.getCurrentUrl());
                break;
            }
        }
    }
    public static void sendText(WebElement element, String value) {
        element.sendKeys(value);
    }

    public static void click(WebElement element){
        element.click();
    }

    public static WebDriverWait waitForElement(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
        return wait;
     }

    public static void waitForClickability(WebElement element){
        waitForElement().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickButwaitForClickability(WebElement element){
        waitForClickability(element);
        element.click();
    }

    public static void waitForVisibilty(WebElement element){
        waitForElement().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForVisibilty(By by){
        waitForElement().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void clickButWaitForVisibility(WebElement element){
        waitForVisibilty(element);
        element.click();
    }

    public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckBox, String expectedValue){
        for (WebElement element : radioOrCheckBox) {
            String actualValue = element.getAttribute("value");
            if(actualValue.equals(expectedValue)){
                element.click();
                break;
            }
        }
    }

    public static void clickRadioOrCheckBox(WebElement element){
        if(element.isEnabled() && !element.isSelected()){
            element.click();
        }

    }

    public static void clickDropDown(List<WebElement> dropDownList, String expectedValue){
        for (WebElement element : dropDownList) {
            String actualText = element.getText();
            if(actualText.equals(expectedValue)){
                element.click();
                break;
            }
        }
    }

    public static void selectDdValue(WebElement element, String expectedvalue) {
        Select select =new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if(option.getText().equals(expectedvalue)){
                select.selectByVisibleText(expectedvalue);
                break;
            }
        }
    }

    /**
     * Method select dropdown
     * @param dropDownList WebElement
     * @param expectedvalue String
     */
    public static void selectDdValue(List<WebElement> dropDownList, String expectedvalue) {
        for (WebElement element : dropDownList) {
            String actualText = element.getText();
            if (actualText.equals(expectedvalue)) {
                element.click();
                break;
            }
        }
    }

    /**
     * Method will select a dropdown or multi-select by index
     * @param element WebElement
     * @param index int
     */
    public static void selectDdValue(WebElement element, int index){
        Select select = new Select(element);
//        List<WebElement> options = select.getOptions();
        select.selectByIndex(index);
        // burada try catch ile outofbounderror u hallet. 
    }

}
