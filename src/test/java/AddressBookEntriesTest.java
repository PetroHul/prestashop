import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CreateAnAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import tools.TestRunner;

import java.util.concurrent.TimeUnit;

public class AddressBookEntriesTest extends TestRunner {
    @Test
    public void addAddressTest() {
        //arrenge
        final String LOGIN = "local_part@domain.com";
        final String PASSWORD = "qwerty";

        HomePage homePage = loadAplication();

        LoginPage loginPage = homePage.clickSignInButton();
        MyAccountPage myAccountPage = loginPage.signin(LOGIN, PASSWORD);
    }
}
