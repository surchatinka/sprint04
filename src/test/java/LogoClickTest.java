import model.HomePage;
import model.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import static constants.LogoLinks.*;

@RunWith(Parameterized.class)
public class LogoClickTest extends BaseTest{
    private final String logoName;
    private final boolean result;
    private final String linkName;

    public LogoClickTest(String logoName,String linkName, boolean result) {
        this.logoName = logoName;
        this.result=result;
        this.linkName=linkName;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                        {"Yandex",YANDEX_LOGO_LINK,true},
                        {"Scooter",SCOOTER_LOGO_LINK,true}
                };
    }

    @Test
    public void checkLinksTest() {
        WebDriver driver = super.startBrowser();
        HomePage home = new HomePage(driver);
        home.testLogoClickOpensCorrectLink(logoName,linkName,result);
    }
}
