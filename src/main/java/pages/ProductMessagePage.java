package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductMessagePage extends ProductPage{

    public final String EXPECTED_MESSAGE_CART = "Success: You have added %s to your shopping cart!";

    private WebElement alertMessage;

    public ProductMessagePage(WebDriver driver) {
        super(driver);
        initAlertMessage();
    }

    private void initAlertMessage() {
        alertMessage = driver.findElement(By.xpath("//*[@id='blockcart-modal']/div"));
    }

    // PageObject

    // alertMessage
    public WebElement getAlertMessage() {
        return alertMessage;
    }

    public WebElement getAlertMessageCloseButton() {
        return getAlertMessage().findElement(By.cssSelector(".close"));
    }

    public String getAlertMessageText() {
        String textMessage = getAlertMessage().getText();
        // Remove x Symbol from Message
        return textMessage.substring(0, textMessage.length() - 2);
    }

    // Business Logic

    public ProductPage closeAlertMessage() {
        getAlertMessageCloseButton().click();
        return new ProductPage(driver);
    }


}
