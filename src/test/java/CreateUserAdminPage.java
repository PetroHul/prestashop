import data.IUser;
import data.UserRepository;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateUserAdminMessagePage;
import pages.ProductsAdminPage;
import tools.TestRunner;

public class CreateUserAdminPage extends TestRunner {
    @Test
    public void CreateUserTest() {

        //Arrange
        ProductsAdminPage productsAdminPage = signInAsAdmin();
        pages.CreateUserAdminPage createUserAdminPage=new pages.CreateUserAdminPage(driver);
        final IUser newUser = UserRepository.get().newUserAdmin();
        CreateUserAdminMessagePage actual=new CreateUserAdminMessagePage(driver);

        //Act
        delayExecution(3000);
        createUserAdminPage.clickClientsFirstButton();
        delayExecution(3000);
        createUserAdminPage.clickClientsButton();
        delayExecution(3000);
        createUserAdminPage.clickAddUserButton();
        createUserAdminPage.setSocialTitle(newUser.getSocialTitle());
        createUserAdminPage.setFirstName(newUser.getFirstName());
        createUserAdminPage.setLastName(newUser.getLastName());
        createUserAdminPage.setEmail(newUser.getEmail());
        createUserAdminPage.setPassword(newUser.getPassword());
        createUserAdminPage.clickSaveButton();

        //Assert
        Assert.assertTrue(actual.getMessageText().contains("Успішно створено."));



    }
}
