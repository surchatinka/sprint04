import model.HomePage;
import model.NotFoundOrderPage;
import model.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

public class NotFoundOrderPageTest
{
    private WebDriver driver;
    private static final String BROWSER_NAME = "Chrome";


    @Before
    public void startup()
    {
        String browserName = System.getenv("BROWSER_NAME");
        if(browserName==null)
        {
            browserName=BROWSER_NAME;
        }
        driver=new WebDriverFactory().createForName(browserName);
    }

    @Test
    public void notFoundPagePictureTest()
    {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage home = new HomePage(driver);
        home.searchOrder("bla bla bla");
        NotFoundOrderPage notFound = new NotFoundOrderPage(driver);
        notFound.checkImage(true);
    }


    @After
    public void testEnd()
    {
        driver.quit();
    }
}
