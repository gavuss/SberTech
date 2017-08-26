package pages.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractYandexPage;
import pages.elements.Menu;

/**
 * Created by Alexander Silaev on 23.08.2017.
 */
//div.home-arrow
public class YandexPage extends AbstractYandexPage {

    @Override
    public WebElement logo() {
        return getDriver().findElement(By.cssSelector(".home-logo"));
    }

    public YandexPage(WebDriver driver) {
        super(driver, "https://yandex.ru");
    }

    @FindBy(css = "div.home-arrow")
    public Menu tabs;

    @Override
    public YandexPage open() {
        super.open();
        return this;
    }

    @Override
    public YandexPage openByUrl(String url) {
        super.openByUrl(url);
        return this;
    }


}

