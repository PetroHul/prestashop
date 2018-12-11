
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import tools.TestRunner;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTest extends TestRunner {

    @Test
    public void testLogin() throws InterruptedException {
        boolean expected;
        final String email = "barzoom5@gmail.com";
        final String password = "529440";

        HomePage homePage = loadAplication();
        homePage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.fillLoginForm(email,password);

        String actual = driver.getCurrentUrl();
        expected = actual.contains("my-account");
        assertTrue(expected);
      
        //HomePage homePage = HomePage()
        // .fillLoginForm('barzoom5@gmailcom',"529440");
    }
}

