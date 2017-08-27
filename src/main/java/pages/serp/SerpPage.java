package pages.serp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractYandexPage;
import pages.serp.filters.ResultItem;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.List;

/**
 * Created by Alexander Silaev on 23.08.2017.
 */
public class SerpPage extends AbstractYandexPage {

    public SerpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".n-snippet-card")
    public List<ResultItem> searchResults;

    @FindBy(css = "button.button_action_n-filter-apply")
    public Button applyFilters;

    public <T extends HtmlElement> T getSearchFilter(Class<T> filterType, String name) {
        WebElement wrappedElement = getDriver()
                .findElement(By.xpath("//span[.='" + name.replace(", ", ",\u00A0") + "']/../../.."));
        return HtmlElementLoader.createHtmlElement(filterType, wrappedElement, "фильтр '" + name + "'");
    }

    public SerpPage applyFilters() {
        applyFilters.click();
        SerpPage serpPage = new SerpPage(getDriver());
        serpPage.waitUntilIsDisplayed();
        return serpPage;
    }

}
