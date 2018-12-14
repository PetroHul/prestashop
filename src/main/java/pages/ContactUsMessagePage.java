package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsMessagePage extends ContactUsPage{

    @FindBy(css = ".col-xs-12.alert.alert-success")
    private WebElement alertMessage;

    public ContactUsMessagePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getAlertMessage() {
        return alertMessage;
    }

    public String getMessageText(){
        return getAlertMessage().getText();
    }


}
