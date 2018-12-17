import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OrderMessagePage;
import tools.OrderRunner;

public class OrderTest extends OrderRunner {

    @BeforeMethod
    public void prepareCart() {
        addProductTOCart();
    }

    @Test
    public void makeOrderTest() {
        makeOrder();
        OrderMessagePage orderMessagePage = new OrderMessagePage(driver);
        Assert.assertTrue(orderMessagePage.getMessageText().contains("YOUR ORDER IS CONFIRMED"));
    }




}
