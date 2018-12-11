package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends AHeadComponent {
    private WebElement heading;
    private WebElement informationButton;
    private WebElement addressesButton;
    private WebElement orderHistoryAndDetailsButton;
    private WebElement creditSlipsButton;
    private WebElement logOutButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        initMyAcountComponent();
    }

    private void initMyAcountComponent() {
        heading = driver.findElement(By.cssSelector("footer.page-footer a[href*='mylogout']"));
        informationButton = driver.findElement(By.cssSelector("a#identity-link[href*='identity']"));
        addressesButton = driver.findElement(By.cssSelector("a#identity-link[href*='address']"));
        orderHistoryAndDetailsButton = driver.findElement(By.cssSelector("a#identity-link[href*='order-history']"));
        creditSlipsButton = driver.findElement(By.cssSelector("a#identity-link[href*='credit-slip']"));
        logOutButton = driver.findElement(By.cssSelector("a#identity-link[href*='identity']"));
    }

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
