package pages.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractYandexPage;
import pages.elements.Menu;

import java.util.function.Function;

/**
 * Created by Alexander Silaev on 23.08.2017.
 */
//div.home-arrow
public class YandexPage extends AbstractYandexPage {

    public YandexPage(WebDriver driver) {
        super(driver, "https://yandex.ru");
    }

    @FindBy(css = "div.home-arrow")
    public Menu tabs;

    @Override
    public YandexPage open(Function<WebDriver, Boolean>... conditions) {
        super.open();
        return this;
    }

    @Override
    public YandexPage openByUrl(String url, Function<WebDriver, Boolean>... conditions) {
        super.openByUrl(url);
        return this;
    }

    @Override
    public boolean isLoaded() {
        return super.isLoaded() && getDriver().findElement(By.cssSelector(".home-logo__custom:nth-child(1)")).isDisplayed();
    }
}

