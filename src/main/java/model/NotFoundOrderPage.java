package model;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotFoundOrderPage {
    private final WebDriver driver;
    private static final By NOT_FOUND_ORDER_IMAGE = By.xpath(".//img[@alt='Not found']");

    public NotFoundOrderPage(WebDriver driver) {
        this.driver=driver;
    }

    public void checkImage(boolean result) {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(NOT_FOUND_ORDER_IMAGE)));
        Assert.assertEquals(result,driver.findElement(NOT_FOUND_ORDER_IMAGE).isDisplayed());
    }
}
