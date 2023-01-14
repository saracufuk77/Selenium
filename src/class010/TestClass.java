package class010;

import utils.BaseClass;
import static  utils.BaseClass.*;

public class TestClass  { //extends BaseClass {
    public static void main(String[] args)  {
        setUp("https://exelenter.com");    // <------------ launch the browser

        System.out.println(driver.getTitle());   //<------------perform an action on the browser (actual testing)

        tearDown();         // <----------------quit the browser
    }
}
