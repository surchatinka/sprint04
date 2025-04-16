package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class WebDriverFactory {
    public WebDriver createForName(String browserName) {
        if(browserName.equals("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            return new ChromeDriver(options);
        }
        else if(browserName.equals("Firefox")) {
            FirefoxDriver a = new FirefoxDriver();
            a.manage().window().maximize();
            return a;
        }
        else {
            throw new RuntimeException("Нераспознаный браузер"+browserName);
        }
    }
}
