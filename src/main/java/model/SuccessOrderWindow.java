package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static constants.OrderPageKeys.SUCCESS_MADE_ORDER_WINDOW_HEADER;
import static constants.OrderPageKeys.YES_BUTTON;

public class SuccessOrderWindow
{
    private final WebDriver driver;
    public SuccessOrderWindow(WebDriver driver)
    {
        this.driver=driver;
    }

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
