//import org.testng.annotations.Test;
//import pages.HomePage;
//import pages.LoginPage;
//import tools.TestRunner;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.testng.Assert.assertEquals;
//
//public class LoginPageTest extends TestRunner {
//
//    @Test
//    public void testLogin() throws InterruptedException {
//
//        final String email = "barzoom5@gmail.com";
//        final String password = "529440";
//
//        HomePage homePage = loadAplication();
//        homePage.clickSignInButton();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
////        LoginPage loginPage = new LoginPage(); // тут бага
//        loginPage.clickLoginButton();
//        loginPage.fillLoginForm(email,password);
//
//        String actual = driver.getCurrentUrl();
//        String expected = "";
//        expected.contains("my-account");
//        assertEquals(actual,"sa");
//        System.out.println(expected);
//        System.out.println(actual);
//
//
//        //HomePage homePage = HomePage()
//
//
//        // .fillLoginForm('barzoom5@gmailcom',"529440");
//    }
//}