package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage extends AHeadComponent {
    @FindBy(css = ".page-header > h1")
    private WebElement heading;
    @FindBy(css = ".addresses-footer a[data-link-action='add-address']")
    private WebElement createBunnon;

    protected AddressesPage(WebDriver driver) {
        super(driver);
            PageFactory.initElements(driver, this);
    }

    public String getHeadingText() {
        return heading.getText().trim().toUpperCase();
    }

    public AddressFormPage clickCreate() {
        createBunnon.click();
        return new AddressFormPage(driver);
    }
}
