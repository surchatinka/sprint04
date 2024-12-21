package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessOrderWindow
{
    private final WebDriver driver;
    public SuccessOrderWindow(WebDriver driver)
    {
        this.driver=driver;
    }

    //Заголовок окна успешного  созадния заказа
    private static final By SUCCESS_MADE_ORDER_WINDOW_HEADER = By.xpath(".//div[contains(text(),'Заказ оформлен')]/parent::div");

    //Кнопка Да в окне "Хотите оформить заказ"
    private static final By YES_BUTTON = By.xpath(".//*[contains(@class,'Button_Middle') and contains(text(),'Да')]");

    public void yesButtonClick()
    {
        driver.findElement(YES_BUTTON).click();
    }
    public void waitForLoad()
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(SUCCESS_MADE_ORDER_WINDOW_HEADER));        //driver.findElements(successMakeOrderWindow)
    }

    public boolean isSuccessOrderWindowVisible()
    {
        return driver.findElement(SUCCESS_MADE_ORDER_WINDOW_HEADER).isDisplayed();
    }
}
