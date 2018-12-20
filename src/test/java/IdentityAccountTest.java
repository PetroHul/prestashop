import data.RandomString;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

        @DataProvider(name = "usermManipulation")
        public static Object[][] insertUser() {

            final String insert = "INSERT INTO `ps_customer` (`id_customer`, `id_shop_group`, `id_shop`, `id_gender`," +
                    " `id_default_group`, `id_lang`, `id_risk`, `company`, `siret`," +
                    " `ape`, `firstname`, `lastname`, `email`, `passwd`," +
                    " `last_passwd_gen`, `birthday`, `newsletter`," +
                    " `ip_registration_newsletter`, `newsletter_date_add`," +
                    " `optin`, `website`, `outstanding_allow_amount`," +
                    " `show_public_prices`, `max_payment_days`, `secure_key`," +
                    " `note`, `active`, `is_guest`, `deleted`, `date_add`," +
                    " `date_upd`, `reset_password_token`, `reset_password_validity`)" +
                    " VALUES (NULL, '1', '1', '0', '3', '2', '0', '', '', '', 'Petro'," +
                    " 'Hu" + "" + "" + "l', 'setstore@set.ua'," +
                    " '$2y$10$Gr87PNmdP0Fntv9IXn5iy.LEOcl4KGF0qZMWuYxqpNfNFXcg28pAy'," +
                    " '2018-12-15 14:11:20', '0000-00-00', '0', '', '0000-00-00 00:00:00'," +
                    " '0', '', '0.000000', '0', '0', 'fa0aaaf5a5410dd59b2b4cfe9dddaf2c'," +
                    " '', '1', '0', '0', '2018-12-15 20:11:20', '2018-12-15 20:11:20'," +
                    " '', '0000-00-00 00:00:00')";

            final String insert1 ="INSERT INTO `ps_customer` (`id_customer`, `id_shop_group`," +
                    " `id_shop`, `id_gender`, `id_default_group`, `id_lang`, `id_risk`," +
                    " `company`, `siret`, `ape`, `firstname`, `lastname`, `email`, `passwd`," +
                    " `last_passwd_gen`, `birthday`, `newsletter`, `ip_registration_newsletter`," +
                    " `newsletter_date_add`, `optin`, `website`, `outstanding_allow_amount`," +
                    " `show_public_prices`, `max_payment_days`, `secure_key`, `note`, `active`," +
                    " `is_guest`, `deleted`, `date_add`, `date_upd`, `reset_password_token`," +
                    " `reset_password_validity`) VALUES (NULL, '1', '1', '1', '3', '2', '0', '', ''," +
                    " '', 'Santa', 'Clause', 'setsanta@gmail.set'," +
                    " '$2y$10$YzcDf5MlVCjcF2x47kSz3OZQpcW4LXgM2oSeE6yzF5usiV/HHAO8i', '2018-12-16 12:22:50'," +
                    " '0000-00-00', '0', '', '0000-00-00 00:00:00', '0', '', '0.000000', '0', '0', '4f85f6a179ba962c3d48ce62e3fc57a4'," +
                    " '', '1', '0', '0', '2018-12-16 18:22:50', '2018-12-16 18:22:50', '', '0000-00-00 00:00:00')";

            final String email = "setstore@set.ua";
            final String password = "529440";
            final String newPassword = "268405";

            final String email1 = "setsanta@gmail.set";
            final String password1 = "asdfew21a";
            final String newPassword1 = "147852";

            final String delete = "DELETE FROM ps_customer WHERE email="+"\"setstore@set.ua\";";
            final String delete1 = "DELETE FROM ps_customer WHERE email="+"\"setsanta@gmail.set\";";

            return new Object[][] {{ insert, email, password, newPassword, delete},
                    { insert1, email1, password1, newPassword1, delete1 }};
        }

    @Test(dataProvider = "usermManipulation")
    public void changePasswordTest(String insert, String email, String password, String newPassword, String delete) throws SQLException {
        ConncectDB conncectDB = new ConncectDB();
        conncectDB.DMLDataQuery(insert);

        HomePage homePage = loadApplication();
        homePage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(email,password);

        MyAccountPage myAccount = new MyAccountPage(driver);
        myAccount.clickInformation();

        IdentityAccountPage identity = new IdentityAccountPage(driver);
        identity.typePassword(password);
        identity.typeNewPassword(newPassword);
        identity.clickButtonSave();

        String actual = identity.getAlertSuccessText();
        String expected = "Information successfully updated.";
        assertEquals(actual,expected);

        identity.clickSignOutButtom();
        loginPage.signIn(email,newPassword);

        String actual1 = driver.getCurrentUrl();
        boolean expected1 = actual1.contains("identity");
        assertTrue(expected1);
        identity.clickSignOutButtom();

        conncectDB.DMLDataQuery(delete);
    }
}
