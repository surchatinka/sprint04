import model.HomePage;
import model.OrderPageRenterData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import static constants.ErrorTextsOrderPage.*;

@RunWith(Parameterized.class)
public class OrderPageErrorsTextTest extends BaseTest {
    private final String errorText;
    private final String errorFieldTag;

    public OrderPageErrorsTextTest(String errorText, String errorFieldTag) {
        this.errorText = errorText;
        this.errorFieldTag=errorFieldTag;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]
                {
                        {NAME_FIELD_ERROR_TEXT, "name"},
                        {SECOND_NAME_FIELD_ERROR_TEXT,"surname"},
                        {ADDRESS_FIELD_ERROR_TEXT,"address"},
                        {PHONE_NUMBER_FIELD_ERROR_TEXT,"phone"}
                };
    }

    @Test
    public void checkErrorsTextsTest() {

        super.startBrowser();
        HomePage home = new HomePage(driver);
        home.orderButtonClick("Header");
        OrderPageRenterData order = new OrderPageRenterData(driver);
        order.checkErrorText(errorText,errorFieldTag);
    }
}
