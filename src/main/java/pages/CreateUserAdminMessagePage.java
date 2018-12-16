package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUserAdminMessagePage extends CreateUserAdminPage {
    @FindBy(xpath = "//*[@id='content']/div[3]/div")
    private WebElement alertMessage;

    public CreateUserAdminMessagePage(WebDriver driver){
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

