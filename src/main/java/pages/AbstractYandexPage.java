package pages;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by Alexander Silaev on 23.08.2017.
 */
public abstract class AbstractYandexPage {

    private WebDriver driver;
    private String url;

    public AbstractYandexPage(WebDriver driver, String url) {
        this(driver);
        this.url = url;
    }

    public AbstractYandexPage(WebDriver driver) {
        this.driver = driver;
        HtmlElementLoader.populate(this, driver);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public AbstractYandexPage open() {
        return openByUrl(url);
    }

    @Step("Открыть страницу по ссылке \"{0}\"")
    public AbstractYandexPage openByUrl(String url) {
        if (url == null) {
            throw new IllegalArgumentException("Url не может быть null");
        }
        driver.get(url);
        return this;
    }
}
