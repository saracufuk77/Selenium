package class012_Alerts_PopUps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class _04_Upload_Files {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://the-internet.herokuapp.com/upload");

        /*
        *How do we uploads files using the selenium?
        * 1. Specify the location - get full path of the file you are about to upload
        * 2. locate web element for "Choose File" button, and using sendkeys() method. send the location/full path of the file
        * 3. locate upload button element and click it to upload your file.
        *
        *   This way we bypass window popup which is not supported by Selenium.
         */

        //step 1: find the full path of the file and store it in a string
        String filepath = "C:\\Users\\Owner\\Desktop\\seleniumCourse\\file_upload.png";

        //step2: locate web element for the "choose file" button
        driver.findElement(By.id("file-upload")).sendKeys(filepath);

        //step3: locate web element for "submit" or "upload" button and click on it
        driver.findElement(By.id("file-submit")).click();

        //step4: let's verify the file was uploaded or not
        WebElement fileUploadConfirmation = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));

        if(fileUploadConfirmation.isDisplayed())
            System.out.println("File is uploaded successfully");
        else
            System.out.println("File is NOT uploaded");

        

        Thread.sleep(2000);

        tearDown();

    }
}
