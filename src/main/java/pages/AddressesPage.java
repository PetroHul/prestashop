package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage extends AHeadComponent {
    @FindBy(css = ".page-header > h1")
    private WebElement heading;
    @FindBy(css = ".addresses-footer a[data-link-action='add-address']")
    private WebElement createButton;
    @FindBy(xpath = "(//*[@class='address-body'])[last()]")
    private WebElement lastAddressBody;
    @FindBy(xpath = "(//a[@data-link-action='edit-address'])[last()]")
    private WebElement updateLastButtom;
    @FindBy(xpath = "(//a[@data-link-action='delete-address'])[last()]")
    private WebElement deleteLastButtom;

    private WebElement alertSuccess;

    protected AddressesPage(WebDriver driver) {
        super(driver);
            PageFactory.initElements(driver, this);
    }

    public String getHeadingText() {
        return heading.getText().trim().toUpperCase();
    }

    public AddressFormPage clickCreate() {
        createButton.click();
        return new AddressFormPage(driver);
    }

    public AddressFormPage clickUpdateLast() {
        updateLastButtom.click();
        return new AddressFormPage(driver);
    }

    public String clickDeleteLast() {
        deleteLastButtom.click();
        return getAlertSuccessText();
    }

    public String getAlertSuccessText() {
        return driver.findElement(By.cssSelector("article.alert.alert-success")).getText();
        //TODO throws Exception
    }

    public String getLastAddressText() {
        return lastAddressBody.getText();
    }
}
