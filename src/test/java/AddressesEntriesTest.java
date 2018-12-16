import data.Address;
import data.UserRepository;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.AddressFormPage;
import pages.AddressesPage;
import pages.HomePage;
import tools.TestRunner;

import static org.testng.Assert.assertEquals;

public class AddressesEntriesTest extends TestRunner {

    @Test
    public void addAddressTest() {
        //arrenge
        Address userAddress = Address.EVA_PUPKINA;
        String actualAddress;
        final String expectedAddress = userAddress.getAddressBodyText();
        HomePage homePage = loadApplication(UserRepository.get().addingAddressUser());
        AddressesPage addressesPage = homePage.clickFooterAddressesButton();
        //act
//        String your_addresses = (addressesPage.getHeadingText());
        AddressFormPage addressFormPage = addressesPage.clickCreate();
        addressFormPage.fillAll(userAddress);
        addressesPage = addressFormPage.clickSaveButton();
        actualAddress = addressesPage.getLastAddressText();
        //assert
        assertEquals(actualAddress, expectedAddress);
    }

    @Test
    public void updateAddressTest() {
        //arrenge
        Address userAddress = Address.EVA_PUPKINA;
        String actualAddress;
        final String expectedAddress = userAddress.getAddressBodyText();
        HomePage homePage = loadApplication(UserRepository.get().updatingAddressUser());
        AddressesPage addressesPage = homePage.clickFooterAddressesButton();
        //act
        AddressFormPage addressFormPage = addressesPage.clickUpdateLast();
        addressFormPage.fillAll(userAddress);
        addressesPage = addressFormPage.clickSaveButton();
        actualAddress = addressesPage.getLastAddressText();
        //assert
        assertEquals(actualAddress, expectedAddress);
    }

    @Test
    public void deleteAddressTest() {
        //arrenge
        final String actualAlert;
        final String expectedAlert = "Address successfully deleted!";
        HomePage homePage = loadApplication(UserRepository.get().removingAddressUser());
        AddressesPage addressesPage = homePage.clickFooterAddressesButton();
        //act
        actualAlert = addressesPage.clickDeleteLast();
        //assert
        assertEquals(actualAlert, expectedAlert);
    }

    @AfterMethod
    public void signOut() {
        HomePage homePage = loadApplication();
        homePage.clickSignOutButtom();
    }
}