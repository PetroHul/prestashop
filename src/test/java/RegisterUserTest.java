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
        HomePage homePage = loadApplication();
        LoginPage loginPage;
        CreateAccountPage createAnAccountPage;
        HomePage resultPage;
        final IUser newUser = UserRepository.get().newUser();
        String actual;
        String expected=newUser.getFirstName()+" " + newUser.getLastName();

//взяти собі в тест генерація нового юзера з рандомною поштою ПЕТРО
        //actual
        loginPage = homePage.clickSignInButton();
        createAnAccountPage = loginPage.clickNoAccountButton();
        createAnAccountPage.setSocialTitle(newUser.getSocialTitle());
        createAnAccountPage.setFirstName(newUser.getFirstName());
        createAnAccountPage.setLastName(newUser.getLastName());
        createAnAccountPage.setEmail(newUser.getEmail());
        createAnAccountPage.setPassword(newUser.getPassword());
        createAnAccountPage.setBirthdate(newUser.getBirthdate());
        resultPage = createAnAccountPage.clickSaveButton();
//        actual=resultPage.getUserName();
//


//
//        //Assert
//        System.out.println(actual);
//        Assert.assertEquals(actual,expected);

    }


}