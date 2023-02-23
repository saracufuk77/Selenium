package class017_Web_Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ConfigsReader;

import java.util.List;

import static utils.BaseClass.*;
import static utils.BaseClass.driver;
import static utils.CommonMethods.clickButwaitForClickability;
import static utils.CommonMethods.sendText;
/**
 * HW: Test Case: Add and then Delete added employee from the table
 * 1. Open Chrome Browser
 * 2. Navigate to URL www.exelentersdet.com
 * 3. Login to the website (Credentials are in your Properties file)
 * 4. Add an employee
 * 5. Verify employee has been added (By retrieving Employee ID).
 * 6. Go to Employee list
 * 7. Delete added employee (By employee ID - ID is unique, could be multiple employees with same name)
 * 8. Quit the browser
 */
public class _05_HW_AddandDeleteEmployee {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://www.exelentersdet.com");

        String firstname="Mehmet";
        String lastname="Ali";
        //Login to web application
        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperties("username"));
        sendText(driver.findElement(By.id("txtPassword")),ConfigsReader.getProperties("password"));
        clickButwaitForClickability(driver.findElement( By.id("btnLogin")));
        Thread.sleep(1000);

            //Navigate to PIM page
        driver.findElement(By.linkText("PIM")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Add Employee")).click();

        //and Add Employee
        driver.findElement(By.id("firstName")).sendKeys(firstname);
        driver.findElement(By.id("lastName")).sendKeys(lastname);

        //get employee ID before click save
        String employeID = driver.findElement(By.id("employeeId")).getAttribute("value"); //Retrieving employee if

        //Identify web element for "saved" button and click it.
        driver.findElement(By.id("btnSave")).click();

        //Once you click save button takes you to the Details page
        String addedEmployeeFullName = driver.findElement(By.cssSelector("div#profile-pic h1")).getText();
        if(addedEmployeeFullName.equals(firstname+" "+lastname))
            System.out.println("Employee added successfully");
        else
            System.out.println("Employee is NOT added");

        //from employee detail page,navigate to employee list
        driver.findElement(By.linkText("Employee List")).click();

        //Delete added employee from the employee list
        //On the employee list, loop through the table rows and find added employee and delete it.
        Boolean found= false;
        while (!found){
            List<WebElement> rows = driver.findElements(By.cssSelector("#tableWrapper tbody tr"));  //get number of the rows per page
            for (int i = 0; i < rows.size(); i++) {
                String empID = driver.findElement(By.cssSelector("table#resultTable tbody tr:nth-child(" + (i+1) + ") td:nth-child(2)")).getText();
                if(employeID.equals(empID)){
                    found=true;
                    //select checkbox next to employee and  click on delete button
                    driver.findElement(By.cssSelector("table#resultTable tbody tr:nth-child("+i+") td:nth-child(1) ")).click(); // click checkbox
                    Thread.sleep(1000);
                    driver.findElement(By.id("btnDelete")).click(); // click on the first delete button
                    Thread.sleep(1000);
                    driver.findElement(By.cssSelector("div.modal-footer #dialogDeleteBtn")).click(); // click on the second delete button
                    Thread.sleep(1000);
                    System.out.println("Employee "+firstname+" "+lastname+" with employee ID "+employeID+" has been deleted." );
                    break;
                }
            }
            driver.findElement(By.linkText("Next")).click(); // click on the next arrow button
        }
        tearDown();
    }
}
