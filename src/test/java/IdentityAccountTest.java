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
    @Test
    public void changePasswordTest() throws InterruptedException, SQLException {
        final String email = "olx@set.ua";
        final String password = "529440";
        final String newPassword = "268405";

        //load app
        HomePage homePage = loadApplication();
        homePage.clickSignInButton();
        //logining account
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(email,password);
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
        loginPage1.fillLoginForm(email,newPassword);
        delayExecution(1000);
        //get actual url
        String actual1 = driver.getCurrentUrl();
        boolean expected1 = actual1.contains("identity");
        assertTrue(expected1);
        //del user
        ConncectDB conncectDB = new ConncectDB();
        conncectDB.deleteDataQuery("delete from ps_customer where email="+"\"olx@set.ua\";");
    }
}
