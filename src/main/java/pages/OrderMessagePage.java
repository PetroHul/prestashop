package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderMessagePage extends OrderPage {

    @FindBy(css = ".h1.card-title")
    private WebElement message;


    public OrderMessagePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getMessage() {
        return message;
    }

    public String getMessageText() {
        return getMessage().getText();
    }
}
