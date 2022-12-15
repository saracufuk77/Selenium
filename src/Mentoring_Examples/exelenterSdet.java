package Mentoring_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class exelenterSdet {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://exelentersdet.com/symfony/web/index.php/auth/login");
        String expectedString = "Exelenter Project";
        String actualString = driver.getTitle();
        if (actualString.equals(expectedString)) {
            System.out.println("You are on the right page");
        } else {
            System.out.println("wrong page");
        }

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement((By.id("txtPassword"))).sendKeys("Exelent2022Sdet!");
        Thread.sleep(2000);
       // driver.findElement(By.id("btnLogin")).click(); you can use both click or submit. sometimes one of them might not work
        driver.findElement(By.id("btnLogin")).submit();
        Thread.sleep(2000);

        String message = driver.findElement(By.xpath("//*[contains(text(),'Welcome')]")).getText();
        if (message.contains("Welcome")) {
            System.out.println("You loged in successfully");
        } else {
            System.out.println("You cannot logged in");
        }
        driver.close();
        String s = generateEmail();
        System.out.println(s);


    }

    public static String generateEmail() {
        Random random = new Random();

        String email = "";
        for (int i = 0; i < 7; i++) {
            int charRandom = random.nextInt(97, 123);
            email += (char) charRandom;
        }
        return email + "@gmail.com";
    }
}
