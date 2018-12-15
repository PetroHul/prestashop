import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import tools.TestRunner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTest extends TestRunner {

    @Test
    public void loginTest() throws InterruptedException {
        //arrange
        boolean expected;
        final String email = "barzoom5@gmail.com";
        final String password = "529440";

        HomePage homePage = loadApplication();
        homePage.clickSignInButton();

       // delayExecution(1000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(email,password);

        String actual = driver.getCurrentUrl();
        expected = actual.contains("my-account");
        assertTrue(expected);

        //login invalid data assertFalse
        // + add method(negative)
        //exept
    }
}
