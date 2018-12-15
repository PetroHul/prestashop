import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IdentityAccountPage;
import pages.LoginPage;
import pages.MyAccountPage;
import tools.ConncectDB;
import tools.TestRunner;
import java.sql.SQLException;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IdentityAccountTest extends TestRunner{
        // add create user un db! precondition
        //
    @BeforeMethod
    public void init() throws SQLException {
        ConncectDB conncectDB = new ConncectDB();

        String insert = "INSERT INTO `ps_customer` (`id_customer`, `id_shop_group`, `id_shop`, `id_gender`," +
                " `id_default_group`, `id_lang`, `id_risk`, `company`, `siret`," +
                " `ape`, `firstname`, `lastname`, `email`, `passwd`," +
                " `last_passwd_gen`, `birthday`, `newsletter`," +
                " `ip_registration_newsletter`, `newsletter_date_add`," +
                " `optin`, `website`, `outstanding_allow_amount`," +
                " `show_public_prices`, `max_payment_days`, `secure_key`," +
                " `note`, `active`, `is_guest`, `deleted`, `date_add`," +
                " `date_upd`, `reset_password_token`, `reset_password_validity`)" +
                " VALUES (NULL, '1', '1', '0', '3', '2', '0', '', '', '', 'Petro'," +
                " 'Hul', 'setstore@set.ua'," +
                " '$2y$10$Gr87PNmdP0Fntv9IXn5iy.LEOcl4KGF0qZMWuYxqpNfNFXcg28pAy'," +
                " '2018-12-15 14:11:20', '0000-00-00', '0', '', '0000-00-00 00:00:00'," +
                " '0', '', '0.000000', '0', '0', 'fa0aaaf5a5410dd59b2b4cfe9dddaf2c'," +
                " '', '1', '0', '0', '2018-12-15 20:11:20', '2018-12-15 20:11:20'," +
                " '', '0000-00-00 00:00:00')";

//        String insert2 = "INSERT INTO `ps_customer_group` (`id_customer`, `id_group`) VALUES ('76', '3')";
        conncectDB.DMLDataQuery(insert);
    }

    @Test
    public void changePasswordTest() throws InterruptedException, SQLException {
        final String email = "setstore@set.ua";
        final String password = "529440";
        final String newPassword = "268405";

        //load app
        HomePage homePage = loadApplication();
        homePage.clickSignInButton();
        //logining account
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(email,password);
        //go to information
        MyAccountPage myAccount = new MyAccountPage(driver);
        myAccount.clickInformation();
        //change password
        IdentityAccountPage identity = new IdentityAccountPage(driver);
        delayExecution(1000);
        identity.typePassword(password);
        delayExecution(1000);
        identity.typeNewPassword(newPassword);
        delayExecution(1000);
        identity.clickButtonSave();
        //check massage
        String actual = identity.getAlertSuccessText();
        String expected = "Information successfully updated.";
        assertEquals(actual,expected);
        //logout
        identity.clickSignOutButtom();
        //login
        delayExecution(1000);
        LoginPage loginPage1 = new LoginPage(driver);
        loginPage1.signIn(email,newPassword);
        delayExecution(1000);
        //get actual url
        String actual1 = driver.getCurrentUrl();
        boolean expected1 = actual1.contains("identity");
        assertTrue(expected1);
        //del user and group for user
        ConncectDB conncectDB = new ConncectDB();
        conncectDB.DMLDataQuery("DELETE FROM ps_customer WHERE email="+"\"setstore@set.ua\";");
//        conncectDB.DMLDataQuery("DELETE FROM ps_customer_group WHERE ");// make to work
    }
}
