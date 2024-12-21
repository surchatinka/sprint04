package model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageScooterData
{
    private final WebDriver driver;

    //Страница "Про аренду"
    //Поле "*Когда привезти самокат"
    private static final By DATE_FIELD = By.xpath(".//input[contains(@placeholder,'Когда привезти самокат')]");

    //Поле "Срок аренды"
    private static final By RENT_TIME_FIELD = By.xpath(".//*[contains(text(),'Срок аренды')]/parent::div");

    //Элементы саджеста для поля "Срок аренды"
    private static final By RENT_TIME_DROPDOWN_LIST_VALUE = By.className("Dropdown-option");

    //Кнопка Заказать в форме заказа
    private static final By MAKE_ORDER_FORM_BUTTON = By.xpath(".//*[contains(@class,'Order_Buttons')]/button[contains(text(),'Заказать')]");



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
