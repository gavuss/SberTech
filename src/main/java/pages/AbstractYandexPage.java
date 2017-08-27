package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.elements.SearchBlock;
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

    @FindAll({@FindBy(css = ".header2__search")})
    private SearchBlock searchBlock;

    @FindAll({
            @FindBy(css = ".home-logo"), //стартовая страница
            @FindBy(css = ".header2__logo")}) //страница Маркет
    private WebElement logo;

    public AbstractYandexPage(WebDriver driver, String url) {
        this(driver);
        this.url = url;
    }

    public void search(String value) {
        searchBlock.search(value);
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

    public AbstractYandexPage open(Function<WebDriver, Boolean>... conditions) {
        return openByUrl(url, conditions);
    }

    @Step("Открыть страницу по ссылке \"{0}\"")
    public AbstractYandexPage openByUrl(String url, Function<WebDriver, Boolean>... conditions) {
        if (url == null) {
            throw new IllegalArgumentException("Url не может быть null");
        }
        driver.get(url);
        waitUntilIsDisplayed(conditions);
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
        wait.until(driver -> isLoaded());

        for (Function<WebDriver, Boolean> condition : conditions) {
            wait.until(booleanSupplier -> condition.apply(driver));
        }

    }

    public boolean isLoaded() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return "complete".equals(jsExecutor.executeScript("return document.readyState")) &&
                logo.isDisplayed();
    }
}
