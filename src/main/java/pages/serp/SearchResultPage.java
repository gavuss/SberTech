package pages.serp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.AbstractYandexPage;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 * Created by Alexander on 27.08.2017.
 */
public class SearchResultPage extends AbstractYandexPage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".n-title__text")
    public TextBlock header;

}
