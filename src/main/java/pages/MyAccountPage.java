package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends AHeadComponent {
    @FindBy(css = "footer.page-footer a[href*='mylogout']")
    private WebElement heading;
    @FindBy(css = "a#identity-link[href*='identity']")
    private WebElement informationButton;
    @FindBy(css = "a#address-link[href*='address']")
    private WebElement addressesButton;
    @FindBy(css = "a#history-link[href*='order-history']")
    private WebElement orderHistoryAndDetailsButton;
    @FindBy(css = "a#order-slips-link[href*='credit-slip']")
    private WebElement creditSlipsButton;
    @FindBy(css = ".page-footer a[href*='mylogout']")
    private WebElement logOutButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //add Petro
    public WebElement getInformationButton(){
        return informationButton;
    }
    public void clickInformation(){
        getInformationButton().click();;
    }

    //add Petro
    public String getHeading() {
        return heading.getText().trim().toUpperCase();
    }

    public WebElement getAddressesButton() {
        return addressesButton;
    }

    public void setAddressesButton(WebElement addressesButton) {
        this.addressesButton = addressesButton;
    }

    public LoginPage clickLogOutButton() {
        logOutButton.click();
        return new LoginPage(driver);
    }
}
