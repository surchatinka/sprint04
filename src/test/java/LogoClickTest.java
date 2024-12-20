import model.HomePage;
import model.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.LogoLinks.*;

@RunWith(Parameterized.class)
public class LogoClickTest
{
    private WebDriver driver;
    private static final String BROWSER_NAME = "Chrome";
    private final String logoName;
    private final String linkURL;
    private final boolean result;


    public LogoClickTest(String logoName, String linkURL, boolean result)
    {
        this.logoName = logoName;
        this.linkURL = linkURL;
        this.result=result;
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
    public void checkLinks()
    {
        driver.get(SCOOTER_LOGO_LINK);
        HomePage home = new HomePage(driver);
        home.testLogoClickOpensCorrectLink(logoName,linkURL,result);
    }

    @After
    public void end()
    {
        driver.quit();
    }
}
