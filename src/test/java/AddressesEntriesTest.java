import data.UserRepository;
import org.testng.annotations.*;
import pages.*;
import tools.TestRunner;

public class AddressesEntriesTest extends TestRunner {
    @Test
    public void addAddressTest() {
    //arrenge
        HomePage homePage = loadAplication(UserRepository.get().localUser());
        AddressesPage addressesPage = homePage.clickFooterAddressesButton();
    //act
        String your_addresses = (addressesPage.getHeadingText());
        AddressFormPage addressFormPage = addressesPage.clickCreate();
//        addressFormPage.fillAll(UserRepository.get().localUser())
    //assert

    }
}
