package class014_WindowHandle;

import org.openqa.selenium.WindowType;

import static utils.BaseClass.*;

public class _02_windowHandle {
    public static void main(String[] args) {
        setUp("https://google.com");
        System.out.println("Parent Window: "+ driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.TAB); //this will open a new blank tab and switch to it
        driver.get("https://about.google");     //this will open URL in our new blank tab

        tearDown();

    }
}
