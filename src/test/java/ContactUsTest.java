import data.Subject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsMessagePage;
import pages.ContactUsPage;
import pages.HomePage;
import tools.TestRunner;

public class ContactUsTest extends TestRunner {

    @Test
    public void contactUs() {

        //Arrange
        HomePage homePage = loadApplication();
        final String expected = "Your message has been successfully sent to our team.";
        final String actual;

        //Act
        homePage.clickContactUsButton();
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.setSubjecte(Subject.CustomerServise);
        contactUsPage.setEmail("sdh@gm.com");
        contactUsPage.setMessage("I want to say thank you!");
        contactUsPage.clickSaveButton();
        ContactUsMessagePage alertPage = new ContactUsMessagePage(driver);
        actual = alertPage.getMessageText();

        //Assert
        Assert.assertEquals(actual, expected);
    }
}
