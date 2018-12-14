import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OrderPage;
import pages.ShoppingCartPage;
import tools.CartFunctionalRunner;

public class OrderTest extends CartFunctionalRunner {

    @BeforeMethod
    public void runApp() {
        addProductTOCart();
    }

    @Test
    public void findButton() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOrderButton();

        OrderPage orderPage = new OrderPage(driver);

        orderPage.clickContinueAddressButton();

        delayExplicitExecution(orderPage.getContinueDeliveryButton());

        orderPage.clickContinueDeliveryButton();


        delayExplicitExecution(orderPage.getPayByCheckCheckbox());

        orderPage.clickPayByCheckCheckbox();

        delayExplicitExecution(orderPage.getAgreeElement());
        orderPage.clickAgreeElement();

        delayExplicitExecution(orderPage.getOrderButton());
        orderPage.clickOrderButton();


    }


}
