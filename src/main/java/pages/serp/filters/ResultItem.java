package pages.serp.filters;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * Created by Alexander on 27.08.2017.
 */
public class ResultItem extends HtmlElement {

    @FindBy(css = ".snippet-card__header-text")
    public Link title;

}
