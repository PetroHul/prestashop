import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IdentityAccountPage;
import pages.LoginPage;
import pages.MyAccountPage;
import tools.TestRunner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IdentityAccountTest extends TestRunner{

    @Test
    public void changePasswordTest() throws InterruptedException {
        final String email = "barzoom5@gmail.com";
        final String password = "529440";


        HomePage homePage = loadApplication();
        homePage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(email,password);

        MyAccountPage myAccount = new MyAccountPage(driver);
        myAccount.clickInformation();

        IdentityAccountPage identity = new IdentityAccountPage(driver);
        identity.typePassword("529440");
        identity.typeNewPassword("268405");
        identity.clickButtonSave();
        //How this input PageObject
        String actual = driver.findElement(By.cssSelector(".alert.alert-success > ul > li")).getText();
        String expected = "Information successfully updated.";
        Assert.assertEquals(actual,expected);

        //MyAccountPage myAccount = new MyAccountPage(driver);




    }
}
