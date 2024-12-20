package constants;

import org.openqa.selenium.By;

public class OrderPageKeys
{
    //Страница "Для кого самокат"
    //Поле "* Имя"
    public static final By NAME_FIELD = By.xpath(".//input[contains(@placeholder,'Имя')]");

    //Поле "* Фамилия"
    public static final By SECOND_NAME_FIELD = By.xpath(".//input[contains(@placeholder,'Фамилия')]");

    //Поле "* Адрес: куда привезти самокат"
    public static final By ADDRESS_FIELD = By.xpath((".//input[contains(@placeholder,'Адрес')]"));

    //Поле "* Телефон: на него позвонит курьер"
    public static final By PHONE_NUMBER_FIELD = By.xpath(".//input[contains(@placeholder,'Телефон')]");

    //Поле "* Станция метро"
    public static final By STATION_FIELD = By.className("select-search__input");

    //Элементы саджеста для поля "* Станция метро"
    public static final By STATION_DROPDOWN_LIST_VALUE = By.className("select-search__row");

    //Кнопка Далее
    public static final By NEXT_BUTTON = By.xpath(".//button[text()='Далее']");

    //Страница "Про аренду"
    //Поле "*Когда привезти самокат"
    public static final By DATE_FIELD = By.xpath(".//input[contains(@placeholder,'Когда привезти самокат')]");

    //Поле "Срок аренды"
    public static final By RENT_TIME_FIELD = By.xpath(".//*[contains(text(),'Срок аренды')]/parent::div");

    //Элементы саджеста для поля "Срок аренды"
    public static final By RENT_TIME_DROPDOWN_LIST_VALUE = By.className("Dropdown-option");

    //Кнопка Заказать в форме заказа
    public static final By MAKE_ORDER_FORM_BUTTON = By.xpath(".//*[contains(@class,'Order_Buttons')]/button[contains(text(),'Заказать')]");

    //Заголовок окна успешного  созадния заказа
    public static final By SUCCESS_MADE_ORDER_WINDOW_HEADER = By.xpath(".//div[contains(text(),'Заказ оформлен')]/parent::div");

    //Кнопка Да в окне "Хотите оформить заказ"
    public static final By YES_BUTTON = By.xpath(".//*[contains(@class,'Button_Middle') and contains(text(),'Да')]");

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
}
