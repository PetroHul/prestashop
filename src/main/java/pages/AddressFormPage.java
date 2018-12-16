package pages;

import data.Address;
import data.Country;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressFormPage extends AHeadComponent {
    @FindBy(css = ".page-header > h1")
    private WebElement heading;
    @FindBy(css = ".form-control[name='alias']")
    private WebElement alias;
    @FindBy(css = ".form-control[name='firstname']")
    private WebElement firstName;
    @FindBy(css = ".form-control[name='lastname']")
    private WebElement lastName;
    @FindBy(css = ".form-control[name='company']")
    private WebElement company;
    @FindBy(css = ".form-control[name='vat_number']")
    private WebElement vatNumber;
    @FindBy(css = ".form-control[name='address1']")
    private WebElement address1;
    @FindBy(css = ".form-control[name='address2']")
    private WebElement address2;
    @FindBy(css = ".form-control[name='postcode']")
    private WebElement postCode;
    @FindBy(css = ".form-control[name='city']")
    private WebElement city;
    @FindBy(css = ".form-control[name='id_country']")
    private WebElement country;
    @FindBy(css = ".form-control[name='phone']")
    private WebElement phone;
    @FindBy(css = ".form-footer.clearfix button[type='submit']")
    private WebElement saveButton;

    protected AddressFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillAll(Address data) {
        fill(alias, data.getAlias());
        fill(firstName, data.getFirstName());
        fill(lastName, data.getLastName());
        fill(company, data.getCompany());
        fill(vatNumber, data.getVatNumber());
        fill(address1, data.getAddress1());
        fill(address2, data.getAddress2());
        fill(postCode, data.getPostCode());
        fill(city, data.getCity());
        selectCountry(data.getCountry());
        fill(phone, data.getPhone());
    }

    private void fill(WebElement field, String value) {
        field.click();
        field.clear();
        field.sendKeys(value);
    }

    public void fillAlias(String alias) {
        fill(this.alias, alias);
    }

    public void fillFirstName(String firstName) {
        fill(this.firstName, firstName);
    }

    public void fillLastName(String lastName) {
        fill(this.lastName, lastName);
    }

    public void fillCompany(String company) {
        fill(this.company, company);
    }

    public void fillVatNumber(String vatNumber) {
        fill(this.vatNumber, vatNumber);
    }

    public void fillAddress1(String address1) {
        fill(this.address1, address1);
    }

    public void fillAddress2(String address2) {
        fill(this.address2, address2);
    }

    public void fillPostCode(String postCode) {
        fill(this.postCode, postCode);
    }

    public void fillCity(String city) {
        fill(this.city, city);
    }

    public void selectCountry(Country country) {
        driver.findElement(By.cssSelector(String.format("select.form-control[name='id_country'] option[value='%s']",
                country.getValue())))
                .click();
    }

    public void fillPhone(String phone) {
        fill(this.phone, phone);
    }

    public AddressesPage clickSaveButton() {
        saveButton.click();
        return new AddressesPage(driver);
//        TODO create exception for incorrect entries
    }

}
