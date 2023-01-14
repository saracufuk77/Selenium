package class014;

import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

import static utils.BaseClass.*;

public class _01_WindowHandleDemo {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://the-internet.herokuapp.com/windows");

        /*
        How to handle new TABS and new WiNDOWS in Selenium?
        * We have to methods for handling new tabs and windows
        *   1. getWindowHandle()  ==> handles main window only
        *   2. getWindowsHandle()  ==> handles All windows (or tabs)
         */

        String mainWindowTitle = driver.getTitle();
        System.out.println("mainWindowTitle = " + mainWindowTitle);

        String windowHandle = driver.getWindowHandle();    //this will return parent window unique id
        System.out.println("windowHandle = " + windowHandle);

        driver.findElement(By.linkText("Click Here")).click();
        System.out.println(driver.getTitle());    //which window title will print here

        Set<String> windowHandles = driver.getWindowHandles();  //this window return unique ID;s for all windows
        int allOpenWindows = windowHandles.size();
        System.out.println("allOpenWindows = " + allOpenWindows);

//        System.out.println(windowHandles);
        windowHandles.forEach(System.out::println);

        //here comes your iterator skills
        Iterator<String> iterator = windowHandles.iterator();
        String mainWindow = iterator.next();
        System.out.println("mainWindow = " + mainWindow);
        String childWindow = iterator.next();
        System.out.println("childWindow = " + childWindow);

        System.out.println("=============================");

        System.out.println("get title before switch"+driver.getTitle());
        driver.switchTo().window(childWindow);

        System.out.println("=========================");
        System.out.println("get title after the switch "+driver.getTitle());

        //if I call driver.close() in this lane, which window will close
        Thread.sleep(1000);
        driver.close();           //it should close child

        tearDown();
    }
}
