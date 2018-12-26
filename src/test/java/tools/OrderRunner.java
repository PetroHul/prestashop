package tools;

import pages.OrderPage;
import pages.ShoppingCartPage;

public class OrderRunner extends CartFunctionalRunner {

    protected void makeOrder() {
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
