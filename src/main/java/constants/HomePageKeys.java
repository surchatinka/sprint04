package constants;

import org.openqa.selenium.By;

public class HomePageKeys
{
    //Вопросы о важном
    //Кнопки вопросов FAQ
    public static final By FAQ_QUESTIONS_LOCATOR = By.className("accordion__button");
    //Тексты ответов FAQ
    public static final By FAQ_ANSWERS_LOCATOR = By.xpath(".//*[@class='accordion__panel']/p");
    //Кнопка закрытия окна куки "Да все привыкли"
    public static final By COOKIES_BAR_BUTTON = By.id("rcc-confirm-button");
    //Кнопка Заказать в шапке страницы
    public static final By MAKE_ORDER_BUTTON_HEADER = By.xpath(".//*[contains(@class,'Header')]/button[contains(text(),'Заказать')]");
    //Кнопка заказать на главной странице лендинга
    public static final By MAKE_ORDER_BUTTON_BODY = By.xpath(".//*[contains(@class,'Button_Middle') and contains(text(),'Заказать')]");

    //Дополнительные
    //Логотип Самоката
    public static final By SCOOTER_LOGO = By.xpath(".//img[@alt='Scooter']");
    //Логотип Яндекса
    public static final By YANDEX_LOGO = By.xpath(".//img[@alt='Yandex']");
    //Кнопка Статус заказа
    public static final By ORDER_STATUS_HEADER_BUTTON = By.xpath(".//button[text()='Статус заказа']");
    //Кнопка Go!
    public static final By GO_HEADER_BUTTON = By.xpath(".//button[text()='Go!']");
    //Поле Введите статус заказа в заголовке
    public static final By ORDER_INPUT_HEADER_FIELD = By.xpath(".//input[contains(@placeholder,'номер заказа')]");
}
