import model.HomePage;
import model.NotFoundOrderPage;
import model.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class NotFoundOrderPageTest
{
    private WebDriver driver;
    private static final String BROWSER_NAME = "Chrome";
    private final String orderNumber;
    private final boolean testResult;

    public NotFoundOrderPageTest(String orderNumber, boolean tstResult)
    {
        this.orderNumber=orderNumber;
        this.testResult=tstResult;
    }

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

    @Parameterized.Parameters
    public static Object[][] getParams()
    {
        return new Object[][]
                {
                        {"bla bla bla",true}
                };
    }

    @Test
    public void startTest()
    {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage home = new HomePage(driver);
        home.searchOrder(orderNumber);
        NotFoundOrderPage notFound = new NotFoundOrderPage(driver);
        notFound.checkImage(testResult);
    }


    @After
    public void testEnd()
    {
        driver.quit();
    }
}
