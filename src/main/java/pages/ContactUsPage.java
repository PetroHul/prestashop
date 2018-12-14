package pages;

import data.Subject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactUsPage extends AHeadComponent {

    @FindBy(css = ".page-header > h1")
    private WebElement heading;

    @FindBy(css = ".form-control.form-control-select")
    private List<WebElement> subject;

    @FindBy(css = ".form-control[name='from']")
    private WebElement email;

    @FindBy(css = ".form-control[name='message']")
    private WebElement message;

    @FindBy(css = "[name='submitMessage']")
    private WebElement saveButton;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getHeading() {
        return heading.getText().trim();
    }

    public List<WebElement> getSubject() {
        return subject;
    }

    public void setSubjecte(Subject subjecte) {
        switch (subjecte) {
            case CustomerServise:
                this.subject.get(0).click();
                break;
            case Webmaster:
                this.subject.get(1).click();
                break;
        }
    }

    public WebElement getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email.click();
        this.email.clear();
        this.email.sendKeys(email);
    }

    public WebElement getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message.click();
        this.message.clear();
        this.message.sendKeys(message);
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public ContactUsMessagePage clickSaveButton() {
        this.saveButton.click();
        return new ContactUsMessagePage(driver);
    }




}
