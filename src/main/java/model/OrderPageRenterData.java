package model;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageRenterData {
    private final WebDriver driver;

    //Страница "Для кого самокат"
    //Поле "* Имя"
    private static final By NAME_FIELD = By.xpath(".//input[contains(@placeholder,'Имя')]");

    //Поле "* Фамилия"
    private static final By SECOND_NAME_FIELD = By.xpath(".//input[contains(@placeholder,'Фамилия')]");

    //Поле "* Адрес: куда привезти самокат"
    private static final By ADDRESS_FIELD = By.xpath((".//input[contains(@placeholder,'Адрес')]"));

    //Поле "* Телефон: на него позвонит курьер"
    private static final By PHONE_NUMBER_FIELD = By.xpath(".//input[contains(@placeholder,'Телефон')]");

    //Поле "* Станция метро"
    private static final By STATION_FIELD = By.className("select-search__input");

    //Элементы саджеста для поля "* Станция метро"
    private static final By STATION_DROPDOWN_LIST_VALUE = By.className("select-search__row");

    //Кнопка Далее
    private static final By NEXT_BUTTON = By.xpath(".//button[text()='Далее']");

    //Дополнительно
    //Ошибка поле Имя
    public static final By NAME_FIELD_ERROR = By.xpath(".//*[contains(@class,'ErrorMessage') and contains(text(),'имя')]");
    //Ошибка поле Фамилия
    public static final By SECOND_NAME_FIELD_ERROR = By.xpath(".//*[contains(@class,'ErrorMessage') and contains(text(),'фамили')]");
    //Ошибка поле Адрес
    public static final By ADDRESS_FIELD_ERROR = By.xpath(".//*[contains(@class,'ErrorMessage') and contains(text(),'адрес')]");
    //Ошибка поле Телефон
    //public static final By PHONE_NUMBER_FIELD_ERROR = By.xpath(".//*[contains(@class,'ErrorMessage') and contains(text(),'номер')]");
    public static final By PHONE_NUMBER_FIELD_ERROR = By.xpath(".//*[contains(text(),'Введите корректный номер')]");


    public OrderPageRenterData(WebDriver driver) {
        this.driver = driver;
    }

    private void inputName(String name) {
        driver.findElement(NAME_FIELD).sendKeys(name);
    }

    private void inputSecondName(String secondName) {
        driver.findElement(SECOND_NAME_FIELD).sendKeys(secondName);
    }

    private void inputAddress(String address) {
        driver.findElement(ADDRESS_FIELD).sendKeys(address);
    }

    private void inputPhoneNumber(String phoneNumber) {
        driver.findElement(PHONE_NUMBER_FIELD).sendKeys(phoneNumber);
    }

    private void inputStation(String stationName) {
        driver.findElement(STATION_FIELD).click();
        driver.findElement(STATION_FIELD).sendKeys(stationName);
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(STATION_DROPDOWN_LIST_VALUE));
        driver.findElement(STATION_DROPDOWN_LIST_VALUE).click();;
    }

    private void buttonNextClick() {
        driver.findElement(NEXT_BUTTON).click();
    }

    public void makeOrder(String name, String secondName, String stationName, String address, String phoneNumber) {

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(NAME_FIELD));
        inputName(name);
        inputSecondName(secondName);
        inputAddress(address);
        inputPhoneNumber(phoneNumber);
        inputStation(stationName);
        buttonNextClick();
    }

    private String getErrorText(String errorField) {
        switch(errorField) {
            case "name": inputName("z"); buttonNextClick(); return driver.findElement(NAME_FIELD_ERROR).getText();
            case "surname": inputSecondName("z"); buttonNextClick(); return driver.findElement(SECOND_NAME_FIELD_ERROR).getText();
            case "phone":  inputPhoneNumber("z"); buttonNextClick(); return driver.findElement(PHONE_NUMBER_FIELD_ERROR).getText();
            case "address": inputAddress("z"); buttonNextClick(); return driver.findElement(ADDRESS_FIELD_ERROR).getText();
            default: throw new RuntimeException(String.format("У поля %s нет текста ошибки",errorField));
        }
    }

    public void checkErrorText(String errorFieldText, String fieldName) {

        String errorText = getErrorText(fieldName);
        Assert.assertEquals(errorFieldText,errorText);
    }
}
