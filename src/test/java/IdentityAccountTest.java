import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IdentityAccountPage;
import pages.LoginPage;
import pages.MyAccountPage;
import tools.TestRunner;
import tools.ConncectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IdentityAccountTest extends TestRunner{

    @Test
    public void changePasswordTest() throws InterruptedException, SQLException {
        final String email = "olx@set.ua";
        final String password = "529440";
        final String newPassword = "268405";


        HomePage homePage = loadApplication();
        homePage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(email,password);

        MyAccountPage myAccount = new MyAccountPage(driver);
        myAccount.clickInformation();

        IdentityAccountPage identity = new IdentityAccountPage(driver);
        identity.typePassword(password);
        identity.typeNewPassword(newPassword);
        identity.clickButtonSave();
        //How this input PageObject
        String actual = identity.getAlertSuccessText();
        String expected = "Information successfully updated.";
        Assert.assertEquals(actual,expected);

        //MyAccountPage myAccount = new MyAccountPage(driver);

        ConncectDB conncectDB = new ConncectDB();
        conncectDB.dataDaseQuery("DELETE FROM ps_customer WHERE id_customer=45;");


    }
}
