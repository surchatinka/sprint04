import model.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver driver;
    private static final String BROWSER_NAME = "Chrome";

    @Before
    public void before() throws Exception {
        String browserName = System.getenv("BROWSER_NAME");
        if(browserName==null) {
            browserName=BROWSER_NAME;
        }
        driver=new WebDriverFactory().createForName(browserName);
    }

    protected void startBrowser() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
