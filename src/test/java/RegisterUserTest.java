import data.IUser;
import data.UserRepository;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import tools.TestRunner;

public class RegisterUserTest extends TestRunner {

//    @DataProvider//(parallel = true)
//    public Object[][] newUser() {
//        // Read from ...
//        return new Object[][] {
//                { UserRepository.get().newUser() },
//        };
//    }

    @Test
    public void registerNewUser() {

        //Arrange
        HomePage homePage = loadAplication();
        LoginPage loginPage;
        CreateAccountPage createAccountPage;
        HomePage resultPage;
        final IUser newUser = UserRepository.get().newUser();
        String actual;
        String expected = newUser.getFirstName() + " " + newUser.getLastName();


        //Actual
        loginPage = homePage.clickSignInButton();
        createAccountPage = loginPage.clickNoAccountButton();
        createAccountPage.setSocialTitle(newUser.getSocialTitle());
        createAccountPage.setFirstName(newUser.getFirstName());
        createAccountPage.setLastName(newUser.getLastName());
        createAccountPage.setEmail(newUser.getEmail());
        createAccountPage.setPassword(newUser.getPassword());
        createAccountPage.setBirthdate(newUser.getBirthdate());
        createAccountPage.setReceiveOffers(newUser.isRecieveOffers());
        createAccountPage.setNewsletter(newUser.isNewsletter());
        delayExecution(1000);
        resultPage = createAccountPage.clickSaveButton();
        actual = resultPage.getUserName();

        //Assert
        System.out.println(actual);
        Assert.assertEquals(actual, expected);

    }


}