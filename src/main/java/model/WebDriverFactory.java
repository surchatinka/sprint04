package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory
{
    public WebDriver createForName(String browserName)
    {
        if(browserName.equals("Chrome"))
        {
            return new ChromeDriver();
        }
        else if(browserName.equals("Firefox"))
        {
            return new FirefoxDriver();
        }
        else
        {
            throw new RuntimeException("Нераспознаный браузер"+browserName);
        }
    }
}
