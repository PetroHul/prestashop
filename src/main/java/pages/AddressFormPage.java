package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressFormPage extends AHeadComponent {
    @FindBy(css = ".page-header > h1")
    private WebElement heading;
    @FindBy(css = ".form-control[name='alias']")
    private WebElement firstName;
    @FindBy(css = ".form-control[name='firstname']")
    private WebElement lastName;
    @FindBy(css = ".form-control[name='lastName']")
    private WebElement company;
    @FindBy(css = ".form-control[name='company']")
    private WebElement vatNumber;
    @FindBy(css = ".form-control[name='vat_number']")
    private WebElement address;
    @FindBy(css = ".form-control[name='address1']")
    private WebElement addressComplement;
    @FindBy(css = ".form-control[name='address2']")
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

}
