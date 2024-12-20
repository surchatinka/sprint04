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
import static constants.LogoLinks.SCOOTER_LOGO_LINK;

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
    private final String errorNameText;
    private final String errorSecondNameText;
    private final String errorAddressText;
    private final String errorPhoneNumberText;

    public OrderPageErrorsTextTest(String errorName, String errorSecondName, String errorAddressText, String errorPhoneNumberText)
    {
        this.errorNameText = errorName;
        this.errorSecondNameText = errorSecondName;
        this.errorAddressText = errorAddressText;
        this.errorPhoneNumberText = errorPhoneNumberText;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData()
    {
        return new Object[][]
                {
                        {NAME_FIELD_ERROR_TEXT,SECOND_NAME_FIELD_ERROR_TEXT,ADDRESS_FIELD_ERROR_TEXT,PHONE_NUMBER_FIELD_ERROR_TEXT}
                };
    }

    @Test
    public void checkErrorsText()
    {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage home = new HomePage(driver);
        home.orderButtonClick("Header");
        OrderPageRenterData order = new OrderPageRenterData(driver);
        order.checkAllErrors(errorNameText,errorSecondNameText,errorAddressText,errorPhoneNumberText);
    }

    @After
    public void shutdown()
    {
        driver.quit();
    }
}
