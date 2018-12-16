package pages;

import data.SocialTitle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateUserAdminPage extends AMenuAdminComponent {

    @FindBy(css = "input[name='id_gender']")
    private List<WebElement> socialTitle;

    @FindBy(css = "input[name='firstname']")
    private WebElement firstName;

    @FindBy(css = "input[name='lastname']")
    private WebElement lastName;

    @FindBy(css = "#email")
    private WebElement email;

    @FindBy(css = "#passwd")
    private WebElement password;

    @FindBy(css = "#customer_form_submit_btn")
    private WebElement saveButton;

    public CreateUserAdminPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getSocialTitle() {
        return socialTitle;
    }

    public void setSocialTitle(SocialTitle socialTitle) {
        switch (socialTitle) {
            case MR:
                this.socialTitle.get(0).click();
                break;
            case MRS:
                this.socialTitle.get(1).click();
                break;
        }

    }

    public WebElement getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.click();
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
    }

    public WebElement getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.click();
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public WebElement getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email.click();
        this.email.clear();
        this.email.sendKeys(email);
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password.click();
        this.password.clear();
        this.password.sendKeys(password);
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public void clickSaveButton() {
        this.saveButton.click();
    }
}
