import data.IUser;
import data.UserRepository;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import tools.ConncectDB;
import tools.TestRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterUserTest extends TestRunner {

//    @DataProvider//(parallel = true)
//    public Object[][] newUser() {
//        // Read from ...
//        return new Object[][] {
//                { UserRepository.get().newUser() },
//        };
//    }

    @Test
    public void registerNewUser() throws SQLException {

        //Arrange
        HomePage homePage = loadApplication();
        LoginPage loginPage;
        CreateAccountPage createAnAccountPage;
        HomePage resultPage;
        final IUser newUser = UserRepository.get().newUser();
        String actual;
        String expected = newUser.getFirstName() + " " + newUser.getLastName();

        //Actual
        loginPage = homePage.clickSignInButton();
        createAnAccountPage = loginPage.clickNoAccountButton();
        createAnAccountPage.setSocialTitle(newUser.getSocialTitle());
        createAnAccountPage.setFirstName(newUser.getFirstName());
        createAnAccountPage.setLastName(newUser.getLastName());
        createAnAccountPage.setEmail(newUser.getEmail());
        createAnAccountPage.setPassword(newUser.getPassword());
        createAnAccountPage.setBirthdate(newUser.getBirthdate());
        createAnAccountPage.setReceiveOffers(newUser.isRecieveOffers());
        createAnAccountPage.setNewsletter(newUser.isNewsletter());
        resultPage = createAnAccountPage.clickSaveButton();
        actual = resultPage.getUserName();

        //Assert
        System.out.println(actual);
        String currentEmail = newUser.getEmail();
        System.out.println(currentEmail);
        Assert.assertEquals(actual, expected);

        ConncectDB conncectDB = new ConncectDB();
        //String currentEmail = newUser.getEmail();

//        ResultSet actual2 = conncectDB.DMLDataSelect("SELECT email FROM ps_customer WHERE email=" + "\"" + currentEmail + "\";");
//        System.out.println(actual2);
//        Assert.assertEquals(actual2.toString(), currentEmail);

        conncectDB.DMLDataQuery("DELETE FROM ps_customer WHERE email=\"" + currentEmail + "\";");
    }

    @Test
    public void registerUserWithExistedEmail() {
        //Arrange
        HomePage homePage = loadApplication();
        LoginPage loginPage;
        CreateAccountPage actual = new CreateAccountPage(driver);
        final IUser newUser = UserRepository.get().newUserInvalidData();
        //Act
        loginPage = homePage.clickSignInButton();
        CreateAccountPage createAnAccountPage = loginPage.clickNoAccountButton();
        createAnAccountPage.setSocialTitle(newUser.getSocialTitle());
        createAnAccountPage.setFirstName(newUser.getFirstName());
        createAnAccountPage.setLastName(newUser.getLastName());
        createAnAccountPage.setEmail(newUser.getEmail());
        createAnAccountPage.setPassword(newUser.getPassword());
        createAnAccountPage.setBirthdate(newUser.getBirthdate());
        createAnAccountPage.clickSaveButton();

        //Assert
        Assert.assertTrue(actual.getMessageText().equals("The email \"ola-good96@ukr.net\" is already used, please choose another one or sign in"));

    }


}