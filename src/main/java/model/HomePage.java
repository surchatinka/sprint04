package model;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.HomePageKeys.*;

public class HomePage
{
    private final WebDriver driver;
    private By makeOrderButton;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    private void scrollToFAQ()
    {
        new WebDriverWait(driver, 10).until(driver->driver.findElement(FAQ_QUESTIONS_LOCATOR).getText() != null);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(FAQ_QUESTIONS_LOCATOR));
    }
    public void scrollToOrderButton(String buttonPlace)
    {
        selectNextButton(buttonPlace);
        new WebDriverWait(driver, 10).until(driver->driver.findElement(makeOrderButton).getText() != null);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(makeOrderButton));
    }

    private void clickQuestion(int questionNumber)
    {
        driver.findElements(FAQ_QUESTIONS_LOCATOR).get(questionNumber).click();
    }

    private boolean isAnswerVisible(int answerNumber)
    {
        return driver.findElements(FAQ_ANSWERS_LOCATOR).get(answerNumber).isDisplayed();
    }
    private String getAnswer(int answerNumber)
    {
        return driver.findElements(FAQ_ANSWERS_LOCATOR).get(answerNumber).getText();
    }
    private String getQuestion(int questionNumber)
    {
        return driver.findElements(FAQ_QUESTIONS_LOCATOR).get(questionNumber).getText();
    }

    public void closeCookiesBar()
    {
        driver.findElement(COOKIES_BAR_BUTTON).click();
    }

    public void orderButtonClick(String buttonPlace)
    {
        selectNextButton(buttonPlace);
        driver.findElement(makeOrderButton).click();
    }
    public void selectNextButton(String buttonPlace)
    {
        switch(buttonPlace)
        {
            case "Header": makeOrderButton=MAKE_ORDER_BUTTON_HEADER; break;
            case "Body": makeOrderButton=MAKE_ORDER_BUTTON_BODY; break;
            default: throw new RuntimeException("Не правильное значение для кнопки Заказать");
        }
    }

    public void faqTextIsRight(String question, String answer, int questionNumber,boolean testStatus)
    {
        closeCookiesBar();
        scrollToFAQ();

        questionNumber--;
        clickQuestion(questionNumber);
        Assert.assertEquals(String.format("Правильность вопроса %d не совпадает",questionNumber),testStatus,getQuestion(questionNumber).equals(question));
        Assert.assertEquals(String.format("Правильность ответа %d не совпадает",questionNumber),testStatus,getAnswer(questionNumber).equals(answer));
    }

    private void logoClick(String logoName)
    {
        switch (logoName)
        {
            case "Yandex": driver.findElement(YANDEX_LOGO).click(); break;
            case "Scooter": driver.findElement(SCOOTER_LOGO).click(); break;
            default: throw new RuntimeException(String.format("Ожидается выбор лого для нажатия, указано неверное значение - %s",logoName));
        }
   }

   public void testLogoClickOpensCorrectLink(String logoName, String link, boolean result)
   {
       logoClick(logoName);
       Object[] windowHandles=driver.getWindowHandles().toArray();
       driver.switchTo().window((String) windowHandles[windowHandles.length-1]);
       Assert.assertEquals(String.format("Открылся не тот сайт - неверная ссылка - %s",driver.getCurrentUrl()),
               result,link.equals(driver.getCurrentUrl()));

   }

   private void orderStatusButtonClick()
   {
       driver.findElement(ORDER_STATUS_HEADER_BUTTON).click();
   }

   private void inputTextToSearchField(String orderNumber)
   {
       driver.findElement(ORDER_INPUT_HEADER_FIELD).sendKeys(orderNumber);
   }
   private void goButtonClick()
   {
       driver.findElement(GO_HEADER_BUTTON).click();
   }

   public void searchOrder(String orderNumber)
   {
       orderStatusButtonClick();
       new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(ORDER_INPUT_HEADER_FIELD)));
       inputTextToSearchField(orderNumber);
       goButtonClick();
   }

}