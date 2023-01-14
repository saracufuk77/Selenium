package class014;

import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

import static utils.BaseClass.*;


public class _03_windowHandle {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://demoqa.com/browser-windows");

        String parentWindowTitle = driver.getTitle();
        System.out.println("parentWindowTitle = " + parentWindowTitle);
        String parentWindow = driver.getWindowHandle();
        System.out.println("parentWindow = " + parentWindow);

        for (int i = 0; i < 3; i++) {
//            driver.findElement(By.id("tabButton")).click();   //open a new tab
            driver.findElement(By.id("windowButton")).click();  //Open a new window
            Thread.sleep(1000);
        }


        Set<String> allWindows = driver.getWindowHandles();

        for (String windowOrTab : allWindows) {
            driver.switchTo().window(windowOrTab);
            driver.get("https://google.com");
            System.out.println("window ID = " + windowOrTab+ "Title = "+ driver.getTitle());
            Thread.sleep(1000);
        }

        System.out.println("======================================");
        // With Iterator
        Iterator<String> iterator = allWindows.iterator();
        while (iterator.hasNext()){
            String windowOrTab = iterator.next();
            driver.switchTo().window(windowOrTab);
            System.out.println("Window ID: "+windowOrTab+" URL: "+driver.getCurrentUrl());
            Thread.sleep(1000);
        }

        tearDown();
    }
}
