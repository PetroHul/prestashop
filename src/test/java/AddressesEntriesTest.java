import data.UserRepository;
import org.testng.annotations.*;
import pages.AddressesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import tools.TestRunner;

public class AddressesEntriesTest extends TestRunner {
    @Test
    public void addAddressTest() {
    //arrenge
        HomePage homePage = loadAplication(UserRepository.get().localUser());
        AddressesPage addressesPage = homePage.clickFooterAddressesButton();
    //act
        System.out.println(addressesPage.getHeadingText());
    //assert
    }
}
