import model.HomePage;
import model.OrderPageRenterData;
import model.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import static constants.ErrorTextsOrderPage.*;

@RunWith(Parameterized.class)
public class OrderPageErrorsTextTest
{
    @Before
    public void start()
    {
        String browserName = System.getenv("BROWSER_NAME");
        if(browserName==null)
        {
            browserName=BROWSER_NAME;
        }
        driver=new WebDriverFactory().createForName(browserName);
    }

    private static final String BROWSER_NAME = "Chrome";
    private WebDriver driver;
    private final String errorText;
    private final String errorFieldTag;

    public OrderPageErrorsTextTest(String errorText, String errorFieldTag)
    {
        this.errorText = errorText;
        this.errorFieldTag=errorFieldTag;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData()
    {
        return new Object[][]
                {
                        {NAME_FIELD_ERROR_TEXT, "name"},
                        {SECOND_NAME_FIELD_ERROR_TEXT,"surname"},
                        {ADDRESS_FIELD_ERROR_TEXT,"address"},
                        {PHONE_NUMBER_FIELD_ERROR_TEXT,"phone"}
                };
    }

    @Test
    public void checkErrorsTextsTest()
    {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage home = new HomePage(driver);
        home.orderButtonClick("Header");
        OrderPageRenterData order = new OrderPageRenterData(driver);
        order.checkErrorText(errorText,errorFieldTag);
    }

    @After
    public void shutdown()
    {
        driver.quit();
    }
}
