package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductMessagePage extends ProductPage {

    @FindBy(xpath = "//*[@id='blockcart-modal']/div")
    private WebElement alertMessage;

    public ProductMessagePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
//        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(getAlertMessageCloseButton()));
        getAlertMessageCloseButton().click();
        return new ProductPage(driver);
    }


}
