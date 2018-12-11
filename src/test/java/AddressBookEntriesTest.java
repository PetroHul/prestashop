import data.UserRepository;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import tools.TestRunner;

public class AddressBookEntriesTest extends TestRunner {
    @Test
    public void addAddressTest() {
        //arrenge
        loadAplication(UserRepository.get().localUser());
    }
}
