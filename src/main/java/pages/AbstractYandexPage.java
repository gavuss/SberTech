package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.function.Function;

import static utils.BaseTest.WEBDRIVER_TIMEOUT;

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


    public void waitUntilIsDisplayed(Function<WebDriver, Boolean>... conditions) {

        Wait<WebDriver> wait = new WebDriverWait(driver, WEBDRIVER_TIMEOUT);

//        wait.until(new Function<WebDriver, Boolean>() {
//            @Override
//            public Boolean apply(WebDriver webDriver) {
//                return isLoaded();
//            }
//        });
        wait.until(driver -> isLoaded()); //

        for (Function<WebDriver, Boolean> condition : conditions) {
            wait.until(booleanSupplier -> condition.apply(driver));
        }

    }

    public boolean isLoaded() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return "complete".equals(jsExecutor.executeScript("return document.readyState")) && logo().isDisplayed();
    }

    abstract public WebElement logo();
}
