package Selenium;

import data.Address;
import data.UserRepository;
import org.testng.annotations.DataProvider;
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
        Address userAddress = Address.VASIA_PUPKIN;
        final String actualAddress;
        final String expectedAddress = userAddress.getAddressBodyText();
        HomePage homePage = loadApplication(UserRepository.get().addressTestUser());
        AddressesPage addressesPage = homePage.clickFooterAddressesButton();
        //act
//        String your_addresses = (addressesPage.getHeadingText());
        AddressFormPage addressFormPage = addressesPage.clickCreate();
        addressFormPage.fillAll(userAddress);
        addressesPage = addressFormPage.clickSaveButton();
        actualAddress = addressesPage.getLastAddressText();
        //assert
        assertEquals(actualAddress, expectedAddress);
        addressesPage.clickSignOutButtom();
    }

    @Test
    public void updateAddressTest() {
        //arrenge
        Address userAddress = Address.EVA_PUPKINA;
        final String actualAddress;
        final String expectedAddress = userAddress.getAddressBodyText();
        HomePage homePage = loadApplication(UserRepository.get().addressTestUser());
        AddressesPage addressesPage = homePage.clickFooterAddressesButton();
        //act
        AddressFormPage addressFormPage = addressesPage.clickUpdateLast();
        addressFormPage.fillAll(userAddress);
        addressesPage = addressFormPage.clickSaveButton();
        actualAddress = addressesPage.getLastAddressText();
        //assert
        assertEquals(actualAddress, expectedAddress);
        addressesPage.clickSignOutButtom();
    }

    @Test
    public void updateInvalidCodeTest(String code) {
        //arrenge
        final String actualAlert;
        final String expectedAlert = "Please fix the error below.";
        HomePage homePage = loadApplication(UserRepository.get().addressTestUser());
        AddressesPage addressesPage = homePage.clickFooterAddressesButton();
        //act
        AddressFormPage addressFormPage = addressesPage.clickUpdateLast();
        addressFormPage.fillPostCode(code);
        addressFormPage.getSaveButton().click();
        actualAlert = addressFormPage.getAlertDangerText();
        //assert
        assertEquals(actualAlert, expectedAlert);
        addressFormPage.clickSignOutButtom();
    }

    @Test
    public void deleteAddressTest() {
        //arrenge
        final String actualAlert;
        final String expectedAlert = "Address successfully deleted!";
        HomePage homePage = loadApplication(UserRepository.get().addressTestUser());
        AddressesPage addressesPage = homePage.clickFooterAddressesButton();
        //act
        actualAlert = addressesPage.clickDeleteLast();
        //assert
        assertEquals(actualAlert, expectedAlert);
        addressesPage.clickSignOutButtom();
    }
}