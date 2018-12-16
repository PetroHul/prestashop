import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginAdminPage;
import pages.ProductsAdminPage;

import tools.TestRunner;

import static org.testng.Assert.*;


public class LoginAdminPageTest extends TestRunner {

    @Test
    public void TestLoginAdmin() {
        ProductsAdminPage productsAdminPage = signInAsAdmin();
        delayExecution(3000);
        boolean isAdminProducts;
        try {

            driver.findElement(By.xpath("//body[contains(@class,'adminproducts')]"));
            isAdminProducts = true;
        } catch (NoSuchElementException e) {
            isAdminProducts = false;
        }
        assertTrue(isAdminProducts);

    }

}