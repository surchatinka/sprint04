package model;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static constants.OrderPageKeys.*;

public class OrderPageRenterData
{
    private final WebDriver driver;

    public OrderPageRenterData(WebDriver driver)
    {
        this.driver = driver;
    }

    private void inputName(String name)
    {

        driver.findElement(NAME_FIELD).sendKeys(name);
    }

    private void inputSecondName(String secondName)
    {

        driver.findElement(SECOND_NAME_FIELD).sendKeys(secondName);
    }

    private void inputAddress(String address)
    {

        driver.findElement(ADDRESS_FIELD).sendKeys(address);
    }

    private void inputPhoneNumber(String phoneNumber)
    {
        driver.findElement(PHONE_NUMBER_FIELD).sendKeys(phoneNumber);
    }


    private void inputStation(String stationName)
    {
        driver.findElement(STATION_FIELD).click();
        driver.findElement(STATION_FIELD).sendKeys(stationName);
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(STATION_DROPDOWN_LIST_VALUE));
        driver.findElement(STATION_DROPDOWN_LIST_VALUE).click();;
    }
    private void buttonNextClick()
    {
        driver.findElement(NEXT_BUTTON).click();
    }

    public void makeOrder(String name, String secondName, String stationName, String address, String phoneNumber)
    {

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(NAME_FIELD));
        inputName(name);
        inputSecondName(secondName);
        inputAddress(address);
        inputPhoneNumber(phoneNumber);
        inputStation(stationName);
        buttonNextClick();
    }
    private String getErrorText(String errorField)
    {
        switch(errorField)
        {
            case "name": return driver.findElement(NAME_FIELD_ERROR).getText();
            case "surname": return driver.findElement(SECOND_NAME_FIELD_ERROR).getText();
            case "phone": return driver.findElement(PHONE_NUMBER_FIELD_ERROR).getText();
            case "address": return driver.findElement(ADDRESS_FIELD_ERROR).getText();
            default: throw new RuntimeException(String.format("У поля %s нет текста ошибки",errorField));
        }
    }

    public void checkAllErrors(String name,String secondName,String address, String phone)
    {
        inputName("w");
        inputSecondName("w");
        inputAddress("w");
        inputPhoneNumber("w");
        buttonNextClick();

        Assert.assertEquals(name,getErrorText("name"));
        Assert.assertEquals(secondName,getErrorText("surname"));
        Assert.assertEquals(phone,getErrorText("phone"));
        Assert.assertEquals(address,getErrorText("address"));}
}
