package Class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class radioButtons {
    private static String url="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
    private static String user="Tester";
    private static String pwd = "test";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get(url);
//      driver.findElement(By.cssSelector("input#ctl00_MainContent_username")).sendKeys("QAEngineer");
        WebElement username = driver.findElement(By.xpath("//input[contains(@id,'username')]"));
        Thread.sleep(1000);
        username.sendKeys("QAEngineer");
        username.clear();
        Thread.sleep(1000);
        username.sendKeys(user);
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys(pwd);
        Thread.sleep(1000);

        WebElement loginBttn = driver.findElement(By.cssSelector("input.button"));
        loginBttn.click();
        //loginBttn.submit();

        //verify login
        WebElement webOrdersLogo=driver.findElement(By.xpath("//*[td]//h1"));
        final var logoDisplayed = webOrdersLogo.isDisplayed();
        if (logoDisplayed){
            System.out.println("Logo is displayed. Test case passed");
        }else {
            System.out.println("Logo is not displayed. Test case failed");
        }

        //identify logged-in user on the dashboard page
        WebElement logedinUser= driver.findElement(By.cssSelector("div.login_info"));
        final var logedinUserText = logedinUser.getText();

        if (logedinUserText.contains(user)){
            System.out.println("Authorized user is able to longed in successfully. Test passed.");
        }else {
            System.out.println("Authorized user is NOT able to longed in successfully. Test failed");
        }
        System.out.println("logedinUserText = " + logedinUserText);

        Thread.sleep(1000);
        driver.close();
    }
}
