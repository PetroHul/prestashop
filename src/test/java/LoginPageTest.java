import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import tools.TestRunner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTest extends TestRunner {

    @Test
    public void loginTest() throws InterruptedException {

        boolean expected;
        final String email = "barzoom5@gmail.com";
        final String password = "529440";

        HomePage homePage = loadApplication();
        homePage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(email,password);

        String actual = driver.getCurrentUrl();
        expected = actual.contains("my-account");
        assertTrue(expected);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickSignOutButtom();
    }
}
