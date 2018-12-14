package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OrderPage extends AHeadComponent {

    @FindBy(css = "button[name='confirm-addresses']")
    private WebElement continueAddressButton;

    @FindBy(css = "button[name='confirmDeliveryOption']")
    private WebElement continueDeliveryButton;

    @FindBy(xpath = "//*[@id='payment-option-1-container']/label")
    private WebElement payByCheckCheckbox;

    @FindBy(css = ".js-terms")
    private WebElement agreeElement;

    @FindBy(css = ".btn.btn-primary.center-block")
    private WebElement orderButton;

    public OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //
    public WebElement getContinueAddressButton() {
        return continueAddressButton;
    }

    public void clickContinueAddressButton() {
        getContinueAddressButton().click();
    }

    //
    public WebElement getContinueDeliveryButton() {
        return continueDeliveryButton;
    }

    public void clickContinueDeliveryButton() {
        getContinueDeliveryButton().click();
    }

    //
    public WebElement getPayByCheckCheckbox()
    {
        return payByCheckCheckbox;
    }

    public void clickPayByCheckCheckbox() {

        if(!getPayByCheckCheckbox().isSelected()){

            getPayByCheckCheckbox().click();
        }
    }

    public WebElement getAgreeElement() {
        return agreeElement;
    }

    public void clickAgreeElement() {

        if(!getAgreeElement().isSelected()){
            getAgreeElement().click();
        }
    }

    public WebElement getOrderButton() {
        return orderButton;
    }

    public void clickOrderButton() {
        getOrderButton().click();
    }
}
