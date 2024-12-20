import model.HomePage;
import model.WebDriverFactory;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import static constants.FAQ.*;

@RunWith(Parameterized.class)
public class HomePageTest {

   private WebDriver driver;
   private static final String BROWSER_NAME = "Chrome";
   private final String question;
   private final String answer;
   private final int numberQuestion;
   private final boolean testStatus;


   public HomePageTest(String question,String answer,int numberQuestion,boolean testStatus)
   {
       this.question=question;
       this.answer=answer;
       this.numberQuestion=numberQuestion;
       this.testStatus=testStatus;
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
    public static Object[][] getFaqText()
    {
        return new Object[][]
                {
                        {"question1","answer1",1,false},
                        {FAQ_QUESTION_NUMBER[0], FAQ_ANSWERS_NUMBER[0],1,true},
                        {FAQ_QUESTION_NUMBER[7],FAQ_ANSWERS_NUMBER[7],8,true}
                };
    }

   @Test
    public void checkFAQIsOpen()
    {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage defaultPage = new HomePage(driver);
        defaultPage.faqTextIsRight(question,answer,numberQuestion,testStatus);
    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }
}
