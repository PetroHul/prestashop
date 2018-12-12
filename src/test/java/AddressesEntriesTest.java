import data.Address;
import data.UserRepository;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import tools.TestRunner;

import static org.testng.Assert.assertEquals;

public class AddressesEntriesTest extends TestRunner {
    @Test
    public void addAddressTest() {
    //arrenge
        Address userAddress = Address.EVA_PUPKINA;
        HomePage homePage = loadAplication(UserRepository.get().localUser());
        AddressesPage addressesPage = homePage.clickFooterAddressesButton();
        String actualAddress;
        String expectedAddress = userAddress.getAddressBodyText();
        //act
        String your_addresses = (addressesPage.getHeadingText());
        AddressFormPage addressFormPage = addressesPage.clickCreate();
        addressFormPage.fillAll(userAddress);
        addressesPage = addressFormPage.clickSaveButton();
        actualAddress = addressesPage.getAddressBodyText();
        //assert
        assertEquals(actualAddress, expectedAddress);
//        TODO delete address after test
    }
}
