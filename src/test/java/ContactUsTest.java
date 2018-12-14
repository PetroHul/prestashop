import data.Subject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsMessagePage;
import pages.ContactUsPage;
import pages.HomePage;
import tools.TestRunner;

public class ContactUsTest extends TestRunner {

    @Test
    public void contactUs(){
        //Arrange
        HomePage homePage = loadApplication();
        ContactUsPage contactUsPage=new ContactUsPage(driver);
        //ContactUsMessagePage resultPage;
        ContactUsMessagePage actual=new ContactUsMessagePage(driver);

        //Actual
        homePage.clickContactUsButton();
        contactUsPage.setSubjecte(Subject.CustomerServise);
        contactUsPage.setEmail("sdh@gm.com");
        contactUsPage.setMessage("I want to say thank you!");
        contactUsPage.clickSaveButton();
//        actual.getMessageText();
        Assert.assertTrue(actual.getMessageText().equals("Your message has been successfully sent to our team."));




    }
}
