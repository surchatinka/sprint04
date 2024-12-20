import model.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class OrderSequenceTest
{

    private static final String BROWSER_NAME = "Chrome";
    //Для запуска из другого браузера поменять BROWSER_NAME в Environment Variables
    private final String name;
    private final String secondName;
    private final String stationName;
    private final String address;
    private final String phoneNumber;
    private final String date;
    private final int numberOfDays;
    private final String button;
    private final boolean testResult;

    private WebDriver driver;

    public OrderSequenceTest(String name, String secondName, String stationName, String address, String phoneNumber, String date, int numberOfDays,String button,boolean testResult)
    {
        this.name = name;
        this.secondName = secondName;
        this.stationName = stationName;
        this.phoneNumber=phoneNumber;
        this.address = address;
        this.date=date;
        this.numberOfDays = numberOfDays;
        this.button=button;
        this.testResult=testResult;
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
    public static Object[][] getOrderData()
    {
        return new Object[][]
                {
                        {"Иван","Иванов", "Спортивная","Елка, д. 5","12345678901","21.01.2025",7,"Header",true},
                        {"Петр","Петров", "Лесопарковая","Кукуево, д. 7","12345678901","21.01.2025",1,"Body",true}
                };
    }

    @Test
    public void checkMakeOrderSequence()
    {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage home = new HomePage(driver);
        home.closeCookiesBar();
        home.scrollToOrderButton(button);
        home.orderButtonClick(button);
        OrderPageRenterData order = new OrderPageRenterData(driver);
        order.makeOrder(name,secondName,stationName,address,phoneNumber);
        OrderPageScooterData scooter = new OrderPageScooterData(driver);
        scooter.makeOrder(date,numberOfDays);
        SuccessOrderWindow success = new SuccessOrderWindow(driver);
        success.yesButtonClick();
        success.waitForLoad();
        Assert.assertEquals("Ошибка при открытии окна успешного создания заказа",testResult,success.isSuccessOrderWindowVisible());
        //Assert.assertTrue("",success.isSuccessOrderWindowVisible());
    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }
}