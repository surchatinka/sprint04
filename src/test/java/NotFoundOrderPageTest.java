import model.HomePage;
import model.NotFoundOrderPage;
import model.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

public class NotFoundOrderPageTest extends BaseTest{
    @Test
    public void notFoundPagePictureTest() {
        super.startBrowser();
        HomePage home = new HomePage(driver);
        home.searchOrder("bla bla bla");
        NotFoundOrderPage notFound = new NotFoundOrderPage(driver);
        notFound.checkImage(true);
    }
}
