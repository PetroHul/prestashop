package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductMessagePage extends ProductPage{

    private WebElement alertMessage;

    public ProductMessagePage(WebDriver driver) {
        super(driver);
        initAlertMessage();
    }

    private void initAlertMessage() {
        alertMessage = driver.findElement(By.xpath("//*[@id='blockcart-modal']/div"));
    }

    // alertMessage
    public WebElement getAlertMessage() {
        return alertMessage;
    }

    public WebElement getAlertMessageCloseButton() {
        return getAlertMessage().findElement(By.cssSelector(".close"));
    }

    // Business Logic
    public ProductPage closeAlertMessage() {
        getAlertMessageCloseButton().click();
        return new ProductPage(driver);
    }


}
