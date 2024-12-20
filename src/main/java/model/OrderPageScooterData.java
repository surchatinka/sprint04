package model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static constants.OrderPageKeys.*;

public class OrderPageScooterData
{
    private final WebDriver driver;

    By rentTimeDropdownOption;

    public OrderPageScooterData(WebDriver driver)
    {
        this.driver=driver;
    }

    private void inputDate(String date)
    {
        driver.findElement(DATE_FIELD).sendKeys(date);
        driver.findElement(DATE_FIELD).sendKeys(Keys.ENTER);
    }

    private void selectRentTime(int numberOfDays)
    {
        if (numberOfDays>0 && numberOfDays<=7)
        {
            driver.findElement(RENT_TIME_FIELD).click();
            numberOfDays--;
            new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(RENT_TIME_DROPDOWN_LIST_VALUE));
            driver.findElements(RENT_TIME_DROPDOWN_LIST_VALUE).get(numberOfDays).click();
        }

        else
        {
           throw new RuntimeException("Нельзя забронировать самокат на срок " + numberOfDays);
        }
    }

    private void makeOrderButtonClick()
    {
        driver.findElement(MAKE_ORDER_FORM_BUTTON).click();
    }

    public void makeOrder(String date, int numberOfDays)
    {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(DATE_FIELD));
        inputDate(date);
        selectRentTime(numberOfDays);
        makeOrderButtonClick();
    }
}
