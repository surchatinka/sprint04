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
public class LogoClickTest
{
    private WebDriver driver;
    private static final String BROWSER_NAME = "Chrome";
    private final String logoName;
    private final boolean result;
    private final String linkName;


    public LogoClickTest(String logoName,String linkName, boolean result)
    {
        this.logoName = logoName;
        this.result=result;
        this.linkName=linkName;
    }
    @Before
    public void before()
    {
        String browserName = System.getenv("BROWSER_NAME");
        if(browserName==null)
        {
            browserName=BROWSER_NAME;
        }
        driver=new WebDriverFactory().createForName(browserName);
    }

    @Parameterized.Parameters
    public static Object[][] getTestData()
    {
        return new Object[][]
                {
                        {"Yandex",YANDEX_LOGO_LINK,true},
                        {"Scooter",SCOOTER_LOGO_LINK,true}
                };
    }

    @Test
    public void checkLinksTest()
    {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage home = new HomePage(driver);
        home.testLogoClickOpensCorrectLink(logoName,linkName,result);
    }

    @After
    public void end()
    {
        driver.quit();
    }
}
