package tools;

import pages.HomePage;
import pages.MyAccountPage;
import pages.ProductMessagePage;
import pages.ProductPage;

public class CartFunctionalRunner extends TestRunner {

    protected void addProductTOCart() {
        loadApplication();
        signIn();

        MyAccountPage accountUser = new MyAccountPage(driver);
        delayExplicitExecution(accountUser.getLogo());
        accountUser.clickLogo();

        HomePage homePage = new HomePage(driver);
        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickToAddButton();

        ProductMessagePage productMessagePage = new ProductMessagePage(driver);
        delayExplicitExecution(productMessagePage.getAlertMessageCloseButton());
        productMessagePage.closeAlertMessage();

        delayExecution(5000);
//        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        productMessagePage.clickShoppingCart();
    }

}
