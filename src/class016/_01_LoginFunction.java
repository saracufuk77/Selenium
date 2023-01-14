package class016;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ConfigsReader;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;


/**
 *  Note: This is our BANK, for reusing the methods elsewhere in the framework when we need it.
 *   We store all common methods for usability here. This will help us to avoid DRY principle of programming/coding.
 */
public class _01_LoginFunction {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com");

        //this is regular, without function, direct access, locate and use.
//        WebElement username = driver.findElement(By.id("txtUsername"));
//        username.sendKeys("Admin");

        //Second way, with function
        WebElement username = driver.findElement(By.id("txtUsername"));
//        sendKeys(username,"Admin");
        sendText(username, ConfigsReader.getProperties("username"));

        WebElement password = driver.findElement(By.id("txtPassword"));
        sendText(password,ConfigsReader.getProperties("password"));

        WebElement loginBtn = driver.findElement( By.id("btnLogin"));
//        CommonMethods.click(loginBtn);
        clickButwaitForClickability(loginBtn);


        tearDown();
    }

}
