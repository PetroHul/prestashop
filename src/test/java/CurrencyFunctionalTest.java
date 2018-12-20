import data.Category;
import data.Currencies;
import org.testng.Assert;


import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import pages.*;
import tools.TestRunner;

public class CurrencyFunctionalTest extends TestRunner {


    @DataProvider//(parallel = true)
    public Object[][] currencyData() {
        // Read from ...
        return new Object[][]{{Currencies.UAH, "UAH ₴"}, {Currencies.EURO, "EUR €"}, {Currencies.USD, "USD $"}};
    }

    @Test(dataProvider = "currencyData")
    public void checkCurrency(Currencies currency, String expectedCurrencyText) {
        //
        // Precondition
        HomePage homePage = loadApplication();
        delayExecution(1000);
        //
        // Steps
        homePage = homePage.chooseCurrency(currency);
        delayExecution(1000);
        //
        // Check
        Assert.assertEquals(homePage.getCurrencyText(), expectedCurrencyText);
        delayExecution(2000);
    }
}