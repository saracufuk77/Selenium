package class014_WindowHandle;

import org.openqa.selenium.WindowType;

import java.util.Set;

import static utils.BaseClass.*;

public class _02_windowHandle2 {
    public static void main(String[] args) {
        setUp("https://google.com");

        System.out.println("Parent window: " + driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.TAB);   // This will open a new BLANK TAB and switch (the focus) to it
        driver.get("https://about.google/");                    // This will open given URL in our new blank tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://store.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://exelenter.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");


        Set<String> allWindows = driver.getWindowHandles();                          // This will store all TABS in a Set of Strings
       // allWindows.forEach(System.out::println);

        switchToWindow("Store",allWindows);


        tearDown();
    }
    public static void switchToWindow(String windowTitle, Set<String> windows){
        for (String windowOrTab : windows) {
            String title = driver.switchTo().window(windowOrTab).getTitle();
            System.out.println("title = " + title);
            if(title.contains(windowTitle)){
                System.out.println("Window is found "+driver.getTitle()+ " URL is "+driver.getCurrentUrl());
                break;
            }

        }
    }

}
