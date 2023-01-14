package class014;

import org.openqa.selenium.By;

import java.util.Set;

import static utils.BaseClass.*;
/*
 *  Task: Go to this URL: https://the-internet.herokuapp.com/windows
 *     1. Identify and print parent window ID and Title
 *     2. Click on the link where it says 'Click Here' three times
 *     3. Switch to new tabs and print their title to the console as well.
 *          Bonus: Load facebook website in all children pages.
 */
public class _04_Task {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://the-internet.herokuapp.com/windows");
        String parentTitle = driver.getTitle();
        System.out.println("parentTitle = " + parentTitle);
        String parentWindow = driver.getWindowHandle();
        System.out.println("parentWindowID = " + parentWindow);

        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//a[@target='_blank']")).click();
            Thread.sleep(1000);
        }

        Set<String> allWindows = driver.getWindowHandles();
//        System.out.println(allWindows);

        for (String tab : allWindows) {
            if(!tab.contains(parentWindow)){
//                System.out.println("Child page title:  "+driver.switchTo().window(tab).getTitle());
                driver.switchTo().window(tab);    //if not parent, make a switch
                driver.get("https://fb.com");     //once you make a switch , load the given URL
                System.out.println("Child Page Title:   "+driver.getTitle());
            }
        }


        tearDown();

    }
}
