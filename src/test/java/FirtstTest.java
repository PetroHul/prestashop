import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductComponent;
import pages.ProductListComponent;
import tools.TestRunner;


public class FirtstTest extends TestRunner {

    @Test
    public void test1() {
        //precondition
        HomePage homePage = loadAplication();
        delayExecution(1000);
        //steps

        System.out.println(homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt"));

//

    }


}
